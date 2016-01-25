package appModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.ClaimIntake_page;

public class FindRightElement {

	// public static void SelectRightElement(WebDriver driver, String
	// CssSelector, String ElementToClick, List<WebElement> allRows){

	public static void SelectRightElement(WebDriver driver, String ElementToClick, List<WebElement> allRows) {
		// List<WebElement> allRows =
		// Tab_Coverages_page.tbl_Coverages(driver).findElements(By.tagName("td"));

		for (WebElement row : allRows) {

			String element = row.getText();

			System.out.println("\n element = " + element);

			if (element.equals(ElementToClick)) {

				row.click();

				break;

			}

		}

	}

	@SuppressWarnings("unused")
	public static void SelectingRightPersonResults_MultiplePages(WebDriver driver, String PersonToSelect,
			List<WebElement> numberofPages, int iColumn) {

		// System.out.println("Number of pages size is:-" +
		// numberofPages.size());

		outerloop: for (WebElement page : numberofPages) {

			List<WebElement> allPersons = ClaimIntake_page.tbl_PersonSearchResults(driver)
					.findElements(By.cssSelector("tbody > tr"));

			for (WebElement row : allPersons) {

				List<WebElement> cells = row.findElements(By.tagName("td"));
				if (cells.size() > 0) {
					String matchingElement = cells.get(iColumn).getText();
					System.out.println("Matching Element is :-" + matchingElement);
					if (PersonToSelect.equalsIgnoreCase(matchingElement)) {
						row.click();
						break outerloop;
					}

				}

			}

			ClaimIntake_page.tbl_Play_NextButton(driver).click();

		}

	}

}
