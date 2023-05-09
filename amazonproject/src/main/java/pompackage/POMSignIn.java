package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMSignIn extends BaseClass {
	// Object Respository
	@FindBy(css = "#ap_customer_name")
	WebElement Username;

	public POMSignIn() {
		PageFactory.initElements(driver, this);
		driver.get(
				"https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fref%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
}
