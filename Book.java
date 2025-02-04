public class Book {

    static String libraryName = "GLA Library";
    final String isbn;
    String title;
    String author;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails(){
        if(this instanceof Book){
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("JavaBook", "james", "123456");

        Book.displayLibraryName();        
        book1.displayDetails();
    }

}
