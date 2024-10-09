package LMS;

public class Book {


    private final String ISBN;
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublication;
    private boolean isAvailable;
    private int inventory;


    // Removed Unnecessary variables from the constructor parameters -isAvailable : because if you add a book the constructor already makes it true.
    public Book(String ISBN, String title, String author, String publisher, int yearOfPublication) {
        this.ISBN = ISBN;
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setYearOfPublication(yearOfPublication);
        this.isAvailable = true;
        this.inventory++;
    }


    // Getters And Setters
    private void setTitle(String title) {
        this.title = title;
    }
    private void setAuthor(String author) {
        this.author = author;
    }
    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    private void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getInventory() {return inventory;}
    public String getPublisher() {
        return publisher;
    }
    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public boolean getIsAvailable() {return isAvailable;}

    // method to increase and decrease the inventory

    // it's here thank you for finding it
    public void increaseInventory(){
        this.inventory++;
    }

    public void decreaseInventory(){
        this.inventory--;
    }




    @Override
    public String toString() {
        return "Book{" +
                "ISBN: " + ISBN +
                ", Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Publisher: '" + publisher + '\'' +
                ", Year Of Publication=" + yearOfPublication +

                '}';
    }
}
