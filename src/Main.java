import javax.swing.*;
import java.awt.*;

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


        // Definindo imagem de ícone para o app
        ImageIcon icon = new ImageIcon("src/img/2232688.png");
        telainicio.setIconImage(icon.getImage());

        // Adicionando barra de menu
        JMenuBar menuBar = new MenuBar(); // Usando a classe MenuBar
        telainicio.setJMenuBar(menuBar);

        telainicio.revalidate();
        telainicio.repaint();
    }
}
