import java.util.ArrayList;

public class LoadMediaDatabase {

	public Media Load(String Title,String Year, String Genre,String ISBN,long Rating,String Pulisher,String Author,
			long numberOfCopy,boolean isNewArrive,long Maxrent,ArrayList<String> commentlist, String type
			) {
		Media media = new BookItem(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
		switch (type) {
		case "magazine":
			media = new Magazine(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
			break;
		case "ebook":
			media = new Ebook(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
			break;
		case "book":
			media = new BookItem(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
			break;
		case "dvd":
			media =new DVD(Title,Year,Genre,ISBN,Rating,Pulisher,Author,numberOfCopy,isNewArrive,Maxrent,commentlist,type);
			break;
		default:
			break;
		}
		return media;
	}

}
