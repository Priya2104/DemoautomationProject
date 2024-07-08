package stepDefinitions;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.PropertiesReader;
import utilities.UploadToXray;

public class Hooks {

	private static WebDriver driver;
	private static Properties p;
	
	String Config_filePath ="src/test/resources/config.properties";
	PropertiesReader config = new PropertiesReader(Config_filePath);

	@Before
	public void setup() throws IOException, InterruptedException {
		driver = BaseClass.initilizeBrowser();
		p = BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		Thread.sleep(2000);
	}


	@After
	public void tearDown(Scenario scenario) throws Exception {
						
		BaseClass.quitDriver();
		// Xray running 
		
		/*
		if(config.getProperty("upload_toXray").contains("Yes"))
        {
            UploadToXray xray = new UploadToXray();
            xray.RemonteResultats();
        }else
        {
            System.out.print("Ignored Xray");
        }
        
        */
		// Sending an email.
		if(config.getProperty("send_Email").contains("Yes"))
		{
			utilities.EmailSendUtils.sendEmail(10, 5, 4,  1);
		}else 
		{
			System.out.print("Ignored Email Report");
		}
		
	}
	
	
	
	
   // save
	@AfterStep
	public void addScreenshot(Scenario scenario) {

		// this is for cucumber junit report
		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());

		}

	}

}