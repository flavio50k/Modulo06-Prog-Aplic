package br.com.jogomemoria;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class TelaJogo extends JFrame implements ActionListener{
 
    /**
     * Construtor da classe
     * @Param jog - Objeto jogador, com os dados do jogador
     * @Param codJog - O tema escolhido
     * @Param fatorJogo - Inteiro que determina se o jogo é 4X4 ou 6X6
     */   
 
         //ClassLoader cl = this.getClass().getClassLoader();
        public TelaJogo( Jogador jog, int codJog, int fatorJogo ){        
 
        super( "Jogo da Memória" );    
 
        setLocation( 200, 10 );            
 
        addWindowListener(new WindowAdapter(){
 
                public void windowClosing( WindowEvent windowEvent ){
 
                    mostrarResumoJogo();
                }
        });        
 
        fator = fatorJogo;
 
        objJogadorJogada = jog;
        temaJogada( codJog );
        preparaArrayImagens();
        container = getContentPane();
 
        labelPontosJogador = new JLabel( "Jogador: " + objJogadorJogada.obterNome() + " >> Pontos: " );
 
        pontosJogador = new JLabel( ""+objJogadorJogada.obterPontos() );
 
        imagemSair = new ImageIcon(getClass().getResource("/imagens/jogo/sair.gif"));
        imagemSairRoll = new ImageIcon(getClass().getResource("/imagens/jogo/sairRoll.gif"));        
 
        // configura o botão sair
        botaoSair = new JButton(" Sair do Jogo ", imagemSair);
        botaoSair.setRolloverIcon( imagemSairRoll );
        botaoSair.addActionListener( this );        
 
        painelImagens = new JPanel();
        painelPontos = new JPanel();        
 
        // configurando o painel superior
        painelPontos.setBackground( Color.white );
        painelPontos.add( labelPontosJogador );
        painelPontos.add( pontosJogador );        
 
        grid = new GridLayout( fator, fator, 5, 5 );
 
        painelImagens.setLayout( grid );                
 
        imagemPadrao = new ImageIcon(getClass().getResource("/imagens/jogo/standard.gif"));
 
        posicoesFiguras = new MyButton[( fator * fator )];                
 
        for ( int cont = 0; cont < ( fator * fator ); cont++ ){
 
            posicoesFiguras[ cont ] = new MyButton(imagemPadrao, imagens[cont]);
            posicoesFiguras[ cont ].addActionListener( this );
            painelImagens.add( posicoesFiguras[ cont ] );
        }
 
        container.add( painelPontos, BorderLayout.NORTH);
        container.add( botaoSair, BorderLayout.SOUTH );
        container.add( painelImagens );
 
        double d_largura = (fator == 4?82.5:80);
 
        d_largura *= fator;
 
        int i_largura = (int) d_largura;
 
        setSize( i_largura, i_largura+70 );
        setVisible( true );
        setResizable( false );
    }
 
    /**
     * Prepara o Array de Imagens
     *
     */
    private void preparaArrayImagens(){
 
        int posicaoNoArray, x, y;
 
        this.imagens8 = new Icon[(fator * fator)/2];
 
        for ( x = 0; x < ((fator*fator)/2); x++ ){
 
            this.imagens8[ x ] = new ImageIcon(getClass().getResource(tema + ( x + 1 ) + ".GIF"));
        }
 
        this.imagens = new Icon[ (fator*fator) ];
 
        for ( x = 0; x < 2; x++ ){
 
            for ( y = 0; y < ((fator*fator)/2); y++ ){
 
                do{
                    posicaoNoArray = ( int ) ( Math.random() * (fator*fator) );        
 
                }while( this.imagens[ posicaoNoArray ] != null );
 
                this.imagens[ posicaoNoArray ] = imagens8[ y ];
 
            }
        }
    }
 
    /**
     * Descobre o tema escolhido
     * @Param codTema - Código do tema escolhido
     */
    private void temaJogada( int codTema ){
 
        switch( codTema ){
 
                case 1: this.tema = "/imagens/duke/";
            break;
 
            case 2: this.tema = "/imagens/tux/";
            break;
 
        }
    } 
 
    /**
     * Mostra o resumo do jogo ao sair
     *
     */
    private void mostrarResumoJogo(){
 
        resumoJogo = "Jogador: " + objJogadorJogada.obterNome() + "nn" +
        "Pontos: " + objJogadorJogada.obterPontos() + "nn" +
        "Quantidade de tentativas: " + qtdeTentativas;
 
        JOptionPane.showMessageDialog( null, ""+resumoJogo, "Resumo do Jogo",
        JOptionPane.INFORMATION_MESSAGE ); 
 
        setVisible( false );
        System.gc();
    }
 
    public void actionPerformed( ActionEvent event ){        
 
        // Se o evento for do botão Sair...
        if ( event.getSource() == botaoSair ){
 
            mostrarResumoJogo();
        }
 
        // Caso contrário é evento de botões de imagem
        else{
 
            // testa se é o primeiro clique
            if( primeiroClique ){
 
                qtdeTentativas++; 
 
                // testa se o jogador errou na jogada anterior
                if ( !acertou ){
 
                    botaoUm = (MyButton) botaoClicadoUm;
                    botaoDois = (MyButton) botaoClicadoDois;
 
                    botaoUm.setImagemPadrao();
                    botaoDois.setImagemPadrao();
                }
 
                botaoClicadoUm = event.getSource();
 
                botaoUm = (MyButton) botaoClicadoUm;
                botaoUm.setImagemBotao();                
 
                // indica que este foi o primeiro clique
                primeiroClique = !primeiroClique;
            }
 
            // se não for o primeiro clique
            else{                
 
                botaoClicadoDois = event.getSource();
                botaoDois = (MyButton) botaoClicadoDois;                                
 
                // verifica se o jogador clicou no mesmo botão
                if ( botaoClicadoDois == botaoClicadoUm ){
 
                    acertou = false;
 
                    JOptionPane.showMessageDialog( null, "Ação não permitida!",
                    "Ação Não Permitida", JOptionPane.WARNING_MESSAGE );
                }
 
                // se não for o mesmo botão...
                else{            
 
                    // coloca a imagem no botão
                    botaoDois.setImagemBotao();
 
                    // compara com o primeiro botão clicado
                    if ( botaoUm.getImagemBotao().equals( botaoDois.getImagemBotao())){
 
                        acertou = true;
                        qtdeAcerto++;                            
 
                        // Desabilita os botões
                        botaoUm.setEnabled( false );
                        botaoDois.setEnabled( false );                            
 
                        // incrementar pontos
                        objJogadorJogada.incrementarPontos();
 
                        pontosJogador.setText( ""+objJogadorJogada.obterPontos() );                            
 
                        // se foi o último par encontrado, apresenta resumo do jogo e fecha a janela
                        if ( qtdeAcerto == ((fator*fator)/2) ){
 
                            mostrarResumoJogo();
                            setVisible( false );
                            System.gc();
                        }
                    }
 
                    // se não for o mesmo botão
                    else{
 
                        acertou = false;                            
 
                        //decrementar pontos
                        objJogadorJogada.decrementarPontos();
 
                        pontosJogador.setText( ""+objJogadorJogada.obterPontos() );
                    }                    
 
                    // indica que este foi o segundo clique
                    primeiroClique = !primeiroClique;
                }
            }
        }
    } 
 
    private Object botaoClicadoUm = new Object();
    private Object botaoClicadoDois = new Object();
    private JLabel pontosJogador, labelPontosJogador;
    private JPanel painelImagens, painelPontos;
    private JButton botaoSair;
    private Icon imagemSair, imagemSairRoll, imagens[], imagemPadrao, imagens8[];
    private GridLayout grid;
    private Container container;
    private String tema, resumoJogo = "";
    private Jogador objJogadorJogada;
    private int fator, qtdeAcerto, qtdeTentativas = 0;
    private boolean primeiroClique = true;
    private boolean acertou = true;
    private MyButton botaoUm, botaoDois, posicoesFiguras[];    
 
} // fim TelaJogo