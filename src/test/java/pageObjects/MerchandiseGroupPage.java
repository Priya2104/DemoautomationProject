package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.GenericUtilities;

public class MerchandiseGroupPage extends BasePage {
    //WebDriverWait wait;
    //WebDriver driver;


    public static String strGrpId;

    public static String strGrpNameVal;
    
    List<String> valuesToAdd;
	ArrayList<String> formvalues;


    public MerchandiseGroupPage(WebDriver driver) {
        super(driver);

    }

    GenericUtilities utils = new GenericUtilities(driver);
    MerxLoginPage Mlp;
    public Properties p;
    
    @FindBy(xpath = "//*[contains(text(),'Add Group')]")
    WebElement btnGroup;

    @FindBy(xpath = "//input[@id='groupId']")
    WebElement inpGrpID;

    @FindBy(xpath = "//input[@id='groupName']")
    WebElement inpGrpName;


    @FindBy(xpath = "//div[@id='divisionId']")
    WebElement filtersVale_divisionId;

    @FindBy(xpath = "//input[contains(@aria-owns,'divisionId_list')]")
    WebElement filterValue_Divsearch;
    
  //Edit Xpaths

  	@FindBy(xpath = "//span[text()='Group']")
  	WebElement Grouptab;

  	@FindBy(xpath = "//span[normalize-space()='Group']")
  	WebElement Group;

  	@FindBy(xpath = "//input[@placeholder='Group ID Or Group Name']")
  	WebElement searchbox;

  	@FindBy(xpath = "//button[@type='button' and @icon='pi pi-search']")
  	WebElement search_btn;

  	@FindBy(xpath = "//div[@class='grid align-items-center']//span[contains(text(),' 1 ')]")
  	WebElement Group_count;

  	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[1]")
  	WebElement gridview_divisionID;

  	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[2]")
  	WebElement gridview_divisionname;

  	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[5]")
  	WebElement gridview_Reportingcategory;

  	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[7]")
  	WebElement gridview_status;

  	@FindBy(xpath = "//span[@class='pi pi-ellipsis-v p-button-icon ng-star-inserted']")
  	WebElement threedots;

  	@FindBy(xpath = "//a[@class='p-ripple p-element p-menuitem-link ng-star-inserted']//span[text()='Edit']")
  	WebElement edit_btn;

  	@FindBy(xpath = "//p-dropdown[@formcontrolname='division']")
  	WebElement formview_division;

  	@FindBy(xpath = "//input[@formcontrolname='groupId']")
  	WebElement formview_groupID;

  	@FindBy(xpath = "//input[@formcontrolname='groupName']")
  	WebElement formview_groupname;

  	@FindBy(xpath = "//div[@id='reportingCategory']/span")
  	WebElement formview_Reportingcategory;

  	@FindBy(xpath = "//div[@id='reportingCategory']//span")
  	WebElement formviewgettext_rp;

  	@FindBy(xpath = "//*[@class='p-dropdown-clear-icon p-icon']")
  	WebElement formview_cancelbutton_rp;

  	@FindBy(xpath = "//ul[@role='listbox']//li/span")
  	List<WebElement> comboReporting;

  	@FindBy(xpath = "//div[@class='p-element p-multiselect-label-container']")
  	WebElement formview_AlternateHierarchy;

  	@FindBy(xpath = "//ul[@role='listbox']//li/span")
  	List<WebElement> comboAlternateHierarchy;

  	@FindBy(xpath = "//div[@id='status']//span")
  	WebElement formviewgettext_status;

  	@FindBy(xpath = "//ul[@role='listbox']//li/span")
  	List<WebElement> combostatus;

  	@FindBy(xpath = "//span[text()='Save']")
  	WebElement formview_Save_btn;

  	@FindBy(xpath = "//span[text()='Cancel']")
  	WebElement formview_Cancel_btn;

  	@FindBy(xpath = "//span[text()='Delete']")
  	WebElement formview_delete_btn;

