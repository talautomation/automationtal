package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_BenefitRight_Benefit_page {
private static WebElement element = null;
	
	public static WebElement tab_BenefitRight(WebDriver driver){
		Waitutil.waituntilvisible(driver, "*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_BenefitRight_cell']");
	    element = driver.findElement(By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_BenefitRight_cell']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement subtab_AmountDetails(WebDriver driver){
		   Waitutil.waituntilvisible(driver, "*[id^='BenefitRights_'][id$='_AmountDetails_cell']");
		   element = driver.findElement(By.cssSelector("*[id^='BenefitRights_'][id$='_AmountDetails_cell']"));
		   utility.Waitutil.implicitwait(driver);
		   return element;
		   }
	public static WebElement txt_SumInsuredAtIncurredDate(WebDriver driver){
		   Waitutil.waituntilvisible(driver, "*[id^='LumpSumAmountWidget_'][id$='_Sum_Assured_at_Incurred_Date']");
		   element = driver.findElement(By.cssSelector("*[id^='LumpSumAmountWidget_'][id$='_Sum_Assured_at_Incurred_Date']"));
		   utility.Waitutil.implicitwait(driver);
		   return element;
		   }
}
