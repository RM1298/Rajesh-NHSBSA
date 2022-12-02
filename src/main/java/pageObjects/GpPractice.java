package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class GpPractice extends Base {
	@FindBy(id = "radio-yes")
	WebElement yesRadioBtn;
	@FindBy(id = "radio-no")
	WebElement noRadioBtn;
	@FindBy(xpath = "//h1[contains(text(),'Is your GP practice in Scotland or Wales?')]")
	WebElement gpSelection;
	@FindBy(id = "next-button")
	WebElement nextBtn;

	
	public GpPractice() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!gpSelection.isDisplayed())
				throw new TestException("GP Practice page is not displayed");
	        if(getDriver().getTitle().startsWith("Is your GP practice in Scotland or Wales?")) {
		      System.out.println("sign in pag is displayed");
	          }
	        else {
		      throw new TestException("Error occured while loading GP Practice page");
	          }
		}
		catch(Exception e) {
			throw new TestException("GP Practice page is not displayed"+e.getMessage());
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
