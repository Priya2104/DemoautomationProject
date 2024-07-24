package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ItemManagementPage;
import pageObjects.MerchandisePage;
import pageObjects.MerxLoginPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;

public class ItemManagementSteps {

	// Web driver
	WebDriver driver;
	// Global variable usage
	public String strBusinessUnits;
	public String strBuNameVal;
	public String strDivId;
	public String strDivNameVal;

	// Constructor creation
	// Merchandise page
	MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
	// Item Management page
	ItemManagementPage ItemMngt = new ItemManagementPage(BaseClass.getDriver());

	MerxLoginPage Mlp;
	public Properties p;

	String TestData_filePath = "testData/TestData.properties";

	PropertiesReader testdata = new PropertiesReader(TestData_filePath);
	GenericUtilities utils = new GenericUtilities(driver);

	@When("Click on create Item menu")
	public void Click_on_createItem_menu() throws InterruptedException {
		ItemMngt.clickonCreateItem();
	}

	@When("Select Business Unit from Item Management")
	public void The_user_on_the_Merchandise_Page() throws IOException, InterruptedException {
		System.out.println("Before select business unit");
		//String BusinessUnit = testdata.getProperty("businessUnitName");
				//CompanyAPI_ID
	//String BusinessUnit = ItemMngt.CompanyAPI_ID;
		ItemMngt.selectBusinessUnit();
		/*
		 * boolean buValdaton = ItemMngt.clickBuValidations();
		 * System.out.println(buValdaton); Assert.assertEquals(buValdaton, true);
		 */
	}

	@When("Select Division from Item Management")
	public void Select_Division_from_Item_Mangement() throws InterruptedException {
		//String Divsision = testdata.getProperty("divisionName");
		ItemMngt.selectDivisionVal();
		/*
		 * boolean divValdaton = ItemMngt.clickDivValidations();
		 * System.out.println(divValdaton); Assert.assertEquals(divValdaton, true);
		 */
	}

	@When("The user select Reporting category Item {string}")
	public void The_user_select_Reporting_category_Item(String strReportingVal) {
		ItemMngt.selectReportingVal(strReportingVal);
	}

	@When("submit Item Creation")
	public void submit_Item_Creation() {
		ItemMngt.clickonContinueButton();
	}

	@When("select class from Item management")
	public void select_class_from_Item_management() throws InterruptedException {
		//String Class = testdata.getProperty("className");
		ItemMngt.selectClassItem();
		/*
		 * boolean isValid = ItemMngt.classIdName(); // boolean isValid =
		 * validateClick(ItemMngt.strDivNameVa); if (isValid) { // Click validation
		 * passed, proceed System.out.println("class ID and name working"); } else { //
		 * Handle failed validation System.out.println("class ID and name not working");
		 * }
		 * 
		 */
	}

	@When("select subclass from Item management")
	public void select_subclass_from_Item_management() throws InterruptedException {
		//String SubClass = testdata.getProperty("subClassName");
		ItemMngt.selectSubClassItem();
		/*
		 * boolean isValid = ItemMngt.subClassIdName(); // boolean isValid =
		 * validateClick(ItemMngt.strDivNameVa); if (isValid) { // Click validation
		 * passed, proceed System.out.println("Subclass ID and name working"); } else {
		 * // Handle failed validation
		 * System.out.println("subclass ID and name not working"); }
		 */
	}

	@When("select Department from Item Management")
	public void select_Department_from_Item_Mangement() throws InterruptedException {
		//String Department = testdata.getProperty("departmentName");
		ItemMngt.selectDepartmentItem();

		/*
		 * boolean isValid = ItemMngt.DeptIDName(); // boolean isValid =
		 * validateClick(ItemMngt.strDivNameVa); if (isValid) { // Click validation
		 * passed, proceed System.out.println("Depart ID and name working"); } else { //
		 * Handle failed validation
		 * System.out.println("Depart ID and name not working"); }
		 */
	}

	@When("Create family Item")
	public void Create_family_Item(String str) {

		// ItemMngt.createFamilyITem();

	}

