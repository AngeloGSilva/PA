package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class VerificaMiniJogo extends EstadoAdapter{
    public VerificaMiniJogo(Jogo jogo){
        super(jogo);
    }
    @Override
    public IEstado atribuiPeca(boolean venceu) {
        //if ganhou minijogo
        //return new EsperaJogada(jogo);
        //if nao ganhou minijogo
        if (venceu == true){
            jogo.setPecaEspecial();
            jogo.poeLog(jogo.getNomeJogador() + "Ganhou uma peca especial pela vitoria do mini jogo.");
            return new EsperaJogada(jogo);
        }else
            return new ProximoPlayer(jogo);

    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperaJogar;
    }

}
