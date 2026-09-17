import model.Pessoa;

import java.awt.*;
import java.util.List;
import java.util.Scanner;
import repository.PessoaRepositoryMemory;
public class Main {
    public static void main(String[] args) {
    PessoaRepositoryMemory repo=new PessoaRepositoryMemory();
   Scanner input=new Scanner(System.in);

    boolean status=true;

    while (status){
        System.out.println("--------------------------------------------------");
        System.out.println("Cadastrar uma pessoa: 1");
        System.out.println("Listar pessoa: 2");
        System.out.println("Atualizar pessoa: 3");
        System.out.println("Deletar pessoa: 4");
        System.out.println("Encerrar: 0");
        int opcao=input.nextInt();
        input.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Nome: ");
                String nome=input.nextLine();

                System.out.println("CPF: ");
                String cpf=input.nextLine();

                System.out.println("Email: ");
                String email= input.nextLine();
                Pessoa pessoa=new Pessoa(nome,cpf,email);
                repo.salvar(pessoa);
                break;
            case 2:
                List<Pessoa> lista=repo.listarTodos();
                for (int i=0;i<lista.size();i++){
                    System.out.println("Id: "+lista.get(i).getId());
                    System.out.println("Nome: "+lista.get(i).getName());
                    System.out.println("CPF: "+lista.get(i).getCpf());
                    System.out.println("Email: "+lista.get(i).getEmail());
                    System.out.println("---------------------------------");

                }
                break;



            case 0:
                status=false;
                System.out.println("Sistema encerrado");
                break;
            default:
                System.out.println("Opção não existe");
                break;
        }

    }

    }
}