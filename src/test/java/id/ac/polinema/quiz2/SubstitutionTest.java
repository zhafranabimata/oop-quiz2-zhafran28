package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubstitutionTest {

    @Test
    @DisplayName("Setiap subclass Ride bisa menggantikan Ride di RideDispatcher")
    void anySubclassWorks() {
        TestSupport.RecordingPrinter printer = new TestSupport.RecordingPrinter();
        RideDispatcher desk = new RideDispatcher(printer);
        Ride a = new TestSupport.TestOrder("A", 3);
        Ride b = new TestSupport.TestAbilityOrder("B", 2);
        Ride c = new TestSupport.FreeOrder("C", 7);
        Ride d = new TestSupport.ScooterRide("D", 1);
        List<Ride> all = List.of(a, b, c, d);
        for (Ride order : all) {
            desk.add(order);
        }
        for (Ride order : all) {
            desk.checkout(order.getRideId());
        }
        assertEquals(4, printer.ids.size(), "Semua jenis harus bisa di-checkout dengan cara yang sama");
        for (int i = 0; i < all.size(); i++) {
            assertEquals(all.get(i).calculateFare(), printer.amounts.get(i), 0.001,
                    "Jumlah untuk " + all.get(i).getRideId() + " harus sama dengan calculateFare() miliknya");
        }
    }

    @Test
    @DisplayName("totalFare memperlakukan semua jenis sama")
    void totalTreatsAllKindsAlike() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        desk.add(new TestSupport.TestOrder("A", 3));
        desk.add(new TestSupport.FreeOrder("C", 7));
        desk.add(new TestSupport.ScooterRide("D", 1));
        assertEquals(3000.0 + 0.0 + 2000.0, RideCalculator.totalFare(desk.getOrders()), 0.001,
                "Subclass dengan tarif 0 tetap harus ikut diproses tanpa error");
    }
}
