package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseDepartmentPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class MerchandiseDepartmentSteps {

	WebDriver driver;
	String Dep_name, Dep_Value;

	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);

	GenericUtilities utils = new GenericUtilities(driver);

	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
	MerchandiseDepartmentPage deptPage = new MerchandiseDepartmentPage(BaseClass.getDriver());
	MerchandiseDepartmentPage DepartmentPage = new MerchandiseDepartmentPage(BaseClass.getDriver());

	// Department
	@When("User get the DeptIDNames")
	public void User_get_the_DeptIDNames() {
		{
			try {
				System.out.println(deptPage.getDeptIDValidation());
				System.out.println(deptPage.getDeptNameValidation());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Then("I apply Department filters {string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_apply_Department_filters(String BusinessUnit, String DivisionData, String GroupData,
			String Accountable, String Responsible, String Reporting_Category, String Alternate_Hierarchy,
			String Status) throws InterruptedException, IOException {

		Thread.sleep(8000);
		BUPage.recordInitialFilterCount();
		MndivisionPage.applyBusinessUnitFilter(BusinessUnit);
		GroupPage.applyDivisionFilter(DivisionData);
		DepartmentPage.applyGroupFilter(GroupData);
		BUPage.applyFilter();
		BUPage.validateFilterAfterApply();

		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();

		//BUPage.recordInitialFilterCount();
		//MndivisionPage.applyBusinessUnitFilter(BusinessUnit);
		
		BUPage.selectAccountableFilter(Accountable);
		BUPage.selectResponsibleFilter(Responsible);
		BUPage.selectReportingCategoryFilter(Reporting_Category);
		BUPage.selectAlternateHierarchyFilter(Alternate_Hierarchy);
		BUPage.selectStatusFilter(Status);
		//BUPage.applyFilter();

		//BUPage.validateFilterAfterApply();
	}

	@Then("I Reset and check the Department filter results")
	public void i_check_the_Department_filter_results() throws InterruptedException {
		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();
	}

	// Edit & Delete scenarios

	@Then("I will search with Department Unit ID and select Edit")
	public void i_will_search_with_department_unit_id_and_select_edit() throws InterruptedException {
		DepartmentPage.clickDepartmentTab();
		// Dep_Value = DepartmentPage.GetDepValue();
		Dep_Value = testdata.getProperty("departmentName");
		DepartmentPage.entersearchbox(Dep_Value);
		DepartmentPage.click_searchbtn();
		DepartmentPage.editrecord();
	}

	@Then("I will update the Department fields {string},{string},{string},{string},{string}")
	public void i_will_update_the_department_fields(String Department_Name, String Reporting_Category, String Item_Type,
			String Alternate_Hierarchy, String Status) throws InterruptedException {

		DepartmentPage.UpdateDept_Name(Dep_Value);
		DepartmentPage.selectReportingCategory(Reporting_Category);
		DepartmentPage.selectItemType(Item_Type);
		DepartmentPage.selectAlternateHierarchy(Alternate_Hierarchy);
		DepartmentPage.Updatestatus(Status);
		DepartmentPage.click_savebtn();

	}

	@When("click on save button in department")
	public void click_on_save_button_in_department() {
		DepartmentPage.addDepartmentButtonSave();

	}

	@Then("Validate depClassSubclass error message on the screen")
	public void Validate_depClassSubclass_error_message_on_the_screen() {
		DepartmentPage.depClassSubClasserrormessageValiation();
	}

	@Then("I will verify the updated Department fields.")
	public void i_will_verify_the_updated_department_fields() throws InterruptedException {

		DepartmentPage.entersearchbox(Dep_Value);
		DepartmentPage.click_searchbtn();
		DepartmentPage.getviewpagevalues();
		DepartmentPage.editrecord();
		DepartmentPage.getformpagevalues();
		DepartmentPage.comparevalues();

	}

	@Then("I will search with Department unit ID")
	public void i_will_search_with_Department_unit_id() {
		DepartmentPage.clickDepartmentTab();
		// Dep_Value = DepartmentPage.GetDepValue();
		Dep_Value = testdata.getProperty("departmentName");
		DepartmentPage.entersearchbox(Dep_Value);
		DepartmentPage.click_searchbtn();
	}

	@Then("I will verify the deleted Department record should not exist in the system")
	public void i_will_verify_the_deleted_Department_record_should_not_exist_in_the_system() {

		DepartmentPage.click_cancelsearchedbtn();
		DepartmentPage.entersearchbox(Dep_Value);
		DepartmentPage.click_searchbtn();
		DepartmentPage.verifyrecorddeleted();

	}

}
