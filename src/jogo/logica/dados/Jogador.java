package jogo.logica.dados;

public class Jogador{
    String nome;
    int turnos = 1;
    int miniJogo = 0;
    int vitoria = 0;
    char letra;
    int creditos;
    int vitoriaMini = 0;
    int pecaEspecial = 0;


    public void subCreditos(int tirar) {
        System.out.println("Creditos do "+ nome + creditos+ "antes");
        this.creditos = creditos - tirar;
        System.out.println("Creditos do "+ nome + creditos+ "depois");
    }

    public void resetVitoriaMini(){
        this.vitoriaMini = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVitoria() {
        return vitoria;
    }

    public int getTurnos() {
        return turnos;
    }

    public int getMiniJogo() {
        return miniJogo;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getVitoriaMini() {
        return vitoriaMini;
    }

    public int getPecaEspecial() {
        return pecaEspecial;
    }

    public void setPecaEspecial() {
        this.pecaEspecial = this.pecaEspecial + 1;
    }

    public void setVitoriaMini() {
        this.vitoriaMini = this.vitoriaMini + 1;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurnos() {
        this.turnos = this.turnos + 1;
    }

    public void setVitoria() {
        this.vitoria = 1;
    }

    public void clean(){
        this.turnos = 0;
        this.miniJogo = 0;
        this.vitoria = 0;
    }
}