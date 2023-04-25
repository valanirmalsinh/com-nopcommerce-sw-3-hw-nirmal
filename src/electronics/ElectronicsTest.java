package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.UUID;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverElement(By.xpath("(//a[text() = 'Electronics '])[1]"));

        //Mouse Hover on “Cell phones” and click
        mouseClickOnElement(By.xpath("(//a[text() = 'Cell phones '])[1]"));

        // Verify the text “Cell phones”
        verifyText(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException{

        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverElement(By.xpath("(//a[text() = 'Electronics '])[1]"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseClickOnElement(By.xpath("(//a[text() = 'Cell phones '])[1]"));

        // 2.3 Verify the text “Cell phones”
        verifyText(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");

        //  2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        // 2.7 Verify the price “$349.00”
        verifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");

        // 2.8 Change quantity to 2
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//p[text()='The product has been added to your ']"),
                "The product has been added to your shopping cart");

        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //  2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        // 2.12 Verify the message "Shopping cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        // 2.13 Verify the quantity is 2
        Thread.sleep(1000);
        String expectedQty = "2";
        WebElement actualElement = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String actualQty = actualElement.getAttribute("value");
        Assert.assertEquals(expectedQty, actualQty);

        //verifyFromElement(By.xpath("//input[@id='itemquantity11334']"),"2");
        // 2.14 Verify the Total $698.00
        verifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");

        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.name("checkout"));

        // 2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        // 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        // 2.19 Verify the text “Register”
        verifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        // 2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@name='Gender' and @value='F']"));
        sendTextToElement(By.name("FirstName"), "Par");
        sendTextToElement(By.name("LastName"), "Meh");
        String email= "random-" + UUID.randomUUID().toString() + "@example.com";
        sendTextToElement(By.xpath("//input[@id='Email']"),email);
        sendTextToElement(By.name("Password"), "Tango456");
        sendTextToElement(By.id("ConfirmPassword"), "Tango456");

        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        // 2.22 Verify the message “Your registration completed”
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),
                "Your registration completed");

        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        // 2.24 Verify the text “Shopping card”
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        //click on the ‘Login’ link
        clickOnElement(By.xpath("//a[text()='Log in']"));
        //Enter valid username
        sendTextToElement(By.xpath("//input[@id='Email']"),email);
        // Enter valid password
        sendTextToElement(By.xpath("//input[@id='Password']"),"Tango456");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@type='submit' and text()='Log in']"));

        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // 2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // 2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United States");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Ohio");
        sendTextToElement(By.id("BillingNewAddress_City"), "Manchester");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "131,Oxford Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "M25 7DQ");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "08989676754");
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        //2.33 Fill all the details Enter CardHolder Name
        sendTextToElement(By.id("CardholderName"), "Prime Testing");
        //Enter card number
        sendTextToElement(By.id("CardNumber"), "5105105105105100");
        //Select Expiry Month
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "10");
        //Select Expiry Year
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2027");
        //Card code
        sendTextToElement(By.id("CardCode"), "357");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        //Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//li[@class='payment-method']"),"Payment Method: Credit Card");

        //Verify “Shipping Method” is “2nd Day Air”
        verifyText(By.xpath("//div[@class='shipping-method-info']/ul/li"),"Shipping Method: 2nd Day Air");

        //Verify Total is “$698.00”
        // String expectedMessage13 = "$698.00";
        verifyText(By.xpath("//tr[@class ='order-total']/td[2]/span//strong[text()='$698.00']"),"$698.00");

        //Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']//button"));
        //Verify the Text “Thank You”
        verifyText(By.xpath("//h1[text()='Thank you']"),"Thank you");
        //  String expectedMessage14 = "Thank you";

        //Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[text()='Your order has been successfully processed!']"),
                "Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        // String expectedMessage16 = "Welcome to our store";
        verifyText(By.xpath("//h2[text()='Welcome to our store']"),"Welcome to our store");
        //Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage = "https://demo.nopcommerce.com/";
        //Actual Message
        String actualMessage = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}