package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class HomePage extends Base {
	@FindBy(xpath = "//input[@id ='next-button']")
	WebElement startButton;
	@FindBy(xpath = "//button[@id ='nhsuk-cookie-banner__link_accept_analytics']")
	WebElement CookieAcceptButton;
	@FindBy(xpath = "//button[@id ='nhsuk-cookie-banner__link_accept']")
	WebElement CookieRejectButton;
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	 }
	
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "cookieaccept":
		case "accept":
		case "imokwithanalyticscookies":
		case "okwithanalyticscookies":
		case "acceptcookie":
		case "acceptcookies":
			Action.click(getDriver(), CookieAcceptButton);
			break;
		case "cookiereject":
		case "reject":
		case "rejectcookie":
		case "rejectcookies":
		case "donotuseanalyticscookies":
			Action.click(getDriver(), CookieRejectButton);
			break;
		case "start":
		case "startnow":
		case "startnowbutton":
			Action.click(getDriver(), startButton);
			break;
			
		default:
			throw new TestException("Invalid action :" +buttonName);
		
		}
		}
		catch(Exception e) {
			throw new TestException("failed while performing "+buttonName +" action"+ e.getMessage());
		}
	}
	
	public void isPageDisplayed() {
		try {
			if(!startButton.isDisplayed())
				throw new TestException("Home page is not displayed");
			System.out.println("TITle ::"+getDriver().getTitle());
	        if(getDriver().getTitle().equals("Check what help you could get to pay for NHS costs - NHSBSA")) {
	          }
	        else {
		      throw new TestException("Error occured while loading Home Page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Home page is not displayed"+e.getMessage());
		}
	}
	
	
	
	
}
