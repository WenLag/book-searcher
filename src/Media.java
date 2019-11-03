import java.util.LinkedList;
import java.util.Queue;

public class Media {

    protected String Title;
    protected String Author;
    protected String Year;
    protected String Genre;
    protected String Publisher;
    protected long Id;
    protected long numberOfCopy;
    protected String ISBN;
    protected int Rating;
    protected boolean isCheckout;
    protected boolean isNewArrive;
    protected Queue<String> holdlist =new LinkedList<String>();
    public Media(long Id,String Title,String Year, String Genre,String ISBN,String Pulisher,String Author,long numberOfCopy,boolean isNewArrive)
    {
    	this.setId(Id);
        this.setISBN(ISBN);
        this.setName(Title);
        this.setAuthor(Author);
        this.setNumberOfCopy(numberOfCopy);
        this.setYear(Year);
        this.setGenre(Genre);
        this.setisNewArrive(isNewArrive);
    }


    public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        if(Rating!=0&&Rating<=5) {
            this.Rating = Rating;
        }
    }
    public boolean isCheckout(){
        return isCheckout;
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


}
