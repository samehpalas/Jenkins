def gv
pipeline {
    agent none
    stages {
        stage('init') {
            steps {
              gv = load (script.groovy)
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
            when {
              expression {
                $BRANCH_NAME == 'main' 
              }
            }  
            steps {
                script {
                     buildIMG()  //call this function from sharedLibrary
            }
        }  
     }
        stage('deploy') {
            when {
              expression {
                $BRANCH_NAME == 'main' 
              }
            }  
            steps {
                script {
                         gv.deployAPP()
            }
         }
        }
    }
}
