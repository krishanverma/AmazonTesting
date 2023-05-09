package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMYourOrders extends BaseClass {

	// Object Respository
	@FindBy(css = "#ap_customer_name")
	WebElement Username;

	public POMYourOrders() {
		PageFactory.initElements(driver, this);
		driver.get("https://www.amazon.ca/gp/your-account/order-history?ref_=ya_d_c_yo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}
