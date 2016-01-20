package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_PaymentHistory_Benefit_page {
	private static WebElement element = null;
	
	public static WebElement tab_PaymentHistory(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_PaymentHistoryBenefitViewTab_cell']");
	    element = driver.findElement( By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_PaymentHistoryBenefitViewTab_cell']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement btn_ProcessPayment(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		//Waitutil.waituntilclickabale(driver,"*[id^='PaymentHistoryDetailsListviewWidget_'][id$='_Process_Payment']");
	    element = driver.findElement( By.cssSelector("*[id^='PaymentHistoryDetailsListviewWidget_'][id$='_Process_Payment']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement tbl_payments(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		element = driver.findElement(By.cssSelector("*[id^='PaymentHistoryDetailsListviewWidget_'][id$='_PaymentHistoryDetailsListview']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}	
	/*public static WebElement row_rightPayment(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		element = driver.findElement(By.cssSelector("*[id^='PaymentHistoryDetailsListviewWidget_'][id$='_PaymentHistoryDetailsListview']"));
		utility.Waitutil.implicitwait(driver);
		return element;
		}	
	*/
	public static WebElement tbl_rightStatus(WebDriver driver, String Status) throws InterruptedException{
		element = driver.findElement(By.xpath(".//*[text()="+Status+"]"));
		utility.Waitutil.implicitwait(driver);
		return element;
		}
	
	
	
	
	
}
