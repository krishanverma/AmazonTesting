package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonclasses.BaseClass;
import pompackage.POMYourAccount;

public class YourAccountTest extends BaseClass {
	POMYourAccount youraccountObj;

	public YourAccountTest() {
		super();
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		youraccountObj = new POMYourAccount();

	}

	@Test
	public void TitleCheck() {
		String title = youraccountObj.verifyTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Your Account");
	}

	@Test
	public void TC2_Hello_hover() {
		youraccountObj.hoverOverAccountsBtn();
		Assert.assertTrue(youraccountObj.YourAccountAndListFlyoutDisplayed());
	}

	@AfterMethod
	public void close() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
	}
}