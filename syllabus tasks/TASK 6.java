import java.util.*;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

class Vehicle {
    String type;

    Vehicle(String type) {
        this.type = type;
    }
}

class Driver {
    String name;
    Vehicle vehicle;

    Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

abstract class Trip {
    double distance;

    Trip(double distance) throws InvalidBookingException {
        if (distance <= 0) {
            throw new InvalidBookingException("Invalid distance");
        }
        this.distance = distance;
    }

    abstract double calculateFare();
}

class BikeTrip extends Trip {
    BikeTrip(double distance) throws InvalidBookingException {
        super(distance);
    }

    double calculateFare() {
        return distance * 5;
    }
}

class CabTrip extends Trip {
    CabTrip(double distance) throws InvalidBookingException {
        super(distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

class AutoTrip extends Trip {
    AutoTrip(double distance) throws InvalidBookingException {
        super(distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Trip trip;

                if (type.equalsIgnoreCase("Bike")) {
                    trip = new BikeTrip(distance);
                } 
                else if (type.equalsIgnoreCase("Cab")) {
                    trip = new CabTrip(distance);
                } 
                else if (type.equalsIgnoreCase("Auto")) {
                    trip = new AutoTrip(distance);
                } 
                else {
                    throw new InvalidBookingException("Invalid ride type");
                }

                System.out.println((int) trip.calculateFare());

            } catch (InvalidBookingException e) {
                System.out.println("Invalid Booking");
            }
        }

        sc.close();
    }
}