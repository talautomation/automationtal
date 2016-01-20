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
import appModule.Selecting_RightElement;
import appModule.Suppress_ManagedRequirement;
import pageObjects.ClaimIntake_page;
import pageObjects.Claim_Benefit_page;
import pageObjects.Tab_BenefitRight_Benefit_page;
import pageObjects.Tab_Coverages_page;
import pageObjects.Tab_LumpSumPayments_Benefit_page;
import pageObjects.Tab_PaymentHistory_Benefit_page;
import pageObjects.Tab_Tasks_Benefit_page;
//import pageObjects.Tab_ManagedRequirements_Claim_page;
import pageObjects.Tab_Tasks_Claim_page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Direct_FuneralEndToEnd_TC {

	public WebDriver cmanagerdriver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private String ClaimNumber;
	private String BenefitNumber;
	private String SumInsured;

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
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Direct_TestCases");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);

		// Removing the test case status and errors from previous test results
		// if any
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_claimNumber);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Result);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Errors);

	}

	@Test(priority = 0)
	public void FuneralEndtoEnd_LoginasCManager() throws Exception {
		cmanagerdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_CMANAGER);
		String sFirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_FirstName);
		String sLastName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LastName);
		String sGroupId = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_GroupId);
		String sProduct = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Product);
		String sBenefitType = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_BenefitType);

		// String sGroupId = "101681729";
		// String sProduct="FP2";
		// String sBenefitType="Funeral Benefit";

		System.out.println("group id is " + sGroupId);
		System.out.println("first name is " + sFirstName);
		System.out.println("last name is " + sLastName);

		ClaimIntake_page.btn_CaseSearch_OpenCase(cmanagerdriver).click();
		ClaimIntake_page.txt_CaseSearch_FirstName(cmanagerdriver).sendKeys(sFirstName);
		ClaimIntake_page.txt_CaseSearch_LastName(cmanagerdriver).sendKeys(sLastName);
		ClaimIntake_page.btn_CaseSearch_PersonSearchPolicy(cmanagerdriver).click();

		List<WebElement> allPersons = ClaimIntake_page.tbl_PersonSearchResults(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(cmanagerdriver, sGroupId, allPersons, 3);

		List<WebElement> allProducts = ClaimIntake_page.tbl_ListofPolicies(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(cmanagerdriver, sProduct, allProducts, 1);

		// Thread.sleep(2000);

		ClaimIntake_page.btn_ClaimsForPolicy_AddButton(cmanagerdriver).click();
		// Thread.sleep(2000);
		Select partition = new Select(ClaimIntake_page.sel_Partitions(cmanagerdriver));
		partition.selectByVisibleText("TAL Head Office");
		ClaimIntake_page.btn_NextButton(cmanagerdriver).click();

		Select type = new Select(ClaimIntake_page.sel_Type(cmanagerdriver));
		type.selectByVisibleText("Death");
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		Select prefContMet = new Select(ClaimIntake_page.sel_PreferredContactMethod(cmanagerdriver));
		prefContMet.selectByValue("2");

		Select occupation = new Select(ClaimIntake_page.sel_Occupation(cmanagerdriver));
		occupation.selectByValue("6");
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Enter Incurred Date
		ClaimIntake_page.txt_DayIncurredDate(cmanagerdriver).sendKeys("14");
		Select monthIncurredDate = new Select(ClaimIntake_page.sel_MonthIncurredDate(cmanagerdriver));
		monthIncurredDate.selectByValue("5");
		ClaimIntake_page.txt_YearIncurredDate(cmanagerdriver).sendKeys("2015");

		// Enter Medical Code
		ClaimIntake_page.txt_DiagnosisCode(cmanagerdriver).sendKeys("can");
		ClaimIntake_page.btn_SearchDiagnosisCode(cmanagerdriver).click();
		ClaimIntake_page.btn_QuickAddDiagnosisCode(cmanagerdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Thread.sleep(4000);
		// Selecting Right BenefitType
		List<WebElement> allBenefitTypes = ClaimIntake_page.tbl_ListofBenefitTypes(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(cmanagerdriver, sBenefitType, allBenefitTypes, 1);
		// Thread.sleep(2000);
		ClaimIntake_page.btn_SelectBenefitRight(cmanagerdriver).click();
		// Thread.sleep(5000);
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();
		// Medical Details Page
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Notifier Details Page
		ClaimIntake_page.btn_SearchNotifier(cmanagerdriver).click();
		// ClaimIntake_page.txt_FirstName(cmanagerdriver).sendKeys("A");
		ClaimIntake_page.txt_LastName(cmanagerdriver).sendKeys("pe");
		ClaimIntake_page.btn_Search(cmanagerdriver).click();
		ClaimIntake_page.btn_Select(cmanagerdriver).click();
		Select NotifierTitle = new Select(ClaimIntake_page.sel_SelectTitle(cmanagerdriver));
		if ((NotifierTitle.getFirstSelectedOption().getText()).equals("Unknown")) {
			NotifierTitle.selectByVisibleText("Mr");
		}
		Select NotifierGender = new Select(ClaimIntake_page.sel_SelectGender(cmanagerdriver));
		if ((NotifierGender.getFirstSelectedOption().getText()).equals("Unknown")) {
			NotifierGender.selectByVisibleText("Male");
		}
		Select relationship = new Select(ClaimIntake_page.sel_RelationshipToInsured(cmanagerdriver));
		relationship.selectByValue("3");
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();
		// Contact Details Page
		ClaimIntake_page.chk_PrimaryContact(cmanagerdriver).click();
		ClaimIntake_page.btn_ApplyPrimaryContact(cmanagerdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Capture Claim Number
		WebElement ElementClaimNumber = cmanagerdriver.findElement(By.xpath(".//*[@id='tab-1']/div[1]/h2/span"));
		ClaimNumber = ElementClaimNumber.getText();
		System.out.println("Claim Number is: " + ClaimNumber);

		// Suppress Managed Requirements
		Suppress_ManagedRequirement.SupressManagedRequirement(cmanagerdriver);

		// Tasks Tab
		Tab_Tasks_Claim_page.tab_task(cmanagerdriver).click();

		// Move claim to Open-TeleClaim
		// Close Review Claim Notification task
		List<WebElement> TaskReviewNewClaimNotification = Tab_Tasks_Claim_page.tbl_TasksList(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(cmanagerdriver, "Review New Claim Notification",
				TaskReviewNewClaimNotification, 2);
		List<WebElement> StepOpenTeleClaim = Claim_Benefit_page.tbl_ChooseNextStep(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(cmanagerdriver, "Open - TeleClaim", StepOpenTeleClaim);
		Claim_Benefit_page.btn_Ok(cmanagerdriver).click();

		// Close Initial Claim Assessment-Teleclaim task
		List<WebElement> TaskInitialClaimAssessment = Tab_Tasks_Claim_page.tbl_TasksList(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(cmanagerdriver, "Initial Claim Assessment - TeleClaim",
				TaskInitialClaimAssessment, 2);
		List<WebElement> StepNoAutomatedTelephony = Claim_Benefit_page.tbl_ChooseNextStep(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(cmanagerdriver,
				"NO - Do not issue the Automated Telephony Initial Notification Pack.", StepNoAutomatedTelephony);
		Claim_Benefit_page.btn_Ok(cmanagerdriver).click();

		// Close Create Initial Notification Pack
		List<WebElement> TaskCreateInitialNotificationTask = Tab_Tasks_Claim_page.tbl_TasksList(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(cmanagerdriver, "Create Initial Notification Pack",
				TaskCreateInitialNotificationTask, 2);

		// Navigate to Coverages tab and Create Benefit
		Tab_Coverages_page.tab_CoveragesTab(cmanagerdriver).click();
		List<WebElement> allBenefitRights = Tab_Coverages_page.tbl_BenefitRights(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(cmanagerdriver, "Selected", allBenefitRights, 6);
		Tab_Coverages_page.btn_CreateBen(cmanagerdriver).click();

		// Navigate to BenefitRight-Amount Details tab to capture Sum Insured
		Tab_BenefitRight_Benefit_page.tab_BenefitRight(cmanagerdriver).click();
		Tab_BenefitRight_Benefit_page.subtab_AmountDetails(cmanagerdriver).click();
		SumInsured = Tab_BenefitRight_Benefit_page.txt_SumInsuredAtIncurredDate(cmanagerdriver).getText();
		System.out.println("Benefit Amount is:" + SumInsured);

		// Go to Benefit-Tasks Tab
		Tab_Tasks_Benefit_page.tab_TasksTab(cmanagerdriver).click();
		List<WebElement> allBenefitTasks = Tab_Tasks_Benefit_page.tbl_TasksList(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(cmanagerdriver, "Assess Benefit", allBenefitTasks, 2);

		// Capture BenefitNumber
		WebElement ElementBenefitNumber = cmanagerdriver.findElement(By.xpath(".//*[@id='tab-1']/div[1]/h2/span"));
		BenefitNumber = ElementBenefitNumber.getText();
		System.out.println("Benefit Number is: " + BenefitNumber);
		cmanagerdriver.quit();
	}

	@Test(priority = 1)
	public void FuneralEndtoEnd_LoginasSCManager() throws Exception {
		// Login as scmanager
		WebDriver scmanagerdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_SCMANAGER);
		ClaimIntake_page.btn_CaseSearch_OpenCase(scmanagerdriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(scmanagerdriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(scmanagerdriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(scmanagerdriver).click();

		// Admit the Benefit
		Claim_Benefit_page.btn_MoveToNextStatus(scmanagerdriver).click();
		List<WebElement> StepAdmitBenefit = Claim_Benefit_page.tbl_ChooseNextStep(scmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(scmanagerdriver, "Admit Benefit", StepAdmitBenefit);
		Claim_Benefit_page.btn_Ok(scmanagerdriver).click();
		List<WebElement> StepAdmitBenefit1 = Claim_Benefit_page.tbl_ChooseNextStep(scmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(scmanagerdriver, "Admit Benefit", StepAdmitBenefit1);
		Claim_Benefit_page.btn_Ok(scmanagerdriver).click();
		// Navigate to Lump Sum Payments tab and Add
		Tab_LumpSumPayments_Benefit_page.tab_LumpSumPayments(scmanagerdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_AddPayments(scmanagerdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_SearchPayee(scmanagerdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_AddPayee(scmanagerdriver).click();
		// List<WebElement> availablePayeeTypes =
		// Tab_LumpSumPayments_page.tbl_AvailablePayeeRoles(cmanagerdriver).findElements(By.cssSelector("tbody
		// > tr"));
		// Selecting_RightElement.Select(cmanagerdriver, "Payee",
		// availablePayeeTypes, 0);
		// Tab_LumpSumPayments_page.btn_OKPayeeRoleSelection(cmanagerdriver).click();
		// Tab_LumpSumPayments_page.txt_FirstName(cmanagerdriver).sendKeys(arg0);
		Tab_LumpSumPayments_Benefit_page.txt_LastName(scmanagerdriver).sendKeys("sm");
		Tab_LumpSumPayments_Benefit_page.btn_Search(scmanagerdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_Select(scmanagerdriver).click();
		// List<WebElement> Payees =
		// Tab_LumpSumPayments_page.tbl_Payees(cmanagerdriver).findElements(By.cssSelector("tbody
		// > tr"));
		// Selecting_RightElement.Select(cmanagerdriver, "Payee", Payees, 1);
		Tab_LumpSumPayments_Benefit_page.btn_Select(scmanagerdriver).click();
		Select description = new Select(Tab_LumpSumPayments_Benefit_page.sel_Description(scmanagerdriver));
		description.selectByValue("1");
		Tab_LumpSumPayments_Benefit_page.txt_BasicPayeeAmount(scmanagerdriver).clear();
		// Enter Basic Payee Amount
		Tab_LumpSumPayments_Benefit_page.txt_BasicPayeeAmount(scmanagerdriver).sendKeys(SumInsured);
		Tab_LumpSumPayments_Benefit_page.txt_BasicAmountDistribution(scmanagerdriver).clear();
		Tab_LumpSumPayments_Benefit_page.txt_BasicAmountDistribution(scmanagerdriver).sendKeys(SumInsured);
		Tab_LumpSumPayments_Benefit_page.tabout_OutstandingAmount(scmanagerdriver).click();
		Tab_LumpSumPayments_Benefit_page.btn_SaveDue(scmanagerdriver).click();
		scmanagerdriver.quit();
	}

	@Test(priority = 2)
	public void FuneralEndtoEnd_LoginasSysAdmin() throws Exception {

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
		Claim_Benefit_page.lnk_Directclaim(sysadmindriver).click();
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
