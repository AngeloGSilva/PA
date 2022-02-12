package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class Fim extends EstadoAdapter {
    public Fim(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado comeca(){
        return new AguardaEscolha(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Fim;
    }
}
