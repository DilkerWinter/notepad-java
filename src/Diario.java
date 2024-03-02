import javax.swing.*;

public class Diario {
    private JTextArea diarioText;

    public Diario() {
        diarioText = new JTextArea();
        diarioText.setEditable(true); // Set the text area editable
        diarioText.setLineWrap(true); // Enable line wrapping
        diarioText.setWrapStyleWord(true); // Wrap at word boundaries
        diarioText.setPreferredSize(new java.awt.Dimension(500, 500)); // Set preferred size
        diarioText.setVisible(true);
    }

    public JTextArea getDiarioText() {
        return diarioText;
    }

}
