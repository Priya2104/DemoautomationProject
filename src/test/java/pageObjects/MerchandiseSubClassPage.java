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

public class MerchandiseSubClassPage extends BasePage {
    //WebDriverWait wait;
    //WebDriver driver;
    public static String strSubClassId;
    public static String strsubclassNameVal;
    public Properties p;
    
	List<String> valuesToAdd;
	ArrayList<String> formvalues;
    
    public MerchandiseSubClassPage(WebDriver driver) {
        super(driver);
    }

    GenericUtilities utils = new GenericUtilities(driver);
    MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
    MerxLoginPage Mlp;

    @FindBy(xpath = "//input[@id='subclassId']")
    WebElement inpSubClassID;
    @FindBy(xpath = "//input[@id='subclassName']")
    WebElement inpSubClassName;
    @FindBy(xpath = "//input[contains(@aria-owns,'classId_list')]")
    WebElement filterValue_Classsearch;
    @FindBy(xpath = "//div[@id='classId']")
    WebElement filtersVale_classId;
    
	// Edit Xpaths
	@FindBy(xpath = "//span[text()='Subclass']")
	WebElement subClass;

	@FindBy(xpath = "//input[@placeholder='Subclass ID Or Subclass Name']")
	WebElement searchbox;

	@FindBy(xpath = "//button[@type='button' and @icon='pi pi-search']")
	WebElement search_btn;

	@FindBy(xpath = "//div[@class='grid align-items-center']//span[contains(text(),' 1 ')]")
	WebElement subclass_Count;

	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[1]")
	WebElement gridview_subclassID;

	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[2]")
	WebElement gridview_subclassname;

	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[5]")
	WebElement gridview_Reportingcategory;

	@FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[7]")
	WebElement gridview_status;

	@FindBy(xpath = "//span[@class='pi pi-ellipsis-v p-button-icon ng-star-inserted']")
	WebElement threedots;

	@FindBy(xpath = "//a[@class='p-ripple p-element p-menuitem-link ng-star-inserted']//span[text()='Edit']")
	WebElement edit_btn;

	@FindBy(xpath = "//input[@formcontrolname='subclassId']")
	WebElement formview_subclassID;

	@FindBy(xpath = "//input[@formcontrolname='subclassName']")
	WebElement formview_subclassname;

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

	@FindBy(xpath = "//h2[contains(text(),'Subclass')]")
	WebElement FormView_subclass;

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement Yes_button;

	@FindBy(xpath = "//span[text()='No']")
	WebElement No_button;

	@FindBy(xpath = "//div[@data-pc-section='detail']")
	WebElement Success_msg;

	@FindBy(xpath = "//span[contains(text(),'Are you sure')]")
	WebElement Cancel_msg;

	@FindBy(xpath = "//h2[contains(text(),'View Subclass')]")
	WebElement txt_viewpage;

	@FindBy(xpath = "//div[@data-pc-section='detail']")
	WebElement txt_postclickondelete_msg;

	@FindBy(xpath = "//i[@class='pi pi-times']")
	WebElement cancel_searchbtn;

	@FindBy(xpath = "//span[contains(text(),'No Records Found')]")
	WebElement Norecord_msg;

	@FindBy(xpath = "//*[@id='itemTypeId']//*[@class='p-dropdown-clear-icon p-icon']")
	WebElement formview_cancelbutton_itemtype;

	@FindBy(xpath = "//div[@id='itemTypeId']/span")
	WebElement formview_Itemtype;
	 @FindBy(xpath = "(//span[contains(text(),'Save')])")
	 WebElement btnSave;
	  @FindBy(xpath = "//span[contains(text(),'Add Subclass')]")
	    WebElement btnAddSubClass;


