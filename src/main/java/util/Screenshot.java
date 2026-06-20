package util;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Screenshot {
    // Screenshot folder path
    public static String filePath =System.getProperty("user.dir") + "//Screenshot//";
    // Capture Screenshot Method
    public static void takeScreenShot(WebDriver driver,String fileName) throws IOException {
        // Create timestamp
        String timeStamp =new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        // Take Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        // Destination file
        File destFile =new File(filePath + fileName + "_"+ timeStamp + ".png");
        // Copy screenshot
        FileHandler.copy(srcFile, destFile);
    }
}