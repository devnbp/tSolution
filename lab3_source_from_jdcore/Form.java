import java.awt.*;

public class Form {
    public int width;
    public int height;
    public java.awt.Shape path;
    public java.awt.BasicStroke stroke = new BasicStroke();
    public java.awt.Paint paint;

    /**
     * Main constructor
     * @param w width
     * @param h height
     * @param p do we need create painting path while constructing
     */
    public Form(int w, int h, boolean p){
        width = w;
        height = h;
        if (p){
            setPath();
        }
    }

    public Form(int w, int h){
        this(w, h, true);
    }

    public Form(int w){
        this(w, 25);
    }

    public Form(){
        this(25);
    }

    /**
     * Setting painting path
     */
    private void setPath(){
        path = new java.awt.geom.Rectangle2D.Double(-width / 2.0D, -height / 2.0D, width, height);
    }

    /**
     * @return painting path
     */
    public java.awt.Shape getPath() {
        if (path == null){
            setPath();
        }
        return path;
    }

    /**
     * Setting stroke width
     * @param w width
     */
    public void setStrokeWidth(float w) {
        stroke = new java.awt.BasicStroke(w);
    }

    /**
     * @return stroke line
     */
    public java.awt.BasicStroke getStroke() {

        return stroke;
    }

    /**
     * Setting paint style
     * @param v {@link java.awt.Paint} object
     */
    public void setPaint(java.awt.Paint v) {
        paint = v;
    }

    /**
     * @return paint style
     */
    public java.awt.Paint getPaint() {

        return paint;
    }
}
