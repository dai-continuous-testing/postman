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
      parallel {
        stage('Run postman') {
          steps {
            powershell 'copy c:\\Users\\guyar\\Desktop\\postman\\environmentYodlee.json .'
            powershell 'newman run collectionYodlee.json -e environmentYodlee.json'
          }
        }
        stage('Appium') {
          steps {
            sleep 4
          }
        }
      }
    }
  }
}