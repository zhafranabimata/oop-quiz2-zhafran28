package id.ac.polinema.quiz2;

public class BikeRide extends Ride {
    public BikeRide (String rideId, Passenger passenger, double distanceKm) {
        super(rideId, passenger, distanceKm);

    }

    @Override 
    public abstract double calculateFare(){
        
    }
}