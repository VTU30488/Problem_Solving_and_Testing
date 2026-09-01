import java.util.*;

abstract class Vehicle {
    abstract int calculateFare(int distance);
}

class Bike extends Vehicle {
    public int calculateFare(int distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    public int calculateFare(int distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    public int calculateFare(int distance) {
        return distance * 12;
    }
}

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class Trip {
    private Vehicle vehicle;
    private int distance;

    public Trip(Vehicle vehicle, int distance) throws InvalidBookingException {
        if (distance <= 0) {
            throw new InvalidBookingException("Invalid booking");
        }

        this.vehicle = vehicle;
        this.distance = distance;
    }

    public int getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String rideType = sc.next();
            int distance = sc.nextInt();

            try {
                Vehicle vehicle;

                if (rideType.equals("Bike")) {
                    vehicle = new Bike();
                } else if (rideType.equals("Auto")) {
                    vehicle = new Auto();
                } else if (rideType.equals("Cab")) {
                    vehicle = new Cab();
                } else {
                    throw new InvalidBookingException("Invalid booking");
                }

                Trip trip = new Trip(vehicle, distance);
                result.append(trip.getFare()).append("\n");

            } catch (InvalidBookingException e) {
                result.append(e.getMessage()).append("\n");
            }
        }

        System.out.print(result);
        sc.close();
    }
}