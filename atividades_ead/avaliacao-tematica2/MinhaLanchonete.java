
import java.util.InputMismatchException;
import java.util.Scanner;

public class MinhaLanchonete {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FilaPedidos fila = new FilaPedidos(); //cria a fila de pedidos (com a classe que fiz)
        int numeroPedido = 1;
        int opcao = -1;

        do {
            System.out.println( "---------- PEDIDOS DA LANCHONETE ----------");
            System.out.println("1 - Novo Pedido: ");
            System.out.println("2 - Atender pedido mais antigo: ");
            System.out.println("3 - Ver fila dos pedidos: ");
            System.out.println("4 - Ver proximo pedido (sem atender): ");
            System.out.println("5 - Cancelar pedido: ");
            System.out.println("0 - Sair: ");
            System.out.println("Opcao: ");


            //try catch para que se o usuário digitar uma letra, o programa não
            //interrompido

            try{
                opcao = teclado.nextInt();
                teclado.nextLine(); // esse aqui é só para limpar o teclado

            } catch (InputMismatchException e) {
                System.out.println("ERRO! DIGITE APENAS NÚMEROS.");
                teclado.nextLine(); //limpar o que foi digitado errado
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Lanche: ");
                    String lanche = teclado.nextLine();
                    if (lanche.isEmpty()) {
                        System.out.println("O nome do lanche não pode ficar vazio. ");
                        
                    break;
                    }
                    System.out.println("Quantidade:");
                    try{
                        int quantidade = teclado.nextInt();
                        teclado.nextLine();
                        if (quantidade <= 0){
                            System.out.println("A quantidade deve ser maior que zero!");
                        } else {
                            String bebida = "";
                            System.out.println("Deseja bebida? (s/n): ");
                            System.out.println("Digite s para sim e n para não!");
                            String respostaBebida = teclado.nextLine();

                            if (respostaBebida.equalsIgnoreCase("s")) {
                                System.out.println("Qual bebida? "); 
                                bebida = teclado.nextLine();
                            }

                            String observacao = "";
                            System.out.println("Deseja alguma observação? (s/n): ");
                            System.out.println("Digite s para sim e n para não!");
                            String respostaObs = teclado.nextLine();


                            if (respostaObs.equalsIgnoreCase("s")) {
                                System.out.println("Qual observação? (ex: sem cebola)");
                                observacao = teclado.nextLine();
                            }
                            Pedido novo = new Pedido (numeroPedido, lanche, quantidade, bebida, observacao);
                            fila.enqueue(novo); //insere no final da fila
                            System.out.println("Pedido nº " + numeroPedido + " Entrou na fila.");
                            numeroPedido++; // soma 1 pro próximo pedido ter outro número
                        }
                    } catch (InputMismatchException e) { 
                        System.out.println("ERRO: a quantidade deve ser um número inteiro");
                        teclado.nextLine();
                    }
                
                    break;

                 case 2:
                
                    Pedido atendido = fila.dequeue(); // remove o primeiro da fila
                    if (atendido == null) {

                        System.out.println("Não há pedidos para atender.");
                    } else {
                        System.out.println("Atendendo -> ");
                        atendido.exibirInfoped();
                    }
                    break;


                 case 3:
                 fila.exibir();
                 break;


 
                 case 4: // VER O PRÓXIMO SEM TIRAR (peek)
                 
                 Pedido proximo = fila.peek(); //consulta sem remover

                 if (fila.isEmpty()) {
                    System.out.println("Não há pedidos na fila");
                 } else {
                    System.out.println("Próximo a ser atendido -> ");
                    proximo.exibirInfoped();
                 }
                 break;

                 case 5: 


                System.out.println("Digite o número do pedido que deseja cancelar:  ");
                try {
                    int numeroCancelar = teclado.nextInt();
                    teclado.nextLine(); //limpar o enter

                    if (fila.cancelar(numeroCancelar)) {
                        System.out.println("Pedido nº " + numeroCancelar + " cancelado.");
                } else {
                     System.out.println("Esse pedido não está na fila! ");
                } 
                } catch (InputMismatchException e) {
                     System.out.println("ERRO! DIGITE APENAS NÚMEROS: ");{
                        teclado.nextLine();
                     }
                     
                } 
                break; 

                 case 0: 
                 System.out.println("ENCERRANDO O PROGRAMA..");
                 break;


                 default: 
                 System.out.println("Opção inválida.");

                 break;

                    
            }

        } while (opcao != 0);

            teclado.close();
        
    }
}
