import PageFactory.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigFileReader;
import utils.ExcelUtils;
import utils.HelperDriverClass;


public class loginPageTests {

    public WebDriver driver;
    ConfigFileReader configFileReader=new ConfigFileReader();

    @BeforeClass
    public void startBrowser() throws Exception {
        ExcelUtils.setExcelFile(configFileReader.getInputSheetPath(),"AUTOMATED TEST CASES");
        HelperDriverClass helperDriverClass=new HelperDriverClass();
        driver=helperDriverClass.SelectBrowser();
    }
    @Test(priority = 13)
    public void VerifyLoginPageLink() throws Exception {
        driver.get(configFileReader.getLoginPageUrl());
        Thread.sleep(2000);

            if (driver.getTitle().equalsIgnoreCase(configFileReader.getWindowTiltleOfLoginOrRegistrationPage())) {
                ExcelUtils.setCellData("Login Page link is up and running", 1, 4);
                ExcelUtils.setCellData("PASS", 1, 5);
            }

        else {
            ExcelUtils.setCellData("Link not working", 1, 4);
            ExcelUtils.setCellData("FAIL", 1, 5);
        }

    }
    @Test(priority = 14)
    public void VerifyRegisterLink() throws Exception {
        driver.get(configFileReader.getLoginPageUrl());
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickOnRegisterButton();
        Thread.sleep(3000);
        String currentUrl=driver.getCurrentUrl();

            if(configFileReader.getRegisterPageUrl().equalsIgnoreCase(currentUrl))
            {
                ExcelUtils.setCellData("Redirected to Registration page",4,4);
                ExcelUtils.setCellData("PASS",4,5);

            }

        else
        {
            ExcelUtils.setCellData("Link not working",4,4);
            ExcelUtils.setCellData("FAIL",4,5);
        }
    }
    @Test(priority = 15)
    public void VerifyLoginPageNegative() throws Exception {
        driver.get(configFileReader.getLoginPageUrl());
        LoginPage loginPage=new LoginPage(driver);
        loginPage.LoginIntoAmplify("123com","1234");
        Thread.sleep(3000);
        String currentUrl=driver.getCurrentUrl();

            if(currentUrl.equalsIgnoreCase(configFileReader.getLoginPageUrl()))
            {
                ExcelUtils.setCellData("login is unsuccessful and an error message is displayed",3,4);
                ExcelUtils.setCellData("PASS",3,5);
            }

       else
        {
            ExcelUtils.setCellData("login is succesfull and redirected to dashbaord",3,4);
            ExcelUtils.setCellData("FAIL",3,5);
        }

    }

    @Test(priority = 16)
    public void VerifyLoginPagePositive() throws Exception {

        driver.get(configFileReader.getLoginPageUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginIntoAmplify("tester@test.com", "1234");
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equalsIgnoreCase(configFileReader.getLoginPageUrl())) {
                ExcelUtils.setCellData("login is unsuccessful and an error message is displayed", 2, 4);
                ExcelUtils.setCellData("FAIL", 2, 5);
            }
        else{
                ExcelUtils.setCellData("login is successful and redirected to dashboard", 2, 4);
                ExcelUtils.setCellData("PASS", 2, 5);

        }

    }
    @AfterClass
        public void closeup()
        {
driver.close();
driver.quit();

        }


    }




