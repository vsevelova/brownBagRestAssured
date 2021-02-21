package UpdateData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class UpdateData extends BaseClass {

    @Test
    void requestToServer() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("street","Station Parade");
        jsonObject.put("suite","16");
        jsonObject.put("city","Barnet");
        jsonObject.put("zipCode","EN48QH");
       ///Add jsonObject for suite,city and zipCode like above
        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.PUT, properties.getProperty("updateRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);

    }




}