pipeline {
  agent any

  tools {
    jdk 'MyJava'                // Match your configured JDK name
    maven 'MyMaven'         // Match your configured Maven name
  }

  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/Ashkol007/nocommerce.git', branch: 'master'
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
    publishHTML([
      reportDir: 'target/cucumber-html-report',
      reportFiles: 'index.html',
      reportName: 'Cucumber HTML Report'
    ])
  }
}

