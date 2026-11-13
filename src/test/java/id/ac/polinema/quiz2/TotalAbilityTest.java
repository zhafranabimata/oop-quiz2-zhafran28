package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalAbilityTest {

    @Test
    @DisplayName("totalInsurance hanya menjumlahkan yang punya kemampuan Insurable")
    void sumsOnlyAbleOrders() {
        List<Ride> orders = new ArrayList<>();
        orders.add(new TestSupport.TestOrder("L1", 2));
        orders.add(new TestSupport.TestAbilityOrder("L2", 3));
        orders.add(new TestSupport.TestAbilityOrder("L3", 1));
        assertEquals(1000.0, RideCalculator.totalInsurance(orders), 0.001,
                "Periksa dengan instanceof Insurable, lalu jumlahkan insuranceFee()");
    }

    @Test
    @DisplayName("Tanpa kemampuan Insurable hasilnya 0")
    void noneAbleIsZero() {
        List<Ride> orders = new ArrayList<>();
        orders.add(new TestSupport.TestOrder("L1", 2));
        assertEquals(0.0, RideCalculator.totalInsurance(orders), 0.001,
                "Bila tidak ada yang Insurable, hasilnya harus 0");
    }

    @Test
    @DisplayName("Daftar kosong menghasilkan 0")
    void emptyListIsZero() {
        assertEquals(0.0, RideCalculator.totalInsurance(new ArrayList<>()), 0.001, "Daftar kosong harus 0");
    }
}
