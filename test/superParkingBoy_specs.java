import org.junit.Assert;
import org.junit.Test;

public class superParkingBoy_specs {
    @Test
    public void should_park_into_first_parking_lot_when_it_has_more_vacancy_rate() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(10);
        for (int i = 0; i < 8; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        for (int i = 0; i < 5; i++) {
            Car car = new Car();
            parkingLot2.park(car);
        }
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car();
        var ticket = parkingBoy.park(car);

        Assert.assertEquals(11, parkingLot1.getAvailableSpace());
        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_park_into_first_parking_lot_when_both_has_same_vacancy_rate() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        for (int i = 0; i < 5; i++) {
            Car car = new Car();
            parkingLot2.park(car);
        }

        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car();
        parkingBoy.park(car);

        Assert.assertEquals(9, parkingLot1.getAvailableSpace());
    }

    @Test
    public void should_park_into_second_parking_lot_when_second_has_more_vacancy_rate() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car();
        parkingBoy.park(car);

        Assert.assertEquals(10, parkingLot1.getAvailableSpace());
        Assert.assertEquals(9, parkingLot2.getAvailableSpace());
    }
}
