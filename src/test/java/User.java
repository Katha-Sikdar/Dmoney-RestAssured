import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class User{

    public Properties props;
@BeforeTest
    public void setup() throws IOException {

        // To dynamic base url which is defined in config.properties file.
        props=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
        props.load(fs);

    }

@Test (priority = 1, enabled = true)
    public void login() throws ConfigurationException, IOException {


        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res=given().contentType("application/json")

                .body("{\n" +
                "    \"emailOrPhoneNumber\":\"salman@roadtocareer.net\",\n" +
                "    \"password\":\"1234\"\n" +
                "}")
                .when()
                .post("/user/login");
        //System.out.println(res.asString());

    //Token Storage in config.properties file
        JsonPath jsonPath=res.jsonPath();
        String token = jsonPath.get("token").toString();
        Utils.setEnvVariable("token", token);
    }
    @Test(priority = 2)

    public void createUser() throws ConfigurationException, IOException {

        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res=given().contentType("application/json")
                .header("Authorization",props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY","ROADTOSDET")

                .body("{\n" +
                        "    \"name\":\"Customer 1\",\n" +
                        "    \"email\":\"c1@test.com\",\n" +
                        "    \"password\":\"12345\",\n" +
                        "    \"phone_number\":\"01689064321\",\n" +
                        "    \"nid\":\"12345678\",\n" +
                        "    \"role\":\"Customer\"\n" +
                        "}")

                .when()
                .post("/user/create");
        System.out.println(res.asString());

    }


}

