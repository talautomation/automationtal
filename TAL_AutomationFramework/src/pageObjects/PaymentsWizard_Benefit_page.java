package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Waitutil;

public class PaymentsWizard_Benefit_page {
private static WebElement element = null;

public static WebElement wiz_Payments(WebDriver driver){
	Waitutil.waituntilclickabale(driver,"*[id^='MENUBAR.CaseSubjectMenu'][id$='_MENUBAR.CaseSubjectMenu_DROPDOWN.Payments_DROPDOWN.Paymentslink']");
    element = driver.findElement( By.cssSelector("*[id^='MENUBAR.CaseSubjectMenu'][id$='_MENUBAR.CaseSubjectMenu_DROPDOWN.Payments_DROPDOWN.Paymentslink']"));
    utility.Waitutil.implicitwait(driver);
    return element;
   }

	public static WebElement sel_SetUpInitialRecurringPayments(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='MENUBAR.CaseSubjectMenu'][id$='_Setup_Initial_Recurring_Paymentslink']");
	    element = driver.findElement( By.cssSelector("*[id^='MENUBAR.CaseSubjectMenu'][id$='_Setup_Initial_Recurring_Paymentslink']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement btn_NextButton(WebDriver driver)throws InterruptedException{
		Thread.sleep(2000);
		Waitutil.waituntilclickabale(driver,"*[id^='p'][id$='_NextButton_cloned']");
	    element = driver.findElement( By.cssSelector("*[id^='p'][id$='_NextButton_cloned']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement chk_AdvancePay(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='RegularPremiumComponentClassExtensionDetailsWidget'][id$='_AdvancedPay_CHECKBOX']");
	    element = driver.findElement( By.cssSelector("*[id^='RegularPremiumComponentClassExtensionDetailsWidget'][id$='_AdvancedPay_CHECKBOX']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	   }
	public static WebElement rec_BenefitEndDay(WebDriver driver)throws InterruptedException{
		Thread.sleep(5000);
		//Waitutil.waituntilclickabale(driver,"*[id^='PaymentDetailsPeriod_'][id$='_InternalEndDate_Day']");
	    //element = driver.findElement( By.cssSelector("*[id^='PaymentDetailsPeriod_'][id$='_InternalEndDate_Day']"));
	    element=driver.findElement( By.xpath (".//*[@id='PaymentDetailsPeriod_un21_InternalEndDate_Day']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	public static WebElement rec_BenefitEndMonth(WebDriver driver){
		//Waitutil.waituntilclickabale(driver,"*[id^='PaymentDetailsPeriod_'][id$='_InternalEndDate_Month']");
	    //element = driver.findElement( By.cssSelector("*[id^='PaymentDetailsPeriod_'][id$='_InternalEndDate_Month']"));
	    element=driver.findElement( By.xpath (".//*[@id='PaymentDetailsPeriod_un21_InternalEndDate_Month']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;   
	}
	public static WebElement rec_BenefitEndYear(WebDriver driver){
		//Waitutil.waituntilclickabale(driver,"*[id^='PaymentDetailsPeriod_'][id$='_InternalEndDate_Year']");
	    //element = driver.findElement( By.cssSelector("*[id^='PaymentDetailsPeriod_'][id$='_InternalEndDate_Year']"));
		element=driver.findElement( By.xpath (".//*[@id='PaymentDetailsPeriod_un21_InternalEndDate_Year']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	public static WebElement txt_DayBenefitEndDay(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_periodToDateTimeBean_Day']");
	    element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_periodToDateTimeBean_Day']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	public static WebElement txt_DayBenefitEndMonth(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_periodToDateTimeBean_Month']");
	    element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_periodToDateTimeBean_Month']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	public static WebElement txt_DayBenefitEndYear(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_periodToDateTimeBean_Year']");
	    element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_periodToDateTimeBean_Year']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	public static WebElement sel_StatusActivityPeriod(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='ActivityPeriodDetailsForWizardWidget'][id$='_statusEnumBean']");
	    element = driver.findElement( By.cssSelector("*[id^='ActivityPeriodDetailsForWizardWidget_'][id$='_statusEnumBean']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	public static WebElement btn_FinishPaymentSetUp(WebDriver driver){
		Waitutil.waituntilclickabale(driver,"*[id^='p'][id$='_rcpFinishButton_cloned']");
	    element = driver.findElement( By.cssSelector("*[id^='p'][id$='_rcpFinishButton_cloned']"));
	    utility.Waitutil.implicitwait(driver);
	    return element;
	}
	
}
