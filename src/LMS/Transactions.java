package LMS;


public class Transactions {
    private final int transactionId;
    private final String bookISBN;
    private final int memberId;
    private final  String  issueDate;
    private  String  returnDate;

    public Transactions(int transactionId, String bookISBN, int memberId, String issueDate) {
        this.transactionId = transactionId;
        this.bookISBN = bookISBN;
        this.memberId = memberId;
        this.issueDate = issueDate;
    }

    public void completeTransaction(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "TransactionID: " + transactionId + ", Book ISBN: " + bookISBN +
                ", MemberID: " + memberId + ", Issue Date: " + issueDate +
                ", Return Date: " + (returnDate != null ? returnDate : "Not Returned");
    }
}


//redundant codes:just its commented



//public class Transactions {
//    private int transactionId;
//    private String bookISBN;
//    private int memberId;
//    private String issueDate;
//    private String returnDate;

//    public Transactions(int transactionId, String bookISBN, int memberId, String issueDate, String returnDate) {
//        this.transactionId = transactionId;
//        this.bookISBN = bookISBN;
//        this.memberId = memberId;
//        this.issueDate = issueDate;
//        this.returnDate = returnDate;
//    }

//    private void setTransactionId(int transactionId) { this.transactionId = transactionId;}
//    private void setBookISBN(String bookISBN) { this.bookISBN = bookISBN;}
//    private void setMemberId(int memberId) { this.memberId = memberId;}
//    private void setIssueDate(String issueDate) { this.issueDate = issueDate; }
//    private void setReturnDate(String returnDate) { this.returnDate = returnDate; }


//    public int getTransactionId() { return transactionId; }
//    public String getBookISBN() { return bookISBN;}
//    public int getMemberId() { return memberId; }
//    public String getIssueDate() { return issueDate; }
//    public String getReturnDate() { return returnDate;}

//    @Override
//    public String toString() {
//        return "Transactions{" +
//                "transactionId=" + transactionId +
//                ", bookISBN='" + bookISBN + '\'' +
//                ", memberId=" + memberId +
//                ", issueDate='" + issueDate + '\'' +
//                ", returnDate='" + returnDate + '\'' +
//                '}';
//    }

//
//    public class Transactions {
//        private final int transactionId;
//        private final String bookISBN;
//        private final int memberId;
//        private final  String  issueDate;
//        private  String  returnDate;
//
//        public Transactions(int transactionId, String bookISBN, int memberId, String issueDate) {
//            this.transactionId = transactionId;
//            this.bookISBN = bookISBN;
//            this.memberId = memberId;
//            this.issueDate = issueDate;
//        }
//
//        public void completeTransaction(String returnDate) {
//            this.returnDate = returnDate;
//        }
//
//        // Getters and Setters
////        public int getTransactionId() { return transactionId; }
////        public String getBookISBN() { return bookISBN; }
////        public int getMemberId() { return memberId; }
////        public String getIssueDate() { return issueDate; }
////        public String getReturnDate() { return returnDate; }
//
//        @Override
//        public String toString() {
//            return "TransactionID: " + transactionId + ", Book ISBN: " + bookISBN +
//                    ", MemberID: " + memberId + ", Issue Date: " + issueDate +
//                    ", Return Date: " + (returnDate != null ? returnDate : "Not Returned");
//        }
//    }


