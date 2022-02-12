package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

import java.util.Random;

public class EsperaJogada extends EstadoAdapter {
    public EsperaJogada(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado escolheColuna(int coluna, boolean pecaEspecial) {
        //System.out.println(coluna);
        if (jogo.getTipoJogo() == 0) {
            if (jogo.getPecasEspeciais()<=0) {
                jogo.Jogada(coluna);
                jogo.poeLog(jogo.getNomeJogador() + " jogou na coluna: " + coluna);
                if(jogo.empate() == false) {
                    return new VerificaVitoria(jogo);
                }else{
                    return new Fim(jogo);
                }
                }else if(jogo.getPecasEspeciais()>0){
                if (pecaEspecial == true) {
                    jogo.jogarPecaEspecial(coluna);
                    jogo.Jogada(coluna);
                    jogo.poeLog(jogo.getNomeJogador() + "Jogou uma Peca Especial e jogou tudo na coluna: " + coluna);
                    if(jogo.empate() == false) {
                        return new VerificaVitoria(jogo);
                    }else{
                        return new Fim(jogo);
                    }
                }else {
                    jogo.Jogada(coluna);
                    jogo.poeLog(jogo.getNomeJogador() + " jogou na coluna: " + coluna);
                    if(jogo.empate() == false) {
                        return new VerificaVitoria(jogo);
                    }else{
                        return new Fim(jogo);
                    }
                }
            }
        } else if (jogo.getTipoJogo() == 1) {
            if (jogo.getJogadorAtual() == 0) {
                if (jogo.getPecasEspeciais()<=0) {
                    jogo.Jogada(coluna);
                    jogo.poeLog(jogo.getNomeJogador() + " jogou na coluna: " + coluna);
                    if(jogo.empate() == false) {
                        return new VerificaVitoria(jogo);
                    }else{
                        return new Fim(jogo);
                    }
                }else if(jogo.getPecasEspeciais()>0){
                    if (pecaEspecial == true) {
                        jogo.jogarPecaEspecial(coluna);
                        jogo.Jogada(coluna);
                        jogo.poeLog(jogo.getNomeJogador() + "Jogou uma Peca Especial e jogou tudo na coluna: " + coluna);
                        if(jogo.empate() == false) {
                            return new VerificaVitoria(jogo);
                        }else{
                            return new Fim(jogo);
                        }
                    }else {
                        jogo.Jogada(coluna);
                        jogo.poeLog(jogo.getNomeJogador() + " jogou na coluna: " + coluna);
                        if(jogo.empate() == false) {
                            return new VerificaVitoria(jogo);
                        }else{
                            return new Fim(jogo);
                        }
                    }
                }
            } else {
                    coluna = jogo.AI(new Random());
                    jogo.Jogada(coluna);
                    jogo.poeLog(jogo.getNomeJogador() + " jogou na coluna: " + coluna);
                if(jogo.empate() == false) {
                    return new VerificaVitoria(jogo);
                }else{
                    return new Fim(jogo);
                }
            }
        }else{
            if(jogo.getJogadorAtual() == 0 || jogo.getJogadorAtual() == 1) {
                coluna = jogo.AI(new Random());
                jogo.Jogada(coluna);
                jogo.poeLog(jogo.getNomeJogador() + " jogou na coluna: " + coluna);
                if(jogo.empate() == false) {
                    return new VerificaVitoria(jogo);
                }else{
                    return new Fim(jogo);
                }
            }
        }
        return new EsperaJogada(jogo);
    }

    @Override
    public IEstado sair(){
        return new Fim(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperaJogada;
    }
}
