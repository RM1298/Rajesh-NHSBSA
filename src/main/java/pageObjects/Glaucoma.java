package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class Glaucoma extends Base{
	
	@FindBy(id = "radio-yes")
	WebElement yesRadioBtn;
	@FindBy(id = "radio-no")
	WebElement noRadioBtn;
	@FindBy(id = "question-heading")
	WebElement glaucomaQuestion;
	@FindBy(id = "next-button")
	WebElement nextBtn;

	
	public Glaucoma() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!glaucomaQuestion.isDisplayed())
				throw new TestException("Glaucoma page is not displayed");
	        if(getDriver().getTitle().startsWith("Do you have glaucoma?")) {
		      
	          }
	        else {
		      throw new TestException("Error occured while loading Glaucoma page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Glaucoma page is not displayed"+e.getMessage());
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
