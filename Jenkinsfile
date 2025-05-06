pipeline {
    agent any
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
        stage ('Push Docker Image') {
            steps {
                withDockerRegistry(credentialsId: 'dockerHubId', url: 'https://id.docker.com') {
                    sh 'docker push leomag/delivery'
                }
            }
        }
        stage ('Deploy') {
            steps {
                sh 'docker run -d -p 80:8080 leomag/delivery'
            }
        }
    }
}