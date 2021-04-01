package PageObjects;

import org.openqa.selenium.By;

public class BrowseQuestionsPageObject {
	
	public static final By campoBusca = By.id("query");
	public static final By botaoBusca = By.xpath("//*[text()=' Search' and @role='button']");
	public static final By mensagemErro = By.xpath("//div[contains(@class,'alert alert-danger')]");
	public static final By campoSelecao = By.xpath("//select[contains(@id,'type')]");
	public static final By tabelaListaItens = By.xpath("//table[contains(@class,'table table-bordered')]//tr");
	public static final By controlePaginacao = By.xpath("//ul[contains(@class,'pagination pagination-lg')]");
}