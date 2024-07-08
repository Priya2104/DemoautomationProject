package testRunner;


import org.junit.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import factory.BaseClass;
import io.cucumber.testng.CucumberOptions;
import utilities.PropertiesReader;
import utilities.UploadToXray;




public class TestRunnerXray {
	
	
	
	
	String Config_filePath ="src/test/resources/config.properties";
	PropertiesReader config = new PropertiesReader(Config_filePath);
	
	@Test
	public void tearDown() throws Exception {
		
		//BaseClass.quitDriver();
		// Xray running 
		if(config.getProperty("upload_toXray").contains("Yes"))
        {
            UploadToXray xray = new UploadToXray();
            xray.RemonteResultats();
        }else
        {
            System.out.print("Ignored Xray");
        }
		
		
	}

}
