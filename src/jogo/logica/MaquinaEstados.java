package jogo.logica;


import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;
import jogo.logica.estados.IEstado;
import jogo.logica.estados.Inicio;

import java.util.List;

public class MaquinaEstados {
    IEstado atual;
    Jogo jogo;


    public MaquinaEstados() {
        jogo = new Jogo();
        atual = new Inicio(jogo);
    }
    //__________________relacionado aos estados____________
    public void vitoriaMini(int op){
        atual = atual.vitoriaMini(op);
    }
    public void comeca(){
        atual = atual.comeca();
    }
    public void sair(){
        atual = atual.sair();
    }
    public void escolheColuna(int coluna, boolean pecaEspecial){
        atual = atual.escolheColuna(coluna, pecaEspecial);
    }
    public void atribuiPeca(boolean venceu){
        atual = atual.atribuiPeca(venceu);
    }
    public void trocaJogador(){
        atual = atual.trocaJogador();
    }
    public void ChamaMiniJogo(boolean escolha){
        atual = atual.ChamaMiniJogo(escolha);
    }
    public void vitoria(){
        atual = atual.vitoria();
    }
    public void gastarCreditos(int quantidade){
        atual = atual.gastarCreditos(quantidade);
    }
    public void setup(int escolha, String jogador1, String jogador2){
        atual = atual.setup(escolha, jogador1, jogador2);
    }
    public void creditos(){
        atual = atual.creditos();
    }
    public Situacao getSituacao(){
        return atual.getSituacao();
    }


    //________________gets do jogo____________________________
    public String getSituacaoJogo(){
        return jogo.toString();
    }

    public int getCreditos(){return jogo.getCreditos();}

    public char[][] getTabalea(){
        return jogo.getTab();
    }

    public int[] getHistorico(){return jogo.getHistorico();}

    public int getJogador(){
        return jogo.getJogadorAtual();
    }

    public int getTurno(){
        return jogo.getTurno();
    }

    public int getVencedor(){
        return jogo.getVencedor();
    }

    public String getNome(){
        return jogo.getNomeJogador();
    }

    public int getTipoJogo(){
        return jogo.getTipoJogo();
    }

    public int getPecas(){
        return jogo.getPecasEspeciais();
    }

    public boolean getEmpate(){
        int i = jogo.getEmpate();
        if(i == 1)
            return true;
        return false;
    }

    public int getVitoriaMini(){
        return jogo.getVitoriaMini();
    }

    public void resetVitoriaMini(){
        jogo.resetVitoriaMini();
    }

    public String getNome2(){
        return jogo.getNome2();
    }

    public String getNome1(){
        return jogo.getNome1();
    }

    public int getResultado(){
        return jogo.getResultado();
    }

    public int getResultadoF(){
        return jogo.getResultadoF();
    }

    public int getOperador(){
        return jogo.getOperador();
    }

    public int getNumero1(){
        return jogo.getNumero1();
    }

    public int getNumero2(){
        return jogo.getNumero2();
    }

    public List<String> getlog(){
        return jogo.getlog();
    }

    public void clearLog(){
        jogo.clearLog();
    }

}
