#! /usr/bin/env groovy
library identifier: 'jenkins-shared-library@main' ,  //scoped shared library to extend the pipeline for this project
    retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://github.com/samehpalas/jenkins-shared-library.git' ,
         credentialsId: 'sameh-github-cred'
       ] 
    )  
//@Library ('jenkins-shared-library')    // global SL , point on from jenkins global pipeline libraries
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
                     buildIMG 'samehpalas/demo-app:py-1.8'  //call this function from sharedLibrary and pass this parameter
                     dockerLogin()
                     dockerpush 'samehpalas/demo-app:py-1.8'
                     
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
