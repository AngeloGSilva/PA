package jogo;


//estados ex:rc.. piso1 ---> package estados
//
//


import jogo.iu.texto.JogoUi;
import jogo.logica.MaquinaEstados;

public class App {
    public static void main(String[] args){
    MaquinaEstados maquinaEstados = new MaquinaEstados();
    JogoUi jogoUi = new JogoUi(maquinaEstados);

    jogoUi.comecar();
    }
}
