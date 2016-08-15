import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestUserInfoInput {
    @Test
    public void testUserInputForm(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/first");
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys("Vasya");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("vasya@mail.ru");
        WebElement formUserInfo = driver.findElement(By.name("info-form"));
        formUserInfo.submit();
        Assert.assertEquals("Second Page", driver.getTitle());
        emailInput = driver.findElement(By.id("output-email"));
        nameInput = driver.findElement(By.id("output-name"));
        Assert.assertEquals("Entered Email: vasya@mail.ru", emailInput.getText());
        Assert.assertEquals("Entered name: Vasya", nameInput.getText());
    }
}
