package model.entities;

import java.util.ArrayList;
import java.util.List;

public class ListarProduto {

    List<Produto> produtoList = new ArrayList<>();

    public ListarProduto() {

    }

    public void adicionarProduto(Produto produto){
        produtoList.add(produto);
    }

    public void listarProdutos(){
        for (Produto produto : produtoList){
            System.out.println("Produto: " + produto.getNome() + " - Valor: "  + produto.formatarValor());
        }
    }
}
