package computer;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //Click on Computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //Select Sort by Position "Name Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A ");

        //Verify the Product will arrange in Descending order.
        selectByValueTextFromDropDown(By.id("products-orderby"), "6");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //Select Sort By position "Name: A to Z"
        selectByValueTextFromDropDown(By.id("products-orderby"), "5");
        Thread.sleep(2000);

        //Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));

        //Verify the Text "Build your own computer"
        verifyText(By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer");

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");

        //Select "8GB [+$60.00]" using Select class.
        selectByValueTextFromDropDown(By.name("product_attribute_2"), "5");

        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(4000);

        //Verify the price "$1,475.00"
        verifyText(By.xpath("//span[@id='price-value-1']"), "$1,475.00");
        Thread.sleep(2000);

        //Click on "ADD TO CART" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),
                "The product has been added to your shopping cart");
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(2000);

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverElement(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.id("topcartlink"));

        //Verify the message "Shopping cart"
        verifyText(By.xpath("//span[contains(text(),'Shopping cart')]"), "Shopping cart");

        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //Verify the Total"$2,950.00"
        verifyText(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"$2,950.00");

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"John");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Wick");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"JWandTheDog@gmail.com");
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"1, Buckingham Palace");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"E1 2BE");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"012345678901");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"),"John Wick");
        sendTextToElement(By.name("CardNumber"),"5245256238832614");
        Thread.sleep(1000);
        selectByValueTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "11");
        selectByValueTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2027");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"999");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[normalize-space()='Credit Card']"),"Credit Card");

        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText(By.xpath("//span[normalize-space()='Next Day Air']"),"Next Day Air");

        //2.33 Verify Total is “$2,950.00”
        verifyText(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"$2,950.00");

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[normalize-space()='Thank you']"), "Thank you");

        //2.36 Verify the message “Your order has been successfully processed!” 2.37 Click on “CONTINUE”
        verifyText(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),
                "Your order has been successfully processed!");
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[normalize-space()='Welcome to our store']"),"Welcome to our store");

    }
//    @After
//    public void tearDown() {
//        closeBrowser();
//    }
}