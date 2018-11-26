package AppleProject.TestingProject;




import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {

	public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }
	public static Response getResponse() {
		RequestSpecification httpRequest = RestAssured.given();
		Response r = httpRequest.get();
        return r;
    }
	
}