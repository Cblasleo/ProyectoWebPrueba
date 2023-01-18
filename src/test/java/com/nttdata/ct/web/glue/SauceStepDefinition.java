package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.WebAutomationApplication;
import com.nttdata.ct.web.lib.WebDriverManager;
import com.nttdata.ct.web.step.SauceSearchStep;
import com.nttdata.ct.web.step.SauceSettingsStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class SauceStepDefinition {

    @Value("${url.google}")
    private String urlGoogle;
    @Value("${url.settings}")
    private String urlGoogleSettings;

    @Autowired
    private WebDriverManager manager;
    @Autowired
    private SauceSearchStep searchStep;
    @Autowired
    private SauceSettingsStep settingsStep; //demo shadowRoot
    @Given("que abro la pagina de sauce")
    public void queAbroLaPaginaDeSauce() {
        manager.navigateTo(urlGoogle);
    }

    @When("^escribo el username y el password: \"([^\"]*)\" ; \"([^\"]*)\"$")
    public void escriboElUsernameYElPassword(String user, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        searchStep.searchUserPasword(user,password);
    }
    @Given("que abro la pagina de configuracio de google")
    public void queAbroLaPaginaDeConfiguracioDeGoogle() {
        manager.navigateTo(urlGoogleSettings);
    }

    @When("escribo la busqueda de: {string}")
    public void escriboLaBusquedaDe(String busqueda) {
        searchStep.searchData(busqueda);
    }

    @Then("valido que los resultados sean mayores a {int}")
    public void validoQueLosResultadosSeanMayoresA(int count) {
        searchStep.validateResults(count);
    }

    @When("busco la opcion {string}")
    public void buscoLaOpcion(String option) {
        settingsStep.searchSettings(option);
    }

    @Then("valido que el resultado sea {string}")
    public void validoQueElResultadoSea(String result) {
        settingsStep.validateValueResult(result);
    }
}