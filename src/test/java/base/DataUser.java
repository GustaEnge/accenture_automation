package base;

import java.util.HashMap;

public class DataUser {
	private HashMap<String,String> insurantData;
	private HashMap<String,String> vehicleData;
	private HashMap<String,String> productData;
	 
	
	public DataUser() {
		insurantData = new HashMap <String,String>();
		vehicleData =  new HashMap <String,String>();
		productData =  new HashMap <String,String>();
	}
	public HashMap<String,String> getInsurantData(){
		return insurantData;
	}
	
	public void setInsurantData(String key,String value){
		insurantData.put(key,value);
	}
	
	public HashMap<String,String> getVehicleData(){
		return vehicleData;
	}
	
	public void setVehicleData(String key,String value){
		vehicleData.put(key,value);
	}
	public HashMap<String,String> getProductData(){
		return productData;
	}
	
	public void setProductData(String key,String value){
		productData.put(key,value);
	}
}
