package repository;

import config.Conexao;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryBD implements PessoaRepository {
    @Override
    public void salvar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome,cpf,email) values(?,?,?);";
        PreparedStatement ps = null;
        try {
            ps = Conexao.Conectar().prepareStatement(sql);
            ps.setString(1, pessoa.getName());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getEmail());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar pessoa no banco", e);

        }
    }

    @Override
    public List<Pessoa> listarTodos() throws Exception {
        String sql = "SELECT * from pessoa;";
        List<Pessoa> pessoas = new ArrayList<>();
        ;
        try {
            Connection con = Conexao.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet lista = stmt.executeQuery();

            while (lista.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(lista.getInt("id"));
                pessoa.setName(lista.getString("nome"));
                pessoa.setCpf(lista.getString("cpf"));
                pessoa.setEmail(lista.getString("email"));
                pessoas.add(pessoa);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }
}
