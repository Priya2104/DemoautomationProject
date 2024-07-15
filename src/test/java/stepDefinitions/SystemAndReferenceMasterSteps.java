package stepDefinitions;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MerchandiseBusinessUnitPage;
import pageObjects.MerchandiseClassPage;
import pageObjects.MerchandiseDepartmentPage;
import pageObjects.MerchandiseDivisionPage;
import pageObjects.MerchandiseGroupPage;
import pageObjects.MerchandisePage;
import pageObjects.MerchandiseSubClassPage;
import pageObjects.SystemAndReferenceMasterPage;
import utilities.GenericUtilities;
import utilities.GenericUtilities.IncorrectXpathException;
import utilities.PropertiesReader;

public class SystemAndReferenceMasterSteps {
	WebDriver driver;
	String Subclass_name, SubClass_Value;

	public static String cityCode, cityName;
	public static String langCode, langName, langshortcode;
	public static String DgSubClassCode, inpUNUnimber;
	public static String stateCode, stateName;

	String TestData_filePath = "testData/TestData.properties";
	PropertiesReader testdata = new PropertiesReader(TestData_filePath);

	GenericUtilities utils = new GenericUtilities(driver);
	MerchandiseBusinessUnitPage BUPage = new MerchandiseBusinessUnitPage(BaseClass.getDriver());
	MerchandiseDivisionPage MndivisionPage = new MerchandiseDivisionPage(BaseClass.getDriver());
	MerchandiseGroupPage GroupPage = new MerchandiseGroupPage(BaseClass.getDriver());
	MerchandiseDepartmentPage DepartmentPage = new MerchandiseDepartmentPage(BaseClass.getDriver());
	MerchandiseClassPage ClassPage = new MerchandiseClassPage(BaseClass.getDriver());
	MerchandiseSubClassPage SubClassPage = new MerchandiseSubClassPage(BaseClass.getDriver());
	SystemAndReferenceMasterPage sysandrefmaster = new SystemAndReferenceMasterPage(BaseClass.getDriver());

	MerchandisePage Mnp = new MerchandisePage(BaseClass.getDriver());

	@When("I click on LANGUAGE MASTER")
	public void clickLanguageMasterButton() throws InterruptedException, IncorrectXpathException {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.ClickOnLanguageMaster();
	}

	@When("I create a new LANGUAGE MASTER {string},{string},{string},{string},{string}")
	public void createNewLanguageMaster(String languageCode, String languageName, String languageShortName,
			String applicableCountries, String status) {

		langCode = languageCode + utils.generateRandomChars(6);

		System.out.println(langCode);
		langName = languageName + utils.generateRandomChars(6);

		System.out.println(langName);

		langshortcode = languageShortName + utils.generateRandomChars(3);

		sysandrefmaster.AddLanguageMaster(langCode, langName, langshortcode, applicableCountries, status);
	}

	@Then("I should validate LANGUAGE MASTER in the table")
	public void validateLanguageMasterInTable() throws IncorrectXpathException, InterruptedException {

		sysandrefmaster.validateLanguageMaster(langCode, langName);

		String strlangCode = Mnp.getCellValue(3, 1);
		System.out.println(strlangCode);

		System.out.println(strlangCode);

		Assert.assertEquals(strlangCode, langCode);

		String strlangName = Mnp.getCellValue(3, 2);
		System.out.println(strlangName);

		System.out.println(strlangName);

		Assert.assertEquals(strlangName, langName);

	}

	@Then("I should validate CITY MASTER in the table")
	public void validateCityMasterInTable() throws IncorrectXpathException, InterruptedException {

		sysandrefmaster.validateCityMaster(cityCode, cityName);

		String strcityCode = Mnp.getCellValue(3, 1);
		System.out.println(strcityCode);

		Assert.assertEquals(strcityCode, cityCode);

		String strCityName = Mnp.getCellValue(3, 2);
		System.out.println(strCityName);

		Assert.assertEquals(strCityName, cityName);

	}

	@Then("I should validate DG MASTER in the table")
	public void validate_DG_MASTER_Table() throws IncorrectXpathException, InterruptedException {
		sysandrefmaster.validateDGyMaster(DgSubClassCode);

		String strDGSubClass = Mnp.getCellValue(3, 3);
		System.out.println(strDGSubClass);

		Assert.assertEquals(strDGSubClass, DgSubClassCode);

	}

