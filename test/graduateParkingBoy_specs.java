import org.junit.Assert;
import org.junit.Test;

public class graduateParkingBoy_specs {
    @Test
    public void should_park_success_when_given_a_available_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(20);
        for (int i = 0; i < 19; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLot);

        Car car = new Car();
        var ticket = parkingBoy.park(car);

        Assert.assertEquals(0, parkingLot.getAvailableSpace());
        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_park_failed_when_given_a_parking_lot_has_no_space() {
        ParkingLot parkingLot = new ParkingLot(20);
        for (int i = 0; i < 20; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLot);

        Car car = new Car();
        var ticket = parkingBoy.park(car);

        Assert.assertNull(ticket);
    }

    @Test
    public void should_pick_up_car_success_when_use_valid_ticket() {
        ParkingLot parkingLot = new ParkingLot(20);
        for (int i = 0; i < 19; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }

        Car parkedCar = new Car();
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLot);

        var ticket = parkingBoy.park(parkedCar);

        var pickedCar = parkingBoy.pickUp(ticket);

        Assert.assertSame(parkedCar, pickedCar);
        Assert.assertEquals(1, parkingLot.getAvailableSpace());
    }

    @Test
    public void should_park_car_in_first_parking_lot_when_both_parking_lot_has_available_space() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(20);
        for (int i = 0; i < 10; i++) {
            Car car1 = new Car();
            Car car2 = new Car();
            parkingLot1.park(car1);
            parkingLot2.park(car2);
        }

        Car parkedCar = new Car();
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLot1, parkingLot2);

        parkingBoy.park(parkedCar);

        Assert.assertEquals(9, parkingLot1.getAvailableSpace());
        Assert.assertEquals(10, parkingLot2.getAvailableSpace());
    }

    @Test
    public void should_park_car_in_second_parking_lot_when_both_parking_lot_has_available_space() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(20);
        for (int i = 0; i < 20; i++) {
            Car car1 = new Car();
            parkingLot1.park(car1);
        }

        Car parkedCar = new Car();
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLot1, parkingLot2);

        parkingBoy.park(parkedCar);

        Assert.assertEquals(19, parkingLot2.getAvailableSpace());
    }

    @Test
    public void should_pick_up_car_from_second_parking_lot_success_when_use_valid_ticket() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(20);
        for (int i = 0; i < 20; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }

        Car parkedCar = new Car();
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLot1, parkingLot2);

        var ticket = parkingBoy.park(parkedCar);

        var pickedCar = parkingBoy.pickUp(ticket);

        Assert.assertSame(parkedCar, pickedCar);
        Assert.assertEquals(20, parkingLot2.getAvailableSpace());
    }

}
