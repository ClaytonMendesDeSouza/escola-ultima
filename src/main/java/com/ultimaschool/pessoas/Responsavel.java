package com.ultimaschool.pessoas;
import java.util.ArrayList;

public class Responsavel extends  Pessoa {

    final int MESES = 12;
    private boolean[] pagamentos = new  boolean[MESES];

    public Responsavel(String nome) {
        super(nome);
    }


    public boolean[] getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(boolean[] pagamentos) {
        this.pagamentos = pagamentos;
    }

    public boolean pagarMensalidade(int mes, boolean situacao){

        pagamentos[mes] = situacao;

        return situacao;
    }

    @Override
    public String verSituacao(int mes) {
        if (getPagamentos()[mes]){
        return "O pagamento foi ralizado nessa data: " + mes;
        }
        return "O pagameno ñ foi realizado nessa data " + mes;
    }

    private String converteListaEsString(ArrayList<Integer>lista){
        String resultado = "";
        for (int l : lista){
        resultado += l + ",";
        }
        return resultado;
    }
    private  String mesesComPagamento(){
        ArrayList<Integer> listaMesesPaghos = new ArrayList<Integer>();

        for (int mes = 1;mes < pagamentos.length;mes++){
            if (pagamentos[mes]){
                listaMesesPaghos.add(mes);
            }
        }
        return "Os meses com pagamento foram: " + converteListaEsString(listaMesesPaghos);
    }
    @Override
    public String relatorio() {
        return "O responsavel: " + getNome() + " Não realizou o pagamento: " + mesesComPagamento();
    }
}
