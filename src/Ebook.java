
public class Ebook extends Media {
	public Ebook(String Title,String Year, String Genre,String ISBN,String Pulisher,String Author,long numberOfCopy,
			boolean isNewArrive,long Maxrent) 
	{
		super(Title,Year,Genre,ISBN,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent);
			
	}
	public String toString()
	{
		
		return "title:"+this.Title+"year:"+this.Year+"genre:"+this.Genre+"ISBN:"+this.ISBN
				+"publisher:"+this.Publisher+"author:"+this.Author+"number of copy:"+this.numberOfCopy
				+"is new arrvial:"+this.isNewArrive();
	}
	public void setMaxrent(long Maxrent)
	{
		this.Maxrent = 14;
	}
	public long getMaxrent()
	{
		return this.Maxrent;
	}
	
}
