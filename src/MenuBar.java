import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PrimitiveIterator;
import javax.swing.JTextArea;


public class MenuBar extends JMenuBar {
    public MenuBar(JFrame telainicio) {
        JMenu menu = new JMenu("Menu");

        JMenuItem novoDiario = new JMenuItem("Novo Diário");
        ImageIcon newIcon = new ImageIcon("src/img/7604035.png");
        novoDiario.setIcon(newIcon);
        novoDiario.setIconTextGap(10);
        novoDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        novoDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            JTextArea novoArquivo = new JTextArea();
            novoArquivo.setSize(50, 50);
            JScrollPane scrollnovo = new JScrollPane(novoArquivo);
            telainicio.add(scrollnovo, BorderLayout.CENTER);
            telainicio.revalidate();
            telainicio.repaint();
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
                File arquivo;
                JFileChooser abrirArquivo = new JFileChooser();
                int returnVal = abrirArquivo.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    arquivo = abrirArquivo.getSelectedFile();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi selecionado um Diario");
                    return;
                }
                try {
                    if (!arquivo.exists()) {
                        arquivo.createNewFile();
                    }
                    FileReader leitor = new FileReader(arquivo);
                    StringBuilder printarquivo = new StringBuilder();
                    int c;
                    while ((c = leitor.read()) != -1) {
                        printarquivo.append((char) c);
                    }
                    leitor.close();
                    JTextArea telaAberta = new JTextArea();
                    telaAberta.setSize(50, 50);
                    telaAberta.setText(printarquivo.toString());
                    JScrollPane scrollabrir = new JScrollPane(telaAberta);

                    telainicio.add(scrollabrir, BorderLayout.CENTER);
                    telainicio.revalidate();
                    telainicio.repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
