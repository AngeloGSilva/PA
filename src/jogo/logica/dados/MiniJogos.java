package jogo.logica.dados;

import java.util.Random;

public class MiniJogos {
    int numero1;
    int numero2;
    int operador;
    int resultado;
    Random rand = new Random();

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public int getOperador() {
        return operador;
    }

    public int getResultado() {
        return resultado;
    }

    public void geraNumero1(){
        //int numero1 = rand.nextInt(20);
        setNumero1(rand.nextInt(20)+1);
    }

    public void geraNumero2(){
        //int numero2 = rand.nextInt(20);
        setNumero2(rand.nextInt(20)+1);
    }

    public void geraOperador (){
    int operadorAux = rand.nextInt(4);
        switch (operadorAux) {
        case 0:
            setOperador(operadorAux);
        case 1:
            setOperador(operadorAux);
        case 2:
            setOperador(operadorAux);
        case 3:
            setOperador(operadorAux);
    }
}

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public void setOperador(int operador) {
        this.operador = operador;
    }

    public void setResultado(int resultado) {

        this.resultado = resultado;
    }

    public int priMini(){
        geraNumero1();
        geraNumero2();
        geraOperador();

        switch (operador) {
            case 0:
                setResultado(numero1 + numero2);
                return getResultado();
            case 1:
                setResultado(numero1 - numero2);
                return getResultado();
            case 2:
                setResultado(numero1 / numero2);
                return getResultado();
            case 3:
                setResultado(numero1 * numero2);
                return getResultado();
        }
        return getResultado();
    }


    public void secMini(){
    }
}
