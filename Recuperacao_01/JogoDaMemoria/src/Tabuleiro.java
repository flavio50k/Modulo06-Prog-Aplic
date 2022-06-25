/*
 * Autor: Henrique Felipe
 * Site: https://blogcyberini.blogspot.com/
 * Janeiro de 2015
 */
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Esta classe representa um "Tabuleiro" de jogo da memória
 * com 12 cartas.
 */
public class Tabuleiro extends JPanel {
	//vetor com todas as cartas do jogo
	private final Carta[] cartas;
	//Última carta virada (sem par). Exerce papel auxiliar
	private Carta ultimaCartaVirada;	
	//conta quantas vezes o jogador errou um par
	private int erros;
	//conta quantos pares foram formados. Exerce papel auxiliar
	private int paresFormados;	
	//quando 'true' impede que as sejam viradas ("bloqueia" o método acao)
	private boolean lock;
	
	public Tabuleiro(){
		super();
		//****CONFIGURAÇÕES DO TABULEIRO****		
		//cria um vetor que irá conter as instâncias de "Carta" 
		cartas = new Carta[12];	
		//cria os objetos do tipo carta usando imagens do diretório do jogo e armazena no vetor "cartas"
		cartas[0] = new Carta(0, new ImageIcon(getClass().getResource("circulo.png")), this);
		cartas[1] = new Carta(0, new ImageIcon(getClass().getResource("circulo.png")), this);		
		cartas[2] = new Carta(1, new ImageIcon(getClass().getResource("estrela4.png")), this);
		cartas[3] = new Carta(1, new ImageIcon(getClass().getResource("estrela4.png")), this);		
		cartas[4] = new Carta(2, new ImageIcon(getClass().getResource("estrela5.png")), this);
		cartas[5] = new Carta(2, new ImageIcon(getClass().getResource("estrela5.png")), this);		
		cartas[6] = new Carta(3, new ImageIcon(getClass().getResource("pentagono.png")), this);
		cartas[7] = new Carta(3, new ImageIcon(getClass().getResource("pentagono.png")), this);		
		cartas[8] = new Carta(4, new ImageIcon(getClass().getResource("quadrado.png")), this);
		cartas[9] = new Carta(4, new ImageIcon(getClass().getResource("quadrado.png")), this);		
		cartas[10] = new Carta(5, new ImageIcon(getClass().getResource("triangulo.png")), this);
		cartas[11] = new Carta(5, new ImageIcon(getClass().getResource("triangulo.png")), this);
		//embaralha o vetor de cartas
		ShuffleAlgorithm.shuffle(cartas);
		//coloca as variáveis auxiliares em seus estados inicias para que o jogo possa iniciar
		ultimaCartaVirada = null;
		erros = 0;
		paresFormados = 0;
		lock = false;
		
		//****CONFIGURAÇÕES DA PARTE VISUAL****		
		//configura o painel com o layout "GridLayout"
		setLayout(new GridLayout(3, 4, 1, 1));
		//adiciona as cartas ao painel (o Tabuleiro em si)
		for(int i = 0; i < cartas.length; i++){
			add(cartas[i]);
		}		
	}
	/*
	 * O método "reset" reinicia o jogo.
	 */
	public void reset(){
		//este "for" coloca todas as cartas viradas para baixo
		for(int i = 0; i < cartas.length; i++){
			if(cartas[i].isViradaParaCima()){
				cartas[i].mudarPosicao();
			}			
		}
		//remove todas as cartas do tabuleiro (visualmente) 
		removeAll();
		//embaralha o vetor de cartas
		ShuffleAlgorithm.shuffle(cartas);
		//readiciona as cartas ao tabuleiro na nova ordem
		for(int i = 0; i < cartas.length; i++){
			add(cartas[i]);
		}
		//coloca as variáveis auxiliares em seus estados inicias
		ultimaCartaVirada = null;		
		erros = 0;
		paresFormados = 0;
		lock = false;
		//esses dois métodos atualizam a interface gráfica e as novas posições das cartas.
		revalidate();
		repaint();
	}
	/*
	 * O método "acao" controla o jogo em si. Como a única ação do
	 * jogador é clicar nas cartas para virá-las, então este métdo
	 * recebe somente a carta que foi clicada.
	 * 
	 * Se o jogador clicar numa carta que já está virada para cima,
	 * o método não irá fazer nada. Existem duas situações nas quais isso pode
	 * ocorrer: 1) a carta já formou um par ou 2) o jogador está
	 * tentando formar par daquela carta com outra.
	 * 
	 * Para formar pares, o jogador precisa escolher duas cartas. A 
	 * primeira das cartas escolhida terá sua referência armazenada na 
	 * variável "ultimaCartaVirada" (grosseiramente falando, a carta é
	 * armazenada nessa variável). Se um par for formado, ambas as
	 * cartas serão mantidas viradas para cima e . Se um par não foi formado,
	 * ambas as cartas são mantidas viradas para por um segundo e depois
	 * viradas para baixo. Formando par ou não, ao final "ultimaCartaVirada"
	 * terá seu valor alterado para "null".
	 * 
	 * Quando um par não é formado, a variável "lock" é alterada para "true".
	 * Quando isso ocorre, o método "acao" não faz nada quando é chamado. Isso
	 * evita que, durante o tempo de um segundo antes das cartas serem viradas
	 * para baixo, outras cartas possam ser viradas. Após um segundo, "lock"
	 * volta a ser "false", as cartas voltam para suas posições originais e 
	 * o método "acao" é "desbloqueado".
	 * 
	 * Quando o jogador erra um par, a variável "erros" é incrementada. Se
	 * um par é formado a variável "paresFormados" é incrementada e, em seguida,
	 * o método verifica se os seis pares já foram formados. Em caso positivo,
	 * uma mensagem é exibida informando o fim do jogo e a quantidade de erros.
	 * Então o jogo é reiniciado através do método "reset". 
	 */
	public void acao(Carta carta){
		//se a carta estiver virada para baixo e o método "acao" não estiver bloqueado
		if(!carta.isViradaParaCima() && !lock){//inicio do if
			//Se "carta" for a primeira escolhida para tentar formar um par... 
			if(ultimaCartaVirada == null){//inicio do if
				//...vira-a para cima e armazena a sua referência em "ultimaCartaVirada"
				carta.mudarPosicao();				
				ultimaCartaVirada = carta;
			}else{//inicio do else
				//...senão, então a primeira carta já foi escolhida e "carta" é a segunda. 
				//Se a segunda carta for igual a primeira....  
				if(carta.equals(ultimaCartaVirada)){//inicio do if
					//ambas formam um par e são mantidas viradas para cima,
					//"ultimaCartaVirada" para a ser "null" (assim uma nova tentativa de par pode ser feita)
					ultimaCartaVirada = null;
					//vira a carta para cima				
					carta.mudarPosicao();	
					//incrementa "paresFormados"
					paresFormados++;
					//Se "paresFormados" for igual a 6, então todos os pares ja foram formados... 
					if(paresFormados == 6){//inicio do if
						//fim do jogo, exibe mensagem com os erros
						JOptionPane.showMessageDialog(this,
								"O jogo acabou! Quantidade de erros: " + erros,
								"Fim de jogo",
								JOptionPane.INFORMATION_MESSAGE);
						reset();//reinicia o jogo
					}//fim do if
				}else{//inicio do else
					//...senão a primeira e a segunda carta não formam um par, já que são diferentes
					//Tarefa "t1": virar a carta para cima para que o jogador veja e "bloquear" o método "acao"
					TimerTask t1 = new TimerTask(){
						@Override
						public void run() {
							carta.mudarPosicao();
							lock = true;
						}						
					};
					//Tarefa "t2": colocar ambas as cartas viradas para baixo, desbloquear "acao", incrementar "erros"...
					//...e alterar o valor de "ultimaCartaVirada" para "null".
					TimerTask t2 = new TimerTask(){
						@Override
						public void run() {
							ultimaCartaVirada.mudarPosicao();
							carta.mudarPosicao();
							ultimaCartaVirada = null;
							erros++;
							lock = false;
						}						
					};
					//Timer é um "agendador" de tarefas
					Timer timer = new Timer();
					//Agenda as tarefas "t1" e "t2":
					//"t1" é executado 1 milissegundo após o agendamento
					timer.schedule(t1, 1);
					//"t2" é executado 1 segundo após o agendamento
					timer.schedule(t2, 1000);
				}//fim do if...else
			}//fim do if...else
		}//fim do if
	}//fim do método "acao"
}
