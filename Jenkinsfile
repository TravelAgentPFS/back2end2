pipeline {
    agent any
    tools {
        maven "Maven"
    }
    triggers {
        githubPush()
    }
    stages {
        stage('checkout') {
            steps {
                withCredentials([string(credentialsId: 'github-pat', variable: 'GITHUB_PAT')]) {
                script {
                    if (fileExists('back2end2')) {
                        dir('back2end2') {
                            sh "git reset --hard" 
                            sh "git clean -fd" 
                            sh "git pull origin main"
                        }
                    } else {
                        sh "git clone https://${GITHUB_PAT}@github.com/TravelAgentPFS/back2end2.git"
                    }
                }
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build image') {
            steps {
                script {
                    sh 'docker-compose build'
                }
            }
        }
        stage('Push image') {
            steps {
                script {
                    sh 'docker push amjadyrd/travel-agent-pfs'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Déploiement simulé réussi'
            }
        }
    }
}
