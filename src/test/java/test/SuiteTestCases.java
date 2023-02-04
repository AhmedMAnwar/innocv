package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.WebDriverExecuter;
import webelement.ContactUsWebElem;
import webelement.FooterWebElem;
import webelement.HeaderWebElem;

/*
 * Class presenting the suite test cases.
 */
public class SuiteTestCases {

    WebDriverExecuter webDriverExecuter;

    @BeforeMethod
    public void setupConfiguration() throws InterruptedException {
        webDriverExecuter = new WebDriverExecuter();
        webDriverExecuter.openHomePageUrl();
    }

    @Test(priority = 1, description = "Verify same phone number in contact us" 
                                    + " and terms&condition page")
    public void isPhoneNumberSame() {
         String phoneNumber = new HeaderWebElem(webDriverExecuter.getWebDriver())
                .clickOnContactUs().acceptCookie().getPhoneNumber().substring(6);

         String TermsAndConditionContent
             = new FooterWebElem(webDriverExecuter.getWebDriver())
            .clickOnTermsAndCondition().getPageContent();

        assertTrue(TermsAndConditionContent.contains(phoneNumber));
    }

    @Test(priority = 2, description = "Verify how many times Faraday shows")
    public void isTextShowingMultipleTimes() {
        int count = new HeaderWebElem(webDriverExecuter.getWebDriver())
                .clickOnContactUs().acceptCookie().countTextShowing("Faraday");
        assertEquals(count, 2);
    }

    @Test(priority = 3, description = "Verify form error message warning")
    public void isWarningMessageshow() {
        ContactUsWebElem contactUsWebElem
            = new HeaderWebElem(webDriverExecuter.getWebDriver())
        .clickOnContactUs().acceptCookie().clickOnSendFormButton();
        assertTrue(contactUsWebElem.isWarningMessageDisplayed());
    }

    @Test(priority = 4, description = "Verify month with current and two before")
    public void isMonthsRetrieved() throws ParseException {
        List<Date> DateList
            = new HeaderWebElem(webDriverExecuter.getWebDriver())
        .clickOnContactUs().acceptCookie().getDatesList();
        for (Date date : DateList) {
            LocalDate localDate
                = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            assertTrue((localDate.getMonthValue() == 1 
                        || localDate.getMonthValue() == 12
                        || localDate.getMonthValue() == 11));
        }
    }

    @AfterMethod
    public void closeWindow() {
        webDriverExecuter.closeDriver();

    }
}
