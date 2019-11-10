import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Media {

	protected String Type;
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
    protected ArrayList<String> commentlist = new ArrayList<String>();
    public ArrayList<String> getCommitlist() {
		return commentlist;
	}

	public void setCommitlist(ArrayList<String> commitlist) {
		this.commentlist = commitlist;
	}

    public Media(String Title,String Year, String Genre,long Rating,String ISBN,String Pulisher,
    		String Author,long numberOfCopy,boolean isNewArrive, long Maxrent,ArrayList<String> commentlist, String type)
    {
    	this.setPublisher(Pulisher);
        this.setISBN(ISBN);
        this.setName(Title);
        this.setAuthor(Author);
        this.setRating(Rating);
        this.setNumberOfCopy(numberOfCopy);
        this.setYear(Year);
        this.setGenre(Genre);
        this.setisNewArrive(isNewArrive);
        this.setMaxrent(Maxrent);
        this.setCommitlist(commentlist);
        this.setType(type);
    }
    
    public String getType() {
    	return Type;
    }
    
    public String setType(String type) {
    	return this.Type = type;
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
    public void addComment()
    {
    	this.sort(this.commentlist);
	    for(int i = 0, j = 0; i < this.commentlist.size() && j < 3;i+=2, j++)
	    {
	    System.out.printf("Rating: %s\tComment: %s\n",this.commentlist.get(i),this.commentlist.get(i+1));
	    }
        Scanner input= new Scanner(System.in);
        System.out.println("enter some comments");
        String cmt= input.nextLine();
        System.out.println("What would you rate this book?");
        String rating = input.nextLine();
        this.getRating();
        this.commentlist.add(rating);
        this.commentlist.add(cmt);
        this.setRating(this.averageRating());
        
    }
    
    public long averageRating() {
	    int temp = 0;
		for(int i = 0; i < this.commentlist.size(); i+=2) {
			try {
			temp += Integer.parseInt(this.commentlist.get(i));
			}catch(NumberFormatException e){}
		}
			if(this.commentlist.size() == 0)
				return 0;
			return (long)(temp/(this.commentlist.size()/2));
		}
		    
		private void sort(ArrayList<String> aList) {
		String[] temp = new String[2];
		for(int i = 0; i < aList.size(); i+=2) {
			for(int j = i; j < aList.size(); j+=2) {
				try {
				if(Integer.parseInt(aList.get(i)) < Integer.parseInt(aList.get(j)))
				{
					temp[0] = aList.get(i);
					temp[1] = aList.get(i+1);
					
					aList.set(i, aList.get(j));
					aList.set(i+1, aList.get(j+1));
					
					aList.set(j, temp[0]);
					aList.set(j+1, temp[1]);
				}
				}catch (NumberFormatException e) {}
		}
	
		}
	}
}
