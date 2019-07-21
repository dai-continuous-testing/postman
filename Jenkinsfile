pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build Server') {
          steps {
            sleep 10
          }
        }
        stage('Build Android App') {
          steps {
            sleep 10
          }
        }
        stage('Build iOS App') {
          steps {
            sleep 7
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
            sleep 10
          }
        }
      }
    }
    stage('Run postman') {
      steps {
        sh '''copy c:\\Users\\guyari\\Desktop\\postman\\environmentYodlee.json .
newman run collectionYodlee.json -e environmentYodlee.json'''
      }
    }
  }
}