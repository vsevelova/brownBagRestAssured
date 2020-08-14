package PostData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostData extends BaseClass {

    @Test
    void createNewUser()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "oleg.mykulskyi@accenture.com");
        jsonObject.put("name", "Oleg Mykulskyi");
        jsonObject.put("phone", "+37120300655");
        jsonObject.put("userName", "oleg.mykulskyi");
        jsonObject.put("website", "https://my.accenture.lv/users/oleg_mykulskyi");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.POST,properties.getProperty("postData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }
}
