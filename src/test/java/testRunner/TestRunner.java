package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.PropertiesReader;
import utilities.UploadToXray;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {".//Features"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:reports/myreport.html", "rerun:target/rerun.txt","json:Report/cucumber/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        publish = false,
        

        //tags = "@ClassErrorMessage or @BUErrorMessage or @DivisionErrorMessage or @GropuErrorMessage or @DepartmentErrorMessage or @SubClassErrorMessage"
         // tags ="@BusinessSetup or @GroupSetup or @ClassSetup or  @DepartmentSetup or SubClassSetup or DivisionSetup"
		  //tags="@LanguageMasterAdd"
        //tags="@LogoMasterMobile or  @LogoMasterDesktop or  @LogoMasterDesktopError or @LogoMasterMobileError or @LanguageMasterAdd"
		 tags="@MerchendiseSetup"
		)
public class TestRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
        
       

   
    }
    
//	String Config_filePath ="src/test/resources/config.properties";
//	PropertiesReader config = new PropertiesReader(Config_filePath);
//    
//	@AfterClass
//	public void tearDown() throws Exception {
//		
//		//BaseClass.quitDriver();
//		// Xray running 
//		if(config.getProperty("upload_toXray").contains("Yes"))
//        {
//            UploadToXray xray = new UploadToXray();
//            xray.RemonteResultats();
//        }else
//        {
//            System.out.print("Ignored Xray");
//        }
//	}
}