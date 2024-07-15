package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import utilities.GenericUtilities;

public class MerchandiseBusinessUnitPage extends BasePage {
	// WebDriverWait wait;
	// WebDriver driver;
	WebDriverWait wait;
	String formBU_Name, status;

	List<String> valuesToAdd;
	ArrayList<String> formvalues;
	String BuID;
	public static String inpEnterBuNames;
	public static String Buname;

	MerchandisePage BU_HomePage = new MerchandisePage(BaseClass.getDriver());

	public MerchandiseBusinessUnitPage(WebDriver driver) {
		super(driver);
	}

	GenericUtilities utils = new GenericUtilities(driver);
	@FindBy(xpath = "//span[text()='Filters']")
	WebElement filterBtn;

	@FindBy(xpath = "//span[text()='Apply']")
	WebElement applyBtn;

	@FindBy(xpath = "//span[text()='Reset']")
	WebElement resetBtn;

	@FindBy(xpath = "//div[text()='Select Alternate Hierarchy']")
	WebElement filtersVale_alternateHierarhcy;

	@FindBy(xpath = "//div[@id='accountableName']")
	WebElement filtersVale_accountableName;

	@FindBy(xpath = "//div[@id='responsible']")
	WebElement filtersVale_responsible;

	@FindBy(xpath = "//span[@aria-label='Select Reporting Category']")
	WebElement filtersVale_reportCategory;

	@FindBy(xpath = "//span[@aria-label='Active' or @aria-label='Select Status']")
	WebElement filtersVale_isActive;

	@FindBy(xpath = "//p-paginator/div/span[contains(text(), ' of ')]")
	WebElement totalRecords;

	@FindBy(xpath = "//span[text()='Confirmation']")
	WebElement confirmation;

	@FindBy(xpath = "//Button/span[text()='Yes']")
	WebElement confirmation_Yes;
	@FindBy(xpath = "//Button/span[text()='No']")
	WebElement confirmation_No;

	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> alterNativeCheckbxo;
	
	// Vinay updated xpaths
	// edit xpaths
    @FindBy(xpath="//input[@placeholder='Business Unit ID Or Business Unit Name']")
	WebElement searchbox;
	//@FindBy(xpath="//span[@class='p-button-icon pi pi-search']")
	@FindBy(xpath="//button[@type='button' and @icon='pi pi-search']")
	WebElement search_btn;
	@FindBy(xpath="//div[@class='grid align-items-center']//span[contains(text(),' 1 ')]")
	WebElement BusinessUnit_Count;
	@FindBy(xpath="//tbody[@role='rowgroup']/tr/td[1]")
	WebElement gridview_businessunitID;
	@FindBy(xpath="//tbody[@role='rowgroup']/tr/td[2]")
	WebElement gridview_businessunitname;
	@FindBy(xpath="//tbody[@role='rowgroup']/tr/td[5]")
	WebElement gridview_Reportingcategory;
	@FindBy(xpath="//tbody[@role='rowgroup']/tr/td[7]")
	WebElement gridview_status;
	@FindBy(xpath="//span[@class='pi pi-ellipsis-v p-button-icon ng-star-inserted']")
	WebElement threedots;
	@FindBy(xpath="//a[@class='p-ripple p-element p-menuitem-link ng-star-inserted']//span[text()='Edit']")
	WebElement edit_btn;
	@FindBy(xpath="//input[@formcontrolname='businessUnitId']")
	WebElement formview_businessunitID;
	@FindBy(xpath="//input[@formcontrolname='businessUnitName']")
	WebElement formview_businessunitname;
	@FindBy(xpath="//div[@id='reportingCategory']/span")
	WebElement formview_Reportingcategory;
	@FindBy(xpath="//div[@id='reportingCategory']//span")
	WebElement formviewgettext_rp;
	@FindBy(xpath="//*[@class='p-dropdown-clear-icon p-icon']")
	WebElement formview_cancelbutton_rp;
	@FindBy(xpath="//ul[@role='listbox']//li/span")
	List <WebElement> comboReporting;
	@FindBy(xpath="//div[@class='p-element p-multiselect-label-container']")
	WebElement formview_AlternateHierarchy;
	@FindBy(xpath="//ul[@role='listbox']//li/span")
	List <WebElement> comboAlternateHierarchy;
	@FindBy(xpath="//div[@id='status']//span")
	WebElement formviewgettext_status;
	@FindBy(xpath="//ul[@role='listbox']//li/span")
	List <WebElement> combostatus;
	@FindBy(xpath="//span[text()='Save']")
	WebElement formview_Save_btn;
	@FindBy(xpath="//span[text()='Cancel']")
	WebElement formview_Cancel_btn;
	@FindBy(xpath="//span[text()='Delete']")
	WebElement formview_delete_btn;
	@FindBy(xpath="//h2[contains(text(),'Business Unit')]")
	WebElement FormView_BU;
	@FindBy(xpath="//span[text()='Yes']")
	WebElement Yes_button;
	@FindBy(xpath="//span[text()='No']")
	WebElement No_button;
	@FindBy(xpath="//div[@data-pc-section='detail']")
	WebElement Success_msg;
	@FindBy(xpath="//span[contains(text(),'Are you sure')]")
	WebElement Cancel_msg;
	@FindBy(xpath="//h2[contains(text(),'View Business Unit')]")
	WebElement txt_viewpage;
	//delete xpaths
	@FindBy(xpath="//i[@class='pi pi-times']")
	WebElement cancel_searchbtn;
	@FindBy(xpath="//a[@class='p-ripple p-element p-menuitem-link ng-star-inserted']//span[text()='Delete']")
	WebElement Delete_btn;
	@FindBy(xpath="//div[contains(text(),'Record Deleted Successfully')]")
	WebElement Delete_msg;
	@FindBy(xpath="//*[contains(text(),'Deleting with id')]")
	WebElement HierarchyexistAlert_msg;
	@FindBy(xpath="//div[@data-pc-section='detail']")
	WebElement txt_postclickondelete_msg;

