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
        stage('Appium') {
          steps {
            powershell 'copy C:\\Users\\guyar\\Desktop\\postman1\\cloud.properties .'
            powershell 'set GRADLE_USER_HOME="c:\\Program Files (x86)\\gradle-4.4-rc-6";./gradlew --info clean test --rerun-tasks'
          }
        }
        stage('Unit') {
          steps {
            sleep 10
          }
        }
      }
    }
    stage('Performance') {
      steps {
        sleep 5
      }
    }
  }
  post {
    always {
      junit 'build/test-results/**/*.xml'
      junit 'newman/**/*.xml'

    }

  }
}