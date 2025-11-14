import java.util.*;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    // Inisialisasi atribut collection dengan parameter yang diterima
    public SuperCollection(List<Integer> collection) {
        this.collection = collection;
    }

    // TODO: Buat method partitionByCondition(int threshold)
    // Pisahkan collection menjadi dua grup: element <= threshold dan element > threshold
    // Return List<List<Integer>> dimana:
    // - Index 0 berisi element <= threshold
    // - Index 1 berisi element > threshold
    //
    // HINT:
    // - Perlu membuat struktur data untuk menampung dua kelompok element
    // - Gunakan loop untuk mengiterasi collection dan kondisi untuk memisahkan
    public List<List<Integer>> partitionByCondition(int threshold) {
        List<Integer> lessOrEqual = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int element : collection) {
            if (element<=threshold) {
                lessOrEqual.add(element);
            } else{
                greater.add(element);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(lessOrEqual);
        result.add(greater);
        return result;
    }
    
    // TODO: Buat method findTopN(int n)
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    //
    // HINT:
    // - Collection asli tidak boleh dimodifikasi
    // - Pertimbangkan cara mengurutkan List dalam urutan terbalik
    // - Collections class memiliki method utility yang berguna
    public List<Integer> findTopN(int n) {
        List<Integer> copyCollection = new ArrayList<>(collection);
        Collections.sort(copyCollection, Collections.reverseOrder());
        
        return copyCollection.size() <= n ? copyCollection : copyCollection.subList(0, n);
    }

    // TODO: Buat method runningSum()
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    //
    // HINT:
    // - Perlu menyimpan state (akumulasi) saat iterasi
    // - Setiap element dalam result adalah hasil penjumlahan sampai index tersebut
    public List<Integer> runningSum() {
        List<Integer> result = new ArrayList<>();
        int sum = 0;

        for (int element : collection) {
            sum += element;
            result.add(sum);
        }
        return result;
    }

    // TODO: Buat method findPairsWithSum(int targetSum)
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    //
    // HINT:
    // - Perlu mengecek setiap kemungkinan pasangan element
    // - Bagaimana cara menghindari duplikat seperti "3+5" dan "5+3"?
    // - Pertimbangkan struktur data yang otomatis mengurutkan dan menghindari duplikat
    // - TreeSet adalah Set yang sorted
    // - Gunakan .addAll untuk menambahkan seluruh elemen dari set ke List hasil kalian
    public List<String> findPairsWithSum(int targetSum) {
        Set<String> pairs = new TreeSet<>();
        Set<Integer> isThere = new HashSet<>();
        
        for (int element : collection) {
            int complement = targetSum - element;
            if (isThere.contains(complement)) {
                String pair = element < complement ? element + "+" + complement : complement + "+" + element;
                pairs.add(pair);
            }
            isThere.add(element);
        }

        return new ArrayList<>(pairs);
    }

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    //
    // HINT:
    // - Langkah 1: Identifikasi semua element unik
    // - Langkah 2: Hitung berapa kali setiap element muncul
    // - Langkah 3: Urutkan berdasarkan frekuensi (tinggi ke rendah), lalu nilai (tinggi ke rendah)
    // - Pertimbangkan membuat helper class untuk menyimpan pasangan (value, frequency)
    // - Untuk sorting custom, gunakan Comparator
    public List<Integer> getMostFrequentElements(int n) {
        Map <Integer, Integer> frequency = new HashMap<>();

        for (Integer element : collection) {
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((entry1, entry2) -> {
            int frequencyComparison = Integer.compare(entry2.getValue(), entry1.getValue());
            if (frequencyComparison != 0) {
                return frequencyComparison;
            }
            return Integer.compare(entry2.getKey(), entry1.getKey());
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(n, entries.size()); i++) {
            result.add(entries.get(i).getKey());
        }
        
        return result;
    }


    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection() {
        return collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection) {
        this.collection = newCollection;
    }
}
