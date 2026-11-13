package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeskInterfaceTest {

    @Test
    @DisplayName("RideDispatcher menyimpan metode pembayaran di field bertipe interface PaymentMethod")
    void holdsPrinterAsInterface() {
        boolean found = false;
        for (Field f : RideDispatcher.class.getDeclaredFields()) {
            if (f.getType() == PaymentMethod.class) {
                found = true;
            }
        }
        assertTrue(found,
                "Simpan objek dari constructor di field bertipe PaymentMethod (interface), bukan CashPayment");
    }

    @Test
    @DisplayName("Field PaymentMethod bersifat private")
    void printerFieldIsPrivate() {
        for (Field f : RideDispatcher.class.getDeclaredFields()) {
            if (f.getType() == PaymentMethod.class) {
                assertTrue(Modifier.isPrivate(f.getModifiers()), "Field '" + f.getName() + "' harus private");
            }
        }
    }
}
