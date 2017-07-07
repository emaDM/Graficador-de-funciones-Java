package graficador;

/**
 * @author ema
 */
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Wheellistener implements MouseWheelListener {

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        if (e.getSource().equals(programa.panel3)) {
            if (e.getWheelRotation() > 0) {
                programa.panel3.zoom += 1;
            } else if (programa.panel3.zoom > 1) {
                programa.panel3.zoom -= 1;
            }
            programa.actualizargrafica();
        }
    }

}
