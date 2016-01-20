package appModule;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selecting_RightElement {
	
	public static void Select(WebDriver driver, String sGroupId, List<WebElement> allRows, int Column ){
	
        //if (allRows.size() >2)  {
        	
        	for (WebElement row : allRows) {
     	        
                List<WebElement> cells = row.findElements(By.tagName("td"));
                System.out.println(cells.size());
                if(cells.size() > 0) {
                	String matchingElement = cells.get(Column).getText();
                	System.out.println("matching element is " +matchingElement);
                
                    	if (sGroupId.equals(matchingElement)){
                    		row.click();
                    	break;
                    }
                }
              
        	}
          }
	
}




/*for (WebElement cell : cells) {
 

cell.getText();
//}
	

}*/

/*public static void Select(WebDriver driver, String sPolicyNumber ){
	
	List<WebElement> allRows =  CaseSearch_page.tbl_ListofPolicies(driver).findElements(By.tagName("tr"));
    
    if (allRows.size() >2)  {
       	        	
    	int iCount = 3;
    	
    	myloop: for (WebElement row : allRows) {
 	        	
             List<WebElement> cells = row.findElements(By.tagName("td"));
             for (WebElement cell : cells) {
            		                                
                 String matchingPolicy = cell.getText();
                 
                 if (sPolicyNumber.equals(matchingPolicy)){
                	//System.out.println("Before enters the matching iCount Number >>   " +iCount);
                 	//System.out.println("Matching policy Number >>   " + matchingPolicy);
                 	//System.out.println("Policy Number >>   " + sPolicyNumber);
                 	
                 	// This logic is to select 2nd policy if at all matches with the one that is given at the start
                    if (iCount == 5){
                   	 //System.out.println("iCount Number >>   " +iCount);
                   	WebElement exactPolicyMatch = driver.findElement(By.xpath(".//*[@id='ContractsForPartyWidget_Policy_un26_ContractsForPartyListViewControl']/tbody/tr[2]/td[1]"));
                   	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                  	exactPolicyMatch.click();
                  	//System.out.println("selected right policy");
                   	 
                   	 //driver.findElement(By.cssSelector("*[id^='ContractsForPartyWidget_Policy'][id$='ContractsForPartyListViewControl']/tbody/tr[2]/td[1]")).click();
                   	}
                    
                    // This logic is to select 3rd policy if at all matches with the one that is given at the start
                    
                    if (iCount == 6){
                   	 //System.out.println("iCount Number >>   " +iCount);
                   	 //driver.findElement(By.cssSelector("*[id^='ContractsForPartyWidget_Policy'][id$='ContractsForPartyListViewControl']/tbody/tr[3]/td[1]")).click();
                   	 WebElement exactPolicyMatch = driver.findElement(By.xpath(".//*[@id='ContractsForPartyWidget_Policy_un26_ContractsForPartyListViewControl']/tbody/tr[3]/td[1]"));
                   	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                   	 exactPolicyMatch.click();
                   	//System.out.println("selected right policy");
                   	 
                   	}	 
                   
                    // This logic is to select 4th policy if at all matches with the one that is given at the start
                    
                    if (iCount == 7){
                      	//System.out.println("iCount Number >>   " +iCount);
                      	//driver.findElement(By.cssSelector("*[id^='ContractsForPartyWidget_Policy'][id$='ContractsForPartyListViewControl']/tbody/tr[3]/td[1]")).click();
                      	WebElement exactPolicyMatch = driver.findElement(By.xpath(".//*[@id='ContractsForPartyWidget_Policy_un26_ContractsForPartyListViewControl']/tbody/tr[4]/td[1]"));
                      	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                      	exactPolicyMatch.click();
                      	//System.out.println("selected right policy");
                      	 
                      	}
                    
                 // This logic is to select 5th policy if at all matches with the one that is given at the start
                    
                    if (iCount == 8){
                      	//System.out.println("iCount Number >>   " +iCount);
                      	//driver.findElement(By.cssSelector("*[id^='ContractsForPartyWidget_Policy'][id$='ContractsForPartyListViewControl']/tbody/tr[3]/td[1]")).click();
                      	WebElement exactPolicyMatch = driver.findElement(By.xpath(".//*[@id='ContractsForPartyWidget_Policy_un26_ContractsForPartyListViewControl']/tbody/tr[5]/td[1]"));
                      	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                      	exactPolicyMatch.click();
                      	//System.out.println("selected right policy");
                      	 
                      	}
                    
                 // This logic is to select 6th policy if at all matches with the one that is given at the start
                    
                    if (iCount == 9){
                     	 //System.out.println("iCount Number >>   " +iCount);
                     	 //driver.findElement(By.cssSelector("*[id^='ContractsForPartyWidget_Policy'][id$='ContractsForPartyListViewControl']/tbody/tr[3]/td[1]")).click();
                     	 WebElement exactPolicyMatch = driver.findElement(By.xpath(".//*[@id='ContractsForPartyWidget_Policy_un26_ContractsForPartyListViewControl']/tbody/tr[6]/td[1]"));
                     	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                     	 exactPolicyMatch.click();
                     	//System.out.println("selected right policy");
                     	 
                     	}                  	                	
                
                 break myloop;
                 
                 }
          
             }
                   	 
             iCount = iCount + 1 ;
     
    	}
      }
    // And iterate over them, getting the cells
}*/