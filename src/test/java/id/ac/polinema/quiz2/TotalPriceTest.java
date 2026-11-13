package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalPriceTest {

    @Test
    @DisplayName("totalFare menjumlahkan tarif semua jenis dengan satu looping")
    void sumsAllKinds() {
        List<Ride> orders = new ArrayList<>();
        orders.add(new TestSupport.TestOrder("L1", 2));
        orders.add(new TestSupport.TestAbilityOrder("L2", 3));
        assertEquals(5000.0, RideCalculator.totalFare(orders), 0.001,
                "Panggil calculateFare() pada tiap Ride lalu jumlahkan");
    }

    @Test
    @DisplayName("Daftar kosong menghasilkan 0")
    void emptyListIsZero() {
        assertEquals(0.0, RideCalculator.totalFare(new ArrayList<>()), 0.001, "Daftar kosong harus 0");
    }

    @Test
    @DisplayName("Jenis yang tidak dikenal ikut dihitung")
    void unknownKindIsCounted() {
        List<Ride> orders = new ArrayList<>();
        orders.add(new TestSupport.ScooterRide("L1", 2));
        assertEquals(2 * 2000.0, RideCalculator.totalFare(orders), 0.001,
                "Jangan mengecek nama subclass: biarkan tiap objek menghitung tarif-nya sendiri");
    }
}
