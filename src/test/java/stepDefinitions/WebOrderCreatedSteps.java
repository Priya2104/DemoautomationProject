package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.WebOrderCreatedPage;
import utilities.GenericUtilities;
import utilities.PropertiesReader;
import utilities.GenericUtilities.IncorrectXpathException;

public class WebOrderCreatedSteps {

	WebDriver driver;

	
	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);  
	GenericUtilities utils = new GenericUtilities(driver);

	WebOrderCreatedPage WebOrderCreatePage = new WebOrderCreatedPage(BaseClass.getDriver());
	

	
	@When("I Create Web Order")
	public void I_Create_Web_Order() throws InterruptedException {
		WebOrderCreatePage.createWebOrder();
		
		
	}
	
	 @Then("The user should be redirected to the WeBpage Page")
	    public void The_user_should_be_redirected_to_the_WeBpage_Page() throws InterruptedException, IncorrectXpathException {
	       
		   
		      Thread.sleep(1000);
	    	WebOrderCreatePage.PageCheck();
	        
	        
	    }
	 
	  @When("create Product information")
	    public void create_Product_information() throws InterruptedException {
	    WebOrderCreatePage.productInformation("FamilyAlbum","10");	
	      Thread.sleep(10000);
	    }

	 
	  @When("Enter Address Information")
	  public void iEnterTheAddressInformation() {
		  
		  
		  WebOrderCreatePage.adressInformation("MARCIN","MIGBALAJINAGAR","Hyderabad","500072");
		  
		 
		  
		  
	   
	  }
	
		

	}