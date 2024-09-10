package swag.labs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
    private WebDriver driver;

    public MyDriver(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
