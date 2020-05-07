package com.myStore.qa.pages;

import com.myStore.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignIn extends TestBase {

    public SignIn(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    WebElement createAnAccountWord;

    @FindBy(xpath = "//form[@id='create-account_form']//label[contains(text(),'Email address')]")
    WebElement emailWord;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreateInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement emailCreateSubmitBtn;

    @FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
    WebElement alreadyRegisterWord;

    @FindBy(xpath = "//form[@id='login_form']//label[contains(text(),'Email address')]")
    WebElement loginEmailHeader;

    @FindBy(xpath = "//input[@id='email']")
    WebElement loginEmailInput;

    @FindBy(xpath = "//label[contains(text(),'Password')]")
    WebElement loginPasswordHeader;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement loginSubmitBtn;



    public void validateSingInHeader(){
        Assert.assertEquals(createAnAccountWord.getText(),"CREATE AN ACCOUNT","Create an account word is absent in sign in page");
        Assert.assertEquals(emailWord.getText(),"Email address","Email address word is absent in sign in page");

    }

    public PersonalInfo createAccountClick(){
        emailCreateInput.sendKeys(prop.getProperty("username"));
        emailCreateSubmitBtn.click();
        return new PersonalInfo();
    }

    public void logInWithNewCredentialSignIn(){
        Assert.assertTrue(alreadyRegisterWord.isDisplayed(),"");
        Assert.assertTrue(loginEmailHeader.isDisplayed(),"");
        loginEmailInput.sendKeys(prop.getProperty("username"));
        Assert.assertTrue(loginPasswordHeader.isDisplayed(),"");
        loginPasswordInput.sendKeys(prop.getProperty("password"));
        loginSubmitBtn.click();

        new HomePage();
    }








}
