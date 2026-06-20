package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {


    private WebDriver driver;
    private WebDriverWait wait ;

    public HomePage(WebDriver driver){
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void closePopUp() throws InterruptedException {

        WebElement closePop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='b3wTlE']")));
        Thread.sleep(1000);
        closePop.click();

    }

    public void mobileSearch(String keyword,String target) throws InterruptedException {

//      enter test in search box
        WebElement input = driver.findElement(By.xpath("//input[@class='nw1UBF v1zwn25']"));
        Thread.sleep(1000);
        input.sendKeys(keyword);


        //      auto suggestion clicking mobiles under 15000
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[1]/li")));
        Thread.sleep(1000);
        for (WebElement l : list) {
            if (l.getText().equalsIgnoreCase(target)) {
                System.out.println("Element Mobiles Under 15000 is Selected");
                l.click();
                break;
            }
        }
    }





}
