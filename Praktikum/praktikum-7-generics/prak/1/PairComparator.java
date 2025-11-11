public final class PairComparator {
    private PairComparator() {
    }

    // TODO:
    // 1. Lengkapi parameter generik method yang merupakan kelas-kelas yang
    // menerapkan interface Comparable
    // 2. Lengkapi parameter generik dari pair yang dibandingkan
    public static <T extends Comparable<T>, U extends Comparable<U>>
    boolean isGreater(Pair<T, U> p1, Pair<T, U> p2) {
        return p1.getFirst().compareTo(p2.getFirst()) > 0 &&
               p1.getSecond().compareTo(p2.getSecond()) > 0;
        // TODO:
        // 1. Bandingkan elemen pertama dan kedua antar pair menggunakan compareTo().
        // 2. Kembalikan true hanya jika kedua perbandingan menunjukkan p1 lebih besar dari p2.
        // ...
    }
}
