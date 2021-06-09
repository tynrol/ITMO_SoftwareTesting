import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectTest {
    Utils utils;

    public void link(WebDriver webDriver) {
        assertTrue(utils.addImageByLink(webDriver, "https://cs11.pikabu.ru/post_img/big/2018/11/12/6/1542010753153392364.png"));
        //wrong link
        assertFalse(utils.addImageByLink(webDriver, "https://sun9-33.userapi.com/impg/c857236/v857236717/1f9080/j69jPafpfA4.jpg?size=1350x2048&quality=96&sign=16396867ca1fea72e21e1b9c053ea815"));
        webDriver.quit();
    }

    public void upload(WebDriver webDriver){
        assertTrue(utils.addImageByUpload(webDriver, "C:\\Code\\JavaTesting\\Lab3\\src\\test\\resources\\1.jpg"));
        webDriver.quit();
    }

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @Test
    public void linkTest(){
        link(new ChromeDriver());
        //link(new FirefoxDriver());
    }

    @Test
    public void uploadTest(){
        upload(new ChromeDriver());
        //upload(new FirefoxDriver());
    }
}
