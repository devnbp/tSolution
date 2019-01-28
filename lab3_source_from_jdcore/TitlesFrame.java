import javax.swing.*;

public class TitlesFrame extends JFrame
{
  private static final String title = "Кривые фигуры";
  private static final int width = 350;
  private static final int height = 350;
  private static final int shapeType = 94;
  /**
   * Initializing JFrame user interface
   */
  public TitlesFrame()
  {
    initUI();
  }

  /**
   * Setting JFrame parameters
   */
  private void initUI()
  {
    setTitle(title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(new TitlesPanel(shapeType));
    setSize(width, height);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args)
  {
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        TitlesFrame ps = new TitlesFrame();
        ps.setVisible(true);
      }
    });
  }
}
