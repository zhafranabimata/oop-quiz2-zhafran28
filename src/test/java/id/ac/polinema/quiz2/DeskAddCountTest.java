package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeskAddCountTest {

    @Test
    @DisplayName("RideDispatcher baru berisi 0 perjalanan")
    void newDeskIsEmpty() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        assertEquals(0, desk.count(), "RideDispatcher yang baru dibuat harus kosong");
    }

    @Test
    @DisplayName("add menambah jumlah perjalanan")
    void addIncreasesCount() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        desk.add(new TestSupport.TestOrder("L1", 2));
        desk.add(new TestSupport.TestOrder("L2", 3));
        assertEquals(2, desk.count(), "Setelah dua kali add, count() harus 2");
    }
}
