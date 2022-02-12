package jogo.logica.estados;

import jogo.logica.dados.Jogador;
import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class ProximoPlayer extends EstadoAdapter {
    public ProximoPlayer(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado trocaJogador(){
        //if turno%8 == 0

        if(jogo.getTipoJogo() == 0){
            if(jogo.getTurno() >= 4 && jogo.getTurno() % 4 == 0){
                return new EsperaResposta(jogo);
            }

        }else if(jogo.getTipoJogo() == 1){
            if(jogo.getJogadorAtual() == 0 && jogo.getTurno() >= 4 && jogo.getTurno() % 4 == 0){
                return new EsperaResposta(jogo);
            }
        }else if(jogo.getTipoJogo() == 2){
            return new EsperaJogada(jogo);
        }
        /*if((jogo.getTurnoJogador(player)) % 4 == 0) {
            System.out.println((jogo.getTurnoJogador(player)) % 4);
            return new EsperaResposta(jogo);
        }else*/
            return new EsperaJogada(jogo);
        //if turno%8 != 0
        //return new EsperaJogada(jogo);
    }

    @Override
    public IEstado creditos(){
        return new EscolheCreditos(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.ProximoPlayer;
    }
}
