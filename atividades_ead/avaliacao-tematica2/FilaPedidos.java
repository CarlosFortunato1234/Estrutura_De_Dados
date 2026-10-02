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
//BUSCAR: procura um pedido pelo nro sem tirar ele da fila 

public Pedido buscar (int numero) {
    for (Pedido p : fila) { 
        if (p.numero == numero) { // está olhando cada pedido na fila, se bater com o procurado vai devolver ele
            return p;
        }
    }
    return null; // se nao achar nada volta nulo pra depois ser tratado dizendo q não achou nad
}
//cancelar: primeiro ele irá achar o pedido e depois irá remover ele


public boolean cancelar (int numero) {
    Pedido pedido = buscar(numero); //usa o buscar para achar o pedido

    if (pedido == null ) {
        return false; // se não achar nennhum pedido não tem cancelar 

    }
    fila.remove (pedido); // remove esse pedido em especifico da fila 
    return true;  // deu certo
}
}
