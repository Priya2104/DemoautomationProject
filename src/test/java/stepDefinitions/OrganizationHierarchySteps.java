package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandisePage;
import pageObjects.MerxLoginPage;
import pageObjects.OrganizationHierarchyPage;
import pageObjects.SystemAndReferenceMasterPage;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;
import utilities.PropertiesReader;


public class OrganizationHierarchySteps {

	public static String Chainname,RegionName,AreaName,DistrictName;

    WebDriver driver;

    // MerchandisePage Mnp;
    OrganizationHierarchyPage orgHierarchy = new OrganizationHierarchyPage(BaseClass.getDriver());
    MerxLoginPage Mlp;
    public Properties p;
  //public static String  strBusinessUnits;
  
    //OrganizationHierarchyPage orgHierarchy = new OrganizationHierarchyPage(BaseClass.getDriver());
    SystemAndReferenceMasterPage sysandrefmaster = new SystemAndReferenceMasterPage(BaseClass.getDriver());
    GenericUtilities utils = new GenericUtilities(driver);
    
    String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);
	
  
 // public static String Chainname;
  //public static String RegionName;

   //Chain
    
    @When("user click on Organization Hierarchy menu")
    public void user_click_on_organization_hierarchy_menu() {
    	orgHierarchy.OrganozationHierarchyMenu_Click();
    }
    @When("user clicks on Add Chain button")
    public void user_clicks_on_add_chain_button() {
    	orgHierarchy.addOrHierarchy_button_Click();
    }
    @When("user provide chain details are {string},{string},{string},{string}")
    public void user_provide_chain_details_are(String string, String OrganizationHierachy, String DefaulrCurrency, String status) {
    	Chainname=string+utils.generateRandomChars(5);
    	testdata.setProperty("ChainName", Chainname);
    			orgHierarchy.provide_Chain_Values(Chainname, OrganizationHierachy, DefaulrCurrency, status);
    }
    @Then("user validate the success message as {string}")
    public void user_validate_the_success_message_as(String string) {

    	System.out.println(string);
    }
    @Then("user search with {string}")
    public void user_search_with(String ChainNaame) {
    	ChainNaame=testdata.getProperty("ChainName");
    	
       orgHierarchy.provide_Chaindetails_forSearchField(ChainNaame);
    }


//Range
    
    @When("user clicks on Add Region button")
    public void user_clicks_on_add_region_button() {
    	orgHierarchy.addRegionButton_Click();
    }
  
    @When("user provide Range details are {string},{string},{string},{string},{string}")
    public void user_provide_range_details_are(String Areaname,String Regionname,String Alternativehierarchy,String curencny,String status) {
    	RegionName=Regionname+utils.generateRandomChars(5);
    	testdata.setProperty("RegionName", RegionName);
    	orgHierarchy.provide_Range_Values(Areaname,RegionName,Alternativehierarchy,curencny,status);
    }
    @Then("user search with rangename {string}")
    public void user_search_with_rangename(String Regioname) {
    	Regioname=testdata.getProperty("RegionName");
    	orgHierarchy.provide_Chaindetails_forSearchField(Regioname);
    }


  //steps

  //Area

      @When("user clicks on Add Area button")
      public void user_clicks_on_add_area_button() {
          orgHierarchy.addAreaButton_Click();
      }
      @When("user provide Area details are {string},{string},{string},{string},{string}")
      public void user_provide_area_details_are(String ChainName, String Areaname, String Alternativehierarchy, String defaultcurrency, String status) {
      	AreaName=Areaname+utils.generateRandomChars(5);
      	orgHierarchy.provide_Area_Values(ChainName, AreaName, Alternativehierarchy, defaultcurrency, status);
      }
      @Then("user search with Areaname {string}")
      public void user_search_with_areaname(String areaname) {
      	areaname=AreaName;
      	orgHierarchy.provide_Chaindetails_forSearchField(areaname);
      }
      
      //District
      
      @When("user clicks on Add District button")
      public void user_clicks_on_add_district_button() {
          orgHierarchy.addDistrictButton_Click();
      }
      @When("user provide District details are {string},{string},{string},{string},{string}")
      public void user_provide_district_details_are(String regionname, String districtname, String alternativehierarchy, String defaultcurrency, String status) {
      	DistrictName=districtname+utils.generateRandomChars(5);
      	testdata.setProperty("districtname", DistrictName);
      	orgHierarchy.provide_District_Values(regionname, DistrictName, alternativehierarchy, defaultcurrency, status);
      }
      @Then("user search with Districtname {string}")
      public void user_search_with_districtname(String Districtname) {
      	Districtname=testdata.getProperty("districtname");
          orgHierarchy.provide_Chaindetails_forSearchField(Districtname);
      }






}
