class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "Gary Cornell", 499.99);
        book.displayDetails();
    }
}
