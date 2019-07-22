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
            sleep 1
          }
        }
        stage('Upload Mobile Apps') {
          steps {
            sleep 1
          }
        }
      }
    }
    stage('Run Tests') {
      parallel {
        stage('Run postman') {
          steps {
            powershell 'copy c:\\Users\\guyar\\Desktop\\postman\\environmentYodlee.json .'
            powershell 'newman run collectionYodlee.json -e environmentYodlee.json'
          }
        }
        stage('Appium') {
          steps {
            powershell 'copy C:\\Users\\guyar\\Desktop\\postman1\\cloud.properties .'
            powershell 'set GRADLE_USER_HOME="c:\\Program Files (x86)\\gradle-4.4-rc-6";./gradlew --info test --rerun-tasks'
            junit 'build/test-results/test/*.xml'
          }
        }
      }
    }
  }
}