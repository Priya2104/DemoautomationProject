package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import factory.BaseClass;
import utilities.ExcelUtily;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;

public class MerchandiseDivisionPage extends BasePage {
    //WebDriverWait wait;
    //WebDriver driver;

	public static String strDivId;
	public static String strDivNameVal;
	String formDiv_Name;

	List<String> valuesToAdd;
	ArrayList<String> formvalues;


    public MerchandiseDivisionPage(WebDriver driver) {
        super(driver);

    }

    GenericUtilities utils = new GenericUtilities(driver);

   
    MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());

    MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());

    MerchandiseDepartmentPage deptPage = new MerchandiseDepartmentPage(BaseClass.getDriver());

    MerchandiseClassPage classPage = new MerchandiseClassPage(BaseClass.getDriver());

    
	//ItemManagementPage ItemMngt = new ItemManagementPage(BaseClass.getDriver());
    //MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());

    //public String BuStoreName=Mnp.EnterBussUnitName().trim();

    // String inpEnterBuNameone= EnterBussUnitName();


    //MerchandiseDivisionSteps mnps=new MerchandiseDivisionSteps();

    //String inpEnterBuName = null;

   @FindBy(xpath = "//span[normalize-space()='Division']")
    //@FindBy(xpath = "//h2[normalize-space()='Division']")
    WebElement Division;

    //@FindBy(xpath ="(//span[@class='p-button-label ng-star-inserted'])[3]")

    @FindBy(xpath = "//span[normalize-space()='Group']")
    WebElement tabGroup;

    @FindBy(xpath = "//*[contains(text(),' View Business Unit')]") // Home Page heading
    WebElement msgHeading;

    //@FindBy(xpath = "//*[contains(text(),' Add Division Unit')]") // add division unit
    @FindBy(xpath = "//span[normalize-space()='Add Division']")
    //@FindBy(xpath="//button[@class='p-ripple p-element p-button p-component' and text()=' Add Business Unit ']");
            WebElement btnAddDiviUnit;

    @FindBy(xpath = "//h2[@class='text-primary font-semibold text-lg uppercase m-0']") // Home Page heading
    WebElement viewDivisionPage;

    @FindBy(xpath = "//*[contains(text(),'Record saved successfully.')]")
    WebElement msgSaveSuccessMessage;


    //@FindBy(xpath="//span[@role='combobox' and @aria-controls='businessUnit_list']")

    //WebElement drpDwnBusinessUnit;

    @FindBy(xpath = "//div[@id='businessUnit']")
    WebElement drpDwnBusinessUnit;

    @FindBy(xpath = "//div[@id='reportingCategory']")
    WebElement drpDwnReporting;

    //(//span[@class='p-element p-dropdown-label p-inputtext p-placeholder ng-star-inserted'])[1]

    @FindBy(xpath = "//input[@id='divisionId']")
    WebElement autoDivisionId;

    @FindBy(xpath = "//input[@id='divisionName']")
    WebElement inpdivisionName;

    //@FindBy(xpath="//span[@class='ng-star-inserted']")
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

    @FindBy(xpath = "(//span[contains(text(),'Save and Next')])[1]") // save continue
    //@FindBy(css ="p-button[name='Continue'] button[type='button']")
    WebElement btnSaveAndContiue;
    //@FindBy(xpath = "(//*[@type='button'])[9]")
    //WebElement btnSaveAndContiue;

    @FindBy(xpath = "(//span[contains(text(),'Save')])[2]")
    WebElement btnSave;
    @FindBy(xpath = "//input[@id='businessUnitName']") // Business unit name
    WebElement inBusinessUnitName;

    @FindBy(xpath = "//h2[contains(text(),' View Group')]")
    WebElement viewGroup;

    @FindBy(xpath = "//span[contains(text(),'Department')]")
    WebElement DepartmentTab;

    @FindBy(xpath = "//*[contains(text(),'Add Group')]")
    WebElement btnGroup;
    @FindBy(xpath = "//span[contains(text(),'Add Department')]")
    WebElement btnAddDeparment;

    @FindBy(xpath = "//span[contains(text(),'Add Subclass')]")
    WebElement btnAddSubClass;

    @FindBy(xpath = "//span[contains(text(),'Add Class')]")
    WebElement btnAddClass;

    @FindBy(xpath = "//div[@id='division']")
    WebElement drrpdiviion;

    //@FindBy(xpath="//div[@id='groupId']")
    @FindBy(xpath = "//div[@id='group']//span[@aria-label='Select'][normalize-space()='Select']")
    WebElement drrpGroup;

    @FindBy(xpath = "//div[@id='class']")
    WebElement drrpSubClass;

    @FindBy(xpath = "//div[@id='department']")
    WebElement drrpClass;

    @FindBy(xpath = "//input[@id='groupName']")
    WebElement inGroupName;

    @FindBy(xpath = "//input[@id='departmentName']")
    WebElement inDepartmentName;

    @FindBy(xpath = "//input[@id='className']")
    WebElement inClassName;

    @FindBy(xpath = "//input[@id='subclassName']")
    WebElement inSubClassName;

    @FindBy(xpath = "//h2[contains(text(),' View Department ')]")
    WebElement viewDepart;

    @FindBy(xpath = "//h2[contains(text(),' View Class ')]")
    WebElement viewClass;
    @FindBy(xpath = "//h2[contains(text(),' View Subclass')]")
    WebElement viewSubClass;

    @FindBy(xpath = "//h2[contains(text(),' View Business Unit ')]")
    WebElement viewBusinessUnitPage;

    @FindBy(xpath = "//label[@for='itemTypeId']//following::span[1]")
    WebElement btnItemType;

    @FindBy(xpath = "//span[@aria-label='VMI']")
    WebElement btnItemTypeVMI;

    //@FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext p-placeholder ng-star-inserted'])[3]")

    //@FindBy(xpath = "//div[@id='itemTypeId']")
    @FindBy(xpath = "//div[@id='itemTypeId']//span[@aria-label='Select'][normalize-space()='Select']")
    WebElement comboItemType;
    
    //@FindBy(css = "div[id='itemTypeId'] span[aria-label='Select']")
    @FindBy(xpath = "//div[@id='itemTypeId']")
    WebElement ItemTypeClcik;    
   

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    List<WebElement> ItemTypes;
    @FindBy(xpath = "(//span[@class='p-button-label ng-star-inserted'])[4]")
    WebElement departmentTab;

   // @FindBy(xpath = "(//span[@class='p-button-label ng-star-inserted'])[6]")
    @FindBy(xpath = "//span[contains(.,'Subclass')]")
    WebElement subClassTab;

    @FindBy(xpath = "//span[normalize-space()='Class']")
    WebElement ClassTab;


    @FindBy(xpath = "//span[@aria-expanded='true']")
    WebElement itemtypes;

    @FindBy(xpath = "//div[@id='itemTypeId']//span[@aria-label='Select'][normalize-space()='Select']")
    WebElement itemtypeSelect;

    @FindBy(xpath = "//*[contains(text(),' View Business Unit ')]")
    WebElement businessunitview;


    @FindBy(xpath = "//input[@id='divisionId']")
    WebElement inpDivID;

    @FindBy(xpath = "//input[@id='divisionName']")
    WebElement inpDivName;

    //filter selection xpaths
    @FindBy(xpath = "//div[@id='merchBusinessUnitPkid']")
    WebElement filtersVale_businessUnitId;

    @FindBy(xpath = "//input[contains(@aria-owns,'merchBusinessUnitPkid_list')]")
    WebElement filterValue_BUsearch;

    @FindBy(xpath ="//select[@id='itemTypeDropdown']/option[text()='Mobile']")
    WebElement ItemTYpe;
    
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement SearchBoxText;
    
    @FindBy(xpath = "//p[contains(., 'This field is required.')]")
    List<WebElement> errFieldRequired;

    
  ////input[@type='text' and @role='searchbox' and @autocomplete='off' and @class='p-dropdown-filter p-inputtext p-component' and @aria-owns='businessUnit_list']

 
   
    public void vefiyGroupPage(String strFieldValue) {

        utils.verifyElementExists(viewGroup, strFieldValue);
    }

    public void vefiyDeprtPage(String strFieldValue) {

        utils.verifyElementExists(viewDepart, strFieldValue);
    }

    public void vefiyClassPage(String strFieldValue) {
        utils.verifyElementExists(viewClass, strFieldValue);
    }

    public void vefiySubClassPage(String strFieldValue) {
        utils.verifyElementExists(viewSubClass, strFieldValue);
    }

    public void vefiyViewBusinessUnitHomePage(String strFieldValue) {
        utils.verifyElementExists(businessunitview, strFieldValue);
    }
    
