/*Realizei um programa que controla
a entradda e saída de pacientes em um hospital.
Usando ferramentas abordadas na temática 1, como por exemplo
classes, arraylist etc.. para tratar  e estruturar
dados. */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class hospital_atividade1 {
    public static void main (String[] args) {
        //arraylist que criei para armazenar objeto do tipo paciente
    ArrayList <Paciente> pacientes = new ArrayList<>();
    Scanner Entradauser = new Scanner (System.in);
    boolean continuar = true; //isso é para o while continuar o programa ou não! 

    System.err.println("Bem vindo ao programa de controle de pacientes!");

    while (continuar){
        try {
            System.err.println("\n===============Menu================");
             System.err.println("Opção 1: Registrar entrada de paciente");
             System.err.println("Opção 2: Registrar saída de paciente");
             System.err.println("Opção 3: Listar pacientes internados");
             System.err.println("Opção 4: Mostrar total de pacientes internados");
             System.err.println("Opção 5: Sair");
             System.err.println("Escolha uma opção!");
        
             int opcao = Entradauser.nextInt();

             switch(opcao) {
             
                case 1: { 
                    System.out.println("Digite o nome do paciente:");
                    Entradauser.nextLine();
                    String nome = Entradauser.nextLine();

                    System.out.println("Digite a idade do paciente:");
                    int idade = Entradauser.nextInt();

                    System.out.println("Digite o leito do paciente:");
                    Entradauser.nextLine();
                    String leito = Entradauser.nextLine();

                    //criação do objeto

                    Paciente novoPaciente = new Paciente (nome ,idade, leito);
                    pacientes.add (novoPaciente);

                    System.out.println("Paciente " + nome + " Internado com sucesso!");

                    break; 

                } //chave do case 1 pra eu nao me perder
                
                case 2: {
                    System.err.println("Digite o nome do paciente que está saindo do hospital: ");
                    Entradauser.nextLine();
                    String nome = Entradauser.nextLine();
                    boolean removido = false; 
                    for (int i = 0; i < pacientes.size(); i++){ 
                        if (pacientes.get(i).getNome().equalsIgnoreCase(nome)) //esse equalsignore é para comparar ignorando letras maiusculas e minusculas. 
                        {
                            pacientes.remove(i);
                            System.out.println("Paciente " + nome + " foi retirado do quadro de internados!");
                            removido = true;
                            break;
                        }//if
                    }//for
                    if (!removido) {
                        System.out.println( "Paciente não encontrado na lista de internados");
                    }
                    break;
                }

                case 3: { 
                    System.out.println("\n ======= PACIENTES INTERNADOS: =========");
                    if (pacientes.size() == 0) {
                        System.out.println("Não há pacientes internados no momento"); }

                        else { 
                            for (int i = 0; i < pacientes.size(); i++) {
                                Paciente p = pacientes.get(i);
                                System.out.println((i+1) + "- Nome: " + p.getNome  () + " | Idade " + p.getIdade () + " | Leito " + p.getLeito());
                            }
                        }
                        break; 
                    }
                

                case 4: { 
                    System.out.println("Total de Pacientes internados:" + pacientes.size());
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
    private String leito;


    public Paciente (String nome, int idade, String leito) {
        this.nome = nome;
        this.idade = idade; 
        this.leito = leito; 
    }

    public String getNome () {
        return nome; 
    }
    public int getIdade () {
        return idade;
    }
    public String getLeito() {
        return leito;
    }
}