import baseclass.BaseClass;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;


public class PostClass extends BaseClass {

    @Test
    void PostData()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "mans@mail.lv");
        jsonObject.put("name", "Guinea");
        jsonObject.put("phone", "12345678");
        jsonObject.put("userName", "Pig");
        jsonObject.put("website", "dd@dd.lv");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.POST,properties.getProperty("postData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);

    }

}
