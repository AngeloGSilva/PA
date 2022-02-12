package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class EscolheCreditos extends EstadoAdapter {
    public EscolheCreditos(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado gastarCreditos(int quantidade){
        if(jogo.getTurnosTotal() < quantidade)
            return new EscolheCreditos(jogo);

        jogo.tiraCreditos(quantidade);
        jogo.reverterJogadas(quantidade);
        System.out.println(jogo.getCreditos());
        return new EsperaJogada(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EscolheCreditos;
    }
}

