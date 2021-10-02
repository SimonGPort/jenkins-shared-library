#!/usr/bin/env groovy

def call(){
    withCredentials([usernamePassword(credentialsId:'docker-hub-repo',passwordVariable:'PASS',usernameVariable:'USER')]){
        sh 'docker build -t simongport/my-repo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push simongport/my-repo:jma-2.0'
}