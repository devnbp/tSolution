import java.awt.Point;
import java.awt.geom.GeneralPath;
import static java.lang.Math.PI;

public class Star extends Form{
    private static int arms;
    private static Point center;
    private static double rOuter;
    private static double rInner;
    private static double angle;

    /**
     * @param w width
     * @param h height
     * @param a Count of star vertices
     * @param c Center point of star
     * @param rOc Outside radius coefficient
     * @param rIc Inside radius coefficient
     */
    public Star(int w, int h, int a, Point c, double rOc, double rIc)
    {
        super(w, h, false);
        arms = a;
        center = c;
        rOuter = width / rOc;
        rInner = width / rIc;
        angle = PI / arms;
        setPath();
    }

    /**
     * Setting painting path
     */
    private void setPath(){
        GeneralPath gPath = new GeneralPath();

        for (int i = 0; i < 2 * arms; i++)
        {
            double r = (i & 0x1) == 0 ? rOuter : rInner;
            java.awt.geom.Point2D.Double p = new java.awt.geom.Point2D.Double(center.x + Math.cos(i * angle) * r, center.y + Math.sin(i * angle) * r);
            if (i == 0) gPath.moveTo(p.getX(), p.getY()); else
                gPath.lineTo(p.getX(), p.getY());
        }
        gPath.closePath();
        path = gPath;
    }
}
