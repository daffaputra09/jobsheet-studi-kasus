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
        String tingkat, tahun;

        System.out.print("Masukkan Nama Mahasiswa: ");
        prestasiList[jumlahPrestasi][0] = scanner.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        prestasiList[jumlahPrestasi][1] = scanner.nextLine();

        System.out.print("Masukkan Jenis Prestasi: ");
        prestasiList[jumlahPrestasi][2] = scanner.nextLine();

        do {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();

            if (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional")) {
                System.out.println("Input tidak valid. Masukkan kembali tingkat prestasi.");
            }

        } while (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional"));

        prestasiList[jumlahPrestasi][3] = tingkat;

        do {
            System.out.print("Masukkan Tahun Prestasi (2010 hingga tahun saat ini): ");
            tahun = scanner.nextLine();

            if (Integer.parseInt(tahun) < 2010 || Integer.parseInt(tahun) > 2024) {
                System.out.println("Input tidak valid. Masukkan kembali tahun prestasi.");
            }

        } while (Integer.parseInt(tahun) < 2010 || Integer.parseInt(tahun) > 2024);
        
        prestasiList[jumlahPrestasi][4] = tahun;

        jumlahPrestasi++;
        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    static void tampilkanSemuaPrestasi() {
        if (jumlahPrestasi == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("\n=== DAFTAR PRESTASI MAHASISWA ===");
            for (int i = 0; i < jumlahPrestasi; i++) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s%n",
                prestasiList[i][0], prestasiList[i][1], prestasiList[i][2], prestasiList[i][3], prestasiList[i][4]);
            }
        }
    }

    static void analisisPrestasi() {

    }
}
