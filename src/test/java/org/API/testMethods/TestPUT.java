package org.API.testMethods;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPUT {

    @Test
    public void test_put01(){
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
                .put("api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

}
