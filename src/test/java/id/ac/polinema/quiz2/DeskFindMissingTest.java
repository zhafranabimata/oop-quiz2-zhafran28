package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeskFindMissingTest {

    @Test
    @DisplayName("findById mengembalikan null bila kode tidak ada")
    void missingReturnsNull() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        desk.add(new TestSupport.TestOrder("L1", 2));
        assertNull(desk.findById("L9"), "Kode yang tidak ada harus menghasilkan null (jangan melempar exception)");
    }

    @Test
    @DisplayName("findById pada RideDispatcher kosong mengembalikan null")
    void emptyDeskReturnsNull() {
        RideDispatcher desk = new RideDispatcher(new TestSupport.RecordingPrinter());
        assertNull(desk.findById("L1"), "RideDispatcher kosong harus menghasilkan null");
    }
}
