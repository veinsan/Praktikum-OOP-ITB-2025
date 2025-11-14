/**
 * GrassNimons.java
 * Representasi Pokenimons bertipe GRASS.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang digunakan
 * - Kelas ini menyerang jarak jauh
 */
public class GrassNimons extends Pokenimons implements RangedAttacker{
  /**
   * Membuat instance GrassNimons baru.
   *
   * @param name nama Pokenimons
   * @param hp   HP awal
   *
   * TODO: Buatlah konstruktor ini dengan menggunakan super untuk menginisialisasi tipe GRASS.
   */
  public GrassNimons(String name, int hp) {
    super(name, hp, Type.GRASS);
  }

  /**
   * Mengembalikan nama skill unik milik GrassNimons.
   *
   * @return nama skill
   *
   * TODO: Kembalikan nama skill GrassNimons, yaitu "Leaf Blade".
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected String skillName() {
    return "Leaf Blade";
  }

  /**
   * Mengembalikan base damage untuk skill GrassNimons.
   *
   * @return nilai damage dasar
   *
   * TODO: Kembalikan nilai base damage untuk skill GrassNimons, yaitu 12.
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected int skillBaseDamage() {
    return 12;
  }

  /**
   * Evolusi GrassNimons.
   *
   * Aturan yang diharapkan:
   * - Jika fainted (HP 0), tidak dapat berevolusi; cetak pesan "<nama_pokenimons> has fainted and cannot evolve.".
   * - Jika sudah berada pada bentuk akhir, kembalikan bentuk saat ini dan cetak pesan "<nama_pokenimons> is already in final form.".
   * - Jika level telah mencapai minimal level 5, cetak pesan "<nama_pokenimons> evolves into GrassEvoNimons!"
   *   lalu kembalikan bentuk evolusi dengan HP bertambah 10 dan level dipertahankan.
   * - Jika belum memenuhi syarat, cetak pesan "<nama_pokenimons> is not ready to evolve.".
   * 
   * For your exploration: manfaatkan instanceof untuk melakukan guard.
   *
   * @return objek bentuk saat ini atau bentuk evolusi
   *
   * TODO: Implementasikan seluruh logika di atas sesuai spesifikasi.
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  public Pokenimons evolve() {
    if (getHp() <= 0){
      System.out.println(getName() + " has fainted and cannot evolve.");
      return this;
    }
    else if (this instanceof GrassEvoNimons){
      System.out.println(getName() + " is already in final form.");
      return this;
    }
    else if (getLevel() >= 5){
      System.out.println(getName() + " evolves into GrassEvoNimons!");
      GrassEvoNimons evo = new GrassEvoNimons(getName(), getHp() + 10);
      evo.setLevel(getLevel());
      return evo;
    }
    else{
      System.out.println(getName() + " is not ready to evolve.");
      return this;
    }
  }
}
