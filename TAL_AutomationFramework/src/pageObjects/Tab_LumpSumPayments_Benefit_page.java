package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_LumpSumPayments_Benefit_page {
	private static WebElement element = null;

	public static WebElement tab_LumpSumPayments(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_AdhocDues_cell']");
		element = driver.findElement(
				By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_AdhocDues_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_AddPayments(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='Adhoc_Dues_'][id$='_listviewBean_cmdAdd']");
		element = driver.findElement(By.cssSelector("*[id^='Adhoc_Dues_'][id$='_listviewBean_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchPayee(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='AdhocDueAmountWidget_'][id$='_rcbPayee_rcbSearchButton_rcbPayee']");
		element = driver.findElement(
				By.cssSelector("*[id^='AdhocDueAmountWidget_'][id$='_rcbPayee_rcbSearchButton_rcbPayee']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_AddPayee(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='listView_'][id$='_addPayeeButton']");
		element = driver.findElement(By.cssSelector("*[id^='listView_'][id$='_addPayeeButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_AvailablePayeeRoles(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AddPayeeForCaseTypeRoleWidget_'][id$='_Payee_Roles']");
		element = driver.findElement(By.cssSelector("*[id^='AddPayeeForCaseTypeRoleWidget_'][id$='_Payee_Roles']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_OKPayeeRoleSelection(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AddPayeeForCaseTypeRoleWidget_'][id$='SaveButton']");
		element = driver.findElement(By.cssSelector("*[id^='AddPayeeForCaseTypeRoleWidget_'][id$='SaveButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_FirstName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_claimant_'][id$='_First_Name']");
		element = driver.findElement(By.cssSelector(
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_claimant_'][id$='_First_Name']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_LastName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_claimant_'][id$='_Last_Name']");
		element = driver.findElement(By.cssSelector(
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_claimant_'][id$='_Last_Name']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Search(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='DynamicPartySearchWidget_claimant_'][id$='_searchButton']");
		element = driver
				.findElement(By.cssSelector("*[id^='DynamicPartySearchWidget_claimant_'][id$='_searchButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Select(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='p'][id$='_searchPageOk_cloned']");
		element = driver.findElement(By.cssSelector("*[id^='p'][id$='_searchPageOk_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_Payees(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='listView_'][id$='_Payees']");
		element = driver.findElement(By.cssSelector("*[id^='listView_'][id$='_Payees']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_Description(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AdhocDueAmountWidget_'][id$='_DescriptionEnum']");
		element = driver.findElement(By.cssSelector("*[id^='AdhocDueAmountWidget_'][id$='_DescriptionEnum']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_BasicPayeeAmount(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AdhocDueAmountWidget'][id$='_BasicPayeeAmount']");
		element = driver.findElement(By.cssSelector("*[id^='AdhocDueAmountWidget'][id$='_BasicPayeeAmount']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_BasicAmountDistribution(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='groupAdhocDueAmountWidget_'][id$='_BasicAmount']");
		element = driver.findElement(By.cssSelector("*[id^='groupAdhocDueAmountWidget_'][id$='_BasicAmount']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tabout_OutstandingAmount(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='groupAdhocDueAmountWidget_'][id$='_OutstandingBalance']");
		element = driver.findElement(By.cssSelector("*[id^='groupAdhocDueAmountWidget_'][id$='_OutstandingBalance']"));
		// element =
		// driver.findElement(By.xpath(".//*[@id='p16_un9_SaveUnscheduledDue']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SaveDue(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='p'][id$='_SaveUnscheduledDue']");
		element = driver.findElement(By.cssSelector("*[id^='p'][id$='_SaveUnscheduledDue']"));
		// element =
		// driver.findElement(By.xpath(".//*[@id='p16_un9_SaveUnscheduledDue']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_ApproveRecoverPayments(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilvisible(driver, "*[id^='Adhoc_Dues_'][id$='_ApproveRecover']");
		element = driver.findElement(By.cssSelector("*[id^='Adhoc_Dues_'][id$='_ApproveRecover']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_GeneratePayments(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilvisible(driver, "*[id^='Adhoc_Dues_'][id$='_Generate_Payments']");
		element = driver.findElement(By.cssSelector("*[id^='Adhoc_Dues_'][id$='_Generate_Payments']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_EditPaymentAmount(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='Adhoc_Dues_'][id$='_listviewBean_cmdEdit']");
		element = driver.findElement(By.cssSelector("*[id^='Adhoc_Dues_'][id$='_listviewBean_cmdEdit']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
