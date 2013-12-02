package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
	
	@FindBy(id = "user_email")
	WebElement _loginInput;

	@FindBy(id = "user_password")
	WebElement _passwordInput;
	
	@FindBy(className = "icon-lock")
	WebElement _loginBtn;
	
	public void open(){
		AbstractPage.driver = new FirefoxDriver();
		AbstractPage.driver.get("https://core.futuresimple.com/sales/users/login");
		PageFactory.initElements(AbstractPage.driver, this);
	}
	
	public void typeLogin(String login){
		_loginInput.clear();
		_loginInput.sendKeys(login);
	}
	
	public void typePassword(String pswd){
		_passwordInput.clear();
		_passwordInput.sendKeys(pswd);
	}
	
	public void clickLoginButton(){
		_loginBtn.click();
	}

}
