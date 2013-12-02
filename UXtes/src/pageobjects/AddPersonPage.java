package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPersonPage extends AbstractPageWithAddContactOption {

	@FindBy(xpath = "//input[contains(@class,'ui-autocomplete-input input-xlarge') and contains(@placeholder,'Company')]")
	WebElement _companyInput;

	public AddPersonPage() {
		PageFactory.initElements(AbstractPage.driver, this);
	}

	public void typeCompanyValue(String text) {
		_companyInput.clear();
		_companyInput.sendKeys(text);
	}
}
