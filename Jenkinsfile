pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerHubId')
    }

    stages {
        stage ('Build') {
            agent {
                any {
                    image 'openjdk:17'
                    args '-v "$PWD":/app'
                    reuseNode true
                }
            }
            steps {
                sh './gradlew clean build'
            }
        }
        stage ('Docker Info') {
            steps {
                sh 'docker info'
            }
        }
        stage ('Build Docker Image') {
            steps {
                sh 'docker build -t leomag/delivery .'
            }
        }
        stage ('Push Docker Image') {
            steps {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker push leomag/delivery:latest'
                }
            }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}