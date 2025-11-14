public interface PhysicalAttack extends Attack {
    public int getPhysicalPower();

    public void setPhysicalPower(int power);
    
    // TODO: Buat default method refineBlade()
    // Tambahkan 10 ke physicalPower dengan memanggil getPhysicalPower() dan setPhysicalPower()
    public default void refineBlade() {
        int physicalPower = getPhysicalPower();
        setPhysicalPower(physicalPower + 10);
    }
    
    // TODO: Buat default method showPhysicalStats()
    // Tampilkan: "Kekuatan Fisik: <physicalPower>"
    public default void showPhysicalStats() {
        System.out.println("Kekuatan Fisik: " + getPhysicalPower());
    }
}