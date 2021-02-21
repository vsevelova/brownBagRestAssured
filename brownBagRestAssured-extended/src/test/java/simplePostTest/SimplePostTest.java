package simplePostTest;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePostTest extends BaseClass {

    @Test
    void requestToServer()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "feduk@email.com");
        //Add jsonObject for name,phone,userName and website like above.
        jsonObject.put("name", "Feduk");
        jsonObject.put("phone", "371223344");
        jsonObject.put("userName", "Feduk87");
        jsonObject.put("website", "www.company/feduk87.com");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.POST, properties.getProperty("postData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }
}
