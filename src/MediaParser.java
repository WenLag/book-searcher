import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.Reader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;
public class MediaParser implements MediaInterface {
    private static final String MEDIA_FILE_NAME="media.json";
   
    ArrayList<Media> media = new ArrayList<Media>();
    public ArrayList<Media> parserMedia(){
    	 
        try
        {

            FileReader reader=new FileReader(MEDIA_FILE_NAME);
            JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray mediaJSON = (JSONArray)jsonData.get("books");
			for(int i = 0; i < mediaJSON.size(); i++) {
				JSONObject booksJSON = (JSONObject)mediaJSON.get(i);
				String title = (String)booksJSON.get("title");
				String year= (String)booksJSON.get("year");
				String genre=(String)booksJSON.get("genre");
				String Isbn= (String)booksJSON.get("ISBN");
				long rating=(long)booksJSON.get("Rating");
				String publisher = (String)booksJSON.get("publisher");
				String author=(String)booksJSON.get("author");
				long numOfcopies=(long)booksJSON.get("numCopies");
				boolean isNewArrival = (boolean)booksJSON.get("newArrival");
				long Maxrent=(long)booksJSON.get("Maxrent");
				media.add(new Media(title,year,genre,rating,Isbn,publisher,author,numOfcopies,isNewArrival,Maxrent));
				
			}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return media;
    }
	@Override
	public Media search(ArrayList<Media> aMedias, String aMediaName) {
		Media media = null;
		boolean found = false;
		
		ArrayList<Media> searchbook = aMedias;
		System.out.println("size: "+searchbook.size());
		
		for(int i=0;i < searchbook.size();i++)
		{
			String title1 = searchbook.get(i).getName();
			
			if (aMediaName.equalsIgnoreCase(title1)) {
				System.out.println("Title: "+ title1 + "\nNumber of copies: " + searchbook.get(i).getNumberOfCopy());
				found = true;
				media = searchbook.get(i);
			}
			if (i == searchbook.size()-1 && found == false) {
				System.out.println("Did not match any media.");
				System.out.println("not found");
				return null;
			}
		}
		System.out.println("found"+media);
		return media;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addMediaDatabase() throws IOException { 
		MediaParser Mp=new MediaParser();
		boolean newArrival;
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		System.out.println("Input the tilte ");
		String title=input.nextLine();
		System.out.println("input the year");
		String year=input.nextLine();
		System.out.println("Input the genre ");
		String genre=input.nextLine();
		System.out.println("Input Rating of book");
		long rating=input.nextLong();
		System.out.println("Input the ISBN ");
		String ISBN=input.nextLine();
		System.out.println("Input the Publisher ");
		String publisher=input.nextLine();
		System.out.println("Input the author ");
		String author=input.nextLine();
		System.out.println("Input the numCopies ");
		int numCopies=input.nextInt();
		System.out.println("Is that newArrivel?");
		
		String ans =input.nextLine();
		input.nextLine();
		if (ans.equalsIgnoreCase("yes")) {
		newArrival = true;
		} else {
			newArrival = false;
		}
		System.out.println("maxrent day");
		long Maxrent=input.nextLong();
		
		ArrayList<Media> media = Mp.parserMedia();
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONObject Media1 = new JSONObject();
		Media1.put("title",title);
		Media1.put("year",year);
		Media1.put("genre",genre);
		Media1.put("ISBN",ISBN);
		Media1.put("Rating",rating);
		Media1.put("publisher",publisher);
		Media1.put("author", author);
		Media1.put("numCopies",numCopies);
		Media1.put("newArrival", newArrival);
		Media1.put("Maxrent",Maxrent);
	    arr.add(Media1);
		for (int i = 0; i < media.size(); i++) {
			JSONObject Media = new JSONObject();
			Media.put("title",media.get(i).getName());
			Media.put("year",media.get(i).getYear());
			Media.put("genre", media.get(i).getGenre());
			Media.put("ISBN", media.get(i).getISBN());
			Media.put("Rating",media.get(i).getRating());
			Media.put("publisher",media.get(i).getPublisher());
			Media.put("author",media.get(i).getAuthor());
			Media.put("numCopies",media.get(i).getNumberOfCopy());
			Media.put("newArrival",media.get(i).isNewArrive());
			Media.put("Maxrent",media.get(i).getMaxrent());
			arr.add(Media);
			obj.put("media",arr);
		  }
		
		try (FileWriter file = new FileWriter("media.json")) {
			
			  file.write(obj.toString());
			  file.close();
			
		}
			
		
	}
	@Override
	public void removeMediaDatabase() {
		Media media = null;
		MediaParser Mp= new MediaParser();
		Scanner input = new Scanner(System.in);
		System.out.println("Input title of book you wann to delete");
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
	
	public ArrayList<Media> getList(){
		return media;
	}

	
}
