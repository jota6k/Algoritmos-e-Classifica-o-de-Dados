import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Item> itens;
    private TipoPagamento pagamento;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() { return itens; }
    public Cliente getCliente() { return cliente; }

    public void setPagamento(TipoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public TipoPagamento getPagamento() { return pagamento; }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void exibirResumo() {
        System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        for (Item item : itens) {
            System.out.println("  " + item);
        }
        System.out.println("Total: R$" + calcularTotal());
        System.out.println("Pagamento: " + pagamento);
    }
}
