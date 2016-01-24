package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Overpayment_Subcase_page {
	private static WebElement element = null;

	public static WebElement btn_AddActualRecoveries(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='ActualRecoveriesListviewWidget_'][id$='_RecoveryPlanListView_cmdAdd']");
		element = driver.findElement(
				By.cssSelector("*[id^='ActualRecoveriesListviewWidget_'][id$='_RecoveryPlanListView_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement rec_OutstandingAmount(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='OverpaymentRecordWidget_'][id$='_OutstandingAmount']");
		element = driver.findElement(By.cssSelector("*[id^='OverpaymentRecordWidget_'][id$='_OutstandingAmount']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_AmountOfRecovery(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='EditActualRecoveryWidget_'][id$='_Recovery_Amount']");
		element = driver.findElement(By.cssSelector("*[id^='EditActualRecoveryWidget_'][id$='_Recovery_Amount']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_RecoveryMethod(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='EditActualRecoveryWidget_'][id$='_Recovery_Method']");
		element = driver.findElement(By.cssSelector("*[id^='EditActualRecoveryWidget_'][id$='_Recovery_Method']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}