package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import utilities.ExcelUtily;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;
import utilities.PropertiesReader;

public class MerchandiseDivisionSteps {

	WebDriver driver;
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	GenericUtilities utils = new GenericUtilities(driver);
	
	public String strDivId;
	public String strDivameVal, Divsision;

	

	@When("The user on the Merchandise Pages")
	public void The_user_on_the_Merchandise_Page() throws IOException {

		BaseClass.getLogger().info("Goto my Merx Application-->Click on Login.. ");

		
		boolean targetpage = MndivisionPage.ismerchandiseBusineunitHomesPageExists();

		Assert.assertEquals(targetpage, true);

		if (targetpage) {
			BaseClass.getLogger().info("Landing on the  Merchandise page");

		} else {
			BaseClass.getLogger().info("Page is not landing on the Merchandise page");
		}

	}

	@When("click on division tab")

	public void click_on_divsion_tab() throws InterruptedException

	{

		
		MndivisionPage.clickDivisionTab();

		BaseClass.getLogger().info("Click on division Tab.");
	}
	
	

	@When("click on group tab")

	public void click_on_group_tab() throws InterruptedException

	{
		
		MndivisionPage.clickGroupTab();

		BaseClass.getLogger().info("Click on group Tab.");
	}
	@When("Click on Group Add button")
	public void click_on_Group_Add_button() throws IncorrectXpathException
	{
		MndivisionPage.clickAddButtonGroup();
	}
	
	
	@When("Click on Department Add button")
	public void click_on_Department_Add_button()
	{
		MndivisionPage.clickAddButtonDepartment();
	}
	
	
	@When("Click on Class Add button")
	public void click_on_class_Add_button()
	{
		MndivisionPage.clickAddButtonClass();
	}
	
	@When("Click on SubClass Add button")
	public void click_on_Subclass_Add_button()
	{
		MndivisionPage.clickAddButtonSubClass();
	}
	

	@Then("View the  division page")

	public void View_the_division_page() {

		boolean blnDiviiinHome = MndivisionPage.ismerchandiseDivisonPageExists();

		System.out.println(blnDiviiinHome);

		Assert.assertEquals(blnDiviiinHome, true);
		BaseClass.getLogger().info("Landing on the divion view page");

	}

	@When("select business Unit in division page")

	public void select_business_Unit_in_divsion_page() throws InterruptedException {
		// MndivisionPage= new MerchandiseDivisionPage(BaseClass.getDriver());
		//MndivisionPage.selectDivisionUnitInDivision();
		String BusinessUnit = testdata.getProperty("businessUnitName");
		
		MndivisionPage.selectBUFromDivision(BusinessUnit);
		
	}
	
	@When("Click on Divivion Add button")
	public void Click_on_Divivion_Add_button()
	{
		MndivisionPage.clickAddButtonDivision();
	}
	

	@When("verify that Division Unit ID is automatically generated")
	public void verify_that_Division_Unit_ID_is_automatically_generated() {
		try {
			MndivisionPage.isDivisionUnitUnique();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			BaseClass.getLogger().info(e);
		}
	}

	@When("Enter Division Name")
	public void Enter_Division_Name() throws IOException {
		// List<Map<String,String>> testDataInMap=ExcelUtily.getTestdatainMap();

		// MndivisionPage.setDivisionName(testDataInMap.get(0).get("divisionName"));
		// MndivisionPage.setDivisionName();

		System.out.println("Before enter division Name");

		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");
		String inpEnterDivisions = "SanityDivisionNameTests" + strTimeStamps;

		

		MndivisionPage.enterDivisionName(inpEnterDivisions, "Division Name");
		BaseClass.getLogger().info("entered Division name");

	}
	
	
	
