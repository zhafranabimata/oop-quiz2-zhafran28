package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IsAcceptableTest {

    @Test
    @DisplayName("isAcceptable bernilai true untuk jarak yang valid")
    void trueWhenValid() {
        assertTrue(RideCalculator.isAcceptable(new TestSupport.TestOrder("L1", 5)), "jarak 5 valid");
        assertTrue(RideCalculator.isAcceptable(new TestSupport.TestOrder("L1", 50)), "jarak 50 masih valid");
    }

    @Test
    @DisplayName("isAcceptable bernilai false (bukan melempar) untuk jarak tidak valid")
    void falseWhenInvalid() {
        assertFalse(RideCalculator.isAcceptable(new TestSupport.TestOrder("L1", 0)),
                "Tangkap InvalidDistanceException dengan catch lalu kembalikan false");
        assertFalse(RideCalculator.isAcceptable(new TestSupport.TestOrder("L1", 50 + 0.5)),
                "jarak di atas 50 km harus menghasilkan false");
    }

    @Test
    @DisplayName("isAcceptable tidak pernah melempar exception")
    void neverThrows() {
        assertDoesNotThrow(() -> RideCalculator.isAcceptable(new TestSupport.TestOrder("L1", -1)),
                "Exception harus ditangkap di dalam isAcceptable, bukan diteruskan");
    }
}
