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

public class WebOrderCreatedPage extends BasePage {
    //WebDriverWait wait;
    //WebDriver driver;

    public WebOrderCreatedPage(WebDriver driver) {
        super(driver);

    }

    GenericUtilities utils = new GenericUtilities(driver);


    WebOrderLoginPage Mlp;

    public Properties p;
    Actions actions = new Actions(driver);

    //workings -MerchandiseGroup GroupPage = new MerchandiseGroup(BaseClass.getDriver());


    @FindBy(xpath = "//a[@href and text()='Order']")
    WebElement lnkOrder;
	
	@FindBy(xpath="//*[text()='Web Orders']")
	 WebElement PgWebOrders;
	

	@FindBy(xpath="//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
	 WebElement Product;
     
	@FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
	 WebElement Quantity;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_txtName']")
	WebElement Customername;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
	WebElement street;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
	WebElement Zip;
		
		
		

    public void createWebOrder() throws InterruptedException {
    	//utils.waitForElementToBeVisiblewithFluentWait(lnkOrder, 3);
    	Thread.sleep(1000);
    
    	utils.clickElementWithJavaScript(lnkOrder);
        
    }

    public void PageCheck() throws IncorrectXpathException, InterruptedException
    {
    	//utils.waitForElementToBeVisiblewithFluentWait(PgWebOrders, 3);
    	Thread.sleep(1000);
    	utils.doesElementExist(PgWebOrders);
    }
    
    public void productInformation(String strproductvalue,String Quantityvalue) throws InterruptedException {
    	utils.selectValueFromDropdownByVisibleText(Product,strproductvalue);
    	//Quantity.clear();
    	//utils.setValueInEditBox(Quantity,Quantityvalue);
    	
    	WebElement element = Quantity;

    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].value='';", element);
    	element.sendKeys((Quantityvalue).trim());
    	
    	Thread.sleep(1000);
    	
    }
    
    public void adressInformation(String strCustomerName,String strstreet,String strcity,String pinzip)
    {
    	
    	utils.setValueInEditBox(Customername, strCustomerName);
    	
    	utils.setValueInEditBox(street, strstreet);
    	
    	utils.setValueInEditBox(city, strcity);
    	
    	utils.setValueInEditBox(Zip, pinzip);
    	
    	
    }
    
    

	}