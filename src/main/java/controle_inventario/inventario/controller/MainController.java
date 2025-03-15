package controle_inventario.inventario.controller;

import controle_inventario.inventario.model.Board;
import controle_inventario.inventario.model.Produto;
import controle_inventario.inventario.service.BoardService;
import controle_inventario.inventario.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainController implements CommandLineRunner {
    @Autowired
    private BoardService boardService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistema de Controle de Inventário ===");
            System.out.println("1 - Criar novo board");
            System.out.println("2 - Criar produto");
            System.out.println("3 - Mover produto");
            System.out.println("4 - Bloquear produto");
            System.out.println("5 - Desbloquear produto");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarBoard(scanner);
                    break;
                case 2:
                    criarProduto(scanner);
                    break;
                case 3:
                    moverProduto(scanner);
                    break;
                case 4:
                    bloquearProduto(scanner);
                    break;
                case 5:
                    desbloquearProduto(scanner);
                    break;
                case 6:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void criarBoard(Scanner scanner) {
        System.out.print("Nome do board: ");
        String nome = scanner.nextLine();
        Board board = new Board();
        board.setNome(nome);
        boardService.criarBoard(board);
        System.out.println("Board criado com sucesso!");
    }

    private void criarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setQuantidade(quantidade);
        produtoService.criarProduto(produto);
        System.out.println("Produto criado com sucesso!");
    }

    private void moverProduto(Scanner scanner) {
        System.out.print("ID do produto: ");
        Long produtoId = scanner.nextLong();
        System.out.print("ID da nova coluna: ");
        Long novaColunaId = scanner.nextLong();
        produtoService.moverProduto(produtoId, novaColunaId);
        System.out.println("Produto movido com sucesso!");
    }

    private void bloquearProduto(Scanner scanner) {
        System.out.print("ID do produto: ");
        Long produtoId = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Motivo do bloqueio: ");
        String motivo = scanner.nextLine();
        produtoService.bloquearProduto(produtoId, motivo);
        System.out.println("Produto bloqueado com sucesso!");
    }

    private void desbloquearProduto(Scanner scanner) {
        System.out.print("ID do produto: ");
        Long produtoId = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Motivo do desbloqueio: ");
        String motivo = scanner.nextLine();
        produtoService.desbloquearProduto(produtoId, motivo);
        System.out.println("Produto desbloqueado com sucesso!");
    }
}
