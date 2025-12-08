package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPOJO;
import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="Valid First Time User logs into the application")
	public void setup()
	{
		myAccountPage=homePage.goToLoginPage().doLoginWith("taparev945@okcdeals.com", "pass@111");
		address=FakeAddressUtility.getFakeAddress();
	}
	
	
	@Test
	public void addNewAddress()
	{
		
		String newAddress =myAccountPage.goToAddAddressPage().saveAddress(address);
		
		Assert.assertEquals(newAddress,address.getAddressAlias().toUpperCase());
		
	}

}
