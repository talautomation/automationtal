package automationTestCases;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import pageObjects.Tab_ManagedRequirements_Claim_page;
import pageObjects.ClaimIntake_page;
import pageObjects.Tab_Expenses_Benefit_page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Continuation_TC {

	public WebDriver chiefdriver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private String ClaimNumber;

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

		String filename = props.getProperty("FILE");
		String path = props.getProperty("PATH");

		Constant.URL_CMANAGER = cmanagerURL;
		Constant.URL_SCMANAGER = scmanagerURL;
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
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Group_TestCases");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		chiefdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_CHIEF);

		// Removing the test case status and errors from previous test results
		// if any
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_claimNumber);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Result);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Errors);

	}

	@Test
	public void Continuation() throws Exception {
		String BenefitNumber = "";
		ClaimIntake_page.btn_CaseSearch_OpenCase(chiefdriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(chiefdriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(chiefdriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(chiefdriver).click();
		Tab_Expenses_Benefit_page.tab_Expenses(chiefdriver).click();

		/*
		 * ClaimIntake_page.btn_CaseSearch_Search(chiefdriver).click(); // Open
		 * Claim and Navigate to Expenses Tab
		 * Tab_Expenses_Benefit_page.tab_Expenses(chiefdriver).click();
		 * Tab_Expenses_Benefit_page.btn_AddExpense(chiefdriver).click();
		 * AddExpense_page.txt_InvoiceNumber(chiefdriver).sendKeys("12345");
		 * AddExpense_page.btn_SearchPayee(chiefdriver).click();
		 * OpenParty_page.tab_Provider(chiefdriver).click();
		 * OpenParty_page.btn_Organisation(chiefdriver).click();
		 * ClaimIntake_page.txt_Organisation(chiefdriver).sendKeys("Fineos");
		 * ClaimIntake_page.btn_Search(chiefdriver).click();
		 * ClaimIntake_page.btn_Select(chiefdriver).click();
		 * AddExpense_page.btn_SearchLineItemCode(chiefdriver).click();
		 * AddExpense_page.txt_ExpenseCode(chiefdriver).sendKeys("LEGAL");
		 * AddExpense_page.btn_SearchExpenseCode(chiefdriver).click();
		 * AddExpense_page.btn_SelectService(chiefdriver).click();
		 * AddExpense_page.txt_InvoiceStartDate_Day(chiefdriver).sendKeys("20");
		 * Select InvoiceStartDateMonth = new
		 * Select(AddExpense_page.txt_InvoiceStartDate_Month(chiefdriver));
		 * InvoiceStartDateMonth.selectByVisibleText("JAN");
		 * AddExpense_page.txt_InvoiceStartDate_Year(chiefdriver).sendKeys(
		 * "2016");
		 * 
		 * AddExpense_page.txt_InvoiceCost(chiefdriver).clear();
		 * AddExpense_page.txt_InvoiceCost(chiefdriver).sendKeys("4000");
		 * AddExpense_page.btn_QuickAddInvoice(chiefdriver).click();
		 * Claim_Benefit_page.btn_Ok(chiefdriver).click();
		 */
	}

	@AfterMethod

	public void writeResult(ITestResult result) throws Exception {

		int status = result.getStatus();
		// System.out.println("status is" +status);

		switch (status) {
		case ITestResult.SUCCESS:
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			ExcelUtils.setCellData(ClaimNumber, iTestCaseRow, Constant.Col_claimNumber);
			Utils.captureScreenshot(chiefdriver, sTestCaseName, Constant.Path_Screenshots, "Pass");
			break;
		case ITestResult.FAILURE:
			if (ClaimNumber != "") {
				ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			}
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
