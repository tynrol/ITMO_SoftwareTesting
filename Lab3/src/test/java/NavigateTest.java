import Pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigateTest {
    Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    private void navigate(WebDriver webDriver){
        webDriver.get("https://fastpic.ru/");
        webDriver.manage().window().setSize(new Dimension(968, 824));
        webDriver.findElement(By.xpath("//*[@id=\"headermenu\"]/tbody/tr/td/div/a[1]/div/div[4]")).click();
        assertEquals("FastPic — Загрузить изображения", PageFactory.initElements(webDriver, MainPage.class)
                .getTitle());
        webDriver.findElement(By.xpath("//table[@id=\'headermenu\']/tbody/tr/td/div/a[2]/div/div[4]")).click();
        assertEquals("Правила — FastPic", PageFactory.initElements(webDriver, RulesPage.class)
                .getTitle());
        webDriver.findElement(By.xpath("//table[@id=\'headermenu\']/tbody/tr/td/div/a[3]/div/div[4]")).click();
        assertEquals("О сервисе — FastPic", PageFactory.initElements(webDriver, AboutPage.class)
                .getTitle());
        webDriver.findElement(By.xpath("//table[@id=\'headermenu\']/tbody/tr/td/div/a[4]/div/div[4]")).click();
        assertEquals("FP Uploader программа загрузки изображений — FastPic", PageFactory.initElements(webDriver, UploadPage.class)
                .getTitle());
        webDriver.findElement(By.xpath("//table[@id=\'headermenu\']/tbody/tr/td/div/a[5]/div/div[4]")).click();
        assertEquals("Мои загрузки — FastPic", PageFactory.initElements(webDriver, DownloadPage.class)
                .getTitle());
        webDriver.quit();
    }
    @Test
    public void navigateTest(){
        navigate(new ChromeDriver());
        //navigate(new FirefoxDriver());
    }
}
