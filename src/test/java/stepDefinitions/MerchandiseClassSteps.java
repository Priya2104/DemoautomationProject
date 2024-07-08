package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseClassPage;
import pageObjects.MerchandiseDepartmentPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class MerchandiseClassSteps {

    WebDriver driver;
    String class_name, Class_Value;
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	
    GenericUtilities utils = new GenericUtilities(driver);
    MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
    MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
    MerchandiseDepartmentPage DepartmentPage = new MerchandiseDepartmentPage(BaseClass.getDriver());
    MerchandiseClassPage ClassPage = new MerchandiseClassPage(BaseClass.getDriver());

    MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());

    MerchandiseDepartmentPage deptPage = new MerchandiseDepartmentPage(BaseClass.getDriver());

    MerchandiseClassPage classPage = new MerchandiseClassPage(BaseClass.getDriver());

    // class
    @When("User get the classIdName")
    public void User_get_the_classIdName() {
        {
            try {
                System.out.println(classPage.getClassIDValidation());
                System.out.println(classPage.getClassNameValidation());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

	@Then("I apply class filters {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_apply_class_filters(String BusinessUnit,String DivisionData,String GroupData,String DepartmentData,String Accountable, String Responsible, String Reporting_Category, String Alternate_Hierarchy, String Status) throws InterruptedException, IOException {

		BUPage.clickOnFilter();

		BUPage.recordInitialFilterCount();
		MndivisionPage.applyBusinessUnitFilter(BusinessUnit);
		GroupPage.applyDivisionFilter(DivisionData);
		DepartmentPage.applyGroupFilter(GroupData);
		ClassPage.applyDepartmentFilter(DepartmentData);
		BUPage.selectAccountableFilter(Accountable);
		BUPage.selectResponsibleFilter(Responsible);
		BUPage.selectReportingCategoryFilter(Reporting_Category);
		BUPage.selectAlternateHierarchyFilter(Alternate_Hierarchy);
		BUPage.selectStatusFilter(Status);
		BUPage.applyFilter();

		BUPage.validateFilterAfterApply();
	}

	@Then("I Reset and check the class filter results")
	public void i_check_the_Department_filter_results() throws InterruptedException {
		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();
	}

	@When("click on save button in class")
	public void click_on_save_button_in_class()
	{
		ClassPage.addClassmentButtonSave();
	}

	// Edit & Delete scenarios

	@Then("I will search with Class Unit ID and select Edit")
	public void i_will_search_with_class_unit_id_and_select_edit() throws InterruptedException {
		ClassPage.clickClassTab();
		//Class_Value = ClassPage.GetClassValue();
		Class_Value = testdata.getProperty("className");
		ClassPage.entersearchbox(Class_Value);
		ClassPage.click_searchbtn();
		ClassPage.editrecord();
	}

	@Then("I will update the Class fields {string},{string},{string},{string},{string}")
	public void i_will_update_the_class_fields(String Class_Name, String Reporting_Category, String Item_Type,
			String Alternate_Hierarchy, String Status) throws InterruptedException {

		ClassPage.UpdateClass_Name(Class_Value);
		ClassPage.selectReportingCategory(Reporting_Category);
		ClassPage.selectItemType(Item_Type);
		ClassPage.selectAlternateHierarchy(Alternate_Hierarchy);
		ClassPage.Updatestatus(Status);
		ClassPage.click_savebtn();
	}

	@Then("I will verify the updated Class fields.")
	public void i_will_verify_the_updated_class_fields() throws InterruptedException {

		ClassPage.entersearchbox(Class_Value);
		ClassPage.click_searchbtn();
		ClassPage.getviewpagevalues();
		ClassPage.editrecord();
		ClassPage.getformpagevalues();
		ClassPage.comparevalues();

	}

	@Then("I will search with Class unit ID")
	public void i_will_search_with_Department_unit_id() {
		ClassPage.clickClassTab();
		//Class_Value = ClassPage.GetClassValue();
		Class_Value = testdata.getProperty("className");
		ClassPage.entersearchbox(Class_Value);
		ClassPage.click_searchbtn();
	}

	@Then("I will verify the deleted Class record should not exist in the system")
	public void i_will_verify_the_deleted_Department_record_should_not_exist_in_the_system() {

		ClassPage.click_cancelsearchedbtn();
		ClassPage.entersearchbox(Class_Value);
		ClassPage.click_searchbtn();
		ClassPage.verifyrecorddeleted();

	}

}