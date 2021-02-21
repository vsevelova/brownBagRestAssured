package DeleteData;

import baseclass.BaseClass;
import com.google.gson.JsonObject;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteData extends BaseClass {

    @Test
    void deleteUser()
    {
        JsonObject payload = new JsonObject();
        httpRequest.header("content-Type", "application/json");
        httpRequest.body(payload.toString());
        response=httpRequest.request(Method.DELETE,properties.getProperty("deleteRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204);
    }
}
