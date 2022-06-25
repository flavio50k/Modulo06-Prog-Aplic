/*
 * Autor: Henrique Felipe
 * Site: https://blogcyberini.blogspot.com/
 * Janeiro de 2015
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * A classe "Carta" representa uma carta no jogo da memória.
 * Além disso, também é um componente de interface gráfica do tipo "JLabel". 
 */
public class Carta extends JLabel {
	//indica se a carta está virada para cima no tabuleiro (se sim, o valor é true)
	private boolean viradaParaCima;
	//imagem/ícone da carta quando virada para cima
	private Icon imagemFrontalDaCarta;
	//imagem/ícone da carta quando virada para baixo
	private Icon imagemTraseiraDaCarta;
	//ID da carta
	private int id;
	//tabuleiro com todas as cartas do jogo
	private Tabuleiro tabuleiro;
	
	public Carta(int id, Icon imagemFrontalDaCarta, Tabuleiro tabuleiro){
		super();
		this.imagemFrontalDaCarta = imagemFrontalDaCarta;
		imagemTraseiraDaCarta = new ImageIcon(getClass().getResource("interrogacao.png"));
		this.tabuleiro = tabuleiro;
		viradaParaCima = false;		
		this.id = id;
		setIcon(imagemTraseiraDaCarta);
		addMouseListener(new MouseClique());
	}	
	//retorna 'true' se a carta estiver virada para cima ou, caso contrário, retorna false.
	public boolean isViradaParaCima() {
		return viradaParaCima;
	}
	/*
	 * Se uma carta estiver virada para cima, ela será virada para baixo. Se estiver
	 * virada para baixo, ela será virada para cima.
	 */	
	public void mudarPosicao(){
		if(isViradaParaCima()){
			viradaParaCima = false;
			setIcon(imagemTraseiraDaCarta);
		}else{
			viradaParaCima = true;		
			setIcon(imagemFrontalDaCarta);
		}		
	}

	/*
	 * Compara este objeto com outro. Dois objetos do 
	 * tipo 'Carta' serão iguais se tiverem o mesmo ID
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	//'MouseListener' que tratará o evento do clique na carta
	private class MouseClique implements MouseListener{
		
		@Override
		public void mouseReleased(MouseEvent e) {
			//obtém a carta que foi clicada e passa-a para o tabuleiro
			Carta c = (Carta) e.getSource();
			c.tabuleiro.acao(c);			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			//não precisa implementar
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			//não precisa implementar
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//não precisa implementar
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//não precisa implementar
		}		
	}
}
