import java.util.ArrayList;

public class BookItem extends Media {
	/**Load information from database*/
	public BookItem(String Title,String Year, String Genre,
			String ISBN,long Rating,String Pulisher,String Author,
			long numberOfCopy,boolean isNewArrive,long Maxrent,ArrayList<String> commentlist, String type) {
		super(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist, type);
		this.setMaxrent();
	}
	public BookItem()
	{
		super();
		this.setMaxrent();
	}
	public String toString()
	{

		return "title:"+this.Title+"\nyear:"+this.Year+"\ngenre:"+this.Genre+"\nrating:"+this.Rating+"\nGenre: " + this.Genre+"\nISBN:"+this.ISBN
				+"\npublisher:"+this.Publisher+"\nauthor:"+this.Author+"\nnumber of copy:"+this.numberOfCopy
				+"\nis new arrvial:"+this.isNewArrive() + "\nType: " + this.getType();
	}
	public void setMaxrent()
	{
		this.Maxrent = 30;
	}
	public long getMaxrent()
	{
		return this.Maxrent;
	}

}
