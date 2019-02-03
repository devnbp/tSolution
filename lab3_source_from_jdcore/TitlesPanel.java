import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.Timer;

public class TitlesPanel extends javax.swing.JPanel implements java.awt.event.ActionListener
{
  private Graphics2D g2d;
  private Timer animation;
  private boolean is_done;
  private int start_angle = 0;
  private static ArrayList<ArrayList<Shape>> listOfShapes = new ArrayList<ArrayList<Shape>>();
  private static Form shape;

  /**
   * Constructing panel
   * @param _shape value that using for initializing shape type in {@link ShapeFactory#getShape(int)}
   */
  public TitlesPanel(int _shape) {
    is_done = true;
    shape = new ShapeFactory().getShape(_shape);
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

  /**
   * Method allow us to draw our shapes from {@link ShapeFactory}
   * @param g Abstract class for graphics context
   */
  private void doDrawing(Graphics g) {
    is_done = false;
    g2d = ((Graphics2D)g);
    g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, 
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

    java.awt.Dimension size = getSize();
    Insets insets = getInsets();

    int w = size.width - insets.left - insets.right;
    int h = size.height - insets.top - insets.bottom;

    g2d.setStroke(shape.getStroke());
    g2d.setPaint(shape.getPaint());
    double angle = start_angle++;
    if (start_angle > 360) start_angle = 0;
    double dr = 90.0D / (w / (shape.width * 1.5D));
    for (int j = shape.height; j < h; j = (int)(j + shape.height * 1.5D))
      for (int i = shape.width; i < w; i = (int)(i + shape.width * 1.5D)) {
        angle = angle > 360.0D ? 0.0D : angle + dr;
        AffineTransform transform = new AffineTransform();
        transform.translate(i, j);
        transform.rotate(Math.toRadians(angle));
        g2d.draw(transform.createTransformedShape(shape.getPath()));
      }
    is_done = true;
  }

  private void createTransformedShapeList(Form initShape) {
    if (listOfShapes.size() > 0) {
      return;
    }
    System.out.println("creating list of shapes");
    java.awt.Dimension size = getSize();
    Insets insets = getInsets();

    int w = size.width - insets.left - insets.right;
    int h = size.height - insets.top - insets.bottom;

    if (start_angle > 360) start_angle = 0;

    for (double angle = 0.0D; angle < 360.0D; angle += 1.0D) {
      ArrayList<Shape> posShapes = new ArrayList<Shape>();
      for (int j = initShape.height; j < h; j = (int)(j + initShape.height * 1.5D)) {
        for (int i = initShape.width; i < w; i = (int)(i + initShape.width * 1.5D)) {
          AffineTransform transform = new AffineTransform();
          transform.translate(i, j);
          transform.rotate(Math.toRadians(angle));
          posShapes.add(transform.createTransformedShape(initShape.getPath()));
        }
      }
      listOfShapes.add(posShapes);
    }
    System.out.println("created list of shapes");
  }

  private void doDrawingV2(Graphics g) {
    is_done = false;
    g2d = ((Graphics2D)g);
    g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
            java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

    java.awt.Dimension size = getSize();
    Insets insets = getInsets();
    int w = size.width - insets.left - insets.right;
    int h = size.height - insets.top - insets.bottom;

    createTransformedShapeList(shape);

    g2d.setStroke(shape.getStroke());
    g2d.setPaint(shape.getPaint());
    start_angle++;

    double dr = 90.0D / (w / (shape.width * 1.5D));
    int position = 0;
    for (int j = shape.height; j < h; j = (int)(j + shape.height * 1.5D))
      for (int i = shape.width; i < w; i = (int)(i + shape.width * 1.5D)) {
        if (start_angle > 360) start_angle = 1;
        g2d.draw(listOfShapes.get(start_angle-1).get(position));
        start_angle += (int) dr;
        position++;
      }

    is_done = true;
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    doDrawingV2(g);
  }
}
