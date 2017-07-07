package graficador;

/**
 * @author ema
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class graficador extends JPanel {

    public boolean f = false;
    private int ANCHO, CENV, CENH, LARGO;
    private int y1, y2;
    private double x1, x2, y;
    public static double zoom = 1;
    public static Are are = new Are();
    double resultado;

    graficador() {
    }

    @Override
    public void paint(Graphics g) {
        //double l;
        //l=are.f(0.03125,"4+(x^2)+4", 0);
        //System.out.println(l);
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ANCHO = this.getWidth();
        LARGO = this.getHeight();
        CENV = this.getHeight() / 2;
        CENH = this.getWidth() / 2;

        g.setColor(Color.RED);
        g.drawLine(0, CENV, ANCHO, CENV);
        g.drawLine(CENH, 0, CENH, LARGO);

        if (f == true) {
            paintFunction(g2d);
        }
    }

    public double func(double x) {
        resultado = are.f(x, programa.ecufield.getText(), 0, 0);
        return resultado;
    }

    public int getx(double x) {//devuelve la coordenada relativa en el mapa
        return (int) ((x * zoom) + CENH);
    }

    public void paintFunction(Graphics2D g) {
        x1 = -ANCHO;
        y1 = (int) (CENV - (func(x1) * zoom));
        for (double i = (-ANCHO) + 1; i < ANCHO; i++) {

            x2 = (i / zoom);
            y = func(x2);
            //if(y<0)System.out.println(x2);

            y2 = (int) (CENV - (y * zoom));
// si molesta como grafica la tangete, grafica punto por punto
            //g.drawLine(getx(x1), y1, getx(x1), y1);
             g.drawLine(getx(x1), y1, getx(x2), y2);

            x1 = x2;
            y1 = y2;

            if (x1 == ((int) (x1))) {
                if (y == 0) {
                    g.drawString("raiz: " + x2, getx(x2), CENV - 10);
                } else {
                    g.drawString("" + x2, getx(x2), CENV + 13);
                }
            }
            if (y == ((int) (y))) {
                g.drawString("" + y, CENH - 23, y2);
            }

        }
    }

}
