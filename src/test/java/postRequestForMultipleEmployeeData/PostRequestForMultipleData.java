package postRequestForMultipleEmployeeData;

import baseclass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilityClass.RestUtility;

public class PostRequestForMultipleData extends BaseClass {

    @Test(priority = 1, dataProvider = "employeeData")
    void sendDataToServer(String employeEmail, String employeeName, String employeePhoneNumber, String employeUserName, String employeWebsite)
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

    @DataProvider(name = "employeeData")
    Object[][]employeeData()
    {
        String  employData [][] = {
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()},
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()},
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()},
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()},
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()},
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()},
                {RestUtility.email(), RestUtility.name(), RestUtility.phone(),RestUtility.userName(),RestUtility.website()}};
        return (employData);
    }
}
