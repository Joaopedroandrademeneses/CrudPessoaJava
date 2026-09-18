import model.Pessoa;

import java.awt.*;
import java.util.List;
import java.util.Scanner;
import repository.PessoaRepository;
import repository.PessoaRepositoryMemory;
public class Main {
    public static void main(String[] args) {
        PessoaRepository repo = new PessoaRepositoryMemory();

   Scanner input=new Scanner(System.in);

    boolean status=true;

    while (status){
        System.out.println("--------------------------------------------------");
        System.out.println("Cadastrar uma pessoa: 1");
        System.out.println("Listar pessoa: 2");
        System.out.println("Buscar pessoa: 3");
        System.out.println("Atualizar pessoa: 4");
        System.out.println("Deletar pessoa: 5");
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
                try {
                    List<Pessoa> lista=repo.listarTodos();

                    for (int i=0;i<lista.size();i++){
                        System.out.println("---------------------------------");
                        System.out.println("Id: "+lista.get(i).getId());
                        System.out.println("Nome: "+lista.get(i).getName());
                        System.out.println("CPF: "+lista.get(i).getCpf());
                        System.out.println("Email: "+lista.get(i).getEmail());
                    }
                }catch (Exception e){

                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 3:
                System.out.println("Digite o id");

                int idBusca=input.nextInt();
                try {
                    Pessoa pessoaBusca=repo.buscarPorId(idBusca);
                    System.out.println("---------------------------------");
                    System.out.println("Id: "+pessoaBusca.getId());
                    System.out.println("Nome: "+pessoaBusca.getName());
                    System.out.println("CPF: "+pessoaBusca.getCpf());
                    System.out.println("Email: "+pessoaBusca.getEmail());

                }catch (Exception e){
                    System.out.println("Erro: "+ e.getMessage());
                }
                break;
            case 4:
                System.out.println("Digite o id");
                int id=input.nextInt();
                input.nextLine();
                System.out.println("Digite o novo nome");
                String novoNome=input.nextLine();
                System.out.println("Digite o cpf correto");
                String novoCPF=input.nextLine();
                System.out.println("Digite o email correto");
                String novoEmail=input.nextLine();

                try {
                    repo.atualizar(id,novoNome,novoCPF,novoEmail);
                }catch (Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
                break;

            case 5:
                System.out.println("Digite o id");
                int idDelete=input.nextInt();

                try {
                    repo.deletar(idDelete);
                }catch (Exception e){
                    System.out.println("Erro: " + e.getMessage());
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