	@When("Create Family Item with name {string},{string},{string},{string},{string},{string}")
	public void Create_Family_Item_with_name(String familyDescval, String itemStatus, String longDescription,
			String pos1Description, String pos2Description, String Differentiators) {
		ItemMngt.createFamilyITem(familyDescval, itemStatus, longDescription, pos1Description, pos2Description,
				Differentiators);
	}

	@When("Create ChildItem {string}")
	public void Create_ChildItem(String strChildItems) throws IOException {
		ItemMngt.createChildITem(strChildItems);
	}

	@Then("Verify the child item was created successfully {string},{string},{string},{string},{string}")
	public void Verify_the_child_item_was_created_successfully(String familyDesc,String ClothingColor,String ClothingSize,String ClothingPattern,String	ClothingFabric) throws InterruptedException {
		ItemMngt.verifyChiltemExists(familyDesc,ClothingColor,ClothingSize,ClothingPattern,ClothingFabric);
	}

	@When("select subtype")
	public void select_subtype() throws InterruptedException {
		ItemMngt.selectSubTypeItem();
	}

	@When("select Group from Item Management")
	public void select_Group_from_Item_Mangement() throws InterruptedException, TimeoutException {
		//String Group = testdata.getProperty("groupName");
		ItemMngt.selectGrouDivVal();
		/*
		 * boolean isValid = ItemMngt.GroupIDName(); // boolean isValid =
		 * validateClick(ItemMngt.strDivNameVa); if (isValid) { // Click validation
		 * passed, proceed System.out.println("Groupname and ID workings"); } else { //
		 * Handle failed validation System.out.println("Groupname and ID not workings");
		 * } }
		 */

	}
	
	
	@When("I search with created Family item and select edit.")
    public void i_search_with_created_family_item_and_select_edit() throws InterruptedException {
        System.out.println("checking...");
        ItemMngt.click_maintainitem();
        //ItemMngt.searchitem("10000315");
        //ItemMngt.click_threedots();
        ItemMngt.SelectFamilyitem();
    }
    
    @When("I will select the Item VAT from Item Association in the Maintain screen")
    public void i_will_select_the_item_vat_from_item_association_in_the_maintain_screen() throws InterruptedException {
        
        ItemMngt.ClickItemAssociation();
        ItemMngt.ClickItemVAT();
    }
    
    @When("I will select the Item Related from Item Association in the Maintain screen")
    public void i_will_select_the_item_Related_from_item_association_in_the_maintain_screen() throws InterruptedException {
        
        ItemMngt.ClickItemAssociation();
        ItemMngt.selectRelatedItem();
    }

	@When("I Create Merchandise data with API request")
	public void iCreateMerchansiseDataWithApiRequest() {
		//ItemMngt.getCreateMerchandiseDataIDs();
		ItemMngt.CreateMerchandiseData();
	}
	
	 @When("I submit a new Related Item {string},{string}")
	    public void submitNewRelatedItem(String strSKUCODE,String RelatedItemDes) throws InterruptedException {
		 ItemMngt.fillItemDetails(strSKUCODE,RelatedItemDes);
	       // ItemMngt.submitItem();
	    }

	    @Then("Created Related Item Displayed in Results grid {string},{string}")
	    public void verifyCreatedItemDisplayed(String strSKUCODE,String RelatedItemDes) {
	    	//ItemMngt.verifyItemDisplayed("test", "Sprint9 Sanity CFH1");
	    	
	    	String strSKUItemDescription = Mnp.getCellValue(2, 2);
			System.out.println(strSKUItemDescription);

			Assert.assertEquals(strSKUItemDescription, strSKUCODE);

			String strRelatedItemDes = Mnp.getCellValue(2, 4);
			System.out.println(strRelatedItemDes);

			Assert.assertEquals(strRelatedItemDes, RelatedItemDes);
	    	
	    	
	    }
	    
	    @When("Select VMI Consignment")
		public void select_vmi_type() throws InterruptedException {
			ItemMngt.selectVMIConsignment();
		}
		
		@When("Select VMI consession")
		public void select_vmi_consession() throws InterruptedException {
		   
		    ItemMngt.selectVMIConsession();;
		}

}