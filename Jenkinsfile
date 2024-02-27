#! /usr/bin/env groovy
@Library ('jenkins-shared-library')
def gv
pipeline {
    agent any
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    gv.testAPP()   //call this function from from groovyscript
                }
            }
        }
        stage('build') {
            //when {
              //expression {
                //$BRANCH_NAME == 'main' 
              //}
            //}  
            steps {
                script {
                     buildIMG 'samehpalas/demo-app:py-1.7'  //call this function from sharedLibrary and pass this parameter
                     dockerLogin()
                     Docker.dockerpush 'samehpalas/demo-app:py-1.7'
                     
            }
        }  
     }
        stage('deploy') { 
            steps {
                script {
                         gv.deployAPP()
            }
         }
        }
    }
}
