package swag.labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.pages.checkout.CheckoutPersonalInfoPage;
import swag.labs.utils.basePage.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_button")
    private List<WebElement> removeItemButtons;

    public int getRemoveItemButtonsSize(){
        return this.removeItemButtons.size();
    }

    public CheckoutPersonalInfoPage checkout(){
        this.checkoutButton.click();
        return new CheckoutPersonalInfoPage(this.getDriver());
    }

    public void clickRemoveItem(WebElement removeItemButton){
        removeItemButton.click();
    }

    public void removeItems(int items){
       if(items > this.getRemoveItemButtonsSize()){
           items = this.getRemoveItemButtonsSize();
       }
       for(int i = 0; i < items; i++){
           this.clickRemoveItem(this.removeItemButtons.get(this.getRemoveItemButtonsSize()-1));
       }
    }

}
