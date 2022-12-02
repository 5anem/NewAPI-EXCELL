package APO;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigurationReaders;
import utils.ExcelUtils;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static utils.ExcelUtils.getCellData;

public class TRY {

    public static void main(String[] args) throws Exception {
        RestAssured.baseURI = "http://localhost:3000";

        String response = given().queryParam("id", "10003").header("Content-Type", "application/json").
                when().get("users/10003").then().extract().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String country = js.getString("country");
        System.out.println(country);
       // ExcelUtils.setExcelFile(ConfigurationReaders.getProperty("path"));
     //   String bodyR = ExcelUtils.getCellData(1, 0, "sheet1");


      //  RequestSpecification req = given().header("Content-Type", "application/json").body(bodyR);
    //    Response res = req.post("users");

        RequestSpecification reqGet = given().header("Content-Type", "application/json");
        Response resGet=reqGet.get("users/iKxKnrT");
        String bodyRidvanGet= resGet.getBody().asString();


        System.out.println(bodyRidvanGet);
        ExcelUtils.add_Value_InSpecifiedCell__FromExcel(ConfigurationReaders.getProperty("path"), "Sheet1",1,1,bodyRidvanGet);
    }
}
