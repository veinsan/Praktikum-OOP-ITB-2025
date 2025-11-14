public class Mage extends Hero {
    // TODO: Buat atribut: mana, spellPower
    private int mana;
    private int spellPower;
    // TODO: Buat constructor yang menerima name, hp, attackPower, mana, spellPower
    // Gunakan pula constructor parent dengan role "Mage"
    // Jangan lupa set atribut mana dan spellPower
    public Mage(String name, int hp, int attackPower, int mana, int spellPower){
        super(name, hp, attackPower, "Mage");
        this.mana = mana;
        this.spellPower = spellPower;
    }
    // TODO: Override method specialSkill()
    // Mage cast "Fireball" yang butuh 30 mana, damage = attackPower + spellPower
    // Jika mana cukup, tampilkan: "<name> casts Fireball! Deals <damage> magic damage! Mana: <mana>"
    // Contoh: "Kagura casts Fireball! Deals 130 magic damage! Mana: 120"
    // Jika tidak cukup: "<name> tidak memiliki cukup mana untuk Fireball!"
    @Override
    public void specialSkill(){
        if (mana >= 30){
            int damage = attackPower + spellPower;
            this.mana -= 30;
            System.out.println(name + " casts Fireball! Deals " + damage + " magic damage! Mana: " + mana);
        }
        else{
            System.out.println(name + " tidak memiliki cukup mana untuk Fireball!");
        }
    }
    // TODO: Buat method levelUp() yang override parent
    // Panggil super.levelUp() dulu, lalu tambah mana +40, spellPower +15
    // Tampilkan pesan bonus: "Bonus Mage: +40 mana, +15 spell power!"
    @Override
    public void levelUp(){
        super.levelUp();
        this.mana +=40;
        this.spellPower += 15;
        System.out.println("Bonus Mage: +40 mana, +15 spell power!");
    }
    // TODO: Buat method meditation() untuk restore 60 mana (max 200)
    // Format: "<name> bermeditasi dan memulihkan mana. Mana sekarang: <mana>"
    // Contoh: "Kagura bermeditasi dan memulihkan mana. Mana sekarang: 200"
    public void meditation(){
        this.mana += 60;
        if (this.mana>200){
            this.mana = 200;
        }
        System.out.println(name + " bermeditasi dan memulihkan mana. Mana sekarang: " + this.mana);
    }
    // TODO: Buat getter dan setter untuk mana dan spellPower
    public int getMana(){
        return mana;
    }

    public int getSpellPower(){
        return spellPower;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public void setSpellPower(int spellPower){
        this.spellPower = spellPower;
    }
}   