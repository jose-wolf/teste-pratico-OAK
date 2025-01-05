package application;

import model.entities.ListarProduto;
import model.entities.Produto;
import model.exceptions.ValorNegativoOuIgualAZeroException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListarProduto listarProduto = new ListarProduto();

        try {
            while (true) {
                System.out.print("Digite o nome do produto (ou 'sair' para sair): ");
                String nome = sc.nextLine();

                if (nome.equalsIgnoreCase("sair")) {
                    break;
                }

                double valor;

                while (true) {
                    try {
                        System.out.print("Digite o valor do produto: ");
                        valor = Double.parseDouble(sc.nextLine().replace(",", "."));

                        if (valor <= 0) {
                            throw new ValorNegativoOuIgualAZeroException("O valor do produto deve ser maior que zero.");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Insira um número válido! " + e.getMessage());
                    } catch (ValorNegativoOuIgualAZeroException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                }

                System.out.print("Descrição do produto: ");
                String descricao = sc.nextLine();

                Produto produto = new Produto(nome,valor,descricao);

                while (true) {
                    System.out.println("O produto está disponível? (sim/não)");
                    String resposta = sc.nextLine().trim().toLowerCase();

                    if (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("não")) {
                        System.out.println(produto.produtoDisponivel(resposta));
                        break;
                    } else {
                        System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'não'.");
                    }
                }

                listarProduto.adicionarProduto(produto);
            }
        }catch (NumberFormatException e){
            System.err.println("Insira um número váliro! " + e.getMessage());
        } finally {
            sc.close();
        }
        listarProduto.ordenarValor();
        listarProduto.listarProdutos();
    }
}