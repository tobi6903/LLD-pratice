package FareStrategyPattern.ConcreteStrategies;
import CommonEnum.DurationType;
import FareStrategyPattern.ParkingFeeStrategy;


public class BasicHourlyRateStrategy implements ParkingFeeStrategy{
    
    @Override
    public double calculateFee(String vehicleType, int duration, DurationType durationType){
        switch(vehicleType.toLowerCase()){
            case "car":
                return durationType == DurationType.HOURS 
                        ? duration *10
                        : duration*10*24;

            case "bike":
                return durationType == DurationType.HOURS
                        ? duration * 5.0    // $5 per hour for bikes
                        : duration * 5.0 * 24;  // Daily rate

            case "auto":
                return durationType == DurationType.HOURS
                        ? duration * 8.0    // $8 per hour for autos
                        : duration * 8.0 * 24;  // Daily rate

            default:
                return durationType == DurationType.HOURS
                        ? duration * 15.0   // $15 per hour for other vehicles
                        : duration * 15.0 * 24;  // Daily rate
        }
    } 
}