	@When("I click on CITY MASTER")
	public void I_click_on_CITY_MASTER() throws InterruptedException {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.clickOnCityMaster();
	}

	// **
	@When("I click on DG MASTER")
	public void I_click_on_DG_MASTER() throws InterruptedException {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.clickOnDGMaster();
	}

	@When("I create a new DG MASTER {string},{string},{string},{string},{string},{string}")
	public void createNewDGeMaster(String dgCode, String dgDescription, String status, String strDgSubClass,
			String strDgSubDesc, String inpUNUDescription) throws InterruptedException {

		DgSubClassCode = strDgSubClass + utils.generateRandomChars(6);

		System.out.println(DgSubClassCode);

		inpUNUnimber = utils.generateRandomNumbers(4);

		System.out.println(inpUNUnimber);

		sysandrefmaster.addDGMasterbutton();
		sysandrefmaster.AddDGMaster(dgCode, dgDescription, status, DgSubClassCode, strDgSubDesc, inpUNUnimber,
				inpUNUDescription);
	}

	// ***

	@When("I create a new CITY MASTER {string},{string},{string},{string},{string},{string}")
	public void createNewCityeMaster(String cityCodeMaster, String cityNameMaster, String strCountryName,
			String strSateName, String strStrTimeZone, String status) throws InterruptedException {

		cityCode = cityCodeMaster + utils.generateRandomChars(6);

		System.out.println(cityCode);
		cityName = cityNameMaster + utils.generateRandomChars(6);

		// System.out.println(langName);
		sysandrefmaster.addCityMasterbutton();
		sysandrefmaster.AddCityMaster(cityCode, cityName, strCountryName, strSateName, strStrTimeZone, status);

	}

	@When("I click on Logo Master")
	public void I_click_on_Logo_Master() throws InterruptedException {
		{
			sysandrefmaster.clickOnMasterLogMaster();
			sysandrefmaster.selectImage();

		}
	}

	@When("I upload an image for {string} logo less {string} {string}")
	public void I_upload_an_image_for_Desktop_logo_less_than_5MB(String strType, String strSize, String strColor)
			throws InterruptedException, AWTException {

		sysandrefmaster.erroValidation(strType, strSize, strColor);
	}

	@When("I upload an image for {string} logo {string} {string}")
	public void I_upload_an_image_for_Desktop_logo_more_than_5MB(String strType, String strSize, String strColor)
			throws InterruptedException, AWTException {
		sysandrefmaster.erroValidation(strType, strSize, strColor);
	}

	@Then("I should validate upload image {string}")
	public void I_should_see_a_success_message_for_the_upload(String imageType) {

		// Use a switch statement for cleaner conditional logic
		switch (imageType.toLowerCase()) {
		case "desktop":
			sysandrefmaster.imageExistAfterUploadDesktop();
			break;
		case "mobile":
			sysandrefmaster.imageExistAfterUploadMobile();
			break;
		default:
			throw new IllegalArgumentException("Invalid image type: " + imageType);
		}
	}

	@Then("The uploaded image is displayed correctly")
	public void The_uploaded_image_is_displayed_correctly()

	{

		// ******************************Start
	}// Currency

	@When("User clicks on Masters menu")
	public void user_clicks_on_masters_menu() {
		sysandrefmaster.masterClick();

	}

	@When("user clicks on Currency Master menu")
	public void user_clicks_on_currency_master_menu() {
		sysandrefmaster.currencyMastermasterClick();
	}

	@Then("user navigate to the Currency Page")
	public void user_navigate_to_the_currency_page() {
		String currencyHeader = " CURRENCY MASTER ".trim();
		String headercur = sysandrefmaster.addCurrencyMaster_Click();

		org.testng.Assert.assertEquals(headercur, currencyHeader);
		sysandrefmaster.addCurrency_Click();

	}

	@When("User Provides all the Currency mandatory details as {string},{string},{string},{string},{string}")
	public void user_provides_all_the_mandatory_details_as(String string, String string2, String string3,
			String string4, String string5) {
		sysandrefmaster.provideCurrencyDetails(string, string2, string3, string4, string5);
	}

	@Then("User Validate the success message")
	public void user_validate_the_success_message() {
		System.out.println("");
	}

