package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class DateOfBirth extends Base {

	@FindBy(id = "dob-day")
	WebElement dayTextBox;
	@FindBy(id = "dob-month")
	WebElement monthTextBox;
	@FindBy(id = "dob-year")
	WebElement yearTextBox;
	@FindBy(id = "next-button")
	WebElement nextBtn;
	@FindBy(xpath = "//span[contains(text(),'Why we ask for your date of birth')]")
	WebElement whyDateOfBirthLink;
	
	public DateOfBirth() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterDetails(String textBoxName, String value) {
		try {
		switch(textBoxName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "day":
		case "date":
			Action.type(dayTextBox,value);
			break;
		case "month":
		case "mon":
			Action.type(monthTextBox,value);
			break;
		case "year":
			Action.type(yearTextBox,value);
			break;	
		default:
			throw new TestException("Invalid field" +textBoxName);
		
		}
		}
		catch(Exception e) {
			throw new TestException("failed while entering "+textBoxName +" Field"+ e.getMessage());
		}
	}
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "next":
		case "nxt":
		case "nextbtn":
		case "nextbutton":
			Action.click(getDriver(),nextBtn);
			break;
		case "whydob":
		case "whydateofbirth":
			Action.click(getDriver(),whyDateOfBirthLink);
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
			if(!dayTextBox.isDisplayed())
				throw new TestException("Date Of Birth Page is not displayed");
			System.out.println("TITle ::"+getDriver().getTitle());
	        if(getDriver().getTitle().startsWith("What is your date of birth?")) {
	          }
	        else {
		      throw new TestException("Error occured while loading Date Of Birth Page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Date Of Birth Page is not displayed"+e.getMessage());
		}
	}
}
