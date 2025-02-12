class BookNode { 
    String title, author, genre; 
    int bookId; 
    boolean availability; 
    BookNode next, prev; 

    public BookNode(int bookId, String title, String author, String genre, boolean availability) { 
        this.bookId = bookId; 
        this.title = title; 
        this.author = author; 
        this.genre = genre; 
        this.availability = availability; 
        this.next = null; 
        this.prev = null; 
    } 
} 

class LibraryManagementLinkedList { 
    private BookNode head, tail; 

    public LibraryManagementLinkedList() { 
        this.head = null; 
        this.tail = null; 
    } 

    public void addBookAtBeginning(int bookId, String title, String author, String genre, boolean availability) { 
        BookNode newBook = new BookNode(bookId, title, author, genre, availability); 
        if (head == null) { 
            head = tail = newBook; 
        } else { 
            newBook.next = head; 
            head.prev = newBook; 
            head = newBook; 
        } 
    } 

    public void addBookAtEnd(int bookId, String title, String author, String genre, boolean availability) { 
        BookNode newBook = new BookNode(bookId, title, author, genre, availability); 
        if (tail == null) { 
            head = tail = newBook; 
        } else { 
            newBook.prev = tail; 
            tail.next = newBook; 
            tail = newBook; 
        } 
    } 

    public void addBookAtPosition(int position, int bookId, String title, String author, String genre, boolean availability) { 
        if (position < 0) { 
            System.out.println("Invalid position."); 
            return; 
        } 

        if (position == 0) { 
            addBookAtBeginning(bookId, title, author, genre, availability); 
            return; 
        } 

        BookNode newBook = new BookNode(bookId, title, author, genre, availability); 
        BookNode temp = head; 
        int count = 0; 
        while (temp != null && count < position - 1) { 
            temp = temp.next; 
            count++; 
        } 

        if (temp == null) { 
            addBookAtEnd(bookId, title, author, genre, availability); 
        } else { 
            newBook.next = temp.next; 
            if (temp.next != null) { 
                temp.next.prev = newBook; 
            } 
            temp.next = newBook; 
            newBook.prev = temp; 
        } 
    } 

    public void removeBookById(int bookId) { 
        if (head == null) { 
            System.out.println("Library is empty."); 
            return; 
        } 

        BookNode temp = head; 
        while (temp != null && temp.bookId != bookId) { 
            temp = temp.next; 
        } 

        if (temp == null) { 
            System.out.println("Book not found."); 
            return; 
        } 

        if (temp == head) { 
            head = head.next; 
            if (head != null) { 
                head.prev = null; 
            } 
        } else if (temp == tail) { 
            tail = tail.prev; 
            if (tail != null) { 
                tail.next = null; 
            } 
        } else { 
            temp.prev.next = temp.next; 
            temp.next.prev = temp.prev; 
        } 
    } 

    public void searchBookByTitle(String title) { 
        BookNode temp = head; 
        while (temp != null) { 
            if (temp.title.equalsIgnoreCase(title)) { 
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (ID: " + temp.bookId + ")"); 
                return; 
            } 
            temp = temp.next; 
        } 
        System.out.println("Book not found."); 
    } 

    public void searchBookByAuthor(String author) { 
        BookNode temp = head; 
        while (temp != null) { 
            if (temp.author.equalsIgnoreCase(author)) { 
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (ID: " + temp.bookId + ")"); 
                return; 
            } 
            temp = temp.next; 
        } 
        System.out.println("Book not found."); 
    } 

    public void updateAvailability(int bookId, boolean availability) { 
        BookNode temp = head; 
        while (temp != null) { 
            if (temp.bookId == bookId) { 
                temp.availability = availability; 
                System.out.println("Availability status of " + temp.title + " updated."); 
                return; 
            } 
            temp = temp.next; 
        } 
        System.out.println("Book not found."); 
    } 

    public void displayBooksForward() { 
        BookNode temp = head; 
        while (temp != null) { 
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.availability); 
            temp = temp.next; 
        } 
    } 

    public void displayBooksReverse() { 
        BookNode temp = tail; 
        while (temp != null) { 
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.availability); 
            temp = temp.prev; 
        } 
    } 

    public int countBooks() { 
        int count = 0; 
        BookNode temp = head; 
        while (temp != null) { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
    } 
}

public class LibraryManagementSystem { 
    public static void main(String[] args) { 
        LibraryManagementLinkedList library = new LibraryManagementLinkedList(); 
        library.addBookAtBeginning(1, "Java Programming", "XXXXXX XXXXXX", "Programming", true); 
        library.addBookAtEnd(2, "Bhagvad Gita : As It Is", "Swami Prabhupada", "Relegious", true); 
        library.addBookAtPosition(1, 3, "1984", "George Orwell", "Dystopian", true); 

        System.out.println("Books in Forward Order:");
        library.displayBooksForward(); 

        System.out.println("\nBooks in Reverse Order:");
        library.displayBooksReverse(); 

        library.searchBookByTitle("1984"); 
        library.searchBookByAuthor("Harper Lee"); 

        library.updateAvailability(2, false); 

        System.out.println("\nUpdated Book List:");
        library.displayBooksForward(); 

        System.out.println("Total Books in Library: " + library.countBooks()); 

        library.removeBookById(1); 

        System.out.println("\nBook List after Removal:");
        library.displayBooksForward(); 
    } 
} 
