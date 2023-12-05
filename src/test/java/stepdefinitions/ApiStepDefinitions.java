package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.RoomDTO;
import pojos.RoomPojo;

import static basurls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static stepdefinitions.RoomCreationStepDefinitions.*;

public class ApiStepDefinitions {
    Response response;
    RoomPojo expectedData;
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

    @Given("Admin send Get request for created room by its Id")
    public void admin_send_get_request_for_created_room_by_its_id() {
        // Set Url
        spec.pathParams("first","api"
        ,"second","rooms"
        ,"third",Integer.valueOf(roomIdStr));

        // Set Expected Data
        expectedData = new RoomPojo(roomNumber,"SUITE",true,roomPrice,roomDescription);

        // Sent Request
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

    }
    @Then("validates body for created room")
    public void validates_body_for_created_room() throws JsonProcessingException {
        // first way to de-serialize
        RoomPojo actualData =  new ObjectMapper().readValue(response.asString(),RoomPojo.class);

        // second Way
        RoomPojo actualData2 = response.as(RoomPojo.class);

        // third way:
        RoomPojo actualData3 = new Gson().fromJson(response.asString(),RoomPojo.class);

        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
        assertEquals(expectedData.isStatus(),actualData.isStatus());
        assertEquals(expectedData.getPrice()+ ".0",actualData.getPrice()+"");






    }
}
