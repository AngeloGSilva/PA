package jogo.logica.estados;

import jogo.logica.dados.Jogo;
import jogo.logica.dados.Situacao;

public interface IEstado {
    //metedos a serem usado... (ações)
    //IEstado desce();
    IEstado gastarCreditos (int quantidade);
    IEstado comeca();
    IEstado sair();
    IEstado escolheColuna(int coluna, boolean pecaEspecial);
    IEstado atribuiPeca(boolean venceu);
    IEstado trocaJogador();
    IEstado ChamaMiniJogo(boolean escolha);
    IEstado vitoria();
    IEstado creditos();
    IEstado vitoriaMini(int op);
    IEstado setup(int escolha, String jogador1, String jogador2);

    Situacao getSituacao();


}

