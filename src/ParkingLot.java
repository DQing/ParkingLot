import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class ParkingLot {
    private int capacity;
    private int availableSpace;
    private HashMap<Ticket, Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSpace = capacity;
        this.cars = new HashMap<>();
    }

    public Ticket park(Car car) {
        Ticket ticket = null;

        if (availableSpace > 0) {
            ticket = new Ticket();
            availableSpace--;
            cars.put(ticket, car);
        }

        return ticket;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public Car pickUp(Ticket ticket) {
        availableSpace++;
        return cars.remove(ticket);
    }
}
