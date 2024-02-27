#! /usr/bin/env groovy
library identifier: 'jenkins-shared-library@main' ,
    retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://github.com/samehpalas/jenkins-shared-library.git' ,
         credentialsId: 'sameh-github-cred'
         ]
        )
//@Library ('jenkins-shared-library')
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
                     dockerpush 'samehpalas/demo-app:py-1.7'
                     
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
