package stepdefinitions;

import io.cucumber.java.en.*;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import pages.MedunnaRoomPage;
import utils.ConfigReader;
import utils.Driver;

public class SignInStepDefinitions {
    MedunnaHomePage homePage = new MedunnaHomePage();
    MedunnaLoginPage loginPage = new MedunnaLoginPage();
    MedunnaRoomPage roomPage = new MedunnaRoomPage();

    @Given("Admin visits url {string}")
    public void admin_visits_url(String url) {
        Driver.getDriver().get(url);
    }

    @When("click on users button")
    public void click_on_users_button() {
        homePage.userIcon.click();
    }

    @When("click on Sign in button")
    public void click_on_sign_in_button() {
        homePage.signInOption.click();
    }

    @When("enter username into Username Field")
    public void enter_username_into_username_field() {
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }

    @When("enter password into Password Field")
    public void enter_password_into_password_field() {
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }

    @When("click on Sign In submit button")
    public void click_on_sign_in_submit_button() {
        loginPage.signInSubmitButton.click();
    }
}
