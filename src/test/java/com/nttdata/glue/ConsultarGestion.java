package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultarGestion {

    @Steps
    OrderStep orderStep;

    @Given("que tengo la URL del servicio {string}")
    public void queTengoLaURLDelServicio(String url) {
        orderStep.definirUrl(url);
    }
    @When("realizo una solicitud GET para consultar una orden con ID {string}")
    public void realizoUnaSolicitudGETParaConsultarUnaOrdenConID(String arg0) {
    }

    @Then("el código de respuesta debe ser {string}")
    public void elCódigoDeRespuestaDebeSer(String arg0) {
        
    }

    @And("la respuesta debe contener los detalles de la orden")
    public void laRespuestaDebeContenerLosDetallesDeLaOrden() {
    }
}
