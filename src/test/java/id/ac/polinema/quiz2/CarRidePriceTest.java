package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRidePriceTest {

    @Test
    @DisplayName("CarRide: tarif = jarak x Rp 4.000 per km")
    void priceIsMeasureTimesRate() throws Throwable {
        Ride order = TestSupport.newStudentOrder("CarRide", "L1", 5);
        assertEquals(5 * 4000.0, order.calculateFare(), 0.001,
                "CarRide: 5 km harus Rp 4.000 per km x 5");
    }

    @Test
    @DisplayName("CarRide: jarak pecahan dihitung benar")
    void fractionalMeasure() throws Throwable {
        Ride order = TestSupport.newStudentOrder("CarRide", "L1", 1.5);
        assertEquals(1.5 * 4000.0, order.calculateFare(), 0.001,
                "CarRide: 1.5 km harus Rp 4.000 per km x 1.5 (pakai tipe double)");
    }
}
