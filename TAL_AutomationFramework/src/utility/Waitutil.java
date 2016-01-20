package utility;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class Waitutil {
	
	public static WebDriverWait waittime(WebDriver driver){
			
		//return new WebDriverWait (driver, 10);
		WebDriverWait webWait = new WebDriverWait (driver, 1000);
		webWait.withTimeout(10, TimeUnit.SECONDS);
		webWait.pollingEvery(500, TimeUnit.MILLISECONDS);
		return webWait;
		
	}
	
	
	public static void waituntilclickabale(WebDriver driver, String cssselector){
		
		Waitutil.waittime(driver).until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssselector)));
		
	}
	
	public static void waituntilvisible(WebDriver driver, String cssselector){
		
		Waitutil.waittime(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssselector)));
		
			
	}
	
	
	public static void implicitwait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void pageloadwait(WebDriver driver) {
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		
	}
	
	
	

}
