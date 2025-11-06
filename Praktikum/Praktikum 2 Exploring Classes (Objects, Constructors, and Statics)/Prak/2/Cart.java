import java.util.ArrayList;

public class Cart {
    // TODO: Deklarasikan list products untuk menyimpan Product (Gunakan ArrayList)
    // TODO: Deklarasikan atribut totalPrice (double)
    private double totalPrice;
    private ArrayList<Product> products;
    // TODO: Constructor cart untuk inisialisasi list dengan list kosong dan totalPrice dengan 0.0
    Cart() {
        products = new ArrayList<>();
        totalPrice = 0;
    }
    
    // TODO: Buat method addProduct(Product p) untuk menambah produk ke list & tambah totalPrice dengan harga produk
    public void addProduct(Product p) {
        if (p != null){
            products.add(p);
            totalPrice += p.getPrice();
        }
    }

    // TODO: Buat method getTotalPrice() untuk mendapatkan totalPrice
    public double getTotalPrice() {
        return this.totalPrice;
    }

    // TODO: Buat method showCart() untuk menampilkan isi cart & total harga
    // Case 1 (jika keranjang kosong):
    // Isi Keranjang:
    // (Kosong)

    // Case 2 (jika keranjang ada isinya):
    // Isi Keranjang:
    // - Nama Produk 1 : Harga Produk 1
    // - Nama Produk 2 : Harga Produk 2
    // Total harga: totalPrice
    
    // Hint : Manfaatkan method toString() dari class Product
    public void showCart() {
        if (products.isEmpty()){
            System.out.println("Isi Keranjang:");
            System.out.println("(Kosong)");
        }
        else{
            System.out.println("Isi Keranjang:");
            for (Product p : products){
                System.out.println(p.toString());
            }
            System.out.println("Total harga: " + this.totalPrice);
        }
    }

    // TODO: Buat method clearCart() untuk mengosongkan list products dan reset totalPrice ke 0.0
    public void clearCart() {
        products.clear();
        totalPrice = 0.0;
    }
}