import java.util.LinkedList;
import java.util.Queue;

public class Media {

    protected String Title;
    protected String Author;
    protected String Year;
    protected String Genre;
    protected String Publisher;
    protected long numberOfCopy;
    protected String ISBN;
    protected long Rating;
    protected boolean isCheckout;
    protected boolean isNewArrive;
    protected long Maxrent;
    protected Queue<String> holdlist =new LinkedList<String>();
    public Media(String Title,String Year, String Genre,String ISBN,String Pulisher,String Author,long numberOfCopy,boolean isNewArrive, long Maxrent)
    {

        this.setISBN(ISBN);
        this.setName(Title);
        this.setAuthor(Author);
        this.setNumberOfCopy(numberOfCopy);
        this.setYear(Year);
        this.setGenre(Genre);
        this.setisNewArrive(isNewArrive);
        this.setMaxrent(Maxrent);
        
    }

	public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public long getNumberOfCopy() {
        return this.numberOfCopy;
    }

    public void setNumberOfCopy(long NumberOfCopy) {
        this.numberOfCopy = NumberOfCopy;
            
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN=ISBN;
    }


    public String getName() {
        return Title;
    }

    public void setName(String Title) {
        this.Title = Title;
    }


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {

        this.Year = Year;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre=Genre;
    }

    public long getRating() {
        return Rating;
    }

    public void setRating(long Rating) {
        if(Rating!=0&&Rating<=5) {
            this.Rating = Rating;
        }
    }
    public boolean isCheckout(){
    	if (this.numberOfCopy == 0) {
        	this.isCheckout = true;
        } else {
        	this.isCheckout = false;
        }
        return this.isCheckout;
    }

    public void setisCheckout(boolean isCheckout)
    {
        this.isCheckout=isCheckout;
    }
    public boolean isNewArrive(){
        return isNewArrive;
    }
    public void setisNewArrive(boolean isNewArrive)
    {
        this.isNewArrive=isNewArrive;
    }
    
    public void addHoldList(String aId)
    {
    	Queue<String> Holdlist = new LinkedList<>();
    	Holdlist.add(aId);
    }
    public long getMaxrent()
    {
    	return Maxrent;
    }
    public void setMaxrent(long Maxrent)
    {
    	this.Maxrent=Maxrent;
    }
}
