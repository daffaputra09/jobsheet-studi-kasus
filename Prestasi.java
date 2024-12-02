import java.util.Scanner;

public class Prestasi {
    static int jumlahPrestasi = 0;
    static Scanner scanner = new Scanner(System.in);
    
    static String[][] prestasiList = new String[100][5];
    // DOKUMENTASI KOLOM ARRAY
    // 0 = Nama
    // 1 = NIM
    // 2 = Jenis Prestasi
    // 3 = Tingkat Prestasi
    // 4 = Tahun Prestasi


    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n===== MENU PRESTASI =====");
            System.out.println("1. Tambah Prestasi Mahasiswa");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    tambahPrestasi();
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
                    break;
                case 4:
                    System.out.println("\n===== PROGRAM SELESAI. TERIMA KASIH! =====\n");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan coba lagi.\n");
                    break;
            }
        } while (pilihan != 4);
    }

    static void tambahPrestasi() {
        String nama, nim, jenis, tingkat;
        int tahun;

        System.out.print("Masukkan Nama Mahasiswa: ");
        nama = scanner.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        nim = scanner.nextLine();

        System.out.print("Masukkan Jenis Prestasi: ");
        jenis = scanner.nextLine();

        do {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();

            if (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional")) {
                System.out.println("Input tidak valid. Masukkan kembali tingkat prestasi.");
            }

        } while (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional"));

        do {
            System.out.print("Masukkan Tahun Prestasi (2010 hingga tahun saat ini): ");
            tahun = scanner.nextInt();

            if (tahun < 2010 || tahun > 2024) {
                System.out.println("Input tidak valid. Masukkan kembali tahun prestasi.");
            }

        } while (tahun < 2010 || tahun > 2024);
        
        prestasiList[jumlahPrestasi][0] = nama;
        prestasiList[jumlahPrestasi][1] = nim;
        prestasiList[jumlahPrestasi][2] = jenis;
        prestasiList[jumlahPrestasi][3] = tingkat;
        prestasiList[jumlahPrestasi][4] = String.valueOf(tahun);

        jumlahPrestasi++;
        System.out.println("\n===== DATA PRESTASI BERHASIL DITAMBAHKAN =====\n");
    }

    static void tampilkanSemuaPrestasi() {
        if (jumlahPrestasi == 0) {
            System.out.println("\n===== BELUM ADA DATA PRESTASI =====\n");
        } else {
            System.out.println("\n=== DAFTAR PRESTASI MAHASISWA ===");
            for (int i = 0; i < jumlahPrestasi; i++) {
                System.out.println("Nama: " + prestasiList[i][0] + " | NIM: " + prestasiList[i][1] + " | Jenis: " + prestasiList[i][2] + " | Tingkat: " + prestasiList[i][3] + " | Tahun: " + prestasiList[i][4]);
            }
        }
    }

    static void analisisPrestasi() {
        System.out.print("Masukkan Jenis Prestasi untuk Analisis: ");
        String jenisAnalisis = scanner.nextLine();
        boolean ditemukan = false;

        System.out.println("\n=== ANALISIS PRESTASI ===\n");
        for (int i = 0; i < jumlahPrestasi; i++) {
            if (prestasiList[i][2].equalsIgnoreCase(jenisAnalisis)) {
                System.out.println("Nama: " + prestasiList[i][0] + " | NIM: " + prestasiList[i][1] + " | Tingkat: " + prestasiList[i][3] + " | Tahun: " + prestasiList[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("===== TIDAK ADA DATA PRESTASI DENGAN JENIS TERSEBUT =====");
        }
    }
}
