package automationpractice;

import commons.BrowserUtil;
import org.openqa.selenium.By;
import utility.JOptionPane;
import utility.UIActions;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;



public class NAC {

    public static void main(String[] args) throws AWTException, InterruptedException {
        JOptionPane longmac = new JOptionPane();

        String longMac = longmac.welcomePane();
        String mac = "";
        int r = 0;


        List<String> strings = new ArrayList<String>();
        int index = 0;
        while (index < longMac.length()) {
            strings.add(longMac.substring(index, Math.min(index + 12,longMac.length())));
            index += 12;
            System.out.println(strings);
        }

        BrowserUtil.openBrowser();
        UIActions I = new UIActions();


        I.gotoSite("https://b12-ise-pan.nih.gov/admin/");
        I.waitfor(5);

        I.click(By.cssSelector("form[name='prelogin'] > input[value='Continue']"));


        for (int i = 0; i < strings.size(); i++) {

            mac = strings.get(r);

            I.click(By.cssSelector(".btn-group.toolbar-primary > button:nth-of-type(2)"));
            I.waitfor(1);
            I.write(By.cssSelector("input[name='macAddress']"), mac);
            I.waitfor(1);
            I.write(By.cssSelector("textarea[name='description']"), "HP EliteBook");
            I.waitfor(1);
            I.click(By.cssSelector("input[name='staticEndpoint']"));
            I.waitfor(1);
            I.click(By.cssSelector(".field-policyName [title]"));
            I.write(By.cssSelector(".select2-dropdown.select2-dropdown--above  input[role='textbox']"), "Windows10");
            I.click(By.cssSelector("ul[role='tree'] > li[role='treeitem']"));
            I.waitfor(1);
            I.click(By.cssSelector(".field-identityGroup [title]"));
            I.write(By.cssSelector(".select2-dropdown.select2-dropdown--above  input[role='textbox']"), "OD-ORS_A");
            I.click(By.cssSelector("ul[role='tree'] > li[role='treeitem']"));
            I.waitfor(1);
            I.click(By.cssSelector(".btn-sm.btn-primary"));


            if (I.isElementDisplayed(By.cssSelector(".xwt-success-message")) == true) {
                System.out.println(("The following MAC Address was successfully NAC'd: ") + (mac));
                I.waitfor(2);
                r++;

            }else {
                System.out.println(("Something went wrong while trying to NAC the following MAC Address: ") + (mac));
                break;

            }

        }

        BrowserUtil.closeBrowser();
    }
}