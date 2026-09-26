pipeline {

    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Environment Check') {
            steps {
                sh '''
                    echo "Java version:"
                    java -version

                    echo "Gradle version:"
                    ./gradlew --version
                '''
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
                    java -version
                    javac -version
                    ./gradlew -version
                    chmod +x gradlew
                    ./gradlew clean test \
                    -Dheadless=false \
                    -Dexecution.type=remote \
                    -Dbrowser=chrome
                '''
            }
        }
    }

    post {
        always {
            junit testResults: '**/build/test-results/test/*.xml', allowEmptyResults: true
        }
    }
}
