import java.util.ArrayList;
import java.util.List;

/**
 * Kelas utama untuk menjalankan aplikasi pemesanan makanan di restoran.
 */
public class Main {

    /**
     * Kelas MenuItem merepresentasikan item makanan atau minuman di menu restoran.
     */
    public static class MenuItem {
        private String name;
        private double price;

        /**
         * Constructor untuk kelas MenuItem.
         *
         * @param name  Nama item menu.
         * @param price Harga item menu.
         */
        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        /**
         * Mendapatkan nama item menu.
         *
         * @return Nama item menu.
         */
        public String getName() {
            return name;
        }

        /**
         * Mendapatkan harga item menu.
         *
         * @return Harga item menu.
         */
        public double getPrice() {
            return price;
        }

        /**
         * Mendapatkan informasi item menu dalam bentuk string.
         *
         * @return Informasi item berupa nama dan harga.
         */
        public String getItemInfo() {
            return name + ": Rp " + price;
        }
    }

    /**
     * Kelas Order mengelola daftar pesanan yang terdiri dari beberapa item menu.
     */
    public static class Order {
        private List<OrderItem> items;

        /**
         * Constructor untuk kelas Order.
         * Inisialisasi daftar item pesanan sebagai ArrayList kosong.
         */
        public Order() {
            items = new ArrayList<>();
        }

        /**
         * Menambahkan item menu ke pesanan dengan jumlah yang ditentukan.
         *
         * @param item     Objek MenuItem yang ingin ditambahkan ke pesanan.
         * @param quantity Jumlah item yang dipesan.
         */
        public void addItem(MenuItem item, int quantity) {
            items.add(new OrderItem(item, quantity));
        }

        /**
         * Menghitung total harga dari semua item yang dipesan.
         *
         * @return Total harga pesanan.
         */
        public double calculateTotal() {
            double total = 0;
            for (OrderItem orderItem : items) {
                total += orderItem.getItem().getPrice() * orderItem.getQuantity();
            }
            return total;
        }
        public double calculateTotal() {
                    double total = 0;
                    for (OrderItem orderItem : items) {
                        total += orderItem.getItem().getPrice() * orderItem.getQuantity();
                    }
                    return total;
                }

        /**
         * Mencetak nota pesanan ke console dengan menampilkan semua item yang dipesan
         * beserta total harga.
         */
        public void generateReceipt() {
            System.out.println("=== Nota Pemesanan Makanan ===");
            for (OrderItem orderItem : items) {
                MenuItem item = orderItem.getItem();
                int quantity = orderItem.getQuantity();
                double totalPrice = item.getPrice() * quantity;
                System.out.println(item.getName() + " x" + quantity + " - Rp " + totalPrice);
            }
            System.out.println("===============================");
            System.out.println("Total: Rp " + calculateTotal());
        }
    }




    /**
     * Kelas OrderItem merupakan representasi dari item yang dipesan di dalam Order.
     */
    public static class OrderItem {
        private MenuItem item;
        private int quantity;

        /**
         * Constructor untuk kelas OrderItem.
         *
         * @param item     Objek MenuItem yang dipesan.
         * @param quantity Jumlah item yang dipesan.
         */
        public OrderItem(MenuItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        /**
         * Mendapatkan item menu yang dipesan.
         *
         * @return Objek MenuItem yang dipesan.
         */
        public MenuItem getItem() {
            return item;
        }

        /**
         * Mendapatkan jumlah item yang dipesan.
         *
         * @return Jumlah item yang dipesan.
         */
        public int getQuantity() {
            return quantity;
        }
    }

    /**
     * Metode utama untuk menjalankan aplikasi.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        // Buat item menu
        MenuItem nasiGoreng = new MenuItem("Nasi Goreng", 20000);
        MenuItem ayamGoreng = new MenuItem("Ayam Goreng", 15000);
        MenuItem esTeh = new MenuItem("Es Teh", 5000);

        // Buat pesanan
        Order pesanan = new Order();
        pesanan.addItem(nasiGoreng, 2);  // Pesan 2 Nasi Goreng
        pesanan.addItem(ayamGoreng, 1);   // Pesan 1 Ayam Goreng
        pesanan.addItem(esTeh, 3);        // Pesan 3 Es Teh

        // Cetak nota pesanan
        pesanan.generateReceipt();

    }
}