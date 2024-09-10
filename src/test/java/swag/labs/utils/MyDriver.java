package swag.labs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class MyDriver {
    private WebDriver driver;

    public MyDriver(String browserName){
        String path = System.getProperty("user.dir");
        if(Objects.equals(browserName, "CHROME")){
            System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
            this.driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
