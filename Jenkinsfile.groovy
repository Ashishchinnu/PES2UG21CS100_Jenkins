pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Compile the .cpp file using a shell script
                    sh 'g++ -o output_file hello.cpp'
                }
            }
        }
        
        stage('Test') {
            steps {
                script {
                    // Print output of .cpp file using a shell script
                    sh './output_file'
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    // Perform deployment tasks, if any
                    sh 'mvn deploy'
                    echo 'Deployment Successful'
                }
            }
        }
    }
    
    post {
        failure {
            echo 'Pipeline failed'
        }
    }
}