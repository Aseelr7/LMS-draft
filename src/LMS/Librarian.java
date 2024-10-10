package LMS;

public class Librarian {

    public static void main(String[] args) {
        // Creating Book Objects
        Book book1 = new Book("978-3-16-148410-0", "The Art of Computer Programming", "Donald Knuth", "Addison-Wesley", 1968);
        Book book2 = new Book("978-0-201-03801-8", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", "Addison-Wesley", 1994);
        Book book3 = new Book("978-0-262-03384-8", "Introduction to Algorithms", "Thomas H. Cormen", "MIT Press", 2009);
        Book book4 = new Book("978-0-13-110362-7", "The C Programming Language", "Brian W. Kernighan", "Prentice Hall", 1978);

        // Initializing Library
        Library library = new Library();

        // Inserting Books
        library.insertBook(book1);
        library.insertBook(book2);
        library.insertBook(book3);
        library.insertBook(book4);

        // Displaying All Books
        System.out.println("Displaying all books:");
        library.displayAllBooks();

        // Searching for a Book by ISBN
        Book foundBook = library.searchBookByISBN("978-0-262-03384-8");
        if (foundBook != null) {
            System.out.println("Found Book: " + foundBook.toString());
        } else {
            System.out.println("Book not found by ISBN.");
        }

        // Deleting a Book by ISBN
        library.deleteBookByISBN("978-0-201-03801-8");
        System.out.println("After deletion:");
        library.displayAllBooks();

        // Searching for a Book by ISBN and Author
        Book foundBookByIsbnAndAuthor = library.searchBookByISBNAndAuthor("978-3-16-148410-0", "Donald Knuth");
        if (foundBookByIsbnAndAuthor != null) {
            System.out.println("Found Book by ISBN and Author: " + foundBookByIsbnAndAuthor.toString());
        } else {
            System.out.println("Book not found by ISBN and Author.");
        }

        // Creating Member Objects
        Member member1 = new Member(1, "Tony Morphy", "tony.morphy@gmail.com", "555-1234");
        Member member2 = new Member(2, "Mark Zuckerberg", "mark.zuck@meta.com", "555-5678");
        Member member3 = new Member(3, "Jeff Bezos", "jeff.bezos@amazon.com", "555-9101");


            // Adding Members
            library.addMember(member1);
            library.addMember(member2);
            library.addMember(member3);


        // Displaying All Members
        System.out.println("Displaying all members:");
        library.displayAllMember();

        // Removing a Member
        library.removeMember(3);
        System.out.println("After removing a member:");
        library.displayAllMember();

        // Searching for a Member by ID
        Member foundMember = library.searchMemberByID(1);
        if (foundMember != null) {
            System.out.println("Found Member: " + foundMember.toString());
        } else {
            System.out.println("Member not found by ID.");
        }

        // Borrowing and Returning a Book
        member1.borrowBook(book1);
        member1.returnBook(book1);

        // Displaying Borrowed Books of a Member
        System.out.println("Displaying borrowed books for " + member1.getName() + ":");
        member1.displayBorrowedBooks();
    }
}
