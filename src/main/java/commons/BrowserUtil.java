package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

    private static WebDriver driver;
    private static String CHOSEN_BROWSER="";

    //region Browser Actions
    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        CHOSEN_BROWSER = Browser.CHROME;
        driver.manage().window().maximize();
    }

    public static void openBrowser(String browserType) {
        if(browserType.equalsIgnoreCase(Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            CHOSEN_BROWSER = Browser.CHROME;
        }
        else if(browserType.equalsIgnoreCase(Browser.EDGE)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            CHOSEN_BROWSER = Browser.EDGE;
        }
        else if(browserType.equalsIgnoreCase(Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            CHOSEN_BROWSER = Browser.FIREFOX;
        }
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            StringBuilder strb = new StringBuilder();
            strb.append("\n\nException Message : \n");
            strb.append("\tWebDriver is not initiated, please instantiate WebDriver by\n");
            strb.append("\tcalling openBrowser() method. \n\n");
            strb.append("Exception Location:  Class  -> UIActions\n");
            strb.append("Exception Occured :  Method -> getDriver()\n");
            throw new NullPointerException(strb.toString());
        }
        return driver;
    }

    public static String getChosenBrowser() {
        return CHOSEN_BROWSER;
    }


    public static void closeBrowser() {
        if(CHOSEN_BROWSER.equals(Browser.FIREFOX)) {
            if(driver != null) {
                driver.quit();
                return;
            }
            return;
        }
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }
}