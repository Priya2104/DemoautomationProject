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
import org.testng.Assert;

import factory.BaseClass;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;

public class SystemParametersPage extends BasePage {
    
    public SystemParametersPage(WebDriver driver) {
        super(driver);

    }

    GenericUtilities utils = new GenericUtilities(driver);


   	MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
   	
   	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
   	
    SystemAndReferenceMasterPage sysandrefmaster = new SystemAndReferenceMasterPage(BaseClass.getDriver());

    MerxLoginPage Mlp;

    public Properties p;
    Actions actions = new Actions(driver);



    @FindBy(xpath = "//input[@id='departmentId']")
    WebElement inDeptID;

    @FindBy(xpath = "//span[contains(text(), 'System Parameters')]")
	WebElement systemparameterMenu;
    
    @FindBy(xpath = "//span[contains(text(), 'Alternate Hierarchy')]")
    WebElement AlternateHierarchy;
    
    @FindBy(xpath = "//span[contains(text(), 'Item Settings')]")
    WebElement ItemSettingTab;
    
    //@FindBy(xpath = "//span[contains(text(), 'Alternate Hierarchy')]")
    @FindBy(xpath = "//span[@class='p-tabview-title ng-star-inserted' and text()='Alternate Hierarchy']")
    WebElement systemParamterbutton;
    
    @FindBy(xpath="(//span[text()='Save & Apply'])[2]")
    WebElement saveAndContinue;
    
    @FindBy(xpath="//input[@id='althierchyName']")
    WebElement inpAlternateHierarchy;
    
    @FindBy(xpath="//textarea[@id='althierchyDescription']")
    WebElement inpSearchBoxAlternateHierarchy;
    
    @FindBy(xpath="//input[@class='p-multiselect-filter p-inputtext p-component']")
    WebElement inpSearch;
    
    @FindBy(xpath="//input[@id='itemType']")
    WebElement inpItemType;
    
    @FindBy(xpath="//div[@id='itemTypeId']")
    WebElement inpItemTypevalidate;
    
    @FindBy(xpath="//input[@id='itemType']/..//..//..//span[text()='Save & Apply']")
    WebElement btnSaveAndApply;
    
    @FindBy(xpath="//ul[@role='tablist']//span[text()='Reporting Category']")
    WebElement ReportingCatogory;
    @FindBy(css="input#name")
    WebElement reporingsenddata;
    @FindBy(css="input#referenceNo1")
    WebElement repref1;
    @FindBy(css="input#referenceNo2")
    WebElement repref2;
    @FindBy(css="div#isActive")
    WebElement statusclick;
    @FindBy(css="ul#isActive_list li span[class='ng-star-inserted']")
    List<WebElement> repstatusoptions;
    @FindBy(xpath="(//div[@class='ng-star-inserted'])[2]//span[text()='Save & Apply']")
    WebElement repsavebutton;
    @FindBy(xpath="//div[@class='p-dropdown p-component p-inputwrapper']")
    WebElement ReportingCategoryselct;
    @FindBy(css="span[class='ng-star-inserted']")
    WebElement reportinggettext;
    
    
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
    	Thread.sleep(6000);
    	utils.clickElementWithJavaScript1(systemParamterbutton);
    }
    
    public void submitAlternateHierarhy(String AlternateHierarchy,String Description) throws InterruptedException
    
    
    {
    	
    	utils.sendkeys_ele(inpAlternateHierarchy, AlternateHierarchy, 120);
    	//utils.setFieldValue(inpAlternateHierarchy, AlternateHierarchy, "AlternateHierarchy");
    	
    	utils.sendkeys_ele(inpSearchBoxAlternateHierarchy, Description, 120);
    	
    	   	
    	
    	utils.clickOnWebElement_click(saveAndContinue);
    	
    	
    }
    
    public void createItemSetting(String itemTypeval) throws InterruptedException
    {
    	
    	utils.sendkeys_ele(inpItemType,itemTypeval,120);
    	
    	Thread.sleep(1000);
    	
    	utils.clickElementWithJavaScript(btnSaveAndApply);
    }
    
    public void clickonAlternateHierarchy(String strAlternateHierarchy) throws InterruptedException
    {
    	Mnp.clickOnAlterNative();
    	
    	 Thread.sleep(1000);
    	utils.sendkeys_ele(inpSearch, strAlternateHierarchy, 120);
    	
    	//utils.setFieldValue(inpSearchBoxAlternateHierarchy, strAlternateHierarchy, "Alternate Hierarchy");
    }
    
   
    public void clickItemSetting() throws InterruptedException
    {
    
    	Thread.sleep(5000);
    	utils.clickElementWithJavaScript(ItemSettingTab);
    
    
    }
    
    public void validateItemTypeinBu(String itemTypeval) throws InterruptedException
    {
    	Thread.sleep(10000);
    	 //utils.clickElementWithJavaScript(MndivisionPage.ItemTypeClcik);
    	 
    	 MndivisionPage.selectItemType(itemTypeval);
    	 
    	 System.out.println(itemTypeval);
    	 
    	 Thread.sleep(10000);
    	 
    	 String strvalItemType=validateItemType();
    	 
    	 
    	 
    	    System.out.println(strvalItemType);
    	    
    	    Assert.assertEquals(strvalItemType.trim(), itemTypeval.trim(), "The item type does not match the expected value.");
    	 
    	
    }
    
    public String validateItemType()
    {
    
    String strvalItemType=utils.getText(inpItemTypevalidate);
    
    System.out.println(strvalItemType);
	return strvalItemType;
    
    }
    
    public void clickon_ReportingCategory() {
    	utils.explicit_Wait(ReportingCatogory, 200);
    	utils.clickElement_using_Size("//ul[@role='tablist']//span[text()='Reporting Category']", ReportingCatogory);
    }
    
    public void provideDataFor_ReportingCatogory(String  rep,String rep1,String rep2,String status) {
    	utils.sendDataforrepotingCategory(reporingsenddata, rep, repref1, rep1, repref2, rep2);
    	repstatus_Options(status, statusclick);
    	utils.clickElement_using_Size("(//div[@class='ng-star-inserted'])[2]//span[text()='Save & Apply']", repsavebutton);
    	
    }
    
    public void selectReportingCatogoryInMerchandiseBU(String reportinnnname) {
    	utils.explicit_Wait(ReportingCategoryselct, 200);
    	utils.clickElement_using_Size("//div[@class='p-dropdown p-component p-inputwrapper']", ReportingCategoryselct);
        utils.slowSendKeys(sysandrefmaster.coutryinput, reportinnnname, 200);
       String Actual= utils.getSuccessmsg(reportinggettext);
System.out.println("Reporting Category in Mwerchandise is: "+Actual);

    }
    public void repstatus_Options(String status, WebElement statusele) {
		utils.explicit_Wait(statusele, 100);
		utils.clickElementWithJavaScript1(statusele);
		for (WebElement sta : repstatusoptions) {
			if (sta.getText().equalsIgnoreCase(status)) {
				sta.click();
				break;
			}
		}
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