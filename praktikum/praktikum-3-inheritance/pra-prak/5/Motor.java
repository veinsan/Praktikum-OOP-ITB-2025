public class Motor extends Kendaraan{
    public enum TipeMotor { BEBEK, MATIC, SPORT };

    private TipeMotor tipeMotor;
    private int kapasitasMesin;

    public Motor(String noPolisi, String merk, int tahunProduksi, Kategori kategori, TipeMotor tipeMotor, int kapasitasMesin){
        super(noPolisi, merk, tahunProduksi, Kategori.PRIBADI);
        this.tipeMotor = tipeMotor;
        this.kapasitasMesin = kapasitasMesin;
    }

    @Override
    public int biayaDasarPerHari(){
        int biayaSewa = 0;
        switch (this.tipeMotor){
            case BEBEK: 
                biayaSewa = 100000;
                break;
            case MATIC:
                biayaSewa = 125000;
                break;
            case SPORT:
                biayaSewa = 200000;
                break;
        }
        if (kapasitasMesin > 150){
            biayaSewa += 50000;
        }
        return biayaSewa;
    }

    @Override
    public String toString(){
        return super.toString() +
        "\n\t -> Tipe: " + tipeMotor + ", Kapasitas: " + kapasitasMesin + "cc";
    }
}