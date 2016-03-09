package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class ClaimIntake_page {

	private static WebElement element = null;

	public static WebElement btn_CaseSearch_OpenCase(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='MENUBAR.OperationsMenu_'][id$='MENUBAR.OperationsMenu_MENUITEM.SearchCases_MENUITEM.SearchCaseslink']");
		element = driver.findElement(By.cssSelector(
				"*[id^='MENUBAR.OperationsMenu_'][id$='MENUBAR.OperationsMenu_MENUITEM.SearchCases_MENUITEM.SearchCaseslink']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tab_CaseSearch_Party(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='CaseSearchTabs_'][id$='s_caseSearchByParty_cell']");
		element = driver.findElement(By.cssSelector("*[id^='CaseSearchTabs_'][id$='s_caseSearchByParty_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_PartySearch_FirstName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearchCriteria_'][id$='_firstnames']");
		element = driver.findElement(By.cssSelector("*[id^='PersonSearchCriteria_'][id$='_firstnames']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_CaseSearch_FirstName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearchCriteria_'][id$='_firstnames']");
		element = driver.findElement(By.cssSelector("*[id^='PersonSearchCriteria_'][id$='_firstnames']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_CaseSearch_LastName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearchCriteria_'][id$='_lastName']");
		element = driver.findElement(By.cssSelector("*[id^='PersonSearchCriteria_'][id$='_lastName']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_CaseSearch_PersonSearchPolicy(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearch_Policy_'][id$='_searchButton']");
		element = driver.findElement(By.cssSelector("*[id^='PersonSearch_Policy_'][id$='_searchButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_ClaimsForPolicy_AddButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='CasesForPartyListviewWidget_'][id$='_CasesForParty_cmdAdd']");
		element = driver
				.findElement(By.cssSelector("*[id^='CasesForPartyListviewWidget_'][id$='_CasesForParty_cmdAdd']"));
		// element =
		// driver.findElement(By.xpath(".//*[@id='CasesForPartyListviewWidget_Policy_un23_CasesForParty_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_PersonSearchResults(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearchResults_'][id$='_PersonSearchResults']");
		element = driver.findElement(By.cssSelector("*[id^='PersonSearchResults_'][id$='_PersonSearchResults']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_ListofPolicies(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='ContractsForPartyWidget_Policy_'][id$='_ContractsForPartyListViewControl']");
		element = driver.findElement(
				By.cssSelector("*[id^='ContractsForPartyWidget_Policy_'][id$='_ContractsForPartyListViewControl']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_Partitions(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='SelectPartitionWidget_'][id$='partitionDropDown']");
		element = driver.findElement(By.cssSelector("*[id^='SelectPartitionWidget_'][id$='partitionDropDown']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_Source(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='intakeOpeningIndividualLife'][id$='_ClaimSource']");
		element = driver.findElement(By.cssSelector("*[id^='intakeOpeningIndividualLife'][id$='_ClaimSource']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_Type(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='intakeOpeningIndividualLife_'][id$='_ClaimType']");
		element = driver.findElement(By.cssSelector("*[id^='intakeOpeningIndividualLife_'][id$='_ClaimType']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement chk_AreYouTalkingToInsured(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='intakeOpeningIndividualLife_'][id$='_defaultPartyIsNotifier_CHECKBOX']");
		element = driver.findElement(
				By.cssSelector("*[id^='intakeOpeningIndividualLife_'][id$='_defaultPartyIsNotifier_CHECKBOX']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_NextButton(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='p'][id$='_next_cloned']");
		element = driver.findElement(By.cssSelector("*[id^='p'][id$='_next_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_ClaimIntakeNextButton(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='DriverDialogWidget_'][id$='_nextButton']");
		element = driver.findElement(By.cssSelector("*[id^='DriverDialogWidget_'][id$='_nextButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_PreferredContactMethod(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_preferredContactMethodEnum']");
		element = driver.findElement(
				By.cssSelector("*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_preferredContactMethodEnum']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_DOBDay(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		Waitutil.waituntilclickabale(driver, "*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_birthDate_Day']");
		element = driver
				.findElement(By.cssSelector("*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_birthDate_Day']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_DOBMonth(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_birthDate_Month']");
		element = driver
				.findElement(By.cssSelector("*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_birthDate_Month']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_DOBYear(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_birthDate_Year']");
		element = driver
				.findElement(By.cssSelector("*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_birthDate_Year']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchEmployer(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='OccupationDetailsWidget_'][id$='_RelControlEmployer_rcbSearchButton_RelControlEmployer']");
		element = driver.findElement(By.cssSelector(
				"*[id^='OccupationDetailsWidget_'][id$='_RelControlEmployer_rcbSearchButton_RelControlEmployer']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_Organisation(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_'][id$='_Name']");
		element = driver.findElement(By.cssSelector(
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_'][id$='_Name']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_OccupationCategory(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='OccupationDetailsWidget_'][id$='_JobStrenuous']");
		element = driver.findElement(By.cssSelector("*[id^='OccupationDetailsWidget_'][id$='_JobStrenuous']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_Occupation(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='OccupationDetailsWidget_'][id$='_AltEmploymentCategory']");
		element = driver.findElement(By.cssSelector("*[id^='OccupationDetailsWidget_'][id$='_AltEmploymentCategory']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_DayIncurredDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_IncurredDate_Day']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_IncurredDate_Day']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_MonthIncurredDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_IncurredDate_Month']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_IncurredDate_Month']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_YearIncurredDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_IncurredDate_Year']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_IncurredDate_Year']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_DayAccidentDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_EventDate_Day']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_EventDate_Day']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_MonthAccidentDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_EventDate_Month']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_EventDate_Month']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_YearAccidentDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_EventDate_Year']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_EventDate_Year']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_AccidentSicknessUnemployment(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='claimGeneralWidgetTag_'][id$='_EventType']");
		element = driver.findElement(By.cssSelector("*[id^='claimGeneralWidgetTag_'][id$='_EventType']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	// Medical Details
	public static WebElement btn_AddMedicalProvider(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='partyCaseRole_'][id$='_partyCaseRoles_cmdAdd']");
		element = driver.findElement(By.cssSelector("*[id^='partyCaseRole_'][id$='_partyCaseRoles_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_DiagnosisCode(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='DiagnosisCodes_'][id$='_SearchTextBox']");
		element = driver.findElement(By.cssSelector("*[id^='DiagnosisCodes_'][id$='_SearchTextBox']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchDiagnosisCode(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='DiagnosisCodes_'][id$='_searchbutton']");
		element = driver.findElement(By.cssSelector("*[id^='DiagnosisCodes_'][id$='_searchbutton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_QuickAddDiagnosisCode(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver, "*[id^='DiagnosisCodes_'][id$='_quickaddbutton']");
		element = driver.findElement(By.cssSelector("*[id^='DiagnosisCodes_'][id$='_quickaddbutton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	// Select Benefit Type
	public static WebElement tbl_ListofBenefitTypes(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		Waitutil.waituntilvisible(driver, "*[id^='BenefitRightsListViewWidget_'][id$='_BenefitRights']");
		element = driver.findElement(By.cssSelector("*[id^='BenefitRightsListViewWidget_'][id$='_BenefitRights']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SelectBenefitRight(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		Waitutil.waituntilvisible(driver, "*[id^='BenefitRightsListViewWidget_'][id$='_SelectBenefit']");
		element = driver.findElement(By.cssSelector("*[id^='BenefitRightsListViewWidget_'][id$='_SelectBenefit']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_SearchNotifier(WebDriver driver) {
		Waitutil.waituntilvisible(driver,
				"*[id^='SinglePartyCaseRoleWidget_partyCaseRole'][id$='_selectParty_rcbSearchButton_selectParty']");
		element = driver.findElement(By.cssSelector(
				"*[id^='SinglePartyCaseRoleWidget_partyCaseRole'][id$='_selectParty_rcbSearchButton_selectParty']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_FirstName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_'][id$='_First_Name']");
		element = driver.findElement(By.cssSelector(
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_'][id$='_First_Name']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_LastName(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_'][id$='_Last_Name']");
		element = driver.findElement(By.cssSelector(
				"*[id^='com.fineos.frontoffice.partymanager.partysearch.PersonOrganisationSearchSupportWidget_'][id$='_Last_Name']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Search(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='DynamicPartySearchWidget_'][id$='_searchButton']");
		element = driver.findElement(By.cssSelector("*[id^='DynamicPartySearchWidget_'][id$='_searchButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Select(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='p'][id$='_searchPageOk_cloned']");
		element = driver.findElement(By.cssSelector("*[id^='p'][id$='_searchPageOk_cloned']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_EarningType(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilvisible(driver, "*[id^='DatedEarningsListviewWidget_'][id$='_earningsTypeEnumDropDownBean']");
		element = driver.findElement(
				By.cssSelector("*[id^='DatedEarningsListviewWidget_'][id$='_earningsTypeEnumDropDownBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_EarningBasis(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilvisible(driver, "*[id^='DatedEarningsListviewWidget_'][id$='_Earnings_Basis']");
		element = driver.findElement(By.cssSelector("*[id^='DatedEarningsListviewWidget_'][id$='_Earnings_Basis']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_EarningsAmount(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='DatedEarningsListviewWidget_'][id$='_Earnings_Amount']");
		element = driver.findElement(By.cssSelector("*[id^='DatedEarningsListviewWidget_'][id$='_Earnings_Amount']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_QuickAddEarnings(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='DatedEarningsListviewWidget_'][id$='_QuickAddButton']");
		element = driver.findElement(By.cssSelector("*[id^='DatedEarningsListviewWidget_'][id$='_QuickAddButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_SelectTitle(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_titleEnum']");
		element = driver.findElement(By.cssSelector("*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_titleEnum']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_SelectGender(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_genderEnum']");
		element = driver.findElement(By.cssSelector("*[id^='PersonalDetailsWidget_partyCaseRole'][id$='_genderEnum']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_RelationshipToInsured(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='DataSetWidget0_'][id$='_RelationshipDropDown']");
		element = driver.findElement(By.cssSelector("*[id^='DataSetWidget0_'][id$='_RelationshipDropDown']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	// Contact Details Page
	public static WebElement chk_PrimaryContact(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='AddContactToClaim_'][id$='_IsNotifier_CHECKBOX']");
		element = driver.findElement(By.cssSelector("*[id^='AddContactToClaim_'][id$='_IsNotifier_CHECKBOX']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_ApplyPrimaryContact(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='AddContactToClaim_'][id$='_Apply']");
		element = driver.findElement(By.cssSelector("*[id^='AddContactToClaim_'][id$='_Apply']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_ListofNextSteps(WebDriver driver) {
		Waitutil.waituntilvisible(driver, "*[id^='CHOOSE_NEXT_STEP_WIDGET_'][id$='_StepListView']");
		element = driver.findElement(By.cssSelector("*[id^='CHOOSE_NEXT_STEP_WIDGET_'][id$='_StepListView']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tab_CaseSearch_Case(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='CaseSearchTabs_'][id$='_FINEOS.CaseManager.CaseSearch.Payments_searchByCase_cell']");
		element = driver.findElement(By.cssSelector(
				"*[id^='CaseSearchTabs_'][id$='_FINEOS.CaseManager.CaseSearch.Payments_searchByCase_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_CaseSearch_CaseNumber(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='CaseSearchByCaseWidget_'][id$='_caseNumber']");
		element = driver.findElement(By.cssSelector("*[id^='CaseSearchByCaseWidget_'][id$='_caseNumber']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_CaseSearch_Search(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='CaseSearchByCaseWidget_'][id$='_searchButton']");
		element = driver.findElement(By.cssSelector("*[id^='CaseSearchByCaseWidget_'][id$='_searchButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_GroupClaim_AddContractsForClaim(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ContractsForClaim_'][id$='_AddContract']");
		element = driver.findElement(By.cssSelector("*[id^='ContractsForClaim_'][id$='_AddContract']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tab_GroupClaim_PolicySearch(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='tdw_'][id$='_contractSearch_cell']");
		element = driver.findElement(By.cssSelector("*[id^='tdw_'][id$='_contractSearch_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_GroupClaim_PolicyNumber(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ContractSearchWidget_'][id$='_ReferenceNo']");
		element = driver.findElement(By.cssSelector("*[id^='ContractSearchWidget_'][id$='_ReferenceNo']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_GroupClaim_PolicySearch(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ContractSearchWidget_'][id$='_searchButton']");
		element = driver.findElement(By.cssSelector("*[id^='ContractSearchWidget_'][id$='_searchButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_Divisions(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver,
				"*[id^='GroupPolicyDivisionForClaimListviewWidget_'][id$='_GroupPolicyDivisionsListview']");
		element = driver.findElement(By.cssSelector(
				"*[id^='GroupPolicyDivisionForClaimListviewWidget_'][id$='_GroupPolicyDivisionsListview']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_Classes(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver,
				"*[id^='GroupPolicyClassesListviewWidget_'][id$='_GroupPolicyClassesListview']");
		element = driver.findElement(
				By.cssSelector("*[id^='GroupPolicyClassesListviewWidget_'][id$='_GroupPolicyClassesListview']"));
		// element =
		// driver.findElement(By.xpath(".//*[@id='GroupPolicyClassesListviewWidget_un69_GroupPolicyClassesListview']/tbody/tr[3]/td[1]"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_LinkDivsionClass(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='ClaimMemberDetailsWidget_'][id$='_linkButtonBean']");
		element = driver.findElement(By.cssSelector("*[id^='ClaimMemberDetailsWidget_'][id$='_linkButtonBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_SpanRight(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearchResults_'][id$='_PersonSearchResults_listNavRight']");
		element = driver
				.findElement(By.cssSelector("*[id^='PersonSearchResults_'][id$='_PersonSearchResults_listNavRight']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tbl_Play_NextButton(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PersonSearchResults_'][id$='_PersonSearchResults_cmdNext']");
		element = driver
				.findElement(By.cssSelector("*[id^='PersonSearchResults_'][id$='_PersonSearchResults_cmdNext']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_OpenBenefit(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='BenefitRightsListViewWidget_'][id$='_BenefitRights_cmdEdit']");
		element = driver
				.findElement(By.cssSelector("*[id^='BenefitRightsListViewWidget_'][id$='_BenefitRights_cmdEdit']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tab_Benefit_AmountDetails(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='BenefitRightTabbedDialogWidget_'][id$='AmountDetails_cell']");
		element = driver
				.findElement(By.cssSelector("*[id^='BenefitRightTabbedDialogWidget_'][id$='AmountDetails_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement chk_SumInsuredAtIncurredDate(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='LumpSumAmountWidget_'][id$='_overrideSumAssuredCheckBoxBean_CHECKBOX']");
		element = driver.findElement(
				By.cssSelector("*[id^='LumpSumAmountWidget_'][id$='_overrideSumAssuredCheckBoxBean_CHECKBOX']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_SumInsuredAtIncurredDate(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		Waitutil.waituntilclickabale(driver, "*[id^='LumpSumAmountWidget_'][id$='_Sum_Assured_at_Incurred_Date']");
		element = driver
				.findElement(By.cssSelector("*[id^='LumpSumAmountWidget_'][id$='_Sum_Assured_at_Incurred_Date']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_FlatAmount(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		Waitutil.waituntilclickabale(driver, "*[id^='SumAssuredBasisWidget_'][id$='_flatAmountMoneyBean']");
		element = driver.findElement(By.cssSelector("*[id^='SumAssuredBasisWidget_'][id$='_flatAmountMoneyBean']"));
		Thread.sleep(1000);
		utility.Waitutil.implicitwait(driver);
		return element;

	}

	public static WebElement txt_AutomaticAcceptanceLimit(WebDriver driver) throws InterruptedException {
		Waitutil.waituntilclickabale(driver, "*[id^='PaymentGroupDetailsWidget_'][id$='_AutoAcceptanceLimit']");
		element = driver.findElement(By.cssSelector("*[id^='PaymentGroupDetailsWidget_'][id$='_AutoAcceptanceLimit']"));
		utility.Waitutil.implicitwait(driver);
		return element;

	}

	public static WebElement tab_Benefit_CalculationParameters(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='BenefitRightTabbedDialogWidget_'][id$='_CalculationParameters_cell']");
		element = driver.findElement(
				By.cssSelector("*[id^='BenefitRightTabbedDialogWidget_'][id$='_CalculationParameters_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_FrequencyAmount(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		Waitutil.waituntilclickabale(driver, "*[id^='PaymentAmountDetailsWidget_'][id$='_frequencyAmount']");
		element = driver.findElement(By.cssSelector("*[id^='PaymentAmountDetailsWidget_'][id$='_frequencyAmount']"));
		Thread.sleep(1000);
		utility.Waitutil.implicitwait(driver);
		return element;

	}
}