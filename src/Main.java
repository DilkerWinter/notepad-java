import javax.swing.*;
import java.awt.*;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] args) {
        //Criando tela inicial onde sera exibido o menu e o texto
        JFrame telainicio = new JFrame();
        telainicio.setTitle("Diário");      //nome da tela
        telainicio.setSize(600, 700);       //tamanho da tela
        telainicio.setVisible(true);    //Adicionando para tela aparecer
        telainicio.setLocationRelativeTo(null); // centralizando a tela
        telainicio.setResizable(true);  //adicionando para poder modificiar o tamanho da tela
        telainicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //programa desligar ao fechar tela
        telainicio.setLayout(new BorderLayout()); //adicionando layout de bordar
        ImageIcon icon = new ImageIcon("src/img/2232688.png"); //adicionando imagem de icone
        telainicio.setIconImage(icon.getImage());   //adionando icone ao programa


        JMenuBar menuBar = new MenuBar(telainicio); //criando menubar
        telainicio.setJMenuBar(menuBar);

        telainicio.revalidate();  //renderizando os componentes
        telainicio.repaint();
    }
}
