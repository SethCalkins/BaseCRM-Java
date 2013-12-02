package views;

import org.testng.annotations.Guice;

import pageobjects.LoginPage;

import com.google.inject.Inject;

@Guice
public class LoginView {
	
	@Inject
	LoginPage loginPage;
	
	public void openStartPage(){
		loginPage.open();
	}
	
	public void logInToApplication(){
		loginPage.typeLogin("maciek.targosz@gmail.com");
		loginPage.typePassword("Base123");
		loginPage.clickLoginButton();	
	}
	
	public void closeBrowser(){
		loginPage.closeBrowser();
	}
}
