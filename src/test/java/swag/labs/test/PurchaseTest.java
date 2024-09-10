package swag.labs.test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import swag.labs.pages.*;
import swag.labs.pages.checkout.CheckoutFinishPage;
import swag.labs.pages.checkout.CheckoutOverviewPage;
import swag.labs.pages.checkout.CheckoutPersonalInfoPage;
import swag.labs.utils.baseTest.BaseTest;
import java.util.logging.Logger;

public class PurchaseTest extends BaseTest {

    private static final Logger log = Logger.getLogger(PurchaseTest.class.getName());

    @Test
    @Parameters({"checkoutFirstName",
            "checkoutLastName",
            "checkoutPostalCode"})
    public void purchaseProduct(@Optional("1") String checkoutFirstName,
                                @Optional("1") String checkoutLastName,
                                @Optional("1") String checkoutPostalCode){
        log.info("Starting purchaseProduct test...");

        int cartElements = 1;

        SoftAssert softAssert = new SoftAssert();

        log.info("Adding inventory elements to the cart...");
        InventoryPage inventoryPage = loadInventory();
        inventoryPage.addRandomInventoryElements(cartElements);
        softAssert.assertEquals(inventoryPage.getInventoryRemoveItemButtonSize(),cartElements);

        log.info("Clicking on the shopping cart...");
        CartPage cartPage = inventoryPage.clickShoppingCart();
        softAssert.assertEquals(cartPage.getRemoveItemButtonsSize(),cartElements);

        log.info("Proceeding to checkout...");
        CheckoutPersonalInfoPage checkoutPersonalInfoPage = cartPage.checkout();

        log.info("Entering personal information...");
        CheckoutOverviewPage checkoutOverviewPage = checkoutPersonalInfoPage.checkoutPersonalData(checkoutFirstName,checkoutLastName,checkoutPostalCode);

        log.info("Completing the purchase...");
        CheckoutFinishPage checkoutFinishPage = checkoutOverviewPage.clickFinish();

        log.info("Verifying the completion message...");
        softAssert.assertEquals(checkoutFinishPage.getTextCompleteHeader(),"Thank you for your purchase");
        softAssert.assertAll();

        log.info("purchaseProduct test completed.");
    }

    @Test
    public void removeProducts(){
        log.info("Starting removeProducts test...");

        int cartElements = 3;

        SoftAssert softAssert = new SoftAssert();

        log.info("Adding inventory elements to the cart...");
        InventoryPage inventoryPage = this.loadInventory();
        inventoryPage.addRandomInventoryElements(cartElements);
        softAssert.assertEquals(inventoryPage.getInventoryRemoveItemButtonSize(),cartElements);

        log.info("Clicking on the shopping cart...");
        CartPage cartPage = inventoryPage.clickShoppingCart();
        cartPage.removeItems(cartElements);

        log.info("Verifying the cart after removing items...");
        softAssert.assertEquals(cartPage.getRemoveItemButtonsSize(),0);
        softAssert.assertAll();

        log.info("removeProducts test completed.");
    }
}