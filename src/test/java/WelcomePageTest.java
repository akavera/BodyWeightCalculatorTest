import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WelcomePageTest {

    private static final String PATH = "file:///Users/icy/IdeaProjects/BodyWeightCalculatorTest/src/main/resources/index.html";
    WebDriver driver;

    @BeforeMethod
    public void chrome(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver= new ChromeDriver();
    }

    @Test
    public void welcomeTest(){
        driver.get(PATH);
        boolean isWelcomeMessageShown = driver.findElement(By.name("h1")).isDisplayed();
        Assert.assertTrue(isWelcomeMessageShown,"No message");
    }

    @Test
    public void artistsTest(){
        driver.get(PATH);
        boolean artists = driver.findElement(By.id("artists")).isDisplayed();
        Assert.assertTrue(artists,"No artists");
    }

    @Test
    public void buttonTest(){
        driver.get(PATH);
        boolean button = driver.findElement(By.id("button")).isDisplayed();
        Assert.assertTrue(button,"No button");
    }

    @Test
    public void nameTest(){
        driver.get(PATH);
        String name = driver.findElement(By.id("h2")).getText();
        Assert.assertEquals(name,"I'm Vera","Name isn't correct");
    }

    @Test
    public void urlTest(){
        driver.get(PATH);
        String name = driver.findElement(By.id("url")).getAttribute("href");
        Assert.assertEquals(name,"https://arzamas.academy/","Url isn't correct");
    }
    @Test
    public void pictureMessageTest(){
        driver.get(PATH);
        String picture = driver.findElement(By.id("png")).getAttribute("alt");
        Assert.assertEquals(picture,"Ooopsie","There is no message");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
