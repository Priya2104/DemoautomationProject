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
	
	@FindBy(xpath="//input[@placeholder='Search City Code']")
	WebElement searchCityCode;
	
	
	
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
			  
			  
			  @FindBy(xpath="(//*[contains(text(), 'Save and Continue')])[2]")
			  WebElement btnSaveAndContinue1;
			  
			  @FindBy(xpath="//input[@placeholder='Search DG Subclass Code']")
				WebElement searchDGClassCode;
			  
			  
				
             @FindBy(xpath="//span[@role='combobox' and @class='p-element p-dropdown-label p-inputtext p-placeholder ng-star-inserted' and @aria-label='Select DG Class']")
             WebElement filterDGSubclass;

	
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
       	Thread.sleep(5000);
    	utils.waitForElementclickable(Duration.ofSeconds(120),languageMaster);
    	utils.clickOnWebElement(languageMaster);
    	
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
    	
    	
    	
    	addLanguageButton.click();
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
    	
    	String uploadFile = new File("src/test/resources/Warehouse Add.png").getAbsolutePath();
    	
    	Thread.sleep(4000);
    	
    	filepathXapthDG.sendKeys(uploadFile);  
  	  
  		//utils.waitForElementclickable(Duration.ofSeconds(60), desktopUploadButton);
  		
  		System.out.println(inpUNUnimber);
    	utils.setValueInEditBox(inpUNNumber,inpUNUnimber);
    	
    	utils.setValueInEditBox(inpDGUNDesc,inpUNUDescription);
    	
	//utils.clickElementWithJavaScript(checkedboxApplicableCountries);
    	
    	Mnp.valActivaStatus();
    	
    	utils.clickElementWithJavaScript(btnAddUNNumber);
    	
    	
    	utils.clickElementWithJavaScript(btnSaveAndContinue1); 	   	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
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

    
    

    
    


   
   
    
