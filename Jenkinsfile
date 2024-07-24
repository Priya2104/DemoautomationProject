
node('selenium') {
	stage('Checkout') {
		cleanWs()
		checkout scm
		sh 'ls -lrt'
	}
	stage('Test Execution') {
		sh '''
			env | sort
			apk update
			apk add --no-cache chromium
			apk add --no-cache chromium-chromedriver
			#apk add chromium
			#apk add chromium-chromedriver
			apk add maven
			mvn clean && mvn install
			#ls -l		
		'''
	}
	stage('Reporting') {
    publishHTML(target: [
        allowMissing: false,
        alwaysLinkToLastBuild: true,
        keepAll: true,
        reportDir: 'Report/',
        reportFiles: 'CucumberExtentReport.html',
        reportName: 'Merx UI AUTOMATION Report'
    ])
}	
}


