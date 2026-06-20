package tests;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FiltersPage;
import pages.HomePage;
import pages.SearchResultsPage;
import util.ConfigReader;
import util.DriverSetup;
import util.ExcelUtils;
import util.Screenshot;

public class EcommerceTest extends DriverSetup{

//    private WebDriver driver;

//    @BeforeMethod
//    public void setupSuite() {
//        driver = DriverSetup.getDriver();
//        driver.get(ConfigReader.getUrl());
//    }

    @DataProvider(name = "ExcelDataProvider")
    public Object[][] getData() {
        // FIXED: Capitalized 'S' to strictly match the Excel sheet tab name
        return ExcelUtils.getSheetDataMatrix("Sheet1");
    }

    @Test(dataProvider = "ExcelDataProvider")
    public void executeStoreValidation(String keyword, String target, String maxPrice, String os, String priceThreshold) {

        try {
            HomePage homePage = new HomePage(driver);
            homePage.closePopUp();
            homePage.mobileSearch(keyword, target);

            FiltersPage filtersPage = new FiltersPage(driver);
            filtersPage.settingPrice(maxPrice);
            filtersPage.osVersion(os);
            filtersPage.newestFirst();

            SearchResultsPage searchPage = new SearchResultsPage(driver);
            searchPage.mobileDetails();

            String str = searchPage.firstMobilePrice();//"10000"
            int p = Integer.parseInt(str);
            int p2 = Integer.parseInt(priceThreshold);//"30000"

            // Screenshot captured right before assertion validation
            Screenshot.takeScreenShot(driver, "Flipkart_Final_Results");
            System.out.println("Log: Final results page screenshot captured successfully.");

            // Core checkpoint validation
            Assert.assertTrue(p < p2);
            System.out.println("The price of first Mobile is Less than 30000");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                Screenshot.takeScreenShot(driver, "Test_Failure_Exception");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

//    @AfterMethod
//    public void closeBrowser(){
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}