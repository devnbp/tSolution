import java.awt.geom.GeneralPath;

public class Triangle extends Form{

    /**
     * @param w width
     * @param h height
     */
    public Triangle(int w, int h){
        super(w, h, false);
        setPath();
    }

    /**
     * Setting painting path
     */
    private void setPath() {
        GeneralPath gPath = new GeneralPath();
        double tmp_height = Math.sqrt(2.0D) / 2.0D * height;
        int w = (width / 2);
        gPath.moveTo(-w, -tmp_height);
        gPath.lineTo(0.0D, -tmp_height);
        gPath.lineTo(w, tmp_height);
        gPath.closePath();
        path = gPath;
    }
}
