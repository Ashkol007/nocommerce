pipeline {
  agent any

  tools {
    jdk 'jdk-17'                // Match your configured JDK name
    maven 'maven-3.9.6'         // Match your configured Maven name
  }

  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/your-org/your-repo.git', branch: 'main'
      }
    }

    stage('Build & Test') {
      steps {
        bat 'mvn clean test'
      }
    }

    stage('Publish Report') {
      steps {
        publishHTML([
          reportDir: 'target/cucumber-html-report',
          reportFiles: 'index.html',
          reportName: 'BDD HTML Report'
        ])
      }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts 'target/**/*.log'
    }
  }
}
