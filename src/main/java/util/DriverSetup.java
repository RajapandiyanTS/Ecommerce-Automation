package util;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DriverSetup {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public static void getDriver(String browser) {
        if (driver == null) {
//            String browser = ConfigReader.getBrowser();

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(ConfigReader.getUrl());
        }
//        return driver;
    }

    @AfterMethod
    public static void quitDriver() {
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
