package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FiltersPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public FiltersPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    public void settingPrice(String maxAmount){
        Select select = new Select(driver.findElement(By.xpath("(//select[@class='hbnjE2'])[position()=2]")));
        select.selectByVisibleText(maxAmount);
        System.out.println("The Price is set to MAXIMUM 10000 ");
    }

    public void osVersion(String os) throws InterruptedException {
        WebElement osSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Operating System Version Name']")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", osSection);
        Thread.sleep(1000);

        WebElement dropDownArrow = driver.findElement(
                By.xpath("//div[text()='Operating System Version Name']/following-sibling::*[name()='svg']"));
        dropDownArrow.click();

        WebElement moreBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//span[contains(text(),'MORE')])[position()=2]")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", moreBtn);
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();", moreBtn);
        System.out.println("12 MORE clicked successfully");

        WebElement pieOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[.='Pie'])[3]")));
        Thread.sleep(1000);

//        WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@class='ybaCDx'])[position()=28]"))));
//        ele.click();
        js.executeScript("arguments[0].click();", pieOption);

        System.out.println(os+" selected successfully");
        Thread.sleep(1000);
    }

    public void newestFirst(){
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text()='Newest First']")));
        System.out.println("Newest First clicked successfully");
    }
}