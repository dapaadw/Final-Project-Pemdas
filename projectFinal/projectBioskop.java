package projectFinal;
import java.util.Scanner;

public class projectBioskop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilihanTiket pilihan = new PilihanTiket();

        while (true) {
            System.out.println("Transmart XXI");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Daftar Kursi");
            System.out.println("3. Batalkan Pesanan Tiket");
            System.out.println("4. Riwayat Pesanan Tiket");
            System.out.println("5. Keluar");
            System.out.print("Masukkan opsi anda: ");

            int pil = sc.nextInt();
            sc.nextLine();

            switch (pil) {
                case 1:
                    pilihan.pesanTiket(sc);
                    break;
                case 2:
                    pilihan.lihatKursiTersedia();
                    break;
                case 3:
                    pilihan.batalTiket(sc);
                    break;
                case 4:
                    pilihan.riwayatTiket();
                    break;
                case 5:
                    System.out.println("Anda telah keluar dari sistem pesanan");
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}