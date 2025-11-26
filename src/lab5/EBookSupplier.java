package lab5;

public class EBookSupplier extends BookFactory {

	@Override
	public Book createBook(String title) {
		// TODO Auto-generated method stub
		return new EBook(title);
	}

}
