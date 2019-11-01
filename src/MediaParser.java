import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.ArrayList;
public class MediaParser {
    private static final String Media_File_Name="books.json";
    public ArrayList<Media> parserMedia(int ISBN,String Title){
        ArrayList<Media> media=new ArrayList<Media>();
        try
        {
            FileReader reader=new FileReader(Media_File_Name);
            JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray mediaJSON = (JSONArray)jsonData.get("books.json");
			for(int i=0; i < mediaJSON.size(); i++) {
				JSONObject booksJSON = (JSONObject)mediaJSON.get(i);
				int id = (int)booksJSON.get("id");
				String title = (String)booksJSON.get("title");
				String year= (String)booksJSON.get("year");
				String genre=(String)booksJSON.get("genre");
				int Isbn= (int)booksJSON.get("ISBN");
				String publisher = (String)booksJSON.get("publisher");
				String author=(String)booksJSON.get("author");
				int numOfcopies=(int)booksJSON.get("numCopies");
				boolean isNewArrival=(boolean)booksJSON.get("newArrival");
				media.add(new Media(id,title,year,genre,Isbn,publisher,author,numOfcopies,isNewArrival));
			} 
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