	// Search and edit
	@When("User provide Currency Code as {string} and Currency Name as {string} and filter the record")
	public void user_provide_currency_code_as_and_currency_name_as_and_filter_the_record(String string,
			String string2) {
		sysandrefmaster.provide_details_forSearchField(string, string2);
	}

	@When("User update the Currency records with data")
	public void user_update_the_records_with_data(List<String> details) {
		System.out.println(details.get(0));
		System.out.println(details.get(1));
		System.out.println(details.get(2));
		System.out.println(details.get(3));
		sysandrefmaster.updateCurrencyDetails(details.get(0), details.get(1), details.get(2), details.get(3));

	}

	@Then("User Validate the success message as {string}")
	public void user_validate_the_success_message_as(String SuccessMessage) {
		sysandrefmaster.getMessage(SuccessMessage);
	}

	// Country Master steps

	@When("user clicks on Country Master menu")
	public void user_clicks_on_country_master_menu() {
		sysandrefmaster.countryMasterMenu_Click();
	}

	@Then("user navigate to the Country Page")
	public void user_navigate_to_the_country_page() {
		sysandrefmaster.addCountryMasterClick();
	}

	@When("User Provides all the Country mandatory details as {string},{string},{string},{string},{string},{string},{string}")
	public void user_provides_all_the_mandatory_details_as(String contrycode, String countryname, String ISO1,
			String ISO2, String ISO3, String TimeZone, String status) {
		sysandrefmaster.provideCountryDetails(contrycode, countryname, ISO1, ISO2, ISO3, TimeZone, status);
	}

	// UpdateCountry
	@When("User provide Country Code as {string} and Country Name as {string} and filter the record")
	public void user_provide_country_code_as_and_country_name_as_and_filter_the_record(String countrycode,
			String countryname) {
		sysandrefmaster.provide_details_forSearchField(countrycode, countryname);
	}

	@When("User update the Country records with data")
	public void user_update_the_country_records_with_data(List<String> details) {
		System.out.println(details.get(0));
		System.out.println(details.get(1));
		System.out.println(details.get(2));
		System.out.println(details.get(3));
		System.out.println(details.get(4));
		System.out.println(details.get(5));

		sysandrefmaster.updateCountryDetails(details.get(0), details.get(1), details.get(2), details.get(3),
				details.get(4), details.get(5));
	}

	// UOM Master

	@When("user clicks on UOM menu")
	public void user_clicks_on_uom_menu() {
		sysandrefmaster.uom_Master_Menu_Click();
	}

	@Then("user navigate to the UOM master Page")
	public void user_navigate_to_the_uom_master_page() {
		sysandrefmaster.click_AddUOM();

	}

	@When("User Provides all the UOM mandatory details as {string},{string},{string},{string}")
	public void user_provides_all_the_mandatory_details_as(String measurename, String symbol, String MeasureUnit,
			String status) {
		sysandrefmaster.provideUOMDetails(measurename, symbol, MeasureUnit, status);
	}

	// UOM filter

	@When("User provide UOMmeasurecode as {string} and UOMMeasure Name as {string} and filter the record")
	public void user_provide_uo_mmeasurecode_as_and_uom_measure_name_as_and_filter_the_record(String string,
			String string2) {
		sysandrefmaster.provide_details_forSearchField(string, string2);
	}

	@When("User update the UOM records with data")
	public void user_update_the_uom_records_with_data(List<String> details) {
		sysandrefmaster.updateUOMDetails(details.get(0), details.get(1), details.get(2), details.get(3));
	}

	// Suburb master

	@When("user clicks on Suburb menu")
	public void user_clicks_on_suburb_menu() {
		sysandrefmaster.addSuburbMenu_Click();
	}

	@Then("user navigate to the Suburb master Page")
	public void user_navigate_to_the_suburb_master_page() {
		sysandrefmaster.addSuburb_Button_click();
	}

	@When("User Provides all the Suburb mandatory details as {string},{string},{string},{string},{string},{string},{string}")
	public void user_provides_all_the_suburb_mandatory_details_as(String subcode, String subname, String country,
			String state, String city, String postalcode, String status) {
		sysandrefmaster.provideSuburbDetails(subcode, subname, country, state, city, postalcode, status);
	}

	// Suburb search and update
	@When("User provide Suburbcode as {string} and Suburbname as {string} and filter the record")
	public void user_provide_suburbcode_as_and_suburbname_as_and_filter_the_record(String subcode, String subname) {
		sysandrefmaster.provide_details_forSearchField(subcode, subname);
	}

