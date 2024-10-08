package LMS;

public class Book {

    // Changed The DataType of ISBN to String -Aseel

    private final String ISBN;
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublication;
    private boolean isAvailable;

    // Changed the constructor calls from this.Attribute to setAttribute(Attribute) - Aseel
    public Book(String ISBN, String title, String author, String publisher, int yearOfPublication, boolean isAvailable) {
        this.ISBN = ISBN;
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setYearOfPublication(yearOfPublication);
        this.isAvailable = true;
    }

    // Changed The Access Modifiers for Setters to Private and Arranged Them - Aseel

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

    public String getPublisher() {
        return publisher;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public boolean getIsAvailable() {return isAvailable;}

    private void makeAvailable(boolean available) {
        isAvailable = available;
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
