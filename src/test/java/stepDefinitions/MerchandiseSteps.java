package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandisePage;
import pageObjects.MerxLoginPage;
import utilities.ExcelUtily;
import utilities.GenericUtilities;

public class MerchandiseSteps {

	WebDriver driver;

	public String strBusinessUnits;

	public String strBuNameVal;

	MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());

	MerxLoginPage Mlp;
	public Properties p;

	GenericUtilities utils = new GenericUtilities(driver);

	@When("Click on BUUnitTab")
	public void Click_on_BUUnitTab() {
		Mnp.clickonBUUNitTab();
	}

	@When("The user on the Merchandise Page")
	public void The_user_on_the_Merchandise_Page() throws IOException {
		BaseClass.getLogger().info("Goto my Merx Application-->Click on Login.. ");

			boolean targetpage = Mnp.ismerchandisePageExists();

		System.out.println(targetpage);

		Assert.assertEquals(targetpage, false);
		
	}

	@When("Click on merchandise Menu")
	public void Click_on_merchandise_Menu() {

		Mnp.clickMerchandiseMenu();
	}

	@When("click on Business unit")
	public void click_on_Business_unit() throws InterruptedException {
		Mnp.clickBusinessUNit();
	}
	/*
	@When("click on Add button")
	public void click_on_Add_button()
	{
		Mnp.clickAddButton();
	}
	*/
	
	@When("click on save button in BU page")
	public void click_on_save_button_in_BU_page() throws InterruptedException
	{
		Mnp.addBUButtonSave();
		
	}
	
	@Then("Validate BU error message on the screen")
	
	public void Validate_BU_error_message_on_the_screen()
	{
	
		Mnp.BuerrormessageValiations();
	
}

	@When("The user get an error message if mandatory fields are empty")
	public void The_user_get_an_error_message_if_mandatory_fields_are_empty() throws InterruptedException {

		System.out.println("click on save and continue button");
		
		boolean blnRequiredField = Mnp.ismsgValidaiton();
		Assert.assertEquals(blnRequiredField, true);

	}

	@Then("verify Business Unit ID is automatically generated")
	public void verify_Business_Unit_ID_is_automatically_generated() throws InterruptedException {
		Mnp.isBusinessUnitUnique();

	}

	@When("The user add Business Unit name above length hunded and click on save")
	public void The_user_add_Business_Unit_name_above_length_hunded_and_click_on_save()
			throws InterruptedException, IOException {
		// Map<String, String> dataMap = dataTable.asMap(String.class,String.class);

		List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();

		System.out.println(testDataInMap.get(0).get("Merchandise"));

		Mnp.setBusinessUnitName(testDataInMap.get(0).get("Merchandise"));

		System.out.println("value entered in the business unit");

		Mnp.clickOnSaveContinueButton();

	}

    @When("User Can Select Company {string}")
    public void User_Can_Select_Company (String companyName)  throws IOException, NoSuchElementException, InterruptedException {
		
		//List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
	
		
		Mnp.clickonCompany();
		System.out.println(companyName);
		Mnp.selectCompany(companyName);
		
		//Mnp.selectCompany(testDataInMap.get(0).get("CompanySelect"));
		Mnp.clickonContinue();
	}

	@When("The user select Reporting category {string}")
	public void The_user_select_Reporting_category(String strReportingVal) throws AWTException, IOException, InterruptedException {
	
		Mnp.Repoclick();

		Mnp.enterReportingVal(strReportingVal);	

	
		Boolean blnActiv = Mnp.valReportingValidation();

		Assert.assertEquals(blnActiv, true);

		

		System.out.println("Selecting Reporting category");

	}

	@When("The user select Alternative Hierarchy {string}")
	public void The_user_select_Alternative_Hierarchy(String strHierarchy) throws InterruptedException, IOException, TimeoutException {

		//List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();

		//Mnp.alterNativeHierarchy(testDataInMap.get(0).get("alterNative"));
		Mnp.alterNativeHierarchy(strHierarchy);

		
	}

	@Then("verify that the Active status is selected by default from the Status dropdown")
	public void verify_that_the_Active_status_is_selected_by_default_from_the_Status_dropdown()
			throws InterruptedException {
		Boolean blnActiv = Mnp.valActivaStatus();
		Assert.assertEquals(blnActiv, true);
		
	}

	@Then("The user must get to get an error notification")
	public void The_user_must_get_to_get_an_error_notification() throws InterruptedException {

		boolean blnDuplicate = Mnp.isDuplicateExists();
		Assert.assertEquals(blnDuplicate, true);
		System.out.println("an error notification");

	}

	@When("submit the page")
	public void submit_the_page() {
		Mnp.btnSaveContunuebutton();

	}
	
	
	
	
	@When("I click on CITYMASTER")
	public void I_click_on_CITY_MASTER() throws InterruptedException {
        Thread.sleep(1000);
		Mnp.clickOnMaster();
		
	}

	
	@Then("I should be navigated to the City Master page")
	
	public void I_should_be_navigated_to_the_City_Master_page() throws InterruptedException
		
	{
		boolean isCityMasterDisplayed = Mnp.verifyCityMasterPage();
	    assert isCityMasterDisplayed : "City Master page is not displayed";
	    System.out.println("City Master page has been displaying +"+ isCityMasterDisplayed);
	}
	

	@When("The page has landing the division page")
	public void The_page_has_landing_the_division_page() throws InterruptedException {
		// utils.waitForPageLoad();
		

		Boolean blnTabFocus = Mnp.verifyTabLanding();

		Assert.assertEquals(blnTabFocus, true);

		if (blnTabFocus) {
			BaseClass.getLogger().info("Page has been focused on division page");
		} else {
			BaseClass.getLogger().info("The page is not focused as a division page.");
		}

	}

	@When("user get the BUID")
	public void user_get_the_BUID() throws InterruptedException {

		strBusinessUnits = Mnp.getBUIDValidation();

		strBuNameVal = Mnp.getBUNameValidation();
	}

	@When("User enter business Names")
	public void User_enter_business_Names() throws IOException {
		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");
		String inpEnterBuNames = "SanityAutoTests" + strTimeStamps;

		// List<Map<String,String>> testDataInMap=ExcelUtily.getTestdatainMap();
		Mnp.enterBusinessUnits();
		BaseClass.getLogger().info("enter business name");

	}

	@When("Enter the BU ID into the search box")
	public void Enter_the_BU_ID_into_the_search_box() throws IOException {

	}

	@Then("Verify that the results BU id matches per search")
	public void Verify_that_the_results_BU_id_matches_per_search() throws IOException {

	}

}
