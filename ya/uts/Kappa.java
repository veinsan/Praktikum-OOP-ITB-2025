public class Kappa extends Delta {
    private float k1;

    public Kappa(Alpha b1, float d1, float k1) {
        super(b1, d1);
        this.k1 = k1;
    }

    public void setK1(float k1) {
        this.k1 = k1;
    }

    public float getK1() {
        return k1;
    }

    @Override
    public float g1() {
        return get_b1().f1(getD1(), getK1());
    }

    @Override
    public float h1(float a1, float a2) {
        return a1 + a2 + getK1();
    }

    public static void main(String[] args) {
        Alpha a = new Alpha(2, 3);
        Kappa k = new Kappa(a, 5, 7);

        System.out.println("hasil g1: " + k.g1());
        System.out.println("hasil h1: " + k.h1(4, 5));
        System.out.println("total getCount: " + Beta.getCountBeta());
    }
}