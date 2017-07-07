package graficador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ema
 */
public class ActListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(programa.grafbutton)) {
            programa.actualizargrafica();
        }

    }

}
