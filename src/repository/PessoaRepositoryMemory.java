package repository;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryMemory implements PessoaRepository {
    private List<Pessoa> pessoa=new ArrayList<>();

    public void salvar(Pessoa pessoa){
        this.pessoa.add(pessoa);
    }


    public List<Pessoa> listarTodos() throws Exception {
        if (pessoa.isEmpty()){
            throw new Exception("Nem uma pessoa cadastrada!!!");
        }
        else {
            return pessoa;
        }
    }

    public Pessoa buscarPorId(Integer id) throws Exception {

            for (int i=0;i<pessoa.size();i++){
                if (pessoa.get(i).getId().equals(id)){
                    return pessoa.get(i);
                }
            }
            throw new Exception("Pessoa não encontrada");
    }

    public void atualizar(int id,String nome,String CPF, String email)throws Exception {
       Pessoa getPessoa=buscarPorId(id);

       getPessoa.setName(nome);
       getPessoa.setCpf(CPF);
       getPessoa.setEmail(email);
        System.out.println("--------------------------");
        System.out.println("ATUALIZADO COM SUCESSO!!!");
        System.out.println("--------------------------");


    }
    public void deletar(Integer id) throws Exception{
        Pessoa buscPessoa=buscarPorId(id);
        this.pessoa.remove(buscPessoa);
    }
}
