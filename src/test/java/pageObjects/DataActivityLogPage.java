package pageObjects;

	
	
	import static org.testng.Assert.assertEquals;

	import java.time.Duration;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;

	import utilities.GenericUtilities;

	public class DataActivityLogPage extends BasePage {

		WebDriverWait wait;
		public int waittime = 3000;
		String day;
		private Map<String, String> dataFilters = new HashMap<>();

		public DataActivityLogPage(WebDriver driver) {
			super(driver);
		}

		GenericUtilities utils = new GenericUtilities(driver);

		@FindBy(xpath = "//span[contains(text(),'Activity Log')]")
		WebElement btn_Activitylog;

		@FindBy(xpath = "//div[@id='module']/span")
		WebElement drp_modulename;

		@FindBy(xpath = "//input[@role='searchbox']")
		WebElement searchbox;

		@FindBy(xpath = "//div[@id='table']/span")
		WebElement drp_tablename;

		@FindBy(xpath = "//div[@id='user']/span")
		WebElement drp_username;

		@FindBy(xpath = "//p-button[@icon='pi pi-search']/button")
		WebElement btn_apply;

		@FindBy(xpath = "//p-button[@icon='pi pi-refresh']/button")
		WebElement btn_reset;

		@FindBy(xpath = "//span[@class='ng-tns-c1685646730-50 p-calendar p-input-icon-right']/input")
		WebElement table_fromdate;

		@FindBy(xpath = "//span[@class='ng-tns-c1685646730-51 p-calendar p-input-icon-right p-focus']/input")
		WebElement table_todate;

		@FindBy(xpath = "//label[contains(text(),'From Date')]//following::input[1]")
		WebElement Fromdate_EffectiveDate;

		@FindBy(xpath = "//label[contains(text(),'From Date')]//following::input[2]")
		WebElement Todate_EffectiveDate;

		@FindBy(xpath = "//button[@aria-label='Choose Month']")
		WebElement Choosemonth;

		@FindBy(xpath = "//button[@aria-label='Choose Year']")
		WebElement Chooseyear;

		@FindBy(xpath = "//button[@aria-label='Next Month']")
		WebElement Nextmonth_btn;

		@FindBy(xpath = "//li[@id='table_0']/span[1]")
		WebElement search_Tablevalue;

		@FindBy(xpath = "//li[@id='module_0']/span[1]")
		WebElement search_Modulevalue;

		@FindBy(xpath = "//li[@id='user_0']/span[1]")
		WebElement search_Username;

		@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]/td[2]")
		WebElement txt_gridmodulename;

		@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]/td[3]")
		WebElement txt_gridtablename;

		@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]/td[4]")
		WebElement txt_gridactivitydate;

		@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]/td[6]")
		WebElement txt_username;
		
		@FindBy(xpath="//span[contains(text(),'No Records Found')]")
		WebElement txt_norecordmsg;

		public void ClickActivitylog() throws InterruptedException {
			if (btn_Activitylog.isDisplayed()) {
				utils.waitForElementToBeVisiblewithFluentWait(btn_Activitylog, waittime);
				utils.clickOnWebElement(btn_Activitylog);
			} else {
				utils.retryingFindClick(By.xpath("//span[contains(text(),'Activity Log')]"));
				System.out.println("Activity log button is not displayed");
			}
		}

		public void SelectModulename(String Modulename) throws InterruptedException {

			utils.waitForElementToBeVisiblewithFluentWait(drp_modulename, waittime);
			System.out.println("check on modulename to appear");

			utils.clickOnWebElement(drp_modulename);

			System.out.println("clicked on modulename dropdown");

			utils.waitForElementToBeVisiblewithFluentWait(searchbox, waittime);

			utils.slowSendKeys(searchbox, Modulename, 300);
			// searchbox.sendKeys(Modulename);
			utils.waitForElementToBeVisiblewithFluentWait(search_Modulevalue, waittime);
			search_Modulevalue.click();
			/*
			 * Actions actions = new Actions(driver);
			 * actions.sendKeys(Keys.TAB).build().perform();
			 * actions.sendKeys(Keys.ENTER).build().perform();
			 */
		}

		public void SelectTablename(String Tablename) throws InterruptedException {

			utils.waitForElementToBeVisiblewithFluentWait(drp_tablename, waittime);
			System.out.println("check on Tablename to appear");
			utils.clickOnWebElement(drp_tablename);
			System.out.println("clicked on Tablename dropdown" + Tablename);
			utils.waitForElementToBeVisiblewithFluentWait(searchbox, waittime);
			utils.slowSendKeys(searchbox, Tablename, 300);
			utils.waitForElementToBeVisiblewithFluentWait(search_Tablevalue, waittime);
			search_Tablevalue.click();
		}

		public void SelectUsername(String Username) throws InterruptedException {

			utils.waitForElementToBeVisiblewithFluentWait(drp_username, waittime);
			System.out.println("check on Username to appear");
			utils.clickOnWebElement(drp_username);
			System.out.println("clicked on Username dropdown" + Username);
			utils.waitForElementToBeVisiblewithFluentWait(searchbox, waittime);
			utils.slowSendKeys(searchbox, Username, 300);
			utils.waitForElementToBeVisiblewithFluentWait(search_Username, waittime);
			search_Username.click();
		}

		public void selectfromDate(String Effective_Date) {
			String[] eff_date = Effective_Date.split("/");
			day = eff_date[0];
			String month = eff_date[1];
			String year = eff_date[2];

			System.out.println("day is:" + day);
			System.out.println("month is:" + month);
			System.out.println("year is:" + year);

			Fromdate_EffectiveDate.click();
			while (true) {
				String currentMonth = Choosemonth.getText().trim();// actutal month
				String currentYear = Chooseyear.getText().trim();// actual year

				System.out.println(currentMonth);
				System.out.println(currentYear);

				if (currentMonth.equals(month) && currentYear.equals(year)) {
					break;
				} else {
					Nextmonth_btn.click();// Next
				}
			}
		}

		public void selecttoDate(String Effective_Date) throws InterruptedException {
			Thread.sleep(waittime);
			String[] eff_date = Effective_Date.split("/");
			day = eff_date[0];
			String month = eff_date[1];
			String year = eff_date[2];

			System.out.println("day is:" + day);
			System.out.println("month is:" + month);
			System.out.println("year is:" + year);

			Todate_EffectiveDate.click();
			while (true) {
				String currentMonth = Choosemonth.getText().trim();// actutal month
				String currentYear = Chooseyear.getText().trim();// actual year

				System.out.println(currentMonth);
				System.out.println(currentYear);

				if (currentMonth.equals(month) && currentYear.equals(year)) {
					break;
				} else {
					Nextmonth_btn.click();// Next
				}
			}
		}

		public void selectdate() throws InterruptedException {
			// Thread.sleep(waittime);
			List<WebElement> dates = driver
					.findElements(By.xpath("//td[contains(@class,'ng-star-inserted') and @aria-label]/span"));
			System.out.println("Number of date elements found: " + dates.size());

			for (WebElement dateElement : dates) {
				// System.out.println("getting into loop");
				String fulldate = dateElement.getAttribute("data-date");
				String[] dd = fulldate.split("-");
				String daydate = dd[2];
				if (daydate.equals(day)) {
					System.out.println("Found matching date element and clicked.");
					dateElement.click();
					break; // Click only the first matching element (remove if needed)
				}
				// break;
			}
		}

		public void click_applybutton() throws InterruptedException {
			// utils.waitForElementclickable(Duration.ofSeconds(10), Yes_button);
			utils.waitForElementToBeClickablewithFluentWait(btn_apply, 5);
			System.out.println("Clicked on apply button");
			btn_apply.click();
			Thread.sleep(waittime); //can't remove due to performance issue
		}

		public void click_resetbutton() throws InterruptedException {
			// utils.waitForElementclickable(Duration.ofSeconds(10), Yes_button);
			utils.waitForElementToBeClickablewithFluentWait(btn_reset, 5);
			System.out.println("Clicked on reset button");
			btn_reset.click();
		}

		public String getTextFromElement(WebElement elementId) {
			String element = elementId.getText();
			return element;
		}

		public void VerifyTheRecordsInTheGrid(String module_Name, String table_Name, String user_Name) {
			dataFilters.put("moduleName", module_Name);
			dataFilters.put("tableName", table_Name);
			dataFilters.put("userName", user_Name);

			Map<String, String> actualData = new HashMap<>();
			actualData.put("moduleName", txt_gridmodulename.getText());
			actualData.put("tableName", txt_gridtablename.getText());
			actualData.put("userName", txt_username.getText());

			// Comparing actual values with expected values from the feature file
			for (Map.Entry<String, String> entry : dataFilters.entrySet()) {
				assertEquals(entry.getValue(), actualData.get(entry.getKey()));
			}

		}
		
		public void verifytherecordsgetsclearedfromtable()
		{
			try {
				String value=txt_norecordmsg.getText();
				if(value.equals("No Records Found"))
				{
					Assert.assertTrue(true, "Records gets cleared from the table");
					System.out.println("Records gets cleared from the table");
				}
				else
				{
					Assert.fail("Record not get cleared from the table");
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


