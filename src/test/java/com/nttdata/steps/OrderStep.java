package com.nttdata.steps;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class OrderStep {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    Response response;

    public void createOrder(String id, String petId, String quantity, String shipDate, String status, String complete){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\":\""+complete+"\"}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
        ;
    }

    public void definirUrl(String url){

    }
    public void validarType(DataTable dataTable) {
        Map<String, String> expectedValues = dataTable.asMap(String.class, String.class);
        System.out.println("Valores esperados: " + expectedValues);
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

}
