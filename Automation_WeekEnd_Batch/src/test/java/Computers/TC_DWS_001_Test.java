package Computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenersUtility;
import objectrepositary.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_001_Test extends BaseClass{
	public void clickOnComputer() {
		HomePage hp=new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(),"Demo WebShop. Computers", "Cpmputers page is not diplayed");
		test.log(Status.PASS, "Computers Page is displayed");
	}
}
