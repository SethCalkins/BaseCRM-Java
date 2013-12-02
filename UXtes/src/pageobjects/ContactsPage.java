package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import entities.CollectionType;

public class ContactsPage extends AbstractPage{
	
	@FindBy(xpath="//a/text()[normalize-space(.)='Person']/parent::*")
	WebElement _addNewPersonBtn;
	
	@FindBy(xpath="//a/text()[normalize-space(.)='Company']/parent::*")
	WebElement _addNewCompanyBtn;
	
	public void open(){
		PageFactory.initElements(AbstractPage.driver, this);
		clickContactsMenuLink();
	}
	
	public AddPersonPage openAddPersonPage(){
		clickAddNewPerson();
		return new AddPersonPage();
	}
	
	public ArrayList<String> getCollectionOf(CollectionType collectionType) {
		ArrayList<String> companies = new ArrayList<String>();
		WebDriverWait timer = new WebDriverWait(AbstractPage.driver, 10);
		String xpath = "//h3[contains(@class,'contact-name icn-" + collectionType.getId() + "-10-light-gray')]";
		timer.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		List<WebElement> companiesList = AbstractPage.driver.findElements(By.xpath(xpath));
		for (WebElement contactOnPage : companiesList) {
			WebElement nameLink = contactOnPage.findElement(By.className("name-link"));
			companies.add(nameLink.getText());
			System.out.println(collectionType.getId() + ": " + nameLink.getText());
		}
		return companies;
	}
	
	private void clickContactsMenuLink(){
		_contactsMenuLink.click();
	}
	
	private void clickAddNewPerson(){
		_addNewPersonBtn.click();
	}

}
