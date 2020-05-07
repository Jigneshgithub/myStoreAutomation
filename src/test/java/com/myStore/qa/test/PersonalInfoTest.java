package com.myStore.qa.test;

import com.myStore.qa.base.TestBase;
import com.myStore.qa.pages.HomePage;
import com.myStore.qa.pages.PersonalInfo;
import com.myStore.qa.pages.SignIn;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTest extends TestBase {

    HomePage homePage;
    SignIn signIn;
    PersonalInfo personalInfo;

    public PersonalInfoTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        signIn = new SignIn();
        personalInfo = new PersonalInfo();
        homePage.signBtnClick();
        signIn.validateSingInHeader();
        personalInfo = signIn.createAccountClick();

    }

    @Test(priority = 1)
    public void validatePersonalInfoPageTest(){
        personalInfo.validatePersonalInfoPage();
    }

    @Test(priority = 2)
    public void fillPersonalDetailsTest() throws InterruptedException {
        personalInfo.fillPersonalDetails();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
