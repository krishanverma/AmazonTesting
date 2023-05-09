package pompackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMSignUp extends BaseClass {
	// Object Respository

	@FindBy(css = "#ap_customer_name")
	WebElement Username;

	@FindBy(css = "#auth-customerName-missing-alert > div > div")
	WebElement UsernameAlert;

	@FindBy(css = "#ap_email")
	WebElement EmailOrNumber;

	@FindBy(css = "#auth-email-missing-alert > div > div")
	WebElement EmailOrNumberAlert;

	@FindBy(css = "#ap_password")
	WebElement Password;

	@FindBy(css = "#auth-password-invalid-password-alert > div > div")
	WebElement PasswordAlert;

	@FindBy(css = "#ap_password_check")
	WebElement PasswordAgain;
	
	@FindBy(css = "#auth-password-mismatch-alert > div > div")
	WebElement PasswordAgainAlert;

	@FindBy(css = "#continue")
	WebElement ContinueBtn;

	@FindBy(css = "#auth-continue-announce")
	WebElement ContinueBtnTextSpan;
	
	@FindBy(css = "#authportal-main-section > div:nth-child(2) > div > div.a-section.a-spacing-large > div > div > h4")
	WebElement ExistingAccountAlert;

	public POMSignUp() {
		PageFactory.initElements(driver, this);
		driver.get(
				"https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void typeUsername(String uname) {
		Username.sendKeys(uname);
	}

	public String getUsernameAlert() {
		return UsernameAlert.getText();
	}

	public void typeEmailOrNumber(String EmailOrNum) {
		EmailOrNumber.sendKeys(EmailOrNum);
	}

	public String getEmailOrNumberAlertText() {
		return EmailOrNumberAlert.getText();
	}

	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}

	public String getPasswordAlertText() {
		return PasswordAlert.getText();
	}

	public void typePasswordAgain(String pass) {
		PasswordAgain.sendKeys(pass);
	}
	
	public String getPasswordAgainAlertText() {
		return PasswordAgainAlert.getText();
	}

	public void clickContinueBtn() {
		ContinueBtn.click();
	}

	public String getContinueBtnText() {

		List<WebElement> webEleList = ContinueBtnTextSpan.findElements(By.xpath(".//*"));
		WebElement displayedElement = null;
		for (int i = 0; i < webEleList.size(); i++) {
			WebElement elem = webEleList.get(i);
			if (elem.isDisplayed()) {
				displayedElement = elem;
			}
		}
		return "" + displayedElement.getText();

	}
	
	public Boolean isExistingAccount() {
		if(ExistingAccountAlert.isDisplayed())
			return true;
		else
			return false;
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

}