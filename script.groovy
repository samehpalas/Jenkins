def buildAPP() {
     echo 'building the Application... '
     echo "version is ${NEW_VERSION}"
}

def testAPP() {
                echo 'TeStInG the Application... '
                withCredentials([ usernamePassword(credentialsId: 'abcd', usernameVariable: 'USER', passwordVariable: 'PWD' )])
                 {
                    
                    echo " $PWD "
                    
                }
}

def deployAPP() {
                echo "Deploying the Application... $params.VERSION "
}

return this
