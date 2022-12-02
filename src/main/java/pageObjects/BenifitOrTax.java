package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class BenifitOrTax extends Base {

	
	@FindBy(id = "radio-yes")
	WebElement yesRadioBtn;
	@FindBy(id = "radio-no")
	WebElement noRadioBtn;
	@FindBy(xpath = "//span[contains(text(),'Do you claim any benefits or tax credits?')]")
	WebElement benefitOrTax;
	@FindBy(id = "next-button")
	WebElement nextBtn;
	
	
	public BenifitOrTax() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!benefitOrTax.isDisplayed())
				throw new TestException("Benefit or Tax page is not displayed");
	        if(getDriver().getTitle().startsWith("Do you claim any benefits or tax credits?")) {
		      
	          }
	        else {
		      throw new TestException("Error occured while loading Benefit or Tax page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Benefit or Tax page is not displayed"+e.getMessage());
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
