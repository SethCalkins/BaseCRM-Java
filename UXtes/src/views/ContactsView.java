package views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

import pageobjects.AddPersonPage;
import pageobjects.ContactsPage;

import com.google.inject.Inject;

import entities.CollectionType;

public class ContactsView extends AbstractView{
	
	@Inject
	ContactsPage contactsPage;
	
	public void openPage(){
		contactsPage.open();
	}
	
	public void verifyAvailableCompanies(ArrayList<String> contacts){
		AddPersonPage addPersonPage = contactsPage.openAddPersonPage();

		ArrayList<String> helperList = new ArrayList<String>();
		for(String contact : contacts){
			helperList.add(contact);
		}
		
		for(String contact : contacts){
			addPersonPage.typeCompanyValue(getFirstSign(contact));
			removeElementIfExists(helperList, addPersonPage.getAvailableCompanyOptions(contact));
		}
		
		assertThat(helperList.size(), is(0));
	}
	
	
	public ArrayList<String> getAvailablePersonsCollection(){
		return contactsPage.getCollectionOf(CollectionType.PERSON);
	}
	
	public ArrayList<String> getAvailableCompaniesCollection(){
		return contactsPage.getCollectionOf(CollectionType.COMPANY);
	}

}
