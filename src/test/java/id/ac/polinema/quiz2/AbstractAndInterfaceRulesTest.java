package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractAndInterfaceRulesTest {

    @Test
    @DisplayName("Ride tetap kelas abstrak")
    void baseStaysAbstract() {
        assertTrue(Modifier.isAbstract(Ride.class.getModifiers()),
                "Ride harus tetap abstract: objek perjalanan umum tidak masuk akal");
    }

    @Test
    @DisplayName("Insurable tetap interface kecil dengan satu method")
    void abilityIsSmallInterface() {
        assertTrue(Insurable.class.isInterface(), "Insurable harus tetap interface");
        assertEquals(1, Insurable.class.getDeclaredMethods().length,
                "Insurable harus kecil dan fokus: satu method saja");
    }

    @Test
    @DisplayName("BikeRide TIDAK implements Insurable")
    void sub1DoesNotImplementAbility() throws Throwable {
        Ride order = TestSupport.newStudentOrder("BikeRide", "L1", 3);
        assertFalse(order instanceof Insurable,
                "BikeRide tidak punya asuransi perjalanan, jadi tidak boleh implements Insurable");
    }

    @Test
    @DisplayName("Hanya CarRide yang implements Insurable")
    void onlySub2ImplementsAbility() throws Throwable {
        Ride order = TestSupport.newStudentOrder("CarRide", "L1", 3);
        assertTrue(order instanceof Insurable, "CarRide harus implements Insurable");
    }
}
