package org.API.testMethods;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.net.URL;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestPOST {
    @Test
    public void post_01(){

        JSONObject request=new JSONObject();
        request.put("name","VinTest");
        request.put("job", "Engineer");

        String baseURI="https://reqres.in/";

        given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .log().all()
                .when()
                .post("api/users")
                .then()
                .statusCode(201)
                .log().all();

    }

}
