package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeskOrderTest {

    @Test
    @DisplayName("getOrders mengembalikan daftar menurut urutan penambahan")
    void keepsInsertionOrder() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        desk.add(new TestSupport.TestOrder("L3", 1));
        desk.add(new TestSupport.TestOrder("L1", 1));
        desk.add(new TestSupport.TestOrder("L2", 1));
        List<Ride> orders = desk.getOrders();
        assertNotNull(orders, "getOrders() tidak boleh null");
        assertEquals(3, orders.size(), "getOrders() harus berisi tiga perjalanan");
        assertEquals("L3", orders.get(0).getRideId(), "Urutan pertama harus L3 (urutan penambahan)");
        assertEquals("L1", orders.get(1).getRideId(), "Urutan kedua harus L1");
        assertEquals("L2", orders.get(2).getRideId(), "Urutan ketiga harus L2");
    }

    @Test
    @DisplayName("getOrders pada RideDispatcher kosong mengembalikan daftar kosong")
    void emptyDeskGivesEmptyList() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        assertEquals(0, desk.getOrders().size(), "RideDispatcher kosong harus menghasilkan daftar kosong");
    }
}
