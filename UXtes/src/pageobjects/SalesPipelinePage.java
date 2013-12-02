package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesPipelinePage extends AbstractPageWithAddContactOption{
	
	@FindBy(xpath="//a/text()[normalize-space(.)='Deal']/parent::*")
	WebElement _addDealBtn;
	
	@FindBy(xpath="//input[contains(@class,'ui-autocomplete-input span12') and contains(@placeholder,'Contact*')]")
	WebElement _contactInput;

	@FindBy(xpath="//div[contains(@class,'page-heading')]/h1[normalize-space(text())='Sales Pipeline']")
	WebElement _pageHeader;
	
	public void openPage(){
		PageFactory.initElements(AbstractPage.driver, this);
		clickSalesPipelineMenuLink();
		waitUntilPageHeaderVisible();
		PageFactory.initElements(AbstractPage.driver, this);
	}
	
	public ArrayList<String> getAvailableDeals() {
		ArrayList<String> contacts = new ArrayList<String>();
		WebDriverWait timer = new WebDriverWait(AbstractPage.driver, 10);
		timer.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("name-link")));
		List<WebElement> contactsList = AbstractPage.driver.findElements(By.className("name-link"));
		for(WebElement contactOnPage : contactsList){
			contacts.add(contactOnPage.getText());
			System.out.println("DEALS: " + contactOnPage.getText());
		}
		return contacts;
	}
	
	public void clickAddDeal(){
		if(!isContactFieldVisible()){
			_addDealBtn.click();
		}
	}
	
	public void typeContactValue(String text) {
		WebDriverWait timer = new WebDriverWait(AbstractPage.driver, 10);
		timer.until(ExpectedConditions.visibilityOf(_contactInput));
		_contactInput.clear();
		_contactInput.sendKeys(text);
	}
	
	public boolean isContactFieldVisible(){
		Boolean isVisible = false;
		try{
			if(_contactInput.isDisplayed() == true){
				isVisible = true;
			}
		}
		catch(NoSuchElementException nseExc){
			
		}
		return isVisible;
	}
	
	private void clickSalesPipelineMenuLink(){
		_salesPipelineMenuLink.click();
	}
	
	private void waitUntilPageHeaderVisible(){
		WebDriverWait timer = new WebDriverWait(AbstractPage.driver, 10);
		timer.until(ExpectedConditions.visibilityOf(_pageHeader));
	}
}
