package views;

import java.util.ArrayList;

import org.testng.annotations.Guice;

import pageobjects.LeadsPage;

import com.google.inject.Inject;

@Guice
public class LeadsView {
	
	@Inject
	LeadsPage leadsPage;
	
	public void openPage(){
		leadsPage.open();
	}
	
	public ArrayList<String> getAvailableLeads(){
		ArrayList<String> leadsCollection = new ArrayList<String>();
		leadsCollection = leadsPage.getAvailableLeads();
		return leadsCollection;
	}

}
