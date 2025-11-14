/**
 * WaterNimons.java
 * Representasi Pokenimons bertipe WATER.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang digunakan
 * - Kelas ini menyerang jarak dekat
 */
public class WaterNimons extends Pokenimons{
  /**
   * Membuat instance WaterNimons baru.
   *
   * @param name nama Pokenimons
   * @param hp   HP awal
   *
   * TODO: Buatlah konstruktor ini dengan menggunakan super untuk menginisialisasi tipe WATER.
   */
  public WaterNimons(String name, int hp) {
    super (name, hp, Type.WATER);
  }

  /**
   * Mengembalikan nama skill unik milik WaterNimons.
   *
   * @return nama skill
   *
   * TODO: Kembalikan nama skill WaterNimons, yaitu "Water Gun".
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected String skillName() {
    return "Water Gun";
  }

  /**
   * Base damage untuk skill WaterNimons.
   *
   * @return nilai damage dasar
   *
   * TODO: Kembalikan base damage skill WaterNimons, yaitu 12.
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected int skillBaseDamage() {
    return 12;
  }

  // WaterNimons tidak dapat berevolusi
}