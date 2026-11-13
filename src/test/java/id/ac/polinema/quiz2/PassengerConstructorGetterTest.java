package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PassengerConstructorGetterTest {

    @Test
    @DisplayName("Constructor menyimpan kode dan nama, getter mengembalikannya")
    void constructorStoresValues() {
        Passenger entity = new Passenger("C001", "Budi Santoso");
        assertEquals("C001", entity.getPassengerId(),
                "getPassengerId() harus mengembalikan kode yang dikirim ke constructor");
        assertEquals("Budi Santoso", entity.getName(),
                "getName() harus mengembalikan nama yang dikirim ke constructor");
    }

    @Test
    @DisplayName("Dua objek menyimpan nilainya masing-masing")
    void eachObjectKeepsItsOwnValues() {
        Passenger a = new Passenger("C001", "Budi");
        Passenger b = new Passenger("C002", "Sari");
        assertEquals("Budi", a.getName(), "Field harus milik objek (bukan static)");
        assertEquals("C002", b.getPassengerId(), "Field harus milik objek (bukan static)");
    }
}
