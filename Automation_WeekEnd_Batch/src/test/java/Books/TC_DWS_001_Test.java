package Books;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenersUtility;
import objectrepositary.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_001_Test extends BaseClass{
	public void clickOnBook() {
		HomePage hp=new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(),"Demo WebShop. Books", "Books page is not diplayed");
		test.log(Status.PASS, "Books Page is displayed");
	}
}
