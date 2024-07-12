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

import factory.BaseClass;
import utilities.GenericUtilities;

public class MerchandiseDepartmentPage extends BasePage {
    //WebDriverWait wait;
    //WebDriver driver;

    public MerchandiseDepartmentPage(WebDriver driver) {
        super(driver);

    }

    GenericUtilities utils = new GenericUtilities(driver);


    public static String strDepId;

    public static String strDepNameVal;
    
    List<String> valuesToAdd;
	ArrayList<String> formvalues;
	MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());

    MerxLoginPage Mlp;

    public Properties p;
    Actions actions = new Actions(driver);

    //workings -MerchandiseGroup GroupPage = new MerchandiseGroup(BaseClass.getDriver());


    @FindBy(xpath = "//input[@id='departmentId']")
    WebElement inDeptID;
	@FindBy(xpath="//input[contains(@aria-owns,'groupId_list')]")
	WebElement filterValue_Grpsearch;
    @FindBy(xpath = "//input[@id='departmentName']")
    WebElement inpDeptName;
	@FindBy(xpath = "//div[@id='merchGroupPkid']")
	WebElement filtersVale_groupId;
	
	@FindBy(xpath = "//span[contains(text(),'Add Department')]")
    WebElement btnAddDeparment;
	
	// edit xpaths

		@FindBy(xpath = "//span[normalize-space()='Department']")
		WebElement Department;

		@FindBy(xpath = "//input[@placeholder='Department ID Or Department Name']")
		WebElement searchbox;

		@FindBy(xpath = "//button[@type='button' and @icon='pi pi-search']")
		WebElement search_btn;

		@FindBy(xpath = "//div[@class='grid align-items-center']//span[contains(text(),' 1 ')]")
		WebElement Department_count;

		@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[1]")
		WebElement gridview_DepartmentID;

		@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[2]")
		WebElement gridview_Departmentame;

		@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[5]")
		WebElement gridview_Reportingcategory;

		@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[7]")
		WebElement gridview_status;

		@FindBy(xpath = "//span[@class='pi pi-ellipsis-v p-button-icon ng-star-inserted']")
		WebElement threedots;

		@FindBy(xpath = "//a[@class='p-ripple p-element p-menuitem-link ng-star-inserted']//span[text()='Edit']")
		WebElement edit_btn;

		@FindBy(xpath = "//p-dropdown[@formcontrolname='group']")
		WebElement formview_group;

		@FindBy(xpath = "//input[@formcontrolname='departmentId']")
		WebElement formview_departmentId;

		@FindBy(xpath = "//input[@formcontrolname='departmentName']")
		WebElement formview_departmentname;

		@FindBy(xpath = "//div[@id='reportingCategory']/span")
		WebElement formview_Reportingcategory;

		@FindBy(xpath = "//div[@id='itemTypeId']/span")
		WebElement formview_Itemtype;

		@FindBy(xpath = "//div[@id='reportingCategory']//span")
		WebElement formviewgettext_rp;

		@FindBy(xpath = "//*//*[@id='reportingCategory']//*[@class='p-dropdown-clear-icon p-icon']")
		WebElement formview_cancelbutton_rp;

		@FindBy(xpath = "//*[@id='itemTypeId']//*[@class='p-dropdown-clear-icon p-icon']")
		WebElement formview_cancelbutton_itemtype;

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

		@FindBy(xpath = "//h2[contains(text(),'Department')]")
		WebElement FormView_department;

		@FindBy(xpath = "//span[text()='Yes']")
		WebElement Yes_button;

		@FindBy(xpath = "//span[text()='No']")
		WebElement No_button;

		@FindBy(xpath = "//div[@data-pc-section='detail']")
		WebElement Success_msg;

		@FindBy(xpath = "//span[contains(text(),'Are you sure')]")
		WebElement Cancel_msg;

		@FindBy(xpath = "//h2[contains(text(),'View Department')]")
		WebElement txt_viewpage;

		@FindBy(xpath = "//div[@data-pc-section='detail']")
		WebElement txt_postclickondelete_msg;

		@FindBy(xpath = "//i[@class='pi pi-times']")
		WebElement cancel_searchbtn;

		@FindBy(xpath = "//span[contains(text(),'No Records Found')]")
		WebElement Norecord_msg;
		
		 @FindBy(xpath = "(//span[contains(text(),'Save and Next')])")
	     WebElement btnSave;

    public String getDeptIDValidation() throws InterruptedException {
    	utils.waitForElementToBeVisiblewithFluentWait(inDeptID, 3);
        strDepId = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inDeptID);
        System.out.println("Textbox value: " + strDepId);
        return strDepId;
    }

    public String getDeptNameValidation() throws InterruptedException {
    	utils.waitForElementToBeVisiblewithFluentWait(inpDeptName, 3);
        strDepNameVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpDeptName);
        System.out.println("Textbox value: " + strDepNameVal);
        return strDepNameVal;
    }

	public void applyGroupFilter(String Group) throws InterruptedException
	{
		if(Group.isEmpty())
		{
			System.out.println("Ignoring BusinessUnit filter");
		}else
		{
            utils.waitForElementToBeClickablewithFluentWait(filtersVale_groupId, 10);

            filtersVale_groupId.click();
            Thread.sleep(500);
			filterValue_Grpsearch.sendKeys(Group);
			Thread.sleep(1000);

			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(3000);
			actions.sendKeys(Keys.ENTER).build().perform();
		}
	}

	// edit methods

		public void clickDepartmentTab() {
			try {
				utils.clickOnWebElement(Department);

			} catch (Exception e) {
				// logReportMessageAndTakeScreenShot("Open Failed - " + "");

			}
		}

		public String txt_searchcount() {
			try {
				String count = Department_count.getText();
				return count;
			} catch (Exception e) {
				return (e.getMessage());
			}

		}

		public boolean checkcountequalsto1() {
			try {
				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Department_count);
				String count = Department_count.getText();
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

		public String txt_viewDepartmentID() {
			try {
				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_DepartmentID);
				String txtBuid = gridview_DepartmentID.getText();
				return txtBuid;
			} catch (Exception e) {
				return (e.getMessage());
			}
		}

		public String txt_viewDepartmentname() {
			try {
				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_Departmentame);
				String txtBuname = gridview_Departmentame.getText();
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
				// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), threedots);
				utils.waitForElementToBeClickablewithFluentWait(threedots, 10);
				threedots.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void click_edit_btn() {
			try {
				// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), edit_btn);
				utils.waitForElementclickable(Duration.ofSeconds(10), edit_btn);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", edit_btn);
				// edit_btn.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
        public void depClassSubClasserrormessageValiation()
        {
        	utils.verifyRequiredFieldErrorCount(3);
        }
		public void addDepartmentButtonSave()
		{
			utils.btnSavebutton(btnAddDeparment,btnSave);
		}
		
		public boolean verifyFormDepartment() {
			try {
				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_departmentname);
				// utils.waitForElementclickable(Duration.ofSeconds(10), formview_delete_btn);
				boolean formdep = formview_departmentname.isDisplayed();
				System.out.println(formdep);
				return formdep;
			} catch (Exception e) {
				return false;
			}
		}

		public String getDepartmentID() {
			try {
				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_departmentId);
				// String txtformBUID=formview_businessunitID.getText();
				String formBUID = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
						formview_departmentId);
				return formBUID;
			} catch (Exception e) {
				return (e.getMessage());
			}
		}

		public String getDepartmentName() {
			try {
				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_departmentname);
				// String txtformBUID=formview_businessunitID.getText();
				String formBU_Name = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
						formview_departmentname);
				return formBU_Name;
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

		public void setDepartmentname(String Departmentname) {
			try {
				formview_departmentname.click();
				formview_departmentname.clear();
				formview_departmentname.sendKeys(Departmentname);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void selectStatus(String strstatus) throws InterruptedException {
			utils.waitForElementclickable(Duration.ofSeconds(10), formviewgettext_status);
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10),
			// formviewgettext_status);
			formviewgettext_status.click();
			Thread.sleep(2000);
			utils.comoboxlist(combostatus, strstatus);
		}

		public void click_cancelrp() {
			utils.waitForElementclickable(Duration.ofSeconds(10), formview_cancelbutton_rp);
			formview_cancelbutton_rp.click();
		}

		public void click_cancelitemtype() {
			// utils.waitForElementclickable(Duration.ofSeconds(10),
			// formview_cancelbutton_rp);
			utils.waitForElementToBeVisiblewithFluentWait(formview_cancelbutton_itemtype, 5);
			formview_cancelbutton_itemtype.click();
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

		public void click_yesbutton() {
			utils.waitForElementclickable(Duration.ofSeconds(10), Yes_button);
			Yes_button.click();
		}

		public void click_nobutton() {
			utils.waitForElementclickable(Duration.ofSeconds(10), No_button);
			No_button.click();
		}

		public boolean ViewDepartmentpagedisplayed() {
			try {

				utils.waitForElementVisibilityFor(Duration.ofSeconds(10), txt_viewpage);
				boolean value = utils.doesElementExist(txt_viewpage);
				return value;

			} catch (Exception e) {
				return false;

			}
		}

		public String getDepartID() {
			try {
				return strDepId;
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

		public String GetDepValue() { // Getting the Department unit ID and name

			if (strDepId != null || !strDepId.isEmpty()) {
				return strDepId;
			} else {
				return strDepNameVal;
			}

		}

		public void entersearchbox(String DepartmentId) { // Sending the Department unit value to the search box
			try {
				utils.waitForElementToBeClickablewithFluentWait(searchbox, 10);
				// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), searchbox);
				searchbox.clear();
				searchbox.sendKeys(DepartmentId);
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

		public void UpdateDept_Name(String Dep_Value) { // Updating the Department unit name
			if (verifyFormDepartment()) {
				if (Dep_Value.length() <= 40) {
					String strTimeStamp = utils.getSystemDate();
					String strTimeStamps = strTimeStamp.replace("_", "");
					String inpEnterBuNames = Dep_Value + strTimeStamps;
					setDepartmentname(inpEnterBuNames);
				} else {
					String strTimeStamp = utils.getSystemDate();
					String strTimeStamps = strTimeStamp.replace("_", "");
					String inpEnterBuNames = "Dept" + strTimeStamps + strTimeStamps;
					setDepartmentname(inpEnterBuNames);
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

		public void selectItemType(String strItemType) { // Updating the ItemType
			if (strItemType.isEmpty()) {
				System.out.println("Reporting category is empty");
			} else {
				click_cancelitemtype();
				utils.waitForElementclickable(Duration.ofSeconds(10), formview_Itemtype);
				// utils.waitForElementToBeClickablewithFluentWait(formview_Reportingcategory,
				// 5);
				formview_Itemtype.click();
				utils.comoboxlist(comboReporting, strItemType);
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
				valuesToAdd = Arrays.asList(txt_viewDepartmentID(), txt_viewDepartmentname(), txt_viewreportingcategory(),
						txt_viewstatus());
				// System.out.println(valuesToAdd);
				valuesToAdd.forEach(valuesToAdd -> System.out.println("view page:" + valuesToAdd));
				utils.addvalue(valuesToAdd);
			} else {
				System.out.println("count is not equals to 1");
			}
		}

		public void getformpagevalues() { // Getting the form page field values to compare
			if (verifyFormDepartment()) {
				// utils.getvalues();
				formvalues = new ArrayList<>();

				formvalues.add(getDepartmentID());
				formvalues.add(getDepartmentName());
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