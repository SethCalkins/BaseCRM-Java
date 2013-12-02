package tests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import views.LeadsView;

import com.google.inject.Inject;

public class LeadsViewTests extends AbstractTest{
	
	@Inject
	LeadsView leadsView;
	
	private ArrayList<String> leadsCollection = new ArrayList<String>();
	
	@BeforeMethod
	public void setUpMethod(){
		leadsView.openPage();
		leadsCollection = leadsView.getAvailableLeads();
	}
	
	@Test
	public void dummyTest(){
		//test is empty because on BASE demo there are no suggestions available for Company Name input field
	}

}