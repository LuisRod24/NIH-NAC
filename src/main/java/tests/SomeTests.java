package tests;

import com.github.javafaker.Faker;
import commons.BaseTest;
import org.junit.Test;
import org.testng.Assert;
// import org.testng.annotations.Test;
import utility.UIActions;
import static utility.IElements.*;


public class SomeTests extends BaseTest {

    @Test
    public void PBTW_T1() {
        // ====== TEST DATA =======/
        final String site = "https://parabank.parasoft.com/parabank/index.htm";
        String expected = "Your account was created successfully. You are now logged in.";
        UIActions I = new UIActions();
        Faker data = new Faker();
        String firstName = data.name().firstName();
        String lastName = data.name().lastName();
        String street = data.address().streetAddress();
        String city = data.address().city();
        String state = data.address().state();
        String zipcode = data.address().zipCode();
        String phoneNum = data.phoneNumber().cellPhone();
        String ssn = data.idNumber().ssnValid();
        String username = data.name().username();
        String password = data.internet().password();

        // ====== TEST STEP =======/
        I.gotoSite( site );
        I.highlight(css("div#loginPanel > p:nth-of-type(2) > a"));
        I.click(css("div#loginPanel > p:nth-of-type(2) > a"));
        I.write(id("customer.firstName"), firstName);
        I.write(id("customer.lastName"), lastName);
        I.write(id("customer.address.street"),street);
        I.write(id("customer.address.city"), city);
        I.write(id("customer.address.state"), state);
        I.write(id("customer.address.zipCode"), zipcode);
        I.write(id("customer.phoneNumber"), phoneNum);
        I.write(id("customer.ssn"), ssn);
        I.write(id("customer.username"), username);
        I.write(id("customer.password"), password);
        I.write(id("repeatedPassword"), password);
        I.highlight(xpath("//input[@value='Register']"));
        I.click(xpath("//input[@value='Register']"));

        // ====== Verification =======/
        String actual = I.element(xpath("//div[@id='rightPanel']/p")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void PBTW_T1_SLOWED() {
        // ====== TEST DATA =======/
        final String site = "https://parabank.parasoft.com/parabank/index.htm";
        String expected = "Your account was created successfully. You are now logged in.";
        UIActions I = new UIActions();
        Faker data = new Faker();
        String firstName = data.name().firstName();
        String lastName = data.name().lastName();
        String street = data.address().streetAddress();
        String city = data.address().city();
        String state = data.address().state();
        String zipcode = data.address().zipCode();
        String phoneNum = data.phoneNumber().cellPhone();
        String ssn = data.idNumber().ssnValid();
        String username = data.name().username();
        String password = data.internet().password();

        // ====== TEST STEP =======/
        I.gotoSite( site );
        I.highlight(css("div#loginPanel > p:nth-of-type(2) > a"));
        I.click(css("div#loginPanel > p:nth-of-type(2) > a"));
        I.waitfor(1);
        I.write(id("customer.firstName"), firstName);
        I.waitfor(1);
        I.write(id("customer.lastName"), lastName);
        I.waitfor(1);
        I.write(id("customer.address.street"),street);
        I.waitfor(1);
        I.write(id("customer.address.city"), city);
        I.waitfor(1);
        I.write(id("customer.address.state"), state);
        I.waitfor(1);
        I.write(id("customer.address.zipCode"), zipcode);
        I.waitfor(1);
        I.write(id("customer.phoneNumber"), phoneNum);
        I.waitfor(1);
        I.write(id("customer.ssn"), ssn);
        I.waitfor(1);
        I.write(id("customer.username"), username);
        I.waitfor(1);
        I.write(id("customer.password"), password);
        I.waitfor(1);
        I.write(id("repeatedPassword"), password);
        I.waitfor(1);
        I.click(xpath("//input[@value='Register']"));

        // ====== Verification =======/
        I.highlight(xpath("//div[@id='rightPanel']/p"));
        I.waitfor(2);
        String actual = I.element(xpath("//div[@id='rightPanel']/p")).getText();
        Assert.assertEquals(actual, expected);
    }


}
