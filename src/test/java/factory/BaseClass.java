package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<Properties> properties = new ThreadLocal<>();
	static Logger logger;
	
	//static

	public static WebDriver initilizeBrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} 
			else if (getProperties().getProperty("os").equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching OS..");
			}
			
			
			// browsers
			switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

			        // Set Chrome options
			        ChromeOptions options = new ChromeOptions();
			        options.addArguments("--headless");
			        options.addArguments("--disable-gpu");
			        options.addArguments("--no-sandbox");
			        options.addArguments("--disable-dev-shm-usage");
			        

			        String windowSize = System.getProperty("window.size", "1920x1080");
			        options.addArguments("--window-size=" + windowSize);
			        
			       // options.addArguments("--window-size=1920,1080");

			        // Initialize WebDriver
			        driver.set(new ChromeDriver(options));
					break;
				case "edge":
					driver.set(new EdgeDriver());
					break;
				case "firefox":
					driver.set(new FirefoxDriver());
					break;
				default:
					System.out.println("No matching browser");
					driver = null;
			}
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
				     ChromeOptions options = new ChromeOptions();
				   
					    
					   driver.set(new ChromeDriver());
					    
					break;
				case "edge":
					driver.set(new EdgeDriver());
					break;
				case "firefox":
					driver.set(new FirefoxDriver());
					break;
				default:
					System.out.println("No matching browser");
					driver = null;
			}
		}
		driver.get().manage().deleteAllCookies();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.get().manage().window().maximize();

		return driver.get();

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

	public static synchronized Properties getProperties() throws IOException {
		if (properties.get() == null) {
			FileReader file = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties");
			Properties p = new Properties();
			p.load(file);
			properties.set(p);
		}
		return properties.get();
	}

	public static Logger getLogger() {
		logger = LogManager.getLogger(); // Log4j
		return logger;
	}

	public static String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}

}