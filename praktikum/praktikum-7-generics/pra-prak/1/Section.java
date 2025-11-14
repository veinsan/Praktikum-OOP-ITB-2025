import java.util.ArrayList;
import java.util.List;

public class Section<T extends Product> {
    private String name;
    private List<T> products;

    /*
     * TODO: Lengkapi implementasi konstruktor Section
     * Semua attribut diinisialisasi melalui konstruktor.
     * Attribut products diinisialisasi sebagai ArrayList kosong.
     */
    public Section(String name) {
        // TODO: Lengkapi implementasi method ini
        this.name = name;
        this.products = new ArrayList<>();
    }

    /*
     * TODO: Lengkapi implementasi method addProduct
     * Method ini akan menambahkan produk ke dalam list products
     */
    public void addProduct(T product) {
        // TODO: Lengkapi implementasi method ini
        products.add(product);
    }
    
    /*
     * TODO: Lengkapi implementasi method removeProduct
     * Method ini akan menghapus produk dari dalam list products
     * Jika produk tidak ditemukan, tampilkan pesan "Product not found"
     */
    public void removeProduct(T product) {
        // TODO: Lengkapi implementasi method ini
        if (products.contains(product)) {
            products.remove(product);
        } else {
            System.out.println("Product not found");
        }
    }

    /*
     * TODO: Lengkapi implementasi method getProducts
     * Method ini akan mengembalikan list produk yang ada di dalam section
     */
    public List<T> getProducts() {
        // TODO: Lengkapi implementasi method ini
        return products;
    }

    /*
     * TODO: Lengkapi implementasi method getName
     * Method ini akan mengembalikan nama dari section
     */
    public String getName() {
        // TODO: Lengkapi implementasi method ini
        return name;
    }

    /*
     * TODO: Lengkapi implementasi method getProductWithNameAndType
     * Method ini akan mengembalikan produk berdasarkan nama dan tipe produk
     * Jika produk tidak ditemukan, tampilkan pesan "Product not found".
     * Jika produk ditemukan, tampilkan representasi string dari produk tersebut dan kembalikan produk tersebut.
     */
    public T getProductWithNameAndType(String name, Class<? extends T> type) {
        // TODO: Lengkapi implementasi method ini
        for (T product : products) {
            if (product.getName().equals(name) && type.isInstance(product)) {
                System.out.println(product.toString());
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    /*
     * TODO: Lengkapi implementasi method getTotalValue
     * Method ini akan mengembalikan total nilai dari semua produk yang ada di dalam section
     */
    public double getTotalValue() {
        // TODO: Lengkapi implementasi method ini
        double total = 0;
        for (T product : products) {
            total += product.getPrice();
        }
        return total;
    }

    /*
     * TODO: Lengkapi implementasi method findCheapest
     * Method ini akan mencari produk dengan harga terendah dari dalam list
     */
    public static <U extends Product> U findCheapest(List<? extends U> list) {
        // TODO: Lengkapi implementasi method ini
        if (list.isEmpty()) {
            return null;
        }
        U cheapest = list.get(0);
        for (U product : list) {
            if (product.getPrice() < cheapest.getPrice()) {
                cheapest = product;
            }
        }
        return cheapest;
    }

    /*
     * TODO: Lengkapi implementasi method showProducts
     * Method ini akan menampilkan semua produk yang ada di dalam list.
     * Setiap produk ditampilkan dalam baris baru dengan menggunakan representasi string dari produk tersebut.
     */
    public static void showProducts(List<? extends Product> items) {
        // TODO: Lengkapi implementasi method ini
        for (Product item : items) {
        System.out.println(item.toString());
        }
    }
}