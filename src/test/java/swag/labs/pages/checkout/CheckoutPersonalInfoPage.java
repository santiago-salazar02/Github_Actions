package swag.labs.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.utils.basePage.BasePage;

public class CheckoutPersonalInfoPage extends BasePage {

    public CheckoutPersonalInfoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="first-name")
    private WebElement firstName;

    @FindBy(id="last-name")
    private WebElement lastName;

    @FindBy(id="postal-code")
    private WebElement postalCode;

    @FindBy(id="continue")
    private WebElement continueButton;

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setPostalCode(String postalCode){
        this.postalCode.sendKeys(postalCode);
    }

    public void clickContinue(){
        this.continueButton.click();
    }

    public CheckoutOverviewPage checkoutPersonalData(String firstName,
                                                     String lastName,
                                                     String postalCode){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPostalCode(postalCode);
        this.clickContinue();
        return new CheckoutOverviewPage(this.getDriver());
    }
}
