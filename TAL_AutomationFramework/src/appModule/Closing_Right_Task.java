package appModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.Tab_Tasks_Claim_page;
import utility.Waitutil;

public class Closing_Right_Task {
      
      public static void SelectRightTask(WebDriver driver, String TaskToSelect, List<WebElement> allRows, int iColumn){   
                        
            for (WebElement row : allRows) {
             
            List<WebElement> cells = row.findElements(By.tagName("td"));
             if(cells.size() > 0) {
                  String matchingTask = cells.get(iColumn).getText();
                  System.out.println("Matching task is :"+matchingTask);
                  if (TaskToSelect.equals(matchingTask)){
                        row.click();
                        Tab_Tasks_Claim_page.btn_Closetask(driver).click();
                        Waitutil.waituntilclickabale(driver, "#PopupContainer input[type=submit][value=Yes]");
                        driver.findElement(By.cssSelector("#PopupContainer input[type=submit][value=Yes]")).click();
                  break;
                }
            
            }
          
       }
            
      }
   
}
