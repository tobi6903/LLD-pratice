package VehicleFactoryPattern;
import CommonEnum.DurationType;
import FareStrategyPattern.ParkingFeeStrategy;


public abstract class Vehicle {
    private String licensePlate;
    private String vehicleType;
    private ParkingFeeStrategy feeStrategy;

    public Vehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy){
        this.licensePlate=licensePlate;
        this.vehicleType=vehicleType;
        this.feeStrategy=feeStrategy;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    // Getter method to retrieve the vehicle's license plate number
    public String getLicensePlate() {
        return licensePlate;
    }

    public double calculateFee(int duration, DurationType durationType){
        return feeStrategy.calculateFee(vehicleType, duration, durationType);
    }
}
