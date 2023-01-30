package Maven_Projects;

import commons.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.UIActions;

import java.awt.*;
import java.awt.event.KeyEvent;


public class NAC {

    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rodriguezlua\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        UIActions I = new UIActions();
        I.gotoSite("https://b12-ise-pan.nih.gov/admin/");

        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);



    }
}
