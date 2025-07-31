properties([
    pipelineTriggers([
        githubPush()
    ])
])

pipeline {
    agent any

    stages {
        stage('拉取代码') {
            steps {
                git url: 'https://github.com/sqin2024/fsm-platform.git', branch: 'master'
            }
        }

        stage('构建 fsm-user-service 模块') {
            steps {
                sh 'mvn clean package -pl fsm-user-service -am -DskipTests'
            }
        }

        stage('构建 Docker 镜像') {
            steps {
                sh 'docker build --no-cache -t fsm-user-service:1.0 fsm-user-service'
            }
        }

        stage('部署容器') {
            steps {
                sh '''
                    docker stop fsm-user-service || true
                    docker rm fsm-user-service || true
                    docker run -d --name fsm-user-service -p 1314:10080 fsm-user-service:1.0
                '''
            }
        }
    }
}
