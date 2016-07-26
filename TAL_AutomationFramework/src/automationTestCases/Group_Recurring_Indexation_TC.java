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
import appModule.Split_Date;
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

public class Group_Recurring_Indexation_TC {

	// test

	public WebDriver chiefdriver;
	public WebDriver sysadmindriver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private String ClaimNumber;
	private String BenefitNumber;
	private String IncurredDateDay;
	private String IncurredDateMonth;
	private String IncurredDateYear;
	private String AccidentDateDay;
	private String AccidentDateMonth;
	private String AccidentDateYear;
	private String SumInsured = "7000";
	private String ExecutionDate;

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

		String chiefURL = props.getProperty("URL_CHIEF");
		String systemAdminURL = props.getProperty("URL_SYSADMIN");

		String filename = props.getProperty("FILE");
		String path = props.getProperty("PATH");

		Constant.URL_CHIEF = chiefURL;
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

		// Removing the test case status and errors from previous test results
		// if any
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_claimNumber);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Result);
		ExcelUtils.setCellData("", iTestCaseRow, Constant.Col_Errors);

	}

	@Test
	public void Group_ClaimRecurring() throws Exception {
		chiefdriver = Utils.openBrowser(iTestCaseRow, Constant.URL_CHIEF);
		String sFirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_FirstName);
		String sLastName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LastName);
		String sGroupId = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_GroupId);
		String sPolicyNo = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_PolicyNo);
		String sBenefitType = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_BenefitType);
		String incurredDate = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_IncurredDate);
		String accidentDate = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AccidentDate);
		String accidentOrSickness = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AccidentSickness);

		System.out.println("group id is " + sGroupId);
		System.out.println("first name is " + sFirstName);
		System.out.println("last name is " + sLastName);

		ClaimIntake_page.btn_CaseSearch_OpenCase(chiefdriver).click();
		ClaimIntake_page.tab_CaseSearch_Party(chiefdriver).click();
		ClaimIntake_page.txt_FirstName(chiefdriver).sendKeys(sFirstName);
		ClaimIntake_page.txt_LastName(chiefdriver).sendKeys(sLastName);
		ClaimIntake_page.btn_Search(chiefdriver).click();

		// List<WebElement> allPersons =
		// ClaimIntake_page.tbl_PersonSearchResults(chiefdriver).findElements(By.cssSelector("tbody
		// > tr"));
		// Selecting_RightElement.Select(chiefdriver, sGroupId, allPersons,
		// 3);

		// List<WebElement> allProducts =
		// ClaimIntake_page.tbl_ListofPolicies(chiefdriver).findElements(By.cssSelector("tbody
		// > tr"));
		// Selecting_RightElement.Select(chiefdriver, sProduct, allProducts,
		// 1);

		Thread.sleep(2000);

		ClaimIntake_page.btn_ClaimsForPolicy_AddButton(chiefdriver).click();
		Thread.sleep(2000);
		// Select partition = new
		// Select(ClaimIntake_page.sel_Partitions(chiefdriver));
		// partition.selectByVisibleText("TAL Head Office");
		// ClaimIntake_page.btn_NextButton(chiefdriver).click();

		Select source = new Select(ClaimIntake_page.sel_Source(chiefdriver));
		source.selectByVisibleText("Phone");

		Select type = new Select(ClaimIntake_page.sel_Type(chiefdriver));
		type.selectByValue("3");
		Thread.sleep(1000);
		// ClaimIntake_page.chk_AreYouTalkingToInsured(chiefdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		Select title = new Select(ClaimIntake_page.sel_SelectTitle(chiefdriver));
		if ((title.getFirstSelectedOption().getText()).equals("Unknown")) {
			title.selectByVisibleText("Mr");
			Select gender = new Select(ClaimIntake_page.sel_SelectGender(chiefdriver));
			gender.selectByVisibleText("Male");
		}

		if (ClaimIntake_page.txt_DOBDay(chiefdriver).getText().equals("")) {

			ClaimIntake_page.txt_DOBDay(chiefdriver).sendKeys("16");
			Select DOBMonth = new Select(ClaimIntake_page.sel_DOBMonth(chiefdriver));
			DOBMonth.selectByVisibleText("JUN");
			ClaimIntake_page.txt_DOBYear(chiefdriver).sendKeys("1971");

		}

		Select prefContMet = new Select(ClaimIntake_page.sel_PreferredContactMethod(chiefdriver));
		//if ((prefContMet.getFirstSelectedOption().getText()).equals("Unknown")) {
			prefContMet.selectByValue("2");
		//}
		Thread.sleep(2000);
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();
		Thread.sleep(2000);

		// Event And Policy Details Page
		// Enter Incurred Date
		IncurredDateDay = Split_Date.Date(incurredDate, 1);
		IncurredDateMonth = Split_Date.Date(incurredDate, 2);
		IncurredDateYear = Split_Date.Date(incurredDate, 3);
		ClaimIntake_page.txt_DayIncurredDate(chiefdriver).sendKeys(IncurredDateDay);
		Select monthIncurredDate = new Select(ClaimIntake_page.sel_MonthIncurredDate(chiefdriver));
		monthIncurredDate.selectByVisibleText(IncurredDateMonth);
		ClaimIntake_page.txt_YearIncurredDate(chiefdriver).sendKeys(IncurredDateYear);
		Thread.sleep(2000);
		// Enter Accident Date
		AccidentDateDay = Split_Date.Date(accidentDate, 1);
		AccidentDateMonth = Split_Date.Date(accidentDate, 2);
		AccidentDateYear = Split_Date.Date(accidentDate, 3);
		ClaimIntake_page.txt_DayAccidentDate(chiefdriver).sendKeys(AccidentDateDay);
		Select monthAccidentDate = new Select(ClaimIntake_page.sel_MonthAccidentDate(chiefdriver));
		monthAccidentDate.selectByVisibleText(AccidentDateMonth);
		ClaimIntake_page.txt_YearAccidentDate(chiefdriver).sendKeys(AccidentDateYear);
		Thread.sleep(2000);
		// Select Accident/Sickness/Unemployment
		Select eventType = new Select(ClaimIntake_page.sel_AccidentSicknessUnemployment(chiefdriver));
		eventType.selectByVisibleText(accidentOrSickness);
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		//Policy Details Page
		// Search Group Policy
		ClaimIntake_page.btn_GroupClaim_AddContractsForClaim(chiefdriver).click();
		ClaimIntake_page.tab_GroupClaim_PolicySearch(chiefdriver).click();
		ClaimIntake_page.txt_GroupClaim_PolicyNumber(chiefdriver).sendKeys(sPolicyNo);
		ClaimIntake_page.btn_GroupClaim_PolicySearch(chiefdriver).click();
		ClaimIntake_page.btn_Select(chiefdriver).click();
		// Thread.sleep(3000);
		List<WebElement> allDivisions = ClaimIntake_page.tbl_Divisions(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(chiefdriver, "Personal", allDivisions, 0);

		List<WebElement> allClasses = ClaimIntake_page.tbl_Classes(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Concatenate(chiefdriver, "180 Days", "5 Years", allClasses, 2, 3);
		ClaimIntake_page.btn_LinkDivsionClass(chiefdriver).click();

		Thread.sleep(3000);
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Selecting Right BenefitType
		List<WebElement> allBenefitTypes = ClaimIntake_page.tbl_ListofBenefitTypes(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(chiefdriver, sBenefitType, allBenefitTypes, 1);
		ClaimIntake_page.btn_OpenBenefit(chiefdriver).click();
		ClaimIntake_page.tab_Benefit_CalculationParameters(chiefdriver).click();
		ClaimIntake_page.txt_FrequencyAmount(chiefdriver).clear();
		ClaimIntake_page.txt_FrequencyAmount(chiefdriver).sendKeys(SumInsured);
		Thread.sleep(3000);
		Claim_Benefit_page.btn_Ok(chiefdriver).click();
		ClaimIntake_page.btn_SelectBenefitRight(chiefdriver).click();
		Thread.sleep(3000);
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Occupation Details Page
		ClaimIntake_page.btn_SearchEmployer(chiefdriver).click();
		ClaimIntake_page.txt_Organisation(chiefdriver).sendKeys("C");
		ClaimIntake_page.btn_Search(chiefdriver).click();
		ClaimIntake_page.btn_Select(chiefdriver).click();
		Select occupation = new Select(ClaimIntake_page.sel_Occupation(chiefdriver));
		occupation.selectByValue("18");
		Select occupationCategory = new Select(ClaimIntake_page.sel_OccupationCategory(chiefdriver));
		occupationCategory.selectByValue("2");
		Thread.sleep(3000);
		//ClaimIntake_page.btn_QuickAddEmployer(chiefdriver).click();
		//Thread.sleep(3000);

		// Earning Details
		Select EarningType = new Select(ClaimIntake_page.sel_EarningType(chiefdriver));
		EarningType.selectByVisibleText("Base at Date of Claim");
		Thread.sleep(3000);
		Select EarningBasis = new Select(ClaimIntake_page.sel_EarningBasis(chiefdriver));
		EarningBasis.selectByVisibleText("Monthly");
		ClaimIntake_page.txt_EarningsAmount(chiefdriver).clear();
		ClaimIntake_page.txt_EarningsAmount(chiefdriver).sendKeys("3000");
		ClaimIntake_page.btn_QuickAddEarnings(chiefdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Other Income
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();
		Thread.sleep(5000);

		// Medical Details Page
		// Add a Medical Provider
		//ClaimIntake_page.btn_AddMedicalProvider(chiefdriver).click();
		//ClaimIntake_page.txt_LastName(chiefdriver).sendKeys("ph");
		//ClaimIntake_page.btn_Search(chiefdriver).click();
		//ClaimIntake_page.btn_Select(chiefdriver).click();
		//Thread.sleep(1000);
		// Input Medical Code
		ClaimIntake_page.txt_DiagnosisCode(chiefdriver).sendKeys("eye");
		ClaimIntake_page.btn_SearchDiagnosisCode(chiefdriver).click();
		ClaimIntake_page.btn_QuickAddDiagnosisCode(chiefdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Notifier Details Page
		// ClaimIntake_page.btn_SearchNotifier(chiefdriver).click();
		// ClaimIntake_page.txt_FirstName(chiefdriver).sendKeys("A");
		// ClaimIntake_page.txt_LastName(chiefdriver).sendKeys("pe");
		// ClaimIntake_page.btn_Search(chiefdriver).click();
		// ClaimIntake_page.btn_Select(chiefdriver).click();
		// Select NotifierTitle = new
		// Select(ClaimIntake_page.sel_SelectTitle(chiefdriver));
		// if
		// ((NotifierTitle.getFirstSelectedOption().getText()).equals("Unknown"))
		// {
		// NotifierTitle.selectByVisibleText("Sir");
		// Select NotifierGender = new
		// Select(ClaimIntake_page.sel_SelectGender(chiefdriver));
		// NotifierGender.selectByVisibleText("Male");
		// }

		// Select relationship = new
		// Select(ClaimIntake_page.sel_RelationshipToInsured(chiefdriver));
		// relationship.selectByValue("3");
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Adviser Details Page
		ClaimIntake_page.btn_SearchNotifier(chiefdriver).click();
		ClaimIntake_page.txt_FirstName(chiefdriver).sendKeys("A");
		ClaimIntake_page.txt_LastName(chiefdriver).sendKeys("pe");
		ClaimIntake_page.btn_Search(chiefdriver).click();
		ClaimIntake_page.btn_Select(chiefdriver).click();
		Select AdviserTitle = new Select(ClaimIntake_page.sel_SelectTitle(chiefdriver));
		if ((AdviserTitle.getFirstSelectedOption().getText()).equals("Unknown")) {
			AdviserTitle.selectByVisibleText("Miss");
			Select AdviserGender = new Select(ClaimIntake_page.sel_SelectGender(chiefdriver));
			AdviserGender.selectByVisibleText("Female");
		}

		Select AdviserprefContMet = new Select(ClaimIntake_page.sel_PreferredContactMethod(chiefdriver));
		if ((AdviserprefContMet.getFirstSelectedOption().getText()).equals("Unknown")) {
			AdviserprefContMet.selectByValue("4");
		}
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Contact Details Page
		// ClaimIntake_page.chk_PrimaryContact(chiefdriver).click();
		// ClaimIntake_page.btn_ApplyPrimaryContact(chiefdriver).click();
		ClaimIntake_page.btn_ClaimIntakeNextButton(chiefdriver).click();

		// Capture Claim Number
		ClaimNumber = Claim_Benefit_page.txt_ClaimNumber(chiefdriver).getText();
		System.out.println("Claim Number is: " + ClaimNumber);

		ExecutionDate = Claim_Benefit_page.txt_CreationDate(chiefdriver).getText();
		System.out.println("Execution Date is: " + ExecutionDate);

		// Send Claim Number to Excel
		// ExcelUtils.setCellData(ClaimNumber, iTestCaseRow,
		// Constant.Col_claimNumber);

		// Suppress Managed Requirements
		Suppress_ManagedRequirement.SupressManagedRequirement(chiefdriver);

		// Enter PDI Information
		Tab_Occupations_Claim_page.btn_OccupationTab(chiefdriver).click();
		Select PDI = new Select(Tab_Occupations_Claim_page.sel_SelectPDI(chiefdriver));
		PDI.selectByVisibleText("PDI");
		Thread.sleep(4000);
		Select PDIEarningBasis = new Select(ClaimIntake_page.sel_EarningBasis(chiefdriver));
		PDIEarningBasis.selectByValue("2");
		Thread.sleep(4000);
		ClaimIntake_page.txt_EarningsAmount(chiefdriver).clear();
		ClaimIntake_page.txt_EarningsAmount(chiefdriver).sendKeys("5000");
		ClaimIntake_page.btn_QuickAddEarnings(chiefdriver).click();

		// Tasks Tab
		Tab_Tasks_Claim_page.tab_task(chiefdriver).click();

		// Move claim to Open-TeleClaim
		// Close Review Claim Notification task
		List<WebElement> TaskReviewNewClaimNotification = Tab_Tasks_Claim_page.tbl_TasksList(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(chiefdriver, "Review New Claim Notification", TaskReviewNewClaimNotification,
				2);
		List<WebElement> StepOpenInReviewClaim = Claim_Benefit_page.tbl_ChooseNextStep(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		FindRightElement.SelectRightElement(chiefdriver, "Open - In Review", StepOpenInReviewClaim);
		Claim_Benefit_page.btn_Ok(chiefdriver).click();
		//List<WebElement> StepNoAutomatedTelephony = Claim_Benefit_page.tbl_ChooseNextStep(chiefdriver)
			//	.findElements(By.cssSelector("tbody > tr"));
		//FindRightElement.SelectRightElement(chiefdriver, "NO - Do not issue the Automated Initial Notification Pack.",
			//	StepNoAutomatedTelephony);
		//Claim_Benefit_page.btn_Ok(chiefdriver).click();

		// Close Create Initial Notification Pack
		//List<WebElement> TaskCreateInitialNotificationTask = Tab_Tasks_Claim_page.tbl_TasksList(chiefdriver)
			//	.findElements(By.cssSelector("tbody > tr"));
		//Closing_Right_Task.SelectRightTask(chiefdriver, "Create Initial Notification Pack",
			//	TaskCreateInitialNotificationTask, 2);

		// Navigate to Coverages tab and Create Benefit
		Tab_Coverages_page.tab_CoveragesTab(chiefdriver).click();
		Thread.sleep(5000);
		List<WebElement> allBenefitRights = Tab_Coverages_page.tbl_BenefitRights(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Selecting_RightElement.Select(chiefdriver, "Selected", allBenefitRights, 6);
		Tab_Coverages_page.btn_CreateBen(chiefdriver).click();

		// Navigate to Recurring Payments tab and capture Benefit Start Date
		// Tab_RecurringPayments_Benefit_page.tab_RecurringPayments(chiefdriver).click();
		// String
		// BenefitStartDate=Tab_RecurringPayments_Benefit_page.txt_BenefitStartDate(chiefdriver).getText();

		// Capture BenefitNumber
		WebElement ElementBenefitNumber = chiefdriver.findElement(By.xpath(".//*[@id='tab-1']/div[1]/h2/span"));
		BenefitNumber = ElementBenefitNumber.getText();
		System.out.println("Benefit Number is: " + BenefitNumber);

		// Suppress Validations
		appModule.Suppress_Validations.SupressValidations(chiefdriver);

		// Disable tax as there is currently an issue
		Tab_RecurringPayments_Benefit_page.tab_RecurringPayments(chiefdriver).click();
		Tab_RecurringPayments_Benefit_page.subtab_Amounts(chiefdriver).click();
		Tab_RecurringPayments_Benefit_page.subtab_Amounts_Tax(chiefdriver).click();
		Tab_RecurringPayments_Benefit_page.btn_EditPAYGTax(chiefdriver).click();
		Tab_RecurringPayments_Benefit_page.chk_TaxAppliesToBenefit(chiefdriver).click();
		Tab_RecurringPayments_Benefit_page.btn_OKTaxAppliesToBenefit(chiefdriver).click();

		// Go to Benefit-Tasks Tab
		Tab_Tasks_Benefit_page.tab_TasksTab(chiefdriver).click();
		List<WebElement> allBenefitTasks = Tab_Tasks_Benefit_page.tbl_TasksList(chiefdriver)
				.findElements(By.cssSelector("tbody > tr"));
		Closing_Right_Task.SelectRightTask(chiefdriver, "Assess Benefit", allBenefitTasks, 2);

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
		PaymentsWizard_Benefit_page.txt_DayBenefitEndYear(chiefdriver).sendKeys("2017");
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
		sysadmindriver = Utils.openBrowser(iTestCaseRow, Constant.URL_SYSADMIN);
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
			ExcelUtils.setCellData(ExecutionDate, iTestCaseRow, Constant.Col_ExecutionDate);
			break;
		case ITestResult.FAILURE:
			if (ClaimNumber != "") {
				ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
				ExcelUtils.setCellData(ClaimNumber, iTestCaseRow, Constant.Col_claimNumber);
				ExcelUtils.setCellData(ExecutionDate, iTestCaseRow, Constant.Col_ExecutionDate);
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
