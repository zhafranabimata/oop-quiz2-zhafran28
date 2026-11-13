package id.ac.polinema.quiz2;

/**
 * Implementasi PaymentMethod yang mencetak ke layar. Kelas ini SUDAH LENGKAP,
 * jangan diubah.
 *
 * Dipakai di Main untuk mencoba program. RideDispatcher TIDAK boleh membuat objek
 * kelas ini sendiri: objeknya harus diberikan dari luar lewat constructor.
 */
public class CashPayment implements PaymentMethod {

    @Override
    public void pay(String rideId, double amount) {
        System.out.println("Payment " + rideId + ": Rp " + amount);
    }
}
