package UpdateData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateData extends BaseClass {

    @Test
    void updateUserAddress()
    {
        JsonObject payload = new JsonObject();
        payload.addProperty("city", "Riga");
        payload.addProperty("street", "Krisjana Barona iela 23");
        payload.addProperty("suite", "55");
        payload.addProperty("zipcode", "LV-1011");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(payload.toString());
        response = httpRequest.request(Method.PUT,properties.getProperty("updateRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204);
    }
}
