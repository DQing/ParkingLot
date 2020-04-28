import org.junit.Assert;
import org.junit.Test;

public class parkingLot_specs {
    @Test
    public void should_park_success_when_given_a_available_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(20);
        for (int i = 0; i < 19; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Assert.assertEquals(0, parkingLot.getAvailableSpace());
        Assert.assertNotNull(ticket);
    }

    @Test(expected = ParkingLotIsFullException.class)
    public void should_park_failed_when_given_parking_lot_has_no_space() {
        ParkingLot parkingLot = new ParkingLot(20);
        for (int i = 0; i < 20; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        Car car = new Car();
        parkingLot.park(car);
    }
}
