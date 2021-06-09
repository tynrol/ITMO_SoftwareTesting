import Pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageTest {
    Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/rotate.csv", numLinesToSkip = 1)
    public void imageRotationTest(String link, String deg) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://fastpic.ru/my.php");
        assertTrue(utils.rotatateImage(webDriver, link, deg));
        webDriver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/reduce.csv", numLinesToSkip = 1)
    public void imageReduceTest(String link, String size){
        WebDriver webDriver = new ChromeDriver();
        assertTrue(utils.reduceImage(webDriver, link, size));
        webDriver.quit();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/links.csv", numLinesToSkip = 1)
    public void imageJPEGTest(String link){
        WebDriver webDriver = new ChromeDriver();
        assertTrue(utils.intoJPEG(webDriver, link));
        webDriver.quit();
    }

    @Test
    public void imagePosterTest(){
        WebDriver webDriver = new ChromeDriver();
        assertTrue(utils.intoPoster(webDriver,"https://cs11.pikabu.ru/post_img/big/2018/11/12/6/1542010753153392364.png"));
        webDriver.quit();
    }
}
