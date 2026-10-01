pipeline {

    agent any

     parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser'
        )

        choice(
            name: 'EXECUTION_TYPE',
            choices: ['local', 'remote'],
            description: 'Select execution type'
        )

        choice(
            name: 'HEADLESS',
            choices: ['true', 'false'],
            description: 'Run browser in headless mode'
        )
     }

    environment {
        ORANGEHRM_CREDS = credentials('orangehrm-credentials')
    }

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
                    -Dheadless=${params.HEADLESS} \
                    -Dexecution.type=${params.EXECUTION_TYPE} \
                    -Dbrowser=${params.BROWSER}
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
