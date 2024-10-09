package LMS;

import java.io.BufferedWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library {

    private List<Book> booksList;
    private List<Member> membersList;
    private List<Transactions> transactionsList;
    private Map<Integer, Book> bookSearch; // No need for this since we can search only by ISBN and that is from type of String
    private Map<Integer, Member> memberSearch;
    private BufferedWriter addLog;
    private BufferedWriter removeLog;
    public int memberCounter;

    public Library() {
        booksList = new ArrayList<>();
        membersList = new ArrayList<>();
        transactionsList = new ArrayList<>();
        bookSearch = new HashMap<>(); // no need to have this
        memberSearch = new HashMap<>();


    }


    /*

    public void addMember(int memberID, String name, String email, String phoneNumber) throws IOException {
        membersList.add(new Member(memberID, name, email, phoneNumber));

/*  Note for Aseel:
 I made some small changes to the method. By creating an instance of Member class, we can directly add the
 Member object to the membersList.
 This approach is cleaner and simpler, especially when we create a Member object in Librarian class, making it
 easy to call the addMember method and pass the object.
     */


    public void addMember(Member member) throws IOException {
        membersList.add(member);
        System.out.println(memberCounter++ + ": " + member.getMemberId() + ", " + member.getName() + ", " + member.getEmail() + ", " + member.getPhoneNumber());


    }


    // The purpose of this method is, To displays all the members registered in the library.
    public void displayAllMember() {
        if (membersList.isEmpty()) {
            System.out.println("There is no any registered member in the Library ");
        } else {
            for (Member member : membersList)
                System.out.println(member.toString());
            System.out.println("****** ****** ****** ******");
        }


    }


    public void removeMember(int memberID) throws IOException {
        int counter = 0;
        // Question from Aseel: Could you please explain this method?
        membersList.remove(memberID);
        removeLog.write("\n");
        removeLog.write(counter++);
        removeLog.write("placeHolder");
        removeLog.close();
        memberCounter--;

    }

    // This searchMemberByID method is defined to return a Member object
    Member searchMemberByID(int id) {
        for (Member member : membersList) {
            if (member.getMemberId() == id) {
                return member;
            }

        }
        return null;

    }


    // *************** *************** *************** *************** *************** *************** ***************
    /*
     * The methods below belong to the Book class, created by Salma.
     * If you have any comments or suggestions, please feel free to share them.
     * As we know, essential methods for the Book class include adding a book, removing a book,
     * searching for a book, and listing all books.
     */


    /* insertBook Method
    It takes a single parameter, newBook, which is an instance of the Book class. This parameter represents the book that will be added to
    the library.
    The insertBook method efficiently adds a new Book object to the library's collection and informs the user of the successful addition
     by displaying the book's title.
     */
    public void insertBook(Book newBook) {
        booksList.add(newBook);
        System.out.println("One new book added: " + newBook.getTitle() + " by " + newBook.getAuthor() + ".");
    }


    /*
    The deleteBookByISBN method calls another method searchBookByISBN(isbn), which searches the library's book collection (booksList) for a book that
     matches the provided ISBN.
     If a matching book is found, it is assigned to the variable bookToRemove. If no book is found, bookToRemove will be null.
     */

    public void deleteBookByISBN(String isbn) {
        Book bookToRemove = searchBookByISBN(isbn);
        if (bookToRemove != null) {
            booksList.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove.getTitle() + " by " + bookToRemove.getAuthor() + ".");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }

    }

    /*
    This searchBookByISBN method is defined to return a Book object, indicating that it either returns the found book or null if no book is found.
    It takes a single parameter isbn, which is a String representing the ISBN of the book to search for.
     */
    Book searchBookByISBN(String isbn) {
                /*
        for (int i = 0; i < booksList.size(); i++) {
        Book book = booksList.get(i);
        if (book.getISBN().equals(isbn)) {
            return book;
                 */
        for (Book book : booksList) {
            if (book.getISBN().equals(isbn)) {
                return book;

            }
        }
        return null;
    }

    /*
    The displayAllBooks method is designed to display all the books in the library's collection. It checks if
    there are any books present
    and, if so, iterates through the list of books to print out their details.
     */

    public void displayAllBooks() {
        if (booksList.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : booksList) {
                System.out.println(book.toString());
                System.out.println("****** ****** ****** ******");
            }
        }
    }
}