  	@FindBy(xpath = "//h3[contains(text(),'Group')]")
  	WebElement FormView_grp;

  	@FindBy(xpath = "//span[text()='Yes']")
  	WebElement Yes_button;

  	@FindBy(xpath = "//span[text()='No']")
  	WebElement No_button;

  	@FindBy(xpath = "//div[@data-pc-section='detail']")
  	WebElement Success_msg;

  	@FindBy(xpath = "//span[contains(text(),'Are you sure')]")
  	WebElement Cancel_msg;

  	@FindBy(xpath = "//h2[contains(text(),'View Group')]")
  	WebElement txt_viewpage;

  	@FindBy(xpath = "//div[@data-pc-section='detail']")
  	WebElement txt_postclickondelete_msg;

  	@FindBy(xpath = "//i[@class='pi pi-times']")
  	WebElement cancel_searchbtn;

  	@FindBy(xpath = "//span[contains(text(),'No Records Found')]")
  	WebElement Norecord_msg;
  	
  	 @FindBy(xpath = "(//span[contains(text(),'Save')])[2]")
     WebElement btnSave;


    public String getGrpvIDValidation() throws InterruptedException {
    	utils.waitForElementToBeVisiblewithFluentWait(inpGrpID, 3);
        strGrpId = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpGrpID);
        System.out.println("Textbox value: " + strGrpId);
        return strGrpId;
    }

    // Method
    public String getGrpNameValidation() throws InterruptedException {
    	utils.waitForElementToBeVisiblewithFluentWait(inpGrpName, 3);
        strGrpNameVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpGrpName);
        System.out.println("Textbox value: " + strGrpNameVal);
        return strGrpNameVal;
    }


    public void applyDivisionFilter(String Division) throws InterruptedException {
        if (Division.isEmpty()) {
            System.out.println("Ignoring BusinessUnit filter");
        } else {
            Thread.sleep(2000);
            utils.clickElementWithJavaScript(filtersVale_divisionId);
            filterValue_Divsearch.sendKeys(Division);

            Thread.sleep(1500);

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            actions.sendKeys(Keys.ENTER).build().perform();
        }
    }

    public void clickGroupTab() {
		try {
			utils.clickOnWebElement(Group);

		} catch (Exception e) {
			// logReportMessageAndTakeScreenShot("Open Failed - " + "");

		}
	}

	public String txt_searchcount() {
		try {
			String count = Group_count.getText();
			return count;
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

	public boolean checkcountequalsto1() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Group_count);
			String count = Group_count.getText();
			System.out.println(count);
			String value = "1";

			if (count.equals(value)) {
				return true;
			} else {
				return false;
			}

		}

		catch (Exception e) {
			return false;
		}

	}

	public String txt_viewgroupID() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_divisionID);
			String txtBuid = gridview_divisionID.getText();
			return txtBuid;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String txt_viewgroupname() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_divisionname);
			String txtBuname = gridview_divisionname.getText();
			return txtBuname;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String txt_viewreportingcategory() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_Reportingcategory);
			String txtrp = gridview_Reportingcategory.getText();
			return txtrp;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String txt_viewstatus() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_status);
			String txtstatus = gridview_status.getText();
			return txtstatus;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void click_threedots() {
		try {
			utils.waitForElementToBeClickablewithFluentWait(threedots, 10);
			// utils.waitForElementclickable(Duration.ofSeconds(10), threedots);
			threedots.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void click_edit_btn() {
		try {
			utils.waitForElementToBeClickablewithFluentWait(edit_btn, 10);
			// utils.waitForElementclickable(Duration.ofSeconds(10), edit_btn);
			edit_btn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean verifyFormgrp() {

		try {
			utils.waitForElementclickable(Duration.ofSeconds(10), formview_groupname);
			// utils.waitForpresenseofElementLocated(Duration.ofSeconds(10), FormView_grp);
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), FormView_grp);
			// boolean formgrp= FormView_grp.isDisplayed();
			boolean formgrp = formview_groupname.isEnabled();
			System.out.println(formgrp);
			return formgrp;
		} catch (Exception e) {
			return false;
		}
	}

	public String getgrpID() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_groupID);
			// String txtformBUID=formview_businessunitID.getText();
			String formgrpID = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					formview_groupID);
			return formgrpID;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getgrpName() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_groupname);
			// String txtformBUID=formview_businessunitID.getText();
			String formgrp_Name = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					formview_groupname);
			return formgrp_Name;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getrp() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formviewgettext_rp);
			// utils.waitForElementLocated(Duration.ofSeconds(10), formviewgettext_rp);
			String formrp = formviewgettext_rp.getText();
			return formrp;

		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getstatus() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formviewgettext_status);
			// utils.waitForElementLocated(Duration.ofSeconds(10), formviewgettext_status);
			String formrp = formviewgettext_status.getText();
			return formrp;

		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void setgrpName(String grpname) {
		try {
			formview_groupname.click();
			formview_groupname.clear();
			formview_groupname.sendKeys(grpname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void click_cancelrp() {
		utils.waitForElementclickable(Duration.ofSeconds(10), formview_cancelbutton_rp);
		formview_cancelbutton_rp.click();
	}

	public void selectStatus(String strstatus) {
		utils.waitForElementclickable(Duration.ofSeconds(10), formviewgettext_status);
		// utils.waitForElementVisibilityFor(Duration.ofSeconds(10),
		// formviewgettext_status);
		formviewgettext_status.click();
		utils.comoboxlist(combostatus, strstatus);
	}

	public void click_yesbutton() {
		// utils.waitForElementclickable(Duration.ofSeconds(10), Yes_button);
		utils.waitForElementToBeClickablewithFluentWait(Yes_button, 5);
		Yes_button.click();
	}

	public void click_savebtn() throws InterruptedException {
		utils.waitForElementclickable(Duration.ofSeconds(10), formview_Save_btn);
		utils.clickOnWebElement(formview_Save_btn);
		// Thread.sleep(3000);
	}

	public void click_cancelbtn() {
		utils.waitForElementclickable(Duration.ofSeconds(10), formview_Cancel_btn);
		formview_Cancel_btn.click();
	}

	public boolean Viewgrppagedisplayed() {
		try {

			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), txt_viewpage);
			boolean value = utils.doesElementExist(txt_viewpage);
			return value;

		} catch (Exception e) {
			return false;

		}
	}

	public String getgroupID() {
		try {
			return strGrpId;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public boolean Norecordsmsgdisplayed() {
		try {

			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Norecord_msg);
			boolean value = utils.doesElementExist(Norecord_msg);
			return value;
		} catch (Exception e) {
			return false;
		}
	}

	public String getmessage() {
		try {
			String message = txt_postclickondelete_msg.getText();
			return message;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void click_cancelsearchedbtn() {
		try {
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), threedots);
			utils.waitForElementclickable(Duration.ofSeconds(10), cancel_searchbtn);
			cancel_searchbtn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// New Methods

	public String GetgrpValue() { // Getting the Group ID and name

		if (strGrpId != null || !strGrpId.isEmpty()) {
			return strGrpId;
		} else {
			return strGrpNameVal;
		}
	}

	public void entersearchbox(String GroudId) { // Sending the Group value to the search box
		try {
			// utils.waitForElementclickable(Duration.ofSeconds(10), searchbox);
			utils.waitForElementToBeClickablewithFluentWait(searchbox, 10);
			searchbox.clear();
			searchbox.sendKeys(GroudId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void click_searchbtn() { // selecting the search button for the value entered in the search box
		try {
			utils.waitForElementclickable(Duration.ofSeconds(10), search_btn);
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), search_btn);
			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			// search_btn);
			utils.clickOnWebElement(search_btn);
			// Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void addGroupButtonSave()
	{
		utils.btnSavebutton(btnGroup,btnSave);
    	
	}
	public void editrecord() throws InterruptedException { // selecting the edit button
		if (checkcountequalsto1()) {
			// three dots
			click_threedots();
			// click edit
			click_edit_btn();
			Thread.sleep(3000); // Hard wait cannot be removed because of the performance issue.
		} else {
			System.out.println("count is not equals to 1, so editing the record can't be performed");
		}
	}

	public void UpdateGrp_Name(String Grp_Value) { // Updating the Group name
		if (verifyFormgrp()) {
			if (Grp_Value.length() <= 40) {
				String strTimeStamp = utils.getSystemDate();
				String strTimeStamps = strTimeStamp.replace("_", "");
				String inpEnterBuNames = Grp_Value + strTimeStamps;
				setgrpName(inpEnterBuNames);
			} else {
				String strTimeStamp = utils.getSystemDate();
				String strTimeStamps = strTimeStamp.replace("_", "");
				String inpEnterBuNames = "Grp" + strTimeStamps + strTimeStamps;
				setgrpName(inpEnterBuNames);
			}
		}

		else {
			System.out.println("Form View Business_unit_name returned as empty");
		}
	}

	public void selectReportingCategory(String strReportingCategory) { // updating the Reporting category
		if (strReportingCategory.isEmpty()) {
			System.out.println("Reporting category is empty");
		} else {
			click_cancelrp();
			utils.waitForElementclickable(Duration.ofSeconds(10), formview_Reportingcategory);
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10),
			// formview_Reportingcategory);
			formview_Reportingcategory.click();
			utils.comoboxlist(comboReporting, strReportingCategory);
		}
	}

	public void selectAlternateHierarchy(String strAlternateHierarchy) { // Updating the AlternateHierarchy
		if (strAlternateHierarchy.isEmpty()) {
			System.out.println("AlternateHierarchy is empty");
		} else {
			utils.waitForElementclickable(Duration.ofSeconds(10), formview_AlternateHierarchy);
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10),
			// formview_AlternateHierarchy);
			formview_AlternateHierarchy.click();
			utils.comoboxlist(comboAlternateHierarchy, strAlternateHierarchy);
			formview_AlternateHierarchy.click();
		}
	}

	public void Updatestatus(String status) throws InterruptedException { // Checking and updating the status field

		String actualstatus = getstatus();
		System.out.println(actualstatus);
		if (actualstatus.equals(status)) {
			System.out.println("status values matches:" + status);
		} else {
			System.out.println("status values dosent matches:" + status);
			selectStatus("Active");
			click_yesbutton();
		}
	}

	public void getviewpagevalues() { // Getting the view page field values to compare
		if (checkcountequalsto1()) {
			valuesToAdd = Arrays.asList(txt_viewgroupID(), txt_viewgroupname(), txt_viewreportingcategory(),
					txt_viewstatus());
			// System.out.println(valuesToAdd);
			valuesToAdd.forEach(valuesToAdd -> System.out.println("view page:" + valuesToAdd));
			utils.addvalue(valuesToAdd);
		} else {
			System.out.println("count is not equals to 1");
		}
	}

	public void getformpagevalues() { // Getting the form page field values to compare
		if (verifyFormgrp()) {
			// utils.getvalues();
			formvalues = new ArrayList<>();

			formvalues.add(getgrpID());
			formvalues.add(getgrpName());
			formvalues.add(getrp());
			formvalues.add(getstatus());

			formvalues.forEach(formvalues -> System.out.println("form page:" + formvalues));
		} else {
			System.out.println("System is not redirected to form page");
		}
	}

	public void comparevalues() { // Comparing the view and form page values
		if (!formvalues.isEmpty()) {
			boolean result = utils.compareValues(formvalues);
			System.out.println("Values matches: " + result);
			utils.clearvalues();
		} else {
			System.out.println("Form values is empty");
		}
	}

	public void verifyrecorddeleted() { // verifying the delete record is exist or not in the system
		if (Norecordsmsgdisplayed()) {
			System.out.println("Record deleted successfully");
		} else {
			System.out.println("Record still exist");
		}
	}

}
