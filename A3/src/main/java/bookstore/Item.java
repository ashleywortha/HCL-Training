package bookstore;

public class Item {
	static int id = 0;
	int iid;
	String itemName;
	double price;
	
	public Item(String name, double iPrice) {
		iid = id;
		itemName = name;
		price = iPrice;
		id++;
	}
}

class Book extends Item{
	String author;
	int pubDate;
	
	public Book(String name, double iPrice, String aut, int pub) {
		super(name, iPrice);
		author = aut;
		pubDate = pub;
	}
	
}

class CD extends Item {
	String artist;
	int releaseDate;
	String label;

	public CD(String name, double iPrice, String art, int release, String lab) {
		super(name, iPrice);
		artist = art;
		releaseDate = release;
		label = lab;
	}
	
}

class Software extends Item {
	int verNum;
	int experation;

	public Software(String name, double iPrice, int ver, int exp) {
		super(name, iPrice);
		verNum = ver;
		experation = exp;
	}
	
}
