package model.entities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Produto {

    private String nome;
    private double valor;
    private String descricao;

    public Produto(){}

    public Produto(String nome, double valor, String descricao){
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String  produtoDisponivel(String resultado){
        return resultado.equalsIgnoreCase("sim") ? "Produto disponível: sim" : "Produto disponível: não";
    }

    public String formatarValor(){
        Locale ptBr = new Locale("pt","BR");
        DecimalFormat df = new java.text.DecimalFormat("R$#,##0.00", DecimalFormatSymbols.getInstance(ptBr));
        return df.format(valor);
    }
}
