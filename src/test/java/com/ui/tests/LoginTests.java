package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTests extends TestBase {

	
	Logger logger=LoggerUtility.getLogger(this.getClass());




	@Test(description = "Verify valid user is able to login", groups = { "e2e", "sanity" },
	dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider"
	)
	public void loginTest(User user) {

		//String userName = homePage.goToLoginPage().doLoginWith("taparev945@okcdeals.com", "pass@111").getUserName();
		//assertEquals(homePage.goToLoginPage().doLoginWith("taparev945@okcdeals.com", "pass@111").getUserName(), "Arjun Swami");
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Arjun Swami");
	}
	
	/*
	
	@Test(description = "Verify valid user is able to login", groups = { "e2e", "sanity" },
	dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestCSVDataProvider"
	)
	public void loginCSVTest(User user) {		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Arjun Swami");
	}
	
	
	@Test(description = "Verify valid user is able to login", groups = { "e2e", "sanity" },
	dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestExcelDataProvider",
	retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
	)
	public void loginExcelTest(User user) {	
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Arjun Swami1");

	}
	*/
	
	
	
	
	

}
