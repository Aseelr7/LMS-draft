package LMS;
import java.time.LocalDate;
import java.util.ArrayList;

public class Transactions {
    private static int transactionCounter = 0;
    private final int transactionId;
    private final String bookISBN;
    private final int memberId;
    private static LocalDate issueDate;
    private static LocalDate returnDate;
    ArrayList<Transactions> transactionsList;

    public Transactions(String bookISBN, int memberId) {
        this.transactionId = ++transactionCounter;
        this.bookISBN = bookISBN;
        this.memberId = memberId;
        setIssueDate(LocalDate.now());
        transactionsList = new ArrayList<>();
    }


    private void setIssueDate(LocalDate issueDate) {Transactions.issueDate = issueDate;}
    private void setReturnDate(LocalDate returnDate) {Transactions.returnDate = returnDate;}


    public int getTransactionId() {return transactionId;}
    public String getBookISBN() {return bookISBN;}
    public int getMemberId() {return memberId;}
    public LocalDate getIssueDate() {return issueDate;}
    public LocalDate getReturnDate() {return returnDate;}
    public ArrayList<Transactions> getTransactionsList() {return transactionsList;}

    // Method To use while returning the books
    public void markAsReturned() {
        setReturnDate(LocalDate.now());
    }

    @Override
    public String toString() {
        return "TransactionID: " + transactionId + ", Book ISBN: " + bookISBN +
                ", MemberID: " + memberId + ", Issue Date: " + issueDate + ", Return Date: " + returnDate;
    }
}
