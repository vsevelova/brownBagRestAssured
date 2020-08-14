package GetData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData extends BaseClass {

    @Test
    void getAllUsers()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("allUsers"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains("oleg.mykulskyi"),true);
        JsonPath jsonPath = response.jsonPath();
        String validateName = jsonPath.get("name").toString();
        Assert.assertEquals(validateName.contains("Oleg Mykulskyi"),true);
    }
}
