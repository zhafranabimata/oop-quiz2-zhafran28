package id.ac.polinema.quiz2;

import java.util.List;

/**
 * TAHAP 3 (polimorfisme dan exception): perhitungan atas banyak perjalanan.
 *
 * Lengkapi setiap method (ganti baris
 * {@code throw new UnsupportedOperationException(...)}).
 * Semua method memproses objek lewat tipe {@code Ride}, tanpa mengecek
 * nama subclass.
 */
public class RideCalculator {

    /**
     * Menjumlahkan tarif semua perjalanan di daftar.
     * Satu looping untuk semua jenis, tanpa cabang if per subclass.
     *
     * @param orders daftar perjalanan
     * @return jumlah semua tarif, atau 0 bila daftar kosong
     */
    public static double totalFare(List<Ride> orders) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Menjumlahkan biaya asuransi perjalanan dari perjalanan yang punya
     * kemampuan itu. Periksa kemampuannya dengan {@code instanceof Insurable},
     * bukan nama subclass.
     *
     * @param orders daftar perjalanan
     * @return jumlah biaya asuransi perjalanan, atau 0 bila tidak ada yang punya
     */
    public static double totalInsurance(List<Ride> orders) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Memeriksa jarak. Valid hanya bila jarak lebih dari 0 dan paling banyak 50 km.
     * Bila tidak valid, lempar {@code InvalidDistanceException} dengan pesan
     * "Invalid distance: " diikuti nilai jarak-nya.
     *
     * @param order perjalanan yang diperiksa
     * @throws InvalidDistanceException bila jarak tidak valid
     */
    public static void validate(Ride order) throws InvalidDistanceException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Memanggil {@link #validate} di dalam try/catch.
     *
     * @param order perjalanan yang diperiksa
     * @return true bila valid, false bila validate melempar InvalidDistanceException
     */
    public static boolean isAcceptable(Ride order) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
