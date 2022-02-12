package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class EsperaResposta extends EstadoAdapter {
    public EsperaResposta(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado ChamaMiniJogo(boolean escolha){
        if(escolha == true){
        return new EsperaJogar(jogo);
        }
        return new EsperaJogada(jogo);
    }



    @Override
    public Situacao getSituacao() {
        return Situacao.EsperaResposta;
    }
}
