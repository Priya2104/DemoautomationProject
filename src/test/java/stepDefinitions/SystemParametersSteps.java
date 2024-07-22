package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import pageObjects.SystemParametersPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class SystemParametersSteps {
	WebDriver driver;
	public String  AlterNateHiearhyval;
	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());

	GenericUtilities utils = new GenericUtilities(driver);

	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);
    
	SystemParametersPage sysparamter= new SystemParametersPage(BaseClass.getDriver());

	
	@When("Click on system paramter Menu")
	public void Click_on_system_paramter_Menu() throws InterruptedException {

		sysparamter.clickOnSystemParameterMenu();

	}
	@When("click on Alternate Hierarchy")
	public void Alternate_Hierarchy() throws InterruptedException {
		sysparamter.clickAlternateHierarchy();
	}
	
	@When("click on AlternateHierarhyTab")
	public void click_on_AlternateHierarhyTab() throws InterruptedException
	{
		sysparamter.clickOnSystemParamterButton();
		
	}
	
	@When("Submit the Alternate Hierarhy details {string},{string}")
	public void Submit_the_Alternate_Hierarhy_details(String AlternateHierarchy,String Descriptionval) throws InterruptedException
	{
		System.out.println(AlternateHierarchy);
		AlterNateHiearhyval=AlternateHierarchy+"-"+utils.generateRandomChars(6);
		System.out.println(AlterNateHiearhyval);
		sysparamter.submitAlternateHierarhy(AlterNateHiearhyval, Descriptionval);
	}
	
	@Then("Validate Alternate Hierarhy in the table grid")
	public void Validate_Alternate_Hierarhy_in_the_able_grid() throws InterruptedException
	{
		
		sysparamter.clickonAlternateHierarchy(AlterNateHiearhyval);
						
		
		
		Thread.sleep(1000);
		boolean elementExists = utils.verifyElementExistsWithXpath(AlterNateHiearhyval);

        if (elementExists) {
            System.out.println("Element with selection '" + AlterNateHiearhyval + "' found!");
        } else {
            System.out.println("Element with selection '" + AlterNateHiearhyval + "' not found!");
        }
		
		
	}

}