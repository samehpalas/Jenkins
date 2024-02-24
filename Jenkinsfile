pipeline {
    agent none
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
