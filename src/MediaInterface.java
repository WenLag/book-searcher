import java.io.IOException;
import java.util.ArrayList;

public interface MediaInterface {
	/**
	 * this method can search if a media exist in Media database, if so, return the media
	 * else return null
	 */
	
	public Media search(ArrayList<Media> aMedias, String aMediaName);
	/**
	 * this method can add a Media to database
	 */
	
	public void addMediaDatabase() throws IOException;
	
	
	
}
