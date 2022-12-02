package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actionDriver.Action;
import basepackage.Base;
import dataProviderPackage.DataFactory;
import pageObjects.ArmedForce;
import pageObjects.BenifitOrTax;
import pageObjects.CareHome;
import pageObjects.CountrySelection;
import pageObjects.DateOfBirth;
import pageObjects.DentalPractice;
import pageObjects.Diabetes;
import pageObjects.Glaucoma;
import pageObjects.GpPractice;
import pageObjects.HomePage;
import pageObjects.LocalCouncil;
import pageObjects.Partner;
import pageObjects.PregnantOrGivenBirth;
import pageObjects.UniversalCredit;
import pageObjects.WealthMoreThan16000Dollar;
import pageObjects.WealthMoreThan24000Dollar;
import utility.Log;
@Guice
public class SignInAccountTC extends Base{
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
	}

@Test(groups = "Sanity",dataProvider = "TestDataScenario01", dataProviderClass = DataFactory.class)
public void verifyScenerio1(String cookies,String country,String gpPractice, String CountryDentalPractice, String DOB, String LiveWIthPartner , String BenefitorTax, String pregnentORgivenBirth, String armedForce, String diabetes, String glaucoma , String carehome, String wealthMoreThan16000) {

	VerifyHomepage(cookies);
	
	verifyCountrySelection(country);
	
	VerifyGpPractice(gpPractice);
	
	VerifyDentalPractice(CountryDentalPractice);
	
	VerifyDateOfBirth(DOB);
	
	VerifyPartner(LiveWIthPartner);

	VerifyBenefitorTax(BenefitorTax);
	
	VerifyPregnantOrGivenBirth(pregnentORgivenBirth);
	
	VerifyArmedForce(armedForce);
	
	VerifyDiabetes(diabetes);
	
	verifyGlaucoma(glaucoma);
	
	verifyCareHome(carehome);
	
	verifywealthMoreThan16000Dollar(wealthMoreThan16000);
	
}
@Test(groups = "Sanity",dataProvider = "TestDataScenario02", dataProviderClass = DataFactory.class)
public void verifyScenerio2(String cookies,String country,String gpPractice, String CountryDentalPractice, String DOB, String LiveWIthPartner , String BenefitorTax, String pregnentORgivenBirth, String armedForce, String diabetes, String glaucoma , String carehome, String PayFromLocalCouncil) {

	VerifyHomepage(cookies);
	
	verifyCountrySelection(country);
	
	VerifyGpPractice(gpPractice);
	
	VerifyDentalPractice(CountryDentalPractice);
	
	VerifyDateOfBirth(DOB);
	
	VerifyPartner(LiveWIthPartner);

	VerifyBenefitorTax(BenefitorTax);
	
	VerifyPregnantOrGivenBirth(pregnentORgivenBirth);
	
	VerifyArmedForce(armedForce);
	
	VerifyDiabetes(diabetes);
	
	verifyGlaucoma(glaucoma);
	
	verifyCareHome(carehome);
	
	verifyPayFromLocalCouncil(PayFromLocalCouncil);
}
@Test(groups = "Sanity",dataProvider = "TestDataScenario03", dataProviderClass = DataFactory.class)
public void verifyScenerio3(String cookies,String country,String gpPractice, String CountryDentalPractice, String DOB, String LiveWIthPartner , String BenefitorTax, String pregnentORgivenBirth, String armedForce, String diabetes, String glaucoma , String carehome, String PayFromLocalCouncil, String wealthMoreThan24000$) {

	VerifyHomepage(cookies);
	
	verifyCountrySelection(country);
	
	VerifyGpPractice(gpPractice);
	
	VerifyDentalPractice(CountryDentalPractice);
	
	VerifyDateOfBirth(DOB);
	
	VerifyPartner(LiveWIthPartner);

	VerifyBenefitorTax(BenefitorTax);
	
	VerifyPregnantOrGivenBirth(pregnentORgivenBirth);
	
	VerifyArmedForce(armedForce);
	
	VerifyDiabetes(diabetes);
	
	verifyGlaucoma(glaucoma);
	
	verifyCareHome(carehome);
	
	verifyPayFromLocalCouncil(PayFromLocalCouncil);
	verifywealthMoreThan24000Dollar(wealthMoreThan24000$);
}

