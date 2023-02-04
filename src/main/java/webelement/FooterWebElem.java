package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utiliz.Utility;

/*
 * Class presenting footer web elements.
 */
public class FooterWebElem extends Utility {

    private static final By Terms_Condition_SELECTOR
        = By.xpath("//a[@href='aviso-legal']");

    public FooterWebElem(WebDriver webDriver) {
        super(webDriver);
    }

    public TermConditionWebElem clickOnTermsAndCondition() {
        WebElement webElement = elementToBeClickable(Terms_Condition_SELECTOR);
        moveToElementAndClick(webElement);
        return new TermConditionWebElem(webDriver);
    }

}
