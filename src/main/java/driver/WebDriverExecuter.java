package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Class presenting web driver executer.
 */
public class WebDriverExecuter {

    final WebDriver webDriver;

    public WebDriverExecuter() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void openHomePageUrl() {
        webDriver.get("https://www.innocv.com/");
    }

    public void closeDriver() {
        webDriver.close();
    }

    public void forwardBack() {
        webDriver.navigate().back();
    }
}
