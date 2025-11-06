public abstract class Beta {
    private Alpha b1;
    private static int countBeta = 0;
    
    public Beta(Alpha b1) {
        this.b1 = b1;
        countBeta++;
    }

    public void set_b1 (Alpha bb1) {
        this.b1 = bb1;
    }

    public Alpha get_b1() {
        return b1;
    }

    public static int getCountBeta() {
        return countBeta;
    }

    public abstract float g1 ();
}