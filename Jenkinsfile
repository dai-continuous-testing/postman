pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build Server') {
          steps {
            sleep 3
          }
        }
        stage('Build Android App') {
          steps {
            sleep 3
          }
        }
        stage('Build iOS App') {
          steps {
            sleep 3
          }
        }
      }
    }
    stage('Deploy (QA)') {
      parallel {
        stage('Deploy Server') {
          steps {
            sleep 5
          }
        }
        stage('Upload Mobile Apps') {
          steps {
            sleep 3
          }
        }
      }
    }
    stage('Run postman') {
      steps {
        sh 'newman run collectionYodlee.json -e environmentYodlee.json'
        powershell 'copy c:\\Users\\guyari\\Desktop\\postman\\environmentYodlee.json .'
      }
    }
  }
}