public void VerifyHomepage(String value) {
	
	HomePage homepageobject = new HomePage();
	homepageobject.isPageDisplayed();
	Log.info("Home page is displayed");
	Action.implicitWait(getDriver(), 10);
	homepageobject.performclick(value);
	homepageobject.performclick("startnow");
	Log.info("clicked startnow button successfully");
}
public void verifyCountrySelection(String value) {
	CountrySelection countrySelection = new CountrySelection();
	countrySelection.isPageDisplayed();
	countrySelection.performclick(value);
	countrySelection.performclick("Next");
	}
public void VerifyGpPractice(String value) {
	GpPractice gp = new GpPractice();
	gp.isPageDisplayed();
	gp.performclick(value);
	gp.performclick("Next");
	}
	public void VerifyDentalPractice(String value) {
	DentalPractice dentalPractice = new DentalPractice();
	dentalPractice.isPageDisplayed();
	dentalPractice.performclick(value);
	dentalPractice.performclick("Next");
	}
	public void VerifyDateOfBirth(String value) {
		DateOfBirth dateOfBirth = new DateOfBirth();
		dateOfBirth.isPageDisplayed();
		String[] date = value.split("-");
		dateOfBirth.enterDetails("Date", date[0]);
		dateOfBirth.enterDetails("Month", date[1]);
		dateOfBirth.enterDetails("Year", date[2]);
		dateOfBirth.performclick("Next");
		}
	public void VerifyPartner(String value) {
		Partner partner = new Partner();
		partner.isPageDisplayed();
		partner.performclick(value);
		partner.performclick("Next");
	}
	public void VerifyBenefitorTax(String value){
		BenifitOrTax bt = new BenifitOrTax();
		bt.isPageDisplayed();
		bt.performclick(value);
		bt.performclick("Next");
	}
public void VerifyPregnantOrGivenBirth(String value) {
	PregnantOrGivenBirth pregnantOrGivenBirth = new PregnantOrGivenBirth();
	pregnantOrGivenBirth.isPageDisplayed();
	pregnantOrGivenBirth.performclick(value);
	pregnantOrGivenBirth.performclick("Next");
}

public void VerifyArmedForce( String value) {
	ArmedForce armedForce = new ArmedForce();
	armedForce.isPageDisplayed();
	armedForce.performclick(value);
	armedForce.performclick("Next");
}

public void VerifyDiabetes (String value) {
	Diabetes diabetes = new Diabetes();
	diabetes.isPageDisplayed();
	diabetes.performclick(value);
	diabetes.performclick("Next");
}
public void verifyGlaucoma(String value) {
	Glaucoma glaucoma = new Glaucoma();
	glaucoma.isPageDisplayed();
	glaucoma.performclick(value);
	glaucoma.performclick("Next");
}
public void verifyCareHome(String value) {
	CareHome careHome = new  CareHome();
	careHome.isPageDisplayed();
	careHome.performclick(value);
	careHome.performclick("Next");
}
public void verifywealthMoreThan16000Dollar(String value) {
WealthMoreThan16000Dollar wealth = new WealthMoreThan16000Dollar();
wealth.isPageDisplayed();
wealth.performclick(value);
wealth.performclick("Next");
}
public void verifyPayFromLocalCouncil(String value) {
	LocalCouncil localCouncil = new LocalCouncil();
	localCouncil.isPageDisplayed();
	localCouncil.performclick(value);
	localCouncil.performclick("Next");
}
public void verifywealthMoreThan24000Dollar(String value) {
WealthMoreThan24000Dollar wealth24Dollar = new WealthMoreThan24000Dollar();
wealth24Dollar.isPageDisplayed();
wealth24Dollar.performclick(value);
wealth24Dollar.performclick("Next");
}
public void verifyUniveralCredit(String value) {
	UniversalCredit universalCreditOBJ = new UniversalCredit();
	universalCreditOBJ.isPageDisplayed();
	universalCreditOBJ.performclick(value);
	universalCreditOBJ.performclick("Next");
}

public void verifyUniversalCreditDecision() {
	UniversalCredit universalCreditDecisionOBJ = new UniversalCredit();
	universalCreditDecisionOBJ.performclick("Next");
}

@AfterMethod(groups = {"Smoke","Sanity","Regr{ession"})
public void tearDown() {
	//getDriver().quit();	
}
}
