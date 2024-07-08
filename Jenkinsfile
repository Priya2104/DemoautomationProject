
node('selenium') {
	stage('Checkout') {
		cleanWs()
		checkout scm
		sh 'ls -lrt'
	}
	stage('Test Execution') {
		sh '''
			env | sort
			apk add chromium
			apk add chromium-chromedriver
			mvn clean && mvn install
			#ls -l		
		'''
	}	
}


