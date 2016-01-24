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

import appModule.Closing_AllElements;
import appModule.Closing_Right_Task;
import appModule.FindRightElement;
import appModule.Selecting_RightElement;
import appModule.Suppress_ManagedRequirement;
import pageObjects.ClaimIntake_page;
import pageObjects.Claim_Benefit_page;
import pageObjects.PaymentsWizard_Benefit_page;
import pageObjects.Tab_Coverages_page;
import pageObjects.Tab_Occupations_Claim_page;
import pageObjects.Tab_PaymentHistory_Benefit_page;
import pageObjects.Tab_RecurringPayments_Benefit_page;
import pageObjects.Tab_Tasks_Benefit_page;
import pageObjects.Tab_Tasks_Claim_page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Z_RecurringEndToEnd_TC {

	public WebDriver cmanagerdriver;
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
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "TestCases");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		cmanagerdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_CMANAGER);

		// Removing the test case status and errors from previous test results
		// if any
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_claimNumber);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Result);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Errors);

	}

	@Test
	public void RecurringEndtoEnd() throws Exception {

		String sFirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_FirstName);
		String sLastName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LastName);
		String sGroupId = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_GroupId);
		String sProduct = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Product);
		String sBenefitType = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_BenefitType);

		// String sGroupId = "101681734";
		// String sProduct="IPP2";
		// String sBenefitType="Income Protection Benefit";

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

		Thread.sleep(2000);

		ClaimIntake_page.btn_ClaimsForPolicy_AddButton(cmanagerdriver).click();
		Thread.sleep(2000);
		Select partition = new Select(ClaimIntake_page.sel_Partitions(cmanagerdriver));
		partition.selectByVisibleText("TAL Head Office");
		ClaimIntake_page.btn_NextButton(cmanagerdriver).click();

		Select type = new Select(ClaimIntake_page.sel_Type(cmanagerdriver));
		type.selectByValue("3");
		// ClaimIntake_page.chk_AreYouTalkingToInsured(cmanagerdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		Select prefContMet = new Select(ClaimIntake_page.sel_PreferredContactMethod(cmanagerdriver));
		prefContMet.selectByValue("3");
		Thread.sleep(2000);
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();
		Thread.sleep(2000);

		// Enter Incurred Date
		ClaimIntake_page.txt_DayIncurredDate(cmanagerdriver).sendKeys("12");
		Select monthIncurredDate = new Select(ClaimIntake_page.sel_MonthIncurredDate(cmanagerdriver));
		monthIncurredDate.selectByValue("9");
		ClaimIntake_page.txt_YearIncurredDate(cmanagerdriver).sendKeys("2015");
		Thread.sleep(2000);
		// Enter Accident Date
		ClaimIntake_page.txt_DayAccidentDate(cmanagerdriver).sendKeys("10");
		Select monthAccidentDate = new Select(ClaimIntake_page.sel_MonthAccidentDate(cmanagerdriver));
		monthAccidentDate.selectByValue("9");
		ClaimIntake_page.txt_YearAccidentDate(cmanagerdriver).sendKeys("2015");

		// Select Accident/Sickness/Unemployment
		Select eventType = new Select(ClaimIntake_page.sel_AccidentSicknessUnemployment(cmanagerdriver));
		eventType.selectByValue("1");
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();
		// Enter Medical Code
		// ClaimIntake_page.txt_DiagnosisCode(cmanagerdriver).sendKeys("ear");
		// ClaimIntake_page.btn_SearchDiagnosisCode(cmanagerdriver).click();
		// ClaimIntake_page.btn_QuickAddDiagnosisCode(cmanagerdriver).click();
		// ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		Thread.sleep(4000);
		// Selecting Right BenefitType
		List<WebElement> allBenefitTypes = ClaimIntake_page.tbl_ListofBenefitTypes(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(cmanagerdriver, sBenefitType, allBenefitTypes, 1);
		Thread.sleep(5000);
		ClaimIntake_page.btn_SelectBenefitRight(cmanagerdriver).click();
		Thread.sleep(5000);
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Occupation Details Page

		ClaimIntake_page.btn_SearchEmployer(cmanagerdriver).click();
		ClaimIntake_page.txt_Organisation(cmanagerdriver).sendKeys("C");
		ClaimIntake_page.btn_Search(cmanagerdriver).click();
		ClaimIntake_page.btn_Select(cmanagerdriver).click();
		Select occupation = new Select(ClaimIntake_page.sel_Occupation(cmanagerdriver));
		occupation.selectByValue("20");
		Select occupationCategory = new Select(ClaimIntake_page.sel_OccupationCategory(cmanagerdriver));
		occupationCategory.selectByValue("2");

		// Earning Details
		Select PCIEarningBasis = new Select(ClaimIntake_page.sel_EarningBasis(cmanagerdriver));
		PCIEarningBasis.selectByValue("2");
		ClaimIntake_page.txt_EarningsAmount(cmanagerdriver).clear();
		ClaimIntake_page.txt_EarningsAmount(cmanagerdriver).sendKeys("1500");
		ClaimIntake_page.btn_QuickAddEarnings(cmanagerdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Other Income
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Medical Details Page
		// Add a Medical Provider
		ClaimIntake_page.btn_AddMedicalProvider(cmanagerdriver).click();
		ClaimIntake_page.txt_LastName(cmanagerdriver).sendKeys("ph");
		ClaimIntake_page.btn_Search(cmanagerdriver).click();
		ClaimIntake_page.btn_Select(cmanagerdriver).click();
		Thread.sleep(1000);
		ClaimIntake_page.txt_DiagnosisCode(cmanagerdriver).sendKeys("ear");
		ClaimIntake_page.btn_SearchDiagnosisCode(cmanagerdriver).click();
		ClaimIntake_page.btn_QuickAddDiagnosisCode(cmanagerdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Notifier Details Page
		ClaimIntake_page.btn_SearchNotifier(cmanagerdriver).click();
		// ClaimIntake_page.txt_FirstName(cmanagerdriver).sendKeys("A");
		ClaimIntake_page.txt_LastName(cmanagerdriver).sendKeys("pe");
		ClaimIntake_page.btn_Search(cmanagerdriver).click();
		ClaimIntake_page.btn_Select(cmanagerdriver).click();
		Select title = new Select(ClaimIntake_page.sel_SelectTitle(cmanagerdriver));
		title.selectByVisibleText("Mr");
		Select gender = new Select(ClaimIntake_page.sel_SelectGender(cmanagerdriver));
		gender.selectByVisibleText("Male");
		Select relationship = new Select(ClaimIntake_page.sel_RelationshipToInsured(cmanagerdriver));
		relationship.selectByValue("6");
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();
		// Contact Details Page
		ClaimIntake_page.chk_PrimaryContact(cmanagerdriver).click();
		ClaimIntake_page.btn_ApplyPrimaryContact(cmanagerdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(cmanagerdriver).click();

		// Capture Claim Number
		WebElement ElementClaimNumber = cmanagerdriver.findElement(By.xpath(".//*[@id='tab-1']/div[1]/h2/span"));
		String ClaimNumber = ElementClaimNumber.getText();
		System.out.println("Claim Number is: " + ClaimNumber);

		// Send Claim Number to Excel
		ExcelUtils.setCellData(ClaimNumber, iTestCaseRow, Constant.Col_claimNumber);

		// Suppress Managed Requirements
		Suppress_ManagedRequirement.SupressManagedRequirement(cmanagerdriver);

		// Enter PDI Information
		Tab_Occupations_Claim_page.btn_OccupationTab(cmanagerdriver).click();
		Select PDI = new Select(Tab_Occupations_Claim_page.sel_SelectPDI(cmanagerdriver));
		PDI.selectByVisibleText("PDI");
		Thread.sleep(4000);
		Select PDIEarningBasis = new Select(ClaimIntake_page.sel_EarningBasis(cmanagerdriver));
		PDIEarningBasis.selectByValue("2");
		Thread.sleep(4000);
		ClaimIntake_page.txt_EarningsAmount(cmanagerdriver).clear();
		ClaimIntake_page.txt_EarningsAmount(cmanagerdriver).sendKeys("2000");
		ClaimIntake_page.btn_QuickAddEarnings(cmanagerdriver).click();

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
		Thread.sleep(5000);
		List<WebElement> allBenefitRights = Tab_Coverages_page.tbl_BenefitRights(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(cmanagerdriver, "Selected", allBenefitRights, 6);
		Tab_Coverages_page.btn_CreateBen(cmanagerdriver).click();

		// Navigate to Recurring Payments tab and capture Benefit Start Date
		// Tab_RecurringPayments_Benefit_page.tab_RecurringPayments(cmanagerdriver).click();
		// String
		// BenefitStartDate=Tab_RecurringPayments_Benefit_page.txt_BenefitStartDate(cmanagerdriver).getText();

		// Go to Benefit-Tasks Tab
		Tab_Tasks_Benefit_page.tab_TasksTab(cmanagerdriver).click();
		List<WebElement> allBenefitTasks = Tab_Tasks_Benefit_page.tbl_TasksList(cmanagerdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(cmanagerdriver, "Assess Benefit", allBenefitTasks, 2);

		// Capture BenefitNumber
		WebElement ElementBenefitNumber = cmanagerdriver.findElement(By.xpath(".//*[@id='tab-1']/div[1]/h2/span"));
		String BenefitNumber = ElementBenefitNumber.getText();
		System.out.println("Benefit Number is: " + BenefitNumber);
		cmanagerdriver.quit();

		// Login as Chief
		WebDriver chiefdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_CHIEF);
		ClaimIntake_page.btn_CaseSearch_OpenCase(chiefdriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(chiefdriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(chiefdriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(chiefdriver).click();

		// Suppress Validations
		appModule.Suppress_Validations.SupressValidations(chiefdriver);

		// Admit the Benefit
		Claim_Benefit_page.btn_MoveToNextStatus(chiefdriver).click();
		List<WebElement> StepAdmitBenefit = Claim_Benefit_page.tbl_ChooseNextStep(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(chiefdriver, "Admit Benefit", StepAdmitBenefit);
		Claim_Benefit_page.btn_Ok(chiefdriver).click();
		List<WebElement> StepAdmitBenefit1 = Claim_Benefit_page.tbl_ChooseNextStep(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(chiefdriver, "Admit Benefit", StepAdmitBenefit1);
		Claim_Benefit_page.btn_Ok(chiefdriver).click();

		// Set Up Initial Recurring Payments via wizard
		PaymentsWizard_Benefit_page.wiz_Payments(chiefdriver).click();
		PaymentsWizard_Benefit_page.sel_SetUpInitialRecurringPayments(chiefdriver).click();
		// Select Payee Details
		PaymentsWizard_Benefit_page.btn_NextButton(chiefdriver).click();
		// Set Payment Dates
		String BenefitEndDay = PaymentsWizard_Benefit_page.rec_BenefitEndDay(chiefdriver).getAttribute("value");
		System.out.println("Benefit End Day is: " + BenefitEndDay);
		String BenefitEndMonth = PaymentsWizard_Benefit_page.rec_BenefitEndMonth(chiefdriver).getAttribute("value");
		System.out.println("Benefit End Month is: " + BenefitEndMonth);
		String BenefitEndYear = PaymentsWizard_Benefit_page.rec_BenefitEndYear(chiefdriver).getAttribute("value");
		System.out.println("Benefit End Year is: " + BenefitEndYear);
		PaymentsWizard_Benefit_page.chk_AdvancePay(chiefdriver).click();
		PaymentsWizard_Benefit_page.btn_NextButton(chiefdriver).click();
		// Set GBA Adjustments
		PaymentsWizard_Benefit_page.btn_NextButton(chiefdriver).click();
		// Set NBA Adjustments
		PaymentsWizard_Benefit_page.btn_NextButton(chiefdriver).click();
		// Set Balanced Payee Adjustments
		PaymentsWizard_Benefit_page.btn_NextButton(chiefdriver).click();
		// Set Activity Period
		PaymentsWizard_Benefit_page.txt_DayBenefitEndDay(chiefdriver).sendKeys(BenefitEndDay);
		PaymentsWizard_Benefit_page.txt_DayBenefitEndMonth(chiefdriver).sendKeys(BenefitEndMonth);
		PaymentsWizard_Benefit_page.txt_DayBenefitEndYear(chiefdriver).sendKeys(BenefitEndYear);
		Select periodStatus = new Select(PaymentsWizard_Benefit_page.sel_StatusActivityPeriod(chiefdriver));
		periodStatus.selectByVisibleText("Approved");
		PaymentsWizard_Benefit_page.btn_FinishPaymentSetUp(chiefdriver).click();
		chiefdriver.quit();

		// Login as GManager
		// WebDriver gmanagerdriver = Utils.openBrowser(iTestCaseRow,
		// Constant.gManagerURL);
		// ClaimIntake_page.btn_CaseSearch_OpenCase(gmanagerdriver).click();
		// ClaimIntake_page.tab_CaseSearch_Case(gmanagerdriver).click();
		// ClaimIntake_page.txt_CaseSearch_CaseNumber(gmanagerdriver).sendKeys(BenefitNumber);
		// ClaimIntake_page.btn_CaseSearch_Search(gmanagerdriver).click();

		// Approve the Pending Period
		// Tab_Benefit_Benefit_page.subtab_Periods(gmanagerdriver).click();
		// Tab_Benefit_Benefit_page.btn_EditCertificationPeriod(gmanagerdriver).click();
		// Select periodStatus = new Select
		// (Tab_Benefit_Benefit_page.sel_StatusActivityPeriod(gmanagerdriver));
		// periodStatus.selectByVisibleText("Approved");
		// Tab_Benefit_Benefit_page.btn_OKEditActivityPeriod(gmanagerdriver).click();
		// gmanagerdriver.quit();

		// Login as SystemAdmin
		WebDriver sysadmindriver = Utils.openBrowser(iTestCaseRow, Constant.URL_SYSADMIN);
		ClaimIntake_page.btn_CaseSearch_OpenCase(sysadmindriver).click();
		ClaimIntake_page.tab_CaseSearch_Case(sysadmindriver).click();
		ClaimIntake_page.txt_CaseSearch_CaseNumber(sysadmindriver).sendKeys(BenefitNumber);
		ClaimIntake_page.btn_CaseSearch_Search(sysadmindriver).click();
		// Approve Due Events
		Tab_RecurringPayments_Benefit_page.tab_RecurringPayments(sysadmindriver).click();
		Tab_RecurringPayments_Benefit_page.subtab_PaymentPlan(sysadmindriver).click();
		Tab_RecurringPayments_Benefit_page.chk_AllDueEvents(sysadmindriver).click();
		Tab_RecurringPayments_Benefit_page.btn_ApproveRecover(sysadmindriver).click();
		Claim_Benefit_page.btn_Ok(sysadmindriver).click();

		// Process Payments
		Tab_PaymentHistory_Benefit_page.tab_PaymentHistory(sysadmindriver).click();
		List<WebElement> Payments = Tab_PaymentHistory_Benefit_page.tbl_payments(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));

		for (int i = 1; i <= Payments.size(); i++) {

			List<WebElement> Payments1 = Tab_PaymentHistory_Benefit_page.tbl_payments(sysadmindriver)
					.findElements(By.cssSelector("tbody > tr"));
			Closing_AllElements.Process(sysadmindriver, "PendingActive", Payments1);
			Tab_PaymentHistory_Benefit_page.btn_ProcessPayment(sysadmindriver).click();
			Claim_Benefit_page.btn_Ok(sysadmindriver).click();
			System.out.println("Current row" + i);
			// Closing_AllElements.fff(sysadmindriver);
		}
		// Closing Recurring Payments Authorisation Required task
		Tab_Tasks_Benefit_page.tab_TasksTab(sysadmindriver).click();
		List<WebElement> TaskRecurringPaymentsAuthorisationRequired = Tab_Tasks_Benefit_page
				.tbl_TasksList(sysadmindriver).findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(sysadmindriver, "Recurring Payments Authorisation Required",
				TaskRecurringPaymentsAuthorisationRequired, 2);
		List<WebElement> StepPaymentsAuthorised = Claim_Benefit_page.tbl_ChooseNextStep(sysadmindriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(sysadmindriver, "Payments have been authorised", StepPaymentsAuthorised);
		Claim_Benefit_page.btn_Ok(sysadmindriver).click();

		// Closing Remaining Benefit Tasks
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