	@FindBy(xpath="//span[contains(text(),'No Records Found')]")
	WebElement Norecord_msg;
	
	// end of vinay xpaths
	@FindBy(xpath = "//p-columnfilter//button[@aria-label='Clear']")
	private List<WebElement> clearButtons;

	private String initial_record, Reset_Record, Final_Record;
	
	
	public void clickVisibleClearButtons() {		
	    for (WebElement button : clearButtons) {
	        if (button.isDisplayed() && button.isEnabled()) {
	            try {
	                Thread.sleep(6000);
	                // Move to the button and click it
	                new Actions(driver).moveToElement(button).click().perform();
	            } catch (Exception e) {
	                System.out.println("Error clicking button: " + e.getMessage());
	            }
	        }
	    }
	}
	
	public void recordInitialFilterCount() {
		String toatlRecodstext = totalRecords.getText();
		String[] parts = toatlRecodstext.split(" ");

		String value1 = parts[2]; // "10"
		String value2 = parts[4]; // "85"
		//initial_record = totalRecords.getText();
		initial_record = value2;
		System.out.print(initial_record);
	}
	
	public void clickOnFilter() throws InterruptedException {
		//utils.clickOnWebElement(filterBtn);
		
		Thread.sleep(1000);
		
		//utils.clickElementWithJavaScript(filterBtn);
		utils.clickOnWebElement(filterBtn);
	}



	public void selectAccountableFilter(String Accountable) throws InterruptedException {
		if (Accountable.isEmpty()) {
			System.out.println("Ignoring Accountable filter");
		} else {
			clickVisibleClearButtons();
			recordInitialFilterCount();
			utils.waitForElementToBeClickablewithFluentWait(filtersVale_accountableName, 10);
			utils.selectAndSearchDropdown(filtersVale_accountableName,
					By.xpath("//li[@aria-label='" + Accountable + "']"), Accountable);
			validateFilterAfterApply();
		}
	}

	public void selectResponsibleFilter(String Responsible) throws InterruptedException {

		if (!Responsible.isEmpty()) {
			utils.waitForElementToBeClickablewithFluentWait(filtersVale_responsible, 10);
			clickVisibleClearButtons();
			recordInitialFilterCount();
			Thread.sleep(2000);
			filtersVale_responsible.click();
			String[] ResponsibleValues = Responsible.split(",");
			for (String responsible : ResponsibleValues) {
				// Trim any leading/trailing spaces
				responsible = responsible.trim();
				if (!responsible.isEmpty()) {
					utils.retryingFindClick(By.xpath("//li/span[contains(.,'" + Responsible + "']"));
					Thread.sleep(500);
				}
			}
			validateFilterAfterApply();
		} else {
			System.out.println("Ignoring Responsible Filter");
		}

	}

