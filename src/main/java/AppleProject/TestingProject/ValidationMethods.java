package AppleProject.TestingProject;


import java.util.Map;

import org.testng.Assert;

import io.restassured.response.Response;

public class ValidationMethods {
	//private static Map<String, Object> obj=null;
	
	public static void checkStatusIs200 (Response res) {
        Assert.assertEquals(res.getStatusCode(), 200);
    }
	public static Map<String, Object> getResponseStatus(Response res) {
		Map<String, Object> obj= res.jsonPath().getMap("$..");
		return obj;
	}
	public static boolean checkResponseStatusIsY(Map<String, Object> obj) {
		boolean status=false;
		for (Map.Entry<String, Object> entry : obj.entrySet()) {
		    String data=entry.getValue().toString();
		    if(data.contains("status=y"))
		       	status=true;
		    
		    return status;
		   
		}
		return status;

	}
	public static void displayResponse(Map<String, Object> obj) {
		System.out.println("Countries having Apple Store are:");
		for (Map.Entry<String, Object> entry : obj.entrySet()) {
		    String data=entry.getValue().toString();
		    String[] values=data.split(",",2);
		    {
		    	if(values[1].contains("status=y"))
		    		System.out.println("Apple Store in country "+ values[0].substring(6)+" is down");
		    	else
		    		System.out.println(values[0].substring(6));
		    }
	}
	

}
}
