import java.awt.Point;

public class ShapeFactory
{
  private Form shape;
  private int width = 25;
  private int height = 25;

  public ShapeFactory() {
  }

  /**
   * @param type shape type
   * @throws Error "type is unsupported" if shape type is unavailable
   */
  private void createShape(int type){
    switch (type) {
      case 1:
        shape = new Star(width, height, 3, new Point(0, 0), 2.0D, 2.0D);
        break;
      case 3:
        shape = new Star(width, height,5, new Point(0, 0), 2.0D, 4.0D);
        break;
      case 5:
        shape = new Form(width, height);
        break;
      case 7:
        shape = new Triangle(width, height);
        break;
      case 9:
        shape = new Circle(width,height,30.0D, 300.0D, 2);
        break;
      default:
        throw new Error("type is unsupported");
    }
  }

  /**
   * @param type type of stroke/painting style
   */
  private void setPaintingStyle(int type){
    switch (type) {
      case 1:
        shape.setStrokeWidth(3.0F);
        break;
      case 4:
        shape.setStrokeWidth(7.0F);
        break;
      case 7:
        shape.setPaint(new java.awt.GradientPaint(
                -width, -height, java.awt.Color.white,
                width, height, java.awt.Color.gray, true));
        break;
      case 8:
        shape.setPaint(java.awt.Color.red);
        break;
      default:
        throw new Error("type is unsupported");
    }
  }

  /**
   * @param shape_type 2-digit value, 1st digit - shape type, 2nd digit - stroke or painting type
   * @return {@link Form} object
   */
  public Form getShape(int shape_type){
    createShape(shape_type / 10);
    setPaintingStyle(shape_type % 10);
    return shape;
  }
}
