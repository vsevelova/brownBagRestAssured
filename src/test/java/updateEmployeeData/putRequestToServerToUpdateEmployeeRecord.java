package updateEmployeeData;

import baseclass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilityClass.RestUtility;

public class putRequestToServerToUpdateEmployeeRecord extends BaseClass {
    String street = RestUtility.street();
    String suite = RestUtility.suite();
    String city = RestUtility.city();
    String zipeCode = RestUtility.zipcode();

  @Test(priority = 1)
   public void requestToServerForEmployeeRecordUpdation() {
       JSONObject requestParams = new JSONObject();
       requestParams.put("street", street);
       requestParams.put("suite", suite);
       requestParams.put("city", city);
       requestParams.put("zipcode", zipeCode);

       httpRequest.header("Content-Type", "application/json");
       httpRequest.body(requestParams.toJSONString());
       response = httpRequest.request(Method.PUT, properties.getProperty("updateEmployeeRecord"));
   }

   @Test(priority = 2)
    public void verifyStatusCode()
   {
       int statusCode = response.statusCode();
       Assert.assertEquals(204, statusCode);
   }

   @Test(priority = 3)
    void verifyUpdatedEmployeeRecords()
   {
     //  System.out.println(response.getBody());
       // updated information only verify in get method in this case because here PUT end point return only status.

   }
}
