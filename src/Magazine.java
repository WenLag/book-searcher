
public class Magazine extends Media {
	public Magazine(long Id,String Title,String Year, String Genre,String ISBN,String Pulisher,
			String Author,long numberOfCopy,boolean isNewArrive,long Maxrent) {
		super(Id,Title,Year,Genre,ISBN,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent);
			
	}
	public void setMaxrent(long Maxrent)
	{
		Maxrent = 14;
	}
	
}
