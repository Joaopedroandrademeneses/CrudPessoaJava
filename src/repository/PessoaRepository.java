package repository;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public interface PessoaRepository {
    void salvar(Pessoa pessoa);
    List<Pessoa> listarTodos();
    Pessoa buscarPorId(Integer id) throws Exception;
    void atualizar(Pessoa pessoa) throws Exception;
    void deletar(Integer id) throws Exception;
}
