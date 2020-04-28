public class GraduateParkingBoy {
    private ParkingLot[] parkingLots;

    public GraduateParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableSpace() > 0) {
                ticket = parkingLot.park(car);
                break;
            }
        }
        return ticket;
    }

    public Car pickUp(Ticket ticket) {
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            car = parkingLot.pickUp(ticket);
            if (car != null) {
                break;
            }

        }
        return car;
    }
}
