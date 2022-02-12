package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public abstract class EstadoAdapter implements IEstado {

    protected Jogo jogo;

    protected EstadoAdapter(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public IEstado comeca() {
        return this;
    }

    @Override
    public IEstado sair() {
        return this;
    }

    @Override
    public IEstado escolheColuna(int coluna, boolean pecaEspecial) {
        return this;
    }

    @Override
    public IEstado atribuiPeca(boolean venceu) {
        return this;
    }

    @Override
    public IEstado trocaJogador() {
        return this;
    }

    @Override
    public IEstado vitoriaMini(int op){
        return this;
    }

    @Override
    public IEstado ChamaMiniJogo(boolean escolha) {
        return this;
    }

    @Override
    public IEstado creditos(){return this;}

    @Override
    public IEstado vitoria() {
        return this;
    }

    @Override
    public IEstado gastarCreditos(int quantidade){
        return this;
    }

    @Override
    public IEstado setup(int escolha, String jogador1, String jogador2) {
        return this;
    }


}



