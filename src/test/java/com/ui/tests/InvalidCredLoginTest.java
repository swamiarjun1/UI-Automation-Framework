package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredLoginTest extends TestBase {

	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADRESS="arjun@gmail.com";
	private static final String INVALID_PASSWORD="pass1234";



	@Test(description = "Verify Invalid Credentials Error message", groups = { "e2e", "sanity","smoke" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADRESS,INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
		
	}
	
	

}
