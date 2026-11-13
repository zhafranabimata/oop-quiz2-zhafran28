package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbilityInterfaceTest {

    @Test
    @DisplayName("CarRide implements Insurable")
    void sub2ImplementsAbility() throws Throwable {
        Ride order = TestSupport.newStudentOrder("CarRide", "L1", 4);
        assertTrue(order instanceof Insurable,
                "CarRide harus implements Insurable");
    }

    @Test
    @DisplayName("insuranceFee() mengembalikan Rp 3.000")
    void abilityFee() throws Throwable {
        Insurable order = (Insurable) TestSupport.newStudentOrder("CarRide", "L1", 4);
        assertEquals(3000.0, order.insuranceFee(), 0.001,
                "insuranceFee() harus Rp 3.000, berapa pun jarak-nya");
    }

    @Test
    @DisplayName("Biaya asuransi perjalanan tidak bergantung pada jarak")
    void abilityFeeIsFixed() throws Throwable {
        Insurable small = (Insurable) TestSupport.newStudentOrder("CarRide", "L1", 1);
        Insurable large = (Insurable) TestSupport.newStudentOrder("CarRide", "L2", 10);
        assertEquals(small.insuranceFee(), large.insuranceFee(), 0.001,
                "Biaya asuransi perjalanan adalah tarif tetap Rp 3.000");
    }
}
