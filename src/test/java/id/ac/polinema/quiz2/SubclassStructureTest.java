package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** BikeRide dan CarRide belum ada di kode awal, jadi dicari lewat reflection. */
class SubclassStructureTest {

    @Test
    @DisplayName("Kelas BikeRide ada dan extends Ride")
    void sub1ExtendsBase() {
        Class<?> c = TestSupport.loadClass("BikeRide");
        assertTrue(Ride.class.isAssignableFrom(c) && c != Ride.class,
                "BikeRide harus extends Ride");
    }

    @Test
    @DisplayName("Kelas CarRide ada dan extends Ride")
    void sub2ExtendsBase() {
        Class<?> c = TestSupport.loadClass("CarRide");
        assertTrue(Ride.class.isAssignableFrom(c) && c != Ride.class,
                "CarRide harus extends Ride");
    }

    @Test
    @DisplayName("Kedua subclass bukan kelas abstrak (objeknya bisa dibuat)")
    void subclassesAreConcrete() {
        assertFalse(Modifier.isAbstract(TestSupport.loadClass("BikeRide").getModifiers()),
                "BikeRide tidak boleh abstract: method calculateFare() harus diisi");
        assertFalse(Modifier.isAbstract(TestSupport.loadClass("CarRide").getModifiers()),
                "CarRide tidak boleh abstract: method calculateFare() harus diisi");
    }

    @Test
    @DisplayName("Constructor (rideId, Passenger, distanceKm) meneruskan kode ke superclass")
    void constructorPassesToSuper() throws Throwable {
        Ride a = TestSupport.newStudentOrder("BikeRide", "L1", 5);
        Ride b = TestSupport.newStudentOrder("CarRide", "L2", 3);
        assertEquals("L1", a.getRideId(), "Panggil super(...) di constructor BikeRide");
        assertEquals(3.0, b.getDistanceKm(), 0.001, "Panggil super(...) di constructor CarRide");
    }
}
