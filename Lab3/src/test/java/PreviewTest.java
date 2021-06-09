import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreviewTest {
    Utils utils;
    int firstLength, secondLength;

    private void preview1(WebDriver webDriver) {
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        webDriver.get("https://fastpic.ru/");
        webDriver.manage().window().setSize(new Dimension(1536, 824));
        //Надпись без размера
        utils.addImageWithPreview1(webDriver,"https://delartemagazine.com/wp-content/uploads/2021/02/0-1-e1614273018620.jpg", "Gosling");
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        assertTrue(secondLength == firstLength + 1);

        webDriver.get("https://fastpic.ru/");
        //Размер без надписи
        utils.addImageWithPreview1(webDriver,"https://delartemagazine.com/wp-content/uploads/2021/02/0-1-e1614273018620.jpg", "100");
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        assertTrue(secondLength == firstLength + 2);

        webDriver.quit();
    }

    private void preview2(WebDriver webDriver){
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        webDriver.get("https://fastpic.ru/");
        webDriver.manage().window().setSize(new Dimension(1536, 824));
        //Размер + надпись
        utils.addImageWithPreview2(webDriver, "https://d1nslcd7m2225b.cloudfront.net/Pictures/1024x536/1/9/6/1344196_829pxryan_gosling_35397111013_cropped_764382.jpg", "Another Gosling", "150");
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        assertTrue(secondLength == firstLength + 1);

        webDriver.get("https://fastpic.ru/");
        //Размер + надпись размера
        utils.addImageWithPreview2(webDriver,"https://cs11.pikabu.ru/post_img/big/2018/11/12/6/1542010753153392364.png", "", "50");
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        assertTrue(secondLength == firstLength + 2);

        webDriver.quit();
    }

    private void previewEmpty(WebDriver webDriver){
        //Без надписи и размера
        webDriver.get("https://fastpic.ru/my.php");
        firstLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        webDriver.get("https://fastpic.ru/");
        webDriver.manage().window().setSize(new Dimension(1536, 824));
        utils.addImageWithPreviewEmpty(webDriver,"https://cs11.pikabu.ru/post_img/big/2018/11/12/6/1542010753153392364.png");
        webDriver.get("https://fastpic.ru/my.php");
        secondLength = webDriver.findElements(By.xpath("//*[@id=\"manage-form\"]/div")).size();
        assertTrue(secondLength == firstLength + 1);
        webDriver.quit();
    }


    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @Test
    public void preview1Test(){
        preview1(new ChromeDriver());
        //preview1(new FirefoxDriver());
    }

    @Test
    public void preview2Test(){
        preview2(new ChromeDriver());
        //preview2(new FirefoxDriver());
    }

    @Test
    public void previewEmptyTest(){
        previewEmpty(new ChromeDriver());
        //previewEmpty(new FirefoxDriver());
    }
}
