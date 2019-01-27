import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.AffineTransform;
import javax.swing.Timer;

public class TitlesPanel extends javax.swing.JPanel implements java.awt.event.ActionListener
{
  private Graphics2D g2d;
  private Timer animation;
  private boolean is_done;
  private int start_angle = 0;
  private int shape;
  
  public TitlesPanel(int _shape) {
    is_done = true;
    shape = _shape;
    animation = new Timer(50, this);
    animation.setInitialDelay(50);
    animation.start();
  }
  

  public void actionPerformed(java.awt.event.ActionEvent arg0)
  {
    if (is_done) {
      repaint();
    }
  }
  
  private void doDrawing(Graphics g) {
    is_done = false;
    g2d = ((Graphics2D)g);
    g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, 
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
    
    java.awt.Dimension size = getSize();
    Insets insets = getInsets();
    
    int w = width - left - right;
    int h = height - top - bottom;
    
    ShapeFactory shape = new ShapeFactory(this.shape);
    g2d.setStroke(stroke);
    g2d.setPaint(paint);
    double angle = start_angle++;
    if (start_angle > 360) start_angle = 0;
    double dr = 90.0D / (w / (width * 1.5D));
    for (int j = height; j < h; j = (int)(j + height * 1.5D))
      for (int i = width; i < w; i = (int)(i + width * 1.5D)) {
        angle = angle > 360.0D ? 0.0D : angle + dr;
        AffineTransform transform = new AffineTransform();
        transform.translate(i, j);
        transform.rotate(Math.toRadians(angle));
        g2d.draw(transform.createTransformedShape(shape));
      }
    is_done = true;
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    doDrawing(g);
  }
}
