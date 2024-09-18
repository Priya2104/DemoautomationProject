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

    public void createWebOrder() throws InterruptedException {
    	//utils.waitForElementToBeVisiblewithFluentWait(lnkOrder, 3);
    	Thread.sleep(10000);
    
    	utils.clickElementWithJavaScript(lnkOrder);
        
    }

    public void PageCheck() throws IncorrectXpathException, InterruptedException
    {
    	//utils.waitForElementToBeVisiblewithFluentWait(PgWebOrders, 3);
    	Thread.sleep(10000);
    	utils.doesElementExist(PgWebOrders);
    }
    

	}