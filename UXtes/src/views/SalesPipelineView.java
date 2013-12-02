package views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

import pageobjects.SalesPipelinePage;

import com.google.inject.Inject;

public class SalesPipelineView extends AbstractView{
	
	@Inject
	SalesPipelinePage salesPipelinePage;
	
	public void openPage(){
		salesPipelinePage.openPage();
	}

	public void verifyAvailableCompanies(ArrayList<String> companiesCollection) {
		salesPipelinePage.clickAddDeal();
		
		ArrayList<String> helperList = new ArrayList<String>();
		for(String company : companiesCollection){
			helperList.add(company);
		}
		
		for(String contact : companiesCollection){
			salesPipelinePage.typeContactValue(getFirstSign(contact));
			removeElementIfExists(helperList, salesPipelinePage.getAvailableCompanyOptions(contact));
		}
		
		assertThat(helperList.size(), is(0));
	}

	public void verifyAvailablePersons(ArrayList<String> personsCollection) {
		salesPipelinePage.clickAddDeal();
		
		ArrayList<String> helperList = new ArrayList<String>();
		for(String company : personsCollection){
			helperList.add(company);
		}
		
		for(String contact : personsCollection){
			salesPipelinePage.typeContactValue(getFirstSign(contact));
			removeElementIfExists(helperList, salesPipelinePage.getAvailablePersonOptions(contact));
		}
		
		assertThat(helperList.size(), is(0));
	}
}
