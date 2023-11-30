import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;

class Categoria {
    private String descCategoria;

    public Categoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
}

class Evento {
    private String nomeEvento;
    private Date dataEvento;
    private double precoEvento;
    private String descEvento;
    private int qtdeIngresso;
    private Categoria categoria;

    public Evento(String nomeEvento, Date dataEvento, double precoEvento, String descEvento, int qtdeIngresso,
                  Categoria categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.precoEvento = precoEvento;
        this.descEvento = descEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.categoria = categoria;
    }


    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean buscarEvento(Evento evento) {
        return this.nomeEvento.equals(evento.getNomeEvento());
    }
}


class PedidoItem {
    private String nomeEvento;
    private int qtdeIngresso;
    private double precoIngresso;

    public PedidoItem(String nomeEvento, int qtdeIngresso, double precoIngresso) {
        this.nomeEvento = nomeEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.precoIngresso = precoIngresso;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public void atualizaEstoqueIngresso() {
    }
}

class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private List<PedidoItem> itensPedido;

    public Pedido(int numeroPedido, Date dataHoraPedido, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = dataHoraPedido;
        this.precoTotal = 0.0;
        this.statusPedido = statusPedido;
        this.itensPedido = new ArrayList<>();
    }


    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void inserirPedido() {
    }

    public void alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
    }

    public boolean consultarPedido(Pedido pedido) {
        return this.numeroPedido == pedido.getNumeroPedido();
    }

    public void inserirItensPedido(PedidoItem novoItem) {
        itensPedido.add(novoItem);
    }

    public void excluirItensPedido(PedidoItem itemParaExcluir) {
        itensPedido.remove(itemParaExcluir);
    }

    public double calcularTotalPagar() {
        precoTotal = 0.0;
        for (PedidoItem item : itensPedido) {
            precoTotal += item.getQtdeIngresso() * item.getPrecoIngresso();
        }
        return precoTotal;
    }

    public Collection<PedidoItem> getItensPedido() {
        return itensPedido != null ? new ArrayList<>(itensPedido) : new ArrayList<>();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();
        Categoria categoriaConcerto = new Categoria("Concerto");

        for (int i = 1; i <= 5; i++) {
            Evento evento = new Evento("Evento " + i, new Date(), 50.0 * i, "Descrição Evento " + i, 100,
            categoriaConcerto);
            eventos.add(evento);
        }

        ArrayList<Pedido> pedidos = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Pedido pedido = new Pedido(i, new Date(), 1);

            for (int j = 1; j <= 3; j++) {
                Evento eventoAssociado = eventos.get(j - 1);
                PedidoItem pedidoItem = new PedidoItem("Evento " + j, 2, eventoAssociado.getPrecoEvento());

                eventoAssociado.setQtdeIngresso(eventoAssociado.getQtdeIngresso() - pedidoItem.getQtdeIngresso());

                pedido.inserirItensPedido(pedidoItem);
            }

            pedido.alterarStatus(2);

            pedido.calcularTotalPagar();

            pedidos.add(pedido);
        }

        for (Pedido pedido : pedidos) {
            System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
            System.out.println("Data e Hora do Pedido: " + pedido.getDataHoraPedido());
            System.out.println("Status do Pedido: " + pedido.getStatusPedido());
            System.out.println("Total a Pagar: " + pedido.getPrecoTotal());
            System.out.println("Itens no Pedido: " + pedido.getItensPedido().size());
            System.out.println("---------------");
        }
    }
}
