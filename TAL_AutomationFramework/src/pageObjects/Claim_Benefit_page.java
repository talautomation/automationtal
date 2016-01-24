package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Claim_Benefit_page {
	private static WebElement element = null;

	public static WebElement btn_MoveToNextStatus(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='tab-1']/div[3]/dl[2]/dd[2]/span/span[1]"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_ChooseNextStep(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		element = driver.findElement(By.cssSelector("*[id^='CHOOSE_NEXT_STEP_WIDGET_'][id$='_StepListView']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Ok(WebDriver driver) {

		element = driver.findElement(By.cssSelector("*[id^='p'][id$='_editPageSave_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement lnk_Directclaim(WebDriver driver) {

		element = driver.findElement(By.linkText("Direct Claim"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement lnk_Groupclaim(WebDriver driver) {

		element = driver.findElement(By.linkText("Group Claim"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement lnk_Overpayment(WebDriver driver) {

		element = driver.findElement(By.linkText("Overpayment"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_CreationDate(WebDriver driver) {

		element = driver.findElement(By.cssSelector("*[id^='CaseDetails_'][id$='_CaseDateCreated']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_ClaimNumber(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='tab-1']/div[1]/h2/span"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
