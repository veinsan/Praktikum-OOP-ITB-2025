class HybridCar extends Car {
    private int batteryLevelHybrid;

    public HybridCar(String brand, String model, int speed, int fuelLevel, int batteryLevelHybrid) {
        super(brand, model, speed, fuelLevel);
        this.batteryLevelHybrid = batteryLevelHybrid;
    }

    public void switchMode() {
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode hemat energi");
    }

    // TODO : Tambahkan method yang hilang di kelas ini
    public void move(){
        System.out.println(brand + " " + model + " (mobil hybrid) menggunakan kombinasi bensin dan baterai (" + fuelLevel + "% / " + batteryLevelHybrid + "%)");
    }

    public void refuel(){
        System.out.println("Mobil " + brand + " " + model + " mengisi bensin. Level saat ini: " + fuelLevel + "%");
    }

    public void switchMode(String mode){
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode " + mode);
    }

    public String getEnergySource(){
        return "Hybrid (Bensin + Listrik)";
    }
}