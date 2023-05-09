package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonclasses.BaseClass;
import pompackage.POMSignUp;

public class SignUpTest extends BaseClass {
	POMSignUp signupObj;
	public SignUpTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiate();
		signupObj = new POMSignUp();
		
	}
	
	@Test
	public void TitleCheck() {
		String title = signupObj.verifyTitle();
		System.out.println("Title is "+title);
		Assert.assertEquals(title, "Amazon Registration");
	}
	@Test
	public void TC1_valid_name() {
		signupObj.typeUsername("John Doe");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getUsernameAlert(), "");
		
	}
	
	@Test
	public void TC2_empty_your_name_field() {
		signupObj.typeUsername("");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getUsernameAlert(), "Enter your name");
	}
	
	@Test
	public void TC3_valid_mobile_number() {
		signupObj.typeEmailOrNumber("9876543210");
		signupObj.typePassword("");
		signupObj.getContinueBtnText();
		Assert.assertEquals(signupObj.getContinueBtnText(), "Verify mobile number");
	}
	
	@Test
	public void TC4_invalid_mobile_number(){
		signupObj.typeEmailOrNumber("9");
		signupObj.typePassword("");
		signupObj.getContinueBtnText();
		Assert.assertEquals(signupObj.getContinueBtnText(), "Verify mobile number");
	}
	@Test
	public void TC5_partial_mobile_number() {
		signupObj.typeEmailOrNumber("987");
		signupObj.typePassword("");
		signupObj.getContinueBtnText();
		Assert.assertEquals(signupObj.getContinueBtnText(), "Verify mobile number");
	}
	@Test
	public void TC6_empty_mobile_number_field() {
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getEmailOrNumberAlertText(), "Enter your e-mail address or mobile phone number");
	}
	@Test
	public void TC7_valid_email() {
		signupObj.typeEmailOrNumber("johndoe@gmail.com");
		signupObj.typePassword("");
		signupObj.getContinueBtnText();
		Assert.assertEquals(signupObj.getContinueBtnText(), "Verify email");
	}
	@Test
	public void TC8_invalid_email() {
		signupObj.typeEmailOrNumber("jd2%");
		signupObj.typePassword("");
		signupObj.getContinueBtnText();
		Assert.assertEquals(signupObj.getContinueBtnText(), "Verify email");
	}
	@Test
	public void TC9_invalid_password_less_than_6_characters() {
		signupObj.typePassword("abc");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getPasswordAlertText(), "Minimum 6 characters required");
	}
	@Test
	public void TC10_valid_password_of_6_characters(){
		signupObj.typePassword("abcdef");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getPasswordAlertText(), "");
	}
	@Test
	public void TC11_valid_password_more_than_6_characters() {
		signupObj.typePassword("abcdefg");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getPasswordAlertText(), "");
	}
	@Test
	public void TC12_same_password_in_password_again_field() {
		signupObj.typePassword("abcdef");
		signupObj.typePasswordAgain("abcdef");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getPasswordAlertText(), "");
	}
	@Test
	public void TC13_different_password_in_password_again_field() {
		signupObj.typePassword("abcdef");
		signupObj.typePasswordAgain("xyzd");
		signupObj.clickContinueBtn();
		Assert.assertEquals(signupObj.getPasswordAgainAlertText(), "Passwords do not match");
	}
	@Test
	public void TC14_all_valid_information_new_account() {
		signupObj.typeUsername("John Doe");
		signupObj.typeEmailOrNumber("johndoe@gmail.com");
		signupObj.typePassword("abcdef");
		signupObj.typePasswordAgain("abcdef");
		signupObj.clickContinueBtn();
		//Assert to check valid information and OTP request here
	}
	@Test
	public void TC15_all_valid_information_existing_account() {
		signupObj.typeUsername("John Doe");
		signupObj.typeEmailOrNumber("johndoe@gmail.com");
		signupObj.typePassword("abcdef");
		signupObj.typePasswordAgain("abcdef");
		signupObj.clickContinueBtn();
		Assert.assertTrue(signupObj.isExistingAccount());
	}
	
	
	
	@AfterMethod
	public void close() {
		/*
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		driver.close();
	}
}
