def testAPP() {
                echo 'TeStInG the Application... '
                withCredentials([ usernamePassword(credentialsId: 'abcd', usernameVariable: 'USER', passwordVariable: 'PWD' )])
                 {
                    
                    echo " $PWD "
                  
                }
}
def deployAPP() {
                echo "Deploying the Application... "
}

return this
