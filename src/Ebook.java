
public class Ebook extends Media {
	public Ebook(String Title,String Year, String Genre,String ISBN,String Pulisher,String Author,long numberOfCopy,
			boolean isNewArrive,long Maxrent) 
	{
		super(Title,Year,Genre,ISBN,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent);
			
	}
	public void setMaxrent(long Maxrent)
	{
		this.Maxrent = 14;
	}
	
}
