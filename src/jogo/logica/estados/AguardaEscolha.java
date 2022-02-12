package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;


public class AguardaEscolha extends EstadoAdapter {
    public AguardaEscolha(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado setup(int escolha, String jogador1, String jogador2){
        if(escolha == 1){
            if (!jogador1.equals(jogador2))
                jogo.InicioJogo(escolha,jogador1, jogador2);
            else
                return new AguardaEscolha(jogo);
        }else if(escolha == 2){
            jogo.InicioJogo(escolha,jogador1, null);
        }else if(escolha == 3){
            jogo.InicioJogo(escolha,null,null);
        }
        return new EsperaJogada(jogo);
    }

    @Override
    public IEstado sair(){
        return new Fim(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.AguardaEscolha;
    }
}
