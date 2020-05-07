package com.myStore.qa.pages;

import com.myStore.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PersonalInfo extends TestBase {

    public PersonalInfo(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Create an account')]")
    WebElement createAccountHeader;

    @FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
    WebElement personalInfoHeader;

    @FindBy(xpath = "//label[contains(text(),'Title')]")
    WebElement titleWord;

    @FindBy(xpath = "//label[@for='id_gender1']")
    WebElement mrsSelectBtn;

    @FindBy(xpath = "//label[@for='customer_firstname']")
    WebElement firstNameHeader;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameInput;

    @FindBy(xpath = "//label[@for='customer_lastname']")
    WebElement lastNameHeader;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = "//label[contains(text(),'Email')]")
    WebElement emailHeader;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//label[contains(text(),'Password')]")
    WebElement passwordHeader;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordInput;

    @
    FindBy(xpath = "//label[contains(text(),'Date of Birth')]")
    WebElement dobHeader;

    @FindBy(xpath = "//select[@id='days']")
    WebElement selectDayClick;

    @FindBy(xpath = "//select[@id='days']//option[@value='3']")
    WebElement selectDayInputClick;

    @FindBy(xpath = "//select[@id='months']")
    WebElement selectMonthClick;

    @FindBy(xpath = "//select[@id='months']//option[@value='5']")
    WebElement selectMonthInputClick;

    @FindBy(xpath = "//select[@id='years']")
    WebElement selectYearClick;

    @FindBy(xpath = "//select[@id='years']//option[@value='1994']")
    WebElement selectYearInputClick;

    @FindBy(xpath = "//h3[contains(text(),'Your address')]")
    WebElement yourAddressHeader;

    @FindBy(xpath = "//label[@for='firstname']")
    WebElement addFirstNameHeader;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement addFirstNameInput;

    @FindBy(xpath = "//label[@for='lastname']")
    WebElement addLastNameHeader;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement addLastNameInput;

    @FindBy(xpath = "//label[@for='address1']")
    WebElement addressLine1Header;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLine1Input; // 200 Dutch Meadows Ln

    @FindBy(xpath = "//label[@for='address2']")
    WebElement addressLine2Header;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement addressLine2Input; //  Glenville NY

    @FindBy(xpath = "//label[contains(text(),'City')]")
    WebElement addCityHeader;

    @FindBy(xpath = "//input[@id='city']")
    WebElement addCityInput;

    @FindBy(xpath = "//label[contains(text(),'State')]")
    WebElement addStateHeader;

    @FindBy(xpath = "//select[@id='id_state']")
    WebElement addSelectStateClick;

    @FindBy(xpath = "//select[@id='id_state']//option[contains(text(),'New York')]")
    WebElement addSelectStateInputClick;

    @FindBy(xpath = "//label[contains(text(),'Zip')]")
    WebElement addZipHeader;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement addZipInput; // 12302

    @FindBy(xpath = "//label[contains(text(),'Country')]")
    WebElement addCountryHeader;

    @FindBy(xpath = "//label[contains(text(),'Mobile phone')]")
    WebElement addMobileNumberHeader;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement addMobileNumberInput; // 210-849-2532

    @FindBy(xpath = "//label[contains(text(),'Assign an address alias for future reference.')]")
    WebElement addFutureReferenceHeader;

    @FindBy(xpath = "//input[@id='alias']")
    WebElement addFutureReferenceInput;  //5360 Southwestern

    @FindBy(xpath = "//button[@name='submitAccount']")
    WebElement registerBtn;

    @FindBy(xpath = "//span[contains(text(),'Required field')]")
    WebElement requiredFieldHeader;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement addAlertPopUp;


    public void validatePersonalInfoPage(){
        Assert.assertTrue(createAccountHeader.isDisplayed(),"Create Account word is not matching");
        Assert.assertTrue(personalInfoHeader.isDisplayed(),"Your personal information word is not matching");
    }

    public void fillPersonalDetails() throws InterruptedException {
        Assert.assertTrue(titleWord.isDisplayed(),"Title word is not matching");
        mrsSelectBtn.click();
        Assert.assertTrue(firstNameHeader.isDisplayed(),"First Name word is not matching");
        firstNameInput.sendKeys(prop.getProperty("firstName"));
        Assert.assertTrue(lastNameHeader.isDisplayed(),"Last Name word is not matching");
        lastNameInput.sendKeys(prop.getProperty("lastName"));
        Assert.assertTrue(emailHeader.isDisplayed(),"Email  word is not matching");
        Assert.assertEquals(emailInput.getAttribute("value"),prop.getProperty("username"),"Email word is not matching");
        Assert.assertTrue(passwordHeader.isDisplayed(),"Password word is not matching");
        passwordInput.sendKeys(prop.getProperty("password"));
        Assert.assertTrue(dobHeader.isDisplayed(),"DOB word is not matching");
        selectDayClick.click();
        selectDayInputClick.click();
        selectMonthClick.click();
        selectMonthInputClick.click();
        selectYearClick.click();
        selectYearInputClick.click();

        Assert.assertTrue(yourAddressHeader.isDisplayed(),"Title word is not matching");
        Assert.assertTrue(addFirstNameHeader.isDisplayed(),"First name word is not matching");
        Assert.assertEquals(addFirstNameInput.getAttribute("value"),prop.getProperty("firstName"),"");
        Assert.assertTrue(addLastNameHeader.isDisplayed(),"Last name word is not matching");
        Assert.assertEquals(addLastNameInput.getAttribute("value"),prop.getProperty("lastName"),"");
        Assert.assertTrue(addressLine1Header.isDisplayed(),"Address1 word is not matching");
        addressLine1Input.sendKeys(prop.getProperty("Address1"));
        Assert.assertTrue(addressLine2Header.isDisplayed(),"Address2 word is not matching");
        addressLine2Input.sendKeys(prop.getProperty("Address2"));
        Assert.assertTrue(addCityHeader.isDisplayed(),"City word is not matching");
        addCityInput.sendKeys(prop.getProperty("City"));
        Assert.assertTrue(addStateHeader.isDisplayed(),"State word is not matching");
        addSelectStateClick.click();
        addSelectStateInputClick.click();
        Assert.assertTrue(addZipHeader.isDisplayed(),"Zip word is not matching");
        addZipInput.sendKeys(prop.getProperty("ZipCode"));
        Assert.assertTrue(addCountryHeader.isDisplayed(),"Country word is not matching");
        Assert.assertTrue(addMobileNumberHeader.isDisplayed(),"Mobile no word is not matching");
        Assert.assertTrue(addFutureReferenceHeader.isDisplayed(),"Future Reference Address word is not matching");
        addFutureReferenceInput.sendKeys(prop.getProperty("FutureRef"));

        Assert.assertTrue(requiredFieldHeader.isDisplayed(),"Required field header word is not matching");

        registerBtn.click();

        Thread.sleep(2000);

        Assert.assertTrue(addAlertPopUp.isDisplayed(),"Alert pop up is absent");

        passwordInput.sendKeys(prop.getProperty("password"));
        addMobileNumberInput.sendKeys(prop.getProperty("MobileNo"));
        registerBtn.click();






    }



























}