//Edit and delete xpaths

 	@FindBy(xpath = "//input[@placeholder='Division ID Or Division Name']")
 	WebElement searchbox;

 	// @FindBy(xpath="//span[@class='p-button-icon pi pi-search']")
 	@FindBy(xpath = "//button[@type='button' and @icon='pi pi-search']")
 	WebElement search_btn;

 	@FindBy(xpath = "//div[@class='grid align-items-center']//span[contains(text(),' 1 ')]")
 	WebElement Division_count;

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

 	@FindBy(xpath = "//p-dropdown[@formcontrolname='businessUnit']")
 	WebElement formview_businessunit;

 	@FindBy(xpath = "//input[@formcontrolname='divisionId']")
 	WebElement formview_divisionID;

 	@FindBy(xpath = "//input[@formcontrolname='divisionName']")
 	WebElement formview_divisionname;

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

 	@FindBy(xpath = "//h3[contains(text(),'Division')]")
 	WebElement FormView_div;

 	@FindBy(xpath = "//span[text()='Yes']")
 	WebElement Yes_button;

 	@FindBy(xpath = "//span[text()='No']")
 	WebElement No_button;

 	@FindBy(xpath = "//div[@data-pc-section='detail']")
 	WebElement Success_msg;

 	@FindBy(xpath = "//span[contains(text(),'Are you sure')]")
 	WebElement Cancel_msg;

 	@FindBy(xpath = "//h2[contains(text(),'View Division')]")
 	WebElement txt_viewpage;

 	@FindBy(xpath = "//div[@data-pc-section='detail']")
 	WebElement txt_postclickondelete_msg;

 	@FindBy(xpath = "//i[@class='pi pi-times']")
 	WebElement cancel_searchbtn;

 	@FindBy(xpath = "//span[contains(text(),'No Records Found')]")
 	WebElement Norecord_msg;
 	
	@FindBy(xpath = "//span[text()='Division']")
	WebElement Divisiontab;
	
	  @FindBy(xpath = "//input[@role='searchbox']")
	    WebElement SearchBox;

    public boolean ismerchandiseBusineunitHomesPageExists()   //
    {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    public boolean ismerchandiseDivisonPageExists()   //
    {
        try {
            return (viewDivisionPage.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    public void clikconSaveandCOntinebutton() {
        //utils.clickOnWebElement(btnSaveAndContiue);
        utils.clickOnWebElement(btnSaveAndContiue);
    }

    public void alterNativeHierarch(String valueOngoingChekboxSelects) throws InterruptedException {
        
        utils.waitForElementToBeClickablewithFluentWait(alterNativeHierarch, 5);
        utils.clickOnWebElement(alterNativeHierarch);       

        selectMultCheckbox(valueOngoingChekboxSelects);


    }

    public void clickOnSaveContinueButton() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnSaveAndContiue);


    }

    public void selectItemType(String strItemType) throws InterruptedException {
                
             
    	      utils.clickElementWithJavaScript(ItemTypeClcik);
	
    	      utils.slowSendKeys(SearchBox, strItemType, 500);
			  //utils.setValueTextBox(ItemMngt.SearchBox,strItemType, "Item Tyep");
			  
			  Actions actions = new Actions(driver);
		        actions.sendKeys(Keys.TAB).build().perform();
		        actions.sendKeys(Keys.ENTER).build().perform();  
			  
			  
	   

	        //utils.comoboxlistItemtype(comboBusineeUnit,strItemType);

	 
    
    }


    public boolean ismsgValidaitons() {

        try {
            return (msgSaveSuccessMessage.isDisplayed());
        } catch (Exception e) {
            return (false);
        }

    }

    public void selectMultCheckbox(String valueOngoingChekboxSelects) {
        //String valueOngoingChekboxSelect = "Kids,Jeans,Spring Season,Christmas,Back To school,Bottoms,Cartoons";
        String valueOngoingChekboxSelect = valueOngoingChekboxSelects;

        List<String> ongoingPrecuationsList = Arrays.asList(valueOngoingChekboxSelect.split("#"));

        System.out.println(ongoingPrecuationsList);


        for (String alterNativechekbxes : ongoingPrecuationsList) {
            for (WebElement alternaitiveChk : alterNateCheckbox) {

                if (alternaitiveChk.getText().equalsIgnoreCase(alterNativechekbxes)) {

                    String strvals = alternaitiveChk.getText();

                    System.out.println(strvals);

                    System.out.println(alterNativechekbxes);

                    alternaitiveChk.click();
                }
            }
        }

    }

    public void selectDivisionUnitInDivision() throws InterruptedException {
        //try {
           // List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
            
            

            Thread.sleep(3000);
            //utils.waitForElementToBeClickablewithFluentWait(btnAddDiviUnit,5);
            
            utils.clickOnWebElement(btnAddDiviUnit);   
            
           // utils.waitForElementToBeClickablewithFluentWait(drpDwnBusinessUnit,10);

          //  utils.clickOnWebElement(drpDwnBusinessUnit);
            
           // utils.waitForPageLoad();                        
                       
         //  utils.comoboxlist(comboBusineeUnit, Mnp.strBuNameVal);
            

            System.out.println("Page in the divison Steps page");
         


      //  } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        


    }
    
    public void clickDivisionBtn()
    {
    	utils.waitForElementToBeClickablewithFluentWait(btnAddDiviUnit,5);
        
        utils.clickOnWebElement(btnAddDiviUnit);  
    }
    
    public void selectBUFromDivision(String BusinessUnit) throws InterruptedException {
                 
            
           
            utils.waitForElementToBeClickablewithFluentWait(btnAddDiviUnit,5);
            
            utils.clickOnWebElement(btnAddDiviUnit);   
            
            utils.waitForElementToBeClickablewithFluentWait(drpDwnBusinessUnit,10);

            utils.clickOnWebElement(drpDwnBusinessUnit);
            
           // utils.waitForPageLoad();   
            utils.slowkeyenterValue(SearchBoxText, BusinessUnit,1000);
            
            
        	//String BusinessUnit = testdata.getProperty("businessUnitName");           
            //utils.comoboxlist(comboBusineeUnit, BusinessUnit);
            

            System.out.println("Page in the divison Steps page");
         



    }

    public void clickAddButtonGroup() throws IncorrectXpathException
    {
    	utils.explicit_Wait(btnGroup,2000);
    	//utils.doesElementExist(btnGroup);
    	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
    	
    	clickAddButton(btnGroup);
    }
    
    public void clickAddButtonDepartment()
    {
    	clickAddButton(btnAddDeparment);
    }
    
    
    public void clickAddButtonClass()
    {
    	clickAddButton(btnAddClass);
    }
    
    public void clickAddButtonSubClass()
    {
    	clickAddButton(btnAddSubClass);
    }
    
    
    public void clickAddButtonDivision()
    {
    	clickAddButton(btnAddDiviUnit);
    }
    
    public void clickAddButton(WebElement element)
    {
        
        utils.waitForElementclickable(Duration.ofSeconds(60), element);
        
    	utils.clickOnWebElement(element);
 
    }

    public void selectDivisionFromGroup(String divisionName) throws InterruptedException {
       
           // List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
        Thread.sleep(5000);
       // utils.waitForElementToBeClickablewithFluentWait(btnGroup, 5);
    	   // utils.waitForElementToBeClicks(btnGroup, 20);
            
            //utils.waitForElementToBeClickablewithFluentWait(btnGroup, 60);

            utils.clickOnWebElement(btnGroup);            
            

           utils.waitForElementToBeClickablewithFluentWait(drrpdiviion, 5);

           utils.clickOnWebElement(drrpdiviion);
           
           utils.slowkeyenterValue(SearchBoxText, divisionName,500);
           
           
          //  utils.waitForPageLoad();
           // utils.waitForPageLoad();
            
          //  Thread.sleep(5000);
                       
            utils.comoboxlist(comboBusineeUnit, strDivNameVal);



    }

    public void ItemTpeclick() {
        try {
            //utils.waitForElementToBeClickablewithFluentWait(comboItemType,10);
        	//utils.doubleclickOnWebElement(ItemTypeClcik);
        	 Thread.sleep(1000);
        	
        	utils.hoverAndClick(ItemTypeClcik);
        	
        	//utils.clickElementWithJavaScript(ClassTab);
        	
        	
        	
        	//utils.hoverAndClick(comboItemType);
        	//utils.clickElementWithJavaScript(comboItemType);
            
           // To select an item by visible text
           // utils.dropdownSelector.selectItemByVisibleText("myDropdown", "Option 1");
            
            //utils.selectItemByVisibleText(comboItemType,"Mobile");
            
          
        	
        	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
          
        } catch (Exception e) {
        }


    }
    
    
    
    
    /*
    public void clickmethods()
    {
    	 
    	
    	 // Locate the element to click
        WebElement clickElement = driver.findElement(By.xpath("")); // Replace with your element locator

    	Actions actions = new Actions(driver);
    	 
	       actions.moveToElement(clickElement).perform();
	       
	              
	                 // Simulate down arrow key press after click (replace 2 with desired number of presses)
	        for (int i = 0; i < 2; i++) {
	          
	        	driver.findElement(By.xpath("//div[@id='itemTypeId']//span[@aria-label='Select'][normalize-space()='Select']").sendKeys(Keys.ARROW_DOWN));
    }
	 
	 }
	        */
	        

    
    public void departmentTabClick() {
        utils.clickOnWebElement(departmentTab);
    }

    public void subclassTabClick() {
    	utils.waitForElementclickable(Duration.ofSeconds(60), subClassTab);
        utils.clickOnWebElement(subClassTab);
    }

    public void classTabClick() {
        utils.clickOnWebElement(ClassTab);
    }

    public boolean valItemType() {
        try {
            return getTExValidation(btnItemType, "VMI");
        } catch (StaleElementReferenceException e) {
            //logError("Stale element exeption when getting text from the element", e);
            throw e;
        }
    }


    public void clickDepartment() throws InterruptedException {

        utils.clickOnWebElement(DepartmentTab);
    }


    public void selectGroupInDepartment(String GroupName) throws InterruptedException {
        
            //List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
        Thread.sleep(2000);
        //utils.waitForElementToBeClickablewithFluentWait(btnAddDeparment, 60);
            //utils.waitForElementToBeClickablewithFluentWait(btnAddDeparment, 60);
        utils.waitForElementclickable(Duration.ofSeconds(60), btnAddDeparment);
            utils.clickOnWebElement(btnAddDeparment);
			/*
			 * utils.waitForElementToBeClickablewithFluentWait(drrpGroup, 10);
			 * 
			 * utils.clickOnWebElement(drrpGroup);
			 * 
			 * utils.waitForPageLoad(); utils.waitForPageLoad();
			 * 
			 * Thread.sleep(5000);
			 * 
			 * utils.comoboxlist(comboBusineeUnit, GroupPage.strGrpNameVal);
			 */
            utils.waitForElementclickable(Duration.ofSeconds(60), drrpGroup);
            utils.clickOnWebElement(drrpGroup);
            
            utils.slowkeyenterValue(SearchBoxText, GroupName,500);
            //utils.comoboxlist(comboBusineeUnit, GroupPage.strGrpNameVal);
            
            

        //} catch (IOException e) {
            // TODO Auto-generated catch block-
           // e.printStackTrace();
       // }


    }


    public void selectClassInSubclass(String Classname) throws InterruptedException {
      //  try {
          //  List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
        Thread.sleep(2000);
        utils.waitForElementclickable(Duration.ofSeconds(60), btnAddSubClass);
            utils.clickOnWebElement(btnAddSubClass);

			/*
			 * utils.waitForElementToBeClickablewithFluentWait(drrpSubClass, 5);
			 * 
			 * utils.clickOnWebElement(drrpSubClass); utils.waitForPageLoad();
			 * utils.waitForPageLoad();
			 * 
			 * Thread.sleep(5000);
			 * 
			 * 
			 * utils.comoboxlist(comboBusineeUnit, classPage.strClassNameVal);
			 */
            utils.waitForElementclickable(Duration.ofSeconds(60), drrpSubClass);
            utils.clickOnWebElement(drrpSubClass);
            
            utils.slowkeyenterValue(SearchBoxText, Classname,500);
         
        //} catch (IOException e) {
            // TODO Auto-generated catch block
          //  e.printStackTrace();
        //}


    }

    public void selectnDepartmentInClass(String Department) throws InterruptedException {
      // try {
           // List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();

            
        Thread.sleep(2000);
        
   
        utils.waitForElementclickable(Duration.ofSeconds(60), btnAddClass);        
    	utils.clickOnWebElement(btnAddClass);

			/*
			 * utils.waitForElementToBeClickablewithFluentWait(drrpClass, 5);
			 * 
			 * 
			 * utils.clickOnWebElement(drrpClass);
			 * 
			 * utils.waitForPageLoad(); utils.waitForPageLoad();
			 * 
			 * Thread.sleep(5000);
			 * 
			 * utils.comoboxlist(comboBusineeUnit, deptPage.strDepNameVal);
			 */
    	

    	utils.waitForElementclickable(Duration.ofSeconds(60), drrpClass);  
    	utils.clickOnWebElement(drrpClass);
    	
    	utils.slowkeyenterValue(SearchBoxText, Department,500);

    	

         
      //  } catch (IOException e) {
            // TODO Auto-generated catch block
          //  e.printStackTrace();
       // }


    }

    public void clickDivisionTab() {
        try {
        	Thread.sleep(3000);
            utils.waitForElementToBeClickablewithFluentWait(Division,5);
        	utils.clickOnWebElement(Division);

        } catch (Exception e) {
           
        }
    }

    public void clickGroupTab() {
        try {
        	 utils.waitForElementToBeClickablewithFluentWait(tabGroup,5);
        	utils.clickOnWebElement(tabGroup);

        } catch (Exception e) {
            //logReportMessageAndTakeScreenShot("Open Failed - " + "");


        }
    }

    public boolean valActivaStatus() {
        return getTExValidation(statusDropDwn, "Active");
    }

    public boolean getTExValidation(WebElement element, String strvales) {
        Boolean getTExValidation = false;

        String activeVal = getText(element);

        if (activeVal.equalsIgnoreCase(strvales)) {
            System.out.print(activeVal);
            getTExValidation = true;
        } else {
            getTExValidation = false;
            System.out.print(activeVal);
        }
        return getTExValidation;
    }

    public String getText(WebElement element) throws NoSuchElementException, StaleElementReferenceException {
        String text = null;
        try {
            text = element.getText();
        } catch (NoSuchElementException e) {
            //logError("Element Not found exception when getting text from the element", e);
            throw e;
        } catch (StaleElementReferenceException e) {
            //logError("Stale element exeption when getting text from the element", e);
            throw e;
        }
        return text;
    }

    public boolean isDivisionUnitUnique() throws InterruptedException {
        
       utils.waitForElementToBeVisiblewithFluentWait(inpDivisionUnit,5);

      
        String strDivisonID = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpDivisionUnit);


        System.out.println("Textbox value: " + strDivisonID);


        System.out.println(strDivisonID);

        String firstCharacters = strDivisonID.substring(0, 3);

        String midCharacters = strDivisonID.substring(3, 8);

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

    }

    public static boolean isStringOnlyAlphabet(String str) {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }


    public boolean isDigitCheck(String val) throws InterruptedException {


        if (val.matches("\\d+")) {
            System.out.println("The string contains only digits.");
        } else {
            System.out.println("The string contains characters other than digits.");
        }
        return false;
    }
    
    
    
    public void addDivsionButtonSave() {
    	
    	
    	utils.btnSavebutton(btnAddDiviUnit,btnSave);
    	
    }
    


    
 //public void addGrpButtonSave() {
    	
    //	btnSavebutton();
    	
   // }
    
    public void errormessageValiation()
    {
    	utils.verifyRequiredFieldErrorCount(2);
    }
    
    

   


    public void click() {
        try {
            
        	utils.waitForElementToBeClickablewithFluentWait(drpDwnReporting,5);
        	utils.clickOnWebElement(drpDwnReporting);
        } catch (Exception e) {
        }
    }

    public String getDivIDValidation() throws InterruptedException {
        
    	utils.waitForElementToBeVisiblewithFluentWait(inpDivID, 3);
        strDivId = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpDivID);
        System.out.println("Textbox value: " + strDivId);
        return strDivId;
    }


    public String getDivNameValidation() throws InterruptedException {
      
    	utils.waitForElementToBeVisiblewithFluentWait(inpDivName, 3);
        strDivNameVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inpDivName);
        System.out.println("Textbox value: " + strDivNameVal);
        return strDivNameVal;
    }

    public void selectReportingCategory(String strReportingCategor) throws InterruptedException {


        utils.comoboxlist(comboBusineeUnit, strReportingCategor);

    }


    public String timeSmtap() {
        try {

        } catch (NullPointerException e) {

            e.printStackTrace();

        } finally {


            String strTimeStamp = utils.getSystemDate();
            String strTimeStamps = strTimeStamp.replace("_", "");
            System.out.println(strTimeStamps);
            String inpEnterDivision = "MerxAutoMatest" + strTimeStamps;
            System.out.println(inpEnterDivision);

        }
        return timeSmtap();
    }

    public void setGrouName() {
        try {
            Thread.sleep(2000);
            String strTimevalue = timeSmtap();
            inpdivisionName.clear();
            inpdivisionName.sendKeys(strTimevalue);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void setDivisionName() {
     
            String strTimevalue = timeSmtap();
            inpdivisionName.clear();
            inpdivisionName.sendKeys(strTimevalue);      


    }

    public String BuStored() {
        String strTimeStamp = utils.getSystemDate();
        String strTimeStamps = strTimeStamp.replace("_", "");

        String inpEnterBuNames = "SanityAutoTests" + strTimeStamps;
        return inpEnterBuNames;
    }

    public String EnterBussUnitName() {
        String inpEnterBuName = BuStored();
        return inpEnterBuName;
    }


    public void enterDivisionName(String inpDivisionName, String fieldsanme)
    //public void enterDivisionName(String fieldsanme)
    {
        //String inpEnterBuNameone= EnterBussUnitName();

        utils.setValueTextBox(inpdivisionName, inpDivisionName, fieldsanme);
    }

    public void enterGroupName(String inpGroupName, String fieldsanme) {
        utils.setValueTextBox(inGroupName, inpGroupName, fieldsanme);
    }

    public void enterDepartment(String inpDepartmentName, String fieldsanme) {
        utils.setValueTextBox(inDepartmentName, inpDepartmentName, fieldsanme);
    }

    public void enterClass(String inpClassName, String fieldsanme) {
        utils.setValueTextBox(inClassName, inpClassName, fieldsanme);
    }

    public void enterSubClass(String inpSubClassName, String fieldsanme) {
        utils.setValueTextBox(inSubClassName, inpSubClassName, fieldsanme);
    }

    public void setGrouName1(String strGroup) {


    }

    public void applyBusinessUnitFilter(String BusinessUnit) throws InterruptedException {
        if (BusinessUnit.isEmpty()) {
            System.out.println("Ignoring BusinessUnit filter");
        } else {
            utils.waitForElementToBeClickablewithFluentWait(filtersVale_businessUnitId, 5);
            utils.clickElementWithJavaScript(filtersVale_businessUnitId);
           
            utils.waitForElementToBeVisiblewithFluentWait(filterValue_BUsearch,5);
            
            utils.slowSendKeys(filterValue_BUsearch, BusinessUnit, 500);
            
           
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            Thread.sleep(8000);
            actions.sendKeys(Keys.ENTER).build().perform();

  }
    }
    
   //Edit methods
    public String txt_searchcount() {
		try {
			String count = Division_count.getText();
			return count;
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

	public boolean checkcountequalsto1() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), Division_count);
			String count = Division_count.getText();
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

	public String txt_viewDivisionID() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), gridview_divisionID);
			String txtBuid = gridview_divisionID.getText();
			return txtBuid;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String txt_viewDivisionname() {
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
			// utils.waitForElementclickable(Duration.ofSeconds(10), threedots);
			utils.waitForElementToBeClickablewithFluentWait(threedots, 10);
			threedots.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void click_edit_btn() {
		try {
			// utils.waitForElementclickable(Duration.ofSeconds(10), edit_btn);
			utils.waitForElementToBeClickablewithFluentWait(edit_btn, 10);
			edit_btn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean verifyFormDiv() {
		try {
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), FormView_div);
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_divisionname);
			// boolean formBU= FormView_div.isDisplayed();
			boolean formBU = formview_divisionname.isEnabled();
			System.out.println(formBU);
			return formBU;
		} catch (Exception e) {
			return false;
		}
	}

	public String getDivID() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formview_divisionID);
			// String txtformBUID=formview_businessunitID.getText();
			String formDivID = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					formview_divisionID);
			return formDivID;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getDivName() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(20), formview_divisionname);
			// utils.waitForElementToBeVisiblewithFluentWait(formview_divisionname, 5);
			// String txtformBUID=formview_businessunitID.getText();
			formDiv_Name = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					formview_divisionname);
			return formDiv_Name;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getrp() {
		try {
			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), formviewgettext_rp);
			// utils.waitForElementToBeVisiblewithFluentWait(formviewgettext_rp, 5);
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
			// utils.waitForElementToBeVisiblewithFluentWait(formviewgettext_status, 5);
			String formrp = formviewgettext_status.getText();
			return formrp;

		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void setDivName(String Divname) {
		try {
			formview_divisionname.click();
			formview_divisionname.clear();
			formview_divisionname.sendKeys(Divname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void click_cancelrp() {
		// utils.waitForElementclickable(Duration.ofSeconds(10),
		// formview_cancelbutton_rp);
		utils.waitForElementToBeVisiblewithFluentWait(formview_cancelbutton_rp, 5);
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
		// utils.waitForElementToBeClickablewithFluentWait(formview_Save_btn, 10);
		utils.clickOnWebElement(formview_Save_btn);
		// Thread.sleep(3000);
	}

	public boolean ViewDivpagedisplayed() {
		try {

			utils.waitForElementVisibilityFor(Duration.ofSeconds(10), txt_viewpage);
			boolean value = utils.doesElementExist(txt_viewpage);
			return value;

		} catch (Exception e) {
			return false;

		}
	}

	public String getdivisionID() {
		try {
			return strDivId;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public void click_divisiontab() {
		try {
			utils.waitForElementclickable(Duration.ofSeconds(10), Divisiontab);
			// utils.waitForElementVisibilityFor(Duration.ofSeconds(10), search_btn);
			Divisiontab.click();
			// Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

 	public String GetDivValue() { // Getting the Division unit ID and name

 		if (strDivId != null || !strDivId.isEmpty()) {
 			return strDivId;
 		} else {
 			return strDivNameVal;
 		}

 	}

 	public void entersearchbox(String divId) { // Sending the Division unit value to the search box
 		try {
 			// utils.waitForElementclickable(Duration.ofSeconds(10), searchbox);
 			utils.waitForElementToBeClickablewithFluentWait(searchbox, 10);
 			searchbox.clear();
 			searchbox.sendKeys(divId);
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 		}
 	}

 	public void click_searchbtn() { // selecting the search button for the value entered in the search box
 		try {
 			utils.waitForElementclickable(Duration.ofSeconds(10), search_btn);
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

 	public void UpdateDiv_Name(String Divsision) { // Updating the Division unit name
 		if (verifyFormDiv()) {
 			if (Divsision.length() <= 40) {
 				String strTimeStamp = utils.getSystemDate();
 				String strTimeStamps = strTimeStamp.replace("_", "");
 				String inpEnterBuNames = Divsision + strTimeStamps;
 				setDivName(inpEnterBuNames);
 			} else {
 				String strTimeStamp = utils.getSystemDate();
 				String strTimeStamps = strTimeStamp.replace("_", "");
 				String inpEnterBuNames = "Div" + strTimeStamps + strTimeStamps;
 				setDivName(inpEnterBuNames);
 			}
 		}

 		else {
 			System.out.println("Form View Business_unit_name returned as empty");
 		}
 	}

 	public void selectRC(String strReportingCategory) { // updating the Reporting category
 		if (strReportingCategory.isEmpty()) {
 			System.out.println("Reporting category is empty");
 		} else {
 			click_cancelrp();
 			utils.waitForElementclickable(Duration.ofSeconds(10), formview_Reportingcategory);
 			// utils.waitForElementToBeClickablewithFluentWait(formview_Reportingcategory,
 			// 5);
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
 			valuesToAdd = Arrays.asList(txt_viewDivisionID(), txt_viewDivisionname(), txt_viewreportingcategory(),
 					txt_viewstatus());
 			// System.out.println(valuesToAdd);
 			valuesToAdd.forEach(valuesToAdd -> System.out.println("view page:" + valuesToAdd));
 			utils.addvalue(valuesToAdd);
 		} else {
 			System.out.println("count is not equals to 1");
 		}
 	}

 	public void getformpagevalues() { // Getting the form page field values to compare
 		if (verifyFormDiv()) {
 			// utils.getvalues();
 			formvalues = new ArrayList<>();

 			formvalues.add(getDivID());
 			formvalues.add(getDivName());
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


