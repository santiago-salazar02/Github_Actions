package swag.labs.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.utils.basePage.BasePage;

public class CheckoutFinishPage extends BasePage {
    public CheckoutFinishPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public String getTextCompleteHeader(){
        return this.completeHeader.getText();
    }
}
