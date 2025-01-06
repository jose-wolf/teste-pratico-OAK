package application;

import model.entities.ListarProduto;
import model.entities.Produto;
import model.exceptions.ValorNegativoOuIgualAZeroException;

import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private static ListarProduto listarProduto = new ListarProduto();

    public static void exibirMenu() {
        System.out.println("=== Menu de Cadastro de Produtos ===");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Sair");
    }

    public static void cadastrarProduto(){
        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();

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

        System.out.println("Produto disponível? (sim/não): ");
        boolean disponivel = sc.nextLine().equalsIgnoreCase("sim");

        Produto produto = new Produto(nome,valor,descricao,disponivel);
        listarProduto.adicionarProduto(produto);
        produto.produtoDisponivel();
        listarProduto.ordenarValor();
        listarProduto.listarProdutos();
    }

    public static void listarProdutos(){
        System.out.println("\nListagem de Produtos: ");
        listarProduto.ordenarValor();
        listarProduto.listarProdutos();
        System.out.println();
    }

    public static void executar(){
        try {


            while (true) {
                exibirMenu();
                System.out.println("Escolha uma opção: ");
                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        listarProdutos();

                        break;
                    case 3:
                        System.out.println("Saindo do sistema");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opção inválida tente novamente!");
                }
            }
        }catch (NumberFormatException e){
            System.err.println("Insiro uma das opções!" + e.getMessage());
        }
    }

}
