package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.regex.PatternSyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import utilities.GenericUtilities;

public class MerchandisePage extends BasePage {
	// WebDriverWait wait;
	// WebDriver driver;
	WebDriverWait wait;

	public static final String inpEnterBuName = "";

	public static String strBusinessUnits;

	public static String strBuNameVal;

	public static String strDivId;
	public static String strDivameVal;


	public MerchandisePage(WebDriver driver) {
		super(driver);

	}
	
	

	GenericUtilities utils = new GenericUtilities(driver);

	MerchandiseDivisionPage MndivisionPage;

	// @FindBy(xpath = "//a[text()=' Merchandise Hierarchy ']") // Home Page heading
	// WebElement msgHeading;

	@FindBy(xpath = "//*[contains(text(),'View Business Unit')]") // Home Page heading
	WebElement msgHeading;

	@FindBy(xpath = "//span[contains(text(),'Add Business Unit')]") // Business unit button
	WebElement eleBusinessUnit;

	@FindBy(xpath = "//input[@id='businessUnitId']") // Business unit field
	WebElement inpBusinessUnit;

	@FindBy(xpath = "//input[@id='businessUnitName']") // Business unit name
	WebElement inBusinessUnitName;

	//@FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext p-placeholder ng-star-inserted'])[1]") // Reporting
	@FindBy(xpath = "//div[@id='reportingCategory']") // Reporting																												// Category
	WebElement combReportingCategory;
	
	
	//span[@aria-label='Select']
	
	@FindBy(xpath="//input[@type='text' and @aria-owns='reportingCategory_list']")
	WebElement inputbReportingCategory;
	
	@FindBy(xpath="//li[@id='reportingCategory_0']")
	WebElement selReportingCategory;
		
	@FindBy(xpath="//div[@id='companyDropdown']")
	WebElement clickCompany;
	

	// span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']
	// div[@id='itemTypeId']
	@FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext p-placeholder ng-star-inserted'])[3]")
	WebElement comboItemType;

	@FindBy(xpath = "//label[@for='itemTypeId']//following::span[1]")
	WebElement btnItemType;

	// @FindBy(xpath = "//span[text()='Save']") // saves
// btnSave;

	// @FindBy(xpath = "//span[text()='Save and Continue']") // save continue
	// WebElement btnSaveAndContiue;

	@FindBy(xpath = "//span[text()='Invalid data entered. Please review.']") // error
	WebElement msgErrorDuplcate;

	@FindBy(xpath = "//*[contains(text(),'This field is required.')]")
	WebElement msgErroMessageRequired;

	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement comboReporting;

	// @FindBy(xpath="//span[@class='ng-star-inserted']")
	// WebElement comboReporting1;
	// List <WebElement> comboReporting1;
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> comboReporting1;

	//@FindBy(xpath = "//span[@class='ng-star-inserted']")
	@FindBy(xpath = "//div[@class='p-checkbox p-component']")
	List<WebElement> alterNativeCheckbxo;

	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> ItemType;

	@FindBy(xpath = "//div[@class='p-element p-multiselect-label-container']")
	// @FindBy(xpath="//*[@id='alternateHierarchy']/div[2]")
	WebElement alterNativeHierarchy;

	// @FindBy(xpath="//span[@role='combobox' and @aria-label='Active']")
	// WebElement statusDropDwn;

	@FindBy(xpath = "(//span[contains(text(),'Save and Next')])[1]")
	WebElement btnSaveContimue;

	@FindBy(xpath = "(//span[@class='p-button-label ng-star-inserted'])[2]")
	WebElement Division;

	@FindBy(xpath = "(//span[@class='p-button-label ng-star-inserted'])[1]")
	WebElement BUUnit;

	@FindBy(xpath = "//*[contains(text(),' View Division')]")
	WebElement Divisionview;

	
	// unit
	@FindBy(xpath = "//button[contains(text(),' Add Division ')]")
	// @FindBy(xpath="//button[@class='p-ripple p-element p-button p-component' and
	// text()=' Add Business Unit ']");
	WebElement btnAddDiviUnit;

