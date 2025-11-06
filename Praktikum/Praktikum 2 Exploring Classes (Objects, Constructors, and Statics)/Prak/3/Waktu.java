public class Waktu {
    private int hour;   // 0..23
    private int minute; // 0..59

    // Static attribute untuk default timezone (misalnya "WIB")
    private static String DEFAULT_TZ = "WIB";

    // TODO: default constructor  -> set jam dan menit ke 0
    public Waktu() {
        hour = 0;
        minute = 0;
    }

    // TODO: Parameterized constructor dengan parameter jam dan menit
    // - batasi jam hanya 0..23
    // - batasi menit hanya 0..59
    public Waktu(int hour, int minute) {
        // gunakan this.hour dan this.minute
        if (hour < 0) hour = 0;
        if (hour > 23) hour = 23;
        if (minute < 0) minute = 0;
        if (minute > 59) minute = 59;
        this.hour = hour;
        this.minute = minute;
    }
    // TODO: Constructor dengan total menit
    // - ubah total menit jadi jam dan menit
    public Waktu(int totalMinutes) {
        // misalnya 150 -> 02:30
        this.minute = totalMinutes % 60;
        this.hour = (totalMinutes / 60) % 24;
    }

    // TODO: Buatlah Getter getHour() dan getMinute()
    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    // ===== STATIC method =====
    // TODO: fromMinutes(int total) -> kembalikan Waktu dari total menit
    public static Waktu fromMinutes(int total){
        return new Waktu(total);
    }
    // TODO: toMinutes(Waktu t) -> kembalikan total menit dari objek Waktu
    public static int toMinutes(Waktu t){
        if (t == null){return 0;}
        return t.hour * 60 + t.minute;
    }
    // TODO: addMinutes(Waktu t, int add) -> tambah menit ke sebuah Waktu
    public static Waktu addMinutes(Waktu t, int add){
        int totalWaktuLama = Waktu.toMinutes(t);
        int totalWaktuBaru = totalWaktuLama + add;
        return new Waktu(totalWaktuBaru);
    }

    // ===== STATIC getter & setter untuk Waktuzone =====
    // TODO: getDefaultTz() -> kembalikan DEFAULT_TZ
    public static String getDefaultTz(){
        return DEFAULT_TZ;
    }
    // TODO: setDefaultTz(String tz) -> ubah DEFAULT_TZ
    public static void setDefaultTz(String tz){
        DEFAULT_TZ = tz;
    }

    // Helper untuk format jam:menit
    private String format() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

    @Override
    public String toString() {
        return  "" + this.format() + " "+ DEFAULT_TZ;
    }

    
}