	@When("User update the Suburb records with data")
	public void user_update_the_suburb_records_with_data(List<String> details) {

		sysandrefmaster.updateSuburbDetails(details.get(0), details.get(1), details.get(2), details.get(3),
				details.get(4), details.get(5));
	}

	// HTS Master

	@When("user clicks on HTS menu")
	public void user_clicks_on_hts_menu() {
		sysandrefmaster.addHTSMaster_Click();
	}

	@Then("user navigate to the HTS master Page")
	public void user_navigate_to_the_hts_master_page() {
		sysandrefmaster.addHTS_Button_Click();
	}

	@Then("User Provides all the HTS mandatory details as {string},{string},{string}")
	public void user_provides_all_the_hts_mandatory_details_as(String HTSCode, String HTSDescription, String status) {
		sysandrefmaster.provideHTSDetails(HTSCode, HTSDescription, status);

	}

	// HTS Search and edit
	@When("User provide HTScode as {string} and HTSName as {string} and filter the record")
	public void user_provide_ht_scode_as_and_hts_name_as_and_filter_the_record(String string, String string2) {
		String HTSCode = getProperties("HTSCode");
		String HTSDes = getProperties("HTSDescription");
		sysandrefmaster.provide_details_forSearchField(HTSCode, HTSDes);
	}

	@When("User update the HTS records with data")
	public void user_update_the_hts_records_with_data(io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> maphts = dataTable.asMap();
		sysandrefmaster.updateHTSDetails(maphts.get("HTS Code"), maphts.get("HTS Description"), maphts.get("status"));
	}

	public String getProperties(String getfor) {
		String TestData_filePath = "testData/TestData.properties";
		String Config_filePath = "src/test/resources/config.properties";
		PropertiesReader testdata = new PropertiesReader(TestData_filePath);
		return testdata.getProperty(getfor);
	}

//******************************End

	// Start by Sai

	@When("I click on STATE MASTER")
	public void clickStateMasterButton() throws InterruptedException, IncorrectXpathException {
		sysandrefmaster.clickOnMasterLogMaster();
		sysandrefmaster.clickOnStateMaster();
		sysandrefmaster.addStateMasterbutton();
	}

	@When("I create a new STATE MASTER {string},{string},{string},{string},{string}")
	public void createNewStateMaster(String stateCodeMaster, String stateNameMaster, String countryAssociated,
			String timeZone, String status) throws InterruptedException {

		stateCode = stateCodeMaster + utils.generateRandomChars(6);

		System.out.println(stateCode);
		stateName = stateNameMaster + utils.generateRandomChars(6);

		System.out.println(stateName);

		sysandrefmaster.addStateMaster(stateCode, stateName, countryAssociated, timeZone, status);
	}

	@Then("I should validate STATE MASTER in the table")
	public void validateStateMasterInTable() throws IncorrectXpathException, InterruptedException {

		sysandrefmaster.validateStateMaster(stateCode, stateName);

		String strStateCode = Mnp.getCellValue(3, 1);
		System.out.println(strStateCode);

		System.out.println(strStateCode);

		Assert.assertEquals(strStateCode, stateCode);

		String strStateName = Mnp.getCellValue(3, 2);
		System.out.println(strStateName);

		System.out.println(strStateName);

		Assert.assertEquals(strStateName, stateName);

	}

	public static String transferZoneCode, transferZoneDesciption;

	@When("I click on TRANSFER ZONE")
	public void clickTransferZone() throws InterruptedException, IncorrectXpathException {

		sysandrefmaster.clickOnZoneOption();
		sysandrefmaster.clickOnAddZoneBtn();
	}

	@When("I create a TRANSFER ZONE {string},{string},{string},{string},{string},{string}")
	public void createTransferZone(String zoneCode, String zoneDescription, String zoneRemarks, String status,
			String hierarchyLevel, String hierarchyValue) throws InterruptedException {

		transferZoneCode = zoneCode + utils.generateRandomChars(6);

		System.out.println(transferZoneCode);
		transferZoneDesciption = zoneDescription + utils.generateRandomChars(6);

		System.out.println(transferZoneDesciption);

		sysandrefmaster.addTransferZone(transferZoneCode, transferZoneDesciption, zoneRemarks, status, hierarchyLevel,
				hierarchyValue);
	}

