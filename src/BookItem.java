import java.util.ArrayList;

public class BookItem extends Media {
	public BookItem(String Title,String Year, String Genre,String ISBN,long Rating,String Pulisher,String Author,
			long numberOfCopy,boolean isNewArrive,long Maxrent,ArrayList<String> commentlist) {
		super(Title,Year,Genre,Rating,ISBN,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist);
			
	}
	public String toString()
	{
		
		return "title:"+this.Title+"year:"+this.Year+"genre:"+this.Genre+"rating:"+this.Rating+this.Genre+"ISBN:"+this.ISBN
				+"publisher:"+this.Publisher+"author:"+this.Author+"number of copy:"+this.numberOfCopy
				+"is new arrvial:"+this.isNewArrive();
	}
	public void setMaxrent(long Maxrent)
	{
		this.Maxrent = 30;
	}
	public long getMaxrent()
	{
		return this.Maxrent;
	}
	
}
