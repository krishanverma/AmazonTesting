package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonclasses.BaseClass;
import pompackage.POMSignIn;

public class SignInTest extends BaseClass {
	POMSignIn signinObj;

	public SignInTest() {
		super();
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		signinObj = new POMSignIn();

	}

	@Test(enabled = false)
	public void TitleCheck() {
		String title = signinObj.verifyTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Amazon Sign In");
	}

	@Test(enabled = false)
	public void TC1_valid_mobile_number() {
		signinObj.typeMobileNumberOrEmail("9876543210");
		signinObj.clickContinueBtn();
		Assert.assertTrue(signinObj.passwordFieldDisplayed());
	}

	@Test(enabled = false)
	public void TC2_valid_email() {
		signinObj.typeMobileNumberOrEmail("vermakrishan337@gmail.com");
		signinObj.clickContinueBtn();
		Assert.assertTrue(signinObj.passwordFieldDisplayed());
	}

	@Test(enabled = false)
	public void TC3_invalid_mobile_number() {
		signinObj.typeMobileNumberOrEmail("123");
		signinObj.clickContinueBtn();
		Assert.assertTrue(signinObj.incorrectMobOrEmailAlertDisplayed());
	}

	@Test(enabled = false)
	public void TC4_invalid_email() {
		signinObj.typeMobileNumberOrEmail("xyz@asdj.co");
		signinObj.clickContinueBtn();
		Assert.assertTrue(signinObj.incorrectMobOrEmailAlertDisplayed());
	}

	@Test(enabled = false)
	public void TC5_empty_mobile_number_or_email() {
		signinObj.clickContinueBtn();
		Assert.assertTrue(signinObj.emptyMobOrEmailAlertDisplyed());
	}

	@Test(enabled = false)
	public void TC6_empty_password_field() {
		signinObj.typeMobileNumberOrEmail("vermakrishan337@gmail.com");
		signinObj.clickContinueBtn();
		signinObj.clickSignInBtn();
		Assert.assertTrue(signinObj.emptyPasswordAlertDisplayed());
	}

	@Test(enabled = false)
	public void TC7_incorrect_password() {
		signinObj.typeMobileNumberOrEmail("vermakrishan337@gmail.com");
		signinObj.clickContinueBtn();
		signinObj.typePassword("incorrect");
		signinObj.clickSignInBtn();
		Assert.assertTrue(signinObj.incorrectPasswordAlertDisplayed());
	}

	@Test
	public void TC8_correct_id_and_password() {
		signinObj.typeMobileNumberOrEmail("vermakrishan337@gmail.com");
		signinObj.clickContinueBtn();
		signinObj.typePassword("password");
		// Type correct password here
		signinObj.clickSignInBtn();
		Assert.assertTrue(!signinObj.incorrectPasswordAlertDisplayed());
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
