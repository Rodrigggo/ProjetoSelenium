package Reports;


import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.License;
import com.aspose.words.TextFormFieldType;
import com.aspose.words.WrapType;


public class Doc {

	public Doc(ArrayList<?> array,ArrayList<?> arrayText) throws Exception {
		int verticalPosition = 0;
		String dataPath = ConstantsReport.DOC_PATH;
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		Document doc = new Document(dataPath);
		DocumentBuilder builder = new DocumentBuilder(doc);
		
		for (int i = 0; i < array.size(); i++) {
			String imagePath = (String) array.get(i);
			String text = (String) arrayText.get(i);
			FileInputStream in = new FileInputStream(imagePath);
			builder.insertTextInput( "TextInput" , TextFormFieldType.REGULAR_TEXT,"","\n\n"+text,0);
			builder.insertImage(in,500,200);
			verticalPosition = verticalPosition + 400;
		}
		doc.save(dataPath + dateFormat.format(date) + ".docx");
	}
}
