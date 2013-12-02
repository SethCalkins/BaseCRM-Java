package entities;

public enum CollectionType {
	COMPANY("company"),
	PERSON("contact");
	
	CollectionType(String id){
		_id = id;
	}
	
	String _id;

	public String getId(){
		return _id;
	}

}
