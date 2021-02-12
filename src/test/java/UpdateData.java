import baseclass.BaseClass;
import io.restassured.http.Method;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class UpdateData extends BaseClass {

    @Test
    void addObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("street", "rigastreet");
        jsonObject.put("suite", "testsuite");
        jsonObject.put("city", "riga");
        jsonObject.put("zipcode", "LV1234");
        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.PUT, properties.getProperty("updateRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(204, statusCode);
    }
}
