class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

class MovieLinkedList {
    private MovieNode head, tail;

    public MovieLinkedList() {
        this.head = this.tail = null;
    }

    public void addMovie(String title, String director, int year, double rating, Integer position) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else if (position == null) {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        } else if (position == 0) {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        } else {
            MovieNode temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp == null) {
                System.out.println("Invalid position!");
                return;
            }
            newMovie.next = temp.next;
            newMovie.prev = temp;
            if (temp.next != null) temp.next.prev = newMovie;
            temp.next = newMovie;
            if (newMovie.next == null) tail = newMovie;
        }
    }

    public void removeMovie(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    public void displayMovies() {
        MovieNode temp = head;
        System.out.println("Movies List (Forward):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayMoviesReverse() {
        MovieNode temp = tail;
        System.out.println("Movies List (Reverse):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList movies = new MovieLinkedList();
        movies.addMovie("Inception", "Christopher Nolan", 2010, 8.8, null);
        movies.addMovie("Titanic", "James Cameron", 1997, 7.8, null);
        movies.addMovie("The Dark Knight", "Christopher Nolan", 2008, 9.0, null);
        movies.displayMovies();
        movies.removeMovie("Titanic");
        movies.displayMovies();
        movies.updateRating("Inception", 9.2);
        movies.displayMoviesReverse();
    }
}
