import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class UserInfoInput {
    @Test
    public void userInputFormTest(){
        // создаем новый экземпляр html unit driver
        // Обратите внимание, что последующий код не закладывается на
        // конкретную, имплементацию, а только на интерфейс WebDriver.
        WebDriver driver = new HtmlUnitDriver();
        // Открываем Google
        driver.get("http://localhost:8080/first");
        // Находим по имени поле для ввода
        WebElement formUserInfo = driver.findElement(By.name("info-form"));
        WebElement nameInput = driver.findElement(By.name("name"));
        WebElement emailInput = driver.findElement(By.name("email"));
        // Вводим ключевое слово для поиска
        nameInput.sendKeys("Vasya");
        emailInput.sendKeys("vasya@mail.ru");
        // Отправляем форму в которой находится элемент element.
        // WebDriver сам найдет, в какой он форме.
        formUserInfo.submit();
        // Выводим в консоль заголовок страницы
        Assert.assertEquals("Second Page", driver.getTitle());
        System.out.println("Page title is: " + driver.getTitle());
        nameInput = driver.findElement(By.id("output-name"));
        emailInput = driver.findElement(By.id("output-email"));
        Assert.assertEquals("Vasya", nameInput.getText());
        Assert.assertEquals("vasya@mail.ru", emailInput.getText());
        System.out.println("Name:" + nameInput.getText());
        System.out.println("Email::" + emailInput.getText());
    }
}
