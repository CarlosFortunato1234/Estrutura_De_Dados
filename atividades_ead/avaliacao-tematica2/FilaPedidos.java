import java.util.LinkedList;
import java.util.Queue;


public class FilaPedidos {
  public Queue<Pedido> fila = new LinkedList <>();


public void enqueue (Pedido pedido) {
    fila.add(pedido);
}


public Pedido dequeue () {
    if (fila.isEmpty()) {
        return null;
    }
    return fila.remove();

}

public Pedido peek () {
    if (fila.isEmpty()) {
        return null;
    }
    return fila.peek();
}


public boolean isEmpty() {
    return fila.isEmpty();
}

public void exibir(){
    if (fila.isEmpty()) {
        System.out.println("Nenhum pedido na fila.");

    } else {
        System.out.println("Pedidos na fila:");
        for (Pedido p : fila) { 
            p.exibirInfoped();
        }
    }
}
}
