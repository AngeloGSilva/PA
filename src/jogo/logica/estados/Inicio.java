package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public class Inicio extends EstadoAdapter{
    public Inicio(Jogo jogo){ super(jogo);}

    @Override
    public IEstado comeca(){
        return new AguardaEscolha(jogo); //o new nao é para criar novo objeto
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Inicio;
    }
}