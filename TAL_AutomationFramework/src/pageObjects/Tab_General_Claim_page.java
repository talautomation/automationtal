package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_General_Claim_page {

	private static WebElement element = null;
	
	public static WebElement btn_ClaimDetails_Edit(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='ClaimGeneralWidget'][id$='com.fineos.claims.generaldetails.ClaimGeneralWidgetEDIT_LINKEDIT_BUTTONClaim_Details']");
	   element = driver.findElement(By.cssSelector("*[id^='ClaimGeneralWidget'][id$='com.fineos.claims.generaldetails.ClaimGeneralWidgetEDIT_LINKEDIT_BUTTONClaim_Details']"));
	   utility.Waitutil.implicitwait(driver);
	   return element;
	   }
	 
	public static WebElement sel_RiskCategory(WebDriver driver){
		Waitutil.waituntilvisible(driver, "*[id^='CaseDetails_'][id$='_CaseComplexityDropDownBean']");
		element = driver.findElement(By.cssSelector("*[id^='CaseDetails_'][id$='_CaseComplexityDropDownBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
	 
	public static WebElement btn_OK(WebDriver driver){
		Waitutil.waituntilclickabale(driver, "*[id^='p'][id$='_editPageSave_cloned']");
		element = driver.findElement( By.cssSelector("*[id^='p'][id$='_editPageSave_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}	
}