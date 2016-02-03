package appModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.Tab_ManagedRequirements_Claim_page;

public class Suppress_ManagedRequirement {

	public static void SupressManagedRequirement(WebDriver driver) throws InterruptedException, IOException {

		Tab_ManagedRequirements_Claim_page.tab_ManagedRequirements(driver).click();

		Thread.sleep(5000);
		Tab_ManagedRequirements_Claim_page.chk_OpenManagedRequirement(driver).click();

		Thread.sleep(3000);
		Tab_ManagedRequirements_Claim_page.btn_ManagedRequirementSuppressButton(driver).click();

		Tab_ManagedRequirements_Claim_page.btn_OKManagedRequirementSuppressButton(driver).click();

	}

}
