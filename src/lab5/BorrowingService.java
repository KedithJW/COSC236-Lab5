package lab5;

public class BorrowingService implements BorrowingServiceAPI{
	
	// static variable reference of the single instance
	private static BorrowingService instance;
	
	// borrow limit of 3 
	private int borrowingLimit;
	
	// constructor
	private BorrowingService() {
		borrowingLimit = 3;
	}
	
	// get singleton 
	public static synchronized BorrowingService getInstance() {
		if (instance == null) {
			instance = new BorrowingService();
		}
		return instance;
	}
	
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		if(book.getIsAvailable() && borrowingLimit > 0) {
			borrowingLimit--; //Borrow book limit decrease 
			member.getBorrowedBooks().add(book);
		return new BorrowingBookResult((boolean)true, "Book is available and borrowlimit not reached");
		}else if(!book.getIsAvailable()) {
			return new BorrowingBookResult((boolean)false, "Book is not available.");
		}else {
			return new BorrowingBookResult((boolean)false, "Boroow limit is reached. ");
		}
	}
		
	

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		if(!book.getIsAvailable() && borrowingLimit <= 3) {
			borrowingLimit++; //Return book limit increase 
			member.getBorrowedBooks().remove(book);
			return new BorrowingBookResult((boolean)true, "Book is returned.");
		}else {
			return new BorrowingBookResult((boolean)true, "Book is available and borrowlimit not reached");

		}		
	}

}
