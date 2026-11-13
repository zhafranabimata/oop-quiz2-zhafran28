package id.ac.polinema.quiz2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TAHAP 4 dan 5 (collections dan SOLID): pengatur perjalanan yang menyimpan
 * dan memproses perjalanan.
 *
 * Lengkapi setiap method (ganti baris
 * {@code throw new UnsupportedOperationException(...)}).
 * Deklarasikan sendiri field-nya (semua private).
 *
 * Tahap 4: simpan perjalanan di {@code List} dan cari lewat kode
 * dengan {@code Map}. Jangan memakai array.
 * Tahap 5: metode pembayaran diberikan dari luar lewat constructor. Jangan
 * membuat CashPayment di dalam kelas ini.
 */
public class RideDispatcher {

    /**
     * Membuat pengatur perjalanan kosong dan menyimpan metode pembayaran yang diberikan.
     *
     * @param payment metode pembayaran yang dipakai saat checkout
     */
    private List<Ride> orders;
    private Map<String, Ride> ridesById;
    private PaymentMethod payment;

    public RideDispatcher(PaymentMethod payment) {
        this.payment = payment;
        this.orders = new ArrayList<>();
        this.ridesById = new HashMap<>();
    }

    /**
     * Menyimpan perjalanan ke daftar dan ke Map (kuncinya kode perjalanan).
     *
     * @param order perjalanan yang ditambahkan
     */
    public void add(Ride order) {
        orders.add(order);
        ridesById.put(order.getRideId(), order);;
    }

    /**
     * Mencari perjalanan lewat kodenya.
     *
     * @param rideId kode yang dicari
     * @return perjalanan yang cocok, atau {@code null} bila tidak ada
     */
    public Ride findById(String rideId) {
         return ridesById.get(rideId);
    }

    /**
     * @return jumlah perjalanan yang tersimpan
     */
    public int count() {
        return orders.size();
    }

    /**
     * @return daftar perjalanan menurut urutan penambahan
     */
    public List<Ride> getOrders() {
        return new ArrayList<>(orders);
    }

    /**
     * Mencari perjalanan lewat kodenya, lalu meminta metode pembayaran
     * (yang diberikan lewat constructor) mencatat kode dan tarif-nya.
     * Kelas ini sendiri tidak mencetak apa pun ke layar.
     * Bila kodenya tidak ada, tidak melakukan apa-apa.
     *
     * @param rideId kode perjalanan yang di-checkout
     */
    public void checkout(String rideId) {
        Ride order = findById(rideId);

        if (order != null) {
        payment.pay(order.getRideId(),order.calculateFare());
        };
    }
}
