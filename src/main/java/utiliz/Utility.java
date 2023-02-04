package utiliz;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * Utility class to select web elements.
 */
public class Utility {

    protected final WebDriver webDriver;
    protected final WebDriverWait webDriverWait;

    public Utility(WebDriver webDriver) {
        if (webDriver == null)
            throw new IllegalArgumentException();

        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
    }

    protected WebElement vibislityOfWebElement(By locater) {
       return  webDriverWait
           .until(ExpectedConditions.visibilityOfElementLocated(locater));
    }

    protected WebElement elementToBeClickable(By locater) {
        return webDriverWait.until(ExpectedConditions
                .elementToBeClickable(locater));
    }

    protected List<WebElement> visibilityOfAllElements(By locater) {
        return webDriverWait.until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(locater));
    }

    protected void moveToElementAndClick(WebElement webElement) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", 
                webElement);
    }
}
