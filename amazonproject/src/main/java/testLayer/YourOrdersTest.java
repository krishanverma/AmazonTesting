package testLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonclasses.BaseClass;
import pompackage.POMYourOrders;

public class YourOrdersTest extends BaseClass{
	POMYourOrders yourordersObj;

	public YourOrdersTest() {
		super();
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		yourordersObj = new POMYourOrders();

	}

	@Test
	public void TitleCheck() {
		String title = yourordersObj.verifyTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Your Orders");
	}
}
