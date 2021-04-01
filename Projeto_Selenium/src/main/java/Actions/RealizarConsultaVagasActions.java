package Actions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.BrowseQuestionsPageObject;
import PageObjects.HomePageObject;
import Reports.Report;
import Utils.SeleniumUtils;

public class RealizarConsultaVagasActions extends SeleniumUtils {

	ChromeDriver driver;
	Report report;
	SeleniumUtils seleniumUtils;
	int CONT_TABELA_ESPERADO = 26;

	/**
	 * - Construtor da Class.
	 */
	public RealizarConsultaVagasActions(ChromeDriver driver, Report report) {
		this.driver = driver;
		this.report = report;
	}

	public void acessaUrl(String site) throws InterruptedException {
		openURL(driver, site);
		report.capturarText("Site acessado com sucesso");
		report.capturar();
	}

	public void acessaTelaBusca() throws InterruptedException {

		click(driver, HomePageObject.pagina_busca, 20);
		report.capturarText("Acessando a pagina de busca");
		report.capturar();

	}

	public void realizarConsulta(String campoBusca) throws InterruptedException {
		sendKeys(driver, BrowseQuestionsPageObject.campoBusca, 20, campoBusca);
		report.capturarText("Buscar com o valor " + campoBusca + " ");
		report.capturar();
	}

	public void selecionarParamentro(String campoBusca) throws InterruptedException {
		selectElementVisibleText(driver, BrowseQuestionsPageObject.campoSelecao, campoBusca);
		report.capturarText("Selecionar o valor " + campoBusca + " ");
		report.capturar();
	}

	public void validarListaItensTabela() throws InterruptedException {
		int rowCount = driver.findElements(BrowseQuestionsPageObject.tabelaListaItens).size();

		if (rowCount == CONT_TABELA_ESPERADO) {
			report.capturarText("Listagens dos itens validado com sucesso");
			report.capturar();
		} else {
			Assert.fail("Inconsistência na listagens dos itens");
			report.capturarText("Inconsistência na listagens dos itens");
			report.capturar();
		}
	}

	public void clicoBotaoBusca() throws InterruptedException {
		click(driver, BrowseQuestionsPageObject.botaoBusca, 20);
	}

	public void validarControlePaginacao() throws InterruptedException {
		mover(driver, BrowseQuestionsPageObject.controlePaginacao);

		if (mover(driver, BrowseQuestionsPageObject.controlePaginacao).equals(null)) {
			Assert.fail("Controle de paginacao não exibido");
			report.capturarText("Controle de paginacao não exibido");
			report.capturar();
		} else {
			report.capturarText("Controle de paginacao exibido com sucesso");
			report.capturar();
		}
	}

	public void validarMensagemErro(String mensagem) throws InterruptedException {
		if (getText(driver, BrowseQuestionsPageObject.mensagemErro, 20).equals(mensagem)) {
			report.capturarText("Mensagem de erro exibida comm sucesso");
			report.capturar();
		} else {
			Assert.fail("Inconsistência na mensagem de erro");
			report.capturarText("Inconsistência na mensagem de erro");
			report.capturar();
		}
	}

}
