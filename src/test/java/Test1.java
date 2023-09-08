import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.homedepot.com/");
        String correctTitle = "The Home Depot";
        String currentTitle = driver.getTitle();
        //System.out.println(driver.getTitle());
        Assert.assertEquals(correctTitle, currentTitle, "Title does not match the requirements");


    }
}
