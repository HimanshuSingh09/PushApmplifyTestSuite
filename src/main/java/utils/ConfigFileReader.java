package utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "C:\\Users\\akumar\\Himanshu\\src\\main\\resources\\configuration.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath(){
        String ChromeDriverPath = properties.getProperty("ChromeDriverPath");
        if(ChromeDriverPath!= null) return ChromeDriverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }


    public String getLoginPageUrl() {
        String LoginPageUrl = properties.getProperty("LoginPageUrl");
        if(LoginPageUrl != null) return LoginPageUrl;
        else throw new RuntimeException(" LoginPage url not specified in the Configuration.properties file.");
    }

    public String getInputSheetPath() {
        String InputSheetPath = properties.getProperty("InputSheetPath");
        if(InputSheetPath != null) return InputSheetPath;
        else throw new RuntimeException("InputSheet.xls not specified in the Configuration.properties file.");
    }
    public String getBrowserType() {
        String BrowserType = properties.getProperty("BrowserType");
        if(BrowserType != null) return BrowserType;
        else throw new RuntimeException("BrowserType not specified in the Configuration.properties file.");
    }
    public String getRegisterPageUrl() {
        String RegisterPageUrl = properties.getProperty("RegisterPageUrl");
        if(RegisterPageUrl != null) return RegisterPageUrl;
        else throw new RuntimeException("RegisterPageUrl not specified in the Configuration.properties file.");
    }
    public String getHomePageUrl() {
        String HomePageUrl = properties.getProperty("HomePageUrl");
        if(HomePageUrl != null) return HomePageUrl;
        else throw new RuntimeException("HomePageUrl not specified in the Configuration.properties file.");
    }
    public String getWindowTiltleOfLoginOrRegistrationPage() {
        String WindowTitleLoginOrRegistrationPage = properties.getProperty("WindowTitleLoginOrRegistrationPage");
        if(WindowTitleLoginOrRegistrationPage != null) return WindowTitleLoginOrRegistrationPage;
        else throw new RuntimeException("WindowTitleLoginOrRegistrationPageHomePageUrl not specified in the Configuration.properties file.");
    }
    public String getWindowTiltleOfHomePage() {
        String WindowTitleHomePage = properties.getProperty("WindowTitleHomePage");
        if(WindowTitleHomePage != null) return WindowTitleHomePage;
        else throw new RuntimeException("WindowTitleHomePage not specified in the Configuration.properties file.");
    }
}