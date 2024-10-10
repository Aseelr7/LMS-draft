package LMS;

import java.util.ArrayList;

public class Member {

   private final int memberId;
   private   String name;
   private   String email;
   private   String phoneNumber;
   private ArrayList<Book> borrowedBooks;
   private  Transactions transaction;

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


    // method to borrow a book and add the book to members borrowed books list which also decreases the amount of that book from the inventory
    public void borrowBook(Book book){
        if(getBorrowedBooks().contains(book)){
            System.out.println("Member Already borrowed a copy of this book, return that first");
        } else if(book.getIsAvailable()) {
            getBorrowedBooks().add(book);
            book.decreaseInventory();
            transaction = new Transactions(book.getISBN(),getMemberId());
            transaction.getTransactionsList().add(transaction);
            transaction.markAsIssued();
            System.out.println(book.getTitle() + " by: " + book.getAuthor() + " successfully borrowed");
            System.out.println("**************************************");
            System.out.println("Transaction Details: " + '\n' + transaction.toString());
        } else System.out.println("Book is currently not Available in the Library");
    }


    //Method to return a borrowed book which also removes the book from members borrowed books list and adds it back to the inventory
    public void returnBook(Book book){
        if(getBorrowedBooks().contains(book)){
        getBorrowedBooks().remove(book);
        book.increaseInventory();
            transaction = new Transactions(book.getISBN(),getMemberId());
            transaction.transactionsList.add(transaction);
            transaction.markAsReturned();
            System.out.println(book.getTitle() + " by: " + book.getAuthor() + " successfully returned \n");
            System.out.println("**************************************");
            System.out.println("Transaction Details: " + '\n' + transaction.toString());

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
