package views;

import java.util.ArrayList;

public abstract class AbstractView {
	protected String getFirstSign(String text){
		return text.substring(0, 1);
	}
	
	protected void removeElementIfExists(ArrayList<String> lContacts, ArrayList<String> aContacts){
		for(String aContact : aContacts){
				if(lContacts.contains(aContact)){
					lContacts.remove(aContact);
				}
		}
	}
}
