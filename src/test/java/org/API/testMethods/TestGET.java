package org.API.testMethods;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGET {

    @Test
    public void test_01(){

        Response response=get("https://reqres.in/api/users?page=2");


        System.out.println("***** Response ******");
        System.out.println(response.asString());

        System.out.println("***** Response status code ******");
        System.out.println(response.getStatusCode());

        System.out.println("***** Response Body ******");
        System.out.println(response.getBody().asString());

        System.out.println("***** Response status line ******");
        System.out.println(response.getStatusLine());

        System.out.println("***** Response content type ******");
        System.out.println(response.getHeader("content-type"));

        System.out.println("***** Response time ******");
        System.out.println(response.getTime());

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test
    public void test_02(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7))
                .body("data.first_name",hasItems("Michael","Lindsay","Tobias"))
                .log().all()

        ;

    }

}
