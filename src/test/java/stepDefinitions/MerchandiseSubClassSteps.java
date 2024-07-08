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
import pageObjects.MerchandiseSubClassPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class MerchandiseSubClassSteps {
	WebDriver driver;
	String Subclass_name, SubClass_Value;
	
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	
	GenericUtilities utils = new GenericUtilities(driver);
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	MerchandiseDepartmentPage DepartmentPage = new MerchandiseDepartmentPage(BaseClass.getDriver());
	MerchandiseClassPage ClassPage = new MerchandiseClassPage(BaseClass.getDriver());
	MerchandiseSubClassPage SubClassPage = new MerchandiseSubClassPage(BaseClass.getDriver());

	// subclass
	@When("User get the subclassIdName")
	public void User_get_the_subclassIdName() {
		{
			try {
				System.out.println(SubClassPage.getsubclassIDValidation());
				System.out.println(SubClassPage.getsubclassNameValidation());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	@Then("I apply subclass filters {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_apply_subclass_filters(String BusinessUnit, String DivisionData, String GroupData,
			String DepartmentData, String ClassData, String Accountable, String Responsible, String Reporting_Category,
			String Alternate_Hierarchy, String Status) throws InterruptedException, IOException {

		BUPage.clickOnFilter();

		BUPage.recordInitialFilterCount();
		MndivisionPage.applyBusinessUnitFilter(BusinessUnit);
		GroupPage.applyDivisionFilter(DivisionData);
		DepartmentPage.applyGroupFilter(GroupData);
		ClassPage.applyDepartmentFilter(DepartmentData);
		SubClassPage.applyClassFilter(ClassData);

		BUPage.selectAccountableFilter(Accountable);
		BUPage.selectResponsibleFilter(Responsible);
		BUPage.selectReportingCategoryFilter(Reporting_Category);
		BUPage.selectAlternateHierarchyFilter(Alternate_Hierarchy);
		BUPage.selectStatusFilter(Status);
		BUPage.applyFilter();

		BUPage.validateFilterAfterApply();
	}
	
	@When("click on save button in subclass")
	public void click_on_save_button_in_subclass()
	{
		SubClassPage.addSubClassButtonSave();
		{
			
		}
	}

	@Then("I Reset and check the subclass filter results")
	public void i_check_the_subclass_filter_results() throws InterruptedException {
		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();
	}
	// Edit & Delete Scenarios
	
	@Then("I will search with Subclass Unit ID and select Edit")
	public void i_will_search_with_subclass_unit_id_and_select_edit() throws InterruptedException {
		SubClassPage.clickSubClassTab();
		//SubClass_Value = SubClassPage.GetSubclassValue();
		SubClass_Value = testdata.getProperty("subClassName");
		SubClassPage.entersearchbox(SubClass_Value);
		SubClassPage.click_searchbtn();
		SubClassPage.editrecord();
	}

	@Then("I will update the Subclass fields {string},{string},{string},{string},{string}")
	public void i_will_update_the_subclass_fields(String Subclass_Name, String Reporting_Category, String Item_Type,
			String Alternate_Hierarchy, String Status) throws InterruptedException {
		SubClassPage.UpdateDiv_Name(SubClass_Value);
		SubClassPage.selectReportingCategory(Reporting_Category);
		SubClassPage.selectItemType(Item_Type);
		SubClassPage.selectAlternateHierarchy(Alternate_Hierarchy);
		SubClassPage.Updatestatus(Status);
		SubClassPage.click_savebtn();
	}

	@Then("I will verify the updated Subclass fields.")
	public void i_will_verify_the_updated_subclass_fields() throws InterruptedException {
		SubClassPage.entersearchbox(SubClass_Value);
		SubClassPage.click_searchbtn();
		SubClassPage.getviewpagevalues();
		SubClassPage.editrecord();
		SubClassPage.getformpagevalues();
		SubClassPage.comparevalues();

	}

	@Then("I will search with Subclass unit ID")
	public void i_will_search_with_Department_unit_id() {
		SubClassPage.clickSubClassTab();
		//SubClass_Value = SubClassPage.GetSubclassValue();
		SubClass_Value = testdata.getProperty("subClassName");
		SubClassPage.entersearchbox(SubClass_Value);
		SubClassPage.click_searchbtn();
	}

	@Then("I will verify the deleted Subclass record should not exist in the system")
	public void i_will_verify_the_deleted_Department_record_should_not_exist_in_the_system() {

		SubClassPage.click_cancelsearchedbtn();
		SubClassPage.entersearchbox(SubClass_Value);
		SubClassPage.click_searchbtn();
		SubClassPage.verifyrecorddeleted();

	}

}
