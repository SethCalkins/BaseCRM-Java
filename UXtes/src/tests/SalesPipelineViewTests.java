package tests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import views.ContactsView;
import views.SalesPipelineView;

import com.google.inject.Inject;

public class SalesPipelineViewTests extends AbstractTest {
	
	@Inject
	ContactsView contactsView;

	@Inject
	SalesPipelineView salesPipelineView;
	
	private ArrayList<String> personsCollection = new ArrayList<String>();
	private ArrayList<String> companiesCollection = new ArrayList<String>();

	@BeforeMethod
	public void setUpMethod() {
		contactsView.openPage();
		companiesCollection = contactsView.getAvailableCompaniesCollection();
		personsCollection = contactsView.getAvailablePersonsCollection();
		salesPipelineView.openPage();
	}

	@Test
	public void shouldShowAllAvailableContactSuggestions() {
		salesPipelineView.verifyAvailableCompanies(companiesCollection);
		salesPipelineView.verifyAvailablePersons(personsCollection);
	}

}
