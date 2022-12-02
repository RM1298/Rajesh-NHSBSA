package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class UniversalCredit extends Base {
	
	@FindBy(id = "yes-universal")
	WebElement yesRadioBtn;
	@FindBy(id = "not-yet")
	WebElement noRadioBtn;
	@FindBy(id = "question-heading")
	WebElement universalCreditQuestion;
	@FindBy(id = "different-benefit")
	WebElement differentBenefitRadioBtn;
	@FindBy(id = "next-button")
	WebElement nextBtn;

	
	public UniversalCredit() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!universalCreditQuestion.isDisplayed())
				throw new TestException("Universal Credit page is not displayed");
	        if(getDriver().getTitle().startsWith("Do you get paid Universal Credit? ")) {
		      
	          }
	        else {
		      throw new TestException("Error occured while loading Universal Credit page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Universal Credit page is not displayed"+e.getMessage());
		}
	}
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "yes":
		case "yes,ireceiveuniversalcreditpayments":
		case "yesireceiveuniversalcreditpayments":
			Action.click(getDriver(), yesRadioBtn);
			break;
		case "no":
		case "nobutihaveapplied":
		case "notyetbutihaveapplied":
		case "not":
		case "notyet,buti'veapplied":
		case "notyetbutiveapplied":
			Action.click(getDriver(),noRadioBtn);
			break;
		case "no,igetadifferentbenefit":
		case "noigetadifferentbenefit":
			Action.click(getDriver(),differentBenefitRadioBtn);
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
