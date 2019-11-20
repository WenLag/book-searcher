import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MediaTesting {

	@Test
	void test() {
		JSONTesting();
		get_set_Test();
		test_printoutInfo();
		test_addHoldlist();
		test_addComment();
		
	}
	public void JSONTesting()
	{
		boolean result;
		MediaParser Mp = new MediaParser();
		ArrayList<Media> Medias = Mp.parserMedia();
		if(Medias == null) {
			result = false;
		} else {
			result = true;
		}
		assertEquals(true,result);
	}
	
	public void get_set_Test() {
		LoadMediaDatabase Lmd = new LoadMediaDatabase();
		ArrayList<String> comment = null;
		Media media = Lmd.Load("AA","1231", "science","A111",4,"CNB","mark",
				5,false,14,comment, "magazine");
		String title= media.getName();
		String year=media.getYear();
		String genre=media.getGenre();
		String ISBN=media.getISBN();
		long rating=media.getRating();
		String publisher=media.getPublisher();
		String author=media.getAuthor();
		long maxrent = media.getMaxrent();
		String type= media.getType();
		long numberofCopy=media.getNumberOfCopy();
		ArrayList<String> commentlist = media.getCommitlist();		
		assertEquals("AA", title);
		assertEquals("1231", year);
		assertEquals( "science", genre);
		assertEquals("A111", ISBN);
		assertEquals("CNB", publisher);
		assertEquals("mark",author);
		assertEquals(5, numberofCopy);
		assertEquals(14, maxrent);
		assertEquals(4,rating);
		assertEquals("magazine",type);
		media.setName("BB");
		media.setAuthor("Lisa");
		media.setYear("1234");
		media.setGenre("child");
		media.setISBN("sss444");
		media.setPublisher("CcM");
		media.setRating(5);
		media.setMaxrent(30);
		media.setNumberOfCopy(6);
		media.setType("ebook");
		assertEquals("BB", media.getName());
		assertEquals("1234", media.getYear());
		assertEquals( "child", media.getGenre());
		assertEquals("sss444", media.getISBN());
		assertEquals("CcM", media.getPublisher());
		assertEquals("Lisa",media.getAuthor());
		assertEquals(6, media.getNumberOfCopy());
		assertEquals(30, media.getMaxrent());
		assertEquals(5,media.getRating());
		assertEquals("ebook",media.getType());
		media.setType("book");
		assertEquals("book",media.getType());
		media.setType("ebook");
		assertEquals("ebook", media.getType());

	
	}
		public void test_printoutInfo()
		{
			LoadMediaDatabase Lmd = new LoadMediaDatabase();
			ArrayList<String> comment=null;
			Media media = Lmd.Load("AA","1231", "science","A111",4,"CNB","mark",
					5,false,14,comment, "magazine");
			media.printoutInfo();
		}
		public void test_addHoldlist()
		{
			LoadMediaDatabase Lmd = new LoadMediaDatabase();
			ArrayList<String> comment=null;
			Media media = Lmd.Load("AA","1231", "science","A111",4,"CNB","mark",
					5,false,14,comment, "magazine");
			media.addHoldList("aacc");
					
		}
		public void test_addComment()
		{
			LoadMediaDatabase Lmd = new LoadMediaDatabase();
			Media media = Lmd.Load("AA","1231", "science","A111",4,"CNB","mark",
					5,false,14,new ArrayList<String>(), "magazine");
			media.addComment();
		}
		
}

