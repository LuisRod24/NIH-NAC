package utility;

import org.openqa.selenium.By;

public class IElements {

    public static By css(String expression) {
        return By.cssSelector(expression);
    }


    public static By id(String expression) {
        return By.id(expression);
    }


    public static By xpath(String expression) {
        return By.xpath(expression);
    }


    public static By link(String expression) {
        return By.linkText(expression);
    }


    public static By linktextContains(String expression) {
        return By.partialLinkText(expression);
    }


    public static By nameAttribute(String expression) {
        return By.name(expression);
    }


    public static By withTag(String expression) {
        return By.tagName(expression);
    }
}
