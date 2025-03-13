import java.util.ArrayList;
import java.util.List;

class TicketBookingSystem {
    private final List<Integer> availableSeats;

    public TicketBookingSystem(int totalSeats) {
        availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }

    public synchronized boolean bookSeat(String customerName) {
        if (!availableSeats.isEmpty()) {
            int seat = availableSeats.remove(0);
            System.out.println(customerName + " successfully booked seat " + seat);
            return true;
        } else {
            System.out.println(customerName + " tried to book but no seats available!");
            return false;
        }
    }
}

class Customer extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final String customerName;

    public Customer(TicketBookingSystem bookingSystem, String customerName, int priority) {
        this.bookingSystem = bookingSystem;
        this.customerName = customerName;
        setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(customerName);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5); // 5 seats available

        Thread vip1 = new Customer(bookingSystem, "VIP-1", Thread.MAX_PRIORITY);
        Thread vip2 = new Customer(bookingSystem, "VIP-2", Thread.MAX_PRIORITY);
        Thread regular1 = new Customer(bookingSystem, "Regular-1", Thread.NORM_PRIORITY);
        Thread regular2 = new Customer(bookingSystem, "Regular-2", Thread.NORM_PRIORITY);
        Thread regular3 = new Customer(bookingSystem, "Regular-3", Thread.NORM_PRIORITY);
        Thread regular4 = new Customer(bookingSystem, "Regular-4", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
        regular4.start();
    }
}