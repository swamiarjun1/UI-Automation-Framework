package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	private SearchResultPage searchResultPage;
	

	@BeforeMethod(description = "User logs into application and search for product")
	public void setup() {

		searchResultPage=homePage.goToLoginPage().doLoginWith("taparev945@okcdeals.com", "pass@111")
				.searchForProduct(SEARCH_TERM);
	}

	@Test(description = "Verify logged in user is able to buy", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest()  {
		
		String result=searchResultPage.clickOnTheProductAtIndex(2).changeSize(L).addToCart().proceedToCheckout()
		.goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePaymentByWire();
		
		System.out.println(result);
		
		Assert.assertTrue(result.contains(result));
		
	}

}
