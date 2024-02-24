pipeline {
    agent none
    environment {
        NEW_VERSION = "1.3.0"
        CREDENTIALS = credentials ('abcd')
    }
    stages {
        stage('test') {
            steps {
                echo 'Testing the Application... '
                echo "version is $BRANCH_NAME"
                
            }
        }
        stage('build') {
            when {
              expression {
                $BRANCH_NAME == 'main' 
              }
            }  
            steps {
                echo 'building the Application... '
                echo "version is ${NEW_VERSION}"
            }
        }
        
        stage('deploy') {
            when {
              expression {
                $BRANCH_NAME == 'main' 
              }
            }  
            steps {
                echo 'Deploying the Application... '
            }
        }
        
    }
}
