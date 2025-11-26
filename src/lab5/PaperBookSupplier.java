package lab5;

public class PaperBookSupplier extends BookFactory{

	@Override
	public Book createBook(String title) {
		// TODO Auto-generated method stub
		return new PaperBook(title);
	}
	

}
