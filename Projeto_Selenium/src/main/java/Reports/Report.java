package Reports;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;


public class Report {

	WebDriver driver;
	String pathPrint = ConstantsReport.PRINTS_PATH;
	ArrayList<String> prints;
	ArrayList<String> texts;
	/**
	 * Construtor da classe Report
	 * @param Webdriver driver
	 * @author rodrigo.c.almeida
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Report() {
		this.prints = new ArrayList();
		this.texts = new ArrayList();
	}

	/**
	 * Método para capturar prints que serão utilizados nos relatórios DOC e PDF.
	 * @return void
	 * @author Rodrigo.c.almeida
	 * @return 
	 * @return 
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws BadElementException 
	 */
	public  String capturar()  {
		String namePrint = "print";
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		
		  Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		    try {
				boolean scrFile2 = ImageIO.write(screenShot, "JPG", new File(pathPrint + namePrint + "_" + dateFormat.format(date) + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		prints.add(pathPrint + namePrint + "_" + dateFormat.format(date) + ".jpg");		
		String nomeImagem = pathPrint + namePrint + "_" + dateFormat.format(date) + ".jpg";
				
		return nomeImagem;
	}
	
	public  void capturarText(String txt) {

		texts.add(txt);

	}
	/**
	 * Método para gerar o relatório DOC..
	 * @return void
	 * @author rodrigo.c.almeida
	 */
	public void createReportDoc() throws Exception {
		@SuppressWarnings("unused")
		Doc report = new Doc(prints,texts);
	}

}