		@When("User get the divId and Name")
		public void User_get_the_divI_and_Names()
		   {
			   try {
				   strDivId=MndivisionPage.getDivIDValidation();
				   
				   strDivameVal=MndivisionPage.getDivNameValidation();
				     
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
		   }
		   
	

	@When("The user select Reporting category in Division")
	public void the_user_select_reporting_category_in_division() throws InterruptedException {

		try {
			List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();

			MndivisionPage.click();

			MndivisionPage.selectReportingCategory(testDataInMap.get(0).get("Reporting Category"));

			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Mnp.selectReportingCategory(testDataInMap.get(0).get("Merchandise"));
		Thread.sleep(1000);

	}

	@When("The user select Alternative Hierarchy in Division")
	public void the_user_select_alternative_hierarchy_in_division() throws InterruptedException {

		try {
			List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
			MndivisionPage.alterNativeHierarch(testDataInMap.get(0).get("alterNative"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("The user click on save and continue button")
	public void The_user_click_on_save_button() throws InterruptedException {
		// MndivisionPage.clickOnSaveContinueButton();
		MndivisionPage.clikconSaveandCOntinebutton();
		System.out.println("Click on save and continue button");
	}

	@Then("The user receive confirmation message on the division page")
	public void The_user_receive_confirmation_message_on_the_division_page() {

		boolean blnRequiredField = MndivisionPage.ismsgValidaitons();
		Assert.assertEquals(blnRequiredField, true);

	}
	
	

	@When("click on save button")
	public void click_on_save_button() {
		MndivisionPage.addDivsionButtonSave();
	}

	@Then("Validate error message on the screen")
	public void Validate_error_message_on_the_screen() {
		
				
		//utils.verifyRequiredFieldErrorCount(2);
		MndivisionPage.errormessageValiation();
		
		
	}

	@Then("The page has landing the Group page")

	public void The_page_has_landing_the_Group_page() {
		MndivisionPage.vefiyGroupPage("View Group");

		System.out.println("View Screen page");
	}

	@Then("The page has landing the department page")
	public void The_page_has_landing_the_department_page() {
		MndivisionPage.vefiyDeprtPage("Depart view");
	}

	@Then("The page has landing the class page")
	public void The_page_has_landing_the_class_page() {
		MndivisionPage.vefiyClassPage("Class view");
	}

	@Then("The page has landing the Subclass page")
	public void The_page_has_landing_the_Subclass_page() {
		// MndivisionPage.vefiyClassPage("SubClass view");
		MndivisionPage.vefiySubClassPage("SubClass view");
	}

	@Then("The page has move to home page")
	public void The_page_has_move_to_home_page() {
		MndivisionPage.vefiyViewBusinessUnitHomePage("Home page Business Unit page view");
	}

	@When("User select division name Unit in Group")
	public void User_select_division_name_Unit_in_Group() {
		try {

			
			String DivisionName = testdata.getProperty("divisionName");
			
		   MndivisionPage.selectDivisionFromGroup(DivisionName);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Enter Group Name")
	public void Enter_Group_Name() throws InterruptedException

	{
		// String strGroups=MndivisionPage.timeSmtap();

		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");
		String inpEnterGroup = "SanityGroupName" + strTimeStamps;

		// List<Map<String,String>> testDataInMap=ExcelUtily.getTestdatainMap();
		MndivisionPage.enterGroupName(inpEnterGroup, "Group Name");
		BaseClass.getLogger().info("entered Group name");

	}

	@When("Enter department Name")
	public void Enter_department_Name() {
		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");
		String inpEnterDepartment = "SanityDepartment" + strTimeStamps;

		// List<Map<String,String>> testDataInMap=ExcelUtily.getTestdatainMap();
		MndivisionPage.enterDepartment(inpEnterDepartment, "Department Name");
		BaseClass.getLogger().info("entered department name");
	}

	@When("Enter Class Name")
	public void Enter_Class_Name() {
		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");
		String inpEnterClass = "SanityDepartment" + strTimeStamps;
		MndivisionPage.enterClass(inpEnterClass, "Class Name");
		BaseClass.getLogger().info("entered class name");

	}

	@When("Enter SubClass Name")
	public void Enter_SubClass_Name() {

		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");
		String inpEnterSubClass = "SanitySubClass" + strTimeStamps;
		MndivisionPage.enterSubClass(inpEnterSubClass, "Sub Class");
		BaseClass.getLogger().info("entered sub class name");
	}

	@When("click on department tab")
	public void click_on_department_tab() throws InterruptedException {
		MndivisionPage.clickDepartment();
	}

	@When("User select group name in department")
	public void User_select_group_name_in_department() {
		try {

			
			String GroupName = testdata.getProperty("groupName");
			
			   //MndivisionPage.selectDivisionFromGroup(DepartmentNmae);
			MndivisionPage.selectGroupInDepartment(GroupName);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("The user click on SubClass tab")
	public void The_user_click_on_SubClass_tab() {

		MndivisionPage.subclassTabClick();

	}

	@When("User select class name in Subclass")
	public void User_select_class_name_in_Subclass() {
		try {

			// MndivisionPage.selectGroupInDepartment();
			String Classname = testdata.getProperty("className");
			MndivisionPage.selectClassInSubclass(Classname);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User select department name in class")
	public void User_select_department_name_in_class() {
		try {
			
			String DepartmentName = testdata.getProperty("departmentName");
			
			MndivisionPage.selectnDepartmentInClass(DepartmentName);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@When("User select item Type {string}")

	public void User_select_item_Type(String strItemType) throws IOException, InterruptedException {
		try {

			System.out.println("before clcik on item type");
    
			//MndivisionPage.ItemTpeclick();	
			
			 //Thread.sleep(5000);	
						
						
			//MndivisionPage.ItemTpeclick();
			
			//MndivisionPage.ItemTpeclick();
					
			 Thread.sleep(1000);
			 

			MndivisionPage.selectItemType(strItemType);

		

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Selecting Item type ");

	}
    @When("click on class tab")
    public void click_on_class_tab()
    {
    	MndivisionPage.classTabClick();
    }
    @When("click on subclass tab")
    public void click_on_subclass_tab()
    {
    	MndivisionPage.subclassTabClick();
    }
	@When("The user click on department tab")
	public void The_user_click_on_department_tab() {
		MndivisionPage.departmentTabClick();
	}

	@When("verify that the Active status is selected by default from the Status dropdown in division")
	public void verify_that_the_active_status_is_selected_by_default_from_the_status_dropdown_in_division() {

		try {
			Thread.sleep(3000);
			Boolean blnActiv = MndivisionPage.valActivaStatus();
			Assert.assertEquals(blnActiv, true);

			System.out.println(blnActiv);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I apply Division filters {string},{string},{string},{string},{string},{string}")
	public void i_apply_Division_filters(String BusinessUnit,String Accountable, String Responsible, String Reporting_Category, String Alternate_Hierarchy, String Status) throws InterruptedException, IOException {
		//BUPage.clickOnFilter();
		Thread.sleep(8000);
		BUPage.recordInitialFilterCount();
		MndivisionPage.applyBusinessUnitFilter(BusinessUnit);
		BUPage.applyFilter();
		BUPage.validateFilterAfterApply();
		
		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();
		
		BUPage.selectAccountableFilter(Accountable);
		BUPage.selectResponsibleFilter(Responsible);
		BUPage.selectReportingCategoryFilter(Reporting_Category);
		BUPage.selectAlternateHierarchyFilter(Alternate_Hierarchy);
		BUPage.selectStatusFilter(Status);

		

	}

	@Then("I Reset and check the division filter results")
	public void i_check_the_division_filter_results() throws InterruptedException {
		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();
	}
	// Edit & Delete scenarios

		@Then("I will search with Division Unit ID and select Edit")
		public void i_will_search_with_division_unit_id_and_select_edit() throws InterruptedException {
			Divsision = testdata.getProperty("divisionName");
			MndivisionPage.click_divisiontab();
			//Div_Value = MndivisionPage.GetDivValue();
			MndivisionPage.entersearchbox(Divsision);
			MndivisionPage.click_searchbtn();
			MndivisionPage.editrecord();
		}

		@Then("I will update the Division fields {string},{string},{string},{string}")
		public void i_will_update_the_division_fields(String Division_Name, String Reporting_Category,
				String Alternate_Hierarchy, String Status) throws InterruptedException {
			MndivisionPage.UpdateDiv_Name(Divsision);
			MndivisionPage.selectRC(Reporting_Category);
			MndivisionPage.selectAlternateHierarchy(Alternate_Hierarchy);
			MndivisionPage.Updatestatus(Status);
			MndivisionPage.click_savebtn();
		}

		@Then("I will verify the updated Division fields.")
		public void i_will_verify_the_updated_division_fields() throws InterruptedException {
			MndivisionPage.entersearchbox(Divsision);
			MndivisionPage.click_searchbtn();
			MndivisionPage.getviewpagevalues();
			MndivisionPage.editrecord();
			MndivisionPage.getformpagevalues();
			MndivisionPage.comparevalues();
		}

		// delete

		@Then("I will search with Division unit ID")
		public void i_will_search_with_division_unit_id() {
			Divsision = testdata.getProperty("divisionName");
			MndivisionPage.click_divisiontab();
			//Div_Value = MndivisionPage.GetDivValue();
			MndivisionPage.entersearchbox(Divsision);
			MndivisionPage.click_searchbtn();
		}

		@Then("I will verify the deleted Division record should not exist in the system")
		public void i_will_verify_the_deleted_division_record_should_not_exist_in_the_system() {

			MndivisionPage.click_cancelsearchedbtn();
			MndivisionPage.entersearchbox(Divsision);
			MndivisionPage.click_searchbtn();
			MndivisionPage.verifyrecorddeleted();

		}

	}
