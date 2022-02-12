package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    //Criar lista de arrays para o taboleiro etc

    int empate = 0;
    char[][] tab = new char[6][7];
    Jogador jogador1 = new Jogador();
    Jogador jogador2 = new Jogador();
    int jogadorAtual;
    int tipoJogo = 0;
    int turnosTotal = 0;
    int[] historico = new int[10];
    MiniJogos mini = new MiniJogos();

    public int getEmpate() {
        return empate;
    }

    public int getTurnosTotal() {
        return turnosTotal;
    }

    //passar a tabela
    public char[][] getTab() {
        return tab;
    }

    //--------Jogadores

    public int getVitoriaMini(){
        if (jogadorAtual == 0)
            return jogador1.getVitoriaMini();
        else
            return jogador2.getVitoriaMini();
    }

    public String getNome2(){
        return jogador2.getNome();
    }

    public String getNome1(){
        return jogador1.getNome();
    }

    public void setVitoriaMini(){
        if (jogadorAtual == 0)
            jogador1.setVitoriaMini();
        else
            jogador2.setVitoriaMini();
    }

    public void resetVitoriaMini(){
        if (jogadorAtual == 0)
            jogador1.resetVitoriaMini();
        else
            jogador2.resetVitoriaMini();
    }

    public int getPecasEspeciais(){
        if (jogadorAtual == 0)
            return jogador1.getPecaEspecial();
        else
            return jogador2.getPecaEspecial();

    }

    public void setPecaEspecial(){
        if (jogadorAtual == 0)
            jogador1.setPecaEspecial();
        else
            jogador2.setPecaEspecial();
    }

    //remover uma quantidade de creditos
    public void tiraCreditos(int quantidade) {
        if (jogadorAtual == 0)
            jogador1.subCreditos(quantidade);
        else
            jogador2.subCreditos(quantidade);
    }

    public String getNomeJogador() {
        if (jogadorAtual == 0)
            return jogador1.getNome();
        return jogador2.getNome();
    }

    public int getCreditos() {
        if (jogadorAtual == 0)
            return jogador1.getCreditos();
        return jogador2.getCreditos();
    }

    public int getTurno() {
        if (jogadorAtual == 0)
            return jogador1.getTurnos();
        return jogador2.getTurnos();
    }

    public int getVencedor() {
        if (jogador1.getVitoria() == 1)
            return 0;
        return 1;
    }


    //____________Log_________________
    ArrayList<String> log;

    public Jogo() {
        log = new ArrayList<>();
    }

    public void poeLog(String sitAtual) {
        log.add(sitAtual);
    }

    public List<String> getlog() {
        return log;
    }

    public void clearLog() {
        log.clear();
    }

    @Override
    public String toString() {
        return log.toString();
    }



    //____________MiniJogos_________________

    public int getNumero1(){
        return mini.getNumero1();
    }

    public int getNumero2(){
        return mini.getNumero2();
    }

    public int getOperador() {
        return mini.getOperador();
    }

    public int getResultadoF(){
        return mini.getResultado();
    }

    public int getResultado(){
        return mini.priMini();
    }

    public int getMiniJogo() {
        if (jogadorAtual == 0)
            return jogador1.getMiniJogo();
        else
            return jogador2.getMiniJogo();
    }



    //___________JOGO______________________
    public void jogarPecaEspecial(int escolha){
        for (int linha = 0; linha < tab.length; linha++) {
            tab[linha][escolha-1] = '*';
        }
        int aux = 0;
        int contAux = 0;
        int tamHistorico;
        if (turnosTotal >= 10) {
            tamHistorico = 9;
        }else
            tamHistorico = turnosTotal;

        //_____________________
        /*for(int i = tamHistorico; i>=0; i--){
            if(historico[i] == escolha){

            }
        }*/
    }

        //para iniciar o historico a -1 para ajudar no usi
    public void setHistorico() {
        for (int i = 0; i < historico.length; i++) {
            historico[i] = -1;
        }
    }

    public int getJogadorAtual() {
        return jogadorAtual;
    }

    public boolean reverterJogadas(int quantidade) {
        int tamHistorico = 0;
        int i = 0;
        /*int Tamcoluna = 0;

        if (turnosTotal >= 10)
            tamHistorico = 9;
        else
            tamHistorico = turnosTotal;
*/
        int flagAux = 0, aux = 0;

        if (turnosTotal >= 10)
            tamHistorico = 9;
        else
            tamHistorico = turnosTotal;

        //variavel ate onde o j pode pecorrer
        int percorrer = tamHistorico - quantidade;
        if (percorrer < 0)
            percorrer = percorrer * (-1);
        //System.out.println("tou aqui perdido: tam historico : " + tamHistorico + "Quantidade : " + quantidade);
        //numero de vezes a retirar
        while (quantidade != 0) {
            for (int j = 9; j >= percorrer; j--) {
                //reset as variaveis para poder voltar a usar
                aux = 0;
                i = -1;
                if (historico[j] > 0) {
                    do {
                        i++;
                        if (tab[i][historico[j] - 1] != '*') {
                            //guardar a posicao do historio para apagar
                            flagAux = j;
                            tab[i][historico[j] - 1] = '*';
                            //para informar que um ja foi alterado
                            aux = 1;
                        }
                    } while (tab[i][historico[j] - 1] == '*' && aux == 0);
                }
                if (aux == 1)
                    historico[flagAux] = -1;
            }

            quantidade--;
            turnosTotal--;
        }
        return true;
    }

    public int getTipoJogo() {
        return tipoJogo;
    }

    //Chamada no inicio do jogo ... Atribui e limpa as variaveis
    public void InicioJogo(int escolha, String nome1, String nome2) {
        //jogador1 -> jogadorAtual = 0
        //jogador2 -> jogadorAtual = 1
        empate = 0;
        jogador1.clean();
        jogador2.clean();
        jogador1.setLetra('A');
        jogador2.setLetra('V');
        Random aleatorio = new Random();
        jogadorAtual = aleatorio.nextInt(2);
        //System.out.println("JOGADOR ATUAL :  " + jogadorAtual);
        tipoJogo = 0;
        jogador1.setCreditos(5);//creditos iniciais
        jogador2.setCreditos(5);
        setHistorico();
        if (escolha == 1) { //Jogador vs Jogador
            //pedir nomes
            jogador1.setNome(nome1);
            jogador2.setNome(nome2);

        } else if (escolha == 2) { //Jogador vs Computador
            jogador1.setNome(nome1);
            jogador2.setNome("Computador");
            tipoJogo = 1;
        } else if (escolha == 3) {
            jogador1.setNome("Computador1");
            jogador2.setNome("Computador2");
            tipoJogo = 2;
        }

        //iniciar arrary com *
        for (int linha = 0; linha < tab.length; linha++)
            for (int colunauna = 0; colunauna < tab[0].length; colunauna++) {
                tab[linha][colunauna] = '*';
            }
    }

    //validar jogada
    public boolean ValidarJogada(int escolha) {
        if (tab[0][escolha] != '*')
            return false;
        return true;
    }

    //fazer jogada
    public boolean Jogada(int escolunaha) {
        int Tamcolunauna = 5;
        while (Tamcolunauna != -1) {
            if (tab[Tamcolunauna][escolunaha - 1] == '*') {
                if (jogadorAtual == 0) {
                    tab[Tamcolunauna][escolunaha - 1] = jogador1.letra;
                    jogador1.setTurnos();
                } else {
                    tab[Tamcolunauna][escolunaha - 1] = jogador2.letra;
                    jogador2.setTurnos();
                }
                valorHistorico(escolunaha);
                turnosTotal++;
                return true;
            }
            Tamcolunauna--;
        }
        return false;
    }

    //verificar se ganhou ou nao
    public boolean vitoria() {
        char jogador;
        if (jogadorAtual == 0)
            jogador = jogador1.letra;
        else
            jogador = jogador2.letra;

        //4 para os lados
        for (int linha = 0; linha < tab.length; linha++) {
            for (int coluna = 0; coluna < tab[0].length - 3; coluna++) {
                if (tab[linha][coluna] == jogador &&
                        tab[linha][coluna + 1] == jogador &&
                        tab[linha][coluna + 2] == jogador &&
                        tab[linha][coluna + 3] == jogador) {
                    if (jogadorAtual == 0)
                        jogador1.setVitoria();
                    else
                        jogador2.setVitoria();
                    return true;
                }
            }
        }
        //4 para cima e para baixo
        for (int linha = 0; linha < tab.length - 3; linha++) {
            for (int coluna = 0; coluna < tab[0].length; coluna++) {
                if (tab[linha][coluna] == jogador &&
                        tab[linha + 1][coluna] == jogador &&
                        tab[linha + 2][coluna] == jogador &&
                        tab[linha + 3][coluna] == jogador) {
                    if (jogadorAtual == 0)
                        jogador1.setVitoria();
                    else
                        jogador2.setVitoria();
                    return true;
                }
            }
        }
        //dia para cima
        for (int linha = 3; linha < tab.length; linha++) {
            for (int coluna = 0; coluna < tab[0].length - 3; coluna++) {
                if (tab[linha][coluna] == jogador &&
                        tab[linha - 1][coluna + 1] == jogador &&
                        tab[linha - 2][coluna + 2] == jogador &&
                        tab[linha - 3][coluna + 3] == jogador) {
                    if (jogadorAtual == 0)
                        jogador1.setVitoria();
                    else
                        jogador2.setVitoria();
                    return true;
                }
            }
        }
        //dia para baixo
        for (int linha = 0; linha < tab.length - 3; linha++) {
            for (int coluna = 0; coluna < tab[0].length - 3; coluna++) {
                if (tab[linha][coluna] == jogador &&
                        tab[linha + 1][coluna + 1] == jogador &&
                        tab[linha + 2][coluna + 2] == jogador &&
                        tab[linha + 3][coluna + 3] == jogador) {
                    if (jogadorAtual == 0)
                        jogador1.setVitoria();
                    else
                        jogador2.setVitoria();
                    return true;
                }
            }
        }
        jogadorAtual = jogadorAtual == 0 ? 1 : 0; // se for 1 passa a 0 vice versa
        return false;
    }

    // Computador
    public int AI(Random rand) {
        int jogada;
        jogada = rand.nextInt(7);
        //for(int linha = 0; linha < tab.length; linha++) {
        while (tab[0][jogada] != '*')
            jogada = rand.nextInt(7);
        return jogada + 1;
    }

    public int[] getHistorico() {
        return historico;
    }

    //Poe jogada no historico
    public boolean valorHistorico(int valor) {
        for (int i = 0; i < historico.length; i++) {
            if (historico[i] == -1) {
                historico[i] = valor;
                return true;
            } else if (i == (historico.length - 1)) {
                for (int j = 0; j < historico.length; j++) {
                    if (j == 9) {
                        historico[i] = valor;
                        return true;
                    } else
                        historico[j] = historico[j + 1];
                }
                //historico[i] = valor;
            }
        }
        return true;
    }

    public boolean empate(){
        //iniciar arrary com *
        for (int linha = 0; linha < tab.length; linha++)
            for (int colunauna = 0; colunauna < tab[0].length; colunauna++) {
                if(tab[linha][colunauna] == '*'){
                    return false;
                }
            }
        empate = 1;
        return true;
    }

}

