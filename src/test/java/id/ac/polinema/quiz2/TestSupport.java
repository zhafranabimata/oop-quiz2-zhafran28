package id.ac.polinema.quiz2;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pembantu untuk semua tes. Tahap 3 sampai 5 memakai kelas buatan tes sendiri
 * (bukan kelas buatanmu), jadi satu tahap yang macet tidak menggagalkan
 * tahap lain.
 */
final class TestSupport {

    private TestSupport() {
    }

    /** Mencari kelas buatan siswa lewat reflection. */
    static Class<?> loadClass(String name) {
        try {
            return Class.forName("id.ac.polinema.quiz2." + name);
        } catch (ClassNotFoundException e) {
            return fail("Kelas " + name + " belum dibuat. Buat kelas ini di src/main/java sesuai diagram kelas di README.");
        }
    }

    /** Membuat objek subclass buatan siswa (entitas diisi null, tidak dipakai). */
    static Ride newStudentOrder(String className, String id, double distanceKm) throws Throwable {
        Class<?> c = loadClass(className);
        Constructor<?> k;
        try {
            k = c.getConstructor(String.class, Passenger.class, double.class);
        } catch (NoSuchMethodException e) {
            return fail("Constructor " + className + "(String, Passenger, double) tidak ditemukan. Lihat diagram kelas di README.");
        }
        try {
            return (Ride) k.newInstance(id, null, distanceKm);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        } catch (ClassCastException e) {
            return fail(className + " harus extends Ride.");
        }
    }

    /** Menjalankan aksi dan mengembalikan semua yang tercetak ke layar. */
    static String captureOut(Action action) throws Throwable {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }

    interface Action {
        void run() throws Throwable;
    }

    /** Subclass buatan tes: tarif = jarak x 1000. */
    static class TestOrder extends Ride {
        TestOrder(String id, double distanceKm) {
            super(id, null, distanceKm);
        }

        @Override
        public double calculateFare() {
            return getDistanceKm() * 1000;
        }
    }

    /** Subclass buatan tes dengan kemampuan asuransi perjalanan (biaya 500). */
    static class TestAbilityOrder extends Ride implements Insurable {
        TestAbilityOrder(String id, double distanceKm) {
            super(id, null, distanceKm);
        }

        @Override
        public double calculateFare() {
            return getDistanceKm() * 1000;
        }

        @Override
        public double insuranceFee() {
            return 500;
        }
    }

    /** Jenis baru yang tidak dikenal siswa: dipakai untuk uji OCP dan LSP. */
    static class ScooterRide extends Ride {
        ScooterRide(String id, double distanceKm) {
            super(id, null, distanceKm);
        }

        @Override
        public double calculateFare() {
            return getDistanceKm() * 2000;
        }
    }

    /** Jenis yang tarif-nya selalu 0: dipakai untuk uji LSP. */
    static class FreeOrder extends Ride {
        FreeOrder(String id, double distanceKm) {
            super(id, null, distanceKm);
        }

        @Override
        public double calculateFare() {
            return 0;
        }
    }

    /** metode pembayaran palsu yang mencatat setiap pemanggilan. */
    static class RecordingPrinter implements PaymentMethod {
        final List<String> ids = new ArrayList<>();
        final List<Double> amounts = new ArrayList<>();

        @Override
        public void pay(String rideId, double amount) {
            ids.add(rideId);
            amounts.add(amount);
        }
    }
}
