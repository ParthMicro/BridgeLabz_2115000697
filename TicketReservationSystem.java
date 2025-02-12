class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode head, tail;
    private int ticketCount;

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.ticketCount = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head;  // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }

        ticketCount++;
        System.out.println("Ticket added successfully: " + ticketId);
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = head, prev = null;
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {  // Only one ticket
                    head = tail = null;
                } else if (current == head) {  // Removing head
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {  // Removing tail
                    prev.next = head;
                    tail = prev;
                } else {  // Removing a middle node
                    prev.next = current.next;
                }
                ticketCount--;
                System.out.println("Ticket removed successfully: " + ticketId);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket not found: " + ticketId);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String searchQuery) {
        if (head == null) {
            System.out.println("No tickets available to search.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchQuery) || current.movieName.equalsIgnoreCase(searchQuery)) {
                System.out.println("Ticket Found: Ticket ID: " + current.ticketId + ", Customer Name: " +
                        current.customerName + ", Movie Name: " + current.movieName + ", Seat Number: " +
                        current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for the search query: " + searchQuery);
        }
    }

    public void totalBookedTickets() {
        System.out.println("Total number of booked tickets: " + ticketCount);
    }

    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();
        reservationSystem.addTicket(1, "John Doe", "Avengers", "A1", "10:00 AM");
        reservationSystem.addTicket(2, "Jane Smith", "Avengers", "A2", "10:00 AM");
        reservationSystem.addTicket(3, "Alice Johnson", "Inception", "B3", "12:00 PM");

        System.out.println("\nDisplaying all tickets:");
        reservationSystem.displayTickets();

        System.out.println("\nSearching for tickets with movie name 'Avengers':");
        reservationSystem.searchTicket("Avengers");

        System.out.println("\nRemoving ticket with ID 2:");
        reservationSystem.removeTicket(2);

        System.out.println("\nDisplaying all tickets after removal:");
        reservationSystem.displayTickets();

        System.out.println("\nTotal booked tickets:");
        reservationSystem.totalBookedTickets();
    }
}
