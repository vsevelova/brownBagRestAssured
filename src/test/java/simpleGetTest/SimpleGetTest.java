package simpleGetTest;

import baseclass.BaseClass;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class SimpleGetTest extends BaseClass {

    @Test
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getAllUser"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    void responseBody() {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingleEmployeeData"));
        JsonPath jsonPath = response.jsonPath();
        String validateUserName = jsonPath.get("userName").toString();
        Assert.assertEquals(validateUserName.contains("utkina"), true);
        String validateName = jsonPath.get("name").toString();
        Assert.assertEquals(validateName.contains("testingname"), true);
        String validatePhone = jsonPath.get("phone").toString();
        Assert.assertEquals(validatePhone.contains("testingname"), false);
        Map<String, String> address = response.jsonPath().getMap("address");
        String iela = address.get("street");
        Assert.assertEquals(iela, "rigastreet");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
