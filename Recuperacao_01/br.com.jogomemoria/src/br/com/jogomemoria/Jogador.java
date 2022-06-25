package br.com.jogomemoria;

public class Jogador{
 
    private final String nome;
    private int pontos;
 
    public Jogador(String nomeJogador){
 
        nome = (nomeJogador.equals("")? "Jogador sem nome...coitado! ": nomeJogador );
        pontos = 0;
    }
 
    public String obterNome(){
 
        return nome;
    }
 
    public int obterPontos(){
 
        return pontos;
    }
 
    public void incrementarPontos(){
 
        pontos += 5;
    }
 
    public void decrementarPontos(){
 
        pontos--;
    }
 
} // fim da classe pessoa