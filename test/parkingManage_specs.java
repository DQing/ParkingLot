import org.junit.Assert;
import org.junit.Test;

public class parkingManage_specs {
    @Test
    public void should_park_cars_success_when_parking_manage_boy_park() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }

        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        ParkingManage parkingManage = new ParkingManage(new ParkingLot[]{parkingLot1, parkingLot2}, superParkingBoy, graduateParkingBoy, smartParkingBoy);

        //P1: 10/20 P2 10/10
        Car car1 = new Car();
        var ticket1 = parkingManage.manage(superParkingBoy, car1);
        Assert.assertEquals(9, parkingLot2.getAvailableSpace());
        Assert.assertNotNull(ticket1);

        //P1: 10/20 P2 9/10
        Car car2 = new Car();
        var ticket2 = parkingManage.manage(smartParkingBoy, car2);
        Assert.assertEquals(9, parkingLot1.getAvailableSpace());
        Assert.assertNotNull(ticket2);

        //P1: 9/20 P2 9/10
        Car car3 = new Car();
        var ticket3 = parkingManage.manage(graduateParkingBoy, car2);
        Assert.assertEquals(8, parkingLot1.getAvailableSpace());
        Assert.assertNotNull(ticket3);
    }

    @Test
    public void should_park_car_success_when_parking_lot_has_available_space() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        for (int i = 0; i < 19; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1);

        ParkingManage parkingManage = new ParkingManage(new ParkingLot[]{parkingLot1}, superParkingBoy);

        Car car = new Car();
        parkingManage.park(car);

        Assert.assertEquals(0, parkingLot1.getAvailableSpace());
    }

    @Test
    public void should_not_manage_other_boy_to_park_car() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        for (int i = 0; i < 19; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        SuperParkingBoy superParkingBoy1 = new SuperParkingBoy(parkingLot1);
        SuperParkingBoy superParkingBoy2 = new SuperParkingBoy(parkingLot1);

        ParkingManage parkingManage = new ParkingManage(new ParkingLot[]{parkingLot1}, superParkingBoy1);

        Car car = new Car();
        parkingManage.manage(superParkingBoy2, car);

        Assert.assertEquals(1, parkingLot1.getAvailableSpace());
    }
}
