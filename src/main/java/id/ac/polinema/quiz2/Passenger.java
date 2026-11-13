package id.ac.polinema.quiz2;

/**
 * TAHAP 1 (pemanasan): penumpang yang membuat pesanan.
 *
 * Lengkapi setiap method (ganti baris
 * {@code throw new UnsupportedOperationException(...)} dengan kode yang benar).
 * Jangan mengubah nama kelas, nama method, atau signature-nya.
 *
 * Deklarasikan sendiri field-nya sesuai diagram kelas di README.
 * Semua field harus private.
 */
public class Passenger {

    /**
     * Menyimpan kedua parameter ke field.
     *
     * @param passengerId kode penumpang
     * @param name nama penumpang
     */
    private String passengerId;
    private String name;
    public Passenger(String passengerId, String name) {
        this.passengerId = passengerId;
        this.name = name;

    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    /**
     * Mengubah nama. Nama yang null atau kosong (hanya spasi) tidak valid:
     * abaikan dan biarkan nama lama tetap.
     *
     * @param name nama baru
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        this.name = name;
    }
}
