public class ParkingManage {
    private GraduateParkingBoy[] parkingBoy;

    public ParkingManage(GraduateParkingBoy... parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public Ticket manage(GraduateParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }
}
