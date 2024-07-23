package stepDefinitions;



import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataActivityLogPage;
import utilities.GenericUtilities;

public class DataActivityLogSteps {

	WebDriver driver;

	DataActivityLogPage DAP = new DataActivityLogPage(BaseClass.getDriver());
	GenericUtilities utils = new GenericUtilities(driver);

	@When("I will select the Activity log from the Master tab")
	public void SelectActivitylog() throws InterruptedException {
		DAP.ClickActivitylog();
	}

	@Then("I will select the filters with data {string},{string},{string},{string},{string}")
	public void iWillSelectTheFiltersWithData(String Module_Name, String Table_Name, String User_Name, String From_Date,
			String To_Date) throws InterruptedException {
		Thread.sleep(5000);
		DAP.SelectModulename(Module_Name);
		DAP.SelectTablename(Table_Name);
		DAP.SelectUsername(User_Name);
		DAP.selectfromDate(From_Date);
		DAP.selectdate();
		DAP.selecttoDate(To_Date);
		DAP.selectdate();
	}

	@Then("I will click on Save button")
	public void iWillClickOnSaveButton() throws InterruptedException {
		//Thread.sleep(5000);
		DAP.click_applybutton();
		//Thread.sleep(5000);
	}

	@Then("I will verify the records in the grid {string},{string},{string}")
	public void iWillVerifyTheRecordsInTheGrid(String Module_Name, String Table_Name, String User_Name) {
		DAP.VerifyTheRecordsInTheGrid(Module_Name,Table_Name,User_Name);
	}
	
	@Then("I will click on Reset button and verify the records gets cleared from the table")
	public void iWillClickOnResetbutton() throws InterruptedException {
		Thread.sleep(3000);
		DAP.click_resetbutton();
		Thread.sleep(3000);
		DAP.verifytherecordsgetsclearedfromtable();
		
	}

}
