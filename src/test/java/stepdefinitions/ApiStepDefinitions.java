package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static basurls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static stepdefinitions.RoomCreationStepDefinitions.roomIdStr;
import static stepdefinitions.RoomCreationStepDefinitions.roomNumber;

public class ApiStepDefinitions {
    Response response;
    @Given("Admin send Get request for all Rooms")
    public void admin_send_get_request_for_all_rooms() {
       // Set Url
        spec.pathParams("first","api"
        ,"second","rooms")
                .queryParam("sort","createdDate,desc");

        // Set Expected Data

        // Send request And Response:
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

    }
    @Then("Verify body for the create room")
    public void verify_body_for_the_create_room() {
        JsonPath json = response.jsonPath();
        Object actualRoomId =json.getList("findAll{it.roomNumber == "+roomNumber+"}.id").get(0);
        Object actualRoomType =json.getList("findAll{it.roomNumber == "+roomNumber+"}.roomType").get(0);
        Object actualRoomStatus =json.getList("findAll{it.roomNumber == "+roomNumber+"}.status").get(0);
        Object actualRoomPrice =json.getList("findAll{it.roomNumber == "+roomNumber+"}.price").get(0);
        Object actualRoomDescription =json.getList("findAll{it.roomNumber == "+roomNumber+"}.description").get(0);

        assertEquals(roomIdStr,actualRoomId+"");
        assertEquals("SUITE",actualRoomType);
        assertEquals(true,actualRoomStatus);
        assertEquals(210.00+"",actualRoomPrice+"");
        assertEquals("Batch 179",actualRoomDescription);

    }
}
