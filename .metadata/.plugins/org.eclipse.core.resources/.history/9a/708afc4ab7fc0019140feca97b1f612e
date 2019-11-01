import java.util.LinkedList;
import java.util.Queue;

public class media {

    protected String Title;
    protected String Author;
    protected String Date;
    protected String Genre;
    protected String Publisher;
    protected int numberOfCopy;
    protected int ISBN;
    protected int Rating;
    protected boolean isCheckout;
    protected boolean isNewArrive;
    protected Queue<String> holdlist =new LinkedList<String>();
    public media(int ISBN,String Title,String Pulisher, int numberOfCopy,String Author,String Date, String Genre,int Rating)
    {
        this.setISBN(ISBN);
        this.setName(Title);
        this.setAuthor(Author);
        this.setData(Date);
        this.setGenre(Genre);
        this.setRating(Rating);
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
        //TODO
        this.ISBN = ISBN;
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

    public String getDate() {
        return Date;
    }

    public void setData(String Data) {
        //mm/dd/yyyy
        this.Date = Data;
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
