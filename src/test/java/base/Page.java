package base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import seleniumgluecode.Hooks;

public class Page {
	private WebDriver driver;
	
	public Page()
	{
		driver = Hooks.driver;
		
	}
	
	public void launchPage() {
		
		driver.navigate().to("http://sampleapp.tricentis.com/101/app.php");
	}
	
	public String titlePage() {
		return driver.getTitle();
	}

	public void fillData(HashMap <String,Object> locators,HashMap <String,String> hm, List<String> selectedFields)  throws Exception{
		for(Map.Entry<String,Object> row:locators.entrySet()) {
			String key = row.getKey();
			WebElement value = (WebElement) row.getValue();
			if(!selectedFields.contains(key)) {
				value.sendKeys(hm.get(key));
			}else {
				value.click();
				if(key.equals("picture")) value.sendKeys(hm.get(key));
			}
			TimeUnit.MILLISECONDS.sleep(200);
		}
	}
	
	public void toInsertVehicleData(HashMap <String,String> hm)  throws Exception{
				
		
		HashMap <String,Object> locators = new LinkedHashMap<>();
		
		// check-box definition according to the choice (Yes/No)
		String rightHandlocator = "//*[@id='righthanddrive"+hm.get("hand")+"']/following-sibling::span";
		
		List <String> selectedFields = Arrays.asList("hand");
		
		locators.put("make", driver.findElement(By.id("make")));
		locators.put("model", driver.findElement(By.id("model")));
		locators.put("cc", driver.findElement(By.id("cylindercapacity")));
		locators.put("kW", driver.findElement(By.id("engineperformance")));
		locators.put("dateManu", driver.findElement(By.id("dateofmanufacture")));
		locators.put("seats", driver.findElement(By.id("numberofseats")));
		locators.put("hand", driver.findElement(By.xpath(rightHandlocator)));
		locators.put("numSeats", driver.findElement(By.id("numberofseatsmotorcycle")));
		locators.put("fuel", driver.findElement(By.id("fuel")));
		locators.put("payload", driver.findElement(By.id("payload")));
		locators.put("weight", driver.findElement(By.id("totalweight")));
		locators.put("price", driver.findElement(By.id("listprice")));
		locators.put("plateNumber", driver.findElement(By.id("licenseplatenumber")));
		locators.put("mileage", driver.findElement(By.id("annualmileage")));
		
		WebElement next = driver.findElement(By.id("nextenterinsurantdata"));
		fillData(locators,hm,selectedFields);
		
		
		next.click();
		TimeUnit.MILLISECONDS.sleep(300);
	}
	
	public void toInsertInsurantData (HashMap <String,String> hm) throws Exception{
		
		HashMap <String,Object> locators = new LinkedHashMap<>();
		
		// check-box definition according to the choice (Male/Female)
		String genderLocator = "//*[@id='gender"+hm.get("gender").toLowerCase()+"']/following-sibling::span";
		String hobbiesLocator = "//*[@class='ideal-radiocheck-label']//input[@id='"+hm.get("hobbies").toLowerCase().replace(" ", "")+"']/following-sibling::span";
		
		List <String> selectedFields = Arrays.asList("gender","hobbies");
		
		locators.put("name", driver.findElement(By.id("firstname")));
		locators.put("lname", driver.findElement(By.id("lastname")));
		locators.put("birth", driver.findElement(By.id("birthdate")));
		locators.put("gender", driver.findElement(By.xpath(genderLocator)));
		locators.put("street", driver.findElement(By.id("streetaddress")));
		locators.put("country", driver.findElement(By.id("country")));
		locators.put("zip", driver.findElement(By.id("zipcode")));
		locators.put("city", driver.findElement(By.id("city")));
		locators.put("occupation", driver.findElement(By.id("occupation")));
		locators.put("hobbies", driver.findElement(By.xpath(hobbiesLocator)));
		locators.put("website", driver.findElement(By.id("website")));
		locators.put("picture", driver.findElement(By.id("picture")));
		
		
		WebElement next = driver.findElement(By.id("nextenterproductdata"));
		fillData(locators,hm,selectedFields);
		
		next.click();
		TimeUnit.MILLISECONDS.sleep(300);
	}
	
	public void toInsertProductData (HashMap <String,String> hm) throws Exception{
		
		HashMap <String,Object> locators = new LinkedHashMap<>();
		
		String optionalsLocator = "//*[@class='ideal-radiocheck-label']//input[@id='"+hm.get("optionals").replace(" ", "")+"']/following-sibling::span";
		
		List <String> selectedFields = Arrays.asList("optionals");
		
		locators.put("start", driver.findElement(By.id("startdate")));
		locators.put("insuranceSum", driver.findElement(By.id("insurancesum")));
		locators.put("meritRating", driver.findElement(By.id("meritrating")));
		locators.put("damageIns", driver.findElement(By.id("damageinsurance")));
		locators.put("optionals", driver.findElement(By.xpath(optionalsLocator)));
		locators.put("courtesy", driver.findElement(By.id("courtesycar")));
		
		WebElement next = driver.findElement(By.id("nextselectpriceoption"));
		fillData(locators,hm,selectedFields);
		
		next.click();
		TimeUnit.MILLISECONDS.sleep(300);
	}
	
	public void toInsertPriceOption(String option) throws Exception{
		String selectLocator = "//*[contains(@class,'ideal-radiocheck-label')]//input[@id='"+"select"+option.toLowerCase()+"']/following-sibling::span";
		WebElement selectOp = driver.findElement(By.xpath(selectLocator));
		WebElement next = driver.findElement(By.id("nextsendquote"));
		selectOp.click();
		next.click();
		TimeUnit.MILLISECONDS.sleep(300);
		
	}
	
	public void sendQuote(String email,String phone,String user,String pswd,String comments) throws Exception{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPhone = driver.findElement(By.id("phone"));
		WebElement inputUserName = driver.findElement(By.id("username"));
		WebElement inputPass = driver.findElement(By.id("password")); 
		WebElement inputPassCon = driver.findElement(By.id("confirmpassword")); 
		WebElement inputComments = driver.findElement(By.id("Comments"));
		WebElement send = driver.findElement(By.id("sendemail"));
		
		inputEmail.sendKeys(email);
		inputPhone.sendKeys(phone);
		inputUserName.sendKeys(user);
		inputPass.sendKeys(pswd);
		inputPassCon.sendKeys(pswd);
		inputComments.sendKeys(comments);
			
		
		send.click();
		TimeUnit.MILLISECONDS.sleep(300);
		
	}
	
	public String confirmEmail() {
		WebElement confirmPopUp = driver.findElement(By.xpath("//div[contains(@class,'sweet-alert')]//h2"));
		WebElement buttonConfirm = driver.findElement(By.xpath("//button[@class='confirm']"));
		buttonConfirm.click();
		return confirmPopUp.getText();
		
	}
}
