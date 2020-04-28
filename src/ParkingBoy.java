public abstract class ParkingBoy {

    protected ParkingLot[] parkingLots;

    protected ParkingBoy(ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    protected abstract Ticket park(Car car);

    protected Car pickUp(Ticket ticket) {
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
