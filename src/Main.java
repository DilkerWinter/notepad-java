import javax.swing.*;
import java.awt.*;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] args) {
        // Iniciando o app
        JFrame telainicio = new JFrame();
        telainicio.setTitle("Diário");
        telainicio.setSize(600, 700);
        telainicio.setVisible(true);
        telainicio.setLocationRelativeTo(null);
        telainicio.setResizable(true);
        telainicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telainicio.setLayout(new BorderLayout());

        // Definindo imagem de ícone para o app
        ImageIcon icon = new ImageIcon("src/img/2232688.png");
        telainicio.setIconImage(icon.getImage());

        // Adicionando barra de menu
        JMenuBar menuBar = new MenuBar(telainicio); // Usando a classe MenuBar
        telainicio.setJMenuBar(menuBar);

        //Adicionar botão para customização de texto.

        telainicio.revalidate();
        telainicio.repaint();
    }
}
