package PostData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostData extends BaseClass {

    @Test
    void createNewUser()
    {
        JsonObject payload = new JsonObject();
        payload.addProperty("email", "oleg.mykulskyi@accenture.com");
        payload.addProperty("name", "Oleg Mykulskyi");
        payload.addProperty("phone", "+37120300655");
        payload.addProperty("userName", "oleg.mykulskyi");
        payload.addProperty("website", "https://my.accenture.lv/users/oleg_mykulskyi");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(payload.toString());
        response = httpRequest.request(Method.POST,properties.getProperty("postData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }
}
