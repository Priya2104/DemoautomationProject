package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import utilities.GenericUtilities;

public class OrganizationHierarchyPage extends BasePage {
	// WebDriverWait wait;
	// WebDriver driver;
	WebDriverWait wait;
	

	MerchandisePage BU_HomePage = new MerchandisePage(BaseClass.getDriver());

	public OrganizationHierarchyPage(WebDriver driver) {
		super(driver);
	}

	GenericUtilities utils = new GenericUtilities(driver);
	@FindBy(xpath = "//span[text()='Filters']")
	WebElement filterBtn;
   //
	
	
	
	}