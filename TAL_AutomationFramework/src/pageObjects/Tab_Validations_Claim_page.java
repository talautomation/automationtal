package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_Validations_Claim_page {

	private static WebElement element = null;
	
	public static WebElement tab_Validations(WebDriver driver) throws InterruptedException{
	   Thread.sleep(3000);
	   element = driver.findElement(By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_Validations_cell']"));
	   utility.Waitutil.implicitwait(driver);
	   return element;
	   }
	 
	public static WebElement chk_ValidationsCheckbox(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='ValidationsListViewWidget_'][id$='_ValidationList_MasterMultiSelectCB_CHECKBOX']");
		element = driver.findElement(By.cssSelector("*[id^='ValidationsListViewWidget_'][id$='_ValidationList_MasterMultiSelectCB_CHECKBOX']"));
		utility.Waitutil.implicitwait(driver);
		   return element;
		   }
	 
	public static WebElement btn_ValidationsSuppressButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("*[id^='ValidationsListViewWidget_'][id$='_suppressButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
	 
	public static WebElement btn_OKValidationsSuppressButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("*[id^='SuppressCaseValidationPopupWidget_'][id$='_okButtonBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
	
}