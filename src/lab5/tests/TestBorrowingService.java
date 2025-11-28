package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.BorrowingBookResult;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;

class TestBorrowingService {

	Member member1;
	Member member2;
	
	PaperBook book1 = new PaperBook("Dune");
	PaperBook book2 = new PaperBook("1984");
	PaperBook book3 = new PaperBook("Book 3");
	PaperBook book4 = new PaperBook("Book 4");
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
		book3.setIsAvailable(true);
		book4.setIsAvailable(true);
	}
	@Test
	void borrowBookBook() {
		
		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(book2.getIsAvailable(),"Book must be available");
		member1.borrowBook(book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book count should be 2");
		
		// already-borrowed book
		member1.borrowBook(book2);
		assertEquals(member1.borrowedBooksCount(), 2, "The book count should still be 2.");
		
		// exceed 3-book limit
		member1.borrowBook(book3);
		member1.borrowBook(book4);
		assertEquals(member1.borrowedBooksCount(), 3, "The book count should still be 3");
		assertTrue(book4.getIsAvailable(), "Book should still be available");
		
		member2.borrowBook(book2);
		assertEquals(member2.borrowedBooksCount(), 0, "The count should still be 0 because book was already borrowed");
	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		assertEquals(member1.borrowedBooksCount(),2, "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
		
		// return first book
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
		// return second book
		member1.returnBook(book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		
		// catch trying to return already-returned book
//		BorrowingBookResult bbr = new BorrowingBookResult(false, "the book has already been returned.");
//		BorrowingService bs2 = new BorrowingService();
//		BorrowingBookResult test = bs2.returnBook(member1, book1);
//		assertEquals(bbr.getMessage(), test.getMessage(), "the book has already been returned");
		
		// catch unborrowed book
		BorrowingBookResult bbr1 = new BorrowingBookResult(false, "the member has not borrowed this book.");
		BorrowingService bs = new BorrowingService();
		BorrowingBookResult bbr2 = bs.returnBook(member2, book3);
		assertEquals(bbr1.getMessage(), bbr2.getMessage(), "Member has not borrowed this book");
	}

}
