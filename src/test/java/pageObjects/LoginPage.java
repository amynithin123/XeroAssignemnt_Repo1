package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By loginLink = By.xpath(
			"//div[@class='Responsive__Wrapper-sc-19pjhln-0 cWaBAA']//a[@class='Button__Element-lxf8rm-0 ftKSfc Button']");
	By emailField = By.id("xl-form-email");
	By pwdFiled = By.id("xl-form-password");
	By loginButton = By.id("xl-form-submit");
	By allButtons = By.xpath("//button");
	By securityQueButton = By.xpath("//button[@data-automationid='auth-authwithsecurityquestionsbutton']");
	By firstAnsLabel = By.xpath("//label[@data-automationid='auth-firstanswer--label']");
	By secondAnsLabel = By.xpath("//label[@data-automationid='auth-secondanswer--label']");
	By firstSecurityAnsField = By.xpath("//input[@data-automationid='auth-firstanswer--input']");
	By secondSecurityAnsField = By.xpath("//input[@data-automationid='auth-secondanswer--input']");
	By confirmButton=By.xpath("//button[@data-automationid='auth-submitanswersbutton']");

	public String getPageTitle() {

		return ldriver.getTitle();
	}

	public void clickOnLoginLink() {

		ldriver.findElement(loginLink).click();
		
		

	}

	public void enterEmail(String email) {

		ldriver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {

		ldriver.findElement(pwdFiled).sendKeys(password);
	}

	public void clickLoginButton() {

		ldriver.findElement(loginButton).click();
	}

	public void clickBackUpMethodButtonAndAnsSecurityQuestions() {

		String auth_continuebutton_id = "auth-continuebutton";
		String auth_authsetupqa_id = "auth-authsetupqa";
		String security_que1 = "What is your dream job?";
		String security_que2 = "What was the name of your first pet?";
		String security_que3 = "What is the name of your favourite cartoon?";
		String security_que_ans1 = "AutomationTester";
		String security_que_ans2 = "Mikki";
		String security_que_ans3 = "Tom&Jerry";


		int buttons = ldriver.findElements(allButtons).size();
		for (int i = 0; i < buttons; i++) {

			String data_automation_id = ldriver.findElements(allButtons).get(i).getAttribute("data-automationid");

			if (data_automation_id != null) {

				if (data_automation_id.equals(auth_continuebutton_id)
						|| data_automation_id.equals(auth_authsetupqa_id)) {

					ldriver.findElements(allButtons).get(i).click();
					ldriver.findElement(securityQueButton).click();

					String que1 = ldriver.findElements(firstAnsLabel).get(0).getText().toString();
					String que2 = ldriver.findElements(secondAnsLabel).get(0).getText().toString();
	

					if (que1.equals(security_que1)) {

						ldriver.findElement(firstSecurityAnsField).sendKeys(security_que_ans1);

					}
					if (que1.equals(security_que2)) {

						ldriver.findElement(firstSecurityAnsField).sendKeys(security_que_ans2);

					}
					if (que1.equals(security_que3)) {

						ldriver.findElement(firstSecurityAnsField).sendKeys(security_que_ans3);
					}

					 if (que2.equals(security_que1)) {

						ldriver.findElement(secondSecurityAnsField).sendKeys(security_que_ans1);

					}
					if (que2.equals(security_que2)) {

						ldriver.findElement(secondSecurityAnsField).sendKeys(security_que_ans2);

					}
					if (que2.equals(security_que3)) {

						ldriver.findElement(secondSecurityAnsField).sendKeys(security_que_ans3);

					}

				}
			}
		}
		ldriver.findElement(confirmButton).click();
	}
	
	
}
