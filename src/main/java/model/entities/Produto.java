package model.entities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Produto implements Comparable<Produto>{

    private String nome;
    private double valor;
    private String descricao;
    private boolean disponivel;

    public Produto(){}

    public Produto(String nome, double valor, String descricao, boolean disponivel){
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.disponivel = disponivel;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public String  produtoDisponivel(){
        return disponivel ? "Produto disponível: sim" : "Produto disponível: não";
    }

    public String formatarValor(){
        Locale ptBr = new Locale("pt","BR");
        DecimalFormat df = new java.text.DecimalFormat("R$#,##0.00", DecimalFormatSymbols.getInstance(ptBr));
        return df.format(valor);
    }

    @Override
    public int compareTo(Produto outroValor) {
        return Double.compare(this.valor, outroValor.valor);
    }
}
