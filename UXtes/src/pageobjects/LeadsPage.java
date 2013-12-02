package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsPage extends AbstractPage{
	
	public void open(){
		PageFactory.initElements(AbstractPage.driver, this);
		clickLeadsMenuLink();
	}
	
	public ArrayList<String> getAvailableLeads(){
		ArrayList<String> leads = new ArrayList<String>();
		WebDriverWait timer = new WebDriverWait(AbstractPage.driver, 10);
		timer.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("lead-name")));
		List<WebElement> leadsList = AbstractPage.driver.findElements(By.className("lead-name"));
		for(WebElement leadOnPage : leadsList){
			leads.add(leadOnPage.getText());
		}
		return leads;
	}
	
	private void clickLeadsMenuLink(){
		_leadsMenuLink.click();
	}

}
