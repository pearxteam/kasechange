@Library('ci-skip') _
pipeline {
    agent any
    stages {
        stage('prepare') { steps { ciSkip 'check' } }
        stage('build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('deploy-develop') {
            when { branch 'develop' }
            environment {
                PEARX_REPO = credentials('pearx-repo-user')
            }
            steps {
                sh "./gradlew publishDevelop -PpearxRepoUsername=${PEARX_REPO_USR} -PpearxRepoPassword=${PEARX_REPO_PSW} -PdevBuildNumber=${BUILD_NUMBER}"
            }
        }

        stage('deploy-release') {
            when { branch 'master' }
            environment {
                PEARX_REPO = credentials('pearx-repo-user')
                GITHUB_ACCESS_TOKEN = credentials('github-release-token')
            }
            steps {
                sh "./gradlew publishRelease -PpearxRepoUsername=${PEARX_REPO_USR} -PpearxRepoPassword=${PEARX_REPO_PSW} -PgithubAccessToken=${GITHUB_ACCESS_TOKEN}"
            }
        }
    }
    post { always { ciSkip 'postProcess' } }
}