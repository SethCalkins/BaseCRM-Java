package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import entities.CollectionType;

public abstract class AbstractPageWithAddContactOption extends AbstractPage{
	
	public ArrayList<String> getAvailableCompanyOptions(String contact){
		return getAvailableOptionsFrom(CollectionType.COMPANY, contact);
	}
	
	public ArrayList<String> getAvailablePersonOptions(String contact){
		return getAvailableOptionsFrom(CollectionType.PERSON, contact);
	}
	
	private ArrayList<String> getAvailableOptionsFrom(CollectionType collectionType, String contact){
		ArrayList<String> optionsContainer = new ArrayList<String>();
		WebDriverWait timer = new WebDriverWait(AbstractPage.driver, 5);
		String xpath = "//a[contains(@class,'with-icon bg-"+collectionType.getId()+"-10-light-gray')  and contains(text(),'"+contact +"')]";
		timer.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		List<WebElement> options = AbstractPage.driver.findElements(By.xpath(xpath));
		for(WebElement option : options){
			optionsContainer.add(option.getText());
			System.out.println(option.getText());
		}
		return optionsContainer;
	}

}
