package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
		public void getSize(WebDriver driver) {
		driver.manage().window().getSize();
	}

	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void DragandDrop(WebDriver driver,WebElement element,WebElement element1) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element1).perform();
	}

	public void selectDropDown(String text ,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void getScreenShot(WebDriver driver) throws IOException {
		JAVAUtility jutil=new JAVAUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./ScreenShots/Picture"+jutil.getSystemTime()+".png");
		FileHandler.copy(temp, perm);
		
	}
	
	public void switchToWindow(WebDriver driver, String expUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(expUrl));
			break;
		}
	}
}
