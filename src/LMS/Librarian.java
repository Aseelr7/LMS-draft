package LMS;

import java.util.Scanner;

public class Librarian {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Creating Book Objects
        Book book1 = new Book("978-3-16-148410-0", "The Art of Computer Programming", "Donald Knuth", "Addison-Wesley", 1968);
        Book book2 = new Book("978-0-201-03801-8", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", "Addison-Wesley", 1994);
        Book book3 = new Book("978-0-262-03384-8", "Introduction to Algorithms", "Thomas H. Cormen", "MIT Press", 2009);
        Book book4 = new Book("978-0-13-110362-7", "The C Programming Language", "Brian W. Kernighan", "Prentice Hall", 1978);

        // Inserting Books into Library
        library.insertBook(book1);
        library.insertBook(book2);
        library.insertBook(book3);
        library.insertBook(book4);

        // Creating Member Objects
        Member member1 = new Member(1, "Tony Morphy", "tony.morphy@gmail.com", "555-1234");
        Member member2 = new Member(2, "Mark Zuckerberg", "mark.zuck@meta.com", "555-5678");
        Member member3 = new Member(3, "Jeff Bezos", "jeff.bezos@amazon.com", "555-9101");
        Member member4 = new Member(4, "Jack Martin", "jack.martin@amazon.com", "777-9101");
        Member member5 = new Member(5, "Mike Toe", "mike.toe@amazon.com", "777-9999");

        // Adding Members
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);
        library.addMember(member4);
        library.addMember(member5);


        try {

            // Menu Interface
            int choice;
            do {
                // Display menu options for user
                System.out.println("\n--- Library Management System Menu ---");
                System.out.println("1. Display All Books");
                System.out.println("2. Search for a Book by ISBN");
                System.out.println("3. Search for a Book by ISBN and Author");
                System.out.println("4. Add a Book");
                System.out.println("5. Delete a Book by ISBN");
                System.out.println("6. Display All Members");
                System.out.println("7. Search for a Member by ID");
                System.out.println("8. Add a Member");
                System.out.println("9. Remove a Member");
                System.out.println("10. Borrow a Book");
                System.out.println("11. Return a Book");
                System.out.println("12. Display Borrowed Books of a Member");
                System.out.println("13. Book history from Text File");
                System.out.println("14. Member history from Text File");
                System.out.println("15. Exit");

                System.out.print("Please enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: // Display all books
                        System.out.println("Displaying all books:");
                        library.displayAllBooksFromList();
                        break;

                    case 2: // Search for a book by ISBN
                        System.out.print("Enter ISBN to search: ");
                        String searchIsbn = scanner.nextLine();
                        Book foundBook = library.searchBookByISBN(searchIsbn);
                        if (foundBook != null) {
                            System.out.println("Found Book: " + foundBook.toString());
                        } else {
                            System.out.println("Book not found by ISBN.");
                        }
                        break;

                    case 3: // Search for a book by ISBN and Author
                        System.out.print("Enter ISBN: ");
                        String searchIsbn2 = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String searchAuthor = scanner.nextLine();
                        Book foundBookByIsbnAndAuthor = library.searchBookByISBNAndAuthor(searchIsbn2, searchAuthor);
                        if (foundBookByIsbnAndAuthor != null) {
                            System.out.println("Found Book by ISBN and Author: " + foundBookByIsbnAndAuthor.toString());
                        } else {
                            System.out.println("Book not found by ISBN and Author.");
                        }
                        break;

                    case 4: // Add a new book
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Publisher: ");
                        String publisher = scanner.nextLine();
                        System.out.print("Enter Year of Publication: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        Book newBook = new Book(isbn, title, author, publisher, year);
                        library.insertBook(newBook);
                        System.out.println("Book added successfully.");
                        break;

                    case 5: // Delete a book by ISBN
                        System.out.print("Enter ISBN to delete: ");
                        String deleteIsbn = scanner.nextLine();
                        library.deleteBookByISBN(deleteIsbn);
                        System.out.println("Book deleted successfully.");
                        break;

                    case 6: // Display all members
                        System.out.println("Displaying all members:");
                        library.displayAllMemberFromTheList();
                        break;

                    case 7: // Search for a member by ID
                        System.out.print("Enter Member ID to search: ");
                        int searchMemberId = scanner.nextInt();
                        scanner.nextLine();
                        Member foundMember = library.searchMemberByID(searchMemberId);
                        if (foundMember != null) {
                            System.out.println("Found Member: " + foundMember.toString());
                        } else {
                            System.out.println("Member not found by ID.");
                        }
                        break;

                    case 8: // Add a new member
                        System.out.print("Enter Member ID: ");
                        int memberId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Member Name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter Member Email: ");
                        String memberEmail = scanner.nextLine();
                        System.out.print("Enter Member Phone: ");
                        String memberPhone = scanner.nextLine();

                        Member newMember = new Member(memberId, memberName, memberEmail, memberPhone);
                        library.addMember(newMember);
                        System.out.println("Member added successfully.");
                        break;

                    case 9: // Remove a member
                        System.out.print("Enter Member ID to remove: ");
                        int removeMemberId = scanner.nextInt();
                        scanner.nextLine();
                        library.removeMember(removeMemberId);
                        System.out.println("Member removed successfully.");
                        break;

                    case 10: // Borrow a book
                        System.out.print("Enter Member ID: ");
                        int borrowMemberId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter ISBN of the book to borrow: ");
                        String borrowIsbn = scanner.nextLine();

                        Member borrowMember = library.searchMemberByID(borrowMemberId);
                        Book borrowBook = library.searchBookByISBN(borrowIsbn);

                        if (borrowMember != null && borrowBook != null) {
                            borrowMember.borrowBook(borrowBook);
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Invalid member ID or ISBN.");
                        }
                        break;

                    case 11: // Return a book
                        System.out.print("Enter Member ID: ");
                        int returnMemberId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter ISBN of the book to return: ");
                        String returnIsbn = scanner.nextLine();

                        Member returnMember = library.searchMemberByID(returnMemberId);
                        Book returnBook = library.searchBookByISBN(returnIsbn);

                        if (returnMember != null && returnBook != null) {
                            returnMember.returnBook(returnBook);
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Invalid member ID or ISBN.");
                        }
                        break;

                    case 12: // Display borrowed books of a member
                        System.out.print("Enter Member ID: ");
                        int displayMemberId = scanner.nextInt();
                        scanner.nextLine();

                        Member displayMember = library.searchMemberByID(displayMemberId);
                        if (displayMember != null) {
                            System.out.println("Displaying borrowed books for " + displayMember.getName() + ":");
                            displayMember.displayBorrowedBooks();
                        } else {
                            System.out.println("Member not found by ID.");
                        }
                        break;

                    case 13: // Load books from text file
                        library.displayAllBooksFromTextFile();
                        break;

                    case 14: // Load members from text file
                        library.displayAllMemberFromTextFile();
                        break;

                    case 15: // Exit
                        System.out.println("Exiting the system!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } while (choice != 15);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}