package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMSignIn extends BaseClass {
	// Object Respository
	@FindBy(css = "#ap_email")
	WebElement MobileNumberOrEmail;

	@FindBy(css = "#continue")
	WebElement ContinueBtn;

	@FindBy(css = "#ap_password")
	WebElement Password;

	@FindBy(css = "#auth-error-message-box > div > div > ul > li > span")
	WebElement IncorrectMobNumOrEmailAlert;

	@FindBy(css = "#auth-email-missing-alert > div > div")
	WebElement EmptyMobNumOrEmailAlert;

	@FindBy(css = "#auth-password-missing-alert > div > div")
	WebElement emptyPasswordAlert;

	@FindBy(css = "#auth-error-message-box > div > div > ul > li > span")
	WebElement incorrectPasswordAlert;

	@FindBy(css = "#signInSubmit")
	WebElement SignInBtn;

	public POMSignIn() {
		PageFactory.initElements(driver, this);
		driver.get(
				"https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fref%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	public void typeMobileNumberOrEmail(String mobOrEmail) {
		MobileNumberOrEmail.sendKeys(mobOrEmail);
	}

	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}

	public Boolean passwordFieldDisplayed() {
		if (Password.isDisplayed())
			return true;
		else
			return false;
	}

	public Boolean incorrectMobOrEmailAlertDisplayed() {
		if (IncorrectMobNumOrEmailAlert.isDisplayed())
			return true;
		else
			return false;
	}

	public Boolean emptyMobOrEmailAlertDisplyed() {
		if (EmptyMobNumOrEmailAlert.isDisplayed())
			return true;
		else
			return false;
	}

	public Boolean emptyPasswordAlertDisplayed() {
		if (emptyPasswordAlert.isDisplayed())
			return true;
		else
			return false;
	}

	public Boolean incorrectPasswordAlertDisplayed() {
		if (incorrectPasswordAlert.isDisplayed())
			return true;
		else
			return false;

	}

	public void clickContinueBtn() {
		ContinueBtn.click();
	}

	public void clickSignInBtn() {
		SignInBtn.click();
	}
}
