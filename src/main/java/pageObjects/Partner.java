package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class Partner extends Base{
	
	@FindBy(id = "radio-yes")
	WebElement yesRadioBtn;
	@FindBy(id = "radio-no")
	WebElement noRadioBtn;
	@FindBy(xpath = "//h1[contains(text(),'Do you live with a partner?')]")
	WebElement liveWithPartner;
	@FindBy(id = "next-button")
	WebElement nextBtn;

	
	public Partner() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!liveWithPartner.isDisplayed())
				throw new TestException("Live With Partner page is not displayed");
	        if(getDriver().getTitle().startsWith("Do you live with a partner?")) {
		      
	          }
	        else {
		      throw new TestException("Error occured while loading Live With Partner page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Live With Partner page is not displayed"+e.getMessage());
		}
	}
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "yes":
			Action.click(getDriver(), yesRadioBtn);
			break;
		case "no":
			Action.click(getDriver(),noRadioBtn);
			break;
		case "next":
		case "nxt":
		case "nextbtn":
		case "nextbutton":
			Action.click(getDriver(),nextBtn);
			break;
		default:
			throw new TestException("Invalid action :" +buttonName);
		
		}
		}
		catch(Exception e) {
			throw new TestException("failed while performing "+buttonName +" action"+ e.getMessage());
		}
	}	
	
}
