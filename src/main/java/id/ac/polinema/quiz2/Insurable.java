package id.ac.polinema.quiz2;

/**
 * INTERFACE untuk kemampuan tambahan: asuransi perjalanan. Kelas ini SUDAH
 * LENGKAP, jangan diubah.
 *
 * Hanya sebagian jenis perjalanan yang bisa melakukannya, jadi
 * kemampuan ini dijadikan interface kecil tersendiri.
 */
public interface Insurable {

    /**
     * @return biaya asuransi perjalanan dalam Rupiah
     */
    double insuranceFee();
}
