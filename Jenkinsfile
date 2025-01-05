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
                sh 'mvn clean compile package -DskipTests'
            }
        }
        stage('Build image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-pat', passwordVariable: 'password', usernameVariable: 'username')]) {
                    script {
                        sh 'docker login -u ${username} -p ${password}'
                        sh 'docker build -t amjadyrd/travel-agent-pfs .'
                    }
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
        stage('Deploy to EC2'){
            steps {
                echo "deploy ..."
            }
        }
    }
}
