package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandisePage;
import pageObjects.MerxLoginPage;
import utilities.GenericUtilities.IncorrectXpathException;


public class MerxLoginSteps {


    WebDriver driver;

    // MerchandisePage Mnp;
    MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());
    MerxLoginPage Mlp;
    public Properties p;

    String strBusinessUnits;

    String strBuNameVal;
    //public static String  strBusinessUnits;


    @Given("The user navigates to login page of Merx")
    public void the_user_navigates_to_login_page_of_merx() {

        BaseClass.getLogger().info("Goto my Merx Application-->Click on Login.");

        Mlp = new MerxLoginPage(BaseClass.getDriver());
        


    }


    //@When("The user enters email as {string} and password as {string}")
    @When("The user login Merx application with email as and password")
    public void The_user_login_Merx_application_with_email_as_and_password() throws IOException, TimeoutException, IncorrectXpathException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        // public void user_enters_email_as_and_password_as(String email, String pwd) throws IOException {
        BaseClass.getLogger().info("Entering email and password.. ");

        Mlp = new MerxLoginPage(BaseClass.getDriver());

        Mlp.setEmails(BaseClass.getProperties().getProperty("UserID"));

        BaseClass.getLogger().info("Entering user ID" + BaseClass.getProperties().getProperty("UserID"));

        Mlp.setPasswords(BaseClass.getProperties().getProperty("Password"));

    }

    @When("The user clicks on the Sign in button")
    public void click_on_login_button() throws InterruptedException {
        try {
			Mlp.clickbtnSignIn();
		} catch (InterruptedException | TimeoutException e) {
			
			e.printStackTrace();
		}
        BaseClass.getLogger().info("clicked on Sign in button...");


    }


    @Then("The user should be redirected to the Merchandise Page")
    public void The_user_should_be_redirected_to_the_Merchandise_Page() throws InterruptedException {
        // Mnp=new MerxLoginPage(BaseClass.getDriver());
        boolean targetpage = Mnp.ismerchandisePageExists();
        Assert.assertEquals(targetpage, true);
        BaseClass.getLogger().info("The user has landing to the Merchandise page");
        
    }


    @When("Enter a search with BUID")
    public void Enter_a_search_with_BU_ID() {

        Mnp.enterBUIDSearch();
    }

    @When("click on divsion BUUnit")

    public void click_on_divsion_tab() throws InterruptedException {

        // MerchandiseDivisionPage MndivisionPage= new
        // MerchandiseDivisionPage(BaseClass.getDriver());
        // MerchandisePage Mnp=new MerchandisePage(BaseClass.getDriver());
        Thread.sleep(100);
        Mnp.clickBUnitTab();

        BaseClass.getLogger().info("Click on division Tab.");
    }


    @When("The BUIDName {string} is showing up in the viwe page")
    public void The_BUIDName_is_showing_up_in_the_viwe_page(String BUID) {

        boolean blnTrue = Mnp.isPagenotFoundExist();

        Assert.assertEquals(blnTrue, true);


    }

    @When("The BUIDName {string} is showing up in the view pages")
    public void The_BUIDName_is_showing_up_in_the_viwe_pages(String BUID) {

        boolean blnTrue = Mnp.isPagenotFoundExist();

        Assert.assertEquals(blnTrue, true);


    }

    @When("Enter a Search with BUName")
    public void Enter_a_Search_with_BUName() {
        Mnp.enterBUNameSearch();
    }

    // BUID
    @Then("The BUID is showing up in the view page")
    public void The_BUID_is_showing_up_in_theviwe_page() throws InterruptedException {
        Thread.sleep(1000);
        String strBUID = Mnp.getCellValue(2, 1);
        System.out.println(strBUID);

        System.out.println(Mnp.strBusinessUnits);

        Assert.assertEquals(strBUID, Mnp.strBusinessUnits);
    }

    @Then("The BUName is showing up in the view page")
    public void The_BUName_is_showing_up_in_theviwe_page() {

        String strBuName = Mnp.getCellValue(2, 2);
        System.out.println(strBuName);
        System.out.println(Mnp.strBuNameVal);
        Assert.assertEquals(strBuName,Mnp.strBuNameVal);


    }


}
