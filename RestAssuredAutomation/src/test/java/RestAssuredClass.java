import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class RestAssuredClass {

	final static String geturl="http://dummy.restapiexample.com/api/v1/employee/1";
	final static String deleteurl="http://dummy.restapiexample.com/api/v1/delete/2";
	
	public static void main(String[] args) {
		getResponseBody();
		getResponseStatus();
		Response DeleteResponse =  
				(Response) given().when().get(deleteurl).then().log().all();
		int success = DeleteResponse.getStatusCode();
		Assert.assertEquals(success, "successfully deleted records");
	}
		
		public static void getResponseBody() {
			given().when().get(geturl).then().log().all();
			given().when().get(deleteurl).then().log().all();
	}

		public static void getResponseStatus(){
			int statusCode= given().when().get(geturl).getStatusCode();
			System.out.println("The response status is:" +statusCode);
			given().when().get(geturl).then().assertThat().statusCode(200);
			
			int DeleteStausCode = given().when().get(deleteurl).getStatusCode();
			System.out.println("The response status is:" +statusCode);
			given().when().get(deleteurl).then().assertThat().statusCode(200);
		}
	

		
	


	}


