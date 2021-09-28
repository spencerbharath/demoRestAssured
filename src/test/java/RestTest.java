import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class RestTest {

    String baseURL= "https://reqres.in";
    //String baseURLQA = "https://reqres.in";
    //String baseURLUAT = "https://reqres.in";

    @Test
    void testingGet() throws ParseException {

        Response response = RestAssured.get(baseURL+"/api/users?page=2");
        Assert.assertEquals(response.statusCode(),200);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject)parser.parse(response.body().asString());
        System.out.println(json.get("page"));
        Assert.assertEquals(json.get("page").toString(),"2");
        testingGet(json.get("page").toString());

    }

    @Test
    void testingGet(String input) {
        Response response = RestAssured.get(baseURL+"/api/users/"+input);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    void day2TestingUsingPOST() throws ParseException {

        JSONObject requestBody= new JSONObject();
        requestBody.put("name","morpheus");
        requestBody.put("job","leader");
        Response response = RestAssured.given().body(requestBody.toJSONString()).post(baseURL+"/api/users");
        Assert.assertEquals(response.statusCode(),201);
        //System.out.println(response.body().asString());

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject)parser.parse(response.body().asString());
        System.out.println(json.get("id"));
        Assert.assertEquals(json.get("id").toString(),"2");

    }
}


