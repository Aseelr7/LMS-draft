package LMS;

import java.util.ArrayList;

public class Member {

   private final int memberId;
   private   String name;
   private   String email;
   private   String phoneNumber;
   private ArrayList<Book> borrowedBooks; // implemented Ramin's changes suggestion.

    public Member(int memberId, String name, String email, String phoneNumber) {
        this.memberId = memberId;
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters And Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    private void setBorrowedBooks(ArrayList<Book> borrowedBooks) {this.borrowedBooks = borrowedBooks;}

    public int getMemberId() {
        return memberId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // method to add a book to members borrowed books list

    public void borrowBook(Book book){
        if(borrowedBooks.contains(book)){
            System.out.println("Member Already borrowed a copy of this book, return that first");
        } else if(book.getIsAvailable()) {
            borrowedBooks.add(book);
            book.decreaseInventory(); // please take a look at this method do a better implementation than me i was not thinking when i wrote it lol - Aseel
            System.out.println(book.getTitle() + " by: " + book.getAuthor() + " successfully borrowed");
        } else System.out.println("Book is currently not Available in the Library");
    }

    // method to remove a book from members borrowed books list

    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
        borrowedBooks.remove(book);
        book.increaseInventory(); // this one as well they are not encapsulated at all
            System.out.println(book.getTitle() + " by: " + book.getAuthor() + " successfully removed");

        } else System.out.println("Member never borrowed this book");
    }


    // Method To Display A list of Borrowed Books
    public void displayBorrowedBooks(){
        int i = 1;
        for (Book book : borrowedBooks){
            System.out.print(i++ + ": ");
            System.out.println(book.toString());

        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "Member ID: " + memberId +
                ", Name: '" + name + '\'' +
                ", Email: '" + email + '\'' +
                ", Phone Number: '" + phoneNumber + '\'' +
                ", Borrowed Books: " + borrowedBooks +
                '}';
    }
}
