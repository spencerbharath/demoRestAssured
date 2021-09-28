import static io.restassured.RestAssured.*;
import  static   io.restassured.matcher.RestAssuredMatchers.*;
import  static  org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class StaticTests {

    @Test
    void testingSystems(){

        //String classpath = System.getProperty("java.class.path");
        //String[] classpathEntries = classpath.split(File.pathSeparator);
        //System.out.println(classpathEntries);
        //System.out.println(System.getProperty("java.class.path"));
        RestAssured.
                given().
                get("https://reqres.in/api/users").
                then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("responce.json"));



        //System.out.println(value);

       //building Request
        //RestAssured.given(). queryParam("").when().
          //      get("https://reqres.in/api/users")
                        //Asserting
            //            .then().assertThat().body("data.first_name",hasItems("Janet","George"));

    }


}
