package com.ultimaschool.pessoas;

public class Estudante extends Pessoa {

    final int UNIDADE = 4;
    private String matricula;
    private double notas[] = new double[UNIDADE];

    public Estudante(String nome) {
        super(nome);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    // metodo
    public void consolidarNota(int unidade, double nota){

    notas[unidade-1]= nota;
    }

    public double calcularMeeediaFinal(){
        double somaNotas = 0.0;
        for (double nota: notas){
            somaNotas += nota;
        }
        return somaNotas / UNIDADE;
    }

    private int defirirUnidadeDoMes(int mes){
        if (mes >= 1 && mes <=3){
            return 1;
        } else if (mes >= 3 && mes <= 6) {
            return 2;
        } else if (mes >= 6 && mes <= 9){
            return 3;
        } else if (mes >= 9 && mes <= 12) {
            return 4;
        }else{
            return 0;
        }
    }
    @Override
    public String verSituacao(int mes) {
        int unidade = defirirUnidadeDoMes(mes);
        if (getNotas()[unidade-1] >= 7.0) {
            return "O aluno esta aprovado a média é : "+ unidade + " A sua nota é: " + getNotas()[unidade-1];
        }
        return "O aluno não esta aprovado a média é : "+ unidade + " A sua nota é: " + getNotas()[unidade-1];
    }

    @Override
    public String relatorio() {

        return "Estudante: " + getNome() + "A sua média foi: " + calcularMeeediaFinal();
    }
}
