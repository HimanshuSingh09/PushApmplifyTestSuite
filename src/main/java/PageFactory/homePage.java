package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    WebDriver driver;

    @FindBy(xpath="//*[@id=\"navbarNav\"]/ul[1]/li[1]/a")

    WebElement homePageFeaturesLink;

    @FindBy(xpath="//*[@id=\"navbarNav\"]/ul[1]/li[2]/a")

    WebElement homePageHowItWorksLink;


    @FindBy(xpath="//*[@id=\"navbarNav\"]/ul[1]/li[3]/a")

    WebElement homePagePerformanceLink;

    @FindBy(xpath="//*[@id=\"navbarNav\"]/ul[1]/li[4]/a")

    WebElement homePageGetInTouchLink;

    @FindBy(xpath="//*[@id=\"navbarNav\"]/ul[2]/li/a")

    WebElement homePageLoginLink;

    @FindBy(xpath="//*[@id=\"navbarNav\"]/ul[3]/li/a")

    WebElement homePageRegisterLink;

    @FindBy(xpath="//*[@id=\"email_top\"]")

    WebElement homePageEnterEmailLink;

    @FindBy(xpath="//*[@id=\"submit_top\"]")

    WebElement homePageGetFreeDemoLink;


    @FindBy(xpath="//*[@id=\"features\"]/div/div[2]/div[4]/div/button")

    WebElement homePageStartNowLink;
    @FindBy(xpath="//*[@id=\"email_bot\"]")

    WebElement homePageGetInTouchEmailLink;

    @FindBy(xpath="//*[@id=\"phone_bot\"]")

    WebElement homePageGetInTouchPhoneLink;
    @FindBy(xpath="//*[@id=\"submit_bot\"]")

    WebElement homePageGetInTouchSubmitLink;

    @FindBy(xpath="//*[@id=\"thanks_top\"]")

    WebElement homePageValidatorLink;


    public homePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void clickOnFeaturesLink(){
        homePageFeaturesLink.click();
    }

    public void clickOnHowItWorksLink(){
        homePageHowItWorksLink.click();
    }
    public void clickOnPerformanceLink(){
        homePagePerformanceLink.click();
    }

    public void clickOnGetInTouchLink(){
        homePageGetInTouchLink.click();
    }

    public void clickOnLoginLink(){
        homePageLoginLink.click();
    }
    public void clickOnRegisterLink(){
        homePageRegisterLink.click();
    }

    public void submitEmailForDemo(String emailID){
        homePageEnterEmailLink.clear();
        homePageEnterEmailLink.sendKeys(emailID);
        homePageGetFreeDemoLink.click();

    }

    public void clickOnStartNowLink(){
        homePageStartNowLink.click();

    }
    public void submitGetInTouchDetails(String touchEmail,String phone){
        homePageGetInTouchEmailLink.sendKeys(touchEmail);
        homePageGetInTouchPhoneLink.sendKeys(phone);
        homePageGetInTouchSubmitLink.click();
    }


}
