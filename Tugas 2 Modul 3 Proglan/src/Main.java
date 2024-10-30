import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas untuk merepresentasikan menu di Warung Makan.
 */
class Menu {
    private String nama;
    private int harga;

    /**
     * Konstruktor untuk membuat menu dengan nama dan harga tertentu.
     *
     * @param nama  Nama dari menu
     * @param harga Harga dari menu
     */
    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * Mengambil nama menu.
     *
     * @return nama menu
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil harga menu.
     *
     * @return harga menu
     */
    public int getHarga() {
        return harga;
    }
}

/**
 * Kelas untuk merepresentasikan pesanan yang dilakukan di Warung Makan.
 */
class Pesanan {
    private Menu menu;
    private int jumlah;

    /**
     * Konstruktor untuk membuat pesanan dengan menu dan jumlah tertentu.
     *
     * @param menu   Menu yang dipesan
     * @param jumlah Jumlah pesanan
     */
    public Pesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    /**
     * Menghitung total harga untuk pesanan.
     *
     * @return total harga pesanan
     */
    public int hitungTotalHarga() {
        return menu.getHarga() * jumlah;
    }

    /**
     * Mendapatkan nama menu yang dipesan.
     *
     * @return nama menu yang dipesan
     */
    public String getNamaMenu() {
        return menu.getNama();
    }

    /**
     * Mendapatkan jumlah dari pesanan.
     *
     * @return jumlah pesanan
     */
    public int getJumlah() {
        return jumlah;
    }
}

/**
 * Kelas untuk mengelola daftar menu dan pesanan di Warung Makan.
 */
class WarungMakan {
    private ArrayList<Menu> daftarMenu = new ArrayList<>();
    private ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

    /**
     * Menambahkan menu baru ke daftar menu.
     *
     * @param nama  Nama dari menu
     * @param harga Harga dari menu
     */
    public void tambahMenu(String nama, int harga) {
        daftarMenu.add(new Menu(nama, harga));
    }

    /**
     * Menampilkan daftar menu di Warung Makan.
     */
    public void tampilkanMenu() {
        System.out.println("=== Menu Warung Makan ===");
        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu menu = daftarMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getNama() + " - Rp " + menu.getHarga());
        }
    }

    /**
     * Membuat pesanan berdasarkan nomor menu dan jumlah yang diinginkan.
     *
     * @param nomorMenu Nomor dari menu yang dipilih
     * @param jumlah    Jumlah pesanan
     */
    public void buatPesanan(int nomorMenu, int jumlah) {
        Menu menu = daftarMenu.get(nomorMenu - 1);
        daftarPesanan.add(new Pesanan(menu, jumlah));
    }

    /**
     * Menampilkan daftar pesanan yang dibuat dan total harga.
     */
    public void tampilkanPesanan() {
        int totalBayar = 0;
        System.out.println("\n=== Daftar Pesanan ===");
        for (Pesanan pesanan : daftarPesanan) {
            int totalHarga = pesanan.hitungTotalHarga();
            totalBayar += totalHarga;
            System.out.println(pesanan.getNamaMenu() + " - Jumlah: " + pesanan.getJumlah() + " - Total Harga: Rp " + totalHarga);
        }
        System.out.println("Total pembayaran: Rp " + totalBayar);
    }
}

/**
 * Kelas utama untuk menjalankan aplikasi Warung Makan.
 */
class WarungMakanSetelahRefactor {
    /**
     * Metode utama untuk menjalankan aplikasi, termasuk menambahkan menu, menerima
     * pesanan, dan menampilkan pesanan.
     *
     * @param args Argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarungMakan warung = new WarungMakan();

        // Tambah Menu
        warung.tambahMenu("Nasi Goreng", 15000);
        warung.tambahMenu("Mie Goreng", 13000);
        warung.tambahMenu("Ayam Bakar", 20000);

        // Tampilkan Menu
        warung.tampilkanMenu();

        // Proses Pemesanan
        while (true) {
            System.out.print("Masukkan nomor menu yang dipesan (0 untuk selesai): ");
            int nomorMenu = scanner.nextInt();
            if (nomorMenu == 0) break;

            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = scanner.nextInt();
            warung.buatPesanan(nomorMenu, jumlah);
        }

        // Tampilkan Pesanan
        warung.tampilkanPesanan();
        scanner.close();
    }
}
