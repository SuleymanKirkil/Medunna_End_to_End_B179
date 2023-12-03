package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static basurls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class ApiStedDefinitions {
    @Given("Admin send Get request for all Rooms")
    public void admin_send_get_request_for_all_rooms() {
       // Set Url
        spec.pathParams("first","api"
        ,"second","rooms");

        // Set Expected Data

        // Send request And Response:
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();


    }
    @Then("Verify body for the create room")
    public void verify_body_for_the_create_room() {

    }
}
