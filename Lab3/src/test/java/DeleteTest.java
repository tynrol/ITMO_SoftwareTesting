import Pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteTest {
    Utils utils;
    int firstLength, secondLength;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    private void delete(WebDriver webDriver){
        webDriver.get("https://fastpic.ru/my.php");
        webDriver.manage().window().setSize(new Dimension(968, 824));
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        //если в корзине ничего нет, добавим картинок
        if (firstLength == 0) {

            utils.addImageByLink(webDriver, "https://cs11.pikabu.ru/post_img/big/2018/11/12/6/1542010753153392364.png");
            utils.addImageByLink(webDriver, "https://d1nslcd7m2225b.cloudfront.net/Pictures/1024x536/1/9/6/1344196_829pxryan_gosling_35397111013_cropped_764382.jpg");
            utils.addImageByLink(webDriver, "https://delartemagazine.com/wp-content/uploads/2021/02/0-1-e1614273018620.jpg");
        }
        webDriver.get("https://fastpic.ru/my.php");
        secondLength= webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        System.out.println(secondLength);
        //удалить 1 картинку
        webDriver.findElement(By.xpath("//form[@id='manage-form']/div[2]/div/label/input")).click();
        webDriver.findElement(By.id("delete_checked")).click();
        assertEquals(secondLength - 1, webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size());
        //удалить все
        if (webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size() == 0) {
            utils.addImageByLink(webDriver, "https://cs11.pikabu.ru/post_img/big/2018/11/12/6/1542010753153392364.png");
            utils.addImageByLink(webDriver, "https://d1nslcd7m2225b.cloudfront.net/Pictures/1024x536/1/9/6/1344196_829pxryan_gosling_35397111013_cropped_764382.jpg");
            utils.addImageByLink(webDriver, "https://delartemagazine.com/wp-content/uploads/2021/02/0-1-e1614273018620.jpg");
        }
        webDriver.get("https://fastpic.ru/my.php");
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ выбрать всё ]\')]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),\'[ удалить выбранное ]\')]")).click();
        assertEquals(0, webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size());
        webDriver.quit();
    }

    @Test
    public void deleteTest(){
        delete(new ChromeDriver());
        //delete(new FirefoxDriver());
    }
}
