import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatingTest {
    WebDriver driver;

    @BeforeMethod
    public void chrome(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver= new ChromeDriver();
    }

    @Test
    public void starvationTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("40");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.name("cc")).click();
        //boolean isStarvationMessageShown=driver.findElement(By.className("content")).getAttribute("value");
        //Assert.assertTrue(isStarvationMessageShown,"Result isn't shown");
    }

    @Test
    public void underweightTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("45");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();
        boolean isUnderweightMessageShown=driver.findElement(By.className("content")).isDisplayed();
        Assert.assertTrue(isUnderweightMessageShown,"Result isn't shown");
    }

    @Test
    public void normalWeightTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("60");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();
        boolean isNormalWeightMessageShown=driver.findElement(By.className("content")).isDisplayed();
        Assert.assertTrue(isNormalWeightMessageShown,"Result isn't shown");
    }

    @Test
    public void overweightTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("85");
        driver.findElement(By.name("ht")).sendKeys("175");
        driver.findElement(By.name("cc")).click();
        boolean isOverweightMessageShown=driver.findElement(By.className("content")).isDisplayed();
        Assert.assertTrue(isOverweightMessageShown,"Result isn't shown");
    }

    @Test
    public void obeseTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("90");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.name("cc")).click();
        boolean isObeseMessageShown=driver.findElement(By.className("content")).isDisplayed();
        Assert.assertTrue(isObeseMessageShown,"Result isn't shown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();//закрыть браузер
    }
}
