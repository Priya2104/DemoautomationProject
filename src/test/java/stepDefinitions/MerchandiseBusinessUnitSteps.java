package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandisePage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class MerchandiseBusinessUnitSteps {

	WebDriver driver;

	ArrayList<String> formvalues;
	List<String> valuesToAdd;
	ArrayList<String> formvalues2;
	String BU_name;
	String BU_Value;
	String BusinessUnit;
	
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	GenericUtilities utils = new GenericUtilities(driver);

	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandisePage BU_HomePage = new MerchandisePage(BaseClass.getDriver());

	@Then("I apply filters {string},{string},{string},{string},{string}")
	public void i_apply_filters(String Accountable, String Responsible, String Reporting_Category, String Alternate_Hierarchy, String Status) throws InterruptedException, IOException, AWTException {
		//BUPage.clickOnFilter();
		//BUPage.recordInitialFilterCount();
		BUPage.selectAccountableFilter(Accountable);
		BUPage.selectResponsibleFilter(Responsible);
		BUPage.selectReportingCategoryFilter(Reporting_Category);
		BUPage.selectAlternateHierarchyFilter(Alternate_Hierarchy);
		BUPage.selectStatusFilter(Status);
		//BUPage.applyFilter();


		//BUPage.validateFilterAfterApply();


	}

	@Then("I Reset and check the filter results")
	public void i_check_the_filter_results() throws InterruptedException {
		BUPage.validateResetNoFilter();
		BUPage.validateResetFilter();
	}
	
	// vinay code
	
	// Edit & Delete scenarios

		@Then("I will search with Business Unit ID and select Edit")
		public void i_will_search_with_business_unit_id_and_select_edit() throws InterruptedException {

			//BU_Value = BUPage.GetBUValue();
			BusinessUnit = testdata.getProperty("businessUnitName");
			BUPage.entersearchbox(BusinessUnit);
			BUPage.click_searchbtn();
			BUPage.editrecord();
		}

		@Then("I will update the fields {string},{string},{string},{string}")
		public void i_will_update_the_fields(String Business_Unit_Name, String Reporting_Category,
				String Alternate_Hierarchy, String Status) throws InterruptedException {
			BUPage.UpdateBU_Name(BusinessUnit);
			BUPage.selectReportingCategory(Reporting_Category);
			BUPage.selectAlternateHierarchy(Alternate_Hierarchy);
			BUPage.Updatestatus(Status);
			BUPage.click_savebtn();

		}

		@Then("I will verify the updated fields.")
		public void i_will_verify_the_updated_fields() throws InterruptedException {

			BUPage.entersearchbox(BusinessUnit);
			BUPage.click_searchbtn();
			BUPage.getviewpagevalues();
			BUPage.editrecord();
			BUPage.getformpagevalues();
			BUPage.comparevalues();

		}

	//delete

		@Then("I will search with Business unit ID")
		public void i_will_search_with_business_unit_id() {
			// BU_Value = BUPage.GetBUValue();
			// BUPage.entersearchbox(BU_Value);
			BusinessUnit = testdata.getProperty("businessUnitName");
			BUPage.entersearchbox(BusinessUnit);
			BUPage.click_searchbtn();
		}

		@Then("I will Delete the record")
		public void i_will_delete_the_record() throws InterruptedException {
			BUPage.ClickDelete();
		}

		@Then("I will verify the deleted BU record should not exist in the system")
		public void i_will_verify_the_deleted_bu_record_should_not_exist_in_the_system() {
			BUPage.click_cancelsearchedbtn();
			BUPage.entersearchbox(BusinessUnit);
			BUPage.click_searchbtn();
			BUPage.verifyrecorddeleted();
		}

	}