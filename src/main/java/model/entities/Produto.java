package model.entities;

public class Produto {

    private String nome;
    private double valor;
    private String descricao;
    private boolean disponivel;

    public Produto(){}

    public Produto(String nome, double valor, String descricao) {
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public String  produtoDisponivel(String resultado){
        return resultado.equalsIgnoreCase("sim") ? "Produto disponível: sim" : "Produto disponível: não";
    }
}