    public String getsubclassIDValidation() throws InterruptedException {
        
    	utils.waitForElementToBeVisiblewithFluentWait(inpSubClassID,5);
        strSubClassId = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpSubClassID);
        System.out.println("Textbox value: " + strSubClassId);
        return strSubClassId;
    }

    //Method
    public String getsubclassNameValidation() throws InterruptedException {
    	utils.waitForElementToBeVisiblewithFluentWait(inpSubClassName,5);
        strsubclassNameVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpSubClassName);
        System.out.println("Textbox value: " + strsubclassNameVal);
        return strsubclassNameVal;
    }

    public void applyClassFilter(String ClassData) throws InterruptedException {
        if (ClassData.isEmpty()) {
            System.out.println("Ignoring BusinessUnit filter");
        } else {
            Thread.sleep(2000);
            utils.clickElementWithJavaScript(filtersVale_classId);
            filterValue_Classsearch.sendKeys(ClassData);
            Thread.sleep(1500);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            actions.sendKeys(Keys.ENTER).build().perform();
        }
    }
	public void clickSubClassTab() {
		try {
			utils.clickOnWebElement(subClass);

		} catch (Exception e) {
			// logReportMessageAndTakeScreenShot("Open Failed - " + "");

		}
	}

	public String txt_searchcount() {
		try {
			String count = subclass_Count.getText();
			return count;
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

	public boolean checkcountequalsto1() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), subclass_Count);
			String count = subclass_Count.getText();
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

	public String txt_viewsubclassID() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_subclassID);
			String txtsubclassid = gridview_subclassID.getText();
			return txtsubclassid;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String txt_viewsubclassname() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_subclassname);
			String txtsubclassname = gridview_subclassname.getText();
			return txtsubclassname;
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
			utils.waitForElementToBeClickablewithFluentWait(edit_btn, 10);
			edit_btn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getsubclassID() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_subclassID);
			// String txtformBUID=formview_businessunitID.getText();
			String formBUID = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					formview_subclassID);
			return formBUID;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getsubclassName() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_subclassname);
			// String txtformBUID=formview_businessunitID.getText();
			String formBU_Name = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					formview_subclassname);
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

	public void setsubclassName(String Buname) {
		try {
			formview_subclassname.click();
			formview_subclassname.clear();
			formview_subclassname.sendKeys(Buname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void click_cancelitemtype() {
		// utils.waitForElementclickable(Duration.ofSeconds(10),
		// formview_cancelbutton_rp);
		utils.waitForElementToBeVisiblewithFluentWait(formview_cancelbutton_itemtype, 5);
		formview_cancelbutton_itemtype.click();
	}

	public void selectStatus(String strstatus) {
		utils.waitForElementclickable(Duration.ofSeconds(10), formviewgettext_status);
		// utils.waitForElementVisibilityFor(Duration.ofSeconds(10),
		// formviewgettext_status);
		formviewgettext_status.click();
		utils.comoboxlist(combostatus, strstatus);
	}

	public void click_yesbutton() {
		utils.waitForElementclickable(Duration.ofSeconds(10), Yes_button);
		Yes_button.click();
	}

	public void click_nobutton() {
		utils.waitForElementclickable(Duration.ofSeconds(10), No_button);
		No_button.click();
	}

	public boolean verifydeleteoption() {
		try {
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10),
			// formview_delete_btn);
			utils.waitForElementclickable(Duration.ofSeconds(10), formview_delete_btn);
			boolean deleteoption = formview_delete_btn.isDisplayed();
			return deleteoption;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyFormsubclass() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_subclassname);
			// utils.waitForElementclickable(Duration.ofSeconds(10), formview_delete_btn);
			boolean formsubclass = formview_subclassname.isDisplayed();
			System.out.println(formsubclass);
			return formsubclass;
		} catch (Exception e) {
			return false;
		}
	}

	public void click_cancelrp() {
		utils.waitForElementToBeVisiblewithFluentWait(formview_cancelbutton_rp, 5);
		formview_cancelbutton_rp.click();
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

	public String succeessmsgdispalyed() {
		try {
			String msg = Success_msg.getText();
			return msg;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public boolean cancelmsgdisplayed() {
		try {

			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Cancel_msg);
			boolean value = utils.doesElementExist(Cancel_msg);
			return value;
			/*
			 * utils.waitForElementVisibilityFor(Duration.ofSeconds(20), Cancel_msg); String
			 * msg= Cancel_msg.getText(); System.out.println(msg); return msg;
			 */
		} catch (Exception e) {
			return false;
			/*
			 * return (e.getMessage());
			 */
		}
	}

	public boolean Viewsubclasspagedisplayed() {
		try {

			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), txt_viewpage);
			boolean value = utils.doesElementExist(txt_viewpage);
			return value;

		} catch (Exception e) {
			return false;

		}
	}

	public String getsubclssID() {
		try {
			return strSubClassId;
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

	public String GetSubclassValue() { // Getting the SubClass ID and name

		if (strSubClassId != null || !strSubClassId.isEmpty()) {
			return strSubClassId;
		} else {
			return strsubclassNameVal;
		}

	}

	public void entersearchbox(String subclassId) { // Sending the SubClass value to the search box
		try {
			// utils.waitForElementclickable(Duration.ofSeconds(10), searchbox);
			utils.waitForElementToBeClickablewithFluentWait(searchbox, 10);
			searchbox.clear();
			searchbox.sendKeys(subclassId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addSubClassButtonSave()
	
	{
		utils.waitForElementclickable(Duration.ofSeconds(60), btnAddSubClass);
		utils.btnSavebutton(btnAddSubClass,btnSave);
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
			Thread.sleep(3000); // Hard wait cannot be removed because of the perofrmance issue.
		} else {
			System.out.println("count is not equals to 1, so editing the record can't be performed");
		}
	}

	public void UpdateDiv_Name(String SubClass_Value) { // Updating the SubClass name
		if (verifyFormsubclass()) {
			if (SubClass_Value.length() <= 40) {
				String strTimeStamp = utils.getSystemDate();
				String strTimeStamps = strTimeStamp.replace("_", "");
				String inpEnterBuNames = SubClass_Value + strTimeStamps;
				setsubclassName(inpEnterBuNames);
			} else {
				String strTimeStamp = utils.getSystemDate();
				String strTimeStamps = strTimeStamp.replace("_", "");
				String inpEnterBuNames = "subclass" + strTimeStamps + strTimeStamps;
				setsubclassName(inpEnterBuNames);
			}
		}

		else {
			System.out.println("Form View Business_unit_name returned as empty");
		}
	}

	public void selectReportingCategory(String strReportingCategory) { // Updating the Reporting Category
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
			System.out.println("Item Type is empty");
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
			valuesToAdd = Arrays.asList(txt_viewsubclassID(), txt_viewsubclassname(), txt_viewreportingcategory(),
					txt_viewstatus());
			// System.out.println(valuesToAdd);
			valuesToAdd.forEach(valuesToAdd -> System.out.println("view page:" + valuesToAdd));
			utils.addvalue(valuesToAdd);
		} else {
			System.out.println("count is not equals to 1");
		}
	}

	public void getformpagevalues() { // Getting the form page field values to compare
		if (verifyFormsubclass()) {
			// utils.getvalues();
			formvalues = new ArrayList<>();

			formvalues.add(getsubclassID());
			formvalues.add(getsubclassName());
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
