package appModule;

import java.util.List;
import org.openqa.selenium.*;



public class FindRightElement {
      
      //public static void SelectRightElement(WebDriver driver, String CssSelector, String ElementToClick, List<WebElement> allRows){
            
      public static void SelectRightElement(WebDriver driver, String ElementToClick, List<WebElement> allRows){    
            //List<WebElement> allRows =  Tab_Coverages_page.tbl_Coverages(driver).findElements(By.tagName("td"));
            
            for (WebElement row : allRows) {

                  String element = row.getText();
                  
                  System.out.println("\n element = " +element);
                  
                  if (element.equals(ElementToClick)){
                        
                  row.click();
                  
                  break;
                        
                  }
      
            }
   
      }

}
