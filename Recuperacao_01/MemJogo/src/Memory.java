import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.lang.Math;

public class Memory extends JFrame{

    private static final long serialVersionUID = 1L;

    int pontos = 100;

    Random RandomNumber = new Random();
    int Aleatorio[] = new int [16];
    int Posicao_do_vetor_Aleatorio[] = new int [16];

    private final JToolBar Barra_Ferramenta = new JToolBar();

    private final JButton Button_Novo_Jogo = new JButton("Novo Jogo");
    private final JButton[] Escolha = new JButton[16];
    private final Icon[] images = new Icon[8];

    private final JPanel Panel = new JPanel();
    private final JPanel Barra_de_Status = new JPanel();

    private final GridLayout Layout_do_Jogo = new GridLayout(4,4);
    private final Font Fonte = new Font("Lucida Console", Font.BOLD, 36);

    private final JLabel Pontuacao_do_Jogador = new JLabel("Pontos: 100");

    public Memory() {
        super("Jogo da Memória de Química Orgânica");
        Barra_Ferramenta.add(Button_Novo_Jogo);
        add(Barra_Ferramenta, BorderLayout.NORTH);
        for (int i=0; i<16; ++i){
            Escolha[i] = new JButton();
            Panel.add(Escolha[i]);
            Escolha[i].setFont(Fonte);
            Escolha[i].setVisible(true);
        }
        Panel.setLayout(Layout_do_Jogo);
        add(Panel, BorderLayout.CENTER);
        Barra_de_Status.add(Pontuacao_do_Jogador);
        add(Barra_de_Status, BorderLayout.SOUTH);

        Eventos_JogoDaMemoria Handler = new Eventos_JogoDaMemoria();
        for (int i=0; i<16; ++i){
            Escolha[i].addActionListener(Handler);
        }
        Button_Novo_Jogo.addActionListener(Handler);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        for(int i=0; i<images.length; i++) {
            images[i] = new ImageIcon("imgs\\"+i+".jpg");
        }
    }

    private class Eventos_JogoDaMemoria implements ActionListener{
        int Cont_Acertos,Primeiro_Click,Segundo_Click;
        int Numero_Click, posi, cont, pontos_Anterior;
        boolean Novo_Jogo = true;
        boolean Re_Iniciar = false;
        public void actionPerformed(ActionEvent event){
            if (event.getSource() == Button_Novo_Jogo){
                Novo_Jogo = true;
                Re_Iniciar = false;
            }
            if (Novo_Jogo == true){
                Cont_Acertos = 0;
                pontos_Anterior = pontos;
                pontos = 100;
                Numero_Click = 0;
                posi = 0; cont = 16;
                Primeiro_Click = 0;
                Segundo_Click = 0;
                for (int i=0; i<16; ++i){
                    Escolha[i].setEnabled(true);
                }
                if (Re_Iniciar == false){

                    for (int i=0; i<16; ++i){
                        Posicao_do_vetor_Aleatorio[i] = i;
                    }

                    for (int i=0; i<8; ++i){

                        for (int j=0; j<2; ++j){
                            posi = RandomNumber.nextInt(cont);
                            Aleatorio[Posicao_do_vetor_Aleatorio[posi]] = i;
                            if (posi < cont){
                                for (int q=(posi+1); q<(cont); ++q){
                                    Posicao_do_vetor_Aleatorio[q-1] = Posicao_do_vetor_Aleatorio[q];
                                }
                            } cont--;
                        }
                    }

                }
                Novo_Jogo = false;
            }

            for (int i=0; i<16; ++i){
                if (event.getSource() == Escolha[i]){
                    Escolha[i].setIcon(images[Aleatorio[i]]);
                    Escolha[i].setEnabled(false);
                    Escolha[i].setVisible(true);
                    Numero_Click++;
                    if (Numero_Click == 1) Primeiro_Click = i;
                    if (Numero_Click == 2){
                        Segundo_Click = i;
                        ///////////////Clicks_não_conseguidos///////////////


                        if (Aleatorio[Primeiro_Click] > Aleatorio[Segundo_Click]){

                            if (Math.abs(Aleatorio[Primeiro_Click] - 7)== Aleatorio[Segundo_Click]){
                                Cont_Acertos++;
                                pontos+=10;
                            }
                            else {
                                JOptionPane.showMessageDialog(Memory.this, "Errado");
                                Escolha[Primeiro_Click].setIcon(null);
                                Escolha[Segundo_Click].setIcon(null);
                                Escolha[Primeiro_Click].setEnabled(true);
                                Escolha[Segundo_Click].setEnabled(true);
                            }
                        }
                        else{

                            if (Aleatorio[Primeiro_Click] ==Math.abs(Aleatorio[Segundo_Click] - 7)){
                                Cont_Acertos++;
                                pontos+=10;
                            }
                            else {
                                JOptionPane.showMessageDialog(Memory.this, "Errado");
                                Escolha[Primeiro_Click].setIcon(null);
                                Escolha[Segundo_Click].setIcon(null);
                                Escolha[Primeiro_Click].setEnabled(true);
                                Escolha[Segundo_Click].setEnabled(true);
                            }
                        }
                        Numero_Click = 0;
                    }
                }
            }
            if (Cont_Acertos == 8){
                Cont_Acertos = 0;
                if (pontos > pontos_Anterior) {
                }
            }
            if (pontos < 0) pontos = 0;
            Pontuacao_do_Jogador.setText("Pontos: " + pontos);

        }
    }
    public static void main(String [] args){
        new Memory();
    }
}