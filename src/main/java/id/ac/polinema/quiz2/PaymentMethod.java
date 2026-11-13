package id.ac.polinema.quiz2;

/**
 * INTERFACE untuk metode pembayaran. Kelas ini SUDAH LENGKAP, jangan diubah.
 *
 * RideDispatcher hanya boleh mengenal interface ini, bukan kelas konkretnya.
 */
public interface PaymentMethod {

    /**
     * @param rideId kode perjalanan
     * @param amount jumlah yang harus dibayar, dalam Rupiah
     */
    void pay(String rideId, double amount);
}
