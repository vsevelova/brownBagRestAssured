package getRequestForSingleEmployeeData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleEmployeeRecordGetRequest extends BaseClass {

    @Test(priority = 1)
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingelEmployeeData") + properties.getProperty("userName1"));
    }

    @Test(priority = 2)
    void verifyStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 3)
    void verifyStatusLine()
    {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 ");
    }

    @Test(priority = 4)
    void verifyResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains("Name"),true);
        Assert.assertEquals(responseBody.contains("ukrainis.v@gmail.com"),true);
        Assert.assertEquals(responseBody.contains("Sherhan"),true);
        Assert.assertEquals(responseBody.contains("656646464"),true);
        Assert.assertEquals(responseBody.contains("www.google.com"),true);

        JsonPath jsonPath = response.jsonPath();
//        System.out.println(jsonPath.get("name"));
//        System.out.println(jsonPath.get("email"));
//        System.out.println(jsonPath.get("userName"));
//        System.out.println(jsonPath.get("phone"));
//        System.out.println(jsonPath.get("website"));
    }


}
