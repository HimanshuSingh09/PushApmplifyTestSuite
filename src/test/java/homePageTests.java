import PageFactory.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigFileReader;
import utils.ExcelUtils;
import utils.HelperDriverClass;

public class homePageTests {

    public WebDriver driver;
    ConfigFileReader configFileReader=new ConfigFileReader();

    @BeforeClass
    public void startBrowser() throws Exception {
        ExcelUtils.setExcelFile(configFileReader.getInputSheetPath(),"AUTOMATED TEST CASES");
        HelperDriverClass helperDriverClass=new HelperDriverClass();
        driver=helperDriverClass.SelectBrowser();
    }

   @Test(priority = 1)
    public void VerifyHomePageLink() throws Exception {
        driver.get(configFileReader.getHomePageUrl());
        Thread.sleep(2000);

            if (driver.getTitle().equalsIgnoreCase(configFileReader.getWindowTiltleOfHomePage())) {
                ExcelUtils.setCellData("Home Page link is up and running", 7, 4);
                ExcelUtils.setCellData("PASS", 7, 5);
            }

        else {
                ExcelUtils.setCellData("Link not working", 7, 4);
                ExcelUtils.setCellData("FAIL", 7, 5);
            }

        }



        @Test(priority = 2)
        public void VerifyFeaturesLink() throws Exception {
            homePage homepage = new homePage(driver);
            homepage.clickOnFeaturesLink();
            Thread.sleep(3000);
            JavascriptExecutor executorAfter = (JavascriptExecutor) driver;
            Long valueAfter = (Long) executorAfter.executeScript("return window.pageYOffset;");

                if (valueAfter == 943) {
                    ExcelUtils.setCellData("when features link is clicked , focus moves to its content", 8, 4);
                    ExcelUtils.setCellData("PASS", 8, 5);
                }
            else {
                ExcelUtils.setCellData("Link not working", 8, 4);
                ExcelUtils.setCellData("FAIL", 8, 5);

            }
        }

