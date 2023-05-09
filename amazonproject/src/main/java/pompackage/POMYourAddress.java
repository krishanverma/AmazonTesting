package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMYourAddress extends BaseClass {
	// Object Respository
	@FindBy(css = "#ap_customer_name")
	WebElement Username;

	public POMYourAddress() {
		PageFactory.initElements(driver, this);
		driver.get("https://www.amazon.ca/a/addresses?ref_=ya_d_c_addr");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}
