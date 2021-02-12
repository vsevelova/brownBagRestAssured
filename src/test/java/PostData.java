import baseclass.BaseClass;
import io.restassured.http.Method;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostData extends BaseClass {

    @Test
   void addRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "testing@test.test");
        jsonObject.put("name", "testingname");
        jsonObject.put("phone", "testingphone");
        jsonObject.put("userName", "utkina");
        jsonObject.put("website", "testinglink.test");
        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.POST,properties.getProperty("postData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
    }
}
