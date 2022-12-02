package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import actionDriver.Action;
import basepackage.Base;

public class DentalPractice extends Base {


	@FindBy(xpath = "//label[contains(text(),'England')]")
	WebElement englandRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'Scotland')]")
	WebElement scotlandRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'Wales')]")
	WebElement walesRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'Northern Ireland')]")
	WebElement northernIrelandRadioBTN;
	@FindBy(xpath = "//label[contains(text(),'I am not registered with a dental practice')]")
	WebElement notRegisterBTN;
	@FindBy(id = "next-button")
	WebElement nextBtn;
	
	public DentalPractice() {
		PageFactory.initElements(getDriver(), this);
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
		case "notregister":
		case "iamnotregisteredwithadentalpractice":
			Action.click(getDriver(),notRegisterBTN);
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
			if(!notRegisterBTN.isDisplayed())
				throw new TestException("Dental Practice page is not displayed");
			System.out.println("TITle ::"+getDriver().getTitle());
	        if(getDriver().getTitle().startsWith("Which country is your dental practice in?")) {
	          }
	        else {
		      throw new TestException("Error occured while loading dental practice Page");
	          }
		}
		catch(Exception e) {
			throw new TestException("Dental practice is not displayed"+e.getMessage());
		}
	}
	
	
	
	
}
