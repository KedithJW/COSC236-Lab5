package lab5;

public class AudioBookSupplier extends BookFactory {

	@Override
	public Book createBook(String title) {
		// TODO Auto-generated method stub
		return new AudioBook(title);
	}

}
