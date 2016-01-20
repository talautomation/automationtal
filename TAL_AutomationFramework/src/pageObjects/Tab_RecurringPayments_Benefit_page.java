package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class Tab_RecurringPayments_Benefit_page {
	
private static WebElement element = null;
	
	public static WebElement tab_RecurringPayments(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='DisplayCaseTabbedDialogWidget_'][id$='CaseTabControlBean_Payments_cell']");
	    element = driver.findElement( By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='CaseTabControlBean_Payments_cell']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement txt_BenefitStartDate(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='PaymentDetailsPeriod_'][id$='_CommencementDate']");
	    element = driver.findElement( By.cssSelector("*[id^='PaymentDetailsPeriod_'][id$='_CommencementDate']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement subtab_PaymentPlan(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ViewPayments_'][id$='_FINEOS.BenefitsPaymentManager.Payments.Recurring_Benefit_PaymentPosition_cell']");
	    element = driver.findElement( By.cssSelector("*[id^='ViewPayments_'][id$='_FINEOS.BenefitsPaymentManager.Payments.Recurring_Benefit_PaymentPosition_cell']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement subtab_Amounts(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ViewPayments_'][id$='_FINEOS.BenefitsPaymentManager.Payments.Recurring_Benefit_PaymentAdjustments_cell']");
	    element = driver.findElement( By.cssSelector("*[id^='ViewPayments_'][id$='_FINEOS.BenefitsPaymentManager.Payments.Recurring_Benefit_PaymentAdjustments_cell']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement subtab_Amounts_Tax(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='PaymentAdjustments_'][id$='_FINEOS.BenefitsPaymentManager.PaymentsAdjustments.Recurring_Benefit_TaxInputs_cell']");
	    element = driver.findElement( By.cssSelector("*[id^='PaymentAdjustments_'][id$='_FINEOS.BenefitsPaymentManager.PaymentsAdjustments.Recurring_Benefit_TaxInputs_cell']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement btn_EditPAYGTax(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='AutoAdjustmentTaxInputWidget_PAYG_Income_Tax_'][id$='_editTaxInputButton']");
	    element = driver.findElement( By.cssSelector("*[id^='AutoAdjustmentTaxInputWidget_PAYG_Income_Tax_'][id$='_editTaxInputButton']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement chk_TaxAppliesToBenefit(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='AutoAdjustmentTaxInputWidget'][id$='_appliesToBenefitBean_CHECKBOX']");
	    element = driver.findElement( By.cssSelector("*[id^='AutoAdjustmentTaxInputWidget'][id$='_appliesToBenefitBean_CHECKBOX']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement chk_AllDueEvents(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		Waitutil.waituntilclickabale(driver,"*[id^='PaymentPostion_DueEventsListviewWidget_'][id$='_OffsetsAndDeductions_MasterMultiSelectCB_CHECKBOX']");
	    element = driver.findElement( By.cssSelector("*[id^='PaymentPostion_DueEventsListviewWidget_'][id$='_OffsetsAndDeductions_MasterMultiSelectCB_CHECKBOX']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement btn_ApproveRecover(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='PaymentPostion_DueEventsListviewWidget_'][id$='_ApproveOrRecover']");
	    element = driver.findElement( By.cssSelector("*[id^='PaymentPostion_DueEventsListviewWidget_'][id$='_ApproveOrRecover']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement btn_OKTaxAppliesToBenefit(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='EditAutoAdjustmentInputPopupWidget_'][id$='_okButtonBean']");
	    element = driver.findElement( By.cssSelector("*[id^='EditAutoAdjustmentInputPopupWidget_'][id$='_okButtonBean']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
}
