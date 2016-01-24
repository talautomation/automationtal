package automationTestCases;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import appModule.Closing_Right_Task;
import appModule.FindRightElement;
//import pageObjects.Tab_ManagedRequirements_Claim_page;
import pageObjects.ClaimIntake_page;
import pageObjects.Claim_Benefit_page;
import pageObjects.Tab_LumpSumPayments_Benefit_page;
import pageObjects.Tab_PaymentHistory_Benefit_page;
import pageObjects.Tab_Tasks_Benefit_page;
import pageObjects.Tab_Tasks_Claim_page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

//testing of tesitng tesitng

//testing of 123

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
		String BenefitNumber = "294016-01";
		ClaimIntake_page.btn_CaseSearch_OpenCase(chiefdriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(chiefdriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(chiefdriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(chiefdriver).click();
		// Navigate to Lump Sum Payments tab and Add
		Tab_LumpSumPayments_Benefit_page.tab_LumpSumPayments(chiefdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_AddPayments(chiefdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_SearchPayee(chiefdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_AddPayee(chiefdriver).click();
		// List<WebElement> availablePayeeTypes =
		// Tab_LumpSumPayments_page.tbl_AvailablePayeeRoles(chiefdriver).findElements(By.cssSelector("tbody
		// > tr"));
		// Selecting_RightElement.Select(chiefdriver, "Payee",
		// availablePayeeTypes, 0);
		// Tab_LumpSumPayments_page.btn_OKPayeeRoleSelection(chiefdriver).click();
		// Tab_LumpSumPayments_page.txt_FirstName(chiefdriver).sendKeys(arg0);
		Tab_LumpSumPayments_Benefit_page.txt_LastName(chiefdriver).sendKeys("sm");
		Tab_LumpSumPayments_Benefit_page.btn_Search(chiefdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_Select(chiefdriver).click();
		// List<WebElement> Payees =
		// Tab_LumpSumPayments_page.tbl_Payees(chiefdriver).findElements(By.cssSelector("tbody
		// > tr"));
		// Selecting_RightElement.Select(chiefdriver, "Payee", Payees, 1);
		Tab_LumpSumPayments_Benefit_page.btn_Select(chiefdriver).click();
		Select description = new Select(Tab_LumpSumPayments_Benefit_page.sel_Description(chiefdriver));
		description.selectByValue("1");
		Tab_LumpSumPayments_Benefit_page.txt_BasicPayeeAmount(chiefdriver).clear();
		// Enter Basic Payee Amount
		Tab_LumpSumPayments_Benefit_page.txt_BasicPayeeAmount(chiefdriver).sendKeys("10000");
		Tab_LumpSumPayments_Benefit_page.txt_BasicAmountDistribution(chiefdriver).clear();
		Tab_LumpSumPayments_Benefit_page.txt_BasicAmountDistribution(chiefdriver).sendKeys("10000");
		Tab_LumpSumPayments_Benefit_page.tabout_OutstandingAmount(chiefdriver).click();
		Thread.sleep(4000);
		Tab_LumpSumPayments_Benefit_page.btn_SaveDue(chiefdriver).click();
		Thread.sleep(4000);
		chiefdriver.quit();

		// Login as SystemAdmin
		WebDriver sysadmindriver = Utils.openBrowser(iTestCaseRow, Constant.URL_SYSADMIN);
		ClaimIntake_page.btn_CaseSearch_OpenCase(sysadmindriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(sysadmindriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(sysadmindriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(sysadmindriver).click();

		// Approve and Generate Payments
		Tab_LumpSumPayments_Benefit_page.tab_LumpSumPayments(sysadmindriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_ApproveRecoverPayments(sysadmindriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_GeneratePayments(sysadmindriver).click();
		Claim_Benefit_page.btn_Ok(sysadmindriver).click();

		// Process Payments
		Tab_PaymentHistory_Benefit_page.tab_PaymentHistory(sysadmindriver).click();
		Tab_PaymentHistory_Benefit_page.btn_ProcessPayment(sysadmindriver).click();
		Claim_Benefit_page.btn_Ok(sysadmindriver).click();

		// Close Pay Benefit Task
		Tab_Tasks_Benefit_page.tab_TasksTab(sysadmindriver).click();
		List<WebElement> TaskPayBenefit = Tab_Tasks_Benefit_page.tbl_TasksList(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(sysadmindriver, "Pay Benefit", TaskPayBenefit, 2);

		// Closing all tasks
		List<WebElement> RemainingBenefitTasks = Tab_Tasks_Benefit_page.tbl_TasksList(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));
		appModule.Closing_AllElements.Close(sysadmindriver, RemainingBenefitTasks);

		// Move the Benefit to Paid Status
		Claim_Benefit_page.btn_MoveToNextStatus(sysadmindriver).click();
		List<WebElement> StepPaidBenefit = Claim_Benefit_page.tbl_ChooseNextStep(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(sysadmindriver, "Paid", StepPaidBenefit);
		Claim_Benefit_page.btn_Ok(sysadmindriver).click();

		// Navigate to Claim's Tasks tab and close the tasks
		Claim_Benefit_page.lnk_Groupclaim(sysadmindriver).click();
		Tab_Tasks_Claim_page.tab_task(sysadmindriver).click();
		List<WebElement> RemainingClaimTasks = Tab_Tasks_Claim_page.tbl_TasksList(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));
		appModule.Closing_AllElements.Close(sysadmindriver, RemainingClaimTasks);

		// Move Claim Status to Closed
		Claim_Benefit_page.btn_MoveToNextStatus(sysadmindriver).click();
		List<WebElement> StepCloseClaim = Claim_Benefit_page.tbl_ChooseNextStep(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(sysadmindriver, "Close Claim", StepCloseClaim);
		Claim_Benefit_page.btn_Ok(sysadmindriver).click();

	}

	@AfterMethod

	public void writeResult(ITestResult result) throws Exception {

		int status = result.getStatus();
		// System.out.println("status is" +status);

		switch (status) {
		case ITestResult.SUCCESS:
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			ExcelUtils.setCellData(ClaimNumber, iTestCaseRow, Constant.Col_claimNumber);
			break;
		case ITestResult.FAILURE:
			if (ClaimNumber != "") {
				ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			}
			break;
		case ITestResult.SKIP:
			ExcelUtils.setCellData("Skip", iTestCaseRow, Constant.Col_Result);
			break;
		default:
			throw new RuntimeException("Invalid status");
		}

		// driver.quit();

	}

}