	@Then("I should validate TRANSFER ZONE in the table")
	public void validateTransferZoneInTable() throws IncorrectXpathException, InterruptedException {

		sysandrefmaster.validateZone(transferZoneCode, transferZoneDesciption);

		String strZoneCode = Mnp.getCellValue(3, 1);
		System.out.println(strZoneCode);

		System.out.println(strZoneCode);

		Assert.assertEquals(strZoneCode, transferZoneCode);

		String strZoneDescription = Mnp.getCellValue(3, 2);
		System.out.println(strZoneDescription);

		System.out.println(strZoneDescription);

		Assert.assertEquals(strZoneDescription, transferZoneDesciption);

	}

	@When("I will select the VAT Region Master from the Master options")
	public void selectVATRegionMaster() throws InterruptedException {
		sysandrefmaster.masterClick();
		sysandrefmaster.ClickVATRegionMaster();
	}

	@And("I will select Add VAT Region option to enter the details")
	public void selectAddVATRegion() throws InterruptedException {
		sysandrefmaster.ClickAddVatRegion();
		Thread.sleep(3000);
	}

	@When("I will add the VAT Region Master fields {string},{string},{string},{string}")
	public void i_will_add_the_vat_region_master_fields(String VAT_Region_Code, String VAT_Region_Name, String Remarks,
			String Status) throws InterruptedException {
		sysandrefmaster.SelectVATRegionCode(VAT_Region_Code);
		sysandrefmaster.SelectVATRegionName(VAT_Region_Name);
		sysandrefmaster.SelectRemarks(Remarks);
		sysandrefmaster.Updatestatus(Status);
	}

	@And("I will click on save button and verify success message")
	public void clickSaveButton() throws InterruptedException {
		sysandrefmaster.click_savebtn();
		sysandrefmaster.verifysuccessfullcreationofVATRegionMaster();
	}

	@And("I will click on cancel button and check page navigates to view page")
	public void clickCancelButton() throws InterruptedException {
		sysandrefmaster.click_Cancelbutton();
	}

	@When("I will select the VAT Master from the Master options")
	public void selectVATMaster() throws InterruptedException {
		sysandrefmaster.masterClick();
		sysandrefmaster.ClickVATMaster();
	}

	@And("I will select Add item option to enter the details")
	public void selectAddItemOption() throws InterruptedException {
		sysandrefmaster.ClickAddVat();

	}

	@When("I will add the VAT Master fields {string},{string},{string},{string},{string},{string},{string}")
	public void i_will_add_the_vat_master_fields(String VAT_Region, String VAT_Code, String VAT_Type, String VAT_Rate,
			String Effective_Date, String Remarks, String Status) throws InterruptedException {
		sysandrefmaster.SelectVATRegion(VAT_Region);
		sysandrefmaster.SelectVATCode(VAT_Code);
		sysandrefmaster.SelectVATType(VAT_Type);
		sysandrefmaster.SetVATRate(VAT_Rate);
		sysandrefmaster.selectEffectiveDate(Effective_Date);
		sysandrefmaster.selectdate();
		sysandrefmaster.SetRemarks(Remarks);
		sysandrefmaster.Addstatus(Status);
	}

	@And("I will verify the VAT Description is prepopulated {string}")
	public void verifyVATDescription(String VAT_Code) {
		sysandrefmaster.verifyVATDescription(VAT_Code);
	}

	@When("I will search for the newly created record from the VAT Region filters and select Edit")
	public void searchrecord() throws InterruptedException {
		sysandrefmaster.SelectVATRegionrecordfromfilters();
		Thread.sleep(3000);
		sysandrefmaster.editrecord();
	}

	@When("I will update the VAT Master fields {string},{string},{string},{string},{string}")
	public void i_will_update_the_vat_master_fields(String VAT_Type, String VAT_Rate, String Effective_Date,
			String Remarks, String Status) throws InterruptedException {
		sysandrefmaster.SelectVATType(VAT_Type);
		sysandrefmaster.SetVATRate(VAT_Rate);
		sysandrefmaster.selectEffectiveDate(Effective_Date);
		sysandrefmaster.selectdate();
		sysandrefmaster.SetRemarks(Remarks);
		sysandrefmaster.Updatestatus(Status);
	}

