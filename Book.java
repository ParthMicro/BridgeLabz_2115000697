import java.util.ArrayList;
class Book {
    private String title;
    private String author;
    
	public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}
class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in this library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Concepts of java", "xxx xxx");
        Book book2 = new Book("Concepts of python", "yyy yyy");
        Library library1 = new Library();
        Library library2 = new Library();
        library1.addBook(book1);
        library2.addBook(book2);
        System.out.println("Library 1:");
        library1.displayBooks();
        System.out.println("Library 2:");
        library2.displayBooks();
    }
}
