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
import pageObjects.OrganizationHierarchyPage;
import utilities.GenericUtilities.IncorrectXpathException;


public class OrganizationHierarchySteps {


    WebDriver driver;

    // MerchandisePage Mnp;
    OrganizationHierarchyPage orgHierarchy = new OrganizationHierarchyPage(BaseClass.getDriver());
    MerxLoginPage Mlp;
    public Properties p;
  //public static String  strBusinessUnits;


    @Given("The user navigates to login page of Merx")
    public void the_user_navigates_to_login_page_of_merx() {

        BaseClass.getLogger().info("Goto my Merx Application-->Click on Login.");

        Mlp = new MerxLoginPage(BaseClass.getDriver());
        
        //       


    }



}
