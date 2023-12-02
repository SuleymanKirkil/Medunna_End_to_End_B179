package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class MedunnaRoomPage {

    public MedunnaRoomPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "jh-create-entity")
    public WebElement createANewRoomButton;

    @FindBy(id = "room-roomNumber")
    public WebElement roomNumberInput;

    @FindBy(id = "room-roomType")
    public WebElement roomTypeDropDown;

    @FindBy(id = "room-status")
    public WebElement statusCheckbox;

    @FindBy(id = "room-price")
    public WebElement priceInput;

    @FindBy(id = "room-description")
    public WebElement descriptionInput;

    @FindBy(id = "save-entity")
    public WebElement saveSubmitButton;

    @FindBy(xpath = "//span[.='Created Date']")
    public WebElement createdDate;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> roomNumberlist;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement firstId;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;



}
