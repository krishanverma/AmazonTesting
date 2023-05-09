package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMYourAccount extends BaseClass {
	// Object Respository
	@FindBy(css = "#ap_customer_name")
	WebElement Username;

	public POMYourAccount() {
		PageFactory.initElements(driver, this);
		driver.get(
				"https://www.amazon.ca/gp/css/homepage.html?ref_=nav_AccountFlyout_ya");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}
