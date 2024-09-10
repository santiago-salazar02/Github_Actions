package swag.labs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import swag.labs.pages.BurgerMenuPage;
import swag.labs.pages.LoginPage;
import swag.labs.utils.baseTest.BaseTest;

public class LogoutTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LogoutTest.class);
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logout(){
        log.info("Starting logout test...");

        BurgerMenuPage burguerMenuPage = this.loadBurguerMenu();
        burguerMenuPage.clickBurgerMenu();
        burguerMenuPage.clickLogout();

        log.info("Verifying the current URL after logout...");
        softAssert.assertEquals(burguerMenuPage.getDriver().getCurrentUrl(), LoginPage.getExpectedUrl());
        softAssert.assertAll();

        log.info("Logout test completed.");
    }

}
