package TestCasesGetReqs;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPosts {
	
	@Test(testName = "Test to get all post with id 2")
	public void getPosts() {
		given().when().get("https://jsonplaceholder.typicode.com/posts/2/")
		.then().statusCode(200).assertThat().body("id", equalTo(2))
		.body("title",equalTo("qui est esse"))
		.header("Content-Type", "application/json; charset=utf-8");
	}
	
	@Test(testName = "Test to get comment made by user with id 5")
	public void getCommentsForPosts() {
		given().when().get("https://jsonplaceholder.typicode.com/comments/5")
		.then().statusCode(200).assertThat().body("id", equalTo(5)).body("postId", equalTo(1))
		.body("email",equalTo("Hayden@althea.biz"))
		.header("Content-Type", "application/json; charset=utf-8");
	}
	
	@Test(testName = "Test to fetch the details of user with id 1")
	public void getUsers() {
		given().when().get("https://jsonplaceholder.typicode.com/users/1")
		.then().statusCode(200).assertThat().body("id", equalTo(1))
		.body("name",equalTo("Leanne Graham")).body("email", equalTo("Sincere@april.biz"))
		.header("Content-Type", "application/json; charset=utf-8");
	}
	//to set the method to be executed twice if failed 
	//retryAnalyzer = com.assign.qa.base.reruntests.RetryAnalyserFTC.class
	@Test(testName = "Test to fetch photos of album id ")
	public void getPhotos() {
		given().when().get("https://jsonplaceholder.typicode.com/photos/3")
		.then().statusCode(200).assertThat().body("id", equalTo(1))
		.body("albumId",equalTo(1)).body("url", equalTo("https://via.placeholder.com/600/24f355"))
		.header("Content-Type", "application/json; charset=utf-8");
	}
	
	@Test(testName = "Authorization")
	public void validateUser() {
		given().auth().preemptive().basic("", "").when().get("").statusCode();
		given().accept(ContentType.JSON).when().get("");
	}

}
