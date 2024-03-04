import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu menu = new JMenu("Menu");

        JMenuItem novoDiario = new JMenuItem("Novo Diário");
        ImageIcon newIcon = new ImageIcon("src/img/7604035.png");
        novoDiario.setIcon(newIcon);
        novoDiario.setIconTextGap(10);
        novoDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        novoDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Arrumar para criar nova classe de JtextArea para criar notas e salvar
                newDiario = new Diario(); 
            }
        });

        JMenuItem abrirDiario = new JMenuItem("Abrir Diário");
        ImageIcon openIcon = new ImageIcon("src/img/7604005.png");
        abrirDiario.setIcon(openIcon);
        abrirDiario.setIconTextGap(10);
        abrirDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
        abrirDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Adicionar para abrir uma classe de Diario Existente previamente
                System.out.println("ABRIU");

            }
        });

        JMenuItem salvarDiario = new JMenuItem("Salvar Diário");
        ImageIcon saveIcon = new ImageIcon("src/img/3720719.png");
        salvarDiario.setIcon(saveIcon);
        salvarDiario.setIconTextGap(10);
        salvarDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        salvarDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicionar classe para fazer salvamento das notas como um objeto/String ou arquivo txt.
                System.out.println("SALVO");

            }
        });

        menu.add(novoDiario);
        menu.add(abrirDiario);
        menu.add(salvarDiario);

        add(menu);
    }
}
