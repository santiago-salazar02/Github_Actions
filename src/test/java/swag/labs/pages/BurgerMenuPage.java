package swag.labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.utils.basePage.BasePage;

public class BurgerMenuPage extends BasePage {
    public BurgerMenuPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id="logout_sidebar_link")
    private WebElement logoutHref;

    public void clickBurgerMenu(){
        this.burgerMenuButton.click();
    }

    public void clickLogout(){
        this.waitElementVisibility(this.logoutHref);
        this.logoutHref.click();
    }
}
