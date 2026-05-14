import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CommonEnum.DurationType;
import FareStrategyPattern.ParkingFeeStrategy;
import FareStrategyPattern.ConcreteStrategies.BasicHourlyRateStrategy;
import FareStrategyPattern.ConcreteStrategies.PremiumRateStrategy;
import ParkingLotController.ParkingLot;
import ParkingSpots.ParkingSpot;
import ParkingSpots.ConcreteParkingSpots.BikeParkingSpot;
import ParkingSpots.ConcreteParkingSpots.CarParkingSpot;
import PaymentStrategyPattern.Payment;
import PaymentStrategyPattern.PaymentStrategy;
import PaymentStrategyPattern.ConcretePaymentStrategies.CashPayment;
import PaymentStrategyPattern.ConcretePaymentStrategies.CreditCardPayment;
import VehicleFactoryPattern.Vehicle;
import VehicleFactoryPattern.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>(); 
        parkingSpots.add(new CarParkingSpot(1, "Car"));
        parkingSpots.add(new CarParkingSpot(2,"Car")); 
        parkingSpots.add(new BikeParkingSpot(3, "Bike"));
        parkingSpots.add(new BikeParkingSpot(4, "Bike"));

        ParkingLot parkingLot=new ParkingLot(parkingSpots);
        ParkingFeeStrategy basicHourlyRateStrategy = new BasicHourlyRateStrategy();
        ParkingFeeStrategy premiumRateStrategy = new PremiumRateStrategy();
        Vehicle car1 = VehicleFactory.createVehicle("Car1", "CAR", basicHourlyRateStrategy);
        Vehicle car2 = VehicleFactory.createVehicle("Car2", "CAR", basicHourlyRateStrategy);

        Vehicle bike1 = VehicleFactory.createVehicle("Bike1", "BIKE", premiumRateStrategy);
        Vehicle bike2 = VehicleFactory.createVehicle("Bike2", "BIKE", premiumRateStrategy);

        ParkingSpot carSpot = parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(bike1);

        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(bike2);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();

        PaymentStrategy paymentStrategy;
        if (paymentMethod == 1) {
            paymentStrategy = new CreditCardPayment();
        } else if (paymentMethod == 2) {
            paymentStrategy = new CashPayment();
        } else {
            System.out.println("Invalid payment method selected.");
            scanner.close();
            return;
        }

        if (carSpot != null) {
            double carFee = car1.calculateFee(2, DurationType.HOURS);
            Payment pay = new Payment(carFee, paymentStrategy);
            pay.processPayment(carFee);
            parkingLot.vacateSpot(carSpot, car1);
        }
        scanner.close();
    }
}
