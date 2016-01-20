package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_Occupations_Claim_page {

	private static WebElement element = null;
	
	public static WebElement btn_OccupationTab(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_OccupationsTab_cell']");
	   element = driver.findElement(By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_OccupationsTab_cell']"));
	   return element;
	   }
	 
	public static WebElement btn_AddOccupation(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		Waitutil.waituntilvisible(driver, "*[id^='OccupationListviewWidget'][id$='_OccupationList_cmdAdd']");
		element = driver.findElement(By.cssSelector("*[id^='OccupationListviewWidget'][id$='_OccupationList_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
	 
	public static WebElement chk_SelfEmployed(WebDriver driver){
		Waitutil.waituntilclickabale(driver, "*[id^='AddOccupationDetailsWidget_'][id$='_Self_Employed_CHECKBOX']");
		element = driver.findElement( By.cssSelector("*[id^='AddOccupationDetailsWidget_'][id$='_Self_Employed_CHECKBOX']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}	
	
	public static WebElement btn_OKButton(WebDriver driver){
		Waitutil.waituntilclickabale(driver, "*[id^='p'][id$='_editPageSave_cloned']");
		element = driver.findElement( By.cssSelector("*[id^='p'][id$='_editPageSave_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}	
	 
	public static WebElement btn_SetAsPrimary(WebDriver driver){
		Waitutil.waituntilclickabale(driver, "*[id^='OccupationListviewWidget_'][id$='_SetAsPrimary']");
		element = driver.findElement( By.cssSelector("*[id^='OccupationListviewWidget_'][id$='_SetAsPrimary']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}	
	public static WebElement sel_SelectPDI(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='DatedEarningsListviewWidget_'][id$='_earningsTypeEnumDropDownBean']");
		element = driver.findElement( By.cssSelector("*[id^='DatedEarningsListviewWidget_'][id$='_earningsTypeEnumDropDownBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
			}	
}