package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class StepDefinition extends BaseClass {

	@Before
	public void setup() throws IOException {

		logger = logger.getLogger("XeroProjectVersion1");
		PropertyConfigurator.configure("log4j.properties");

		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {

			logger.info("***Launching Chrome Browser***");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {

			logger.info("***Launching Firefox Browser***");

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equals("ie")) {

			logger.info("***Launching Internet Explorer Browser***");

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

	}

	@Given("user launches Chrome browser")
	public void user_launches_chrome_browser() {

		lp = new LoginPage(driver);

	}

	@When("User navigates to {string} the Home page")
	public void user_navigates_to_the_home_page(String url) {

		logger.info("***Opening URL***");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@And("User clicks on Login button in the Login page")
	public void user_clicks_on_login_button_in_the_login_page() {

		logger.info("***Clicking on Login Link***");

		lp.clickOnLoginLink();

	}

	@And("User enters{string} in the Email address field")
	public void user_enters_amynithin123_gmail_com_in_the_email_address_field(String email) {

		logger.info("***Entering a valid email address who is registered to use Xero***");
		lp.enterEmail(email);

	}

	@And("User enters{string} in the Password field")
	public void user_enters_bala_mani123_in_the_password_field(String pwd) {

		logger.info("***Entering the password***");
		lp.enterPassword(pwd);

	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		logger.info("***Clicking on Login Button***");
		lp.clickLoginButton();

	}

	@And("User clicks on User a backup method instead link and clicks on Security questions icon and answers the security questions and confirm")
	public void user_clicks_on_user_a_backup_method_instead_link_and_clicks_on_security_questions_icon_and_answers_the_security_questions_and_confirm()
			throws InterruptedException {

		logger.info("***Validating back up authentication Method***");
		lp.clickBackUpMethodButtonAndAnsSecurityQuestions();

	}

	@Then("Validate that user is successfully login to the Xero Home page")
	public void validate_that_user_is_successfully_login_to_the_xero_home_page() throws InterruptedException {

		logger.info("***Validating user is sucessfully login to the Xero account on entering valid credentials***");
		hp = new HomePage(driver);

		hp.waitForMyXeroIconToLoad();
		String expected_pagetitle = "My Xero | Home";
		String actual_pagetitle = hp.getPageTitle().trim().toString();

		Assert.assertEquals("Sucessfully login to Xero Account", expected_pagetitle, actual_pagetitle);

	}

	@Given("user clicks on Demo Company in the Home Page and clicks My Xero link and enters {string} {string} {string} to add business")
	public void user_clicks_on_demo_company_in_the_home_page_and_clicks_my_xero_link_and_enters_to_add_business(
			String business, String industry, String country) throws InterruptedException {
		
		logger.info("***Adding orgainsation to the account**");

		hp.addOrganisation(business, industry, country);
	}

	
	@When("User clicks on Accounting  and click Bank Accounts and clicks on Add Bank Account and  selects the {string} and enters the mandatory credentials and clicks continue, bank account will be added successfully")
	public void user_clicks_on_accounting_and_click_bank_accounts_and_clicks_on_add_bank_account_and_selects_the_and_enters_the_mandatory_credentials_and_clicks_continue_bank_account_will_be_added_successfully(String bank) throws InterruptedException {
		
		logger.info("***Validating User is able to add a Bank Account successfully***");
		
		String account_name = randomString();
		String account_no = randomNumbers();

		hp.validateAddBankAccount(bank, account_name, account_no);
	}

}