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
//                 withDockerRegistry(credentialsId: 'dockerHubId', url: 'https://registry.hub.docker.com') {
                    sh 'docker push leomag/delivery:latest'
                }
            }
        }
        // {steps{script {docker.withRegistry( '', registryCredential ) {dockerImage.push()}}}
        stage ('Deploy') {
            steps {
                sh 'docker run -d -p 80:8080 leomag/delivery:latest'
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
}