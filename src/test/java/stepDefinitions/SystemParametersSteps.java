package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import pageObjects.SystemAndReferenceMasterPage;
import pageObjects.SystemParametersPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class SystemParametersSteps {
	WebDriver driver;
	public String  AlterNateHiearhyval,itemSettingVal;
	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
	
	 SystemAndReferenceMasterPage sysandrefmaster = new SystemAndReferenceMasterPage(BaseClass.getDriver());
	 public static String reportingName,ref1,ref2;
	 	

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
	
	@When("click on ItemSettingTab")
	public void click_on_ItemSettingTab() throws InterruptedException
	{

      sysparamter.clickItemSetting();
		
	}
	

	@When("Submit the itemSetting")
	public void Submit_the_itemSetting() throws InterruptedException
	{
		itemSettingVal="ItemType"+utils.generateRandomChars(4);
		sysparamter.createItemSetting(itemSettingVal);
		
	}
	
	@When("Item type validity in the department merchandise")
	public void Item_type_validity_in_the_department_merchandise() throws InterruptedException
	{
		sysparamter.validateItemTypeinBu(itemSettingVal);	
		
		
		
	}
	
	
	@When("Submit the Alternate Hierarhy details {string},{string}")
	public void Submit_the_Alternate_Hierarhy_details(String AlternateHierarchy,String Descriptionval) throws InterruptedException
	{
		System.out.println(AlternateHierarchy);
		AlterNateHiearhyval=AlternateHierarchy+"-"+utils.generateRandomChars(6);
		System.out.println(AlterNateHiearhyval);
		sysparamter.submitAlternateHierarhy(AlterNateHiearhyval, Descriptionval);
	}
	

	@When("click on ReportingCategoryTab")
	public void click_on_reporting_category_tab() {
		sysparamter.clickon_ReportingCategory();
	}
	@When("Submit the Reporting Category Details {string},{string},{string},{string}")
	public void submit_the_reporting_category_details(String Reportingname, String refer1, String refer2, String status) {
		reportingName=Reportingname+"-"+sysandrefmaster.randomString();
		testdata.setProperty("reportingName", reportingName);
		System.out.println("Reporting Category name is: "+ reportingName);
		ref1=refer1+"-"+sysandrefmaster.randomString();
		ref2=refer2+"-"+sysandrefmaster.randomString();
		sysparamter.	provideDataFor_ReportingCatogory(reportingName, ref1, ref2, status);
	}
	@Then("Validate the Reporting Cetegory in the table grid")
	public void validate_the_reporting_cetegory_in_the_table_grid() {
		sysparamter.selectReportingCatogoryInMerchandiseBU(reportingName);
		
	}
	
	@Then("Validate Alternate Hierarhy in the BU Merchandise")
	public void Validate_Alternate_Hierarhy_in_the_able_grid() throws InterruptedException
	{
		
		sysparamter.clickonAlternateHierarchy(AlterNateHiearhyval);
						
		
		
		Thread.sleep(2000);
		boolean elementExists = utils.verifyElementExistsWithXpath(AlterNateHiearhyval);

        if (elementExists) {
            System.out.println("Element with selection '" + AlterNateHiearhyval + "' found!");
        } else {
            System.out.println("Element with selection '" + AlterNateHiearhyval + "' not found!");
        }
		
		
	}

}