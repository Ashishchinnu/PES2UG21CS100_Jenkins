pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
                echo 'Build stage successful'
            }
        }
        
        stage('Test') {
            steps {
                script {
                    // Print output of .cpp file using a shell script
                    sh 'mvn test'
                    echo 'Test stage successful'
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    // Perform deployment tasks, if any
                    sh 'mvn deploy'
                    echo 'Deployment Successful'
                    post{
                        always{
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
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