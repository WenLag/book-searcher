
public class BookItem extends Media {
	public BookItem(String Title,String Year, String Genre,String ISBN,String Pulisher,String Author,
			long numberOfCopy,boolean isNewArrive,long Maxrent) {
		super(Title,Year,Genre,ISBN,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent);
			
	}
	public void setMaxrent(long Maxrent)
	{
		this.Maxrent = 30;
	}
	
}
