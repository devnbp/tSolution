public class Circle extends Form {
    private double start;
    private double end;
    private int type;

    /**
     * @param w width
     * @param h height
     * @param s starting angle
     * @param e ending angle
     * @param t type
     */
    public Circle(int w, int h, double s, double e, int t){
        super(w, h, false);
        start = s;
        end = e;
        type = t;
        setPath();
    }

    /**
     * Setting painting path
     */
    private void setPath() {
        path = new java.awt.geom.Arc2D.Double(-width / 2.0D, -height / 2.0D, width, height, start, end, type);
    }
}
