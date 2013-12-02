package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage {
	
	@FindBy(id="nav-leads")
	WebElement _leadsMenuLink;
	
	@FindBy(id="nav-contacts")
	WebElement _contactsMenuLink;
	
	@FindBy(id="nav-sales")
	WebElement _salesPipelineMenuLink;
	
	protected static WebDriver driver;
	
	public void closeBrowser(){
		driver.quit();
	}
}
