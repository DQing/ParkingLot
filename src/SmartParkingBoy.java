public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        ParkingLot parkingLot = getParkingLotWithMoreSpace();
        if (parkingLot.getAvailableSpace() > 0) {
            ticket = parkingLot.park(car);
        }
        return ticket;
    }

    private ParkingLot getParkingLotWithMoreSpace() {
        ParkingLot parkingLotWithMoreSpace = parkingLots[0];
        int moreSpace = parkingLotWithMoreSpace.getAvailableSpace();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableSpace() > moreSpace) {
                moreSpace = parkingLot.getAvailableSpace();
                parkingLotWithMoreSpace = parkingLot;
            }
        }
        return parkingLotWithMoreSpace;
    }
}
