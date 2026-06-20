package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver; // Cleaned double semi-colon
    }

    String price="";
    public void mobileDetails() throws InterruptedException {
        List<WebElement> mobileName = driver.findElements(By.xpath("//div[@class='RG5Slk']"));
        List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));

        for (int i = 0; i < 5; i++) {
            System.out.println("The mobile name is " + mobileName.get(i).getText() + " and the Price is " + mobilePrice.get(i).getText());
        }
        price = mobilePrice.get(0).getText();//"$10,000"
        Thread.sleep(1000);
    }

    public String firstMobilePrice() throws InterruptedException {
        String price2 = "";//"10000"
        for (int j = 0; j < price.length(); j++) {
            char c = price.charAt(j);
            if (Character.isDigit(c)) {
                price2 += c;
            }
        }
        System.out.println("The first mobile price is : "+price2);
        Thread.sleep(1000);
        return price2;
    }
}