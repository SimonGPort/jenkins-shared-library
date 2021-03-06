#!/usr/bin/env groovy
package com.example

class Docker implements Serializable{
    def script

    Docker(script){
        this.script=script
    }

//    def buildDockerImage(String imageName){
//        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//            script.sh "docker build -t $imageName ."
//            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
//            script.sh "docker push $imageName"
//        }
//    }

    def buildDockerImage(String imageName){
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush(String imageName){
        script.sh "docker push $imageName"
    }
}