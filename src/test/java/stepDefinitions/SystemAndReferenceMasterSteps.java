package stepDefinitions;

import java.awt.AWTException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseClassPage;
import pageObjects.MerchandiseDepartmentPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import pageObjects.MerchandisePage;
import pageObjects.MerchandiseSubClassPage;
import pageObjects.SystemAndReferenceMasterPage;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;
import utilities.PropertiesReader;

public class SystemAndReferenceMasterSteps {
	WebDriver driver;
	String Subclass_name, SubClass_Value;
	
	
	public static String cityCode,cityName;
	public static String langCode,langName,langshortcode;
	public static String DgSubClassCode,inpUNUnimber;
	
	
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	
	GenericUtilities utils = new GenericUtilities(driver);
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	MerchandiseDepartmentPage DepartmentPage = new MerchandiseDepartmentPage(BaseClass.getDriver());
	MerchandiseClassPage ClassPage = new MerchandiseClassPage(BaseClass.getDriver());
	MerchandiseSubClassPage SubClassPage = new MerchandiseSubClassPage(BaseClass.getDriver());
	SystemAndReferenceMasterPage sysandrefmaster=new SystemAndReferenceMasterPage(BaseClass.getDriver());

	 MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
	
	@When("I click on LANGUAGE MASTER")
	public void clickLanguageMasterButton() throws InterruptedException, IncorrectXpathException {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.ClickOnLanguageMaster();
	}
	

	@When("I create a new LANGUAGE MASTER {string},{string},{string},{string},{string}")
	public void createNewLanguageMaster(String languageCode, String languageName, String languageShortName, String applicableCountries, String status)  {
		
		 langCode=languageCode+utils.generateRandomChars(6);
		 
		 System.out.println(langCode);
		 langName=languageName+utils.generateRandomChars(6);
		 
		 System.out.println(langName);
		 
		 langshortcode=languageShortName+utils.generateRandomChars(3);
		 
		 		 
		sysandrefmaster.AddLanguageMaster(langCode, langName, langshortcode, applicableCountries, status);
	}

	@Then("I should validate LANGUAGE MASTER in the table")
	public void validateLanguageMasterInTable() throws IncorrectXpathException, InterruptedException {
		
		
	   
	        
	       sysandrefmaster.validateLanguageMaster(langCode,langName);
			
			   String strlangCode = Mnp.getCellValue(3, 1);
		        System.out.println(strlangCode);

		        System.out.println(strlangCode);

		        Assert.assertEquals(strlangCode,langCode);
		        
		        String strlangName = Mnp.getCellValue(3, 2);
		        System.out.println(strlangName);

		        System.out.println(strlangName);

		        Assert.assertEquals(strlangName,langName);      
		           
		        
		    	//sysandrefmaster.validateLanguageMaster(langCode,langName);  
		
		
	}
	
	@Then("I should validate CITY MASTER in the table")
	public void validateCityMasterInTable() throws IncorrectXpathException, InterruptedException {
		
		//span[@role='combobox' and @aria-label='Select Time Zone']
	
		
		sysandrefmaster.validateCityMaster(cityCode,cityName);
		
		   String strcityCode = Mnp.getCellValue(3, 1);
	        System.out.println(strcityCode);

	        Assert.assertEquals(strcityCode,cityCode);
	        
	        String strCityName = Mnp.getCellValue(3, 2);
	        System.out.println(strCityName);
	   
	        Assert.assertEquals(strCityName,cityName);   
	           
	        
	        
		
		
	}
	
	@Then("I should validate DG MASTER in the table")
	public void validate_DG_MASTER_Table() throws IncorrectXpathException, InterruptedException
	{
		sysandrefmaster.validateDGyMaster(DgSubClassCode);
		
		   String strDGSubClass = Mnp.getCellValue(3, 3);
	        System.out.println(strDGSubClass);

	        Assert.assertEquals(strDGSubClass,DgSubClassCode);
	        
	       // String strCityName = Mnp.getCellValue(3, 2);
	        //System.out.println(strCityName);
	   
	  //      Assert.assertEquals(strCityName,cityName);  
		
	}
	
	@When("I click on CITY MASTER")
     public void I_click_on_CITY_MASTER () throws InterruptedException
     {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.clickOnCityMaster();
     }
	
	
	//**
	@When("I click on DG MASTER")
    public void I_click_on_DG_MASTER () throws InterruptedException
    {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.clickOnDGMaster();
    }
	
	@When("I create a new DG MASTER {string},{string},{string},{string},{string},{string}")
	public void createNewDGeMaster(String dgCode,String dgDescription,String status,String strDgSubClass,String strDgSubDesc,String inpUNUDescription) throws InterruptedException  {
		
		DgSubClassCode=strDgSubClass+utils.generateRandomChars(6);
		
		System.out.println(DgSubClassCode);
		 
		inpUNUnimber=utils.generateRandomNumbers(4);
		
		System.out.println(inpUNUnimber);
		// Sy	// Sysm.out.println(cityCode);sm.out.println(cityCode);
		// cityName=cityNameMaster+utils.generateRandomChars(6);
		 
		// System.out.println(langName);
		sysandrefmaster.addDGMasterbutton();
		sysandrefmaster.AddDGMaster(dgCode,dgDescription,status,DgSubClassCode,strDgSubDesc,inpUNUnimber,inpUNUDescription);
	}

	
	//***
	
	@When("I create a new CITY MASTER {string},{string},{string},{string},{string},{string}")
	public void createNewCityeMaster(String cityCodeMaster, String cityNameMaster, String strCountryName, String strSateName, String strStrTimeZone,String status)  {
		
		 cityCode=cityCodeMaster+utils.generateRandomChars(6);
		 
		 System.out.println(cityCode);
		 cityName=cityNameMaster+utils.generateRandomChars(6);
		 
		// System.out.println(langName);
		sysandrefmaster.addCityMasterbutton();
		sysandrefmaster.AddCityMaster(cityCode, cityName,  strCountryName, strSateName,strStrTimeZone, status
);
	   
	}

	 
		@When("I click on Logo Master")
		public void I_click_on_Logo_Master() throws InterruptedException {
			{
				sysandrefmaster.clickOnMasterLogMaster();
				sysandrefmaster.selectImage();			
				
				
			}
		}

	
		@When("I upload an image for {string} logo less {string} {string}")
		public void I_upload_an_image_for_Desktop_logo_less_than_5MB(String strType,String strSize,String strColor) throws InterruptedException, AWTException {
			
			sysandrefmaster.erroValidation(strType,strSize,strColor);
		}
		
		
		@When("I upload an image for {string} logo {string} {string}")
		public void I_upload_an_image_for_Desktop_logo_more_than_5MB(String strType,String strSize,String strColor) throws InterruptedException, AWTException
		{
			sysandrefmaster.erroValidation(strType,strSize,strColor);
		}

		@Then("I should validate upload image {string}")
		public void I_should_see_a_success_message_for_the_upload(String imageType) {

		    // Use a switch statement for cleaner conditional logic
		    switch (imageType.toLowerCase()) {
		        case "desktop":
		            sysandrefmaster.imageExistAfterUploadDesktop();
		            break;
		        case "mobile":
		            sysandrefmaster.imageExistAfterUploadMobile();
		            break;
		        default:
		            throw new IllegalArgumentException("Invalid image type: " + imageType);
		    }
		}

		
		@Then("The uploaded image is displayed correctly")
		public void The_uploaded_image_is_displayed_correctly()
		
		{
		
			
		}
		
}
