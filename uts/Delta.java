public abstract class Delta extends Beta implements Gamma {
    private float d1;

    public Delta(Alpha b1, float d1) {
        super(b1);     // ini panggil constructor Beta(Alpha b1)
        this.d1 = d1;  // ini isi field d1 di Delta
    }

    public void setD1(float d1) {
        this.d1 = d1;
    }

    public float getD1() {
        return d1;
    }
}
