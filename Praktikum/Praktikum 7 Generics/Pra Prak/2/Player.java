class Player implements Comparable<Player> {
    // TODO:
    // 1. Tambahkan atribut final untuk menyimpan nama dengan tipe String.
    private final String name;
    // 2. Tambahkan atribut final untuk menyimpan skor dengan tipe int.
    private final int score;

    Player(String name, int score) {
        // TODO:
        // 1. Lengkapi parameter konstruktor dengan tipe yang sesuai.
        // 2. Inisialisasikan atribut nama dan skor menggunakan parameter yang diterima.
        this.name = name;
        this.score = score;
    }

    Player boostScore(int bonus) {
        // TODO:
        // 1. Lengkapi parameter dengan tipe yang sesuai untuk bonus skor.
        // 2. Kembalikan objek Player baru dengan skor yang sudah ditambahkan bonus.
        return new Player (this.name, this.score + bonus);
    }

    Player faceOff(Player challenger) {
        // TODO:
        // 1. Lengkapi parameter dengan tipe Player.
        // 2. Gunakan ChampionFinder.findChampion untuk menentukan pemenang antara this dan challenger.
        return ChampionFinder.findChampion(this, challenger);
    }

    @Override
    public String toString() {
        // TODO:
        // Kembalikan representasi string dalam format "<nama>(<skor>)" tanpa spasi tambahan.
        return name + "(" + score + ")";
    }
    

    @Override
    public int compareTo(Player other) {
        // TODO:
        // 1. Lengkapi parameter dengan tipe Player.
        // 2. Bandingkan skor terlebih dahulu menggunakan Integer.compare.
        // 3. Jika skor sama, bandingkan nama secara leksikografis.
        // 4. Kembalikan hasil perbandingan sesuai kontrak Comparable.
        int scoreCompare = Integer.compare(this.score, other.score);
        if (scoreCompare != 0){
            return scoreCompare;
        }
        return this.name.compareTo(other.name);
    }
}