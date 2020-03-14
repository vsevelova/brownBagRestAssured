package postRequestForSingleEmployeeData;

import baseclass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilityClass.RestUtility;

public class PostSingleEmployeeData extends BaseClass {
    String employeEmail = RestUtility.email();
    String employeeName = RestUtility.empName();
    String employeePhoneNumber = RestUtility.phone();
    String employeUserName = RestUtility.userName();
    String employeWebsite = RestUtility.website();


    @Test(priority = 1)
    void sendDataToServer()
    {
        RestAssured.baseURI = properties.getProperty("baseURL");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", employeEmail);
        jsonObject.put("name", employeeName);
        jsonObject.put("phone", employeePhoneNumber);
        jsonObject.put("userName", employeUserName);
        jsonObject.put("website", employeWebsite);

        httpRequest.header("content-Type", "application/json");

        httpRequest.body(jsonObject.toJSONString());

        response = httpRequest.request(Method.POST, properties.getProperty("postEmployeeData"));
    }

    @Test(priority = 2)
    void verifyStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 3)
    void verifyEmployeeDataSavedSuccessfully()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody != null, true);
    }


}
