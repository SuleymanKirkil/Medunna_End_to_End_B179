package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MedunnaLoginPage {

    public MedunnaLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = " //button[@type='submit']")
    public WebElement signInSubmitButton;


}
