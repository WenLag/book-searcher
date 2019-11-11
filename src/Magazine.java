import java.util.ArrayList;

public class Magazine extends Media {
	public Magazine(String Title,String Year, String Genre,String ISBN,long Rating,
			String Pulisher,String Author,long numberOfCopy,boolean isNewArrive,
			long Maxrent,ArrayList<String> commentlist, String type){
		super(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
		this.setMaxrent();
		
	}
	public Magazine()
	{
		super();
		this.setMaxrent();
	}
	public String toString()
	{

		return "title:"+this.Title+"year:"+this.Year+"genre:"+this.Genre+"rating:"+this.Rating+this.Genre+"ISBN:"+this.ISBN
				+"publisher:"+this.Publisher+"author:"+this.Author+"number of copy:"+this.numberOfCopy
				+"is new arrvial:"+this.isNewArrive();
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
