package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	BorrowingBookResult bbr = new BorrowingBookResult(true, "");
	final int BOOK_LIMIT = 3;
	
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		// Here you can implement logic to check if the book is available to
		// borrow and if the member can borrow it
		//(e.g., item limit, member status).
		
		System.out.println("Borrowing book: " + book);
		
		if (member.borrowedBooksCount() < BOOK_LIMIT && !member.getBorrowedBooks().contains(book) && book.getIsAvailable() == true) {
			
			member.getBorrowedBooks().add(book);
			book.setIsAvailable(false);
			bbr.setIsSuccess(true);
			bbr.setMessage("Success");
		}
		else if(member.getBorrowedBooks().contains(book)) {
			bbr.setIsSuccess(false);
			bbr.setMessage("the book is already borrowed by the same member.");
		}
		else if(member.borrowedBooksCount() == BOOK_LIMIT) {
			bbr.setIsSuccess(false);
			bbr.setMessage("the member has exceeded their borrowing limit.");
		}
		else if(book.getIsAvailable() == false) {
			bbr.setIsSuccess(false);
			bbr.setMessage("the book is already borrowed by another member.");
		} else {
			bbr.setIsSuccess(false);
			bbr.setMessage("unkown cause.");			
		}
	
		return bbr;
	}
	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		// Implement logic to handle returning a book
		System.out.println("Returning book: " + book);
		
		if (member.getBorrowedBooks().contains(book) && book.getIsAvailable() == false) {
			member.getBorrowedBooks().remove(book);
			book.setIsAvailable(true);
			bbr.setIsSuccess(true);
			bbr.setMessage("Successfully returned book.");
			return bbr;
		} else if(!member.getBorrowedBooks().contains(book)){
			bbr.setIsSuccess(false);
			bbr.setMessage("the member has not borrowed this book.");
		} else if(book.getIsAvailable() == true) {
			bbr.setIsSuccess(false);
			bbr.setMessage("the book has already been returned.");		
		} else {
			bbr.setIsSuccess(false);
			bbr.setMessage("unknown cause.");
		}
		return bbr;	
		//if member doesn't have book in their list
		//if book is already returned
	}
}
