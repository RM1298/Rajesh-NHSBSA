package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class CountrySelection extends Base {

	@FindBy(xpath = "//label[contains(text(),'England')]")
	WebElement englandRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'Scotland')]")
	WebElement scotlandRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'Wales')]")
	WebElement walesRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'Northern Ireland')]")
	WebElement northernIrelandRadioBTN;
	@FindBy(xpath = "//h1[contains(text(),'Which country do you live in?')]")
	WebElement CountrySelection;
	@FindBy(id = "next-button")
	WebElement nextBtn;
	

	public CountrySelection() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void isPageDisplayed() {
		try {
			if(!CountrySelection.isDisplayed())
				throw new TestException("Country Selection page is not displayed");
	   }
		catch(Exception e) {
			throw new TestException("Country Selection page is not displayed"+e.getMessage());
		}
	}
	
	
	public void performclick(String buttonName) {
		try {
		switch(buttonName.trim().toLowerCase().replaceAll(" ", "").replaceAll("_", "")) {
		case "eng":
		case "england":
			Action.click(getDriver(), englandRadioBTN);
			break;
		case "scot":
		case "scotland":
			Action.click(getDriver(),scotlandRadioBTN);
			break;
		case "wales":
			Action.click(getDriver(),walesRadioBTN);
			break;
		case "northireland!":
		case "northernireland":
		case "ireland":
			Action.click(getDriver(), northernIrelandRadioBTN);
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
