import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
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
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"You're shopping\")]")));
        driver.findElement(By.xpath("//*[contains(text(), \"You're shopping\")]")).click();
        driver.findElement(By.xpath("//*[contains(text(), \"Find Other Stores\")]")).click();
        String parentWindow = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> T1 = s.iterator();

        while (T1.hasNext()){

            String childWindow=T1.next();

            if (parentWindow.equals(childWindow)){
                driver.switchTo().window(childWindow);

                System.out.println(driver.switchTo().window(childWindow).getTitle());
            }
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)","");
        driver.switchTo().window(parentWindow);


    }
}
