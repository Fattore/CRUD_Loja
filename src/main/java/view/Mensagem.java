package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Mensagem {
    public static void ExibirMensagemErro(String Mensagem) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(Mensagem);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Mensagem");
        dialog.setVisible(true);  
    }
}
