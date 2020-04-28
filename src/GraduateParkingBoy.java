public class GraduateParkingBoy extends ParkingBoy {

    public GraduateParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
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
}
