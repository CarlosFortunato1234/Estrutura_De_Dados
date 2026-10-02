public class Pedido {
    public int numero;
    public String lanche;
    public int quantidade;
    public String bebida;
    public String observacao;


    public Pedido (int numero, String lanche, int quantidade, String bebida, String observacao) {
        this.numero = numero;
        this.lanche = lanche;
        this.quantidade = quantidade;
        this.bebida = bebida;
        this.observacao = observacao;
    
    }
     
    public void exibirInfoped() {
        System.out.println("=== PEDIDO Nº " + numero + " - " + "quantidade: " + quantidade  +  "  descrição do lanche: " + lanche );

        if (!bebida.isEmpty()) {
            System.out.println("=== Bebida " + bebida);
        }
        if (!observacao.isEmpty()) {
            System.out.println("=== Observação:  " + observacao);
        }
    }
}