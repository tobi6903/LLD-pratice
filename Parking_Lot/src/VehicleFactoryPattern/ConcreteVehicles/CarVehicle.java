package VehicleFactoryPattern.ConcreteVehicles;
import FareStrategyPattern.ParkingFeeStrategy;
import VehicleFactoryPattern.Vehicle;

public class CarVehicle extends Vehicle {

    public CarVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy parkingFeeStrategy){
        super(licensePlate,vehicleType,parkingFeeStrategy);
    }
}
