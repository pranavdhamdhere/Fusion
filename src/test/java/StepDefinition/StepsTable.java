package StepDefinition;

import java.util.Map;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepsTable {
	
	WebDriver driver;
	
	@Given("I open Login page {string}")
	public void Login(String url){
	   
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pranav\\Documents\\eclipse-workspace\\Kakdi\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get(url);
		
	}

	@When("I provide the valid details")
	public void correctDetails(DataTable dataTable) {
	   
//		Map<String,String> map = dataTable.asMap(String.class,String.class);
//		
//		driver.findElement(By.id("username")).sendKeys(map.get("email"));
//		driver.findElement(By.id("password")).sendKeys(map.get("password"));	
		
		driver.findElement(By.id("username")).sendKeys(dataTable.cell(0, 1));
		driver.findElement(By.id("password")).sendKeys(dataTable.cell(1, 1));
	
	}
	
	@When("I provide the invalid details {string} and {string}")
	public void incorrectDetails(String username, String password) {	
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);		
	
	}

	@And("I check Remember me")
	public void rememberMe() {
	    
		driver.findElement(By.name("rememberme")).click();
		
	}

	@And("I click on LoginButton")
	public void clickOnLoginBtn(){
	 
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
	}

	@Then("I should get successfully Logged in")
	public void SuccessfullLogin() {
		
		String title = driver.getTitle();
		
		if(title.contains("My Account")) {
	
		}else {
			
			Assert.fail("No Login");
			
		}
	   
	}
	
	@Then("I should not get Logged in")
	public void noLogin() {
		
		String title = driver.getTitle();
		
		if(!title.contains("My Account")) {
	
		}else {
			
			Assert.fail("Should not Login");
			
		}
	   
	}

}