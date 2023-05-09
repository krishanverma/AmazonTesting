package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonclasses.BaseClass;

public class POMYourAccount extends BaseClass {
	// Object Respository
	@FindBy(css = "#nav-link-accountList")
	WebElement AccountsAndListsBtn;

	@FindBy(css = "#nav-al-your-account > a:nth-child(2) > span")
	WebElement YourAccountBtn;

	@FindBy(css = "#nav-flyout-accountList")
	WebElement AccountAndListsFlyout;

	@FindBy(css = "#a-page > div.a-container > div > div.a-row.a-spacing-base > h1")
	WebElement YourAccountPageHeading;

	public POMYourAccount() {
		PageFactory.initElements(driver, this);
		driver.get("https://www.amazon.ca/gp/css/homepage.html?ref_=nav_AccountFlyout_ya");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void hoverOverAccountsBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(AccountsAndListsBtn).build().perform();
	}

	public void clickYourAccountBtn() {
		hoverOverAccountsBtn();
		YourAccountBtn.click();
	}

	public Boolean YourAccountPageDisplayed() {
		if (YourAccountPageHeading.isDisplayed())
			return true;
		else
			return false;
	}
	public Boolean YourAccountAndListFlyoutDisplayed() {
		if(AccountAndListsFlyout.isDisplayed())
			return true;
		else
			return false;
	}
	public String verifyTitle() {
		return driver.getTitle();
	}
}
