package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class AddExpense_page {
	private static WebElement element = null;

	public static WebElement txt_InvoiceNumber(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='InvoiceDetailsWidget_'][id$='_Invoice_Number']");
		element = driver.findElement(By.cssSelector("*[id^='InvoiceDetailsWidget_'][id$='_Invoice_Number']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchPayee(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='DefaultPayeeForInvoiceWidget_'][id$='_PayeeControlBean_rcbSearchButton_PayeeControlBean']");
		element = driver.findElement(By.cssSelector(
				"*[id^='DefaultPayeeForInvoiceWidget_'][id$='_PayeeControlBean_rcbSearchButton_PayeeControlBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchLineItemCode(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_serviceCodeRelControlBean_rcbSearchButton_serviceCodeRelControlBean']");
		element = driver.findElement(By.cssSelector(
				"*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_serviceCodeRelControlBean_rcbSearchButton_serviceCodeRelControlBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_ExpenseCode(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		Waitutil.waituntilclickabale(driver, "*[id^='ServiceCodesSearchWidget_'][id$='_code']");
		element = driver.findElement(By.cssSelector("*[id^='ServiceCodesSearchWidget_'][id$='_code']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchExpenseCode(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ServiceCodesSearchWidget_'][id$='_searchButton']");
		element = driver.findElement(By.cssSelector("*[id^='ServiceCodesSearchWidget_'][id$='_searchButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_InvoiceStartDate_Day(WebDriver driver) throws InterruptedException {
		Waitutil.waituntilclickabale(driver, "*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_startDate_Day']");
		element = driver.findElement(By.cssSelector("*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_startDate_Day']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SelectService(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ServiceCodesSearchWidget_'][id$='_OKButton']");
		element = driver.findElement(By.cssSelector("*[id^='ServiceCodesSearchWidget_'][id$='_OKButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_InvoiceStartDate_Month(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_startDate_Month']");
		element = driver
				.findElement(By.cssSelector("*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_startDate_Month']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_InvoiceStartDate_Year(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_startDate_Year']");
		element = driver.findElement(By.cssSelector("*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_startDate_Year']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_InvoiceCost(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_cost'][type=text]");
		element = driver
				.findElement(By.cssSelector("*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_cost'][type=text]"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_QuickAddInvoice(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_QuickAddButton']");
		element = driver.findElement(By.cssSelector("*[id^='QuickAddInvoiceLineItemsWidget_'][id$='_QuickAddButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

}
