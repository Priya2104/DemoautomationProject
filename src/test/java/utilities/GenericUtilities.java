package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Dimension;
import java.awt.Toolkit;

import factory.BaseClass;

public class GenericUtilities {

	WebDriver driver;
	WebDriverWait wait;
	static JavascriptExecutor js;
	// private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private static final Logger LOGGER = Logger.getLogger(GenericUtilities.class.getName());
	// protected ScenarioState state;
	int PAGE_IMPLICIT_WAIT = 60;
	// Properties p;

	// WebDriverWait wait = new WebDriverWait(driver, 20);

	protected JavascriptExecutor jsExecutor;
	private String stylePrevious = "";

	public Properties configReader = new Properties();

	public GenericUtilities(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

	}
	
	public String generateRandomNumbers(int length) {
	    String candidateChars = "1234567890"; // Only numeric digits
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
	    }

	    return sb.toString();
	}

	/**
	 * Choosing the Right Locator
	 *
	 * @param Locatortype and value.
	 * @author PUllaiah
	 * 
	 */
	public WebElement findElement(String locatorType, String locatorValue) {
		By by = null;
		WebElement ele = null;
		if (locatorType.equalsIgnoreCase("id")) {
			by = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("class")) {
			by = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("cssselector")) {
			by = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			by = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("tag")) {
			by = By.tagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			by = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			by = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			by = By.partialLinkText(locatorValue);
		} else {
			System.out.println("Not a valid locator");
			return ele;
		}
		try {
			ele = driver.findElement(by);
		} catch (Exception e) {
			System.out.println("No such element exists. Please try again with valid locators.");
		}
		return ele;
	}

	public List<WebElement> findElements(String locatorType, String locatorValue) {
		By by = null;
		List<WebElement> elements;
		if (locatorType.equalsIgnoreCase("id")) {
			by = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("class")) {
			by = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("cssselector")) {
			by = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			by = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("tag")) {
			by = By.tagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			by = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			by = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			by = By.partialLinkText(locatorValue);
		} else {
			System.out.println("Not a valid locator");
		}
		elements = driver.findElements(by);
		return elements;
	}

	/**
	 * Choosing the Right Locator
	 *
	 * @param element.
	 * @author PUllaiah
	 * @throws IncorrectXpathException
	 * 
	 */

	public boolean doesElementExist(WebElement element) throws IncorrectXpathException {
		try {
			if (element.isDisplayed()) {
				return true;
			} else {

				return false;

			}
		} catch (NoSuchElementException e) {

			LOGGER.log(Level.SEVERE, "Element not exist: ", e);
			throw new IncorrectXpathException("The provided XPath for  field might be incorrect.");

		}

	}
	
	

	public class IncorrectXpathException extends Exception {
		public IncorrectXpathException(String message) {
			super(message);
		}
	}

	/**
	 * Highlights the web element
	 *
	 * @param WebElement Element to be highlighted
	 * @author PUllaiah
	 * 
	 */
	public void highlightElement(WebElement webElement) {
		try {
			stylePrevious = (String) jsExecutor.executeScript("arguments[0].getAttribute('style')", webElement);
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:4px dashed #F00')", webElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * waiting for element visibility in selenium
	 *
	 * @param timeToWaitInSeconds and elementToWaitFor
	 * @author PUllaiah @since-02-04- 2024
	 */

	public void waitForElementVisibilityFor(Duration timeToWaitInSeconds, WebElement elementToWaitFor) {
		wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}

	public void typeInItems(WebElement typingField, String textToType) {
		typingField.clear();
		typingField.sendKeys(textToType);
	}

	public void clickOnWebElement(WebElement clickableElement) {

		try {
			// waitForElementVisibilityFor(Duration.ofSeconds(20),clickableElement);
			waitForElementToBeVisiblewithFluentWait(clickableElement, 60);
			clickableElement.click();

		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			throw new ElementNotFoundException("Element is not found!");

		}

	}
	
	public void  fnScreenResolutionExample() {
		 
	    
	        // Get the default toolkit
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	 
	        // Get the screen size from the toolkit
	        Dimension screenSize = toolkit.getScreenSize();
	 
	        // Extract width and height
	        int screenWidth = (int) screenSize.getWidth();
	        int screenHeight = (int) screenSize.getHeight();
	 
	        // Print the screen resolution
	        System.out.println("Screen Resolution: " + screenWidth + "x" + screenHeight);
	    
	}

	public void doubleclickOnWebElement(WebElement clickableElement) {

		try {

			waitForElementVisibilityFor(Duration.ofSeconds(20), clickableElement);
			Actions actions = new Actions(driver);

			// Perform the double-click action on the element
			actions.doubleClick(clickableElement).perform();

			clickableElement.click();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param strFieldName - name of the text box
	 * @return - void
	 * @name : setValueTextBox
	 * @description enter the text into a text box when an element passed as
	 *              WebElement
	 */
	public void setValueTextBox(WebElement element, String data, String strFieldName) {
		try {
			if (this.isExists(element)) {// System.out.println("Before enter data");
				if (this.isEnabled(element)) {// System.out.println("Before enter data");
					element.click();
					element.clear();
					element.clear();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

					// element.click();
					// element.clear();
					// element.clear();
					element.sendKeys(data);
					BaseClass.getLogger().error(data + "  is entered");
				} else

					System.out.println();
				BaseClass.getLogger().error(data + "  is not entered");

			} else
				BaseClass.getLogger().error(data + "  is not entered");
			System.out.println();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			raiseException();
		}
	}

	/**
	 * @param element - PO
	 * @return Boolean
	 * @name : isEnabled
	 * @description verifying element is enabled or not
	 */
	public boolean isEnabled(WebElement element) {
		boolean temp = false;
		try {
			if (element.isEnabled()) {
				temp = true;
				return temp;
			}
		} catch (Exception e) {
			raiseException();
		}
		return temp;
	}

	/**
	 * @param element - PO
	 * @return Boolean
	 * @name : isExists
	 * @description verifying is an element exists or not
	 */
	public boolean isExists(WebElement element) {

		boolean eleExists = false;
		try {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (element.getText() != null) {
				eleExists = true;
				BaseClass.getLogger().info("element is present");
			}
		} catch (NoSuchElementException e) {
			BaseClass.getLogger().error("element is not present");
			raiseException();
		}
		return eleExists;

	}

	/**
	 * set value in the edit box
	 * 
	 * @param strFieldName - name of the text box
	 * @return - void
	 * @name : setFieldValue
	 * @description enter the text into a text box when an element passed as
	 *              WebElement
	 */

	public static void setFieldValue(WebElement element, String value, String value1) throws InterruptedException {

		try {

			element.sendKeys(value);

			element.sendKeys(Keys.ENTER);

			element.clear();

			// Clear any pre-existing value (optional)
			element.sendKeys(value1.trim());

			element.sendKeys(Keys.ENTER);

			element.sendKeys(Keys.TAB);
			// Hard wait cant remove as needed
			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);

		} catch (NoSuchElementException e) {
			BaseClass.getLogger().error("element does not exists");
		}
	}

	public static String getText(WebElement locates) throws NoSuchElementException {
		WebElement element = locates;
		return element.getText().trim(); // Remove leading/trailing whitespacess
	}

	public void hoverAndClick(WebElement clickElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(clickElement).perform();

		// Simulate down arrow key press after click (replace 2 with desired number of
		// presses)
		for (int i = 0; i < 2; i++) {
			clickElement.sendKeys(Keys.ARROW_DOWN);
			// Replace with explicit wait if needed (not recommended)

		}

		clickElement.sendKeys(Keys.ENTER);
	}

	/**
	 * @param elementValue - PO
	 * @param elementName  - name of the element
	 * @return Boolean
	 * @name : verifyElementExists
	 * @description verifies if an element is visible in the application. If the
	 *              element is not present, will return FAILED in the reports
	 */
	public boolean verifyElementExists(WebElement elementValue, String elementName) {
		boolean isElementExists = false;
		try {
			
			if (this.isExists(elementValue)) {

				BaseClass.getLogger().info("element exists");

				isElementExists = true;
			} else {
				BaseClass.getLogger().error("element does not exists");
			}
		} catch (NoSuchElementException e) {
			BaseClass.getLogger().error("element does not exists");
			raiseException();
		}
		return isElementExists;
	}

	public void scrollDown(WebDriver driver1) {
		// try {
		long height = (Long) js.executeScript("return window.innerHeight;");
		js.executeScript("window.scrollBy(0, arguments[0]);", height);
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// System.out.println(e.getMessage());
		// }

	}

	public void selectItemByVisibleText(String dropdownId, String valueToSelect) {
		WebElement dropdownElement = driver.findElement(By.xpath(dropdownId));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(valueToSelect);

	}

	/**
	 * @return void
	 * @name : raiseException
	 * @description send the fail condition when exception raised
	 */
	public void raiseException() {

		// takeScreenShot();
		// ***IMP***
		// cleanup();
		Assert.assertTrue(false);
	}

	/**
	 * Compare two strings
	 * 
	 * @param str1 and str2
	 * @return - boolean
	 * @name : compareStringsIgnoreCase
	 * @description Compare str1 and str2 WebElement
	 */

	public static boolean compareStringsIgnoreCase(String str1, String str2) {
		return str1.equalsIgnoreCase(str2);
	}

	/**
	 * Compare two strings
	 * 
	 * @param str1 and str2
	 * @return - boolean
	 * @name : compareStringsIgnoreCase
	 * @description Compare str1 and str2 WebElement
	 */

	public void setValueInEditBox(WebElement elementId, String value) {
		WebElement element = elementId;
		element.sendKeys(value);
	}

	/**
	 * @param assertionMsg -
	 * @name : raiseException
	 * @description send the fail condition when exception raised
	 */
	public void raiseException(String assertionMsg) {

		// takeScreenShot();
		Assert.assertTrue(assertionMsg, false);

	}

	public void scrollToElement(WebElement element) {
		try {
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ifElementEnabledThenClick(String locator, String locatorValue) {
		WebElement ele = findElement(locator, locatorValue);
		try {
			if (ele.isEnabled()) {
				ele.click();
			}
		} catch (Exception e) {
			System.out.println("Element does not exist.");
		}

	}

	public void clearField(WebElement element) {
		element.clear();
		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String returnTheCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void selectRandomValueFromDropdown(WebElement dropdown, int indexToExclude) {
		Select selectElement = new Select(dropdown);
		List<WebElement> elements = selectElement.getOptions();
		int numberOfOptions = elements.size();
		if (indexToExclude >= 0) {
			if (indexToExclude > (numberOfOptions - 1)) {
				System.out.println("Index chosen falls beyond the total number of options available.");
			} else {
			}
		}
	}

	public void selectValueFromDropdownByVisibleText(WebElement dropdown, String visibleText) {
		try {

			Select dropdownElement = new Select(dropdown);
			dropdownElement.selectByVisibleText(visibleText);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean waitForElementVisibility(WebElement ele)
			throws NoSuchElementException, StaleElementReferenceException {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(ele));
			return true;
		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
			throw e;
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	/**
	 * @return void
	 * @name : comoboxlist
	 * @description click on value from the list box for strReporting value
	 */
	public void comoboxlist(List<WebElement> element, String strReportingval) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(180))
				.pollingEvery(Duration.ofSeconds(180)).ignoring(NoSuchElementException.class);

		// Define the condition to wait for (optional)
		wait.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				List<WebElement> options = driver.findElements(By.xpath("//span[@class='ng-star-inserted']")); // Replace
																												// with
																												// your
																												// dropdown
																												// locator
				return options.size() > 0;
			}
		});

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Wait for up to 10 seconds
		// Store all School dropdown options into List
		List<WebElement> allOptions = element;
		// List<WebElement> allOptions = element;

		// Fetch all available options using for loop
		for (int i = 0; i <= allOptions.size() - 1; i++) {

			// Using if condition we can select desired option.
			if (allOptions.get(i).getText().contains(strReportingval)) {

				allOptions.get(i).click();
				break;

			}
		}

	}

	// Method to select a checkbox by its label text (using XPath)
	public void selectCheckboxOrRadio(WebElement labelText) throws NoSuchElementException {

		WebElement checkbox = labelText;

		checkbox.click();

		// Check if the checkbox is not already selected before clicking
		// if (!checkbox.isSelected()) {
		// checkbox.click();
		// }

	}

	public String generateRandomChars(int length) {
	    String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
	}
	/**
	 * @return void
	 * @name : comoboxlist
	 * @description click on value from the list box for strReporting
	 */

	public void comboboxlists(WebDriver driver, List<WebElement> element, String strReportingval) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		// Define the condition to wait for (optional)
		wait.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				List<WebElement> options = driver.findElements(By.xpath("//span[@class='ng-star-inserted']")); // Replace
																												// with
																												// your
																												// dropdown
																												// locator
				return options.size() > 0;
			}
		});

		// Store all School dropdown options into List
		List<WebElement> allOptions = element;
		// List<WebElement> allOptions = element;

		// Fetch all available options using for loop
		for (int i = 0; i <= allOptions.size() - 1; i++) {

			// Using if condition we can select desired option.
			if (allOptions.get(i).getText().contains(strReportingval)) {

				allOptions.get(i).click();
				break;

			}
		}
	}

	/**
	 * @return boolean
	 * @name : selectBoxByValue
	 * @description select value by name
	 */
	public boolean selectBoxByValue(WebElement element, int index)
			throws NoSuchElementException, StaleElementReferenceException {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element Not found exception when selecting option by index");
			throw e;
		} catch (StaleElementReferenceException e) {
			System.out.println("Stale element exeption when selecting option by index");
			throw e;
		}
	}

	/**
	 * @return boolean
	 * @name : comoboxlistItemtype
	 * @description select value for Item type
	 */
	public void comoboxlistItemtype(List<WebElement> element, String strval) {

		try {

			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

			// Define the condition to wait for (optional)
			wait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					List<WebElement> options = driver.findElements(By.xpath("//span[@class='ng-star-inserted']")); // Replace
																													// with
																													// your
																													// dropdown
																													// locator
					return options.size() > 0;
				}
			});

			// Store all School dropdown options into List
			List<WebElement> allOptions = element;
			// List<WebElement> allOptions = element;

			// Fetch all available options using for loop
			for (int i = 0; i <= allOptions.size() - 1; i++) {

				// Using if condition we can select desired option.
				if (allOptions.get(i).getText().contains(strval)) {

					allOptions.get(i).click();
					break;

					// System.out.println("Page in the divison Steps page");
					// System.out.println("clicked"+ allOptions.get(i));

				}

			}
		} catch (NoSuchElementException e) {

			System.out.println("Error: Item '" + strval + "' not found in the combobox list.");
		}

	}

	/**
	 * 
	 * @return boolean
	 * @throws TimeoutException 
	 * @name : selectBoxByValue
	 * @description select value from the checkbox for altenate hierarchy
	 */

	public void selectMultCheckbox(List<WebElement> element, String valueOngoingChekboxSelects) throws TimeoutException {
		  List<String> ongoingSelections = Arrays.asList(valueOngoingChekboxSelects.split("#"));  // Split on "#"

		  for (String selection : ongoingSelections) {
		    WebElement checkbox = findCheckboxByText(element, selection);  // Find by text
               System.out.println(checkbox);    
		    if (checkbox != null) {
		      waitForElementToBeClickable(checkbox);  // Existing method for single element
		      checkbox.click();
		    } else {
		      // Handle case where checkbox with specific text is not found (optional)
		      System.out.println("Checkbox with text '" + selection + "' not found");
		    }
		  }
		}
	
	public void waitForElementToBeClickable(WebElement element) throws TimeoutException {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_IMPLICIT_WAIT));  // Replace 'timeoutInSeconds' with your desired timeout

		  wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	
	public WebElement findCheckboxByText(List<WebElement> elements, String text) throws TimeoutException {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_IMPLICIT_WAIT));  // Replace 'timeoutInSeconds' with your desired timeout

		  for (WebElement element : elements) {
			  System.out.println(element);
		    if (element.getText().equalsIgnoreCase(text)) {
		      wait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
		    }
		  }
		  return null; // Checkbox not found
		}
	
	public void checkCheckboxByValue(String valueOngoingChekboxSelects) throws InterruptedException {
		  List<String> ongoingSelections = Arrays.asList(valueOngoingChekboxSelects.split("#"));  // Split on "#"
		  Thread.sleep(1000);
		  for (String selection : ongoingSelections) {
			  System.out.println(selection);
		  String xpath = String.format("//input[@type='checkbox']/"
		          + "..//..//..//..//li[contains(text(),'%s')]", selection);
		  WebElement checkbox = driver.findElement(By.xpath(xpath));
		  if (!checkbox.isSelected()) {
		    checkbox.click();
		  }
		  
		  }
		}
	
	
	public boolean verifyElementExistsWithXpath( String selection) {
        String xpathTemplate = "//input[@type='checkbox']/../../../../li[contains(text(),'%s')]";
        String xpath = String.format(xpathTemplate, selection);

        try 
        {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element != null;
        } catch (Exception e) {
        	return false;

		}
		
       
        }
    

	
	/**
	 * @return void
	 * @name : waitForPageLoad
	 * @description waiting for until page is loaded
	 */
	public void waitForPageLoad() {

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(pageLoadCondition);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			pause();
			System.out.println();
		} catch (Exception e) {

		}
	}

	/**
	 * click on element with java script
	 * 
	 * @return void
	 * @name : pause
	 * @description providing time delay explicitly
	 */
	public void clickElementWithJavaScript(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException e) {
			// Handle any exceptions or log errors
			e.printStackTrace();

			throw new ElementNotFoundException("Submit button not found!");
		}
	}

	/**
	 * @return void
	 * @name : pause
	 * @description providing time delay explicitly
	 */
	protected void pause() {

		try {
			// (getProperties().getProperty("execution_env")
			Thread.sleep(Long.parseLong(configReader.getProperty("pause")));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			raiseException();
		}
	}

	/**
	 * @return boolean
	 * @name : checkIfAtLeastOneElementAvailable
	 * @description location available
	 */

	public boolean checkIfAtLeastOneElementAvailable(String locatorType, String locatorValue) {
		List<WebElement> elements;
		By byLocator;
		if (locatorType.equalsIgnoreCase("xpath")) {
			byLocator = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("id")) {
			byLocator = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			byLocator = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("cssSelector")) {
			byLocator = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("LinkText")) {
			byLocator = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("PartialLinkText")) {
			byLocator = By.partialLinkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("className")) {
			byLocator = By.className(locatorValue);
		} else {
			byLocator = By.tagName(locatorValue);
		}
		elements = driver.findElements(byLocator);
		return !elements.isEmpty();
	}

	public static String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void checkIfElementIsClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*
	 * public static void waitsForElementLocated(Duration timeToWaitInSeconds, By
	 * by) {
	 * 
	 * wait= new WebDriverWait(driver, timeToWaitInSeconds);
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated((By) by)); } . }
	 */

	/**
	 * @return boolean
	 * @name : pauseretryingFindClick
	 * @description Element reverify and click
	 */
	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebElement element = driver.findElement(by);
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
				// Element is stale; retry
			}
			attempts++;
		}
		return result;
	}

	/**
	 * @return void
	 * @name : waitForElementToBeVisiblewithFluentWait
	 * @description FluentWait wait till element is visible
	 */
	public void waitForElementToBeVisiblewithFluentWait(WebElement element, int timeoutInSeconds) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> waitForElement = webDriver -> {
			if (element.isDisplayed()) {
				return element;
			} else {
				throw new NoSuchElementException("Element is not clickable.");
			}
		};

		wait.until(waitForElement);
	}

	/**
	 * @return void
	 * @name : waitForElementToBeClickablewithFluentWait
	 * @description FluentWait wait till element is cliCkable position
	 */
	public void waitForElementToBeClickablewithFluentWait(WebElement element, int timeoutInSeconds) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> waitForElement = webDriver -> {
			if (element.isEnabled() && element.isDisplayed()) {
				return element;
			} else {
				throw new NoSuchElementException("Element is not clickable.");
			}
		};

		wait.until(waitForElement);
	}

	/**
	 * @return void
	 * @name : selectAndSearchDropdown
	 * @description select and search business function
	 */
	public void selectAndSearchDropdown(WebElement dropdownElement, By searchvalue, String valueToSelect) {
		// Click the dropdown
		dropdownElement.click();

		// Enter the text in the search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@role='searchbox' and @type='text']"));
		searchBox.sendKeys(valueToSelect);

		// Wait for a while
		try {
			Thread.sleep(2000); // Wait for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Click on the value in the dropdown
		List<WebElement> options = driver.findElements(searchvalue);
		for (WebElement option : options) {
			if (option.getText().equals(valueToSelect)) {
				option.click();
				break;
			}
		}
	}

	public static boolean isEditBoxNotEditable(WebElement editBoxLocator) {
		try {
			// Find the edit box element
			WebElement editBox = editBoxLocator;

			// Check if the element is read-only using either attribute or enabled state
			if (editBox.getAttribute("readonly") != null || !editBox.isEnabled()) {
				System.out.println("Edit box is not editable (read-only).");
				return true; // Indicate edit box is read-only
			} else {
				return false; // Indicate edit box is editable
			}

		} catch (NoSuchElementException e) {
			System.out.println("Error: Edit box not found with locator: " + editBoxLocator);
			return false; // Indicate element not found
		}
	}

	public static WebElement waitForElementToBeClicks(WebElement locator, int timeout) {
		WebElement element = locator;

		for (int i = 0; i < timeout; i++) {
			try {
				// element = locator;
				if ((element.isDisplayed() == true && element.isEnabled() == true)) {

					break;
				}
			} catch (NoSuchElementException e) {

			}
			try {
				Thread.sleep(1000); // Hard sleep time as needed
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (element == null) {
			throw new NoSuchElementException("Element not found after waiting for " + timeout + " seconds.");
		}
		return element;
	}

	// vinay code--

	private ArrayList<String> stringValues;

	public void addvalue(List<String> valuesToAdd) {
		stringValues = new ArrayList<>();

		// stringValues.add(valuesToAdd);
		stringValues.addAll(valuesToAdd);

	}

	public boolean compareValues(ArrayList<String> values) {
		/*
		 * if(stringValues.size()!= values.size()) { return false; }
		 */

		for (int i = 0; i < stringValues.size(); i++) {
			if (!stringValues.get(i).equals(values.get(i))) {
				return false;
			}
		}

		return true;

	}

	public void clearvalues() {
		stringValues.clear();
	}

	public void waitForElementclickable(Duration timeToWaitInSeconds, WebElement element) {
		wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementLocated(Duration timeToWaitInSeconds, WebElement elementLocated) {
		wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementLocated));
	}

	public void waitForpresenseofElementLocated(Duration timeToWaitInSeconds, WebElement elementLocated) {
		try {

			wait = new WebDriverWait(driver, timeToWaitInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated((By) elementLocated));

			elementLocated.isDisplayed();

			// return elementLocated.isDisplayed();
		} catch (NoSuchElementException e) {
			LOGGER.log(Level.SEVERE, "Element not found after waiting for " + timeToWaitInSeconds + " seconds.", e);

		}
	}

	



	public void getvalues() {
		for (int i = 0; i < stringValues.size(); i++) {
			// System.out.println(stringValues.size());
			String value = stringValues.get(i);
			System.out.println(value);
		}

	

	}

	public boolean isPresent(WebElement element) {

		// registerCall(new Object() {
		// }.getClass().getEnclosingMethod().getName());
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {

			return true;
		} catch (Exception e) {

			LOGGER.log(Level.SEVERE, "Element not found using locator: ", e);
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(PAGE_IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			LOGGER.log(Level.SEVERE, "Element not found using locator: " + by.toString(), e);
			return false;
		}
	}

	public class ElementNotFoundException extends RuntimeException {
		public ElementNotFoundException(String message) {
			super(message);
		}
	}

	

	
	public void slowkeyenterValue(WebElement element, String text, long delay) throws InterruptedException
	{
		
	slowSendKeys(element,text,delay);
	Actions actions = new Actions(driver);
	Thread.sleep(10000);
	actions.sendKeys(Keys.TAB).build().perform();
	actions.sendKeys(Keys.TAB).build().perform();
	actions.sendKeys(Keys.TAB).build().perform();
    actions.sendKeys(Keys.ENTER).build().perform(); 
	}

	
	public void verifyRequiredFieldErrorCount(int expectedCount) {
	    
		List<WebElement> errorElements1=driver.findElements(By.xpath("//p[contains(., 'This field is required.')]"));
		int actualCount = errorElements1.size();

	    if (actualCount == expectedCount) {
	        System.out.println("Found the expected number of error messages: " + expectedCount);
	    } else {
	        System.out.println("Unexpected number of error messages found. Expected: " + expectedCount + ", Actual: " + actualCount);
	        Assert.fail("Verification failed: Incorrect number of error messages.");
	    }
	}
	
	public void btnSavebutton(WebElement element,WebElement element1) {
        try {
            Thread.sleep(1000);
            waitForElementclickable(Duration.ofSeconds(60), element);
            waitForElementToBeClickablewithFluentWait(element,50);
            
            clickElementWithJavaScript(element);
            
            waitForElementToBeClickablewithFluentWait(element1,50);
            clickElementWithJavaScript(element1);
        } catch (Exception e) {
        }
    }
	
	
	
	public void uploadFileUsingSendKeys(WebElement elementLocator, String filePath) throws InterruptedException {
         Thread.sleep(1000);
         elementLocator.sendKeys(filePath);
	   // if (elementLocator.isDisplayed() && elementLocator.isEnabled()) {
	       
	   // } else {
	    //    throw new RuntimeException("File upload element is not visible or enabled!");
	    //}
	}
	
	

    public void getTextele(WebElement ele) {
    	try {
    	System.out.println(	ele.getText().trim());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void sendItemQuantity(WebElement ele,String s) {
    	
    	try {
    		Thread.sleep(200);
    		waitForElementToBeVisiblewithFluentWait(ele, 60);
    		
    	char[] ch=	s.toCharArray();
    	for(char c:ch) {
    	ele.sendKeys(String.valueOf(c));
    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    //pagination
    public Long getNumberOfRowsUsingJS( String tableSelector) throws NoSuchElementException {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  Long rowsCount = (Long) js.executeScript("return document.querySelector('" + tableSelector + " tr').length");
    	  if (rowsCount == null || rowsCount == 0L) {
    	    throw new NoSuchElementException("Table not found using selector: " + tableSelector);
    	  }
    	  return rowsCount;
    	}

    
    public int getNumberOfRowsUsingJS(WebElement table) {
    	String tableSelector = "#table";
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  int rowsCount = (int) js.executeScript("return document.querySelector('"+tableSelector+" tr').length");
    	  return rowsCount;
    	}
    
    public void selectElement(List<WebElement> ele,String ss) {
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   for(int i=0;i<ele.size();i++) {
	   ele.get(i).click() ;
		   //break;
	   
   }
}
    
    public int getTableRowCount(WebElement table) {
	    List<WebElement> rows = table.findElements(By.xpath(".//tr"));
	    for(int i=0;i<rows.size();i++) {
	    	if(i==0) {
	    		continue;
	    	}
	    	System.out.println(i);
	    }
		return rows.size();
	    	
	}
    
    public int getRowCount(List<WebElement> ele) {
    	
    	for(int i=0;i<ele.size()-1;i++)
    	{System.out.println("Rows of table is :" +i);}
    	return ele.size()-1;
		
    }
    
    public int getNumberOfRows(WebElement table) {
    	try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	  List<WebElement> rows = table.findElements(By.xpath(".//tr"));
    	
    	 
    	  
    	 return rows.size()-2;
    	}
    
    
    public int getNumberOfRowsoftable(WebElement table) {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    //	driver.manage().timeouts().getPageLoadTimeout();
    	     	int tablesize=table.findElements(By.tagName("tr")).size();
    	 
    	  
    	  return tablesize-2;
    	}
    public int  rowcountusinfcss() {
    	waitScreen(6500);
    int ssize=	driver.findElements(By.cssSelector("table tr")).size();
    //System.out.println("Number of records are "+(ssize-2));
    return ssize-2;
    }
    
    
    public void page_select_eachpage(List<WebElement> ele) {
    	List<WebElement> options=ele;
    	
    	
    }
    
    public void waitScreen(long mils) {
    	try {
			Thread.sleep(mils);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    //Item management
    public void clickOnWebElement_click(WebElement clickableElement) {

        try {
        	//waitForElementVisibilityFor(Duration.ofSeconds(500),clickableElement);
        	 waitForElementToBeClickablewithFluentWait(clickableElement,250);
        //	clickableElement.click();
        	 clickElementWithJavaScript(clickableElement);
        	
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void explicitWat_click(WebElement ele)  {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(220)) ;
    wait.until(ExpectedConditions.elementToBeClickable(ele));
    try {
    	Thread.sleep(300);
    } catch (InterruptedException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }
    ele.click();
    }
        
       
       
        public boolean clickableElement(WebElement ele) {
        	if(ele.isDisplayed()&&(ele.isEnabled())) {
        		return true;
        	}
        	return false;
        }
        
        public void checkorRedioClick(WebElement ele) {
        	try {
        		clickElementWithJavaScript1(ele);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	}
        
       public void explicit_Wait(WebElement ele,long sec) {
    	   try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
    	   wait.until(ExpectedConditions.elementToBeClickable(ele));
       }
        
        public void sendkeys_ele(WebElement ele, String str,long delay) {
        	waitScreen(2000);
        	explicit_Wait(ele, delay);
        	ele.click();
        	ele.clear();
        	ele.sendKeys(str);
        }
        public void sendkeys_ele_Date(WebElement ele, String str,long delay) {
        	waitScreen(2000);
        	explicit_Wait(ele, delay);
        	
        	ele.clear();
        	ele.sendKeys(str);
        }
        public void sendkeys_ele1(WebElement ele, String str,long delay) {
        	explicit_Wait(ele, delay);
        	ele.click();
        	ele.clear();
        	
        	ele.sendKeys(str);
        }
        
       
        
        
        
        public void clickElement_using_Size(String str,WebElement ele) {
        	explicit_Wait(ele, 200);
        	if(driver.findElements(By.xpath(str)).size()>0) {
        		clickElementWithJavaScript1(ele);
        		}
        }
       
        public void clickElementWithJavaScript1(WebElement element) {
            try {
            	waitScreen(3500);
            	waitForElementToBeClickablewithFluentWait(element, 250);
//                JavascriptExecutor executor = (JavascriptExecutor) driver;
//                executor.executeScript("arguments[0].click();", element);
            	
            	JavascriptExecutor js=(JavascriptExecutor)driver;
            	js.executeScript("arguments[0].click();", element);
            	
            } catch (Exception e) {
                // Handle any exceptions or log errors
                e.printStackTrace();
            }
            
        }
        
    
	  public void nextMonth_specific_Date() {
		  LocalDate today = LocalDate.now();
SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");

		    // Get a specific date in the next month (15th of next month)
		    LocalDate specificDate = today.plusMonths(1).withDayOfMonth(15);

		    // Print the date
		    System.out.println("Next month specific date "+specificDate);
	  }
	
	  public String randomString() {
			String alpha = "AbCDef123456cndjcu78jbkqs2d98@@&^H&%^)(^%$";
			Random ran = new Random();
			StringBuffer sb = new StringBuffer();
			int len = 3;
			for (int i = 0; i < len; i++) {
				int index = ran.nextInt(alpha.length());
				char rch = alpha.charAt(index);
				sb.append(rch);

			}
			return sb.toString();
		}	

	public void explicit_Ele_Forvisibility(WebElement ele)  {
	    WebDriverWait wait=new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(220)) ;
	wait.until(ExpectedConditions.visibilityOf(ele));
	try {
		Thread.sleep(300);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	


public void multi_Select(WebElement ele,String str,List<WebElement> eleclick,long delay) {
	
	String [] st=str.split(",");
//	System.out.println(st);
	
		explicit_Wait(ele, delay);
		waitScreen(1000);
    	ele.click();
    	for(int i=0;i<st.length;i++) {
    		System.out.println("datat is : "+st[i]);
		for(int j=0;j<eleclick.size();j++) {
			if(eleclick.get(j).getText().equalsIgnoreCase(st[i])) {
				eleclick.get(j).click();
				break;
			}
			
		}
	//	clickElementWithJavaScript1(ele);
		
    	}
	ele.click();
}

	
	/**
	 * @return void
	 * @name : slowSendKeys
	 * @description enter value by using send keys
	 */
	// simulate a slow typing effect
	public void slowSendKeys(WebElement element, String text, long delay) {
		for (char c : text.toCharArray()) {
			element.sendKeys(String.valueOf(c));
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
