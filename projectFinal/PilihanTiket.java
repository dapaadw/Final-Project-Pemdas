package projectFinal;

import java.util.Scanner;

public class PilihanTiket {
    public static final int totalBaris = 4;
    public static final int totalKolom = 5;
    public static final int maxRiwayat = 300;
    public static String[] riwayatPesanan = new String[maxRiwayat];
    public static String[][] kursi = new String[totalBaris][totalKolom];
    public static int jumlahPesanan = 0;

    
    public PilihanTiket() {
        for (int i = 0; i < totalBaris; i++) {
            for (int j = 0; j < totalKolom; j++) {
                kursi[i][j] = (char) ('A' + i) + "" + (j + 1);
            }
        }
    }

    public void pesanTiket(Scanner sc) {
        lihatKursiTersedia();
        System.out.print("Pilih kursi yang ingin dipesan (Misal: A1): ");
        String nomorKursi = sc.nextLine();
        nomorKursi = nomorKursi.toUpperCase();
    
        for (int i = 0; i < totalBaris; i++) {
            for (int j = 0; j < totalKolom; j++) {
                if (kursi[i][j].equals(nomorKursi + "(X)")) {
                    System.out.println("Mohon maaf, kursi ini sudah dipesan");
                    return;
                }
                if (kursi[i][j].equals(nomorKursi)) { 
                    kursi[i][j] = nomorKursi + "(X)";
                    tambahRiwayat("Pemesanan kursi " + nomorKursi);
                    System.out.println("Tiket telah dipesan dengan nomor kursi " + nomorKursi);
                    return;
                }
            }
        }
        System.out.println("Nomor kursi tidak valid, mohon untuk mencoba lagi");
        System.out.println("==================================");
    }
    
    public void lihatKursiTersedia() {
        System.out.println("Daftar Kursi: ");
        for (int i = 0; i < totalBaris; i++) {
            for (int j = 0; j < totalKolom; j++) {
                System.out.print(kursi[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("==================================");
    }

    public void batalTiket(Scanner sc) {
        lihatKursiTersedia();
        System.out.print("Masukkan nomor kursi yang ingin dibatalkan (Misal: B2): ");
        String nomorKursi = sc.nextLine();
        nomorKursi = nomorKursi.toUpperCase();

        if (nomorKursi.isEmpty()) {
            System.out.println("Nomor kursi tidak boleh kosong");
            return;
        }
        
        for (int i = 0; i < totalBaris; i++) {
            for (int j = 0; j < totalKolom; j++) {
                if (kursi[i][j].equals(nomorKursi + "(X)")) {
                    kursi[i][j] = nomorKursi;
                    tambahRiwayat("Pembatalan untuk kursi " + nomorKursi);
                    System.out.println("Pesanan untuk nomor kursi " + nomorKursi + " telah dibatalkan");
                    return;
                }
                if (kursi[i][j].equals(nomorKursi)) {
                    System.out.println("Kursi " + nomorKursi + " belum dipesan");
                    return;
                }
            }
        }
        System.out.println("Nomor kursi tersebut tidak ditemukan");
        System.out.println("==================================");
    }

    public void riwayatTiket() {
        if (jumlahPesanan == 0) {
            System.out.println("Tidak ada riwayat pesanan");
        } else {
            for (int i = 0; i < jumlahPesanan; i++) {
                System.out.println(i + 1 + ". " + riwayatPesanan[i]);
            }
        }
        System.out.println("==================================");
    }

    public void tambahRiwayat(String riwayat) {
        if (jumlahPesanan < maxRiwayat) {
            riwayatPesanan[jumlahPesanan] = riwayat;
            jumlahPesanan++;
        } else {
            System.out.println("Riwayat penuh");
        }
    }
}
