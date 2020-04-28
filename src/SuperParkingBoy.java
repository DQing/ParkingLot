public class SuperParkingBoy extends ParkingBoy {

    public SuperParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        ParkingLot parkingLot = getParkingLotWithMoreVacancyRateSpace();
        if (parkingLot.getAvailableSpace() > 0) {
            ticket = parkingLot.park(car);
        }
        return ticket;
    }

    private ParkingLot getParkingLotWithMoreVacancyRateSpace() {
        ParkingLot parkingLotWithMoreSpace = parkingLots[0];
        double moreVacancyRateSpace = parkingLotWithMoreSpace.getAvailableSpace() * 1.0 / parkingLotWithMoreSpace.getCapacity();
        for (ParkingLot parkingLot : parkingLots) {
            double vacancyRateSpace = parkingLot.getAvailableSpace() * 1.0 / parkingLot.getCapacity();
            if (vacancyRateSpace > moreVacancyRateSpace) {
                moreVacancyRateSpace = vacancyRateSpace;
                parkingLotWithMoreSpace = parkingLot;
            }
        }
        return parkingLotWithMoreSpace;
    }
}
