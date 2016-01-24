package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_Expenses_Benefit_page {
	private static WebElement element = null;

	public static WebElement tab_Expenses(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_ExpenseApprovals_cell']");
		element = driver.findElement(By.cssSelector(
				"*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_ExpenseApprovals_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_AddExpense(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='InvoiceListviewWidget_'][id$='_InvoiceListviewWidget_cmdAdd']");
		element = driver
				.findElement(By.cssSelector("*[id^='InvoiceListviewWidget_'][id$='_InvoiceListviewWidget_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
