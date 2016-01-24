package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class OpenParty_page {
	private static WebElement element = null;

	public static WebElement btn_OpenParty(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='MENUBAR.OperationsMenu_'][id$='_MENUBAR.OperationsMenu_MENUITEM.SearchParties_MENUITEM.SearchPartieslink']");
		element = driver.findElement(By.cssSelector(
				"*[id^='MENUBAR.OperationsMenu_'][id$='_MENUBAR.OperationsMenu_MENUITEM.SearchParties_MENUITEM.SearchPartieslink']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Organisation(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='DynamicPartySearchWidget_claimant_'][id$='_Organisation_GROUP']");
		element = driver
				.findElement(By.cssSelector("*[id^='DynamicPartySearchWidget_claimant_'][id$='_Organisation_GROUP']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_Add(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='DynamicPartySearchWidget_claimant_'][id$='_addButton']");
		element = driver.findElement(By.cssSelector("*[id^='DynamicPartySearchWidget_claimant_'][id$='_addButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_OkPartitionButton(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='selectPartitionPopup_'][id$='_okButtonBean']");
		element = driver.findElement(By.cssSelector("*[id^='selectPartitionPopup_'][id$='_okButtonBean']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_OrgPrefContactMethod(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='EditOrganisationDetailsWidget_'][id$='_preferredContactMethodEnum']");
		element = driver.findElement(
				By.cssSelector("*[id^='EditOrganisationDetailsWidget_'][id$='_preferredContactMethodEnum']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_AddNewAddress(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AddressesForPartyWidget_'][id$='_NewButton']");
		element = driver.findElement(By.cssSelector("*[id^='AddressesForPartyWidget_'][id$='_NewButton']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_AddressType(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AddressesForPartyWidget_'][id$='_AddUsageDropDown_DropDown']");
		element = driver
				.findElement(By.cssSelector("*[id^='AddressesForPartyWidget_'][id$='_AddUsageDropDown_DropDown']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_OkAddressType(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AddressesForPartyWidget_'][id$='_AddUsageDropDown_yes']");
		element = driver.findElement(By.cssSelector("*[id^='AddressesForPartyWidget_'][id$='_AddUsageDropDown_yes']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_AddressCountry(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='EditAddressWidget_'][id$='_Country']");
		element = driver.findElement(By.cssSelector("*[id^='EditAddressWidget_'][id$='_Country']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_AddressLine1(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AUEditCountryFormatAddressWidget_'][id$='_Address_1']");
		element = driver.findElement(By.cssSelector("*[id^='AUEditCountryFormatAddressWidget_'][id$='_Address_1']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_AddressLine2(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AUEditCountryFormatAddressWidget_'][id$='_Unit_Number']");
		element = driver.findElement(By.cssSelector("*[id^='AUEditCountryFormatAddressWidget_'][id$='_Unit_Number']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_AddressSuburb(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AUEditCountryFormatAddressWidget_'][id$='_Suburb']");
		element = driver.findElement(By.cssSelector("*[id^='AUEditCountryFormatAddressWidget_'][id$='_Suburb']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_AddressPostcode(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AUEditCountryFormatAddressWidget_'][id$='_Postcode']");
		element = driver.findElement(By.cssSelector("*[id^='AUEditCountryFormatAddressWidget_'][id$='_Postcode']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_AddressState(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='AUEditCountryFormatAddressWidget_'][id$='_State']");
		element = driver.findElement(By.cssSelector("*[id^='AUEditCountryFormatAddressWidget_'][id$='_State']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_PhoneIntCode(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='EditContactMediaWidgetEditPhoneMediumWidget0_'][id$='_intCode']");
		element = driver
				.findElement(By.cssSelector("*[id^='EditContactMediaWidgetEditPhoneMediumWidget0_'][id$='_intCode']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_PhoneAreaCode(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='EditContactMediaWidgetEditPhoneMediumWidget0_'][id$='_areaCode']");
		element = driver
				.findElement(By.cssSelector("*[id^='EditContactMediaWidgetEditPhoneMediumWidget0_'][id$='_areaCode']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_PhoneTelNo(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='EditContactMediaWidgetEditPhoneMediumWidget0_'][id$='_telephoneNo']");
		element = driver.findElement(
				By.cssSelector("*[id^='EditContactMediaWidgetEditPhoneMediumWidget0_'][id$='_telephoneNo']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_TradingAs(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='EditOrganisationDetailsWidget_'][id$='_Organisation_Legal_Business_Name']");
		element = driver.findElement(
				By.cssSelector("*[id^='EditOrganisationDetailsWidget_'][id$='_Organisation_Legal_Business_Name']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement txt_ABN(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='EditOrganisationDetailsWidget_'][id$='_registrationNumber']");
		element = driver
				.findElement(By.cssSelector("*[id^='EditOrganisationDetailsWidget_'][id$='_registrationNumber']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement tab_PartyRoles(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='tpd_'][id$='_FINEOS.PartyManager.OrgDetails.Organisation.Unknown_partyroles_cell']");
		element = driver.findElement(By.cssSelector(
				"*[id^='tpd_'][id$='_FINEOS.PartyManager.OrgDetails.Organisation.Unknown_partyroles_cell']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_AddPartyRoles(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='PartyRolesForPartyListviewWidget_'][id$='_PartyRolesForParty_cmdAdd']");
		element = driver.findElement(
				By.cssSelector("*[id^='PartyRolesForPartyListviewWidget_'][id$='_PartyRolesForParty_cmdAdd']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement sel_PartyRoleType(WebDriver driver) {
		Waitutil.waituntilclickabale(driver,
				"*[id^='PartyRolesForPartyListviewWidget_'][id$='_AddPRTDropDown_DropDown']");
		element = driver.findElement(
				By.cssSelector("*[id^='PartyRolesForPartyListviewWidget_'][id$='_AddPRTDropDown_DropDown']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}

	public static WebElement btn_OkPartyRoleType(WebDriver driver) {
		Waitutil.waituntilclickabale(driver, "*[id^='PartyRolesForPartyListviewWidget_'][id$='_AddPRTDropDown_yes']");
		element = driver
				.findElement(By.cssSelector("*[id^='PartyRolesForPartyListviewWidget_'][id$='_AddPRTDropDown_yes']"));
		utility.Waitutil.implicitwait(driver);
		return element;
	}
}
