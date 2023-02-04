package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utiliz.Utility;
/*
 * Class presenting terms and condition web elements.
 */
public class TermConditionWebElem extends Utility{

    private static final By PAGE_CONTENT_SELECTOR
        = By.xpath("//div[contains(@class, 'jss14')]");


    public TermConditionWebElem(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageContent() {
        return vibislityOfWebElement(PAGE_CONTENT_SELECTOR)
            .getAttribute("innerHTML");
    }
}
