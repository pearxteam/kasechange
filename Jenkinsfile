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
                PGP_KEY_PUBID = credentials('pgp-key-pubid')
                PGP_KEY_PASSWORD = credentials('pgp-key-password')
                PGP_KEY_PRIVATE = credentials('pgp-key-private')
            }
            steps {
                sh "./gradlew publishDevelop -PpearxRepoUsername=${PEARX_REPO_USR} -PpearxRepoPassword=${PEARX_REPO_PSW} -PdevBuildNumber=${BUILD_NUMBER} -Psigning.keyId=${PGP_KEY_PUBID} -Psigning.password=\"${PGP_KEY_PASSWORD}\" -Psigning.secretKeyRingFile=\"${PGP_KEY_PRIVATE}\""
            }
        }

        stage('deploy-release') {
            when { branch 'master' }
            environment {
                PEARX_REPO = credentials('pearx-repo-user')
                GITHUB_ACCESS_TOKEN = credentials('github-release-token')
                PGP_KEY_PUBID = credentials('pgp-key-pubid')
                PGP_KEY_PASSWORD = credentials('pgp-key-password')
                PGP_KEY_PRIVATE = credentials('pgp-key-private')
                SONATYPE_OSS = credentials('sonatype-oss-token')
            }
            steps {
                sh "./gradlew publishRelease -PpearxRepoUsername=${PEARX_REPO_USR} -PpearxRepoPassword=${PEARX_REPO_PSW} -PsonatypeOssUsername=\"${SONATYPE_OSS_USR}\" -PsonatypeOssPassword=\"${SONATYPE_OSS_PSW}\" -PgithubAccessToken=${GITHUB_ACCESS_TOKEN} -Psigning.keyId=${PGP_KEY_PUBID} -Psigning.password=\"${PGP_KEY_PASSWORD}\" -Psigning.secretKeyRingFile=\"${PGP_KEY_PRIVATE}\""
            }
        }
    }
    post {
        always {
            ciSkip 'postProcess'
            junit 'build/test-results-prefixed/**/*.xml'
            jacoco classPattern: 'build/classes', execPattern: 'build/jacoco/*.exec', sourcePattern: 'src'
        }
    }
}