	public void selectReportingCategoryFilter(String Reporting_Category) throws InterruptedException {
		if (Reporting_Category.isEmpty()) {
			System.out.println("Ignoring Reporting Category filter");
		} else {
			clickVisibleClearButtons();
			recordInitialFilterCount();
			Thread.sleep(3000);
			utils.waitForElementToBeClickablewithFluentWait(filtersVale_reportCategory, 10);
			utils.selectAndSearchDropdown(filtersVale_reportCategory,
					By.xpath("//li[@aria-label='" + Reporting_Category + "']"), Reporting_Category);
			validateFilterAfterApply();
		}
	}

	public void selectAlternateHierarchyFilter(String Alternate_Hierarchy) throws InterruptedException {
		if (!Alternate_Hierarchy.isEmpty()) {
			clickVisibleClearButtons();
			recordInitialFilterCount();
			Thread.sleep(2000);
			filtersVale_alternateHierarhcy.click();
			String[] hierarchyValues = Alternate_Hierarchy.split(",");
			for (String hierarchy : hierarchyValues) {
				// Trim any leading/trailing spaces
				hierarchy = hierarchy.trim();
				if (!hierarchy.isEmpty()) {
					utils.retryingFindClick(By.xpath("//li[@aria-label='" + hierarchy + "']"));
					Thread.sleep(500);
				}
			}
			validateFilterAfterApply();
		} else {
			System.out.println("Ignoring Alt Hierarchy");
		}
	}

	public void selectStatusFilter(String Status) throws InterruptedException {
		if (Status.isEmpty()) {
			System.out.println("Ignoring Status filter");
		} else {
			clickVisibleClearButtons();
			recordInitialFilterCount();
			utils.waitForElementToBeClickablewithFluentWait(filtersVale_isActive, 10);
			utils.selectAndSearchDropdown(filtersVale_isActive, By.xpath("//li[@aria-label='" + Status + "']"), Status);
			validateFilterAfterApply();
		}
	}

	public void applyFilter() throws InterruptedException {
		Thread.sleep(2000);
		utils.clickOnWebElement(applyBtn);
		Thread.sleep(1500);

	}

	public void validateFilterAfterApply() throws InterruptedException {
		Thread.sleep(8000);
		Final_Record = totalRecords.getText();
		if (initial_record.equals(Final_Record)) {
			System.out.println("Filter not Applied");
		} else {
			System.out.println("Filter Applied");
		}
	}

	public void validateResetNoFilter() throws InterruptedException {
		utils.clickOnWebElement(resetBtn);
		Thread.sleep(1000);

		if (confirmation.isDisplayed()) {
			confirmation_No.click();
		}
	}

	public void validateResetFilter() throws InterruptedException {
		Thread.sleep(2000);
		utils.clickOnWebElement(resetBtn);
		//utils.clickOnWebElement(filterBtn);
		Thread.sleep(3000);
		if (confirmation.isDisplayed()) {
			confirmation_Yes.click();
		}
		Thread.sleep(10000); // Hard wait cannot be removed because of the performance issue.
		//utils.clickOnWebElement(filterBtn);
		Reset_Record = totalRecords.getText();
		System.out.println(initial_record + "," + Final_Record + "," + Reset_Record);
		if (initial_record.equals(Reset_Record)) {
			System.out.println("Reset Applied : initial_record=" + initial_record + " After Filer=" + Final_Record
					+ " After Reset: " + Reset_Record);
		} else {
			System.out.println("Filter not Applied");
		}
	}
	
	// vinay code--
	
