class Developer {
    // TODO: Deklarasikan atribut: namaDev (String), rating (double)
    String namaDev;
    double rating;

    // TODO: Buat constructor untuk menginisialisasi namaDev dan rating
    Developer(String namaDev, double rating) {
        // HINT: this.namaDev = namaDev; dst.
        this.namaDev = namaDev;
        this.rating = rating;
    }

    // TODO: Cetak informasi developer sesuai format:
    // "Developer: <namaDev> | Rating: <rating>."
    void infoDev() {
        // HINT: Gunakan System.out.println(...)
        System.out.println("Developer: " + this.namaDev + " | Rating: " + this.rating + ".");
    }
}