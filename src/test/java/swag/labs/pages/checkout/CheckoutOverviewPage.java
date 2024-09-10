package swag.labs.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.utils.basePage.BasePage;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="finish")
    private WebElement finishButton;

    public CheckoutFinishPage clickFinish(){
        this.finishButton.click();
        return new CheckoutFinishPage(this.getDriver());
    }
}
