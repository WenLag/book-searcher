import java.util.ArrayList;

public class Ebook extends Media {
	public Ebook(String Title,String Year, String Genre,String ISBN,long Rating,String Pulisher,String Author,long numberOfCopy,
			boolean isNewArrive,long Maxrent,ArrayList<String> commentlist, String type)
	{
		super(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
		this.setMaxrent();
	}
	public Ebook()
	{
		super();
		this.setMaxrent();
	}
	public String toString()
	{

		return "title:"+this.Title+"\nyear:"+this.Year+"\ngenre:"+this.Genre+"\nrating:"+this.Rating+this.Genre+"\nISBN:"+this.ISBN
				+"\npublisher:"+this.Publisher+"\nauthor:"+this.Author+"\nnumber of copy:"+this.numberOfCopy
				+"\nis new arrvial:"+this.isNewArrive();
	}
	public void setMaxrent()
	{
		this.Maxrent = 14;
	}
	public long getMaxrent()
	{
		return this.Maxrent;
	}

}
