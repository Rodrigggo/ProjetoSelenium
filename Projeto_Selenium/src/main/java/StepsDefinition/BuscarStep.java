package StepsDefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import Actions.RealizarBuscaActions;
import Reports.Report;
import Utils.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class BuscarStep {

	Report report;
	RealizarBuscaActions realizarConsultaVagasActions;
	ChromeDriver driver;

	@Before("@StartScenarios")
	public void before() {
		System.out.println("Iniciando a execução dos cenarios ...");
		WebDriverManager webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		report = new Report();
		realizarConsultaVagasActions = new RealizarBuscaActions(driver, report);
	}

	@After("@FinishScenarios")
	public void tearDown() throws Exception {
		System.out.println("Finalizando a execução dos cenarios ...\n");
		report.createReportDoc();
		driver.close();
	}

	@Given("^I navigate to the question bank search page$")
	public void acessar_o_site() throws InterruptedException {
		realizarConsultaVagasActions.acessaUrl("https://opentdb.com/");
		realizarConsultaVagasActions.acessaTelaBusca();
	}

	@When("^I digit \"([^\"]*)\" in the search field$")
	public void acessar_a_pagina_confira_nossas_vagas(String teste) throws InterruptedException {
		realizarConsultaVagasActions.realizarConsulta(teste);
	}

	@When("^I select \"([^\"]*)\" in the search field$")
	public void selecionoParamentroConsulta(String teste) throws InterruptedException {
		realizarConsultaVagasActions.selecionarParamentro(teste);
	}

	@When("^I check if the list of questions has 25 items$")
	public void verificoListaItens() throws InterruptedException {
		realizarConsultaVagasActions.validarListaItensTabela();
	}

	@When("^I check if paging control has been displayed$")
	public void verificoControlePaginacao() throws InterruptedException {
		realizarConsultaVagasActions.validarControlePaginacao();
	}

	@Given("^I click on the search button$")
	public void clicoBotaoBusca() throws InterruptedException {
		realizarConsultaVagasActions.clicoBotaoBusca();
	}

	@Given("^I see an error message with the text \"([^\"]*)\"$")
	public void validoMensagemErro(String mensagem) throws InterruptedException {
		realizarConsultaVagasActions.validarMensagemErro(mensagem);
	}

}
