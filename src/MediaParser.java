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
import java.util.*;
public class MediaParser implements MediaInterface {
    private static final String MEDIA_FILE_NAME="books.json";
    public ArrayList<Media> parserMedia(){
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
				long Maxrent =(long)booksJSON.get("Maxrent");
				media.add(new Media(id,title,year,genre,Isbn,publisher,author,numOfcopies,isNewArrival,Maxrent));
				
			}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
        return media;
    }
	@Override
	public Media search(String aMediaName) {
		Media media = null;
		MediaParser Mp = new MediaParser();
		ArrayList<Media> searchbook= Mp.parserMedia();
		for(int i=0;i < searchbook.size();i++)
		{
			String title1 = searchbook.get(i).getName();
			media = searchbook.get(i);
			if (title1.equalsIgnoreCase(aMediaName)) {
				System.out.println("Title: "+ title1 + "\nNumber of copies: " + searchbook.get(i).getNumberOfCopy());
				}
		}
		return media;
		
	}
	@Override
	public void addMediaDatabase(Media aMeida) {
		MediaParser Mp= new MediaParser();
		Scanner input= new Scanner(System.in);
		System.out.println("Input the id you want to add into database");
		String ID= input.nextLine();
		System.out.println("Input the tilte ");
		String title=input.nextLine();
		System.out.println("Input the genre ");
		String genre=input.nextLine();
		System.out.println("Input the ISBN ");
		String ISBN=input.nextLine();
		System.out.println("Input the Publisher ");
		String publisher=input.nextLine();
		System.out.println("Input the author ");
		String author=input.nextLine();
		System.out.println("Input the numbCopies ");
		int numbCopies=input.nextInt();
		System.out.println("Is that newArrivel?");
		boolean newArrivel=input.nextBoolean();
		//TODO
		
		
	}
	@Override
	public Media removeMediaDatabase(Media aMedia) {
		// TODO Auto-generated method stub
		return null;
	}
}
