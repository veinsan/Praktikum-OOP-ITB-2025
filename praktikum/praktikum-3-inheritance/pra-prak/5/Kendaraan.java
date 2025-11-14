public abstract class  Kendaraan{
    public enum Kategori { PRIBADI, NIAGA};

    private String noPolisi;
    private String merk;
    private int tahunProduksi;
    private Kategori kategori;

    private static final double PPN = 0.11;
    private static int diskonPersen;

    public Kendaraan(String noPolisi, String merk, int tahunProduksi, Kategori kategori){
        this.noPolisi = (noPolisi == null || noPolisi.trim().isEmpty()) ? "N/A" : noPolisi.trim();
        this.merk = (merk == null || merk.trim().isEmpty()) ? "N/A" : merk.trim();
        this.tahunProduksi = (tahunProduksi < 0) ? 2000 : tahunProduksi;
        this.kategori = kategori;
    }

    public abstract int biayaDasarPerHari();

    public int hitungBiayaSewa(int jumlahHari){
        double subTotal = biayaDasarPerHari() * jumlahHari;
        if (tahunProduksi < 2015){
            subTotal *= 1.1;
        }
        
        double hargaDiskon = subTotal * (100 - diskonPersen) / 100.0;
        double hargaFinal = hargaDiskon * 1.11;

        return (int) Math.round(hargaFinal);
    }

    public String toString(){
        return "[" + kategori + "] " + merk + " (" + tahunProduksi + ") - " + noPolisi;
    }

    public static void setDiskon(int persen){
        if (persen >= 0 && persen <= 50){
            diskonPersen = persen;
        }
    }

    public String getNoPolisi(){
        return noPolisi;
    }

    public String getMerk(){
        return merk;
    }

    public int getTahunProduksi(){
        return tahunProduksi;
    }

    public Kategori getKategori(){
        return kategori;
    }
}
