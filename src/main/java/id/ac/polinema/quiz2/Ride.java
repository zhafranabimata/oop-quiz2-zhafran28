package id.ac.polinema.quiz2;

/**
 * Kelas ABSTRAK untuk semua jenis perjalanan. Kelas ini SUDAH LENGKAP,
 * jangan diubah.
 *
 * Kelas abstrak belum lengkap: objeknya tidak boleh dibuat lewat {@code new}.
 * Setiap subclass wajib mengisi method abstrak {@code calculateFare()}.
 */
public abstract class Ride {

    private String rideId;
    private Passenger passenger;
    private double distanceKm;

    public Ride(String rideId, Passenger passenger, double distanceKm) {
        this.rideId = rideId;
        this.passenger = passenger;
        this.distanceKm = distanceKm;
    }

    public String getRideId() {
        return rideId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    /**
     * Menghitung tarif perjalanan ini. Aturannya berbeda untuk tiap subclass.
     *
     * @return tarif dalam Rupiah
     */
    public abstract double calculateFare();
}
