import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PrimitiveIterator;
import javax.swing.JTextArea;
import java.io.FileWriter;


public class MenuBar extends JMenuBar {
    public MenuBar(JFrame telainicio) {     //criando os componentes do menubar e menu bar
        JMenu menu = new JMenu("Menu");
        JMenuItem novoDiario = new JMenuItem("Novo Diário");        //adicionando "Novo diário"
        ImageIcon newIcon = new ImageIcon("src/img/7604035.png");
        novoDiario.setIcon(newIcon);
        novoDiario.setIconTextGap(10);
        novoDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK)); //criando uma ação rapida
        novoDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JTextArea novoJTextAreaArquivo = new JTextArea();       //criando uma tela de texto nova e adicionando a tela principal
                novoJTextAreaArquivo.setSize(50,50);
                JScrollPane scrollNovo = new JScrollPane(novoJTextAreaArquivo);
                telainicio.add(scrollNovo, BorderLayout.CENTER);
                telainicio.revalidate();
                telainicio.repaint();
            }
        });

        JMenuItem abrirDiario = new JMenuItem("Abrir Diário");      //criando "Abrir diário"
        ImageIcon openIcon = new ImageIcon("src/img/7604005.png");
        abrirDiario.setIcon(openIcon);
        abrirDiario.setIconTextGap(10);
        abrirDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
        abrirDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File arquivo;
                JFileChooser abrirArquivo = new JFileChooser();     //inicia um escolhedor de arquivos
                int returnVal = abrirArquivo.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {     //se o arquivo escolhido for valido ele adiciona o conteudo a arquivo
                    arquivo = abrirArquivo.getSelectedFile();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi selecionado um Diario");       //se não ele manda um erro
                    return;
                }
                try {
                    if (!arquivo.exists()) {
                        arquivo.createNewFile();    //caso o arquivo não exista ele cria um novo arquivo
                    }
                    FileReader leitor = new FileReader(arquivo);            //função para ler o conteudo dentro do arquivo e adiconar a uma variavel
                    StringBuilder printarquivo = new StringBuilder();
                    int c;
                    while ((c = leitor.read()) != -1) {
                        printarquivo.append((char) c);
                    }
                    leitor.close();
                    JTextArea telaAberta = new JTextArea();
                    telaAberta.setSize(50, 50);
                    telaAberta.setText(printarquivo.toString());        //adiciona o conteudo lido dentro da jtextarea
                    JScrollPane scrollabrir = new JScrollPane(telaAberta);

                    telainicio.add(scrollabrir, BorderLayout.CENTER);
                    telainicio.revalidate();
                    telainicio.repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        JMenuItem salvarDiario = new JMenuItem("Salvar Diário");    //salvar o conteudo do Jtextpanel dentro de um arquivo txt
        ImageIcon saveIcon = new ImageIcon("src/img/3720719.png");
        salvarDiario.setIcon(saveIcon);
        salvarDiario.setIconTextGap(10);
        salvarDiario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        salvarDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextArea textArea = (JTextArea) ((JScrollPane) telainicio.getContentPane().getComponent(0)).getViewport().getView(); //pega o conteudo do jtextarea
                String diaryContent = textArea.getText(); //aciciona a uma string


                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showSaveDialog(null);


                if (returnVal == JFileChooser.APPROVE_OPTION) {         //escolhe um arquivo para salvar o conteudo ou criar um novo arquivo
                    File saveFile = fileChooser.getSelectedFile();


                    if (!saveFile.exists()) {
                            saveFile = new File(saveFile.getParent(), saveFile.getName() + ".txt");  //criando arquivo caso não exista com .txt

                    }


                    try (FileWriter writer = new FileWriter(saveFile)) {
                        writer.write(diaryContent);
                        JOptionPane.showMessageDialog(null, "Diário salvo com sucesso!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar o diário: " + ex.getMessage());
                    }
                }

            }
        });


        menu.add(novoDiario);
        menu.add(abrirDiario); //adicionando o menu a tela inicial
        menu.add(salvarDiario);

        add(menu);
    }
}
