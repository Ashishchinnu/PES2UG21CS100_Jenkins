pipeline{
    agent any
    stages {
        
      stage('Build') {
          steps {
              script {
                  
            build 'PES2UG21CS099-1'
            sh 'g++ main.cpp -o output'
          }
          }
      }
      stage('Test') {
          steps {
              script {
              sh './output'
              }
          }
      }

      stage('Deploy') {
          steps {
              script{
              echho 'deploy'
              }
          }
      }
    }
    post {
        failure {
            error 'Pipeline failed'
        }
    }
}
