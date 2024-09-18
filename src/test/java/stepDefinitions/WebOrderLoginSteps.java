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

import pageObjects.WebOrderCreatedPage;
import pageObjects.WebOrderLoginPage;
import utilities.GenericUtilities.IncorrectXpathException;


public class WebOrderLoginSteps {


    WebDriver driver;

    // MerchandisePage Mnp;
    WebOrderLoginPage Mnp = new WebOrderLoginPage(BaseClass.getDriver());
    
    

    
    
    WebOrderLoginPage Mlp;
    public Properties p;

    String strBusinessUnits;

    String strBuNameVal;
    //public static String  strBusinessUnits;


    @Given("The user navigates to login page of WeoOrder")
    public void the_user_navigates_to_login_page_of_merx() {

        BaseClass.getLogger().info("Goto my Merx Application-->Click on Login.");

        Mlp = new WebOrderLoginPage(BaseClass.getDriver());
        


    }


    @When("User enters the user name onto the UserName and password")
    public void The_user_login_Merx_application_with_email_as_and_password() throws IOException, TimeoutException, IncorrectXpathException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        // public void user_enters_email_as_and_password_as(String email, String pwd) throws IOException {
        BaseClass.getLogger().info("Entering email and password.. ");

        Mlp = new WebOrderLoginPage(BaseClass.getDriver());

        Mlp.setUserId(BaseClass.getProperties().getProperty("UserID"));

        BaseClass.getLogger().info("Entering user ID" + BaseClass.getProperties().getProperty("UserID"));

        Mlp.setPasswords(BaseClass.getProperties().getProperty("Password"));

    }

    @When("User Click on the Login Page")
    public void click_on_login_button() throws InterruptedException {
        try {
			Mlp.clickbtnSignIn();
		} catch (InterruptedException | TimeoutException e) {
			
			e.printStackTrace();
		}
        BaseClass.getLogger().info("clicked on Sign in button...");


    }


   




}
