package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	
	@BeforeMethod(description="Valid User logs into the application")
	public void setup()
	{
		myAccountPage=homePage.goToLoginPage().doLoginWith("taparev945@okcdeals.com", "pass@111");
		
	}
	
	@Test(description="Verify product search and correct result are displayed",groups= {"e2e","smoke","sanity"})
	public void verifyProductSearchTest() {
		
	boolean actualResult=myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInPrudctList(SEARCH_TERM);
	
	Assert.assertEquals(actualResult, true);
		
	}
}
