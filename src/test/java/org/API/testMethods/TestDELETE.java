package org.API.testMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestDELETE {

    @Test
    public void test_Delete_01(){

        String baseURI="https://reqres.in/";

        WebDriver driver=new ChromeDriver();

        given()
                .baseUri(baseURI)
                .when()
                .delete("api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();

    }
}
