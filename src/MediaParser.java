import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
public class MediaParser implements MediaInterface {
    private static final String MEDIA_FILE_NAME="media.json";
    ArrayList<Media> media = new ArrayList<Media>();
    LoadMediaDatabase lmd=new LoadMediaDatabase();
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
				long rating=(long)booksJSON.get("rating");
				String publisher = (String)booksJSON.get("publisher");
				String author=(String)booksJSON.get("author");
				long numOfcopies=(long)booksJSON.get("numCopies");
				boolean isNewArrival = (boolean)booksJSON.get("newArrival");
				long Maxrent=(long)booksJSON.get("Maxrent");
				String type = (String)booksJSON.get("type");
				@SuppressWarnings("unchecked")
				ArrayList<String> commentlist = (ArrayList<String>)booksJSON.get("comment");
				media.add(lmd.Load(title,year,genre,Isbn,rating,publisher,author,numOfcopies,isNewArrival,Maxrent,commentlist,type));

			}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return media;
    }
	/**
	 * this method is override
	 */
	public Media search(ArrayList<Media> aMedias, String aMediaName) {
		Media media = null;
		boolean found = false;

		ArrayList<Media> searchbook = aMedias;
		for(int i=0;i < searchbook.size();i++)  /**using loop to traverse Arraylist*/
		{
			String title1 = searchbook.get(i).getName();
			/**check if the searched name match the title that user's input
			 * if so, return it, else return null.
			 */
			if (aMediaName.equalsIgnoreCase(title1)) {
				found = true;
				media = searchbook.get(i);
			}
			if (i == searchbook.size()-1 && found == false) {
				return null;
			}
		}
		return media;

	}
	@Override
	/**
	 * This method allows librarian to write information of books into database.
	 */
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
		input.nextLine();
		System.out.println("Input the ISBN ");
		String ISBN=input.nextLine();
		input.nextLine();
		System.out.println("Input the Publisher ");
		String publisher=input.nextLine();
		System.out.println("Input the author ");
		String author=input.nextLine();
		System.out.println("Input the numCopies ");
		int numCopies=input.nextInt();
		System.out.println("Is that newArrivel?");
		String ans =input.nextLine();
		String comments = "";
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
		Media1.put("comment", new String[] {comments});
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
			Media.put("comment",media.get(i).getCommitlist());
			arr.add(Media);
			obj.put("media",arr);
		  }

		try (FileWriter file = new FileWriter("media.json")) {

			  file.write(obj.toString());
			  file.close();

		}
	}


	public ArrayList<Media> getList(){
		return media;
	}

	/**
	 *input book information 
	 */
	public void input(Media aMedia) {
		MediaParser Mp=new MediaParser();
		boolean newArrival;
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		System.out.println("Input the tilte ");
		String title=input.nextLine();
		aMedia.setName(title);
		System.out.println("input the year");
		String year=input.nextLine();
		aMedia.setYear(year);
		System.out.println("Input the genre ");
		String genre=input.nextLine();
		aMedia.setGenre(genre);
		System.out.println("Input Rating of book");
		long rating=input.nextLong();
		aMedia.setRating(rating);
		input.nextLine();
		System.out.println("Input the ISBN ");
		String ISBN=input.nextLine();
		aMedia.setISBN(ISBN);
		System.out.println("Input the Publisher ");
		String publisher=input.nextLine();
		aMedia.setPublisher(publisher);
		System.out.println("Input the author ");
		String author=input.nextLine();
		aMedia.setAuthor(author);
		System.out.println("Input the numCopies ");
		int numCopies=input.nextInt();
		aMedia.setNumberOfCopy(numCopies);
		System.out.println("Is that newArrivel?");
		boolean ans =input.nextBoolean();
		aMedia.setisNewArrive(ans);

	}


}
