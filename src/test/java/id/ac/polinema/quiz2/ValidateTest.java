package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    @DisplayName("validate melempar InvalidDistanceException untuk jarak 0 atau negatif")
    void throwsForZeroOrNegative() {
        assertThrows(InvalidDistanceException.class, () -> RideCalculator.validate(new TestSupport.TestOrder("L1", 0)),
                "jarak 0 tidak valid: lempar InvalidDistanceException");
        assertThrows(InvalidDistanceException.class, () -> RideCalculator.validate(new TestSupport.TestOrder("L1", -2)),
                "jarak negatif tidak valid: lempar InvalidDistanceException");
    }

    @Test
    @DisplayName("validate melempar InvalidDistanceException untuk jarak di atas 50 km")
    void throwsAboveLimit() {
        assertThrows(InvalidDistanceException.class, () -> RideCalculator.validate(new TestSupport.TestOrder("L1", 50 + 1)),
                "jarak lebih dari 50 km tidak valid");
    }

    @Test
    @DisplayName("Pesan exception: Invalid distance: 55.0")
    void exceptionMessage() {
        InvalidDistanceException e = assertThrows(InvalidDistanceException.class,
                () -> RideCalculator.validate(new TestSupport.TestOrder("L1", 55)));
        assertEquals("Invalid distance: 55.0", e.getMessage(),
                "Pesannya harus \"Invalid distance: \" diikuti nilai jarak, contoh: Invalid distance: 55.0");
    }

    @Test
    @DisplayName("validate tidak melempar apa pun untuk jarak yang valid")
    void validDoesNotThrow() {
        assertDoesNotThrow(() -> RideCalculator.validate(new TestSupport.TestOrder("L1", 0.5)),
                "jarak 0.5 valid");
        assertDoesNotThrow(() -> RideCalculator.validate(new TestSupport.TestOrder("L1", 50)),
                "jarak tepat 50 km masih valid");
    }
}