	// @FindBy(xpath = "//h2[@class='text-primary font-semibold text-lg uppercase
	// m-0']") // Home Page heading
	@FindBy(xpath = "//div[@class='p-element p-multiselect-label-container']")
	WebElement viewDivisionPage;

	@FindBy(xpath = "//*[contains(text(),'Record saved successfully.')]")
	WebElement msgSaveSuccessMessage;

	// @FindBy(xpath="//span[@role='combobox' and
	// @aria-controls='businessUnit_list']")

	// WebElement drpDwnBusinessUnit;

	@FindBy(xpath = "//div[@id='businessUnit']")
	WebElement drpDwnBusinessUnit;

	@FindBy(xpath = "//div[@id='reportingCategory']")
	WebElement drpDwnReporting;

	// (//span[@class='p-element p-dropdown-label p-inputtext p-placeholder
	// ng-star-inserted'])[1]

	@FindBy(xpath = "//input[@id='divisionId']")
	WebElement autoDivisionId;

	@FindBy(xpath = "//input[@id='divisionName']")
	WebElement inpdivisionName;

	// @FindBy(xpath="//span[@class='ng-star-inserted']")
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> comboBusineeUnit;

	@FindBy(xpath = "//input[@id='divisionName']//preceding::span[@role='combobox']")
	WebElement checkDropval;

	@FindBy(xpath = "//input[@id='divisionId']") // Business unit field
	WebElement inpDivisionUnit;

	@FindBy(xpath = "//div[@class='p-element p-multiselect-label-container']")
	WebElement alterNativeHierarch;

	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> alterNateCheckbox;

	@FindBy(xpath = "//span[@role='combobox' and @aria-label='Active']")
	WebElement statusDropDwn;

	// @FindBy(xpath = "//span[text()='Save and Continue']") // save continue
	// WebElement btnSaveAndContiue;
	@FindBy(xpath = "(//*[@type='button'])[9]")
	WebElement btnSaveAndContiue;

	@FindBy(xpath = "(//span[contains(text(),'Save')])[2]")
	WebElement btnSave;

	@FindBy(xpath = "//span[normalize-space()='Continue']")
	WebElement continuebtn;

	// end

	@FindBy(xpath = "//*[contains(text(),'Foundation data')]")
	WebElement founddationdatamenu;
	

	

	@FindBy(xpath = "//*[contains(text(),'Merchandise Hierarchy')]")
	WebElement merchandiseMenu;

	@FindBy(xpath = "//input[@placeholder='Business Unit ID Or Business Unit Name']")
	WebElement BUSearch;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> ViewGrid;

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-search']")
	WebElement SearchIcon;

	@FindBy(xpath = "//div[@class='p-datatable-wrapper']")
	WebElement table;

	@FindAll(@FindBy(tagName = "tr"))
	List<WebElement> tableRow;
	// @FindBy(tagName="td")
	// List<WebElement> tableCol;

	@FindAll(@FindBy(tagName = "td"))
	List<WebElement> tableCol;

	@FindBy(xpath = "//span[contains(text(), 'No Records Found')]")
	WebElement NoRecordsFound;
	@FindBy(xpath = "//input[@id='businessUnitName']")
	WebElement BUNames;
	
	//@FindBy(xpath = "//input[@type='checkbox']//..//..//..//..//li[@aria-label='" + value + "']");
	 //WebElement alterNateXapth;
	 

	public boolean ismerchandisePageExists() //
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickonBUUNitTab() {

		// Click on BU Unit
		utils.clickOnWebElement(BUUnit);
	}

	public void clickMerchandiseMenu() {

		utils.waitForElementToBeClickablewithFluentWait(founddationdatamenu, 5);

		utils.clickOnWebElement(founddationdatamenu);

		utils.waitForElementToBeClickablewithFluentWait(merchandiseMenu, 5);

		utils.clickOnWebElement(merchandiseMenu);

	}

