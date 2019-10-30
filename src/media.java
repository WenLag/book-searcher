import java.util.LinkedList;
import java.util.Queue;

public class media {

    protected String Title;
    protected String Author;
    protected String Date;
    protected String Genre;
    protected int ISBN;
    protected int Rating;
    protected boolean isCheckout;
    protected Queue<String> holdlist =new LinkedList<String>();
    public media(int ISBN,String Title,String Author,String Date, String Genre,int Rating)
    {
        this.setISBN(ISBN);
        this.setName(Title);
        this.setAuthor(Author);
        this.setData(Date);
        this.setGenre(Genre);
        this.setRating(Rating);
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
        if(Genre.equalsIgnoreCase("DVD"))
        {
            this.Genre="DVD";
        }
        else if(Genre.equalsIgnoreCase("e-book"))
        {
            this.Genre="e-book";
        }
        else if(Genre.equalsIgnoreCase("magazine"))
        {
            this.Genre="magazine";
        }
        else
            this.Genre="bookItem";
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


}
