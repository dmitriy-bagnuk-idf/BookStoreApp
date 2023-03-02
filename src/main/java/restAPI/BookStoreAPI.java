package restAPI;

import lombok.extern.log4j.Log4j;
import io.restassured.response.Response;
import pageObjects.baseObjects.BasePage;
import restAPI.entity.request.RegisterRequest;
import restAPI.entity.response.RegisterResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static propertyHelper.PropertyReader.getProperties;

@Log4j
public class BookStoreAPI {
    Properties properties = getProperties();
    Random random = new Random();
    List<String> bookTitlesFromAPI = new ArrayList<>();
    private final String apiURI = properties.getProperty("apiURI");
    private final RegisterRequest registerRequest = new RegisterRequest() {{
        setUserName(properties.getProperty("notFullUserName") + random.nextInt(10000));
        setPassword(properties.getProperty("password"));
    }};

    public String newUserRegistration() {
        log.debug("New user registration");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(registerRequest).post(apiURI + "Account/v1/User");
        response.then().assertThat().statusCode(201);
        RegisterResponse registerResponse = response.as(RegisterResponse.class);
        return registerResponse.getUsername();
    }

    public List<String> getListOfBookTitlesFromAPI() {
        log.debug("Get list of book titles from API");
        Response response = given()
                .get(apiURI + "BookStore/v1/Books");
        response
                .then()
                .assertThat()
                .statusCode(200);
        return bookTitlesFromAPI = response
                .jsonPath()
                .getList("books.title");
    }
}
