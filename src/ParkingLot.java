public class ParkingLot {
    private int capacity;
    private int availableSpace;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSpace = capacity;
    }

    public Ticket park(Car car) {
        if (availableSpace == 0) {
            throw new ParkingLotIsFullException();
        }
        availableSpace--;
        return new Ticket();
    }

    public int getAvailableSpace() {
        return availableSpace;
    }
}
