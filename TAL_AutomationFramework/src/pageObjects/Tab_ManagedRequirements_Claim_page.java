package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_ManagedRequirements_Claim_page {
	
	private static WebElement element = null;
	
	public static WebElement tab_ManagedRequirements(WebDriver driver){
	   element = driver.findElement(By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_Managed_Requirements_cell']"));
	   utility.Waitutil.implicitwait(driver);
	   return element;
	   }
	 
	public static WebElement chk_OpenManagedRequirement(WebDriver driver){
		Waitutil.waituntilclickabale(driver, "*[id^='OpenManagedRequirementsListviewWidget_'][id$='_OpenManagedRequirementsListview_MasterMultiSelectCB_CHECKBOX']");
		element = driver.findElement(By.cssSelector("*[id^='OpenManagedRequirementsListviewWidget_'][id$='_OpenManagedRequirementsListview_MasterMultiSelectCB_CHECKBOX']"));
		utility.Waitutil.implicitwait(driver);
		   return element;
		   }
	 
	public static WebElement btn_ManagedRequirementSuppressButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("*[id^='OpenManagedRequirementsListviewWidget_'][id$='_Suppress']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
	 
	public static WebElement btn_OKManagedRequirementSuppressButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("*[id^='SuppressionReasonWidget_'][id$='_okButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
