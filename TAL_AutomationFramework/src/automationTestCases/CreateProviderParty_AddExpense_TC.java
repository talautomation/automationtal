package automationTestCases;

//testing testing testing.

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.AddExpense_page;
import pageObjects.ClaimIntake_page;
import pageObjects.Claim_Benefit_page;
import pageObjects.OpenParty_page;
import pageObjects.Tab_Expenses_Benefit_page;
import pageObjects.Tab_PaymentHistory_Benefit_page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class CreateProviderParty_AddExpense_TC {

	public WebDriver chiefdriver;
	public WebDriver procofficerdriver;
	public WebDriver sysadmindriver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private String ExecutionDate;
	private String BenefitNumber;
	private String ProviderName = "Test1 Fineos Test1";

	@BeforeSuite

	public void setup() {
		String environment = System.getProperty("Environment");
		Properties props = new Properties();
		InputStream is = this.getClass().getResourceAsStream("/Config/" + environment + ".properties");
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String cmanagerURL = props.getProperty("URL_CMANAGER");
		String scmanagerURL = props.getProperty("URL_SCMANAGER");
		String chiefURL = props.getProperty("URL_CHIEF");
		String gManagerURL = props.getProperty("URL_GMANAGER");
		String systemAdminURL = props.getProperty("URL_SYSADMIN");
		String procOfficerURL = props.getProperty("URL_PROCOFFICER");

		String filename = props.getProperty("FILE");
		String path = props.getProperty("PATH");

		Constant.URL_CMANAGER = cmanagerURL;
		Constant.URL_SCMANAGER = scmanagerURL;
		Constant.URL_PROCOFFICER = procOfficerURL;
		Constant.URL_CHIEF = chiefURL;
		Constant.URL_GMANAGER = gManagerURL;
		Constant.URL_SYSADMIN = systemAdminURL;
		Constant.File_TestData = filename;
		Constant.Path_TestData = path;

		String screenshotpath = props.getProperty("SCREENSHOTPATH");
		Constant.Path_Screenshots = screenshotpath;

	}

	@BeforeMethod

	public void beforeMethod() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Direct_TestCases");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);

		// Removing the test case status and errors from previous test results
		// if any
		// ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_claimNumber);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Result);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Errors);

	}

	@Test
	public void Direct_LivingLSEndtoEnd() throws Exception {
		BenefitNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_claimNumber);
		procofficerdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_PROCOFFICER);
		OpenParty_page.btn_OpenParty(procofficerdriver).click();
		OpenParty_page.btn_Organisation(procofficerdriver).click();
		ClaimIntake_page.txt_Organisation(procofficerdriver).sendKeys(ProviderName);
		ClaimIntake_page.btn_Search(procofficerdriver).click();
		OpenParty_page.btn_Add(procofficerdriver).click();
		Select partition = new Select(ClaimIntake_page.sel_Partitions(procofficerdriver));
		partition.selectByVisibleText("TAL Head Office");
		OpenParty_page.btn_OkPartitionButton(procofficerdriver).click();
		OpenParty_page.txt_TradingAs(procofficerdriver).sendKeys("Test Organisation");
		OpenParty_page.txt_ABN(procofficerdriver).sendKeys("123456789");

		OpenParty_page.btn_AddNewAddress(procofficerdriver).click();
		Select AddressType = new Select(OpenParty_page.sel_AddressType(procofficerdriver));
		AddressType.selectByVisibleText("Business");
		OpenParty_page.btn_OkAddressType(procofficerdriver).click();
		Select AddressCountry = new Select(OpenParty_page.sel_AddressCountry(procofficerdriver));
		AddressCountry.selectByVisibleText("Australia");
		OpenParty_page.txt_AddressLine1(procofficerdriver).sendKeys("Unit 1");
		OpenParty_page.txt_AddressLine2(procofficerdriver).sendKeys("369 George Street");
		OpenParty_page.txt_AddressSuburb(procofficerdriver).sendKeys("Sydney");
		Select AddressState = new Select(OpenParty_page.sel_AddressState(procofficerdriver));
		AddressState.selectByVisibleText("New South Wales");
		OpenParty_page.txt_AddressPostcode(procofficerdriver).sendKeys("2000");
		OpenParty_page.txt_PhoneIntCode(procofficerdriver).sendKeys("61");
		OpenParty_page.txt_PhoneAreaCode(procofficerdriver).sendKeys("23");
		OpenParty_page.txt_PhoneTelNo(procofficerdriver).sendKeys("23456789");
		Claim_Benefit_page.btn_Ok(procofficerdriver).click();

		Select OrgPrefContMethod = new Select(OpenParty_page.sel_OrgPrefContactMethod(procofficerdriver));
		OrgPrefContMethod.selectByVisibleText("Mail");
		Claim_Benefit_page.btn_Ok(procofficerdriver).click();

		OpenParty_page.tab_PartyRoles(procofficerdriver).click();
		OpenParty_page.btn_AddPartyRoles(procofficerdriver).click();
		Select PartyRoleType = new Select(OpenParty_page.sel_PartyRoleType(procofficerdriver));
		PartyRoleType.selectByVisibleText("ProviderPartyRole");
		OpenParty_page.btn_OkPartyRoleType(procofficerdriver).click();
		Claim_Benefit_page.btn_Ok(procofficerdriver).click();
		ExecutionDate = appModule.CurrentDateTimeStamp.getCurrentTimeStamp();

		// Open Claim and Navigate to Expenses Tab
		ClaimIntake_page.btn_CaseSearch_OpenCase(procofficerdriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(procofficerdriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(procofficerdriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(procofficerdriver).click();
		Tab_Expenses_Benefit_page.tab_Expenses(procofficerdriver).click();
		Tab_Expenses_Benefit_page.btn_AddExpense(procofficerdriver).click();
		AddExpense_page.txt_InvoiceNumber(procofficerdriver).sendKeys("12345");
		AddExpense_page.btn_SearchPayee(procofficerdriver).click();
		OpenParty_page.tab_Provider(procofficerdriver).click();
		OpenParty_page.btn_Organisation(procofficerdriver).click();
		ClaimIntake_page.txt_Organisation(procofficerdriver).sendKeys(ProviderName);
		ClaimIntake_page.btn_Search(procofficerdriver).click();
		ClaimIntake_page.btn_Select(procofficerdriver).click();
		AddExpense_page.btn_SearchLineItemCode(procofficerdriver).click();
		AddExpense_page.txt_ExpenseCode(procofficerdriver).sendKeys("LEGAL");
		AddExpense_page.btn_SearchExpenseCode(procofficerdriver).click();
		AddExpense_page.btn_SelectService(procofficerdriver).click();
		AddExpense_page.txt_InvoiceStartDate_Day(procofficerdriver).sendKeys("20");
		Select InvoiceStartDateMonth = new Select(AddExpense_page.txt_InvoiceStartDate_Month(procofficerdriver));
		InvoiceStartDateMonth.selectByVisibleText("JAN");
		AddExpense_page.txt_InvoiceStartDate_Year(procofficerdriver).sendKeys("2016");

		AddExpense_page.txt_InvoiceCost(procofficerdriver).clear();
		AddExpense_page.txt_InvoiceCost(procofficerdriver).sendKeys("4000");
		AddExpense_page.btn_QuickAddInvoice(procofficerdriver).click();
		Thread.sleep(3000);
		Claim_Benefit_page.btn_Ok(procofficerdriver).click();
		Thread.sleep(10000);
		procofficerdriver.quit();

		chiefdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_CHIEF);
		System.out.println(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_OpenCase(chiefdriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(chiefdriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(chiefdriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(chiefdriver).click();
		Tab_Expenses_Benefit_page.tab_Expenses(chiefdriver).click();
		Tab_Expenses_Benefit_page.subtab_ExpensePayments(chiefdriver).click();
		Tab_Expenses_Benefit_page.btn_ExpenseApproveRecover(chiefdriver).click();
		Tab_Expenses_Benefit_page.btn_ExpenseGeneratePayments(chiefdriver).click();
		Claim_Benefit_page.btn_Ok(chiefdriver).click();
		Tab_PaymentHistory_Benefit_page.tab_PaymentHistory(chiefdriver).click();
		Tab_PaymentHistory_Benefit_page.btn_ProcessPayment(chiefdriver).click();
		Claim_Benefit_page.btn_Ok(chiefdriver).click();

	}

	@AfterMethod

	public void writeResult(ITestResult result) throws Exception {

		int status = result.getStatus();
		System.out.println("status is" + status);

		switch (status) {
		case ITestResult.SUCCESS:
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			ExcelUtils.setCellData(ExecutionDate, iTestCaseRow, Constant.Col_ExecutionDate);
			Utils.captureScreenshot(chiefdriver, sTestCaseName, Constant.Path_Screenshots, "Pass");
			break;
		case ITestResult.FAILURE:
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			Utils.captureScreenshot(chiefdriver, sTestCaseName, Constant.Path_Screenshots, "Fail");
			break;
		case ITestResult.SKIP:
			ExcelUtils.setCellData("Skip", iTestCaseRow, Constant.Col_Result);
			Utils.captureScreenshot(chiefdriver, sTestCaseName, Constant.Path_Screenshots, "Skip");
			break;
		default:
			throw new RuntimeException("Invalid status");
		}

		// driver.quit();

	}

}