	public void clickOnSaveContinueButton() throws InterruptedException {
		
		utils.waitForElementToBeClickablewithFluentWait(btnSaveContimue, 5);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnSaveContimue);

	}

	public static void clickOn(WebDriver driver, WebElement element, Duration timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void addBUButtonSave() throws InterruptedException {
    	
				
    	utils.btnSavebutton(eleBusinessUnit,btnSave);
    	
    }
	 public void BuerrormessageValiations()
	    {
	    	utils.verifyRequiredFieldErrorCount(1);
	    }
	public void clickBusinessUNit() throws InterruptedException

	{

		Thread.sleep(7000);
		//utils.waitForpresenseofElementLocated(Duration.ofSeconds(100),inpBusinessUnit);
		
		utils.waitForElementToBeClicks(eleBusinessUnit,60);
		;
		utils.clickOnWebElement(eleBusinessUnit);
	}

	public void setBusinessUnitName(String textToType) {
		inBusinessUnitName.clear();
		inBusinessUnitName.sendKeys(textToType);
	}

	public boolean isBusinessUnitUnique() throws InterruptedException {

		try {

			utils.waitForElementToBeVisiblewithFluentWait(inpBusinessUnit,5);
			String strBusinessUnit = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					inpBusinessUnit);
			
			System.out.println("Textbox value: " + strBusinessUnit);

			System.out.println(strBusinessUnit);

			String firstCharacters = strBusinessUnit.substring(0, 4);

			String midCharacters = strBusinessUnit.substring(3, 8);

			System.out.println(firstCharacters);

			System.out.println(midCharacters);

			boolean strChar = isStringOnlyAlphabet(firstCharacters);

			boolean intDigits = isDigitCheck(midCharacters);

			if (strChar == true || intDigits == true) {

				intDigits = true;

				System.out.println("working as per expecting");

			} else {

				intDigits = false;
				System.out.println("Not working as per expecting");
			}
			return intDigits;
		} catch (StaleElementReferenceException e) {
			
			throw e;
		}

	}
	
	

	/*
	public static boolean isStringOnlyAlphabet(String str) {

		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}
	*/
	public static boolean isStringOnlyAlphabet(String str) {
		  try {
		    return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
		  } catch (PatternSyntaxException e) {
		    // Handle potential syntax error in the regular expression (very rare)
		    System.out.println("Error: Invalid regular expression for alphabet check.");
		    return false;
		  }
		}


	public boolean ismsgValidaiton() {

		try {
			utils.waitForElementToBeVisiblewithFluentWait(msgErroMessageRequired, 5);
			return (msgErroMessageRequired.isDisplayed());
		} catch (Exception e) {
			return (false);
		}

	}

	public boolean isDigitCheck(String val) throws InterruptedException {

		if (val.matches("\\d+")) {
			System.out.println("The string contains only digits.");
		} else {
			System.out.println("The string contains characters other than digits.");
		}
		return false;
	}

	public boolean isobjetExists(String strval) //
	{
		try {
			return (msgErrorDuplcate.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	
	public boolean isDuplicateExists() //
	{
		try {
			return (msgErrorDuplcate.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void click() throws NoSuchElementException {
		  try {
		    utils.waitForElementToBeClickablewithFluentWait(combReportingCategory, 5);
		    utils.clickOnWebElement(combReportingCategory);
		  } catch (NoSuchElementException e) {
			  
		    System.out.println("Error: Element '" + combReportingCategory + "' not found on the page. Please check the layout.");
		  } catch (ElementClickInterceptedException e) {
		    System.out.println("Error: Unable to click element '" + combReportingCategory + "'. Another element might be blocking it.");
		  }
		}
	
	public void Repoclick() throws NoSuchElementException {
		  try {
		    utils.waitForElementToBeClickablewithFluentWait(combReportingCategory, 5);
		    utils.clickOnWebElement(combReportingCategory);
		  } catch (NoSuchElementException e) {
			  
		    System.out.println("Error: Element '" + combReportingCategory + "' not found on the page. Please check the layout.");
		  } catch (ElementClickInterceptedException e) {
		    System.out.println("Error: Unable to click element '" + combReportingCategory + "'. Another element might be blocking it.");
		  }
		}
	
	public void enterReportingVal(String strval) throws InterruptedException
	{
		utils.setValueTextBox(inputbReportingCategory,strval,"Reportingvalue");
		Thread.sleep(1000);
		utils.clickElementWithJavaScript(selReportingCategory);
		
		
	}

	// Extent Report - 1.
	public static String getSystemDate() {

		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	

	public void alterNativeHierarchy(String valueOngoingChekboxSelects) throws InterruptedException, TimeoutException {

		try {
			System.out.println("click on alternate");

			clickOnAlterNative();

			utils.checkCheckboxByValue(valueOngoingChekboxSelects);
			//utils.selectMultCheckbox(alterNativeCheckbxo, valueOngoingChekboxSelects);
		} catch (StaleElementReferenceException e) {
			// logError("Stale element exeption when getting text from the element", e);
			throw e;
		}

	}

	public void clickOnAlterNative() throws InterruptedException {

		Thread.sleep(2000);
		//utils.waitForElementToBeClickablewithFluentWait(alterNativeHierarchy, 30);
		utils.clickElementWithJavaScript(alterNativeHierarchy);

	}

	public void clickonContinue() {
		utils.clickOnWebElement(continuebtn);

	}

	public void selectCompany(String StrCompany) {
		utils.comoboxlist(comboReporting1, StrCompany);
		
	}
	
	public void clickonCompany() throws NoSuchElementException {
		  try {
			  
			  utils.verifyElementExists(clickCompany,"company");
			  clickCompany.isDisplayed();
			  utils.clickOnWebElement(clickCompany);
		  } catch (NoSuchElementException e) {
			  
			    System.out.println("Error: Element '" + combReportingCategory + "' not found on the page. Please check the layout.");
			  } catch (ElementClickInterceptedException e) {
			    System.out.println("Error: Unable to click element '" + combReportingCategory + "'. Another element might be blocking it.");
			  }
			}

	public void selectReportingCategory(String strReportingCategor) {
		utils.comoboxlist(comboReporting1, strReportingCategor);
	}

	public void selectItemType(String itemType) {
		utils.comoboxlist(ItemType, itemType);
	}

	public boolean valActivaStatus() {
		try {
			return getTExValidation(statusDropDwn, "Active");
		} catch (StaleElementReferenceException e) {
			// logError("Stale element exeption when getting text from the element", e);
			throw e;
		}
	}

	public boolean valReportingValidation() {
		try {
			return getTExValidation(statusDropDwn, "Active");
		} catch (StaleElementReferenceException e) {
			// logError("Stale element exeption when getting text from the element", e);
			throw e;
		}
	}

	public boolean valItemType() {
		try {
			return getTExValidation(btnItemType, "VMI");
		} catch (StaleElementReferenceException e) {
			// logError("Stale element exeption when getting text from the element", e);
			throw e;
		}
	}

	public boolean getTExValidation(WebElement element, String strvales) {
		Boolean getTExValidation = false;

		String activeVal = getText(element);

		try {

			if (activeVal.equalsIgnoreCase(strvales)) {
				System.out.print(activeVal);
				getTExValidation = true;
			} else {
				getTExValidation = false;
				System.out.print(activeVal);
			}
		} catch (StaleElementReferenceException e) {
			// logError("Stale element exeption when getting text from the element", e);
			throw e;
		}

		return getTExValidation;
	}

	public void btnSaveContunuebutton() {

		try {

			utils.waitForElementToBeClickablewithFluentWait(btnSaveContimue, 5);
			utils.clickOnWebElement(btnSaveContimue);

		} catch (Exception e) {
			BaseClass.getLogger().info("Save and continue button is not present");

		}
	}

	public boolean verifyTabLanding() throws InterruptedException {

		try {

			utils.waitForElementToBeVisiblewithFluentWait(Divisionview, 5);
			return (Divisionview.isDisplayed());

		} catch (Exception e) {

		}
		return true;

	}

	public String getText(WebElement element) throws NoSuchElementException, StaleElementReferenceException {
		String text = null;
		try {
			text = element.getText();
		} catch (NoSuchElementException e) {
			// logError("Element Not found exception when getting text from the element",
			// e);
			throw e;
		} catch (StaleElementReferenceException e) {
			// logError("Stale element exeption when getting text from the element", e);
			throw e;
		}
		return text;
	}

	public void enterBusinessUnit(String fieldsanme) {
		
		String inpEnterBuNameone = EnterBussUnitName();

		utils.setValueTextBox(inBusinessUnitName, inpEnterBuNameone, fieldsanme);
	}

	public String getBUIDValidation() throws InterruptedException {

		utils.waitForElementToBeVisiblewithFluentWait(inpBusinessUnit, 5);
		strBusinessUnits = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				inpBusinessUnit);
		System.out.println("Textbox value: " + strBusinessUnits);
		return strBusinessUnits;
	}

	public String getBUNameValidation() throws InterruptedException {
		utils.waitForElementToBeVisiblewithFluentWait(BUNames, 5);
		strBuNameVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", BUNames);
		System.out.println("Textbox value: " + strBuNameVal);
		return strBuNameVal;
	}

	public String BuStored() {
		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");

		String inpEnterBuNames = "SanityAutoTests" + strTimeStamps;
		return inpEnterBuNames;
	}

	public void enterBusinessUnits() {

		String strTimeStamp = utils.getSystemDate();
		String strTimeStamps = strTimeStamp.replace("_", "");

		String inpEnterBuNames = "SanityAutoTests" + strTimeStamps;

		utils.waitForElementToBeVisiblewithFluentWait(inBusinessUnitName, 5);

		utils.setValueTextBox(inBusinessUnitName, inpEnterBuNames, "BusineeUnitName");
	}

	public void enterBUIDSearch() {

		boolean blnBuSSearchexist = utils.isExists(BUSearch);

		utils.setValueTextBox(BUSearch, strBusinessUnits, "BusineeID");

		utils.waitForElementToBeClickablewithFluentWait(BUSearch, 5);

		utils.clickOnWebElement(SearchIcon);

	}

	public void enterBUNameSearch() {
		
			boolean blnBuSSearchexist = utils.isExists(BUSearch);

			System.out.println(strBuNameVal);

			utils.setValueTextBox(BUSearch, strBuNameVal, "BusineeID");

			utils.clickOnWebElement(SearchIcon);

		

	}

	public void clickBUnitTab() {		
			utils.clickOnWebElement(BUUnit);
	
	}

	public boolean isPagenotFoundExist() {
		return utils.isExists(NoRecordsFound);
	}

	public String getCellValue(int rowIndex, int colIndex) {
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		WebElement row = rows.get(rowIndex - 1);
		List<WebElement> cells = row.findElements(By.xpath(".//td"));
		WebElement cell = cells.get(colIndex - 1);
		System.out.println(cell.getText());

		return cell.getText();

	}

	public String getCellValueEmptyvalue(int rowIndex, int colIndex) {
		
				
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		WebElement row = rows.get(rowIndex - 1);
		List<WebElement> cells = row.findElements(By.xpath(".//td"));
		WebElement cell = cells.get(colIndex - 1);
		System.out.println(cell.getText());

		return cell.getText();

	}

	
	public String EnterBussUnitName() {
		String inpEnterBuName = BuStored();
		return inpEnterBuName;
	}

	protected void registerCall(String functionName) {

		System.out.println(functionName);
		
	}
	// vinay code
	public String getBusinessunitID()
	{
		try {
		return strBusinessUnits;
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	// end
	
}
