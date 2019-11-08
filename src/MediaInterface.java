import java.io.IOException;
import java.util.ArrayList;

public interface MediaInterface {
	/**
	 * A method search if a media exist in database if exist return the media
	 * else return null
	 * @param aMediaName type of String 
	 * @return type of Media
	 */
	
	public Media search(ArrayList<Media> aMedias, String aMediaName);
	/**
	 * Add a Media to database
	 * @param aMedia type of Media
	 * @throws IOException 
	 */
	
	public void addMediaDatabase() throws IOException;
	
	/**
	 * If the media exist in database remove and return it
	 * else return null
	 * @param aMedia type of Media
	 * @return type of Media
	 */
	
	public void removeMediaDatabase();
	
	
}
