import javax.swing.JFrame;

public class TitlesFrame extends JFrame
{
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
    setTitle("Кривые фигуры");
    setDefaultCloseOperation(3);
    add(new TitlesPanel(94));
    setSize(350, 350);
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
