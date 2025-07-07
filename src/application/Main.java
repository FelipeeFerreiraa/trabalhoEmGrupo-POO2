package application;

import javax.swing.JFrame;
import view.TelaPrincipal;

/**
 *
 * @author felip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
