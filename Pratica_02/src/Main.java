public class Main {
    public static void main(String[] args) {
        Estoque produto = new Estoque("Produto A", 100, 20);

        produto.darBaixa(30);

        // Verificar a quantidade atual após a baixa
        System.out.println(produto.mostra());


        System.out.println(produto.mostra System.out.println;

// Verificar se precisa repor o estoque
        if (produto.precisaRepor()) {
            System.out.println(
                    System.out System "É necessário repor o estoque de " + produto.getNome());
        }

        else {
            System.out.println(System"Não é necessário repor o estoque de " + produto.getNome());
        }
    }
}




