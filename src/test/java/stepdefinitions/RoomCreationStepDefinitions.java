package stepdefinitions;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import pages.MedunnaRoomPage;
import utils.Driver;
import utils.ReusableMethods;

public class RoomCreationStepDefinitions {
    public  static int roomNumber;
    public  static String roomIdStr;
    public  static String roomPrice;
    public  static String roomDescription;
    MedunnaRoomPage roomPage = new MedunnaRoomPage();
    MedunnaHomePage homePage = new MedunnaHomePage();
    MedunnaLoginPage loginPage = new MedunnaLoginPage();
    @When("click on items&Titles button")
    public void click_on_items_titles_button() {;

        homePage.itemsdAndTitles.click();
    }

    @When("click on Room button")
    public void click_on_room_button() {
        homePage.roomOption.click();
    }
    @When("click on Create new Room button")
    public void click_on_create_new_room_button() {
        roomPage.createANewRoomButton.click();
    }
    @When("enter room number into Room Number field")
    public void enter_room_number_into_room_number_field() {
        roomNumber = Faker.instance().number().numberBetween(10000,100000);
        roomPage.roomNumberInput.sendKeys(roomNumber + "");
    }
    @When("select SUITE option from room type dropdown")
    public void select_suite_option_from_room_type_dropdown() {
        Select select = new Select(roomPage.roomTypeDropDown);
        select.selectByIndex(3);
    }
    @When("select status box")
    public void select_status_box() {
        roomPage.statusCheckbox.click();
    }

    @And("enter {string} into Price field")
    public void enterIntoPriceField(String price) {
        roomPrice = price;
        roomPage.priceInput.sendKeys(price);
    }

    @And("enter {string} into Description field")
    public void enterIntoDescriptionField(String description) {
        roomDescription = description;
        roomPage.descriptionInput.sendKeys(description);
    }

    @When("click Save submit button")
    public void click_save_submit_button() {
        ReusableMethods.click(roomPage.saveSubmitButton);
        ReusableMethods.visibleWait(roomPage.alert,5);
        roomIdStr = roomPage.alert.getText().replaceAll("[^0-9]","");
        System.out.println(roomIdStr);
    }
}
