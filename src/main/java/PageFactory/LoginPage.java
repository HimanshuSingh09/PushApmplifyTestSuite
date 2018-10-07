package PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    @FindBy(xpath="//*[@id=\"login\"]/div/div/div[1]/div/div/form/div[1]/input")

    WebElement loginPageUserEmail;

    @FindBy(xpath="//*[@id=\"login\"]/div/div/div[1]/div/div/form/div[2]/input")

    WebElement loginPageUserPassword;

    @FindBy(xpath="//*[@id=\"login\"]/div/div/div[1]/div/div/form/button")

    WebElement loginPageSubmitButton;

    @FindBy(xpath="//*[@id=\"nav\"]/div[2]/div/a[1]/div/span")

    WebElement overViewDashBoardButton;

    @FindBy(xpath="//*[@id=\"login\"]/div/div/div[1]/div/div/div/a")

    WebElement registerLinkButton;



    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void LoginIntoAmplify(String uEmail,String upass){
        loginPageUserEmail.clear();
        loginPageUserEmail.sendKeys(uEmail);
        loginPageUserPassword.clear();
        loginPageUserPassword.sendKeys(upass);
        loginPageSubmitButton.click();


    }
    public void clickOnRegisterButton(){

        registerLinkButton.click();

    }

}