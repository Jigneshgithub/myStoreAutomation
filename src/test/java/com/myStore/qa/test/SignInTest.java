package com.myStore.qa.test;

import com.myStore.qa.base.TestBase;
import com.myStore.qa.pages.HomePage;
import com.myStore.qa.pages.SignIn;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends TestBase {

    HomePage homePage;
    SignIn signIn;

    public SignInTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        signIn = new SignIn();
        homePage.signBtnClick();
    }

    @Test(priority = 1)
    public void validateSignInHeaderTest() {
        signIn.validateSingInHeader();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
