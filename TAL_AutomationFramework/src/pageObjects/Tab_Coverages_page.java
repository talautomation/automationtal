package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tab_Coverages_page {

	private static WebElement element = null;

	public static WebElement tab_CoveragesTab(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(
				By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_CoveragesTab_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_Coverages(WebDriver driver) {
		element = driver.findElement(By.cssSelector("*[id^='AssuranceComponentLVW_'][id$='_CoveragesLVW_ScrollPane']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Open(WebDriver driver) {
		element = driver
				.findElement(By.cssSelector("*[id^='BenefitRightsListViewWidget_'][id$='_BenefitRights_cmdEdit']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_BenefitRights(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		element = driver.findElement(By.cssSelector("*[id^='BenefitRightsListViewWidget_'][id$='_BenefitRights']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_CreateBen(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("*[id^='BenefitRightsListViewWidget_'][id$='_CreateBenefit']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}