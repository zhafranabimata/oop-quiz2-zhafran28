package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoConcretePrinterTest {

    @Test
    @DisplayName("RideDispatcher tidak punya field bertipe kelas konkret CashPayment")
    void noConcreteField() {
        for (Field f : RideDispatcher.class.getDeclaredFields()) {
            assertFalse(CashPayment.class.isAssignableFrom(f.getType()),
                    "Field '" + f.getName() + "' tidak boleh bertipe CashPayment: pakai interface PaymentMethod");
        }
    }

    @Test
    @DisplayName("Field PaymentMethod tidak static: tiap RideDispatcher memakai metode pembayaran-nya sendiri")
    void printerFieldIsNotStatic() {
        for (Field f : RideDispatcher.class.getDeclaredFields()) {
            assertFalse(Modifier.isStatic(f.getModifiers()) && PaymentMethod.class.isAssignableFrom(f.getType()),
                    "Field '" + f.getName() + "' tidak boleh static: tiap RideDispatcher menyimpan objek dari constructor-nya");
        }
    }

    @Test
    @DisplayName("Dua RideDispatcher memakai metode pembayaran masing-masing")
    void twoDesksUseTheirOwnPrinters() {
        TestSupport.RecordingPrinter one = new TestSupport.RecordingPrinter();
        TestSupport.RecordingPrinter two = new TestSupport.RecordingPrinter();
        RideDispatcher deskOne = new RideDispatcher(one);
        RideDispatcher deskTwo = new RideDispatcher(two);
        deskOne.add(new TestSupport.TestOrder("L1", 1));
        deskTwo.add(new TestSupport.TestOrder("L2", 1));
        deskOne.checkout("L1");
        deskTwo.checkout("L2");
        assertEquals("L1", one.ids.get(0), "Objek PaymentMethod pertama hanya boleh menerima L1");
        assertEquals("L2", two.ids.get(0), "Objek PaymentMethod kedua hanya boleh menerima L2");
        assertEquals(1, one.ids.size(), "Objek PaymentMethod pertama menerima tepat satu panggilan");
    }
}
