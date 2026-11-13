package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BikeRidePriceTest {

    @Test
    @DisplayName("BikeRide: tarif = jarak x Rp 2.500 per km")
    void priceIsMeasureTimesRate() throws Throwable {
        Ride order = TestSupport.newStudentOrder("BikeRide", "L1", 5);
        assertEquals(5 * 2500.0, order.calculateFare(), 0.001,
                "BikeRide: 5 km harus Rp 2.500 per km x 5");
    }

    @Test
    @DisplayName("BikeRide: jarak pecahan dihitung benar")
    void fractionalMeasure() throws Throwable {
        Ride order = TestSupport.newStudentOrder("BikeRide", "L1", 2.5);
        assertEquals(2.5 * 2500.0, order.calculateFare(), 0.001,
                "BikeRide: 2.5 km harus Rp 2.500 per km x 2.5 (pakai tipe double)");
    }
}
