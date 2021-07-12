package seleniumgluecode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.DataUser;
import base.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;



public class buyVehicleStep {
	DataUser user;
	Page page;
	
	@Given("I have to access Tricentis")
	public void accessPage() {
		page = new Page();
		user = new DataUser();
		page.launchPage();
	}
	
	@Given("^I have to be on (.*) tab for vehicle$")
	public void i_have_to_enter_vehicle_data(String title,DataTable dataTable) throws Exception{
		
		Assert.assertEquals("Not expected page",title,page.titlePage());
		//Assert.assertEquals("Not expected tab",tab,page.getNavData());
		List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
		Map<String,String> data = new HashMap<>(rows.get(0));
		
		for(Map.Entry mapElement:data.entrySet()) {
			String key = (String)mapElement.getKey();
			String value = (String)mapElement.getValue();
			user.setVehicleData(key,value);
			
		}
		
		page.toInsertVehicleData(user.getVehicleData());
	}

	@And("^I need to (.*) tab for insurant$")
	public void i_need_to_enter_insurant_data(String title,DataTable dataTable) throws Exception {
		
		Assert.assertEquals("Not expected page",title,page.titlePage());
		List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
		Map<String,String> data = new HashMap<>(rows.get(0));
		
		for(Map.Entry mapElement:data.entrySet()) {
			String key = (String)mapElement.getKey();
			String value = (String)mapElement.getValue();
			user.setInsurantData(key,value);
			
		}
		
		page.toInsertInsurantData(user.getInsurantData());
	}

	@When("^I need to (.*) tab for product$")
	public void i_need_to_enter_product_data(String title,DataTable dataTable) throws Exception{
		
		Assert.assertEquals("Not expected page",title,page.titlePage());
		List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
		Map<String,String> data = new HashMap<>(rows.get(0));
		
		for(Map.Entry mapElement:data.entrySet()) {
			String key = (String)mapElement.getKey();
			String value = (String)mapElement.getValue();
			user.setProductData(key,value);
			
		}
		
		page.toInsertProductData(user.getProductData());
		
	}

	@When("^I (.*) : (.*)$")
	public void i_select_the_option_price_option(String title,String option) throws Exception{
		Assert.assertEquals("Not expected page",title,page.titlePage());
		page.toInsertPriceOption(option);
		
	}

	@Then("^I (.*) using the following data: (.*), (.*), (.*), (.*) and (.*)$")
	public void i_send_the_quote_using_the_following_data_email_phone_user_pwd_pwd_and_comments(String title,String email,String phone, String user, String pwd,String comm) throws Exception{
		Assert.assertEquals("Not expected page",title,page.titlePage());
		page.sendQuote(email, phone, user, pwd, comm);
		Assert.assertEquals("Not expected message","Sending e-mail success!",page.confirmEmail());
		
	}

}
