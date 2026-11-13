package id.ac.polinema.quiz2;

public class BikeRide extends Ride {
    public BikeRide (String rideId, Passenger passenger, double distanceKm) {
        super(rideId, passenger, distanceKm);
    }
    @Override 
    public double calculateFare(){
        return getDistanceKm() * 2500.0;
    }
}