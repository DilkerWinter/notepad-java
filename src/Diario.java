import javax.swing.*;

public class Diario {
    private JTextArea diarioText;

    public Diario() {
        diarioText = new JTextArea();
        diarioText.setEditable(true);
        diarioText.setLineWrap(true); 
        diarioText.setWrapStyleWord(true);
        diarioText.setPreferredSize(new java.awt.Dimension(500, 500)); 
        diarioText.setVisible(true);
    }

    public JTextArea getDiarioText() {
        return diarioText;
    }

}
