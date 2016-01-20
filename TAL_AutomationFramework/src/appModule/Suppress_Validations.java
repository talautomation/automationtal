package appModule;

import java.io.IOException;
import org.openqa.selenium.WebDriver;


import pageObjects.*;


public class Suppress_Validations {
	
	public static void SupressValidations(WebDriver driver) throws InterruptedException, IOException{
		
		Tab_Validations_Claim_page.tab_Validations(driver).click();
		
		Tab_Validations_Claim_page.chk_ValidationsCheckbox(driver).click();
		
		Tab_Validations_Claim_page.btn_ValidationsSuppressButton(driver).click();
		
		Tab_Validations_Claim_page.btn_OKValidationsSuppressButton(driver).click();
	 

	    
	}
	

}
