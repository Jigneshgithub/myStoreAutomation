package com.myStore.qa.pages;

import com.myStore.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends TestBase {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement homePageLogo;

    @FindBy(xpath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]")
    WebElement headerContactUsWord;

    @FindBy(xpath = "//h4[contains(text(),'Categories')]")
    WebElement footerCategoriesWord;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signBtn;

    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    WebElement womenSectionBtn;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement signOutBtn;

    @FindBy(xpath = "//div[@class='product-image-container']//a//img[@class='replace-2x img-responsive' and @title='Blouse']")
    WebElement quickViewHover;

    @FindBy(xpath = "//div[@class='product-image-container']//a//img[@class='replace-2x img-responsive' and @title='Blouse']/../..//span[contains(text(),'Quick view')]")
    WebElement quickViewClick;

//    WebElement iframeElement = driver.findElement(By.className("fancybox-iframe"));
    @FindBy(className = "fancybox-iframe")
    WebElement iFrameElement;

    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement plusIcon;

    @FindBy(xpath = "//button[@name='Submit']//span[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @FindBy(xpath = "//div[@class='clearfix']//strong[contains(text(),'Quantity')]/../..//span[contains(text(),'$54.00')]")
    WebElement ptcTotal;

    @FindBy(xpath = "//div[@class='clearfix']//strong[contains(text(),'Total products')]/../..//span[contains(text(),'$54.00')]")
    WebElement ptcTotalProducts;

    @FindBy(xpath = "//div[@class='clearfix']//strong[contains(text(),'Total shipping')]/../..//span[contains(text(),'$2.00')]")
    WebElement ptcTotalShipping;

    @FindBy(xpath = "//div[@class='clearfix']//strong[contains(text(),'Total')]/../..//span[contains(text(),'$56.00')]")
    WebElement ptcOverallTotal;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement ptcProceedToCheckOut;

    @FindBy(xpath = "//span[contains(text(),'$27.00')]")
    WebElement summaryUnitPrice;

    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    WebElement summaryQty;

    @FindBy(xpath = "//td[@class='cart_total']")
    WebElement summaryTotal;

    @FindBy(xpath = "//td[@id='total_product']")
    WebElement summaryTotalProduct;

    @FindBy(xpath = "//td[@id='total_shipping']")
    WebElement summaryTotalShipping;

    @FindBy(xpath = "//td[@id='total_price_without_tax']")
    WebElement summaryTotalWithOutTax;

    @FindBy(xpath = "//td[@id='total_tax']")
    WebElement summaryTax;

    @FindBy(xpath = "//span[@id='total_price']")
    WebElement summaryTotalAfterTax;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
    WebElement summaryProceedToCheckOut;

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement addressProceedToCheckOut;

    @FindBy(xpath = "//div[@class='delivery_option_price']")
    WebElement shippingPrice;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement shippingTermAndCondition;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement shippingCarrierProceedToCheckout;

    @FindBy(xpath = "//div[@class='paiement_block']//span[contains(text(),'$27.00')]")
    WebElement paymentUnitPrice;

    @FindBy(xpath = "//div[@class='paiement_block']//td[@class='cart_quantity text-center']//span[contains(text(),'2')]")
    WebElement paymentQty;

    @FindBy(xpath = "//div[@class='paiement_block']//td[@class='cart_total']")
    WebElement paymentTotal;

    @FindBy(xpath = "//div[@class='paiement_block']//td[@id='total_product']")
    WebElement paymentTotalProduct;

    @FindBy(xpath = "//div[@class='paiement_block']//td[@id='total_shipping']")
    WebElement paymentTotalShipping;

    @FindBy(xpath = "//div[@class='paiement_block']//span[@id='total_price']")
    WebElement paymentTotalWithShipping;

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement paymentModeNetBanking;

    @FindBy(xpath = "//span[@id='amount']")
    WebElement confirmAmount;

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrderPayment;

    @FindBy(xpath = "//strong[contains(text(),'$56.00')]")
    WebElement orderFinalAmount;

    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    WebElement backToOrder;

    @FindBy(xpath = "//a[@class='account']")
    WebElement profileName;

    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    WebElement profileOrderHistory;

    @FindBy(xpath = "//span[@class='price']")
    WebElement orderHistoryFinalPrice;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement backToHomePage;

    public void validateHomePage(){
        Assert.assertTrue(homePageLogo.isDisplayed(),"Home Page Logo is absent");
        Assert.assertEquals(headerContactUsWord.getText(),"Contact us","Contact us header word is missing ");
        Assert.assertEquals(footerCategoriesWord.getText(),"Categories","Contact us Categories word is missing ");
    }

    public void signBtnClick(){
        signBtn.click();
    }

    public void validateProductSelect(){
        womenSectionBtn.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(quickViewHover).build().perform();
        quickViewClick.click();
        driver.switchTo().frame(iFrameElement);
        plusIcon.click();
        addToCart.click();
        driver.switchTo().defaultContent();
    }

    public void validateProceedToCheckOut(){
        Assert.assertEquals(ptcTotal.getText(),prop.getProperty("Total"),"Total price is not matching");
        Assert.assertEquals(ptcTotalProducts.getText(),prop.getProperty("TotalProduct"),"Total product price is not matching");
        Assert.assertEquals(ptcTotalShipping.getText(),prop.getProperty("TotalShipping"),"Total shipping price is not matching");
        Assert.assertEquals(ptcOverallTotal.getText(),prop.getProperty("TotalOverall"),"Total overall price is not matching");
        ptcProceedToCheckOut.click();
    }

    public void validateSummary(){
        Assert.assertEquals(summaryUnitPrice.getText(),prop.getProperty("unitPrice"),"Single unit price is not matching");
        Assert.assertEquals(summaryQty.getAttribute("value"),prop.getProperty("Qty"),"Total Qty is not matching");
        Assert.assertEquals(summaryTotal.getText(),prop.getProperty("Total"),"Total price is not matching");
        Assert.assertEquals(summaryTotalProduct.getText(),prop.getProperty("TotalProduct"),"Total product price is not matching");
        Assert.assertEquals(summaryTotalShipping.getText(),prop.getProperty("TotalShipping"),"Total shipping price is not matching");
        Assert.assertEquals(summaryTotalWithOutTax.getText(),prop.getProperty("TotalWithoutTax"),"Total price is not matching");
        Assert.assertEquals(summaryTax.getText(),prop.getProperty("Tax"),"Total Tax price is not matching");
        Assert.assertEquals(summaryTotalAfterTax.getText(),prop.getProperty("TotalOverall"),"Total overall price is not matching");
        summaryProceedToCheckOut.click();
    }

    public void validateAddress(){
        addressProceedToCheckOut.click();
    }

    public void validateShipping(){
        Assert.assertEquals(shippingPrice.getText(),prop.getProperty("TotalShipping"),"Total shipping price is not matching");
        shippingTermAndCondition.click();
        shippingCarrierProceedToCheckout.click();
    }

    public void validatePayment(){

        Assert.assertEquals(paymentUnitPrice.getText(),prop.getProperty("unitPrice"),"Total unit price is not matching");
        Assert.assertEquals(paymentQty.getText(),prop.getProperty("Qty"),"Total qty price is not matching");
        Assert.assertEquals(paymentTotal.getText(),prop.getProperty("Total"),"Total price is not matching");
        Assert.assertEquals(paymentTotalProduct.getText(),prop.getProperty("TotalProduct"),"Total product price is not matching");
        Assert.assertEquals(paymentTotalShipping.getText(),prop.getProperty("TotalShipping"),"Total shipping price is not matching");
        Assert.assertEquals(paymentTotalWithShipping.getText(),prop.getProperty("TotalOverall"),"Total overall price is not matching");

        paymentModeNetBanking.click();
        Assert.assertEquals(confirmAmount.getText(),prop.getProperty("TotalOverall"),"Total overall price is not matching");
        confirmOrderPayment.click();
        Assert.assertEquals(orderFinalAmount.getText(),prop.getProperty("TotalOverall"),"Total price overall is not matching");
        backToOrder.click();

    }

    public void validateProfileOrderAmountCheck(){
        profileName.click();
        profileOrderHistory.click();
        Assert.assertEquals(orderHistoryFinalPrice.getText(),prop.getProperty("TotalOverall"),"Total overall price is not matching");
        backToHomePage.click();
        signOutBtn.click();
    }

}
