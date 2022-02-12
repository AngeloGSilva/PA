package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class EsperaJogar extends EstadoAdapter {
    public EsperaJogar(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado vitoriaMini(int op){
        while(jogo.getVitoriaMini()<5){
            if (jogo.getMiniJogo() == 0) {
                if (jogo.getResultadoF() == op)
                    jogo.setVitoriaMini();
                if(jogo.getVitoriaMini()>=5)
                    return new VerificaMiniJogo(jogo);
                return this;
            }
        }
        //jogo.resetVitoriaMini();
        //if ganhou minijogo
        //return new EsperaJogada(jogo);
        //if nao ganhou minijogo
        jogo.resetVitoriaMini();
        return new VerificaMiniJogo(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperaJogar;
    }
}
