package org.global;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class TestScript {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		BaseClass base=new BaseClass();
		base.getDriver("Chrome");
		base.getUrl("https://magento.softwaretestingboard.com/");
		Thread.sleep(6000);
		base.winMax();
		Thread.sleep(6000);
		
		WebElement signIn = base.element("//li[@class='authorization-link']");
		signIn.click();
		
		WebElement username = base.element("//input[@id='email']");
		username.sendKeys("Sudarofficial21@gmail.com");
		
		WebElement password = base.element("//input[@type='password']");
		password.sendKeys("Sudar@123");
		
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
		
		WebElement selectAmt = base.element("//input[@type='radio']");
		selectAmt.click();
		Thread.sleep(2000);
		
		WebElement SelectNext = base.element("//span[text()='Next']");
		SelectNext.click();
		Thread.sleep(4000);
		
		WebElement PlaceOrder = base.element("//span[text()='Place Order']");
		PlaceOrder.click();
		}

}