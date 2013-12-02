package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Guice;

import views.LoginView;

import com.google.inject.Inject;

@Guice
public abstract class AbstractTest {
	
	@Inject
	LoginView loginView;
	
	@BeforeSuite
	public void setUpSuite(){
		loginView.openStartPage();
		loginView.logInToApplication();
	}
	
	@AfterSuite
	public void tearDownSuite(){
		loginView.closeBrowser();
	}
}
