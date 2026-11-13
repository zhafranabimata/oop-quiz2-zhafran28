package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ScooterRide dibuat di dalam tes, bukan oleh siswa. Jenis baru ini harus
 * langsung bekerja tanpa mengubah RideDispatcher atau RideCalculator.
 */
class NewSubclassNoChangeTest {

    @Test
    @DisplayName("RideDispatcher menyimpan dan menemukan jenis perjalanan yang baru")
    void storesNewKind() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        Ride fresh = new TestSupport.ScooterRide("N1", 2);
        desk.add(fresh);
        assertSame(fresh, desk.findById("N1"),
                "Jenis baru harus bisa disimpan dan ditemukan tanpa mengubah RideDispatcher");
    }

    @Test
    @DisplayName("checkout meneruskan tarif jenis yang baru ke metode pembayaran")
    void checkoutPrintsNewKind() {
        TestSupport.RecordingPrinter printer = new TestSupport.RecordingPrinter();
        RideDispatcher desk = new RideDispatcher(printer);
        desk.add(new TestSupport.ScooterRide("N1", 2));
        desk.checkout("N1");
        assertEquals(2 * 2000.0, printer.amounts.get(0), 0.001,
                "checkout harus memakai calculateFare() milik objeknya, bukan mengecek jenis subclass");
    }

    @Test
    @DisplayName("RideCalculator ikut menghitung jenis yang baru")
    void calculatorCountsNewKind() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        desk.add(new TestSupport.ScooterRide("N1", 2));
        desk.add(new TestSupport.TestOrder("L1", 1));
        assertEquals(2 * 2000.0 + 1000.0, RideCalculator.totalFare(desk.getOrders()), 0.001,
                "Jumlahkan lewat calculateFare() agar jenis baru langsung terhitung (OCP: terbuka untuk diperluas)");
        assertEquals(0.0, RideCalculator.totalInsurance(desk.getOrders()), 0.001,
                "Jenis baru tanpa Insurable tidak punya biaya asuransi perjalanan");
    }
}
