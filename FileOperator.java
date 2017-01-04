import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;

public class FileOperator {

	private String[] line;

	public ArrayList<Makale> extracted(String filePath) {
		CSVReader csvReader=null;
		ArrayList<Makale> publicationList = new ArrayList<Makale>();
		try{
			csvReader = new CSVReader(new FileReader(filePath));
			while((line=csvReader.readNext())!=null)
			{
				publicationList.add(new Makale(line[0], line[1], line[2], line[3], 
						Integer.parseInt(line[4]),null));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return publicationList;
	}

	
}
