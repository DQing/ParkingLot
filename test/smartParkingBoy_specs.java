import org.junit.Assert;
import org.junit.Test;

public class smartParkingBoy_specs {
    @Test
    public void should_park_into_first_parking_lot_when_it_has_more_space() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(20);
        for (int i = 0; i < 8; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingLot2.park(car);
        }
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car();
        var ticket = parkingBoy.park(car);

        Assert.assertEquals(11, parkingLot1.getAvailableSpace());
        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_park_into_first_parking_lot_when_both_has_same_space() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(20);
        for (int i = 0; i < 10; i++) {
            Car car1 = new Car();
            Car car2 = new Car();
            parkingLot1.park(car1);
            parkingLot2.park(car2);
        }
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car();
        parkingBoy.park(car);

        Assert.assertEquals(9, parkingLot1.getAvailableSpace());
    }

    @Test
    public void should_park_into_second_parking_lot_when_second_has_more_space() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(20);
        for (int i = 0; i < 8; i++) {
            Car car = new Car();
            parkingLot2.park(car);
        }
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car();
        parkingBoy.park(car);

        Assert.assertEquals(10, parkingLot1.getAvailableSpace());
        Assert.assertEquals(11, parkingLot2.getAvailableSpace());
    }
}
