package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class VerificaVitoria extends EstadoAdapter {
    public VerificaVitoria(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado vitoria(){
        if(jogo.vitoria() == true) {
            if (jogo.getJogadorAtual() == 0) {
                jogo.poeLog(jogo.getNomeJogador() + " Ganhou o jogo.");
                return new Fim(jogo);
            }else {
                jogo.poeLog(jogo.getNomeJogador() + " Ganhou o jogo.");
                return new Fim(jogo);
            }
        }
        return new ProximoPlayer(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.VerificaVitoria;
    }
}
