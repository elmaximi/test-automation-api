package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearGestion {

    @Steps
    OrderStep orderStep;
    
    @Given("que tengo la URL del servicio {string}")
    public void queTengoLaURLDelServicio(String url) {
        orderStep.definirUrl(url);
    }

    @When("realizo una solicitud POST para crear una orden con los datos {string}, {string}, {string}, {string}, {string}, {string}")
    public void realizoUnaSolicitudPOSTParaCrearUnaOrdenConLosDatos(String id, String petId, String quantity, String shipDate, String status, String complete) {
        orderStep.createOrder(id, petId, quantity,shipDate,status,complete);
    }

    @Then("el código de respuesta debe ser {int}")
    public void elCódigoDeRespuestaDebeSer(int statusCode) {
        orderStep.validarCodigoRespuesta(statusCode);
    }

    @And("la respuesta debe contener:")
    public void laRespuestaDebeContener(DataTable type) {
        orderStep.validarType(type);
    }
}
