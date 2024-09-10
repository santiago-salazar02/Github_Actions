package swag.labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.utils.basePage.BasePage;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".inventory_item button[name^=add]")
    private List<WebElement> inventoryItemButtons;

    @FindBy(css = ".inventory_item button[name^=remove]")
    private List<WebElement> inventoryRemoveItemButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id="logout_sidebar_link")
    private WebElement logoutHref;

    public int getInventoryItemButtonSize(){
        return this.inventoryItemButtons.size();
    }

    public int getInventoryRemoveItemButtonSize(){
        return this.inventoryRemoveItemButtons.size();
    }

    public void clickRandomInventoryElement(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.inventoryItemButtons.size());
        WebElement randomElement = this.inventoryItemButtons.get(randomIndex);
        randomElement.click();
    }

    public void addRandomInventoryElements(int numberElements){
        if(numberElements > this.inventoryItemButtons.size()){
            numberElements = this.inventoryItemButtons.size();
        }
        for(int i = 0; i < numberElements; i++){
            clickRandomInventoryElement();
        }
    }

    public CartPage clickShoppingCart(){
        shoppingCart.click();
        return new CartPage(this.getDriver());
    }

}
