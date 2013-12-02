package tests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import views.ContactsView;

import com.google.inject.Inject;

public class ContactsViewTests extends AbstractTest{
	
	@Inject
	ContactsView contactsView;
	
	private ArrayList<String> personsCollection = new ArrayList<String>();
	private ArrayList<String> companiesCollection = new ArrayList<String>();
	
	@BeforeClass
	public void setUpClass(){
		contactsView.openPage();
		companiesCollection = contactsView.getAvailableCompaniesCollection();
		personsCollection = contactsView.getAvailablePersonsCollection();
	}
	
	@Test
	public void shouldSuggestAvailableCompanies(){
		contactsView.verifyAvailableCompanies(companiesCollection);
	}

}
