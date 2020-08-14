package DeleteData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteData extends BaseClass {

    @Test
    void deleteUser()
    {
        JSONObject jsonObject = new JSONObject();
        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response=httpRequest.request(Method.DELETE,properties.getProperty("deleteRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204);
    }
}
