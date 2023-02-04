package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utiliz.Utility;
/*
 * Class presenting header web elements.
 */
public class HeaderWebElem extends Utility{

    private static final By HEADER_SELECTOR = By.tagName("header");
    private static final By CONTACT_US_SELECTOR = By.linkText("Contact us");

    final WebElement headerWebElem;

    public HeaderWebElem(WebDriver webDriver) {
        super(webDriver);

        this.headerWebElem = vibislityOfWebElement(HEADER_SELECTOR);
    }

    public ContactUsWebElem clickOnContactUs() {
        headerWebElem.findElement(CONTACT_US_SELECTOR).click();
        return new ContactUsWebElem(webDriver);
    }

}
