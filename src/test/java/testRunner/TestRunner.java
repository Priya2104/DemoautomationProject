package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.PropertiesReader;


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
        
    tags="@WebOrder"
        
		)
public class TestRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
        
       

   
    }
    

}