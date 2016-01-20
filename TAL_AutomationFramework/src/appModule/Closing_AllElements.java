package appModule;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.Tab_Tasks_Claim_page;
import utility.Waitutil;

public class Closing_AllElements {

	public static void Close(WebDriver driver, List<WebElement> Tasks) throws InterruptedException, IOException {

		// List<WebElement> allTasks =
		// Tab_Tasks_Claim_page.tbl_TasksList(driver).findElements(By.tagName("tr"));

		if (Tasks.size() > 0) {

			for (int iTask = 1; iTask <= Tasks.size(); iTask++) {

				Tab_Tasks_Claim_page.tbl_TasksList(driver).click();
				Tab_Tasks_Claim_page.btn_Closetask(driver).click();
				Waitutil.waituntilclickabale(driver, "#PopupContainer input[type=submit][value=Yes]");
				driver.findElement(By.cssSelector("#PopupContainer input[type=submit][value=Yes]")).click();

			}

		}

	}

	/*
	 * public static void fff(WebDriver driver) throws InterruptedException{
	 * 
	 * List<WebElement> Payments =
	 * Tab_PaymentHistory_Benefit_page.tbl_payments(driver).findElements(By.
	 * cssSelector("tbody > tr"));
	 * 
	 * for(int i =1; i<=Payments.size(); i++){
	 * 
	 * List<WebElement> Payments1 =
	 * Tab_PaymentHistory_Benefit_page.tbl_payments(driver).findElements(By.
	 * cssSelector("tbody > tr")); Closing_AllElements.Process(driver,
	 * "PendingActive", Payments1);
	 * Tab_PaymentHistory_Benefit_page.btn_ProcessPayment(driver).click();
	 * Claim_Benefit_page.btn_Ok(driver).click(); System.out.println(
	 * "Current row" +i);
	 * 
	 * }
	 */

	public static void Process(WebDriver driver, String ElementToClick, List<WebElement> allRows)
			throws InterruptedException {

		for (WebElement row : allRows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > 0) {
				String matchingElement = cells.get(3).getText();
				// System.out.println("matching element is " +matchingElement);
				if (ElementToClick.equals(matchingElement)) {
					row.click();
					break;
				}
			}
		}
	}
}
