package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HelperDriverClass {

    public WebDriver driver;


    public WebDriver SelectBrowser(){

        ConfigFileReader configFileReader=new ConfigFileReader();
        String browserName = configFileReader.getBrowserType();

        if ("Firefox".equals(browserName)) {
            if (driver == null) {
                driver = new FirefoxDriver();
            }

        } else if ("Chrome".equals(browserName)) {

            if (driver == null) {

                System.setProperty("webdriver.chrome.driver",
                        configFileReader.getChromeDriverPath());

                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();

            }

        }
        return driver;
    }
}