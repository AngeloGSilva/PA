package jogo.iu.texto;

import jogo.Varios.Varios;
import jogo.logica.MaquinaEstados;
import jogo.logica.dados.Jogador;
import jogo.logica.dados.Situacao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JogoUi {
    //construtor que recebe o estado
    MaquinaEstados me;
    boolean sair;

    public JogoUi(MaquinaEstados me){
        this.me = me;
    }

    public void comecar(){
        sair = false;
        while(!sair){
            //mostraLog();
            switch (me.getSituacao()){
                case Inicio:
                    inicioUI();
                    break;
                case AguardaEscolha:
                    aguardaEscolhaUI();
                    break;
                case EsperaJogada:
                    esperaJogadaUI();
                    break;
                case VerificaMiniJogo:
                    verificaMiniJogoUI();
                    break;
                case EscolheCreditos:
                    escolheCreditosUI();
                    break;
                case VerificaVitoria:
                    verificaVitoriaUI();
                    break;
                case ProximoPlayer:
                    proximoPlayerUI();
                    break;
                case EsperaResposta:
                    esperaRespostaUI();
                    break;
                case EsperaJogar:
                    esperaJogarUI();
                    break;
                case Fim:
                    fimUI();
                    break;
            }
       }
    }

    private void verificaMiniJogoUI() {
        me.atribuiPeca(true);
    }

    private void escolheCreditosUI() {
        System.out.println("Jogador: " + me.getNome());
        System.out.println("Creditos Disponiveis: " + me.getCreditos());
        int op = Varios.pedeInteiro("Quantos Creditos pertende gastar: ");
        me.gastarCreditos(op);
    }

    private void fimUI() {
        if(me.getEmpate() == true) {
         System.out.println("Jogo entre " + me.getNome1() + " e " + me.getNome2() + " acabou em empate.");
        }else {
            if (me.getVencedor() == 0) {
                System.out.println(me.getNome() + " Venceu");
            } else if (me.getVencedor() == 1) {
                System.out.println(me.getNome() + " Venceu");
            }
        }
        me.comeca();
    }

    private void esperaJogarUI() {
        int op;
        while(me.getVitoriaMini() <5){
            System.out.println("Jogo de Calculo");
            me.getResultado();
            switch (me.getOperador()) {
                case 0:
                    System.out.print(me.getNumero1() + " + " + me.getNumero2());
                    break;
                case 1:
                    System.out.print(me.getNumero1() + " - " + me.getNumero2());
                    break;
                case 2:
                    System.out.print(me.getNumero1() + " / " + me.getNumero2());
                    break;
                case 3:
                    System.out.print(me.getNumero1() + " * " + me.getNumero2());
                    break;
            }
            op = Varios.pedeInteiro("Qual é solucao? ");
            if (op == me.getResultadoF())
                me.vitoriaMini(op);
        }
       // }else {
        //me.resetVitoriaMini();
            System.out.println("Jogo de Palavras");
       // }
        me.atribuiPeca(true);
    }

    private void esperaRespostaUI() {
        System.out.println("Pertende jogar mini jogo " + me.getNome());
        int i = Varios.escolheOpcao("Jogar Mini jogo", "Nao Jogar", "Sair");
        switch (i) {
            case 1:
                me.ChamaMiniJogo(true);
                break;
            case 2:
                me.ChamaMiniJogo(false);
                break;
            default:
                sair = true;
                break;
        }
    }

    void mostraLog(){
        List<String> msg = me.getlog();
        System.out.print("[");
        if(msg.size() <=5){
            for (int i = 0; i < msg.size(); i++){
                System.out.print(msg.get(i) + ", ");
            }
        }else{
            for (int i = (msg.size() - 1); i >= (msg.size()-5); i--){
                System.out.print(msg.get(i)+ ", ");
            }
        }
        System.out.print("]\n");
    }

    private void proximoPlayerUI() {
        if (me.getTipoJogo() == 0){
            if (me.getCreditos() > 0){
                System.out.println(me.getNome() + " pretendes:");
                switch (Varios.escolheOpcao("Jogar","Gastar Creditos","Sair")) {
                    case 1:
                        me.trocaJogador();
                        break;
                    case 2:
                        me.creditos();
                    break;
                    default:
                    sair = true;
                    break;
        }
            }else{
                System.out.println(me.getNome() + " pretendes:");
                switch (Varios.escolheOpcao("Jogar","Sair")) {
                    case 1:
                        me.trocaJogador();
                        break;
                    default:
                        sair = true;
                        break;
                }
            }
        }else if(me.getTipoJogo() == 1){
            if (me.getCreditos() > 0 && me.getJogador() == 0){
                System.out.println(me.getNome() + " pretendes:");
                switch (Varios.escolheOpcao("Contiuar a jogar","Gastar Creditos","Sair")) {
                    case 1:
                        me.trocaJogador();
                        break;
                    case 2:
                        me.creditos();
                        break;
                    default:
                        sair = true;
                        break;
                }
            }else if(me.getCreditos() == 0 && me.getJogador() == 0){
                System.out.println(me.getNome() + " pretendes:");
                switch (Varios.escolheOpcao("Contiuar a jogar","Sair")) {
                    case 1:
                        me.trocaJogador();
                        break;
                    default:
                        sair = true;
                        break;
                }
            }
        }else if(me.getTipoJogo() == 2)
            me.trocaJogador();
        me.trocaJogador();
    }

    private void verificaVitoriaUI() {
        me.vitoria();
    }

    public void historico(){
        int[] hist = me.getHistorico();
        System.out.println("--------------------------");
        for (int i=0; i < hist.length; i++){
            System.out.print(hist[i]);
        }
        System.out.println("--------------------------");
    }

    public String tabela(){
        char[][] tab = me.getTabalea();
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("---------------");
        for (int linha = 0; linha < tab.length; linha++){
            System.out.print("|");
            for (int coluna = 0; coluna < tab[0].length; coluna++){
                System.out.print(tab[linha][coluna]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println();
        return null;
    }

    private void esperaJogadaUI() {
        int escolha = 0;
        //historico();
        System.out.println("Jogador: " + me.getNome());
        if (me.getTipoJogo() == 0 || me.getTipoJogo() == 1 && me.getJogador() == 0) {
            tabela();
            if (me.getPecas() > 0) {
                System.out.println("Possui " + me.getPecas() + " pecas especiais.");
                System.out.println("Se pretender utilizar uma peca especial digite o numero 8.");
                int op = Varios.pedeInteiro("Escolha: ");
                switch (op) {
                    case 1:
                        escolha = 1;
                        me.escolheColuna(escolha, false);
                        break;
                    case 2:
                        escolha = 2;
                        me.escolheColuna(escolha, false);
                        break;
                    case 3:
                        escolha = 3;
                        me.escolheColuna(escolha, false);
                        break;
                    case 4:
                        escolha = 4;
                        me.escolheColuna(escolha, false);
                        break;
                    case 5:
                        escolha = 5;
                        me.escolheColuna(escolha, false);
                        break;
                    case 6:
                        escolha = 6;
                        me.escolheColuna(escolha, false);
                        break;
                    case 7:
                        escolha = 7;
                        me.escolheColuna(escolha, false);
                        break;
                    case 8:
                        escolha = Varios.pedeInteiro("Qual coluna pertende jogar a peca especial? ");
                        me.escolheColuna(escolha, true);
                        break;
                    default:
                        sair = true;
                        break;
                }
            } else{
                int op = Varios.pedeInteiro("Escolha uma coluna: ");
                switch (op) {
                    case 1:
                        escolha = 1;
                        me.escolheColuna(escolha, false);
                        break;
                    case 2:
                        escolha = 2;
                        me.escolheColuna(escolha, false);
                        break;
                    case 3:
                        escolha = 3;
                        me.escolheColuna(escolha, false);
                        break;
                    case 4:
                        escolha = 4;
                        me.escolheColuna(escolha, false);
                        break;
                    case 5:
                        escolha = 5;
                        me.escolheColuna(escolha, false);
                        break;
                    case 6:
                        escolha = 6;
                        me.escolheColuna(escolha, false);
                        break;
                    case 7:
                        escolha = 7;
                        me.escolheColuna(escolha, false);
                        break;
                    default:
                        sair = true;
                        break;
                }
            }
        }else {
                me.escolheColuna(escolha, false);
            }
            tabela();
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

    }

    private void aguardaEscolhaUI() {
        String jogador1 = null;
        String jogador2 = null;
        int op = Varios.escolheOpcao("Jogador vs Jogador","Jogador vs Computador","Computador vs Computador","Sair");
        if (op == 1) {
            jogador1 = Varios.pedeString("Qual o nome do Jogador1: ");
            jogador2 = Varios.pedeString("Qual o nome do Jogador2: ");
            me.setup(op,jogador1, jogador2);
        }else if(op == 2) {
            jogador1 = Varios.pedeString("Qual o nome do Jogador1: ");
            me.setup(op, jogador1, null);
        }else if(op == 3){
            me.setup(op, null,null);
        }else
            sair = true;
    }

    private void inicioUI() {
        int op = Varios.escolheOpcao("Comecar","Sair");
        if (op == 1) {
            me.comeca();
        } else {
            sair = true;
        }
    }
}
