
public interface MediaInterface {
	/**
	 * A method search if a media exist in database if exist return the media
	 * else return null
	 * @param aMediaName type of String 
	 * @return type of Media
	 */
	public Media search(String aMediaName);
	
	/**
	 * Add a Media to database
	 * @param aMedia type of Media
	 */
	public void addMediaDatabase(Media aMedia);
	
	/**
	 * If the media exist in database remove and return it
	 * else return null
	 * @param aMedia type of Media
	 * @return type of Media
	 */
	public Media removeMediaDatabase(Media aMedia);
}
