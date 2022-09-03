package org.API.testMethods;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPATCH {

    @Test
    public void test_Patch01(){

        JSONObject request=new JSONObject();
        request.put("name","VinTest");
        request.put("job", "Engineer");

        String baseURI="https://reqres.in/";

        given()
                .baseUri(baseURI)
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
