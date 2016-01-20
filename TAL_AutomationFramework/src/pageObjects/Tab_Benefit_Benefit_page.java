package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_Benefit_Benefit_page {
	private static WebElement element = null;

	public static WebElement subtab_Periods(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='TabbedDialogWidget_'][id$='_FINEOS.Claims.Benefits.Payments.Recurring_Benefit_BenefitPeriods_cell']");
		element = driver.findElement( By.cssSelector("*[id^='TabbedDialogWidget_'][id$='_FINEOS.Claims.Benefits.Payments.Recurring_Benefit_BenefitPeriods_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
   }
	public static WebElement btn_EditCertificationPeriod(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodsListviewWidget_'][id$='_periodsListview_cmdEdit']");
		element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodsListviewWidget_'][id$='_periodsListview_cmdEdit']"));
		utility.Waitutil.implicitwait(driver);
		return element;
   }
	public static WebElement sel_StatusActivityPeriod(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodWidget_'][id$='_statusEnumBean']");
		element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodWidget_'][id$='_statusEnumBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
   }
	public static WebElement btn_OKEditActivityPeriod(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodWidget_'][id$='_saveActivityButtonBean_cloned']");
		element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodWidget_'][id$='_saveActivityButtonBean_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
