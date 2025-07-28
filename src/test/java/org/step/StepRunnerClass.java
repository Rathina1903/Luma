package org.step;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepRunnerClass {
	
	BaseClass base=new BaseClass();
	
	@Given("Select a product")
	public void select_a_product() throws InterruptedException {
		base.getDriver("Chrome");
		base.getUrl("https://magento.softwaretestingboard.com/");
		Thread.sleep(6000);
		base.winMax();
		Thread.sleep(6000);
		
		WebElement signIn = base.element("//li[@class='authorization-link']");
		signIn.click();
		
		WebElement username = base.element("//input[@id='email']");
		username.sendKeys("rathinadevi2001@gmail.com");
		
		WebElement password = base.element("//input[@type='password']");
		password.sendKeys("Rathina@2002");
		
		WebElement submit = base.element("//span[text()='Sign In']");
		submit.click();

		WebElement clickMen = base.element("//span[text()='Men']");
		clickMen.click();
		
		WebElement scrolltoHotSellers = base.element("//a[text()='Search Terms']");
		base.scrollDown(scrolltoHotSellers, "arguments[0].scrollIntoView(false)");
		
		WebElement moveToElement = base.element("//span[@class='price-label']");
		base.moveToElement(moveToElement);
		
		WebElement clickAdd = base.element("//span[text()='Add to Cart']");
		clickAdd.click();
		
		WebElement scrollDown = base.element("//span[text()='Add to Compare']");
		base.scrollDown(scrollDown, "arguments[0].scrollIntoView(false)");
		
		WebElement size = base.element("//div[@class='swatch-option text']");
		size.click();
		Thread.sleep(2000);
		
		WebElement colour = base.element("//div[@class='swatch-option color']");
		colour.click();
	}
	
	@When("Add those products to cart")
	public void add_those_products_to_cart() throws InterruptedException {
		WebElement AddToCart = base.element("//span[text()='Add to Cart']");
		AddToCart.click();
		Thread.sleep(2000);
		
		WebElement ScrollToWelcome = base.element("//span[text()='Welcome, Sudarvelan S!']");
		base.ScrollUp(ScrollToWelcome, "arguments[0].scrollIntoView(true)");
		Thread.sleep(3000);

		WebElement goCartPage = base.element("//a[@class='action showcart']");
		goCartPage.click();
		Thread.sleep(3000);
		
		WebElement CheckOut = base.element("//button[text()='Proceed to Checkout']");
		CheckOut.click();
		Thread.sleep(4000);
		
		WebElement Scrolldown = base.element("//span[text()='Next']");
		base.scrollDown(Scrolldown,"arguments[0].scrollIntoView(false)" );
		Thread.sleep(3000);
	}
	
	@Then("Select those amounts")
	public void select_those_amounts() throws InterruptedException {
		WebElement selectAmt = base.element("//input[@type='radio']");
		selectAmt.click();
		Thread.sleep(2000);
		
		WebElement SelectNext = base.element("//span[text()='Next']");
		SelectNext.click();
		Thread.sleep(4000);
	}
	
	@Then("Proceed to check out")
	public void proceed_to_check_out() {
		WebElement PlaceOrder = base.element("//span[text()='Place Order']");
		PlaceOrder.click();
		}

	



}
