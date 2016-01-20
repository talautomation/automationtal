package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tab_Tasks_Benefit_page {
private static WebElement element = null;
	
	public static WebElement tab_TasksTab(WebDriver driver){
	   element = driver.findElement(By.cssSelector("*[id^='DisplayCaseTabbedDialogWidget_'][id$='_CaseTabControlBean_Tasks_cell']"));
	   utility.Waitutil.implicitwait(driver);
	   return element;
	   }
	public static WebElement tbl_TasksList(WebDriver driver){
		   element = driver.findElement(By.cssSelector("*[id^='TasksForCaseListViewWidget_'][id$='_TasksForCaseWidget']"));
		   utility.Waitutil.implicitwait(driver);
		   return element;
		   }
}
