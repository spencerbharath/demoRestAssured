import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Rest2Test {

    @Test
    void day2TestingUsingPOST() throws ParseException {
        String baseURl="https://reqres.in/api";

        JSONObject requestBody= new JSONObject();
        requestBody.put("name","morpheus");
        requestBody.put("job","leader");

        Response response = RestAssured.given().body(requestBody.toJSONString()).post("https://reqres.in/api/users");
        Assert.assertEquals(response.statusCode(),201);
        //System.out.println(response.body().asString());



    }


}
