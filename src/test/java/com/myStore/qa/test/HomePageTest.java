package com.myStore.qa.test;

import com.myStore.qa.base.TestBase;
import com.myStore.qa.pages.HomePage;
import com.myStore.qa.pages.SignIn;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {

    HomePage homePage;
    SignIn signIn;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        signIn = new SignIn();
    }

    @Test(priority = 1)
    public void validateHomePageTest(){
        homePage.validateHomePage();
    }
    @Test(priority = 2)
    public void logInWithNewCredentialTest(){
        homePage.signBtnClick();
        signIn.logInWithNewCredentialSignIn();
    }

    @Test(priority = 3)
    public void orderFlowTest(){
        homePage.signBtnClick();
        signIn.logInWithNewCredentialSignIn();
        homePage.validateProductSelect();
        homePage.validateProceedToCheckOut();
        homePage.validateSummary();
        homePage.validateAddress();
        homePage.validateShipping();
        homePage.validatePayment();
        homePage.validateProfileOrderAmountCheck();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
