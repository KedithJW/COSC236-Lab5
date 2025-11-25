package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    // Use interface instead of concrete class
    private ArrayList<Book> catalog = new ArrayList<>();  
    private ArrayList<Member> members = new ArrayList<>();

    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    // Return type becomes Book (interface)
    public Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    // Accept Book instead of PaperBook
    public void addBook(Book book) {
        catalog.add(book);
    }

    public void removeMember(String name) {
        Member member = findMemberByName(name);
        removeMember(member);
    }

    public void removeMember(Member member) {
        if (member != null) {
            member.returnAllBooks();
            members.remove(member);
        }
    }

    public void removeBook(String title) {
        Book book = findBookByTitle(title);
        removeBook(book);
    }

    // Accept interface
    public void removeBook(Book book) {
        if (book != null)
            catalog.remove(book);
    }

    public void showMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void showBooks() {
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    public int booksCount() {
        return catalog.size();
    }

    public int membersCount() {
        return members.size();
    }
}
