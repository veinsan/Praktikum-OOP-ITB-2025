public class Alpha {
    private float a1;
    private float a2;

    public Alpha (float a1, float a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public float f1 (float aa1, float aa2) {
        return (a1+ a2) + (aa1 + aa2);
    }

    public void setA1(float a1){
        this.a1 = a1;
    }

    public float getA1() {
        return a1;
    }

    public void setA2(float a2) {
        this.a2 = a2;
    }

    public float getA2() {
        return a2;
    }
}