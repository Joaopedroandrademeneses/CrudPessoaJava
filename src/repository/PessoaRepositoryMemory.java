package repository;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryMemory implements PessoaRepository {
    private List<Pessoa> pessoa=new ArrayList<>();

    public void salvar(Pessoa pessoa){
        this.pessoa.add(pessoa);
    }


    public List<Pessoa> listarTodos() {
        return pessoa;
    }

    public Pessoa buscarPorId(Integer id) throws Exception {

            for (int i=0;i<pessoa.size();i++){
                if (pessoa.get(i).getId().equals(id)){
                    return pessoa.get(i);
                }
            }
            throw new Exception("Pessoa não encontrada");
    }

    public void atualizar(Pessoa pessoa)throws Exception {
       Pessoa getPessoa=buscarPorId(pessoa.getId());

       getPessoa.setCpf(pessoa.getCpf());
       getPessoa.setEmail(pessoa.getEmail());
       getPessoa.setName(pessoa.getName());
    }
    public void deletar(Integer id) throws Exception{
        Pessoa buscPessoa=buscarPorId(id);
        this.pessoa.remove(buscPessoa);
    }
}
