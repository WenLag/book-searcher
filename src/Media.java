import java.util.LinkedList;
import java.util.Queue;

public class Media {

    protected String Title;
    protected String Author;
    protected String Year;
    protected String Genre;
    protected String Publisher;
    protected int Id;
    protected int numberOfCopy;
    protected int ISBN;
    protected int Rating;
    protected boolean isCheckout;
    protected boolean isNewArrive;
    protected Queue<String> holdlist =new LinkedList<String>();
    public Media(int Id,String Title,String Year, String Genre,int ISBN,String Pulisher,String Author,int numberOfCopy,boolean isNewArrive)
    {
    	this.setId(Id);
        this.setISBN(ISBN);
        this.setName(Title);
        this.setAuthor(Author);
        this.setYear(Year);
        this.setGenre(Genre);
        this.setisNewArrive(isNewArrive);
    }


    public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


	public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public int getNumberOfCopy() {
        return numberOfCopy;
    }

    public void setNumberOfCopy(int NumberOfCopy) {
        if(numberOfCopy>0) {
            this.numberOfCopy = NumberOfCopy;
        }
        else
            System.out.println("We don't have this book");
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN=ISBN;
    }

<<<<<<< HEAD
=======
    public String getName() {
        return Title;
    }

    public void setName(String Title) {
        this.Title = Title;
    }
>>>>>>> parent of c71a550... jiabei-5

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
