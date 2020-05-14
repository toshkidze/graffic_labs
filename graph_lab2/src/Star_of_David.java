import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Star_of_David extends JPanel implements ActionListener {
    // Масштабування відбувається відносно центру координат,
    // тому малювати фігуру бажано також симетрично центру
    double points[][] = {
            { -100, -15 }, { -25, -25 }, { 0, -90 }, { 25, -25 },
            { 100, -15 }, { 50, 25 }, { 60, 100 }, { 0, 50 },
            { -60, 100 }, { -50, 25 }, { -100, -15 }
    };

    double width = 1000;
    double height = 600;

    Timer timer;
    // Для анімації повороту
    private double angle = 0;

    // Для анімації масштабування
    private double scale = 1;
    private double delta = 0.01;

    // Для анімації руху
    private double dx = 1;
    private double tx = height/4;
    private double dy = 1;
    private double ty = 0;
    private static int maxWidth;
    private static int maxHeight;

    public Star_of_David() {
        // Таймер генеруватиме подію що 10 мс
        timer = new Timer(10, this);
        timer.start();
    }
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;

        Stroke defaultStroke = g2d.getStroke();
        g2d.setBackground(Color.BLACK);
        g2d.clearRect(0, 0, maxWidth+1, maxHeight+1);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        this.drawBorder(g2d);

        GeneralPath bab = new GeneralPath();
        double points2[][] = {
                {0, -300},
                {104, -150},
                {300, -150},
                {200, 0},
                {300, 150},
                {104, 150},
                {0, 300},
                {-104, 150},
                {-300, 150},
                {-200, 0},
                {-300, -150},
                {-104, -150},
                {0, -300}
        };
        bab.moveTo(points2[0][0], points2[0][1]);
        for (int k = 1; k < points2.length; k++)
            bab.lineTo(points2[k][0], points2[k][1]);
        bab.closePath();


        g2d.translate(maxWidth/2, maxHeight/2);
        g2d.translate(tx,ty);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)scale));

        g2d.setStroke(defaultStroke);

        GradientPaint gp = new GradientPaint(
                0, 0, new Color(0, 0, 0),
                50, 50, new Color(0.0F, 1.0F, 1.0F),
                true);
        g2d.setPaint(gp);
        g2d.fill(bab);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(-243,-243,243*2,243*2);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(-195,-195,195*2,195*2);

        g2d.setColor(Color.RED);
        g2d.fillOval(-144,-144,144*2,144*2);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(-104,-104,104*2,104*2);

        g2d.setColor(Color.YELLOW);
        g2d.fillOval(-62,-62,62*2,62*2);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(-32,-32,32*2,32*2);

        g2d.drawLine(-7,0,7,0);
        g2d.drawLine(0,-7,0,7);

    }

    private void drawBorder(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        BasicStroke basicStroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(basicStroke);
        g2d.drawRect(5, 5, maxWidth - 10, maxHeight - 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 2 Variant 13");
        frame.add(new Star_of_David());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1900, 1080);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
    // Цей метод буде викликано щоразу, як спрацює таймер
    public void actionPerformed(ActionEvent e) {
        if ( scale < 0.01 ) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }

        scale += delta;
        angle += 0.01;
        ty = height/4*Math.sin(angle);
        tx = height/4*Math.cos(angle);

        repaint();
    }
}