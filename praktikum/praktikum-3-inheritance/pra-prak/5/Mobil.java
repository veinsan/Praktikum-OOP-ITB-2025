public class Mobil extends Kendaraan{
    public enum TipeMobil { SUV, SEDAN, MPV};

    private TipeMobil tipeMobil;
    private boolean punyaSupir;

    public Mobil(String noPolisi, String merk, int tahunProduksi, Kategori kategori, TipeMobil tipeMobil, boolean punyaSupir){
        super(noPolisi, merk, tahunProduksi, Kategori.PRIBADI);
        this.tipeMobil = tipeMobil;
        this.punyaSupir = punyaSupir;
    }

    @Override
    public int biayaDasarPerHari(){
        int biayaSewa = 0;
        switch (this.tipeMobil){
            case SUV:
                biayaSewa = 600000;
                break;
            case SEDAN:
                biayaSewa = 550000;
                break;
            case MPV:
                biayaSewa = 500000;
                break;
        }
        if (punyaSupir == true){
            biayaSewa += 150000;
        }
        return biayaSewa;
    }

    @Override
    public String toString(){
        return super.toString() +
                "\n\t -> Tipe: " + tipeMobil + ", Supir: " + (punyaSupir ? "Ya" : "Tidak");
    }
}