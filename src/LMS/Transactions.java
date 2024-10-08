package LMS;

public class Transactions {

    private int transactionId;


    public class Transaction {
        private int transactionId;
        private String bookISBN;
        private int memberId;
        private String  issueDate;
        private  String  returnDate;

        public Transaction(int transactionId, String bookISBN, int memberId, String issueDate) {
            this.transactionId = transactionId;
            this.bookISBN = bookISBN;
            this.memberId = memberId;
            this.issueDate = issueDate;
        }

        public void completeTransaction(String returnDate) {
            this.returnDate = returnDate;
        }

        // Getters and Setters
        public int getTransactionId() { return transactionId; }
        public String getBookISBN() { return bookISBN; }
        public int getMemberId() { return memberId; }
        public String getIssueDate() { return issueDate; }
        public String getReturnDate() { return returnDate; }

        @Override
        public String toString() {
            return "TransactionID: " + transactionId + ", Book ISBN: " + bookISBN +
                    ", MemberID: " + memberId + ", Issue Date: " + issueDate +
                    ", Return Date: " + (returnDate != null ? returnDate : "Not Returned");
        }
    }


}
