package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registrationPage {

    WebDriver driver;

    @FindBy(xpath="//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[1]/input")
    WebElement registrationPageEmail;
    @FindBy(xpath="//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[2]/input")
    WebElement registrationPagePassOne;
    @FindBy(xpath="//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[3]/input")
    WebElement registrationPagePassTwo;
    @FindBy(xpath="//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[4]/input")
    WebElement registrationPageCompanyName;

    @FindBy(xpath="//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[5]/a")
    WebElement registrationPageLoginPageRedirection;
    @FindBy(xpath="//*[@id=\"register\"]/div/div/div[1]/div/div/form/button/span")
    WebElement registrationPageRegisterButton;

    public registrationPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public void VerifyRegistrationProcess(String emailId,String passOne, String passTwo, String companyName)
    {
        registrationPageEmail.clear();
        registrationPageEmail.sendKeys(emailId);
        registrationPagePassOne.clear();
        registrationPagePassOne.sendKeys(passOne);
        registrationPagePassTwo.clear();
        registrationPagePassTwo.sendKeys(passTwo);
        registrationPageCompanyName.clear();
        registrationPageCompanyName.sendKeys(companyName);
        registrationPageRegisterButton.click();
    }
    public void clickOnLoginButtonToRedirect(){
        registrationPageLoginPageRedirection.click();
    }
}
