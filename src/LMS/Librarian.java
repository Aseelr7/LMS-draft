package LMS;

public class Librarian {

    public static void main(String[] args) {

        Book book1 = new Book("1234-1", "FirstBook", "FirstBookAuthor", "Bob", 2000);
        Book book2 = new Book("1234-2", "SecondBook", "SecondBookAuthor", "Tony", 2001);
        Book book3 = new Book("1234-3", "ThirdBook", "ThirdBookAuthor", "Morphy", 2002);
        Book book4 = new Book("1234-4", "FourthBook", "FourthBookAuthor", "John", 2003);


        System.out.println(book1.toString());

        // the below methods from Library class called - Salma
        Library library = new Library();

        library.insertBook(book1);
        library.insertBook(book2);
        library.insertBook(book3);
        library.insertBook(book4);
        library.displayAllBooks();

        Book foundBook = library.searchBookByISBN("1234-4");
        if (foundBook != null) {
            System.out.println("This Book is in the collection: " + foundBook.toString());
        } else {
            System.out.println("There is no book in the collection with this ISBN.");
        }
        library.deleteBookByISBN("1234-2");
        library.displayAllBooks();


        Book foundBookByIsbnAndAuthor = library.searchBookByISBNAndAuthor("1734-5", "something");
        if (foundBookByIsbnAndAuthor != null) {
            System.out.println("This Book is in the collection: " + foundBookByIsbnAndAuthor.toString());
        } else {
            System.out.println("There is no book in the collection with this ISBN and Author.");
        }

        // ***********  ***********  ***********  ***********  ***********  ***********  ***********  ***********

        Member member1 = new Member(1111, "Bob", "b.bob@gmail.com", "777-777-7777");
        Member member2 = new Member(1112, "Tony", "tony@gmail.com", "777-777-8888");
        Member member3 = new Member(1113, "John", "john@gmail.com", "777-777-9999");


//

        member1.borrowBook(book1);
        try {
            library.addMember(member1);
            library.addMember(member2);
            library.addMember(member3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        library.displayAllMember();
        library.removeMember(1113);



        member1.borrowBook(book1);
        member1.borrowBook(book1);
        member1.borrowBook(book2);
        member1.returnBook(book1);


        System.out.println( "This is to only check the search method: " + library.searchMemberByID(1113));

        library.displayAllMember();
    }

}
