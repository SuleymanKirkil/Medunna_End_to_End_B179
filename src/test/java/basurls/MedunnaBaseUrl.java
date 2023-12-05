package basurls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static utils.Authentication.generateToken;

public class MedunnaBaseUrl {

    public static RequestSpecification spec;

    public static void setUp(){
        spec = new RequestSpecBuilder()
                .addHeader("Authorization","Bearer "+generateToken())
                .setContentType(ContentType.JSON)
                .setBaseUri(ConfigReader.getProperty("medunna_url"))
                .build();
    }

}
