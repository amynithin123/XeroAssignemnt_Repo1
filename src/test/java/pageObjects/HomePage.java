package pageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public HomePage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By DemoCompanyButton = By.xpath("//span[@class='xnav-appbutton--text']");
	By DashBoard = By
			.xpath("//a[@class='xnav-focusable xnav-tab--body xnav-tab--body-is-selected xnav-tab--body-is-selected']");
	By MyXeroLink = By.linkText("My Xero");
	By businessNameField = By.xpath("//input[@data-automationid='organisation-name--input']");
	By industryField = By.xpath("//input[@data-automationid='industry-autocompleter--input']");
	By industryDropDown = By.xpath("//li[@class='xui-pickitem xui-pickitem-is-hovered xui-pickitem-medium']");
	By countryDropDownIcon = By.xpath("//div[@class='xui-touchtarget']");
	By countryDropDownItem = By.xpath("//li[@id='CNTRY/NZ']");
	By employeeNoQueRadioButton = By
			.xpath("//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-small']");
	By startTrailButton = By.xpath("//button[@data-automationid='NewOrgProv-StartTrial']");
	By dashBoardOrgName = By.xpath("a[@data-automationid='dashboardOrgName']");
	By addyourBusinessLink = By.linkText("Add your business");
	By allLinks = By.xpath("//a");
	By addOrgnaisationLink = By.linkText("Add an organisation");
	By myXeroIcon = By.xpath("//span[@class='xnav-appbutton--text']");
	By addOrganisationButton = By.linkText("Add an organisation");
	By accountingButton = By.xpath("//button[@data-name='navigation-menu/accounting']");
	By bankAccountLink = By.linkText("Bank accounts");
	By addBankAccountLink = By.linkText("Add Bank Account");
	By bankSearchField = By.id("bankSearch-input");
	By bankList = By.xpath("//span[@class='bank-search-normal-text']");
	By accountNameField = By.id("accountname-1025-inputEl");
	By accountType = By.id("accounttype-1027-inputEl");
	By accountTypeTrigger = By.id("accounttype-1027-trigger-picker");
	By continueButton = By.id("common-button-submit-1015");
	By loanDropDownItem = By.xpath("//*[contains(text(),'Loan')]");
	By accountNoField = By.id("accountnumber-1056-inputEl");
	By actualBankAccName = By.xpath("//div[@class='bankaccounts-account--name']");
	By actualBankAccNo = By.xpath("//div[@class='bankaccounts-account--number']");
	By gotFormButton = By.xpath("//a[@data-automationid='connectbank-buttonIHaveAForm']");
	By uploadLaterButton = By.xpath("//a[@data-automationid='uploadForm-uploadLaterButton']");
	By goToDashBoardButton = By.xpath("//a[@data-automationid='uploadFormLater-goToDashboardButton']");

	public String getPageTitle() {

		return ldriver.getTitle();
	}

	public void waitForMyXeroIconToLoad() {

		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myXeroIcon));

	}

	public void addOrganisation(String business, String industry, String country)  {

		wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myXeroIcon)).click();

		ldriver.findElement(addOrganisationButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(businessNameField)).sendKeys(business);

		ldriver.findElement(industryField).clear();
		ldriver.findElement(industryField).sendKeys(industry);
		wait.until(ExpectedConditions.visibilityOfElementLocated(industryDropDown)).click();
		ldriver.findElement(countryDropDownIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDownItem)).click();

		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNoQueRadioButton));

		if (!(ldriver.findElement(employeeNoQueRadioButton).isSelected())) {

			wait.until(ExpectedConditions.elementToBeClickable(employeeNoQueRadioButton)).click();
		}

		ldriver.findElement(startTrailButton).click();

	}

	public void validateAddBankAccount(String bank, String account_name, String account_number) throws InterruptedException {

		wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountingButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(bankAccountLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addBankAccountLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(bankSearchField)).sendKeys(bank);
		Thread.sleep(2000);
		ldriver.findElements(bankList).get(0).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(accountNameField)).sendKeys(account_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountTypeTrigger)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loanDropDownItem)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountNoField)).sendKeys(account_number);
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(actualBankAccName));

		String actual_account_name = ldriver.findElement(actualBankAccName).getText().toString();
		Assert.assertEquals("Bank Account Name has been added successfully", account_name, actual_account_name);

		String actual_account_no = ldriver.findElement(actualBankAccNo).getText().toString();
		Assert.assertEquals("Bank Account Number has been added successfully", account_number, actual_account_no);

		ldriver.findElement(gotFormButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadLaterButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(goToDashBoardButton)).click();

	}

}