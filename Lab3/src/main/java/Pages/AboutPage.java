package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage{

    public WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        driver.get("https://fastpic.ru/about");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("о сервисе");
            }
        });

        return driver.getTitle();
    }
}

