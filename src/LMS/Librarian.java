package LMS;

public class Librarian {

    public static void main(String[] args) {

        Book book1 = new Book("1234-1", "FirstBook", "FirstBookAuthor", "Bob", 2000);
        Book book2 = new Book("1234-2", "SecondBook", "SecondBookAuthor", "Tony", 2001);
        Book book3 = new Book("1234-3", "ThirdBook", "ThirdBookAuthor", "Morphy", 2002);


        System.out.println(book1.toString());

        // the below methods from Library class called - Salma
        Library library = new Library();

        library.insertBook(book1);
        library.insertBook(book2);
        library.insertBook(book3);
        library.displayAllBooks();
        Book foundBook = library.searchBookByISBN("1234-4");
        if (foundBook != null) System.out.println("This Book is in the collection: " + foundBook.toString());
        else System.out.println("There is no any book in collection with this ISBN");


        library.deleteBookByISBN("1234-1");

        Member member = new Member(112321, "asfsd", "asdfkadslfkj", "123123123");

        member.borrowBook(book1);
        member.borrowBook(book1);
        member.borrowBook(book2);
        member.returnBook(book1);
        member.borrowBook(book1);


        member.displayBorrowedBooks();

    }
}
