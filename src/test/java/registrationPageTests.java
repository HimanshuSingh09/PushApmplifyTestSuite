import PageFactory.LoginPage;
import PageFactory.registrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigFileReader;
import utils.ExcelUtils;
import utils.HelperDriverClass;
import utils.randomGenerator;

public class registrationPageTests {
    public WebDriver driver;
    ConfigFileReader configFileReader=new ConfigFileReader();


    @BeforeClass
    public void startBrowser() throws Exception {
        ExcelUtils.setExcelFile(configFileReader.getInputSheetPath(),"AUTOMATED TEST CASES");
        HelperDriverClass helperDriverClass=new HelperDriverClass();
        driver=helperDriverClass.SelectBrowser();
        }




    @Test(priority = 17)
    public void VerifyRegistrationPageLink() throws Exception {
        driver.get(configFileReader.getRegisterPageUrl());
        Thread.sleep(2000);

            if (driver.getTitle().equalsIgnoreCase(configFileReader.getWindowTiltleOfLoginOrRegistrationPage())) {
                ExcelUtils.setCellData("RegistrationPage link is up and running", 21, 4);
                ExcelUtils.setCellData("PASS", 21, 5);
            }
        else
           {
            ExcelUtils.setCellData("Link not working", 21, 4);
            ExcelUtils.setCellData("FAIL", 21, 5);
        }
    }
    @Test(priority = 18)
    public void VerifyErrorOnMismatchedPasswords() throws Exception {
        driver.get(configFileReader.getRegisterPageUrl());
        registrationPage registrationPage=new registrationPage(driver);
        registrationPage.VerifyRegistrationProcess("123@com","123456","1234","lfc");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[5]")));
        String validator = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[5]")).getText();
        Thread.sleep(3000);

            if (validator.equalsIgnoreCase("Passwords don't match")) {
                ExcelUtils.setCellData("When Passwords doesn't match,a error notification is received", 22, 4);
                ExcelUtils.setCellData("PASS", 22, 5);
            }
        else {
            ExcelUtils.setCellData("No error pop up", 22, 4);
            ExcelUtils.setCellData("FAIL", 22, 5);

        }

    }
    @Test(priority = 19)
    public void VerifyErrorOnExistingUsers() throws Exception {
        driver.get(configFileReader.getRegisterPageUrl());
        registrationPage registrationPage=new registrationPage(driver);
        registrationPage.VerifyRegistrationProcess("tester@test.com","123456","123456","lfc");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[5]")));
        String validator = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div/div[1]/div/div/form/div[5]")).getText();
        Thread.sleep(3000);

            if (validator.equalsIgnoreCase("Account already exists!")) {
                ExcelUtils.setCellData("When user already Exists ,an error notification is received", 23, 4);
                ExcelUtils.setCellData("PASS", 23, 5);
            }
        else {
            ExcelUtils.setCellData("No error pop up", 23, 4);
            ExcelUtils.setCellData("FAIL", 23, 5);

        }

    }
    @Test(priority = 20)
    public void VerifyRegistrationNegative() throws Exception {
        Thread.sleep(2000);
        driver.get(configFileReader.getRegisterPageUrl());
        driver.navigate().refresh();
        Thread.sleep(2000);
        registrationPage registrationPage=new registrationPage(driver);
        registrationPage.VerifyRegistrationProcess("1234","123456","123456","lfc");
        Thread.sleep(3000);

            if(driver.findElement(By.xpath("//*[@id=\"register\"]/div/div/div[1]/div/div/form/button/span")).isDisplayed() )
            {
                ExcelUtils.setCellData("no error pop up, even if credentials are invalid", 24, 4);
                ExcelUtils.setCellData("FAIL", 24, 5);
            }
      else
        {
            ExcelUtils.setCellData("error poped  up if credentials are invalid", 24, 4);
            ExcelUtils.setCellData("PASS", 24, 5);
        }


    }
    @Test(priority = 21)
    public void VerifyRegistrationPositive() throws Exception {
        driver.get(configFileReader.getRegisterPageUrl());
        registrationPage registrationPage = new registrationPage(driver);

        randomGenerator randomGenerator = new randomGenerator();
        int randomEmail = randomGenerator.createRandomNumber();
        registrationPage.VerifyRegistrationProcess(randomEmail + "@test.com", "123456", "123456", "lfc");
            if (driver.findElement(By.xpath("//*[@id=\"register\"]/div/div/div[1]/div/div/form/button/span")).isDisplayed()) {
                registrationPage.clickOnLoginButtonToRedirect();
                LoginPage loginPage = new LoginPage(driver);
                loginPage.LoginIntoAmplify(randomEmail+"@test.com", "123456");
                Thread.sleep(3000);
                String currentUrl = driver.getCurrentUrl();

                    if (currentUrl.equalsIgnoreCase(configFileReader.getLoginPageUrl())) {
                        ExcelUtils.setCellData("login is unsuccessful with registered credentials", 25, 4);
                        ExcelUtils.setCellData("FAIL", 25, 5);
                    }

                else{
                    ExcelUtils.setCellData("login is successful and redirected to dashboard", 25, 4);
                    ExcelUtils.setCellData("PASS", 25, 5);

                }

            }

        }
    @AfterClass
    public void closeup()
    {
        driver.close();
        driver.quit();

    }


    }