        @Test(priority = 3)
        public void VerifyHowItWorksLink() throws Exception {
            homePage homepage = new homePage(driver);
            homepage.clickOnHowItWorksLink();
            Thread.sleep(3000);
            JavascriptExecutor executorAfter = (JavascriptExecutor) driver;
            Long valueAfter = (Long) executorAfter.executeScript("return window.pageYOffset;");

                if (valueAfter == 1643) {
                    ExcelUtils.setCellData("when HowItWorks link is clicked , focus moves to its content", 9, 4);
                    ExcelUtils.setCellData("PASS", 9, 5);
                }
            else
            {
                ExcelUtils.setCellData("Link not working",9,4);
                ExcelUtils.setCellData("FAIL",9,5);
            }
        }
    @Test(priority = 4)
    public void VerifyPerformanceLink() throws Exception {
        homePage homepage=new homePage(driver);
        homepage.clickOnPerformanceLink();
        Thread.sleep(3000);
        JavascriptExecutor executorAfter = (JavascriptExecutor) driver;
        Long valueAfter = (Long) executorAfter.executeScript("return window.pageYOffset;");
            if(valueAfter==2888)
            {
                ExcelUtils.setCellData("when PerformanceLink is clicked , focus moves to its content",10,4);
                ExcelUtils.setCellData("PASS",10,5);
            }

        else
        {
            ExcelUtils.setCellData("Link not working",10,4);
            ExcelUtils.setCellData("FAIL",10,5);
        }
    }
    @Test(priority = 5)
    public void VerifyGetInTouchLink() throws Exception {
        homePage homepage=new homePage(driver);
        homepage.clickOnGetInTouchLink();
        Thread.sleep(3000);
        JavascriptExecutor executorAfter = (JavascriptExecutor) driver;
        Long valueAfter = (Long) executorAfter.executeScript("return window.pageYOffset;");

           if (valueAfter == 3779) {
               ExcelUtils.setCellData("when GetInTouchLink is clicked , focus moves to its content", 11, 4);
               ExcelUtils.setCellData("PASS", 11, 5);
           }

      else{
           ExcelUtils.setCellData("Link not working",11,4);
           ExcelUtils.setCellData("FAIL",11,5);
       }

       }
    @Test(priority = 6)
    public void VerifyLoginLink() throws Exception {
        homePage homepage=new homePage(driver);
        homepage.clickOnLoginLink();
        Thread.sleep(3000);

            if (driver.getTitle().equalsIgnoreCase(configFileReader.getWindowTiltleOfLoginOrRegistrationPage())) {
                ExcelUtils.setCellData("When Clicked on login link , page is redirected to login Page", 12, 4);
                ExcelUtils.setCellData("PASS", 12, 5);
            }

      else
        {
            ExcelUtils.setCellData("Link not working", 12, 4);
            ExcelUtils.setCellData("FAIL", 12, 5);
        }
    }
    @Test(priority = 7)
    public void VerifyRegisterLink() throws Exception {
        homePage homepage = new homePage(driver);
        driver.navigate().back();
        homepage.clickOnRegisterLink();
        Thread.sleep(3000);

            if (driver.getTitle().equalsIgnoreCase(configFileReader.getWindowTiltleOfLoginOrRegistrationPage())) {
                ExcelUtils.setCellData("When Clicked on Register link , page is redirected to Registration Page", 13, 4);
                ExcelUtils.setCellData("PASS", 13, 5);
            }
        else
        {
            ExcelUtils.setCellData("Link not working", 13, 4);
            ExcelUtils.setCellData("FAIL", 13, 5);
        }
    }
        @Test(priority = 8)
    public void VerifyStartNowLink() throws Exception {
        homePage homepage=new homePage(driver);
        driver.navigate().back();
        homepage.clickOnStartNowLink();
        Thread.sleep(3000);

                if (driver.getTitle().equalsIgnoreCase(configFileReader.getWindowTiltleOfLoginOrRegistrationPage())) {
                    ExcelUtils.setCellData("When Clicked on StartNow link , page is redirected to Registration Page", 14, 4);
                    ExcelUtils.setCellData("PASS", 14, 5);
                }

           else
            {
                ExcelUtils.setCellData("Link not working", 14, 4);
                ExcelUtils.setCellData("FAIL", 14, 5);
            }
    }
    @Test(priority = 9)
    public void VerifySubmitEmailForDemoNegative() throws Exception {
        homePage homepage=new homePage(driver);
        driver.get(configFileReader.getHomePageUrl());
        homepage.submitEmailForDemo("123");
        Thread.sleep(3000);

            if(driver.getPageSource().contains("Our team will get in touch with you. Thanks for your interest.")){
                ExcelUtils.setCellData("When Clicked on Get demo, if credentials are invalid ,a error notification is received", 15, 4);
                ExcelUtils.setCellData("PASS", 15, 5);
            }
        else
        {
            ExcelUtils.setCellData("Link not working", 15, 4);
            ExcelUtils.setCellData("FAIL", 15, 5);
        }
    }
    @Test(priority = 10)
    public void VerifySubmitEmailForDemoPositive() throws Exception {
        homePage homepage = new homePage(driver);
        driver.get(configFileReader.getHomePageUrl());
        homepage.submitEmailForDemo("123@com");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"thanks_top\"]")));

        String validator = driver.findElement(By.xpath("//*[@id=\"thanks_top\"]")).getText();
        Thread.sleep(3000);

            if (validator.equalsIgnoreCase("Our team will get in touch with you. Thanks for your interest.")) {
                ExcelUtils.setCellData("When Clicked on Get demo, if credentials are valid ,a success notification is received", 16, 4);
                ExcelUtils.setCellData("PASS", 16, 5);

        } else{
            ExcelUtils.setCellData("Link not working", 16, 4);
            ExcelUtils.setCellData("FAIL", 16, 5);

        }

    }
    @Test(priority = 11)
    public void VerifySubmitGetInTouchDetailsNegative() throws Exception {
        homePage homepage=new homePage(driver);
        driver.get(configFileReader.getHomePageUrl());
        homepage.submitGetInTouchDetails("123com","0");
        Thread.sleep(3000);

            if(driver.findElement(By.xpath("//*[@id=\"thanks_bot\"]")).isDisplayed())
            {
                ExcelUtils.setCellData("no error pop up, even if credentials are invalid", 17, 4);
                ExcelUtils.setCellData("FAIL", 17, 5);
            }
     else {
                ExcelUtils.setCellData("error pop up  if credentials are invalid", 17, 4);
                ExcelUtils.setCellData("PASS", 17, 5);
        }
    }
    @Test(priority = 12)
    public void VerifySubmitGetInTouchDetailsPositive() throws Exception {
        homePage homepage = new homePage(driver);
        driver.get(configFileReader.getHomePageUrl());
        homepage.submitGetInTouchDetails("123@com","123456789");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"thanks_bot\"]")));

        String validator = driver.findElement(By.xpath("//*[@id=\"thanks_bot\"]")).getText();
        Thread.sleep(3000);

            if (validator.equalsIgnoreCase("Our team will get in touch with you. Thanks for your interest.")) {
                ExcelUtils.setCellData("When Clicked on Submit, if credentials are valid ,a success notification is received", 18, 4);
                ExcelUtils.setCellData("PASS", 18, 5);

        }else {
            ExcelUtils.setCellData("Link not working", 18, 4);
            ExcelUtils.setCellData("FAIL", 18, 5);

        }

    }



    @AfterClass
    public void closeup()
    {
        driver.close();
        driver.quit();

    }





}