	@And("I will click on cancel button")
	public void click_CancelButton() throws InterruptedException {
		sysandrefmaster.click_Cancelbutton();
	}

	@And("I will click on save button")
	public void I_click_SaveButton() throws InterruptedException {
		sysandrefmaster.click_savebtn();
		sysandrefmaster.verifysuccessfullcreationofVATMaster();
	}

	// Differentiators
	public static String DiffTypeName, DiffTypeRemarks, DiffTypeStatus, NewDiffTypeStatus, ItemType, DiffValueTypeName,
			DiffValue;

	@When("I click on Differentiators dropdown")
	public void iClickOnDifferentiatorsDropdown() throws InterruptedException {
		sysandrefmaster.openMastersDropdownIfClosed();
		sysandrefmaster.openDifferentiatorDropdownIfClosed();
	}

	@And("I click on Differentiator Type dropdown")
	public void iClickOnDifferentiatorTypeDropdown() {
		sysandrefmaster.clickDifferentiatorTypeDropdown();

	}

	@Then("I click on Add Differentiator Type")
	public void iClickOnAddDifferentiatorType() {
		sysandrefmaster.validateViewDifferentiatorPageAvailability();
		sysandrefmaster.clickOnAddDifferentiatorType();
	}

	@And("I enter the details for Differentiator Type {string},{string},{string}")
	public void iEnterTheDetailsForDifferentiatorType(String diffType, String Remarks, String Status) {
		DiffTypeName = diffType + " " + utils.generateRandomChars(3);
		DiffTypeRemarks = Remarks;
		DiffTypeStatus = Status;
		sysandrefmaster.enterDifferentiatorTypeDetails(DiffTypeName, DiffTypeRemarks, DiffTypeStatus);
	}

	@And("I click on Save button")
	public void iClickOnSaveButton() {
		sysandrefmaster.clickOnSaveButton();
	}

	@Then("I verify the following details {string},{string},{string} in Edit Page")
	public void iVerifyTheFollowingDetailsInEditPage(String diffType, String Remarks, String Status)
			throws InterruptedException {
		sysandrefmaster.validateViewDifferentiatorPageAvailability();
		sysandrefmaster.clickOnEditBtn(DiffTypeName);
		sysandrefmaster.validateTypePage();
		sysandrefmaster.verifyDifferentiatorTypeDetails(DiffTypeName, Remarks, Status);
	}

	@And("I enter the details for Differentiator Type with more than maximum limit data on {string},{string},{string}")
	public void iEnterTheDetailsForDifferentiatorTypeWithMoreThanMaximumLimitDataOn(String diffType, String Remarks,
			String Status) {
		DiffTypeName = diffType + " " + utils.generateRandomChars(20);
		DiffTypeRemarks = Remarks + " " + utils.generateRandomChars(100);
		sysandrefmaster.enterDifferentiatorTypeDetails(DiffTypeName, DiffTypeRemarks, Status);
	}

	@Then("I verify Error Messages")
	public void iVerifyErrorMessages() {
		sysandrefmaster.validateErrorMessages();
	}

	@And("I click on Cancel button and verify popup")
	public void iClickOnCancelButtonAndVerifyPopup() {
		sysandrefmaster.clickOnCancelButton();
	}

	@And("Modify the values for {string},{string} and Click on Save")
	public void modifyTheValuesForAndClickOnSave(String Remarks, String Status) {
		DiffTypeRemarks = Remarks + " " + utils.generateRandomChars(3);
		NewDiffTypeStatus = Status.equalsIgnoreCase("Active") ? "Inactive" : "Active";
		System.out.println("DiffStatus: " + NewDiffTypeStatus);
		sysandrefmaster.modifyDifferentiatorTypeDetails(DiffTypeRemarks, NewDiffTypeStatus);
		sysandrefmaster.clickOnSaveButton();
	}

	@Then("Check the modified data in Edit page")
	public void checkTheModifiedDataInEditPage() throws InterruptedException {
		Thread.sleep(4000);
		sysandrefmaster.validateViewDifferentiatorPageAvailability();
		sysandrefmaster.clickOnEditBtn(DiffTypeName);
		sysandrefmaster.validateTypePage();
		sysandrefmaster.verifyDifferentiatorTypeDetails(DiffTypeName, DiffTypeRemarks, NewDiffTypeStatus);
	}

}
