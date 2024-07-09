package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.runtime.junit.Assertions;
import factory.BaseClass;
import utilities.Apiutilities;
import utilities.ExcelUtily;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;
import utilities.PropertiesReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemAndReferenceMasterPage extends BasePage {

    public int waittime = 6000;
     public String originalWindow;
     WebDriverWait wait;
    final private CloseableHttpClient client;
    
  
    String TestData_filePath = "testData/TestData.properties";
    String Config_filePath ="src/test/resources/config.properties";
    
    PropertiesReader testdata = new PropertiesReader(TestData_filePath);    
    PropertiesReader config = new PropertiesReader(Config_filePath);
    
    public String BaseAPIurl = config.getProperty("BaseAPIurl");
    
    @FindBy(xpath = "//span[contains(text(), 'Masters')]")
    WebElement masterMenu;
    
    @FindBy(xpath = "//span[text()='Logo Master']")
    WebElement logoMaster; 
    @FindBy(xpath ="//span[text()='Language Master']")
    WebElement languageMaster; 
    
    @FindBy(xpath ="//span[text()='City Master']")
    WebElement cityMaster; 
    
  
    
    @FindBy(xpath ="//span[text()='Add City']")
    WebElement cityMasterAddButton; 

    @FindBy(xpath ="//div[contains(text(), 'Desktop Logo Image')]/..//..//span[@class='p-button-label' and text()='Select Images']")
    WebElement desktopSelectdButton;
    
    @FindBy(xpath ="//div[contains(text(), 'Mobile Logo Image')]/..//..//span[@class='p-button-label' and text()='Select Images']")
    WebElement mobilepSelectButton;
    


    @FindBy(xpath ="//div[contains(text(), 'Desktop Logo Image')]/..//..//span[@class='p-button-label ng-star-inserted'][normalize-space()='Upload']")
    WebElement desktopUploadButton;

    @FindBy(xpath ="//div[contains(text(), 'Mobile Logo Image')]/..//..//span[@class='p-button-label ng-star-inserted'][normalize-space()='Upload']")
    WebElement mobilepUploadButton;

    @FindBy(xpath ="//div[contains(text(), 'Desktop Logo Image')]/..//..//li[contains(text(), 'Maximum image size should not exceed 5MB')]")
    WebElement validationDesktopImazeSize;
    
    @FindBy(xpath ="//div[contains(text(), 'Mobile Logo Image')]/..//..//li[contains(text(), 'Maximum image size should not exceed 5MB')]")
    WebElement validationMobileImazeSize;


    @FindBy(xpath ="(//div[contains(text(), 'Desktop Logo Image')]/..//..//div[@class='ng-star-inserted'])[2]")
  WebElement validationDesktopImageExists;
    @FindBy(xpath ="(//div[contains(text(), 'Mobile Logo Image')]/..//..//div[@class='ng-star-inserted'])[2]")
  WebElement validationMobileImageExists;
    
	@FindBy(xpath = "//*[contains(text(),'System Parameters')]")
	WebElement systemandref;
	
	@FindBy(id = "file-submit")
	WebElement fileSubmitButton;
	
	
	//@FindBy(xpath ="//input[@label='File name']")
	//@FindBy(css =".file-upload-input[type='file']")
	
	//@FindBy(xpath ="(//input[@type='file'])[1]")
	
	@FindBy(xpath="//input[@type='file']")
	WebElement filepathXapth;
	
	@FindBy(xpath="(//input[@type='file'])[1]")
	WebElement filepathXapthDG;
	
	@FindBy(xpath="(//input[@type='file'])[3]")
	WebElement filepathXapthMob;
	@FindBy(xpath="//span[contains(text(), 'Add Language')]")
	WebElement addLanguageButton;
	
	@FindBy(xpath="//input[@id='languageCode']")
	WebElement languageCode;
	
	@FindBy(xpath="//input[@id='cityCode']")
	WebElement inpcityCode;
	
	@FindBy(xpath="//input[@id='cityName']")
	WebElement inpcityName;
	
	
	@FindBy(xpath="//input[@id='languageName']")
	WebElement languageName;
	
	@FindBy(xpath="//input[@id='languageShortName']")
	WebElement languageShortName;
	
	
	@FindBy(xpath="//label[text()=' Status * ']/..//span[contains(text(), 'Active')]")
	WebElement languageStatus;
	
	@FindBy(xpath="//div[@id='applicableCountries']")
	WebElement selectCountry;
	
	@FindBy(xpath="//span[@aria-label='Select Country']")
	WebElement selectCountryInCityMasterDrop;
	
	@FindBy(xpath="//span[@role='combobox' and @aria-label='Select State']")
	WebElement selectStateDrop;
	
	@FindBy(xpath="//span[@role='combobox' and @aria-label='Select Time Zone']")
	WebElement selectTimeZone;
	
	
	
	@FindBy(xpath="//input[@role='searchbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='p-checkbox p-component']//div[@class='p-checkbox-box']")
	WebElement checkedboxApplicableCountries;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement saveButton;
	
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Search Language Name']")
	WebElement searchLang;
	
	
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Search State/Province Code']")
	WebElement searchCityCode;
	
	//input[@type='text' and @placeholder='Search State/Province Code']
	
	
	@FindBy(xpath="(//*[name()='svg'][@class='p-icon pi-filter-icon'])[2]")
	WebElement filterIcon;
	
	@FindBy(xpath="//li[contains(@class, 'p-column-filter-row-item') and text()=' Equals ']")
	WebElement selectEqual;
	
	@FindBy(xpath="//h2[contains(text(), ' Language Master ')]")
	WebElement pageHeader;
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	WebElement selectvalFromDropDown;
	
	
			@FindBy(xpath="(//img[@alt='merx-topbar-logo'])[3]")
			WebElement footerLogo;
			
			  @FindBy(xpath ="//span[text()='Dangerous Goods Master']")
			    WebElement dgMaster;
			  
			  @FindBy(xpath ="//span[text()='Add Dangerous Goods']")
			    WebElement dgMasterAddButton;
			  
			  @FindBy(xpath="//input[@id='dgClassCodeId']")
				WebElement inpDGCode;
			  
			  @FindBy(xpath="//input[@id='dgClassDescriptionId']")
				WebElement inpDGDescription;
	
			  @FindBy(xpath="//span[normalize-space()='Save and Continue']")
			  WebElement btnSaveAndContinue;
			  
			  @FindBy(xpath="//input[@id='dgSubclassCodeId']")
				WebElement inpDGSubclassCode;
			  
			  @FindBy(xpath="//input[@id='dgSubclassDescriptionId']")
				WebElement inpDGSubclassdgSubclassDescription;
			  
			  @FindBy(xpath="//input[@placeholder='UN Number']")
			  WebElement inpUNNumber;
			  
			  @FindBy(xpath="//input[@placeholder='UN Description']")
			  WebElement inpDGUNDesc;			  
			  
			  @FindBy(xpath="//span[contains(@class, 'p-button-label') and contains(text(), 'Add UN Number')]")
			  WebElement btnAddUNNumber;
			  
			  
			  @FindBy(xpath="//div[@id='pn_id_191_content']//p-button[@class='p-element ng-star-inserted']//button[@type='button']")
			  WebElement btnSaveAndContinue1;
			  
			  @FindBy(xpath="//input[@placeholder='Search DG Subclass Code']")
				WebElement searchDGClassCode;
			  
			  
				
             @FindBy(xpath="//span[@role='combobox' and @class='p-element p-dropdown-label p-inputtext p-placeholder ng-star-inserted' and @aria-label='Select DG Class']")
             WebElement filterDGSubclass;
             
             
           //Anjaiahmartha
             
             @FindBy(xpath="//span[text()='Masters']") 
             WebElement Masters;
             @FindBy(xpath="//span[text()='Currency Master']") 
             WebElement currencyMaster;
             @FindBy(xpath="//h2[text()=' Currency Master ']") WebElement currencymasterheader;
             @FindBy(xpath="//span[text()='Add Currency']") WebElement addcurrency;

             @FindBy(css="input#currencyCode") WebElement currencycode;
             @FindBy(css="input#countryCode") WebElement correncyname;
             @FindBy(css="div#applicableCountries") WebElement applicableCountries;
             @FindBy(xpath="//input[@type='text'][@role='searchbox']") WebElement coutryinput;
             @FindBy(css="li#applicableCountries_0") WebElement CountryCheckBoxClick;
             @FindBy(css="div#status") WebElement status_click;
             @FindBy(css="ul[role='listbox'] li") List<WebElement> statusoptions;
             @FindBy(css="input#numberOfDecimals") WebElement decimal_input;
             @FindBy(xpath="//span[.='Save']") WebElement saveButton_;
             @FindBy(xpath="//span[.='Cancel']") WebElement CXancelButton;
             @FindBy(xpath="//span[starts-with(@class,'p-confirm-dialog-message')]") WebElement CancelText;
             @FindBy(xpath="//span[.='No']") WebElement CancelNo;

             @FindBy(css="li#status_0") WebElement ActiveClick;
             @FindBy(css="li#status_1") WebElement InActiveClick;

             //Search and edit 
             @FindBy(xpath="(//tr[starts-with(@class,'remove-in-print ')]/th)[1]//input") WebElement SearchCurrencyCode;
             @FindBy(xpath="(//tr[starts-with(@class,'remove-in-print ')]/th)[2]//input") WebElement SearchCurrencyName;
             @FindBy(xpath="(//td[@id='row.id'])[1]") WebElement threedots;
             @FindBy(xpath="//span[.='Edit']") WebElement edit;
             @FindBy(xpath="//div[@role='checkbox']") WebElement checkbox;
             @FindBy(xpath="//div[starts-with(@class,'p-toast-detail ng-tns-')]") WebElement UpdateSuccess;
             @FindBy(xpath="//div[starts-with(@class,'p-dialog-content ng-')]//span") WebElement status_Confirmation;
             @FindBy(xpath="//span[.='Yes']") WebElement ConfirmYes;
             
           //Country Master
             @FindBy(xpath="//span[.='Country Master']") 
             WebElement CountryMaster;
             @FindBy(xpath="(//span[.='Country Master'])[2]") 
             WebElement AddcountryMasterButton;
             @FindBy(css="input#countryCode") 
             WebElement Countrycode;
             @FindBy(css="input#countryName") 
             WebElement CountryName;
             @FindBy(css="input#isoCode") 
             WebElement ISO1code;
             @FindBy(css="input#isoCode2") 
             WebElement ISO2code;
             @FindBy(css="input#isoCode3") 
             WebElement ISO3code;
             @FindBy(css="div#timeZone") 
             WebElement TimeZone_Click;
             @FindBy(css="li#timeZone_0") 
             WebElement TimezoneCheckBoxOptionCLick; 
             
             //UOMMaster

             @FindBy(xpath="//span[.='UOM Master']") WebElement UOM_Master_Menu;
             @FindBy(xpath="//h2[.=' UOM MASTER ']") WebElement UOMMaster_header;
             @FindBy(xpath="//span[.='Add UOM']") WebElement addUOM_button;
             @FindBy(xpath="//h3[.=' UOM MASTER ']") WebElement addUOM_Master_Header;
             @FindBy(css="input#name") WebElement MeasurementName;
             @FindBy(css="input#symbol") WebElement symbol;
             @FindBy(css="div#metricUnit") WebElement measurementUnit;
             @FindBy(css="div#isActive") WebElement UOM_Status;
             @FindBy(css="li#metricUnit_0") WebElement MeasureUnit_Click;
             @FindBy(css="li#isActive_0") WebElement statusclick;
             
             //Suburb master

             @FindBy(xpath="//span[text()='Suburb Master']") WebElement SuburbMenu;
             @FindBy(xpath="//span[text()='Add Suburbs']") WebElement addSuburbbutton;
             @FindBy(xpath="//h3[text()=' Suburb Master ']") WebElement addsuburnmasterheader;

             @FindBy(css="input#suburbCode") WebElement suburbcode;
             @FindBy(css="input#suburbName") WebElement suburbname;
             @FindBy(css="div#country") WebElement country;
             @FindBy(css="li#country_0") WebElement countryselect;
             @FindBy(css="div#state") WebElement state;
             @FindBy(css="li#state_0") WebElement stateselect;
             @FindBy(css="div#city") WebElement city;
             @FindBy(css="li#city_0") WebElement cityselect;
             @FindBy(css="input#postalCode") WebElement postalcode;
             @FindBy(xpath="//div[@class='p-card-content']/div/h2") WebElement Header_in_view_page;
             @FindBy(xpath="//div[@class='p-card-content']/h3") WebElement header_in_addmaster_page;
             

             //HTS MAster
             
             @FindBy(xpath="//span[text()='HTS Master']") WebElement HTS_MasterMenu;
             @FindBy(xpath="//span[.='Add HTS Code']") WebElement AddHTSMaster_Button;
             @FindBy(css="input#htsCode") WebElement htscode;
             @FindBy(css="input#htsDescription") WebElement htsdescription;
             @FindBy(xpath="(//input[@type='text'][@role='combobox'])[1]") WebElement fromdate_click;
             @FindBy(xpath="(//input[@type='text'][@role='combobox'])[2]") WebElement todate_click;
             @FindBy(xpath="//tbody/tr/td/span") List<WebElement> alldates;
             @FindBy(xpath="(//div[starts-with(@class,'p-datepicker-header ng')]//button)[4]") WebElement calender_next_arrow;
             

             //Sai Kumar
         	@FindBy(xpath="//span[text()='State Master']")
         	WebElement stateMaster;
         	
         	@FindBy(xpath="//span[text()='Add State']")
         	WebElement addStateButton;
         	
         	@FindBy(xpath="//input[@id='stateCode']")
         	WebElement inpStateCode;
         	
         	@FindBy(xpath="//input[@id='stateName']")
         	WebElement inpStateName;
         	
         	@FindBy(xpath="//span[@aria-label='Select Country']")
         	WebElement inpStateCountrydd;
         	@FindBy(xpath="(//li[@id='applicableCountries_0'])[1]")
         	WebElement inpStateCountryList;
         	
         	
         	@FindBy(xpath="//div[@class='p-multiselect-label p-placeholder']")
         	WebElement inpStateTimeZone;
         	
         	@FindBy(xpath="(//*[name()='svg'][@class='p-checkbox-icon p-icon'])[1]")
         	WebElement inpMultiTimeZone;
         	
         	@FindBy(xpath="//span[@class='layout-menuitem-text ng-tns-c3391058336-27']")
         	WebElement inpStateStatus;
         	
         	@FindBy(xpath="//input[@type='text' and @placeholder='Search State/Province Name']")
         	WebElement searchState;
         	
         	//@FindBy(xpath="//input[@type='text' and @placeholder='Search Language Name']")
        	//WebElement searchState;
         	
         	//Sai Kumar

	
    public SystemAndReferenceMasterPage(WebDriver driver) {
    	super(driver);
    	this.client = HttpClients.createDefault();
    }
    private static final Logger LOGGER = Logger.getLogger(SystemAndReferenceMasterPage.class.getName());


    GenericUtilities utils = new GenericUtilities(driver);
    MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
    Apiutilities apiUtils = new Apiutilities();

    MerchandiseGroupPage groupPage = new MerchandiseGroupPage(BaseClass.getDriver());
    MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());

    MerchandiseDepartmentPage deptPage = new MerchandiseDepartmentPage(BaseClass.getDriver());

    MerchandiseClassPage classPage = new MerchandiseClassPage(BaseClass.getDriver());

    MerchandiseSubClassPage subclassPage = new MerchandiseSubClassPage(BaseClass.getDriver());
    
    
    public void clickOnMasterLogMaster() throws InterruptedException
    {
    	//Thread.sleep(60);
    	
    	//utils.fnScreenResolutionExample();

    	//utils.waitForElementclickable(Duration.ofSeconds(60), systemandref);
    	//utils.clickOnWebElement(systemandref);
    	Thread.sleep(5000);
    	utils.waitForElementclickable(Duration.ofSeconds(60), masterMenu);
    	Thread.sleep(2000);
    	//utils.clickElementWithJavaScript(masterMenu);
    	utils.clickOnWebElement(masterMenu);
    	System.out.println("click on Master menu");
    }
    
    
    public void clickOnCityMaster() throws InterruptedException
    {
    	
    	Thread.sleep(20);
    	utils.waitForElementclickable(Duration.ofSeconds(60),cityMaster );
    	utils.clickElementWithJavaScript(cityMaster);
    }
    
    public void clickOnDGMaster() throws InterruptedException
    {
    	Thread.sleep(20);
    	utils.waitForElementclickable(Duration.ofSeconds(60),dgMaster );
    	utils.clickElementWithJavaScript(dgMaster);
    }
   
    
    public void addCityMasterbutton()
    {
    	utils.waitForElementclickable(Duration.ofSeconds(60),cityMasterAddButton );
    	utils.clickElementWithJavaScript(cityMasterAddButton);
    }
    
    
    public void addDGMasterbutton()
    {
    	utils.waitForElementclickable(Duration.ofSeconds(60),dgMasterAddButton);
    	utils.clickElementWithJavaScript(dgMasterAddButton);
    }
    public void selectImage()
    {
       	utils.waitForElementclickable(Duration.ofSeconds(60),logoMaster);
    	utils.clickOnWebElement(logoMaster);
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), desktopSelectdButton);
    	//utils.clickOnWebElement(desktopSelectdButton);
    }
    
    public void validateLanguageMaster(String strLangCode,String strLang ) throws IncorrectXpathException, InterruptedException
    {
    	utils.setValueInEditBox(searchLang, strLang);
    	
    	//utils.doesElementExist(filterIcon);
    	Thread.sleep(2000);
    	
    	searchLang.sendKeys(Keys.ENTER);
    	   	
    	
    	
    	Thread.sleep(5000);
    	
    	
    	/*
    	utils.clickElementWithJavaScript(filterIcon);
    	Thread.sleep(2000);
    	utils.clickElementWithJavaScript(selectEqual);
    	
    	*/
    	
    }
    
    
    public void validateStateMaster(String strcityCode,String strStateName ) throws IncorrectXpathException, InterruptedException
    {
    	
    	
    	Thread.sleep(5000);
    	
    	utils.setValueInEditBox(searchCityCode, strcityCode);
    	
    	//utils.doesElementExist(filterIcon);
    	Thread.sleep(2000);
    	
    	searchCityCode.sendKeys(Keys.ENTER);
    	
    	
    	
    	
    	Thread.sleep(5000);
    }
    	
    public void validateDGyMaster(String strDGCode) throws IncorrectXpathException, InterruptedException
    {
    	//utils.clickElementWithJavaScript(filterDGSubclass);
    	utils.setValueInEditBox(searchDGClassCode, strDGCode);
    	
    	//utils.doesElementExist(filterIcon);
    	Thread.sleep(2000);
    	
    	searchDGClassCode.sendKeys(Keys.ENTER);
    	
    	
    	
    	
    	Thread.sleep(5000);
    }
    public void validateCityMaster(String strcityCode,String strCityName ) throws IncorrectXpathException, InterruptedException
    {
    	utils.setValueInEditBox(searchCityCode, strcityCode);
    	
    	//utils.doesElementExist(filterIcon);
    	Thread.sleep(2000);
    	
    	searchCityCode.sendKeys(Keys.ENTER);
    	
    	
    	
    	
    	Thread.sleep(5000);
    	
    	
    	/*
    	utils.clickElementWithJavaScript(filterIcon);
    	Thread.sleep(2000);
    	utils.clickElementWithJavaScript(selectEqual);
    	
    	*/
    	
    }
    
    public void ClickOnLanguageMaster() throws IncorrectXpathException, InterruptedException
    {
       	Thread.sleep(10000);
    	//utils.waitForElementclickable(Duration.ofSeconds(120),languageMaster);
    	
       	utils.clickOnWebElement(languageMaster);
       	
     	Thread.sleep(10000);
        	
       	utils.clickOnWebElement(addLanguageButton);
       	
       	/*
    	
         String strPageHeader=utils.getText(pageHeader).trim().toLowerCase();
         
         Assert.assertEquals(strPageHeader,"language master");
         
         utils.doesElementExist(footerLogo);
    	
    	//utils.waitForElementclickable(Duration.ofSeconds(60),addLanguageButton );
    	
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(addLanguageButton));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", addLanguageButton);
    	Actions builder = new Actions(driver);
    	builder.moveToElement(addLanguageButton).click().perform();
    	Thread.sleep(2000);
    	addLanguageButton.isDisplayed();  	
    	*/
    	
    	
    	//addLanguageButton.click();
    }
    
    public void AddDGMaster(String strDGCode,String strDGDescription,String strActive,String strDgSubCode,String strDgSubDesc,String inpUNUnimber,String inpUNUDescription) throws InterruptedException
    {
    	utils.waitForElementclickable(Duration.ofSeconds(60), inpDGCode);
    	
    	utils.setValueInEditBox(inpDGCode, strDGCode);
    	
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), inpDGDescription);
    	utils.setValueInEditBox(inpDGDescription, strDGDescription);
    	
    	Mnp.valActivaStatus();
    	
    	utils.clickElementWithJavaScript(btnSaveAndContinue);
    	
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), inpDGSubclassCode);
    	
    	utils.setValueInEditBox(inpDGSubclassCode, strDgSubCode);
    	
    	utils.setValueInEditBox(inpDGSubclassdgSubclassDescription, strDgSubDesc);
    	
    	Mnp.valActivaStatus();
    	
    	String uploadFile = new File("src/test/resources/SamplePNGImage_3mbmb.png").getAbsolutePath();
    	
    	Thread.sleep(500);
    	
    	filepathXapthDG.sendKeys(uploadFile);  
  	  
  		//utils.waitForElementclickable(Duration.ofSeconds(60), desktopUploadButton);
  		
  		System.out.println(inpUNUnimber);
  		
    	utils.setValueInEditBox(inpUNNumber,inpUNUnimber);
    	
    	utils.setValueInEditBox(inpDGUNDesc,inpUNUDescription);
    	
	//utils.clickElementWithJavaScript(checkedboxApplicableCountries);
    	
    	Thread.sleep(2000);
    	
    	utils.clickOnWebElement(btnAddUNNumber);
    	
    	Thread.sleep(10000);
    	
    	//utils.clickElementWithJavaScript(btnSaveAndContinue1); 	   	
    	utils.clickOnWebElement(btnSaveAndContinue1);
    	
    	Thread.sleep(10000);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    public void AddLanguageMaster(String languageCodes, String languageNames, String languageShortNames, String applicableCountries, String status)
    {
    	
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), languageCode);
    	
    	utils.setValueInEditBox(languageCode, languageCodes);
    	
    	utils.setValueInEditBox(languageName, languageNames);
    	
    	utils.setValueInEditBox(languageShortName, languageShortNames);	
    	
    	
    	utils.clickOnWebElement(selectCountry);
    	
    	utils.setValueInEditBox(searchBox, applicableCountries);
    	
    	utils.clickElementWithJavaScript(checkedboxApplicableCountries);
    	
    	Mnp.valActivaStatus();
    	
    	utils.clickElementWithJavaScript(saveButton);
    	
    }
    
    public void AddCityMaster(String cityCodes, String cityNames, String strCountryName, String strSateName,String strStrTimeZone, String status)
    {
    	
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), inpcityCode);
    	
    	utils.setValueInEditBox(inpcityCode, cityCodes);
    	
    	utils.setValueInEditBox(inpcityName, cityNames);
    	
    	//utils.setValueInEditBox(languageShortName, languageShortNames);	
    	
    	
    	utils.clickOnWebElement(selectCountryInCityMasterDrop);
    	
    	//utils.setValueInEditBox(searchBox, applicableCountries);
    	
    	//utils.clickElementWithJavaScript(checkedboxApplicableCountries);
    	
    	 utils.slowkeyenterValue(searchBox, strCountryName,700);
    	 
    	//span[@class='ng-star-inserted']
    	 
      utils.clickOnWebElement(selectStateDrop);
      
      

    	
    	//utils.setValueInEditBox(searchBox, checkectState);
      utils.slowkeyenterValue(searchBox,strSateName,700);
    	
      
      utils.clickOnWebElement(selectTimeZone);
    	
      utils.slowkeyenterValue(searchBox,strStrTimeZone,800);
      
      
      
    	//utils.clickElementWithJavaScript(checkedboxApplicableCountries);
    	
    	Mnp.valActivaStatus();
    	
    	utils.clickElementWithJavaScript(saveButton);
    	
    }
    
    public void imageuploadpath(WebElement element,String path) throws InterruptedException
    {
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), element);
    	utils.uploadFileUsingSendKeys(element, path);
    	
    }

    public void UploadButtonClcik()
    {
    	
    	utils.waitForElementclickable(Duration.ofSeconds(60), desktopUploadButton);
    	utils.clickOnWebElement(desktopUploadButton);
    }
    
    
    
    
    
    public void imageExistAfterUploadDesktop()
    {
    	
    	 try {
    	        imagePresent(validationDesktopImageExists);
    	    } catch (NoSuchElementException e) {
    	        // Handle the case where the element with the provided XPath is not found
    	        System.out.println("Error: Image element not found using the provided XPath.");
    	    } catch (Exception e) {
    	        // Catch other potential exceptions (broader handling)
    	        e.printStackTrace();
    	    }
    }

    
    public void imageExistAfterUploadMobile()
    {
    	
    try {
    	imagePresent(validationMobileImageExists);
    } catch (NoSuchElementException e) {
        // Handle the case where the element with the provided XPath is not found
        System.out.println("Error: Image element not found using the provided XPath.");
    } catch (Exception e) {
        // Catch other potential exceptions (broader handling)
        e.printStackTrace();
    }
}
    
    public void imagePresent(WebElement element)
    {
    	
    try {
		utils.doesElementExist(element);
	} catch (IncorrectXpathException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}
    public void switchToWindowByTitle() {
    	String title="val";
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            
            System.out.println(driver.getTitle());
           // if (driver.getTitle().equals(title)) {
             //   return;
            //}
        }
        //driver.switchTo().window(originalWindow);
        //throw new NoSuchElementException("Window with title '" + title + "' not found");
    }
    
    public void switchBackToOriginalWindow(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }

    
    //***Anji
    
    
    
    
    //HTS MAster
    
  public void addHTSMaster_Click() {
    	utils.explicit_Wait(HTS_MasterMenu, 200);
    	utils.clickElement_using_Size("//span[text()='HTS Master']", HTS_MasterMenu);
    }
  public void addHTS_Button_Click() {
  	utils.explicit_Wait(AddHTSMaster_Button, 200);
  	utils.getSuccessmsg(Header_in_view_page);
  	utils.clickElement_using_Size("//span[.='Add HTS Code']", AddHTSMaster_Button);
  }
  
  public void provideHTSDetails(String HTSCode,String HTSDescription,String status) {
  	utils.getSuccessmsg(Header_in_view_page);
  	String htsCode=HTSCode+randomString();
  	setProperties("HTSCode",htsCode);
  	String htsdes=HTSDescription+randomString_notspecial();
  	setProperties("HTSDescription",htsdes);
  	utils.sendkeys_ele(htscode, htsCode, 100);
  	utils.sendkeys_ele(htsdescription,htsdes,100);
  utils.effective_Frm_Date(fromdate_click, alldates);
  utils.effective_To_Date(todate_click, calender_next_arrow, alldates);
  
  status_Options(status,status_click);
  	
  	validateCancel_Save();
  	
  }
  	
  public void setProperties(String setfor,String code) {
	  String TestData_filePath = "testData/TestData.properties";
	    String Config_filePath ="src/test/resources/config.properties";
	    PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	    testdata.setProperty(setfor, code);
	   
  }
  public String getProperties(String getfor) {
	  String TestData_filePath = "testData/TestData.properties";
	    String Config_filePath ="src/test/resources/config.properties";
	    PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	 return  testdata.getProperty(getfor);
	  
	   
  }
  
  public void updateHTSDetails(String HTSCode,String HTSDescription,String status) {
	  	utils.getSuccessmsg(Header_in_view_page);
	  	utils.sendkeys_ele(htscode, HTSCode+randomString(), 100);
	  	utils.sendkeys_ele(htsdescription,HTSDescription+randomString_notspecial(),100);
	  utils.effective_Frm_Date(fromdate_click, alldates);
	  utils.effective_To_Date(todate_click, calender_next_arrow, alldates);
	  
	  status_Options(status,status_click);
	  	
	  	validateCancel_Save();
	  	
	  }
    
    
  
  //suburb naster
  
  public void addSuburbMenu_Click() {
  	utils.explicit_Wait(SuburbMenu, 200);
  	utils.clickElement_using_Size("//span[text()='Suburb Master']", SuburbMenu);
  }


  public void addSuburb_Button_click() {
  	utils.explicit_Wait(addSuburbbutton, 200);
  	String header=utils.clickElement_using_Size_getText("//div[@class='p-card-content']/div/h2", Header_in_view_page);
  	System.out.println(header);
  	utils.clickElement_using_Size("//span[text()='Add Suburbs']", addSuburbbutton);
  }

  public void provideSuburbDetails(String suburbco,String suburbna,String countryse,String statese,String cityse,String postalcodese,String status) {
  	utils.getSuccessmsg(addsuburnmasterheader);
  	utils.sendkeys_ele(suburbcode, suburbco+randomString(), 100);
  	utils.sendkeys_ele(suburbname,suburbna+randomString(),100);
  	
  	utils.coutry_Select(country, countryse, coutryinput,countryselect, 150);
  	utils.coutry_Select(state, statese, coutryinput,stateselect, 200);
  	utils.coutry_Select(city, cityse, coutryinput,cityselect, 200);
  	utils.sendkeys_ele(postalcode,postalcodese,100);
  status_Options(status,status_click);
  	
  	validateCancel_Save();
  	
  	
  	
  	
  }

  public void updateSuburbDetails(String subname,String countryse,String statese,String cityse,String postalse,String statusop) {
  	try {
  		Thread.sleep(300);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	String header=utils.getSuccessmsg(header_in_addmaster_page);
  	System.out.println(header.trim());
  	utils.javascriptexecuterfor_sendkeys(suburbname,subname+randomString(),100);
  	
  	utils.coutry_Select(country, countryse, coutryinput,countryselect, 150);
  	utils.coutry_Select(state, statese, coutryinput,stateselect, 150);
  	utils.coutry_Select(city, cityse, coutryinput,cityselect, 150);
 
  utils.sendkeys_ele(postalcode, postalse, 200);
  	status_Options(statusop,status_click);
  	
  	validateCancel_Save();
  	
  	
  	
  }
  
  
  // UOM
  
  public void uom_Master_Menu_Click() {
  	utils.explicit_Wait(UOM_Master_Menu, 200);
  	utils.clickElement_using_Size("//span[.='UOM Master']", UOM_Master_Menu);
  	
  }
  public void click_AddUOM() {
  	utils.explicit_Wait(UOMMaster_header, 200);
  	String Actual=" UOM MASTER ".trim();
  	String expected=utils.getSuccessmsg(UOMMaster_header);
  	org.testng.Assert.assertEquals(expected, Actual);
  	utils.clickElement_using_Size("//span[.='Add UOM']", addUOM_button);
  }

  public void provideUOMDetails(String measurename,String sym,String MeasureUnit,String status) {
  	utils.getSuccessmsg(addUOM_Master_Header);
  	utils.sendkeys_ele(MeasurementName, measurename+randomString(), 100);
  	utils.sendkeys_ele(symbol,sym+randomString(),100);
  	
  	utils.coutry_Select(measurementUnit, MeasureUnit, coutryinput,MeasureUnit_Click, 150);
  	status_Options(status,UOM_Status);
  	
  	validateCancel_Save();
  	
  	
  	
  }
  public void updateUOMDetails(String measurename,String sym,String MeasureUnit,String status) {
  	try {
  		Thread.sleep(300);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	utils.getSuccessmsg(addUOM_Master_Header);
  	utils.javascriptexecuterfor_sendkeys(MeasurementName,measurename+randomString(),100);
  	utils.slowSendKeys(symbol, sym, 250);
  	
  	
  	utils.coutry_Select(measurementUnit, MeasureUnit, coutryinput,MeasureUnit_Click, 150);
  	//status_Options(status,UOM_Status);
  	uom_Status_Options(status, UOM_Status, coutryinput,statusclick);
  	validateCancel_Save();
  	
  	
  	
  }
  
  // country master
  

  public void countryMasterMenu_Click() {
  	utils.explicit_Wait(CountryMaster, 200);
  	utils.clickElementWithJavaScript1(CountryMaster);
  }
  public void addCountryMasterClick() {
  	utils.explicit_Wait(AddcountryMasterButton, 220);
  	utils.clickElementWithJavaScript(AddcountryMasterButton);
  }


  public void provideCountryDetails(String ccode,String cname,String ISO1,String ISO2,String ISO3,String selectTimeZone,String status) {
  	utils.sendkeys_ele(Countrycode, ccode+randomString(), 10);
  	utils.sendkeys_ele(CountryName,cname+randomString(),10);
  	utils.sendkeys_ele(ISO1code, ISO1+randomString(), 200);
  	utils.sendkeys_ele(ISO2code, ISO2+randomString(), 200);
  	utils.sendkeys_ele(ISO3code, ISO3+randomString(), 200);
  	utils.coutry_Select(TimeZone_Click, selectTimeZone, coutryinput,TimezoneCheckBoxOptionCLick, 150);
  	status_Options(status,status_click);
  	
  	validateCancel_Save();
  	
  	
  	
  }
  public void updateCountryDetails(String cname,String ISO1,String ISO2,String ISO3,String selectTimeZone,String status) {
  	try {
  		Thread.sleep(300);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	utils.javascriptexecuterfor_sendkeys(CountryName,cname+randomString(),50);
  	utils.slowSendKeys(ISO1code, ISO1+randomString(), 250);
  	utils.sendkeys_ele(ISO2code, ISO2+randomString(), 200);
  	utils.sendkeys_ele(ISO3code, ISO3+randomString(), 200);
  	
  	utils.updateCountrySelectcoutry_Select(TimeZone_Click, selectTimeZone, coutryinput,checkbox,TimezoneCheckBoxOptionCLick, 200);
  	status_Options(status,status_click);
  	
  	validateCancel_Save();
  	
  	
  	
  }

  public void validateCancel_Save() {
  	utils.clickElementWithJavaScript1(CXancelButton);
  	String getCancelText=utils.getSuccessmsg(CancelText);
  	System.out.println(getCancelText);
  	utils.clickElementWithJavaScript1(CancelNo);
  	utils.clickElementWithJavaScript1(saveButton_);
  }

  public String randomString() {
  	String alpha="AbCDef123456cndjcu78jbkqs2d98@@&^H&%^)(^%$";
  	Random ran=new Random();
  	StringBuffer sb=new StringBuffer();
  	int len=3;
  	for(int i=0;i<len;i++) {
  		int index=ran.nextInt(alpha.length());
  		char rch=alpha.charAt(index);
  		sb.append(rch);
  		
  		
  	}
  	return sb.toString();
  }

  public String randomString_notspecial() {
  	String alpha="AbCDef123456cndjcu78jbkqs2d98H";
  	Random ran=new Random();
  	StringBuffer sb=new StringBuffer();
  	int len=10;
  	for(int i=0;i<len;i++) {
  		int index=ran.nextInt(alpha.length());
  		char rch=alpha.charAt(index);
  		sb.append(rch);
  		
  		
  	}
  	return sb.toString();
  }

// currency master 
  

  public void masterClick() {
  	try {
  		utils.explicit_Wait(Masters,120);
  		utils.clickElementWithJavaScript1(Masters);
  	}catch(Exception e) {
  		e.printStackTrace();
  	}
  }

  public void currencyMastermasterClick() {
  	
  		utils.explicit_Wait(currencyMaster,120);
  		utils.clickElementWithJavaScript1(currencyMaster);
  	
  }

  public String addCurrencyMaster_Click()
  {
  	
  	utils.explicitWat_click(currencymasterheader);
  	String  headercur=utils.getSuccessmsg(currencymasterheader);
  	return headercur;
  	
  	
  	
  	
  	
  	
  	

  }
  public void addCurrency_Click() {
  	utils.explicit_Wait(addcurrency, 120);
  	utils.clickElementWithJavaScript1(addcurrency);
  }

  public void provideCurrencyDetails(String ccode,String cname,String countries,String status,String decimals) {
  	utils.sendkeys_ele(currencycode, ccode+randomString(), 10);
  	utils.sendkeys_ele(correncyname,cname+randomString(),10);
  	utils.coutry_Select(applicableCountries, countries, coutryinput, CountryCheckBoxClick,15);
  	status_Options(status,status_click);
  	
  	
  	utils.sendkeys_ele(decimal_input, decimals, 10);
  	utils.clickElementWithJavaScript1(CXancelButton);
  	String getCancelText=utils.getSuccessmsg(CancelText);
  	System.out.println(getCancelText);
  	utils.clickElementWithJavaScript1(CancelNo);
  	utils.clickElementWithJavaScript1(saveButton_);
  	
  }
  public void updateCurrencyDetails(String cname,String countries,String status,String decimals) {
  	
  	utils.javascriptexecuterfor_sendkeys(correncyname,cname+randomString(),10);
  	utils.updateCountrySelectcoutry_Select(applicableCountries, countries, coutryinput,checkbox, CountryCheckBoxClick,200);
  	status_Options(status,status_click);
  //	utils.getSuccessmsg(status_Confirmation);
  	//utils.clickElement_using_Size("//div[starts-with(@class,'p-dialog-content ng-')]//span", ConfirmYes);
  	
  	utils.sendkeys_ele(decimal_input, decimals, 100);
  	validateCancel_Save();
  	
  }

  public void status_Options(String status, WebElement statusele) {
  	utils.explicit_Wait(statusele, 100);
  	utils.clickElementWithJavaScript1(statusele);
  	for(WebElement sta:statusoptions) {
  		if(sta.getText().equalsIgnoreCase(status)) {
  			sta.click();
  			break;
  		}
  	}
  }

  public void uom_Status_Options(String status, WebElement statusele,WebElement statu,WebElement click) {
  	utils.explicit_Wait(statusele, 100);
  	
  	utils.clickElementWithJavaScript1(statusele);
  	utils.slowSendKeys(coutryinput, status, 15);
  	click.click();
  }

  public void provide_details_forSearchField(String ccode,String cname) {
  
  	utils.wiatScreen(3000);
  	utils.search_filter_select(SearchCurrencyCode, ccode, SearchCurrencyName, cname);
  	utils.edit_Click(threedots, edit);
  	
//  	utils.sendkeys_ele(SearchCurrencyCode, ccode, 200);
//  	utils.sendkeys_ele(SearchCurrencyName, cname, 200);
  	
  }
  public void getMessage(String str) {
  	String Actual=str.trim();
  	try {
  		Thread.sleep(1000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	utils.explicit_Wait(UpdateSuccess, 200);
  	String expected=utils.getSuccessmsg(UpdateSuccess);
       System.out.println(expected);
       Assert.assertEquals(expected.trim(), Actual);
  }
  
    
    //*** end by Anji
    
//Sai Kumar
  public void clickOnStateMaster() throws InterruptedException
  {
  	//Thread.sleep(60);

  	//utils.waitForElementclickable(Duration.ofSeconds(60), systemandref);
  	//utils.clickOnWebElement(systemandref);
  	Thread.sleep(20);
  	utils.waitForElementclickable(Duration.ofSeconds(60),stateMaster );
  	utils.clickElementWithJavaScript(stateMaster);
  }
  
  public void addStateMasterbutton()
  {
  	utils.waitForElementclickable(Duration.ofSeconds(60),addStateButton );
  	utils.clickElementWithJavaScript(addStateButton);
  }
  
  public void addStateMaster(String stateCodes, String stateNames, String associatedCountries, String timeZones, String status) throws InterruptedException
  {
  	
  	
  	utils.waitForElementclickable(Duration.ofSeconds(60), inpStateCode);
  	
  	utils.setValueInEditBox(inpStateCode, stateCodes);
  	
  	utils.setValueInEditBox(inpStateName, stateNames);
  	
  	utils.clickOnWebElement(inpStateCountrydd);	
  	
  	utils.setValueInEditBox(searchBox, associatedCountries);
  	
  	utils.clickOnWebElement(inpStateCountryList);
  	utils.clickOnWebElement(selectCountry);
  	
  	utils.clickOnWebElement(inpStateTimeZone);
  	Thread.sleep(3000);
      utils.setValueInEditBox(searchBox,timeZones);
      
      utils.clickElementWithJavaScript(checkedboxApplicableCountries);
     
      
  	Mnp.valActivaStatus();
  	
  	utils.clickElementWithJavaScript(saveButton);
  	
  }
  //Sai Kumar

  
    public void erroValidation(String strtype,String strSize,String strcolor) throws InterruptedException, AWTException
    {
    	
Thread.sleep(2000);
    	
  
    	
    	 if (strtype.equals("Desktop")) {
    		 
    		 if (strSize.equalsIgnoreCase("less than 5MB"))
    		  {
    		    	String uploadFile1 = new File("src/test/resources/SamplePNGImage_3mbmb.png").getAbsolutePath();
    		    	
    		    	  Thread.sleep(2000);
    		    	  filepathXapth.sendKeys(uploadFile1);  
    		    	  
    		    		utils.waitForElementclickable(Duration.ofSeconds(60), desktopUploadButton);
    		        	utils.clickOnWebElement(desktopUploadButton);
    		        	
    		        	
    		  }
    		  else
    		  {
    			  String uploadFile2 = new File("src/test/resources/SamplePNGImage_10mbmb.png").getAbsolutePath();
    		  	
    		
    	 
		filepathXapth.sendKeys(uploadFile2);
       
    	Thread.sleep(2000);
    
    		  
      	
    
    	
    	Thread.sleep(2000);
    	utils.validateImageUpload(validationDesktopImazeSize, strcolor);
    		  }
    	}
    		 
    	
    	else
    	{
    		 if (strSize.equalsIgnoreCase("less than 5MB"))
   		  {
   		    	String uploadFile1 = new File("src/test/resources/SamplePNGImage_3mbmb.png").getAbsolutePath();
   		    	
   		    	  Thread.sleep(2000);
   		    	filepathXapthMob.sendKeys(uploadFile1); 
   		     utils.waitForElementclickable(Duration.ofSeconds(60), mobilepUploadButton);
 	    	utils.clickOnWebElement(mobilepUploadButton);
 	    	
 	    	Thread.sleep(2000);
 	    	utils.validateImageUpload(validationMobileImazeSize, strcolor);
   		  }
   		  else
   		  {
   			  String uploadFile2 = new File("src/test/resources/SamplePNGImage_10mbmb.png").getAbsolutePath();
   		  	
   			  Thread.sleep(2000); 
    		
    		
			filepathXapthMob.sendKeys(uploadFile2);
			Thread.sleep(2000);
 	    	utils.validateImageUpload(validationMobileImazeSize, strcolor);
			
   		  }
    		
    	}
    	
    }
    }

    
    

    
    


   
   
    
