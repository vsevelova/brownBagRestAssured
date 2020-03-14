package deleteRequestForEmployeeData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.junit.Assert;
import org.testng.annotations.Test;

public class DeleteRequestForEmployeeRecord extends BaseClass {
    @Test(priority = 1)
    public void requestToServerForDeletionEmployeeRecord() {

        response = httpRequest.request(Method.DELETE, properties.getProperty("deleteEmployeeRecords"));
    }

    @Test(priority = 2)
    void verifyStatusCode()
    {
        int statusCode = response.statusCode();
        Assert.assertEquals(204, statusCode);
    }

    @Test(priority = 3)
    public void verifyDeletedUserNotPresent() {

        response = httpRequest.request(Method.GET, properties.getProperty("getSingelEmployeeData") +properties.getProperty("verificationOfDeletedUserNotPresent"));

        int statusCode = response.statusCode();
        Assert.assertEquals(404, statusCode);
    }
}
