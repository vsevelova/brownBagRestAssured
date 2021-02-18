import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateData extends BaseClass {

    @Test
    void UpdateData()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("street", "Maskavas");
        jsonObject.put("suite", "18");
        jsonObject.put("city", "Riga");
        jsonObject.put("zipcode", "LV-1060");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.PUT ,properties.getProperty("updateRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204);
    }
}
