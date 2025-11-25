package lab5;

public class BorrowingService implements BorrowingServiceAPI{

	@Override
	public boolean borrowBook(Member member, Book book) {
		member.borrowBook(book);
		return false;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		return member.returnBook(book);
		
		
	}

}
