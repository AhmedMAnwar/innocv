package webelement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utiliz.Utility;

/*
 * Class presenting contact us web element.
 */
public class ContactUsWebElem extends Utility {

    private static final By PHONE_NUMBER_SELECTOR = By
        .xpath("//span[contains(text(),'Teléfono')]/following-sibling::span[1]");
    private static final By ACCEPT_COOKIE_SELECTOR = By.id("rcc-confirm-button");
    private static final By SEND_BUTTON_SELECTOR
        = By.xpath("//button[contains(.,'Enviar formulario')]");
    private static final By ERROR_MESSAGE_SELECTOR
        = By.xpath("//p[contains(.,'Campo requerido')]");
    private static final By DATE_SELECTOR
        = By.xpath("//p[contains(text(),'nuevo')]/following-sibling::p");
    
    public ContactUsWebElem(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPhoneNumber() {
        return vibislityOfWebElement(PHONE_NUMBER_SELECTOR).getText();
    }

    public ContactUsWebElem acceptCookie() {
        elementToBeClickable(ACCEPT_COOKIE_SELECTOR).click();
        return this;
    }

    public int countTextShowing(String text) {
        vibislityOfWebElement(By.xpath("//div[@class='visit']"));
        List<WebElement> textWebElements = visibilityOfAllElements
            (By.xpath("//p[text()[contains(.,'"+text+"')]]"));
        int count = 0;
        for (WebElement webElement : textWebElements) {
            if(webElement.getAttribute("innerHTML").contains(text))
                count++;
        }
        return count;
    }

    public ContactUsWebElem clickOnSendFormButton() {
        WebElement webElement = elementToBeClickable(SEND_BUTTON_SELECTOR);
        moveToElementAndClick(webElement);
        return this;
    }

    public boolean isWarningMessageDisplayed() {
        return vibislityOfWebElement(ERROR_MESSAGE_SELECTOR).isDisplayed();
    }

    public List<Date> getDatesList() throws ParseException {
        List<WebElement> DateWebElements = visibilityOfAllElements(DATE_SELECTOR);
        List<Date> DatesList = new ArrayList<Date>();
        for (WebElement webElement : DateWebElements) {
            Date date
                = new SimpleDateFormat("dd-MM-yyyy").parse(webElement.getText());
            DatesList.add(date);
        }
        return DatesList;
    }
}
