package testRunner;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;  // Assuming you're using TestNG

public class TestRunner1 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	/*
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("force-device-scale-factor=1");
        options.addArguments("high-dpi-support=1");
        options.addArguments("--no-sandbox");
        options.addArguments("--hide-scrollbars");
        // gl stands for "Graphics library"
        // swiftshader is a library for software rendering
        // I believe in alpine chrome it turned on by default
        // options.addArguments("--use-gl=swiftshader");
        // related options:
        //  --ignore-gpu-blacklist
        //  --disable-software-rasterizer
        //  --disable-dev-shm-usage
        //  --disable-gpu
        
        options.setBinary("Driver/chrome-headless-shell");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.getTitle();
        System.out.println("driver started");
    }

    @Test
    public void testSomething() {
        System.out.println("Test method");
    }
}