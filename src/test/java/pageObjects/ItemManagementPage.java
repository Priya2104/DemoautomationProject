package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class ItemManagementPage extends BasePage {

    public int waittime = 6000;

    public String strDivId;
    public String strDivNameVal;
    public static String strGrpId;
    public static String strGrpNameVal;

    final private CloseableHttpClient client;
    
    private String CompanyAPI_ID, BusinessUnitAPI_ID, DivisionAPI_ID, GroupAPI_ID, DepartmentAPI_ID, ClassAPI_ID, SubClassAPI_ID;
    private int CompanyAPI_responseID, BusinessUnitAPI_responseID, DivisionAPI_responseID, GroupAPI_responseID, DepartmentAPI_responseID, ClassAPI_responseID, SubClassAPI_responseID;
    private String CompanyAPI_responseName,BusinessUnitAPI_responseName, DivisionAPI_responseName, GroupAPI_responseName, DepartmentAPI_responseName, ClassAPI_responseName, SubClassAPI_responseName;
    
    String TestData_filePath = "testData/TestData.properties";
    String Config_filePath ="src/test/resources/config.properties";
    
    PropertiesReader testdata = new PropertiesReader(TestData_filePath);    
    PropertiesReader config = new PropertiesReader(Config_filePath);
    
    public String BaseAPIurl = config.getProperty("BaseAPIurl");
    
    public ItemManagementPage(WebDriver driver) {
    	super(driver);
    	this.client = HttpClients.createDefault();
    }
    private static final Logger LOGGER = Logger.getLogger(ItemManagementPage.class.getName());


    GenericUtilities utils = new GenericUtilities(driver);
    MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
    Apiutilities apiUtils = new Apiutilities();

    MerchandiseGroupPage groupPage = new MerchandiseGroupPage(BaseClass.getDriver());
    MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());

    MerchandiseDepartmentPage deptPage = new MerchandiseDepartmentPage(BaseClass.getDriver());

    MerchandiseClassPage classPage = new MerchandiseClassPage(BaseClass.getDriver());

    MerchandiseSubClassPage subclassPage = new MerchandiseSubClassPage(BaseClass.getDriver());

    //MerchandiseDivisionPage MndivisionPage;

    @FindBy(xpath = "//span[contains(text(),'Create Item')]") // Home Pages headings
    WebElement createItem;


    @FindBy(xpath = "//div[@id='businessUnitId']")
    WebElement BUUNitField;

    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement SearchBox;

    @FindBy(xpath = "//li[@id='businessUnitId_0']")
    WebElement disBuNamBuSearch;

    @FindBy(xpath = "//span[@aria-label='%s - %s']")
    WebElement buValidations;

    @FindBy(xpath = "//*[@id='businessUnitId']/span")
    WebElement buvalidationAfterSelct;

    @FindBy(xpath = "//div[@id='divisionId']")
    WebElement DivisionField;
    
    @FindBy(xpath = "//div[@id='divisionId']")
    WebElement DivisionFields;

    @FindBy(xpath = "//li[@id='divisionId_0']")
    WebElement DivisionSearch;

    @FindBy(xpath = "//span[@aria-label='Select']")
    WebElement GropDivId;
    
    

    @FindBy(xpath = "//li[@id='groupId_0']")
    WebElement GropSearchID;

    @FindBy(xpath = "//*[@id='groupId']/span")
    WebElement groupValidationAfterSelct;


    @FindBy(xpath = "//*[@id='departmentId']/span")
    WebElement DepartmentsValidationAfterSelct;

    @FindBy(xpath = "//*[@id='classId']/span")
    WebElement classValidationAfterSelct;


    @FindBy(xpath = "//*[@id='subclassId']/span")
    WebElement SuclassValidationAfterSelct;


    @FindBy(xpath = "//*[@id='divisionId']/span")
    WebElement divisionValidationAfterSelct;

    @FindBy(xpath = "//div[@id='departmentId']")
    WebElement deptId;

    @FindBy(xpath = "//div[@id='classId']")
    WebElement classId;

    @FindBy(xpath = "//li[@id='classId_0']")
    WebElement classIdValeSelectITem;

    @FindBy(xpath = "//div[@id='subclassId']")
    WebElement subclassId;

    @FindBy(xpath = "//li[@id='subclassId_0']")
    WebElement subclassIdValeSelectITem;


    @FindBy(xpath = "//li[@id='departmentId_0']")
    WebElement deptIdValeSelectITem;


    @FindBy(xpath = "//div[@id='reportCategoryId']")
    WebElement reportingCategoryinITem;

    @FindBy(xpath = "//li[@id='reportCategoryId_0']")
    WebElement reportingValSelect;


    @FindBy(xpath = "//button/span[contains(.,'Continue')]")
    WebElement continueButton;
    
    @FindBy(xpath="//button/span[contains(.,'Save and Apply')]")
    WebElement saveAndContinue;

    @FindBy(xpath="//*[@id='itemSubtypeId']/span")
    WebElement subTypeItemselectClick;
    
    @FindBy(xpath="//li[@id='itemSubtypeId_0']")
    WebElement subTypeItemselects;
    
    @FindBy(xpath="//textarea[@placeholder='Family Description']")
    WebElement editFamilyDescription;
    
    @FindBy(xpath="//span[@aria-label='Select']")
    WebElement statusEleClick;
    
    @FindBy(xpath="//input[@role='searchbox']")
    WebElement statusSetVal;
    
    @FindBy(xpath="//li[@id='itemStatusId_0']")
    WebElement statusSelectOptions;
    
    
    @FindBy(xpath="//input[@id='departmentIdDis']")
    WebElement isreadonlyDepartment;
    
    
    @FindBy(xpath="//input[@id='classIdDis']")
    WebElement isreadonlyClass;
    
    @FindBy(xpath="//input[@id='subclassIdDis']")
    WebElement isreadonlySubClass;
    
    @FindBy(css="input.custom-control-input")
    public WebElement defaultSelector;
    
    // Define the CSS selector for the toggle button
    String toggleButtonSelector = "input.custom-control-input";
    
    
    @FindBy(xpath="//textarea[@placeholder='Family Long Description']")
    WebElement inpLongDescription;
    
    
    
    @FindBy(xpath="(//textarea[@placeholder='POS Description'])[1]")
    WebElement inpPosDesc1;
    @FindBy(xpath="(//textarea[@placeholder='POS Description'])[2]")
    WebElement inpPosDesc2;
    
    @FindBy(xpath="//div[@class='p-checkbox-box']")
    WebElement chekCaptureSerialNumber;
    
    //*[@id='isSerialnumCaptured']
    
    
    //@FindBy(xpath="//input[@type='radio' and @id='Yes' or @name='Yes']")
    @FindBy(xpath="//input[@type='radio'and @id='Yes']")
    WebElement radioDifferentators;
    
    @FindBy(xpath="(//span[@aria-label='Select group'][normalize-space()='Select group'])[1]")
    WebElement drpdwnDiffGrps;
    /*
    @FindBy(xpath="(//span[@aria-label='Select group'][normalize-space()='Select group'])[1]")
    WebElement drpdwnDiffGrp1;
    
    @FindBy(xpath="(//span[@aria-label='Select group'][normalize-space()='Select group'])[2]")
    WebElement drpdwnDiffGrp2;
   
    @FindBy(xpath="(//span[@aria-label='Select group'][normalize-space()='Select group'])[3]")
    WebElement drpdwnDiffGrp3;
    
    @FindBy(xpath="(//span[@aria-label='Select group'][normalize-space()='Select group'])[4]")
    WebElement drpdwnDiffGrp4;
    */
    
    @FindBy(xpath ="//span[normalize-space()='${value}']")
    WebElement drpDwnValSelect; 
  
    @FindBy(xpath="//span[contains(.,'Save')]")
    WebElement btnSave;
    
    @FindBy(xpath="(//div//span[contains(@class,'p-inputswitch-slider')])[1]")
    WebElement switchIndicatorsSaleable;
    
    
    
    
    @FindBy(xpath="(//input[@type='text' and @role='searchbox'])")
    WebElement searchDiffGrpVal;
    
    @FindBy(xpath="(//input[@type='text' and @role='searchbox'])[2]")
    WebElement searchDiffGrpVal2;
    
    @FindBy(xpath="(//input[@type='text' and @role='searchbox'])[3]")
    WebElement searchDiffGrpVal3;
   
    @FindBy(xpath="(//input[@type='text' and @role='searchbox'])[4]")
    WebElement searchDiffGrpVal4;
    

  

    public void clickonCreateItem() throws InterruptedException {

        // Click on BU Unit 	
        System.out.println("ClickonCreateITem");

      utils.waitForElementToBeClickablewithFluentWait(createItem, 5);
        createItem.click();


    }

    public void selectDivisionVal(String DivisionAPI) throws InterruptedException {
        //System.out.println(MndivisionPage.strDivNameVal);

        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), BUUNitField);
        
        utils.waitForElementToBeVisiblewithFluentWait(BUUNitField,waittime);
          
        //utils.clickElementWithJavaScript(DivisionField);
        
        utils.retryingFindClick(By.xpath("//div[@id='divisionId']"));
       

        System.out.println("Click on division unit");
     
        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), SearchBox);
        
        utils.waitForElementToBeVisiblewithFluentWait(SearchBox,waittime);
        
    
        //utils.setValueTextBox(SearchBox, MndivisionPage.strDivNameVal, "selectDivInItemCreation");      
        
        utils.setValueTextBox(SearchBox,DivisionAPI, "selectDivInItemCreation");       
   
        
        utils.waitForElementToBeVisiblewithFluentWait(DivisionSearch,waittime);
        
        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), DivisionSearch);
        
                       
        utils.clickOnWebElement(DivisionSearch);   
        
        System.out.println("Click on submit button in the  division");


    }

    public void clickonContinueButton() {
    	utils.waitForElementToBeVisiblewithFluentWait(continueButton,waittime);
        utils.clickOnWebElement(continueButton);
    }

    public void selectReportingVal(String strRepoVal) {
        try {
            selectItemCreation1(reportingCategoryinITem, reportingValSelect, strRepoVal, "ReportingCategory");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        }
    }
    
    
    /*
    
    public void selectDiffGroupVals(WebElement diffVal1, String value)
    {
    	
    	String strDifVal="//span[normalize-space()='" + value + "']";
    	
    	  utils.clickOnWebElement(diffVal1); 
    	  
    	  utils.waitForElementToBeVisiblewithFluentWait(strDifVal,10);
    	  
    	  WebElement element =driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
    	     	  
    	  element.click(); 	 
    	
    }
    */
    
    public void selectDiffGroupVal(WebElement diffVals,String value) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waittime));
    	
    	
    	 utils.clickOnWebElement(diffVals); 
    	
    	//String strDifVal = "//span[normalize-space()='" + value + "']";
    	
    	String strDifVal = "//span[normalize-space()='" + value + "']";
    	//By locator = By.xpath(strDifVal); // Convert String to By using XPath
    	
    
    	//WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust timeout as needed

    	//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    	  
    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strDifVal)));
    	     	   	  
    	  

    	  WebElement element = driver.findElement(By.xpath(strDifVal));
    	  element.click();
    	  
    	  
    	  
    	   
    	  
    	}


    public void selectDepartmentItem(String DepartmentAPI) throws InterruptedException {
        //selectItemCreation1(deptId, SearchBox, deptIdValeSelectITem, deptPage.strDepNameVal, "Department");
    	//selectItemCreation1(deptId, SearchBox, deptIdValeSelectITem, "SanityAutoTestsExecution", "Department");
    	 
    	selectMerchandiseInItem(deptId,DepartmentAPI);
    	 
       
    }


    public void selectClassItem(String ClassAPI) throws InterruptedException {
       // selectItemCreation1(classId, SearchBox, classIdValeSelectITem, classPage.strClassNameVal, "class");
        
        selectItemCreation1(classId, classIdValeSelectITem, ClassAPI, "class");
        
        
    }


    public void selectSubClassItem(String SubClassAPI) throws InterruptedException {
        //selectItemCreation1(subclassId, SearchBox, subclassIdValeSelectITem, subclassPage.strsubclassNameVal, "subclass");
        
        selectItemCreation1(subclassId, subclassIdValeSelectITem, SubClassAPI, "subclass");
        
    }


    public void selectItemCreation1(WebElement clickdropdownval,WebElement ClickonMerchandiseval, String merchName, String Flow) throws InterruptedException {
       // utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), clickdropdownval);
        
    	clickdropdownval.isDisplayed();
    	clickdropdownval.isDisplayed();
    	
    	Thread.sleep(waittime);
    	
        utils.waitForElementToBeVisiblewithFluentWait(clickdropdownval,waittime);
        

        // to check value runtime
        //System.out.println(merchName);
        // click on drop down value
        utils.clickElementWithJavaScript(clickdropdownval);        
        
        System.out.println("Click on Reporitng drop down");

        //utils.waitForElementToBeVisiblewithFluentWait(SearchBox,waittime);
        utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), SearchBox);
        
        SearchBox.isDisplayed();
        SearchBox.isDisplayed(); 
      
        
       

        utils.setValueTextBox(SearchBox, merchName, Flow);

        System.out.println("After set the value into search box");
        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), ClickonMerchandiseval);
        
        
        utils.waitForElementToBeVisiblewithFluentWait(ClickonMerchandiseval,waittime);

        utils.clickOnWebElement(ClickonMerchandiseval);
        
        System.out.println("After selcting reporting category value");


    }

    public void selectGrouDivVal(String GroupAPI) throws InterruptedException, TimeoutException {

        //System.out.println();

        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), GropDivId);

        //utils.waitForElementToBeVisiblewithFluentWait(GropDivId,waittime);
    	
    	//utils.waitForElementToBeClickablewithFluentWait(GropDivId, waittime);
        
    	//utils.clickOnWebElement(GropDivId);    
    	
        //utils.retryingFindClick(By.xpath("//div[@id='groupId']"));
    	
    


    	//utils.waitForElementToBeClicks(GropDivId,20);
    	
    	//utils.waitForElementToBeClickable(GropDivId,20);
    	
    	Thread.sleep(waittime);
      
        utils.clickElementWithJavaScript(GropDivId);

     
        //System.out.println(groupPage.strGrpNameVal);

       // utils.setValueTextBox(SearchBox, groupPage.strGrpNameVal, "selectGrpInItemCreation");
        
        utils.waitForElementToBeVisiblewithFluentWait(SearchBox,waittime);
        
        utils.setValueTextBox(SearchBox,GroupAPI, "selectGrpInItemCreation");

        
        
        
        //utils.clickElementWithJavaScript(GropSearchID);
        
       // utils.waitForElementToBeClickablewithFluentWait(GropSearchID,5);
        utils.waitForElementToBeVisiblewithFluentWait(GropSearchID,waittime);
        
        utils.clickOnWebElement(GropSearchID);
        
        System.out.println("After selection of Group");

    }

    public void clickGrpValidations() {


    }

    public void selectBusinessUnit(String BusinessUnitAPI) throws InterruptedException {
        // wait the element is visible
        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), BUUNitField);
        utils.waitForElementToBeVisiblewithFluentWait(BUUNitField,waittime);
        // Click on business unit.
        System.out.println("check on business unit appearing");

        //BUUNitField.click();
        utils.clickOnWebElement(BUUNitField);        

        System.out.println("Click on business unit");
       
        //utils.waitForElementVisibilityFor(Duration.ofSeconds(waittime), SearchBox);
        utils.waitForElementToBeVisiblewithFluentWait(SearchBox,waittime);

        //utils.slowSendKeys(SearchBox, Mnp.strBuNameVal, 500);
        
        utils.slowSendKeys(SearchBox, BusinessUnitAPI, 500);
        
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();      

    }
    
    public void selectMerchandiseInItem(WebElement element,String strval) throws InterruptedException {
    	
    	 utils.waitForElementToBeVisiblewithFluentWait(element,waittime);
    	 
    	 System.out.println("check on click on "+ element +" appearing");
    	 
    	 utils.clickOnWebElement(element); 
    	 
    	 utils.waitForElementToBeVisiblewithFluentWait(SearchBox,waittime);
    	 
    	 utils.slowSendKeys(SearchBox,strval,500);
    	 
    	 Actions actions = new Actions(driver);
         actions.sendKeys(Keys.TAB).build().perform();
         actions.sendKeys(Keys.ENTER).build().perform();  	 
    	  	 
    	
    }
    
    
    

    public boolean GroupIDName() {

        String expectedName = groupPage.strGrpId + " - " + groupPage.strGrpNameVal;
        boolean isValid = validateClick(groupValidationAfterSelct, expectedName);

        return isValid;

    }


    public boolean DeptIDName() {

        String expectedName = deptPage.strDepId + " - " + deptPage.strDepNameVal;
        boolean isValid = validateClick(DepartmentsValidationAfterSelct, expectedName);

        return isValid;


    }
    public void selectSubTypeItem() throws InterruptedException
        
    {
    	utils.clickOnWebElement(subTypeItemselectClick);
    	
    	
    	utils.clickOnWebElement(subTypeItemselects);
    	
    	Thread.sleep(5000);
    	
    	utils.clickOnWebElement(continueButton);
    	
    	
    	    	
    }
    
    public void createChildITem(String strChildItems) throws IOException
    {
    	
    	//utils.clickOnWebElement(searchDiffGrpVal1);
    	
    	
    	List<String> ongoingSetDifferentiatorsLists = Arrays.asList(strChildItems.split("#"));
    	 

    	 
    	 int i=1;
         for (String  setDifferentiators  : ongoingSetDifferentiatorsLists) {
        	 
                	 
        	 String strValueIndex = String.valueOf(i);
       	  
       	  //selectDiffGroupVal(drpdwnDiffGrps,setDifferentiators);
        	 
        	 //String newStr = searchDiffGrpVal.substring(0, searchDiffGrpVal.length() - 1);
        	 
        	 //String strDifvalueSearch=(searchDiffGrpVal).length() - 1+ "[" + i + "]";
        	 
        	 //System.out.println(strDifvalueSearch);
        	 
        	 
       	  
       	diffGrpSet(setDifferentiators,strValueIndex);
       	
       	i = i + 1;

         }   
		
    	/*
    	diffGrpSet(searchDiffGrpVal1,"Red");
    	diffGrpSet(searchDiffGrpVal2,"xl");
    	diffGrpSet(searchDiffGrpVal3,"Skinny");
    	diffGrpSet(searchDiffGrpVal4,"Cotton");
    	
    	
    	*/
         utils.waitForElementToBeClicks(saveAndContinue,30);
         utils.waitForElementToBeClicks(saveAndContinue,30);
         
         utils.clickOnWebElement(saveAndContinue);
      
    	
    }
    
    public void verifyChiltemExists(String familyDesc,String ClothingColor,String ClothingSize,String ClothingPattern,String ClothingFabric) throws InterruptedException
    { 
    	
    	try 
    	{   		
    	
    		Thread.sleep(waittime);
    	
    	List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
    	
    	   	    	
    	String strFamilycode=Mnp.getCellValue(3, 1);
    	System.out.println(strFamilycode);
    	String strFamilItemDescription=Mnp.getCellValue(3, 2);
    	System.out.println(strFamilItemDescription);
    	String strClothingColor=Mnp.getCellValue(3, 5);
    	System.out.println(strClothingColor);
    	String strClothingSize=Mnp.getCellValue(3, 6);
    	System.out.println(strClothingSize);
    	String strClothingPatern=Mnp.getCellValue(3, 7);
    	System.out.println(strClothingPatern);
    	String strClothingFabric=Mnp.getCellValue(3, 8);
    	System.out.println(strClothingFabric);
    	
    	
    	
    	 //Assertions.assertThat(actualValue).as("Actual value does not match expected value").isEqualTo(expectedValue);
    	
    	 //Assert.assertEquals(strFamilycode, testDataInMap.get(0).get("FamilyItemDesciption"), "Actual value does not match expected value");
    	  
    	 Assert.assertEquals(strFamilycode, familyDesc, "Actual value does not match expected value");
    	 Assert.assertEquals(strClothingColor, ClothingColor, "Actual value does not match expected value");
    	 Assert.assertEquals(strClothingSize, ClothingSize, "Actual value does not match expected value");
    	 Assert.assertEquals(strClothingPatern, ClothingPattern, "Actual value does not match expected value");
    	 Assert.assertEquals(strClothingFabric, ClothingFabric, "Actual value does not match expected value");
     	
    	} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    public void diffGrpSet(String strval,String index)
    {
    	
    	
    	
    	System.out.println(strval);
    	
    	System.out.println(index);
    	
    	String strDifValSearch ="(//input[@type='text' and @role='searchbox'])"+"[" + index + "]";
    	
    	
    	
    	
    	 //String indexedXpath = elements + "[" + index + "]";
    	 
    	System.out.println(strDifValSearch);
     	
    	 
    	// System.out.println(indexedXpath);
    	
    	//utils.clickOnWebElement(indexedXpath);
    	
    	WebElement searchDiffElement=driver.findElement(By.xpath(strDifValSearch));
    	//searchDiffElement.click();
    	
    	searchDiffElement.isDisplayed();
    	
    	
    	//searchDiffElement.sendKeys(strval);
    	    	
    	
    	utils.slowSendKeys(searchDiffElement, strval, 700);
    	
    	
    	
    	//String strDifVal = "//span[normalize-space()='" + value + "']";
    	String strDifVal ="//span[text()='"+ strval +"']//preceding-sibling::div//div[@class='p-checkbox-box']";

  	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
  	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strDifVal)));
  	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strDifVal)));
  	    	  
    	    	
      	WebElement checkboxElement=driver.findElement(By.xpath(strDifVal));
      	
      	
      	
      	checkboxElement.isDisplayed();
      	
    	checkboxElement.click();
    }
   
    public void createFamilyITem(String familyDescval,String itemStatus, String longDescription,String pos1Description, String pos2Description,String Differentiators)
    {
    	
    	
		try {
			List<Map<String, String>> testDataInMap = ExcelUtily.getTestdatainMap();
		
			
    		  
	

    	
    	//utils.setValueInEditBox(editFamilyDescription,testDataInMap.get(0).get("FamilyItemDesciption"));
    	
		utils.setValueInEditBox(editFamilyDescription,familyDescval);
		
		
    	utils.clickOnWebElement(statusEleClick);
    	
    	utils.setValueInEditBox(statusSetVal, itemStatus);
    	
    	utils.clickOnWebElement(statusSelectOptions);
    	
    	utils.isEditBoxNotEditable(isreadonlyDepartment);
    	
    	utils.isEditBoxNotEditable(isreadonlyClass);
    	
    	utils.isEditBoxNotEditable(isreadonlySubClass);
    	
    	utils.clickOnWebElement(switchIndicatorsSaleable);
   
    	
    	  // Click the toggle button
     // clickToggleButton(toggleButtonSelector);
      
    	
      

        // Print the state of the toggle button
     // boolean blntru= printToggleButtonState(toggleButtonSelector);
      
     // Assert.assertEquals(blntru,true);
      
      utils.setValueInEditBox(inpLongDescription, longDescription);
      
      utils.setValueInEditBox(inpPosDesc1, pos1Description);
      
      utils.setValueInEditBox(inpPosDesc2, pos2Description);
      
     // utils.selectCheckboxOrRadio(chekCaptureSerialNumber);       
    
      
      utils.clickElementWithJavaScript(radioDifferentators);
           
      
      List<String> ongoingDifferentiatorsList = Arrays.asList(Differentiators.split("#"));      
     // List<String> ongoingDifferentiatorsList = Arrays.asList(testDataInMap.get(0).get("Differentiators").split("#"));


      for (String  Differentiatorsvalue  : ongoingDifferentiatorsList) {
    	  
    	  drpdwnDiffGrps.isDisplayed();
    	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	  utils.waitForElementToBeClicks(drpdwnDiffGrps,3000);
    	  
    	  selectDiffGroupVal(drpdwnDiffGrps,Differentiatorsvalue);
      }      
      
     // selectDiffGroupVal(drpdwnDiffGrp1,"Clothing Size");
      
    
      
    //  selectDiffGroupVal(drpdwnDiffGrp1,"Clothing Pattern");
      
    
      
      
      //selectDiffGroupVal(drpdwnDiffGrp1,"Clothing Fabric");
      
      
      utils.waitForElementToBeClickablewithFluentWait(btnSave, 500);
      utils.clickOnWebElement(btnSave);
      
      
      
      
      
      
      
      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      
      
      
 	
    	
    	
    	
    	

    }
    public boolean classIdName() {
        String expectedName = classPage.strclassId + " - " + classPage.strClassNameVal;
        boolean isValid = validateClick(classValidationAfterSelct, expectedName);

        return isValid;

    }
    
    
    // Method to click the toggle button
    public void clickToggleButton(String cssSelector) {
        WebElement toggleButton = driver.findElement(By.cssSelector(cssSelector));
        toggleButton.click();
    }

    // Method to check if the toggle button is selected
    public boolean isToggleButtonSelected(String cssSelector) {
        WebElement toggleButton = driver.findElement(By.cssSelector(cssSelector));
        return toggleButton.isSelected();
    }

    // Method to print the state of the toggle button
    public boolean printToggleButtonState(String cssSelector) {
        boolean isSelected = isToggleButtonSelected(cssSelector);
        if (isSelected) {
            System.out.println("Toggle button is ON");
        } else {
            System.out.println("Toggle button is OFF");
        }
		return isSelected;
    }



    public boolean subClassIdName() {
        String expectedName = subclassPage.strSubClassId + " - " + subclassPage.strsubclassNameVal;
        boolean isValid = validateClick(SuclassValidationAfterSelct, expectedName);

        return isValid;

    }


    public boolean validateClick(WebElement element, String expectedDivName) {
        String actualText = utils.getText(element); // Assuming utils.getText works on WebElement
        String expectedName = expectedDivName;
        boolean result = utils.compareStringsIgnoreCase(actualText, expectedName);
        return result;
    }


    public boolean clickDivValidations() {
        String strDivValAfterSelct = utils.getText(divisionValidationAfterSelct);

        System.out.println(strDivValAfterSelct);

        String strDivIDNAMe = (MndivisionPage.strDivId + " - " + MndivisionPage.strDivNameVal);

        System.out.println(strDivIDNAMe);


        boolean result = utils.compareStringsIgnoreCase(strDivValAfterSelct, strDivIDNAMe);
        System.out.println("Are input1 and input2 equal? " + result);
        return result;
    }


    public boolean clickBuValidations() {

        String strBuValAfterSelct = utils.getText(buvalidationAfterSelct);

        System.out.println(strBuValAfterSelct);
        
        String strBUIDNAMe = (Mnp.strBusinessUnits + " - " + Mnp.strBuNameVal);

        System.out.println(strBUIDNAMe);


        boolean result = utils.compareStringsIgnoreCase(strBuValAfterSelct, strBUIDNAMe);
        System.out.println("Are input1 and input2 equal? " + result);
        return result;
    }

    
    //API data setup
    public void getCreateMerchandiseDataIDs() {
        //generate IDs
        CompanyAPI_ID = getReferenceIDs("companies");
        System.out.println("CompanyID: " + CompanyAPI_ID);
        testdata.setProperty("companyCode", CompanyAPI_ID);

        BusinessUnitAPI_ID = getMerchandiseIDs("business-units");
        System.out.println("BusinessUnitID: " + BusinessUnitAPI_ID);
        testdata.setProperty("businessUnitCode", BusinessUnitAPI_ID);

        DivisionAPI_ID = getMerchandiseIDs("divisions");
        System.out.println("DivisionID: " + DivisionAPI_ID);
        testdata.setProperty("divisionCode", DivisionAPI_ID);

        GroupAPI_ID = getMerchandiseIDs("groups");
        System.out.println("GroupID: " + GroupAPI_ID);
        testdata.setProperty("groupCode", GroupAPI_ID);

        DepartmentAPI_ID = getMerchandiseIDs("departments");
        System.out.println("DepartmentID: " + DepartmentAPI_ID);
        testdata.setProperty("departmentCode", DepartmentAPI_ID);

        ClassAPI_ID = getMerchandiseIDs("classes");
        System.out.println("ClassID: " + ClassAPI_ID);
        testdata.setProperty("classCode", ClassAPI_ID);

        SubClassAPI_ID = getMerchandiseIDs("sub-classes");
        System.out.println("SubClassID: " + SubClassAPI_ID);
        testdata.setProperty("subClassCode", SubClassAPI_ID);

        }
        public void CreateMerchandiseData() {

        	  /*
        //post and get company data
        Map<String, String> companyData = postCompanyData("companies");
        String CompanyAPI_responseCode = companyData.get("code");
        CompanyAPI_responseName = companyData.get("name");
        testdata.setProperty("companyName", CompanyAPI_responseName);
        CompanyAPI_responseID = Integer.parseInt(companyData.get("id"));
        System.out.println("CompanyAPI_responseID: " + CompanyAPI_responseID);
        System.out.println("CompanyAPI_responseCode: " + CompanyAPI_responseCode);
        System.out.println("CompanyAPI_responseName: " + CompanyAPI_responseName);
      */
        //post and get merchandise data
        Map<String, String> businessUnitData = postMerchandiseData("business-units");
        String BusinessUnitAPI_responseCode = businessUnitData.get("code");
        BusinessUnitAPI_responseName = businessUnitData.get("name");
        testdata.setProperty("businessUnitName", BusinessUnitAPI_responseName);
        BusinessUnitAPI_responseID = Integer.parseInt(businessUnitData.get("id"));
        System.out.println("BusinessUnitAPI_responseID: " + BusinessUnitAPI_responseID);
        System.out.println("BusinessUnitAPI_responseCode: " + BusinessUnitAPI_responseCode);
        System.out.println("BusinessUnitAPI_responseName: " + BusinessUnitAPI_responseName);

        Map<String, String> divisionData = postMerchandiseData("divisions");
        String DivisionAPI_responseCode = divisionData.get("code");
        DivisionAPI_responseName = divisionData.get("name");
        DivisionAPI_responseID = Integer.parseInt(divisionData.get("id"));
        testdata.setProperty("divisionName", DivisionAPI_responseName);
        System.out.println("DivisionAPI_responseID: " + DivisionAPI_responseID);
        System.out.println("DivisionAPI_responseCode: " + DivisionAPI_responseCode);
        System.out.println("DivisionAPI_responseName: " + DivisionAPI_responseName);

        Map<String, String> groupData = postMerchandiseData("groups");
        String GroupAPI_responseCode = groupData.get("code");
        GroupAPI_responseName = groupData.get("name");
        GroupAPI_responseID = Integer.parseInt(groupData.get("id"));
        testdata.setProperty("groupName", GroupAPI_responseName);
        System.out.println("GroupAPI_responseID: " + GroupAPI_responseID);
        System.out.println("GroupAPI_responseCode: " + GroupAPI_responseCode);
        System.out.println("GroupAPI_responseName: " + GroupAPI_responseName);

        Map<String, String> departmentData = postMerchandiseData("departments");
        String DepartmentAPI_responseCode = departmentData.get("code");
        DepartmentAPI_responseName = departmentData.get("name");
        testdata.setProperty("departmentName", DepartmentAPI_responseName);
        DepartmentAPI_responseID = Integer.parseInt(departmentData.get("id"));
        System.out.println("DepartmentAPI_responseID: " + DepartmentAPI_responseID);
        System.out.println("DepartmentAPI_responseCode: " + DepartmentAPI_responseCode);
        System.out.println("DepartmentAPI_responseName: " + DepartmentAPI_responseName);

        Map<String, String> classData = postMerchandiseData("classes");
        String ClassAPI_responseCode = classData.get("code");
        ClassAPI_responseName = classData.get("name");
        ClassAPI_responseID = Integer.parseInt(classData.get("id"));
        testdata.setProperty("className", ClassAPI_responseName);
        System.out.println("ClassAPI_responseID: " + ClassAPI_responseID);
        System.out.println("ClassAPI_responseCode: " + ClassAPI_responseCode);
        System.out.println("ClassAPI_responseName: " + ClassAPI_responseName);

        Map<String, String> subClassData = postMerchandiseData("sub-classes");
        String SubClassAPI_responseCode = subClassData.get("code");
        SubClassAPI_responseName = subClassData.get("name");
        SubClassAPI_responseID = Integer.parseInt(subClassData.get("id"));
        testdata.setProperty("subClassName", SubClassAPI_responseName);
        System.out.println("SubClassAPI_responseID: " + SubClassAPI_responseID);
        System.out.println("SubClassAPI_responseCode: " + SubClassAPI_responseCode);
        System.out.println("SubClassAPI_responseName: " + SubClassAPI_responseName);

    }

    public String getReferenceIDs(String reference) {
        String response = null;
        try {
            String url = BaseAPIurl + "system-reference-data/v1/" + reference + "/ids";
            response = apiUtils.sendGetRequest(url);
            JSONObject jsonResponse = new JSONObject(response);
            response = jsonResponse.getJSONObject("data").getString("code");
            System.out.println(response);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to get reference IDs", e);
        }
        return response;
    }

    public String getMerchandiseIDs(String merchandise) {
        String response = null;
        try {
            String url = BaseAPIurl + "merch-hierarchy/v1/" + merchandise + "/ids";
            response = apiUtils.sendGetRequest(url);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.has("data")) {
                response = jsonResponse.getJSONObject("data").getString("code");
                System.out.println(response);
            } else {
                LOGGER.log(Level.SEVERE, "Data not found in the response");
                response = null;
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to get merchandise IDs", e);
        }
        return response;
    }

    public Map<String, String> postCompanyData(String CompanyID) {
        Map<String, String> result = new HashMap<>();
        String response = null;
        try {
            String url = BaseAPIurl + "system-reference-data/v1/" + CompanyID;
            JSONObject json = new JSONObject();
            json.put("code", CompanyAPI_ID);
            json.put("name", "Company" + GenericUtilities.getSystemDate().replace("_", ""));
            json.put("alternateHierarchies", "[1,2]");
            json.put("accountableName", "user1");
            json.put("reportCategoryId", "1");
            json.put("isActive", true);
            response = apiUtils.sendPostRequest(url, json.toString());
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.has("data")) {
                JSONObject data = jsonResponse.getJSONObject("data");
                if (data.has("code")) {
                    result.put("code", data.getString("code"));
                }
                if (data.has("name")) {
                    result.put("name", data.getString("name"));
                }
                if (data.has("id")) {
                    result.put("id", String.valueOf(data.getInt("id")));
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to post company: ", e);
        }
        return result;
    }

    public Map<String, String> postMerchandiseData(String MerchandiseID) {
        Map<String, String> result = new HashMap<>();
        String response = null;
        try {
            String url = BaseAPIurl + "merch-hierarchy/v1/" + MerchandiseID;
            JSONObject json = new JSONObject();

            switch (MerchandiseID) {
                case "business-units":
                    json.put("code", BusinessUnitAPI_ID);
                    json.put("name", "BU" + GenericUtilities.getSystemDate().replace("_", ""));
                    break;
                case "divisions":
                    json.put("code", DivisionAPI_ID);
                    json.put("name", "Div" + GenericUtilities.getSystemDate().replace("_", ""));
                    json.put("businessUnitId", BusinessUnitAPI_responseID);
                    break;
                case "groups":
                    json.put("code", GroupAPI_ID);
                    json.put("name", "Grp" + GenericUtilities.getSystemDate().replace("_", ""));
                    json.put("divisionId", DivisionAPI_responseID);
                    break;
                case "departments":
                    json.put("code", DepartmentAPI_ID);
                    json.put("name", "Dept" + GenericUtilities.getSystemDate().replace("_", ""));
                    json.put("groupId", GroupAPI_responseID);
                    json.put("itemTypeId","11");
                    break;
                case "classes":
                    json.put("code", ClassAPI_ID);
                    json.put("name", "Class" + GenericUtilities.getSystemDate().replace("_", ""));
                    json.put("departmentId", DepartmentAPI_responseID);
                    json.put("itemTypeId","11");
                    break;
                case "sub-classes":
                    json.put("code", SubClassAPI_ID);
                    json.put("name", "SubClass" + GenericUtilities.getSystemDate().replace("_", ""));
                    json.put("classId", ClassAPI_responseID);
                    json.put("itemTypeId","11");
                    break;
            }
            //json.put("companyId", CompanyAPI_responseID);
            json.put("companyId", "2");
            int[] althier = {1, 2};
            json.put("alternateHierarchies", althier);
            json.put("accountableName", "user1");
            json.put("reportCategoryId", "1");
            json.put("isActive", true);
            response = apiUtils.sendPostRequest(url, json.toString());
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.has("data")) {
                JSONObject data = jsonResponse.getJSONObject("data");
                if (data.has("code")) {
                    result.put("code", data.getString("code"));
                }
                if (data.has("name")) {
                    result.put("name", data.getString("name"));
                }
                if (data.has("id")) {
                    result.put("id", String.valueOf(data.getInt("id")));
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to post Merchandise: ", e);
        }
        return result;
    }
}

	
		
	
	

	
	

