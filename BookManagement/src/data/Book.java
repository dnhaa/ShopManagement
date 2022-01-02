
package data;


public class Book {
    private long ISBN;
    private String title;
    private double price;
    private String authorID;

    public Book(long ISBN, String title, double price, String authorID) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.authorID = authorID;

    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN=" + ISBN + ", title=" + title + ", price=" + price + ", authorID=" + authorID + '}';
    }
    
    public void showBook() {
        System.out.printf("|%-5s|%10d|%-20s|%11.2f|%9s|\n", "Book", ISBN, title, price, authorID);
        
    }
    
    
}