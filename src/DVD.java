import java.util.ArrayList;

public class DVD extends Media{
	/**load data from media database*/
	public DVD(String Title,String Year, String Genre,String ISBN,long Rating,
			String Pulisher,String Author,
			long numberOfCopy,boolean isNewArrive,long Maxrent,ArrayList<String> commentlist, String type) {
		super(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);

	}
	public DVD()
	{
		super();
	}

	/**printing out*/
	public String toString()
	{
		return "title:"+this.Title+"year:"+this.Year+"genre:"+this.Genre+"rating:"+this.Rating+this.Genre+"ISBN:"+this.ISBN
		+"publisher:"+this.Publisher+"author:"+this.Author+"number of copy:"+this.numberOfCopy
		+"is new arrvial:"+this.isNewArrive();
	}
	public void setMaxrent(long Maxrent)
	{
		
	}
	public long getMaxrent()
	{
	return this.Maxrent;
	}
	}
