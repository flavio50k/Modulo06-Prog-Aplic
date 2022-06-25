package br.com.jogomemoria;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class TelaUm extends JFrame implements ActionListener, ItemListener{    
 
    private Container container;
    private JButton botaoSair, botaoIniciarJogo;
    private JPanel painelBotoes, painelDados, painelCabecalho;
    private JPanel painelCentro, painelRodape, painelImagem;
    private Icon imagemPainel, imagemRodape, imagemJogar, titulo;
    private Icon imagemJogarRoll, imagemSair, imagemSairRoll;
    private JLabel labelImagemPainel, nomeJogador, temaJogada;
    private JLabel texto1, desenvolvimento, autor;
    private GridLayout gridBotoes, gridDados, gridCabecalho, gridRodape;
    private JComboBox temasJogada;
    private int indiceTema = 1;
    private Jogador objJogador;
    private TelaJogo objTelaJogo;
    private JTextField fieldNomeJogador;
    private Font fonte18, fonte10;
    private JTextArea telaSaida = new JTextArea();
    private boolean jogoFacil = false;
    private ButtonGroup dificuldadeGroup;
    private JMenu menuDificuldade;
    private JMenuBar barraMenu;
    private JRadioButtonMenuItem facil, dificil;
    private JLabel nivelDificuldade;
 
    String nomeObjJogador;
 
    // os temas para os jogos
    private String nomesTemas[] =
    { "Duke", "Tux"};    
 
    // índices dos temas para os jogos
    private int indiceTemas[] =
    { 1, 2 };    
 
    public TelaUm(){                   
 
        super( "Bem-vindo ao Jogo da Memória!" );                
 
        // adiciona um listener à janela
        addWindowListener(            
 
            // classe interna anônima
            new WindowAdapter(){
 
                // trata o evento de quando o usuário fecha a janela
                public void windowClosing( WindowEvent windowEvent ){
 
                    saidaPrograma();
                }
            }// fim da classe interna anônima    
 
        );
 
        nivelDificuldade = new JLabel("Nível de dificuldade: DIFÍCIL");
        nivelDificuldade.setForeground(Color.red);
 
        // gerenciadores de layout
        gridBotoes = new GridLayout( 1, 2, 5, 5 );
        gridDados = new GridLayout( 6, 1, 10, 10 );
        gridCabecalho = new GridLayout( 1, 1, 10, 10 );
        gridRodape = new GridLayout( 1, 1, 10, 10 );
 
        // painel da imagem (esquerda)
        imagemPainel = new ImageIcon(getClass().getResource("/imagens/jogo/painel.gif"));
        labelImagemPainel = new JLabel( imagemPainel );
        painelImagem = new JPanel();
        painelImagem.add( labelImagemPainel );
        painelImagem.setBackground( Color.white );
 
        fonte10 = new Font( "Verdana", Font.ITALIC, 10 );
 
        // imagens dos botões
        imagemJogar = new ImageIcon(getClass().getResource("/imagens/jogo/jogar.gif"));
        imagemJogarRoll = new ImageIcon(getClass().getResource("/imagens/jogo/jogarRoll.gif")); // imagem Rollover
        imagemSair = new ImageIcon(getClass().getResource("/imagens/jogo/sair.gif"));
        imagemSairRoll = new ImageIcon(getClass().getResource("/imagens/jogo/sairRoll.gif")); // imagem Rollover        
 
        // botão Iniciar Jogo
        botaoIniciarJogo = new JButton( "Iniciar Jogo", imagemJogar );
        botaoIniciarJogo.setRolloverIcon( imagemJogarRoll );
        botaoIniciarJogo.addActionListener( this );
        botaoIniciarJogo.setSize( 250, 15 );
        botaoIniciarJogo.setHorizontalAlignment( SwingConstants.LEFT );
 
        // botão Sair
        botaoSair = new JButton( "Abandonar o Jogo", imagemSair );
        botaoSair.setRolloverIcon( imagemSairRoll );
        botaoSair.addActionListener( this );
        botaoSair.setSize( 250, 15 );
        botaoSair.setHorizontalAlignment( SwingConstants.RIGHT );
        botaoSair.setHorizontalTextPosition( SwingConstants.LEFT );
 
        // painel de botões (inferior)
        painelBotoes = new JPanel();
        painelBotoes.setBackground( Color.lightGray );
        painelBotoes.setLayout( gridBotoes );
        painelBotoes.add( botaoSair );
        painelBotoes.add( botaoIniciarJogo );        
 
        //cabeçalho
        titulo = new ImageIcon(getClass().getResource("/imagens/jogo/titulo.gif"));
        texto1 = new JLabel( titulo );
        texto1.setHorizontalAlignment( SwingConstants.CENTER );        
 
        // painel de cabeçalho
        painelCabecalho = new JPanel();
        painelCabecalho.setLayout( gridCabecalho );
        painelCabecalho.setBackground( Color.lightGray );
        painelCabecalho.add( texto1 );
 
        // label do nome do jogador
        nomeJogador = new JLabel("Informe seu nome:");
        nomeJogador.setHorizontalAlignment( SwingConstants.LEFT );
 
        // campo do nome do jogador
        fieldNomeJogador = new JTextField( 15 );
        fieldNomeJogador.setHorizontalAlignment( SwingConstants.LEFT );
 
        // label do tema da jogada
        temaJogada = new JLabel( "Escolha o tema:" );
        temaJogada.setHorizontalAlignment( SwingConstants.LEFT );
 
        // ComboBox do tema da jogada
        temasJogada = new JComboBox( nomesTemas );
        temasJogada.addItemListener( this );
        temasJogada.setMaximumRowCount( 4 );
 
        // configuração do painel central
        painelCentro = new JPanel();
        painelCentro.setLayout( gridDados );
        painelCentro.setBackground( Color.lightGray );
        painelCentro.add( temaJogada );
        painelCentro.add( temasJogada );
        painelCentro.add( nomeJogador );
        painelCentro.add( fieldNomeJogador );
        //painelCentro.add( som );
        painelCentro.add(nivelDificuldade);
 
        menuDificuldade = new JMenu("Nível de Dificuldade");
        menuDificuldade.setBackground( Color.lightGray );
 
        dificuldadeGroup = new ButtonGroup();
 
        dificil = new JRadioButtonMenuItem("Difícil (6X6)");
        dificil.setSelected(true);
 
        dificil.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent evt){
                jogoFacil = false;
                nivelDificuldade.setText("Nível de dificuldade: DIFÍCIL");
                nivelDificuldade.setForeground(Color.red);
            }
        });
 
        facil = new JRadioButtonMenuItem("Fácil (4X4)");
 
        facil.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent evt){
                jogoFacil = true;
                nivelDificuldade.setText("Nível de dificuldade: FÁCIL");
                nivelDificuldade.setForeground(Color.blue);
            }
        });
 
        dificuldadeGroup.add(dificil);
        dificuldadeGroup.add(facil);
 
        menuDificuldade.add(dificil);
        menuDificuldade.add(facil);
 
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        barraMenu.setBackground( Color.lightGray );
 
        barraMenu.add(menuDificuldade);        
 
        // imagem do rodapé
        imagemRodape = new ImageIcon(getClass().getResource("/imagens/jogo/java.gif"));
 
        // texto do rodapé
        desenvolvimento = new JLabel(
        "Desenvolvido em Java",
        imagemRodape, SwingConstants.CENTER );
        desenvolvimento.setFont( fonte10 );        
 
        // configuração do painel de rodapé
        painelRodape = new JPanel();
        painelRodape.setLayout( gridRodape );
        painelRodape.setBackground( Color.white );
        painelRodape.add( desenvolvimento );        
 
        // configuração do painel de dados (que possui o painel de cabeçalho,
        // o painel central e o painel de botões
        painelDados = new JPanel();
        painelDados.setLayout( new BorderLayout( 10, 10 ));
        painelDados.setBackground( Color.lightGray );
        painelDados.add( painelCabecalho, BorderLayout.NORTH);
        painelDados.add( painelCentro );
        painelDados.add( painelBotoes, BorderLayout.SOUTH );        
 
        // configuração do container (que tem toda essa bagunça aí!!! =)
        container = getContentPane();
        container.setLayout( new BorderLayout( 5, 5 ) );
        container.setBackground( Color.lightGray );
        container.add( painelRodape, BorderLayout.SOUTH );
        container.add( painelImagem, BorderLayout.WEST );
        container.add( painelDados );        
 
        setSize( 550, 380 );
        setVisible( true );
        setResizable( false );
 
    }
 
    private void saidaPrograma(){
 
        telaSaida.setText(
 
            "tJogo da Memória - 2005nn"+
            "tDesenvolvido por: Luiz Gustavo Stábile de Souzan"+
            "tGraduando em Análise de Sistemas pela "+
            "Faculdade de Ciências e Tecnologia de Birigui  n"+
            "tContato: luizgustavoss@gmail.comnn"+
            "tLinguagem de Desenvolvimento: Java (TM) 2 Standard Edition nn"+
            "tRequisitos: J2RE - Java(TM) 2 Runtime Environmentnn"+
            "tEste jogo foi desenvolvido com fins educacionais, portanto sem nenhum tipo de garantia.nn"
 
        );
 
        JOptionPane.showMessageDialog(null, telaSaida,
        "Informações sobre o Jogo", JOptionPane.PLAIN_MESSAGE);
        System.exit( 0 );
    }
 
    public void actionPerformed( ActionEvent event ){
 
            // se o evento for do botão sair
            if ( event.getSource() == botaoSair ){
 
                saidaPrograma();
 
            }
 
            // senão é do botão iniciar jogo
            else if ( event.getSource() == botaoIniciarJogo ){                
 
                nomeObjJogador = fieldNomeJogador.getText();
                objJogador = new Jogador( nomeObjJogador );
 
                if(jogoFacil)
                    objTelaJogo = new TelaJogo( objJogador, indiceTema, 4 );
                else
                    objTelaJogo = new TelaJogo( objJogador, indiceTema, 6 );
            }
    }
 
    public void itemStateChanged( ItemEvent event ){
 
        if ( event.getSource() == temasJogada ){
 
            if ( event.getStateChange() == ItemEvent.SELECTED )
 
                indiceTema = indiceTemas[ temasJogada.getSelectedIndex() ];
        }
    }
 
    public static void main( String args[] ){
 
        TelaUm application = new TelaUm();
 
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setLocationRelativeTo( null );
    }
 
} // fim da classe TelaUm