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
    private static final String MEDIA_FILE_NAME="books.json";
    public ArrayList<Media> parserMedia(String wantedTitle){
        ArrayList<Media> media = new ArrayList<Media>();
        try
        {
            FileReader reader=new FileReader(MEDIA_FILE_NAME);
            JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray mediaJSON = (JSONArray)jsonData.get("books");
			for(int i=0; i < mediaJSON.size(); i++) {
				JSONObject booksJSON = (JSONObject)mediaJSON.get(i);
				long id = (long)booksJSON.get("id");
				String title = (String)booksJSON.get("title");
				String year= (String)booksJSON.get("year");
				String genre=(String)booksJSON.get("genre");
				String Isbn= (String)booksJSON.get("ISBN");
				String publisher = (String)booksJSON.get("publisher");
				String author=(String)booksJSON.get("author");
				long numOfcopies=(long)booksJSON.get("numCopies");
				boolean isNewArrival = (boolean)booksJSON.get("newArrival");
				media.add(new Media(id,title,year,genre,Isbn,publisher,author,numOfcopies,isNewArrival));
				
			}
        }
    


        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        for (int j = 0; j < media.size(); j++) {
			if (media.get(j).getName().equalsIgnoreCase(wantedTitle)) {
				System.out.println("Title: " + wantedTitle + "\nNumber of copies Available: " + media.get(j).getNumberOfCopy());
				
				
			}
		}
        
        return media;
    }
}
