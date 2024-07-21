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
import utilities.GenericUtilities.IncorrectXpathException;

public class SystemParametersPage extends BasePage {
    
    public SystemParametersPage(WebDriver driver) {
        super(driver);

    }

    GenericUtilities utils = new GenericUtilities(driver);


   	MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());

    MerxLoginPage Mlp;

    public Properties p;
    Actions actions = new Actions(driver);



    @FindBy(xpath = "//input[@id='departmentId']")
    WebElement inDeptID;

    @FindBy(xpath = "//span[contains(text(), 'System Parameters')]")
	WebElement systemparameterMenu;
    
    @FindBy(xpath = "//span[contains(text(), 'Alternate Hierarchy')]")
    WebElement AlternateHierarchy;
    
    //@FindBy(xpath = "//span[contains(text(), 'Alternate Hierarchy')]")
    @FindBy(xpath = "//span[@class='p-tabview-title ng-star-inserted' and text()='Alternate Hierarchy']")

    WebElement systemParamterbutton;
    
    @FindBy(xpath="//button/span[contains(.,'Save and Apply')]")
    WebElement saveAndContinue;
    
    @FindBy(xpath="//input[@id='althierchyName']")
    WebElement inpAlternateHierarchy;
    
    
    public void clickOnSystemParameterMenu() throws InterruptedException {
		
		Thread.sleep(5000);
		utils.waitForElementclickable(Duration.ofSeconds(60), systemparameterMenu);
		
		
		utils.clickOnWebElement(systemparameterMenu);
		System.out.println("click on system paramter menu");
	}
    
    public void clickAlternateHierarchy() throws InterruptedException
    {
    	Thread.sleep(10000);
    	utils.clickableElement(AlternateHierarchy);
    	
    }
    
    public void clickOnSystemParamterButton() throws InterruptedException
    {
    	Thread.sleep(60000);
    	utils.clickableElement(systemParamterbutton);
    }
    
    public void submitAlternateHierarhy(String AlternateHierarchy,String Description) throws InterruptedException
    
    
    {
    	
    	
    	utils.setFieldValue(inDeptID, AlternateHierarchy, "AlternateHierarchy");
    	
    	utils.setFieldValue(inDeptID, Description, "Description");
    	
    	
    	utils.clickOnWebElement_click(saveAndContinue);
    	
    	
    }
    
    
    
    /*
    
    public void validateCityMaster(String strHierarchy)
			throws IncorrectXpathException, InterruptedException {
		utils.setValueInEditBox(inpAlternateHierarchy,strHierarchy);

				Thread.sleep(2000);

		searchCityCode.sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		/*
		 * utils.clickElementWithJavaScript(filterIcon); Thread.sleep(2000);
		 * utils.clickElementWithJavaScript(selectEqual);
		 * 
		 */

	
    
    
    
	}