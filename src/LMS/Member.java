package LMS;

import java.util.ArrayList;

public class Member {

   private final int memberId;
   private   String name;
   private   String email;
   private   String phoneNumber;
   private ArrayList<String> borrowedBooks; // we can intialize borrowedBooks to avoid null reference. = new Arraylist<>()

    public Member(int memberId, String name, String email, String phoneNumber, ArrayList<String> borrowedBooks) {
        this.memberId = memberId;
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setBorrowedBooks(borrowedBooks);
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

    private void setBorrowedBooks(ArrayList<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;

    }


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

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method To Display A list of Borrowed Books
    public void displayBorrowedBooks(){
        // Fill after creating a way to store the borrowed books
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
