/*
 * Autor: Henrique Felipe
 * Site: https://blogcyberini.blogspot.com/
 * Janeiro de 2015
 */
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

//Classe principal do jogo da memória
public final class JogoDaMemoria {
	public static void main(String[] args) {
		//****AJUSTA O LOOK AND FEEL****
		try{
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		}catch (Exception e){
			//faz nada
		}
		
		try{
			new JanelaDoJogo().setVisible(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro desconhecido: "+e.getMessage()+"\n O jogo será finalizado!",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);//encerra o programa
		}
		
	}
}
