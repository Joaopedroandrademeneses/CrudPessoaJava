package repository;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public interface PessoaRepository {
    void salvar(Pessoa pessoa);
    List<Pessoa> listarTodos() throws Exception;
    Pessoa buscarPorId(Integer id) throws Exception;
    void atualizar(int id,String nome,String CPF, String email) throws Exception;
    void deletar(Integer id) throws Exception;
}
