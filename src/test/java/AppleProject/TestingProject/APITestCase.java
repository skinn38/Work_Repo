package AppleProject.TestingProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.response.Response;




public class APITestCase {
	private Properties prop=new Properties();
	private Response res=null;
	//private String baseURI="";
	FileInputStream fis;
	
	
	
	
	@BeforeTest
	public void setup() throws IOException
	{
		fis=new FileInputStream("D:\\software&environments\\environment\\Eclipse Workspace\\AppleProject\\src\\main\\java\\AppleProject\\TestingProject\\config.properties");
		prop.load(fis);
		//baseURI=baseURI.concat(prop.getProperty("host"));
		//System.out.println(baseURI);
		RequestMethods.setBaseURI(prop.getProperty("host"));
		res=RequestMethods.getResponse();
		   
	}
		
		
	
	@Test
	public void validateStatusCode() {
		ValidationMethods.checkStatusIs200(res);
		
	}
	@Test (dependsOnMethods= {"validateStatusCode"})
	public void validateResponseStatusAsY() {
		SoftAssert sa= new SoftAssert();
		sa.assertTrue(ValidationMethods.checkResponseStatusIsY(ValidationMethods.getResponseStatus(res)));
		sa.assertAll();
	}
	@Test
		public void displayCountryName() {
			ValidationMethods.displayResponse(ValidationMethods.getResponseStatus(res));
		}
	}
	
	