	// edit methods

	
	public String txt_searchcount()
	{
		try
		{
		String count = BusinessUnit_Count.getText();
		return count;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public boolean checkcountequalsto1()
	{
		try
		{
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), BusinessUnit_Count);
		String count = BusinessUnit_Count.getText();
		System.out.println(count);
		String  value= "1";
		
		if(count.equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		}
		
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	public String txt_viewBusinessID()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_businessunitID);
		String txtBuid = gridview_businessunitID.getText();
		return txtBuid;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String txt_viewBusinessname()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_businessunitname);
		String txtBuname = gridview_businessunitname.getText();
		return txtBuname;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String txt_viewreportingcategory()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_Reportingcategory);	
		String txtrp = gridview_Reportingcategory.getText();
		return txtrp;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String txt_viewstatus()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_status);	
		String txtstatus = gridview_status.getText();
		return txtstatus;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void click_threedots()
	{
		try
		{
			//utils.waitForElementclickable(Duration.ofSeconds(10), threedots);
			utils.waitForElementToBeClickablewithFluentWait(threedots, 10);
			threedots.click();
	    }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void click_edit_btn()
	{
		try
		{
			//utils.waitForElementclickable(Duration.ofSeconds(10), edit_btn);
			utils.waitForElementToBeClickablewithFluentWait(edit_btn, 10);
			edit_btn.click();
	    }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getBuID()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_businessunitID);	
		//utils.waitForElementToBeVisiblewithFluentWait(formview_businessunitID, 5);
		//String txtformBUID=formview_businessunitID.getText();
		String formBUID = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", formview_businessunitID);
		return formBUID;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String getBuName()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_businessunitname);	
		//utils.waitForElementToBeVisiblewithFluentWait(formview_businessunitname, 5);
		//String txtformBUID=formview_businessunitID.getText();
		String formBU_Name = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", formview_businessunitname);
		return formBU_Name;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String getrp()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formviewgettext_rp);	
		//utils.waitForElementToBeVisiblewithFluentWait(formviewgettext_rp, 5);
		String formrp =formviewgettext_rp.getText();
		return formrp;
		
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String getstatus()
	{
		try {
		utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formviewgettext_status);	
		//utils.waitForElementToBeVisiblewithFluentWait(formviewgettext_status, 5);
		String formrp =formviewgettext_status.getText();
		return formrp;
		
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void setBuName(String Buname)
	{
		try 
		{
		//utils.waitForElementToBeClickablewithFluentWait(formview_businessunitname, 5);	
		formview_businessunitname.click();
		formview_businessunitname.clear();
		formview_businessunitname.sendKeys(Buname);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	  public void selectStatus(String strstatus)
	  {
		  utils.waitForElementclickable(Duration.ofSeconds(10), formviewgettext_status); 
		 // utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formviewgettext_status);
		  formviewgettext_status.click();
		  utils.comoboxlist(combostatus,strstatus);
	  }
	  
	  public void click_yesbutton() throws InterruptedException
	  {
		  //utils.waitForElementclickable(Duration.ofSeconds(10), Yes_button);
		  utils.waitForElementToBeClickablewithFluentWait(Yes_button, 5);	
		  Yes_button.click();
		  //Thread.sleep(3000);
	  }
	  
	  public void click_nobutton()
	  {
		  utils.waitForElementclickable(Duration.ofSeconds(10), No_button);
		  No_button.click();
	  }
	  
	  public boolean verifydeleteoption()
	  {
		  try
		  {
			 //utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_delete_btn); 
			 utils.waitForElementclickable(Duration.ofSeconds(10), formview_delete_btn);
		     boolean deleteoption= formview_delete_btn.isDisplayed();
		     return deleteoption;
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
	  }
	  
	  public boolean verifyFormBU()
	  {
		  try
		  {
			 //utils.waitForElementVisibilityFor(Duration.ofSeconds(10), FormView_BU); 
			 utils.waitForElementclickable(Duration.ofSeconds(10), formview_businessunitname);
		    // boolean formBU= FormView_BU.isDisplayed();
			 boolean formBU= formview_businessunitname.isEnabled();
		     System.out.println(formBU);
		     return formBU;
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
	  }
	  
	  public void click_cancelrp()
	  {
		  //utils.waitForElementclickable(Duration.ofSeconds(10), formview_cancelbutton_rp);
		  utils.waitForElementToBeVisiblewithFluentWait(formview_cancelbutton_rp, 5);
		  formview_cancelbutton_rp.click();
	  }
	  
	  
	  public void click_cancelbtn()
	  {
		  utils.waitForElementclickable(Duration.ofSeconds(10), formview_Cancel_btn);
		  formview_Cancel_btn.click();
	  }
	  
	  public String succeessmsgdispalyed()
	  {
		  try 
		  {
		  //utils.waitForElementToBeVisiblewithFluentWait(Success_msg, 2);  
		  utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Success_msg);
		  String msg=Success_msg.getText();
		  return msg;
		  }
		  catch(Exception e)
		  {
			  return (e.getMessage());
		  }
	  }
	  
	  public boolean cancelmsgdisplayed()
	  {
		  try {
			 utils.waitForElementToBeVisiblewithFluentWait(Cancel_msg, 10);   
			 //utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Cancel_msg);
			 boolean value= utils.doesElementExist(Cancel_msg);
			 return value;
			/*  utils.waitForElementVisibilityFor(Duration.ofSeconds(20), Cancel_msg);
			  String msg= Cancel_msg.getText();
			  System.out.println(msg);
			  return msg;*/
		  }
		  catch(Exception e)
		  {
			  return false;
			  /*
			  return (e.getMessage());
			  */
		  }
	  }
	  
	  public boolean ViewBUpagedisplayed()
	  {
		  try {
			  
			 utils.waitForElementVisibilityFor(Duration.ofSeconds(10), txt_viewpage);
			 boolean value= utils.doesElementExist(txt_viewpage);
			 return value;
			
		  }
		  catch(Exception e)
		  {
			  return false;
			 
		  }
	  }
	  
	  public boolean DeleteButtonDisplayed()
	  {
		  try {
			  utils.waitForElementclickable(Duration.ofSeconds(10), Delete_btn);
			 //utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Delete_btn);
			 boolean value= utils.doesElementExist(Delete_btn);
			 return value;
			
		  }
		  catch(Exception e)
		  {
			  return false;
			 
		  }
	  }
	  
	  public void click_deletebtn()
		{
			try
			{
				//utils.waitForElementVisibilityFor(Duration.ofSeconds(10), threedots);
				utils.waitForElementclickable(Duration.ofSeconds(10), Delete_btn);
				Delete_btn.click();
		    }
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	  
	  public boolean Successfullydeletedmsgdisplayed()
	  {
		  try {
			  
			 utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Delete_msg);
			 boolean value= utils.doesElementExist(Delete_msg);
			 return value;
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
	  }
	  
	  public boolean HierarchyexistAlertmsgdisplayed()
	  {
		  try {
			  
			 utils.waitForElementVisibilityFor(Duration.ofSeconds(10), HierarchyexistAlert_msg);
			 boolean value= utils.doesElementExist(HierarchyexistAlert_msg);
			 return value;
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
	  }
	  
	  public boolean Norecordsmsgdisplayed()
	  {
		  try {
			  
			 utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Norecord_msg);
			 boolean value= utils.doesElementExist(Norecord_msg);
			 return value;
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
	  }
	  
	  public boolean getmessage()
	  {
		  try
		  {
		  utils.waitForElementLocated(Duration.ofSeconds(10), txt_postclickondelete_msg);
		  String message = txt_postclickondelete_msg.getText();
		  System.out.println(message);
		  String expectedvalue= "Record Deleted Successfully";
		  if(message.equals(expectedvalue))
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		  }
		  catch(Exception e)
		  {
			  return (false);
		  }
	  }
	  
	  public boolean deletemessage()
	  {
		  try
		  {
		
		  utils.waitForElementLocated(Duration.ofSeconds(2), Delete_msg);
		  boolean message = Delete_msg.isDisplayed();
		  System.out.println(message);
		  if(message==true)
		  {
		  return true;
		  }
		  else
		  {
			  return false;
		  }
		  }
		  catch(Exception e)
		  {
			  return (false);
		  }
	  }
	  
	  public void click_cancelsearchedbtn()
		{
			try
			{
				//utils.waitForElementVisibilityFor(Duration.ofSeconds(10), threedots);
				utils.waitForElementclickable(Duration.ofSeconds(10), cancel_searchbtn);
				cancel_searchbtn.click();
		    }
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	
	// end by vinay code 

	// New Methods for edit and delete records

		public String GetBUValue() { // Getting the Busineess unit ID and name
			BuID = BU_HomePage.strBusinessUnits;
			System.out.println(BuID);
			Buname = BU_HomePage.strBuNameVal;
			System.out.println(Buname);

			/*
			 * if (BuID != null || !BuID.isEmpty()) { return BuID; } else { return Buname; }
			 */
			return Buname;
		}

		public void entersearchbox(String BuId) { // Sending the Busineess unit value to the search box
			try {
				// utils.waitForElementclickable(Duration.ofSeconds(10), searchbox);
				utils.waitForElementToBeClickablewithFluentWait(searchbox, 10);
				// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), searchbox);
				searchbox.clear();
				searchbox.sendKeys(BuId);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void click_searchbtn() { // selecting the search button for the value entered in the search box
			try {
				// utils.waitForElementToBeClickablewithFluentWait(search_btn, 10);
				utils.waitForElementclickable(Duration.ofSeconds(10), search_btn);
				// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				// search_btn);
				utils.clickOnWebElement(search_btn);
				// Thread.sleep(5000);
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

		public void UpdateBU_Name(String BusinessUnit) { // Updating the Bussiness unit name
			if (verifyFormBU()) {
				if (BusinessUnit.length() <= 40) {
					String strTimeStamp = utils.getSystemDate();
					String strTimeStamps = strTimeStamp.replace("_", "");
					inpEnterBuNames = BusinessUnit + strTimeStamps;
					setBuName(inpEnterBuNames);
				} else {
					String strTimeStamp = utils.getSystemDate();
					String strTimeStamps = strTimeStamp.replace("_", "");
					inpEnterBuNames = "BU" + strTimeStamps + strTimeStamps;
					setBuName(inpEnterBuNames);
				}
			}

			else {
				System.out.println("Form View Business_unit_name returned as empty");
			}
		}

		// update RC With click on cancel RC button
		// update AC

		public void selectReportingCategory(String strReportingCategory) { // updating the Reporting category
			if (strReportingCategory.isEmpty()) {
				System.out.println("Reporting category is empty");
			} else {
				click_cancelrp();
				utils.waitForElementclickable(Duration.ofSeconds(10), formview_Reportingcategory);
				// utils.waitForElementToBeClickablewithFluentWait(formview_Reportingcategory,
				// 5);
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
				// utils.waitForElementToBeClickablewithFluentWait(formview_AlternateHierarchy,
				// 5);
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
				valuesToAdd = Arrays.asList(txt_viewBusinessID(), txt_viewBusinessname(), txt_viewreportingcategory(),
						txt_viewstatus());
				// System.out.println(valuesToAdd);
				valuesToAdd.forEach(valuesToAdd -> System.out.println("view page:" + valuesToAdd));
				utils.addvalue(valuesToAdd);
			} else {
				System.out.println("count is not equals to 1");
			}
		}

		public void getformpagevalues() { // Getting the form page field values to compare
			if (verifyFormBU()) {
				// utils.getvalues();
				formvalues = new ArrayList<>();

				formvalues.add(getBuID());
				formvalues.add(getBuName());
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

		public void searchwithupdatedBUname() { // Searching with Updated Business unit name
			try {
				// utils.waitForElementclickable(Duration.ofSeconds(10), searchbox);
				utils.waitForElementToBeClickablewithFluentWait(searchbox, 10);
				// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), searchbox);
				searchbox.clear();
				searchbox.sendKeys(inpEnterBuNames);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// click save

		public void click_savebtn() throws InterruptedException { // selecting on save button
			// utils.waitForElementToBeClickablewithFluentWait(formview_Save_btn, 10);
			utils.waitForElementclickable(Duration.ofSeconds(10), formview_Save_btn);
			utils.clickOnWebElement(formview_Save_btn);
			// formview_Save_btn.click();
			// Thread.sleep(3000);
		}

		public void ClickDelete() throws InterruptedException { // selecting on delete button
			if (checkcountequalsto1()) {
				click_threedots();
				click_deletebtn();
				click_yesbutton();
			} else {
				Assert.fail("count is not 1");
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