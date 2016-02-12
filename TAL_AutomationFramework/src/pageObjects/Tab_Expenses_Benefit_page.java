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

	public static WebElement subtab_ExpensePayments(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ExpenseListviewWidget_'][id$='_Dues_cell']");
		element = driver.findElement(By.cssSelector("*[id^='ExpenseListviewWidget_'][id$='_Dues_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_ExpenseApproveRecover(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='Expense_Dues_'][id$='_ApproveRecover']");
		element = driver.findElement(By.cssSelector("*[id^='Expense_Dues_'][id$='_ApproveRecover']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_ExpenseGeneratePayments(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='Expense_Dues_'][id$='_Generate_Payments']");
		element = driver.findElement(By.cssSelector("*[id^='Expense_Dues_'][id$='_Generate_Payments']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
