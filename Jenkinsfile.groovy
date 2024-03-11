// pipeline {
//     agent any
    
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'mvn clean install'
//                 echo 'Build stage successful'
//             }
//         }
        
//         stage('Test') {
//             steps {
//                 script {
//                     // Print output of .cpp file using a shell script
//                     sh 'mvn test'
//                     echo 'Test stage successful'
//                 }
//             }
//         }
        
//         stage('Deploy') {
//             steps {
//                 script {
//                     // Perform deployment tasks, if any
//                     sh 'mvn deploy'
//                     echo 'Deployment Successful'
//                     post{
//                         always{
//                             junit 'target/surefire-reports/*.xml'
//                         }
//                     }
//                 }
//             }
//         }
//     }
    
//     post {
//         failure {
//             echo 'Pipeline failed'
//         }
//     }
// }
pipeline{
agent {

docker {

image 'node:14'
}
}
stages {
stage('clone repository') {
steps{
git branch: 'main',

url: 'https://github.com/Ashishchinnu/PES2UG21CS100_Jenkins'
}}
stage('Install dependencies') {
steps {
sh 'npm install'
}}
stage('Build application') {
steps {
sh 'npm run build'
}}
stage('Test application') {
steps {
sh 'npm test'
}}
stage('Push Docker image') {
steps {
sh 'docker build t Ashishchinnu/<image>:SBUILD NUMBER'
sh 'docker push Ashishchinnu/<image>:SBUILD NUMBER'
}}}}