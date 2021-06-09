package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage{

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getTitle() {
        driver.get("https://fastpic.ru/");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("fastpic");
            }
        });

        return driver.getTitle();
    }
}
