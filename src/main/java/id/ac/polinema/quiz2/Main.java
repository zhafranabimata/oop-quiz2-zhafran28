package id.ac.polinema.quiz2;

import java.util.ArrayList;
import java.util.List;

/**
 * Tempat bebas untuk mencoba programmu. Kelas ini TIDAK dinilai.
 *
 * Ide percobaan (tulis sendiri setelah tiap tahap selesai):
 *  1. Buat satu Passenger, lalu coba ubah namanya.
 *  2. Buat satu BikeRide dan satu CarRide, lalu tampilkan tarif-nya.
 *  3. Masukkan keduanya ke RideCalculator.totalFare(...) lewat sebuah List.
 *  4. Buat RideDispatcher dengan new CashPayment(), tambahkan perjalanan, lalu panggil checkout(...).
 *
 * Jalankan lewat NetBeans (Run Project), VS Code (Run di atas main),
 * atau terminal: mvn -q compile exec:java
 */
public class Main {

    public static void main(String[] args) {
        Passenger passenger = new Passenger("P1", "Alya");
        System.out.println("Penumpang: " + passenger.getName() + " - ID85 " + passenger.getPassengerId() );
        passenger.setName("Alya Putri");
        passenger.setName("   ");
        System.out.println("Nama baru: " + passenger.getName()); 
    
        Ride bike = new BikeRide("R1", passenger, 5.0);
        Ride car = new CarRide("R2", passenger, 10.0);
        System.out.println("Tarif motor " + bike.getRideId() + ": Rp " + bike.calculateFare());
        System.out.println("Tarif mobil " + car.getRideId() + ": Rp " + car.calculateFare());

        List<Ride> orders = new ArrayList<>();
        orders.add(bike);
        orders.add(car);
        System.out.println("Total tarif: Rp " + RideCalculator.totalFare(orders));
        System.out.println("Total biaya asuransi: Rp " + RideCalculator.totalInsurance(orders));

        Ride bike3 = new BikeRide("03", passenger, 55.0);
        System.out.println("ID dapat diterima? " + RideCalculator.isAcceptable(bike3));

        RideDispatcher dispatcher = new RideDispatcher(new CashPayment());
        dispatcher.add(bike);
        dispatcher.add(car);
        System.out.println("Jumlah perjalanan: " + dispatcher.count());
        dispatcher.checkout("R1");
        dispatcher.checkout("R2");

    }
}
