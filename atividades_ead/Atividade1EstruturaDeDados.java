/*Realizei um programa que controla
a entradda e saída de pacientes em um hospital.
Usando ferramentas abordadas na temática 1, como por exemplo
classes, arraylist etc.. para tratar  e estruturar
dados. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade1EstruturaDeDados {
    public static void main (String[] args) {
        //array que criei para armazenar objeto do tipo paciente
    Paciente[] pacientes = new Paciente [10];
    int quantidade = 0; 
    Scanner Entradauser = new Scanner (System.in);
    boolean continuar = true; //isso é para o while continuar o programa ou não! 

    System.out.println("Bem vindo ao programa de controle de pacientes!");

    while (continuar){
        try {
            System.out.println("\n===============Menu================");
             System.out.println("Opção 1: Registrar um paciente no vetor.");
             System.out.println("Opção 2: Pesquisar um paciente no vetor");
             System.out.println("Opção 3: Excluir um paciente no vetor");
             System.out.println("Opção 4: Imprimir pacientes nos vetores");
             System.out.println("Opção 5: Sair");
             System.out.println("Escolha uma opção!");
        
             int opcao = Entradauser.nextInt();

             switch(opcao) {
             
                case 1: { 
                    System.out.println("Escolha uma opção: ");

                    System.out.println("Opção 1: Inserir paciente no próximo leito livre");

                    System.out.println("Opção 2: Inserir paciente em um leito específico");
                    int OpcaoInserida = Entradauser.nextInt();

                    if (OpcaoInserida == 1) {
                        
                    if (quantidade == pacientes.length) {
                        System.out.println("Os leitos estão todos cheios!");
                    }  else {

                        Entradauser.nextLine();

                    System.out.println("Digite o nome do paciente:");
                    String nome = Entradauser.nextLine();
 
                    System.out.println("Digite a idade do paciente:");
                    int idade = Entradauser.nextInt();
 
                        Paciente novoPaciente = 
                        new Paciente (nome, idade);
                               //próxima posição livre
                        pacientes[quantidade]  = novoPaciente;
                    
                      
                    
                        quantidade ++;

                    System.out.println("Paciente inserido com sucesso!");
                    }
                    }// chaves do if do opcao inserida1
                    else if (OpcaoInserida == 2){
                        if (quantidade == pacientes.length) { 
                            System.out.println("Os leitos estão cheios!");
                        } //chaves do if quantidade = pacientes
                        else { 
                            
                            if (quantidade == 0) { 
                                System.out.println( "Ainda não há pacientes cadastrados, ele pegará o primeiro leito, digite 1 para inserir o primeiro paciente: ");
                            }
                              else { 
                                System.out.println("Digite a posição onde deseja inserir: entre o leito 1 (primeiro ocupado) e o leito "
                                    + (quantidade + 1) + " (próximo disponível), de um total de " + pacientes.length + " leitos:"
                                );
                            }
                            
                            int posicao = Entradauser.nextInt();

                            //essa parte é para o usuário ver as opções começando em 1

                            int indice = posicao - 1; 

                            if (indice < 0 || indice > quantidade) {
                                System.out.println("Posição inválida");
                            }  else {
                                Entradauser.nextLine();

                                System.out.println("Digite o nome do paciente:");
                                String nome = Entradauser.nextLine();
 
                                System.out.println("Digite a idade do paciente:");
                                int idade = Entradauser.nextInt();


                                for (int i = quantidade; i > indice; i--) { 
                                    pacientes[i] = pacientes [i -1];
                                }

                                pacientes [indice] = 
                                new Paciente(nome, idade);
                                quantidade ++; 

                                System.out.println("Paciente inserido na posição: " +
                                    posicao + "!"
                                ); 

                            }
                        }

                    }//chaves do else if 
                
                    else{ 
                        System.out.println("Opção inválida!");
                    }

                    break; 

                } //chave do case 1 pra eu nao me perder
                

                //CASE PARA PESQUISA
                
                case 2: {
                    System.out.println("1- Pesquisa pelo nome: ");

                    System.out.println("2- Pesquisa pelo leito: ");
                    
                    System.out.println("Escolha uma opção: ");

                    int opcaoPesquisa = Entradauser.nextInt();
                    


                    if (opcaoPesquisa == 1) { 
                    Entradauser.nextLine();
                    System.out.println("Digite o nome do paciente: ");
                    String nomePesquisa = Entradauser.nextLine();

                    boolean encontrado = false; 

                    for (int i = 0; i < quantidade; i++) { 
                        if (pacientes [i] .getNome() .equalsIgnoreCase(nomePesquisa)) {
                            System.out.println("Paciente encontrado no leito: " + (i+1));

                            System.out.println(pacientes[i]);
                            encontrado = true; 
                            break;
                        }
                    }
                   if (!encontrado){ 
                        System.out.println("Paciente não encontrado!");
                    }

                    } // fecha o if (opcaoPesquisa == 1)
                    else if (opcaoPesquisa == 2 ) {
                      
                        System.out.println("Digite o leito que deseja pesquisar:");
                        int posicao = Entradauser.nextInt();

                        int indice = posicao - 1;

                        if (indice < 0 || indice >= quantidade){ 
                            System.out.println("Opção inválida!");
                        } else { 
                            System.out.println("Paciente na posição:" + posicao + ":"); 
                            System.out.println(pacientes[indice]);
                        }

                    }//if do opcao pesquisa ==2
                    else { 
                        System.out.println("Opção inválida!");
                    }

                    break; 
                    }//if do Opção pesquisa

    
                case 3: { 
                      System.out.println("Opção 1: Excluir pelo nome do paciente");
                      System.out.println("Opção 2: Excluir pelo leito do paciente");
                      System.out.println("Escolha uma opção: ");
                      int opcaoExcluir = Entradauser.nextInt();

                      if (opcaoExcluir == 1 ) {
                        Entradauser.nextLine();
                        
                        System.out.println("Digite o nome do paciente que deseja excluir:");
                        String nomeExcluir = Entradauser.nextLine();
                        int posicaoEncontrada = -1;

                        //laço para procurar o paciente

                for (int i = 0; i < quantidade; i++) { 
                    if (pacientes [i] .getNome() .equalsIgnoreCase(nomeExcluir)) {
                        posicaoEncontrada = i;
                        break;
                    }
                }
                
                if (posicaoEncontrada == -1) { 
                    System.out.println("Paciente não encontrado!");
                } else {
                    //deslocar elementos para a esquerda
                    for (int i = posicaoEncontrada; i < quantidade - 1; i++) {
                        pacientes[i] = pacientes [i + 1];
                    }

                    pacientes [quantidade - 1] = null; 
                    quantidade --;

                    System.out.println( 
                        "Paciente Excluído!"
                    );
                }
            }
                else if (opcaoExcluir == 2) {
                    System.out.println( "Digite o leito que deseja excluir:");

                    int posicao = Entradauser.nextInt();

                    int indice = posicao -1;

                    if (indice < 0 || indice >= quantidade) {
                        System.out.println("Leito inválido!");
                    } else {
                        for (int i = indice; i < quantidade - 1; i++) {
                            pacientes [i] = pacientes [i+1];
                        }
                        pacientes [quantidade -1 ] = null;
                        quantidade --; 

                        System.out.println( "Leito da posição" + 
                            posicao + "Excluído com sucesso!"
                        );
                    }
                } else {
                    System.out.println("Opção inválida!");
                }
                break;

                      }//if do opcao excluir =1
                    
                

                case 4: { 
                    System.out.println("PACIENTES INTERNADOS");
                    if (quantidade == 0 ) { 
                        System.out.println("Não há pacientes internados"); 

                    }

                    else {
                        for (int i = 0; i < quantidade; i ++) { 
                            System.out.println("Leito: " + (i + 1) + "-" + pacientes [i] );
                        }
                    }
                    break; 
                }
                
                case 5: { 
                    System.out.println("Saindo do programa..");
                    continuar = false; 
                    break;
                }

                default : { 
                    System.out.println("Opção inválida!");
                    break; 
                }
             }//chaves do switch 
        } catch (InputMismatchException e){ 
            System.out.println("Erro! Digite apenas valores válidos");
            Entradauser.nextLine();//fechamento de chaves do try
        }
        
    }// fechamento de chaves do while  pra mim nao me perder dps

   Entradauser.close();
    }
}


//classe do registro do paciente


class Paciente {
    private String nome;
    private int idade; 

    public Paciente (String nome, int idade) {
        this.nome = nome;
        this.idade = idade; 
   
    }

    public String getNome () {
        return nome; 
    }
    public int getIdade () {
        return idade;
    }


    

    public String toString() {
 
        return "Nome: " + nome

                + " | Idade: " + idade;

    }

}