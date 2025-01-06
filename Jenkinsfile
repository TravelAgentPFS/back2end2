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
        stage('Deploy To EC2') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-pat', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                sshagent(['ec2-ssh-key']) {
                        script {
                            sh '''
                            ssh -o StrictHostKeyChecking=no ec2-user@ec2-35-181-136-158.eu-west-3.compute.amazonaws.com  "
                                docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}
                                docker pull amjadyrd/travel-agent-pfs
                                cd /home/ec2-user/test/back2end2
                                docker stack deploy --compose-file docker-compose.yml stack1
                            "
                            '''
                        }
                    }
                }
            }
        }
        }
    }
