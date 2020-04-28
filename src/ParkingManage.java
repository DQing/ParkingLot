import java.util.Arrays;

public class ParkingManage extends ParkingBoy {
    private ParkingBoy[] parkingBoys;

    public ParkingManage(ParkingLot[] parkingLots, ParkingBoy... parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public Ticket manage(ParkingBoy parkingBoy, Car car) {
        if (!Arrays.asList(parkingBoys).contains(parkingBoy)) {
            return null;
        }
        return parkingBoy.park(car);
    }

    protected Ticket park(Car car) {
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
