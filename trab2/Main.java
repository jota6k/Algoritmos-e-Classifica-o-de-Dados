import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Produto> produtos = new ArrayList<>();
    static Pedido pedidoAtual;

    public static void main(String[] args) {
        produtos.add(new Produto(Descricao.ARROZ, 5.50, 100));
        produtos.add(new Produto(Descricao.FEIJAO, 7.20, 100));
        produtos.add(new Produto(Descricao.FARINHA, 4.30, 100));
        produtos.add(new Produto(Descricao.LEITE, 4.80, 100));

        int opcao;
        do {
            System.out.println("\n1) Novo pedido");
            System.out.println("2) Realizar pagamento");
            System.out.println("0) Sair da aplicação");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: novoPedido(); break;
                case 2: realizarPagamento(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void novoPedido() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        pedidoAtual = new Pedido(cliente);

        String continuar;
        do {
            System.out.println("Produtos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(i + " - " + produtos.get(i));
            }
            System.out.print("Escolha o número do produto: ");
            int idx = Integer.parseInt(scanner.nextLine());
            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(scanner.nextLine());

            Produto produto = produtos.get(idx);
            if (produto.baixarEstoque(qtd)) {
                pedidoAtual.adicionarItem(new Item(produto, qtd));
            } else {
                System.out.println("Estoque insuficiente!");
            }

            System.out.print("Adicionar outro item? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("Pedido criado! Use a opção 2 para pagar.");
    }

    static void realizarPagamento() {
        if (pedidoAtual == null || pedidoAtual.getItens().isEmpty()) {
            System.out.println("Nenhum pedido em aberto.");
            return;
        }

        System.out.println("Total do pedido: R$" + pedidoAtual.calcularTotal());
        System.out.println("Forma de pagamento: 1-DINHEIRO 2-CHEQUE 3-CARTAO 4-PIX");
        int op = Integer.parseInt(scanner.nextLine());

        TipoPagamento pagamento;
        switch (op) {
            case 1: pagamento = TipoPagamento.DINHEIRO; break;
            case 2: pagamento = TipoPagamento.CHEQUE; break;
            case 3: pagamento = TipoPagamento.CARTAO; break;
            case 4: pagamento = TipoPagamento.PIX; break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
        pedidoAtual.setPagamento(pagamento);

        System.out.println("\n--- Resumo do pedido ---");
        pedidoAtual.exibirResumo();
        pedidoAtual = null;
    }
}
