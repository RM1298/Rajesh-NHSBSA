package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class GetBenefit extends Base {

	@FindBy(id = "taxCredit")
	WebElement taxCreditBtn;
	@FindBy(id = "incSupport")
	WebElement incomeSupportBtn;
	@FindBy(id = "esa")
	WebElement esaBtn;
	@FindBy(id = "jsa")
	WebElement jsaRadioBtn;
	@FindBy(id = "penCredit")
	WebElement pencreditBtn;
	@FindBy(id = "continue")
	WebElement notGetAnyOfTheseBtn;
	@FindBy(xpath = "//h1[contains(text(),'If your benefit isn't listed or has recently changed')]")
	WebElement benefitLink;
	@FindBy(id = "next-button")
	WebElement nextBtn;

	
	public GetBenefit() {
		PageFactory.initElements(getDriver(), this);
	 }
	public void isPageDisplayed() {
		try {
			if(!benefitLink.isDisplayed())
				throw new TestException("Benefit page is not displayed");
	        if(getDriver().getTitle().startsWith("Do you get any of these benefits?")) {
		      
	          }
	        else {
		      throw new TestException("Error occured while loading Benefit page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Benefit page is not displayed"+e.getMessage());
		}
	}
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "taxcredit":
		case "taxcredits":
			Action.click(getDriver(), taxCreditBtn);
			break;
		case "incomesupport":
			Action.click(getDriver(),incomeSupportBtn);
			break;
		case "esa":
		case "employmentandsupportallowance":
		case "employmentandsupportallowance(esa)":
			Action.click(getDriver(),esaBtn);
			break;
		case "jsa":
		case "jobseekersallowance(jsa)":
		case "jobseeker'sallowance(jsa)":
		case "jobseekerallowance (jsa)":
			Action.click(getDriver(),jsaRadioBtn);
			break;
		case "pensioncredit":
		case "pension":
			Action.click(getDriver(),pencreditBtn);
			break;
		case "noidon'tgetanyofthese":
		case "continue":
			Action.click(getDriver(),notGetAnyOfTheseBtn);
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

