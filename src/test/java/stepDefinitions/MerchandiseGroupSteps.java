package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class MerchandiseGroupSteps {
    WebDriver driver;
    MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
    MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
    MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());

    GenericUtilities utils = new GenericUtilities(driver);
    //public String strGroupId;
    // public String  strGrpNameVal;
    String Gp_name, Grp_Value;
    
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  

    @When("User get the GroupIDNames")
    public void User_get_the_GroupIDNames() {
        {
            try {
                System.out.println(GroupPage.getGrpvIDValidation());
                System.out.println(GroupPage.getGrpNameValidation());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch blocks
                e.printStackTrace();
            }
        }
    }

    @Then("I apply group filters {string},{string},{string},{string},{string},{string},{string}")
    public void i_apply_group_filters(String BusinessUnit,String DivisionData,String Accountable, String Responsible, String Reporting_Category, String Alternate_Hierarchy, String Status) throws InterruptedException, IOException {
        BUPage.clickOnFilter();

        BUPage.recordInitialFilterCount();
        MndivisionPage.applyBusinessUnitFilter(BusinessUnit);
        GroupPage.applyDivisionFilter(DivisionData);
        BUPage.selectAccountableFilter(Accountable);
        BUPage.selectResponsibleFilter(Responsible);
        BUPage.selectReportingCategoryFilter(Reporting_Category);
        BUPage.selectAlternateHierarchyFilter(Alternate_Hierarchy);
        BUPage.selectStatusFilter(Status);

        BUPage.applyFilter();

        BUPage.validateFilterAfterApply();

    }

    @Then("I Reset and check the group filter results")
    public void i_check_the_group_filter_results() throws InterruptedException {
        BUPage.validateResetNoFilter();
        BUPage.validateResetFilter();
    }
 // Edit & Delete scenarios

 	@Then("I will search with Group Unit ID and select Edit")
 	public void i_will_search_with_group_unit_id_and_select_edit() throws InterruptedException {

 		GroupPage.clickGroupTab();
 		//Grp_Value = GroupPage.GetgrpValue();
 		Grp_Value = testdata.getProperty("groupName");
 		GroupPage.entersearchbox(Grp_Value);
 		GroupPage.click_searchbtn();
 		GroupPage.editrecord();
 	}

 	@Then("I will update the Group fields {string},{string},{string},{string}")
 	public void i_will_update_the_group_fields(String Group_Name, String Reporting_Category, String Alternate_Hierarchy,
 			String Status) throws InterruptedException {

 		GroupPage.UpdateGrp_Name(Grp_Value);
 		GroupPage.selectReportingCategory(Reporting_Category);
 		GroupPage.selectAlternateHierarchy(Alternate_Hierarchy);
 		GroupPage.Updatestatus(Status);
 		GroupPage.click_savebtn();

 	}

 	@Then("I will verify the updated Group fields.")
 	public void i_will_verify_the_updated_group_fields() throws InterruptedException {

 		GroupPage.entersearchbox(Grp_Value);
 		GroupPage.click_searchbtn();
 		GroupPage.getviewpagevalues();
 		GroupPage.editrecord();
 		GroupPage.getformpagevalues();
 		GroupPage.comparevalues();

 	}
 	
 	@When("click on save button in group")
	public void click_on_save_button_in_group()
	{
 		GroupPage.addGroupButtonSave();
	}

 	@Then("I will search with Group unit ID")
 	public void i_will_search_with_Group_unit_id() {
 		GroupPage.clickGroupTab();
 		Grp_Value = testdata.getProperty("groupName");
 		//Grp_Value = GroupPage.GetgrpValue();
 		GroupPage.entersearchbox(Grp_Value);
 		GroupPage.click_searchbtn();
 	}

 	@Then("I will verify the deleted Group record should not exist in the system")
 	public void i_will_verify_the_deleted_Group_record_should_not_exist_in_the_system() {

 		GroupPage.click_cancelsearchedbtn();
 		GroupPage.entersearchbox(Grp_Value);
 		GroupPage.click_searchbtn();
 		GroupPage.verifyrecorddeleted();

 	}

 }