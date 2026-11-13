package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeskPrintsNothingTest {

    @Test
    @DisplayName("RideDispatcher tidak mencetak apa pun ke layar sendiri")
    void deskPrintsNothing() throws Throwable {
        TestSupport.RecordingPrinter printer = new TestSupport.RecordingPrinter();
        RideDispatcher desk = new RideDispatcher(printer);
        String output = TestSupport.captureOut(() -> {
            desk.add(new TestSupport.TestOrder("L1", 2));
            desk.checkout("L1");
            desk.findById("L1");
        });
        assertEquals(1, printer.ids.size(),
                "checkout harus menyerahkan pekerjaan mencatat ke PaymentMethod (tidak boleh dibiarkan kosong)");
        assertEquals("", output,
                "RideDispatcher tidak boleh memakai System.out: tugas mencatat milik PaymentMethod");
    }
}
