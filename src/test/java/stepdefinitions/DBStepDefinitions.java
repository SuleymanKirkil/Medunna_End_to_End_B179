package stepdefinitions;

import io.cucumber.java.en.*;
import pojos.RoomPojo;

import java.sql.*;

import static junit.framework.TestCase.assertEquals;
import static stepdefinitions.RoomCreationStepDefinitions.*;
import static stepdefinitions.RoomCreationStepDefinitions.roomDescription;


public class DBStepDefinitions {

    Connection connection;
    ResultSet resultSet;
    RoomPojo expectedData;
    @Given("Admin create connection to DB")
    public void admin_create_connection_to_db() throws SQLException {

        expectedData = new RoomPojo(roomNumber,"SUITE",true,roomPrice,roomDescription);

        // Set Connection:
        connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");

    }
    @When("execute query for the room")
    public void execute_query_for_the_room() throws SQLException {
    // Create Statement:
        String queryStatement = "SELECT * FROM room WHERE room_number = "+roomNumber;
        String queryStatement2 = "SELECT * FROM room WHERE id = "+roomIdStr;
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(queryStatement);
    }
    @Then("validates room creation from result set")
    public void validates_room_creation_from_result_set() throws SQLException {
        resultSet.next();
       String actualPrice = resultSet.getString("price");
       String actualType = resultSet.getString("room_type");
       String actualDescription = resultSet.getString("description");
       String actualStatus = resultSet.getString("status");
       String actualRoomNumber = resultSet.getString("room_number");

       assertEquals(expectedData.getPrice()+".00",actualPrice+"");
       assertEquals(expectedData.getDescription(),actualDescription);
       assertEquals(expectedData.isStatus()+"",actualStatus+"rue");
       assertEquals(expectedData.getRoomType(),actualType);
       assertEquals(expectedData.getRoomNumber()+"",actualRoomNumber+"");

    }
}
