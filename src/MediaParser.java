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
				String title = (String)booksJSON.get("title");
				String year= (String)booksJSON.get("year");
				String genre=(String)booksJSON.get("genre");
				String Isbn= (String)booksJSON.get("ISBN");
				String publisher = (String)booksJSON.get("publisher");
				String author=(String)booksJSON.get("author");
				long numOfcopies=(long)booksJSON.get("numCopies");
				boolean isNewArrival = (boolean)booksJSON.get("newArrival");
				long Maxrent=(long)booksJSON.get("Maxrent");
				media.add(new Media(title,year,genre,Isbn,publisher,author,numOfcopies,isNewArrival,Maxrent));
				
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
		boolean found = false;
		MediaParser Mp = new MediaParser();
		ArrayList<Media> searchbook= Mp.parserMedia();
		for(int i=0;i < searchbook.size();i++)
		{
			String title1 = searchbook.get(i).getName();
			media = searchbook.get(i);
			if (title1.equalsIgnoreCase(aMediaName)) {
				System.out.println("Title: "+ title1 + "\nNumber of copies: " + searchbook.get(i).getNumberOfCopy());
				found = true;
			}
			if (i == searchbook.size()-1 && found == false) {
				System.out.println("No book of this title");
			}
				
				
		}
		return media;
		
	}
	@Override
	public void addMediaDatabase() { 
		MediaParser Mp=new MediaParser();
		Scanner input= new Scanner(System.in);
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
		System.out.println("maxrent day");
		long Maxrent=input.nextLong();
		input.nextLine();
		ArrayList<Media> media = Mp.parserMedia();
		JSONObject Media = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONObject Media1 = new JSONObject();
		Media1.put("title",title);
		Media1.put("genre",genre);
		Media1.put("ISBN",ISBN);
		Media1.put("publisher",publisher);
		Media1.put("author", author);
		Media1.put("numbCopies",numbCopies);
		Media1.put("newArrival", newArrivel);
		Media1.put("Maxrent",Maxrent);
	    arr.add(Media1);
		for (int i = 0; i < media.size(); i++) {
			Media.put("title",media.get(i).getName());
			Media.put("genre", media.get(i).getGenre());
			Media.put("ISBN", media.get(i).getISBN());
			Media.put("publisher",media.get(i).getPublisher());
			Media.put("author",media.get(i).getAuthor());
			Media.put("numbCopies",media.get(i).getNumberOfCopy());
			Media.put("newArrival",media.get(i).isNewArrive());
			Media.put("Maxrent",media.get(i).getMaxrent());
			arr.add(Media);
		  }
			
		
	}
	@Override
	public void removeMediaDatabase() {
		Media media = null;
		MediaParser Mp= new MediaParser();
		Scanner input = new Scanner(System.in);
		System.out.println("Input title of book you wann to delect");
		String title =input.nextLine();
		ArrayList<Media> searchbook= Mp.parserMedia();
		for(int i=0;i < searchbook.size();i++)
		{
			String title1 = searchbook.get(i).getName();
			media= searchbook.get(i);
			if(title1.equalsIgnoreCase(title))
			{
				searchbook.remove(title);
			}
		}
		
	}
}
