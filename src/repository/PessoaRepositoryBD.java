package repository;

import config.Conexao;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

        try {
            PreparedStatement stmt = Conexao.Conectar().prepareStatement(sql);
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

    @Override
    public Pessoa buscarPorId(Integer id) throws Exception {
        String sql="select * from pessoa where id=?;";
        PreparedStatement ps=null;

        try {
            Pessoa pessoa=new Pessoa();
            ps=Conexao.Conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet pess= ps.executeQuery();
            pess.next();
            pessoa.setId(pess.getInt("id"));
            pessoa.setName(pess.getString("nome"));
            pessoa.setCpf(pess.getString("cpf"));
            pessoa.setEmail(pess.getString("email"));

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void atualizar(int id, String nome, String CPF, String email) throws Exception {
        String sql="update pessoa set nome=?,cpf=?,email=? where id =?;";
        try {
            Pessoa pessoa;
            pessoa=buscarPorId(id);
            if (pessoa!=null){

                PreparedStatement ps=Conexao.Conectar().prepareStatement(sql);
                ps.setString(1,nome);
                ps.setString(2,CPF);
                ps.setString(3,email);
                ps.setInt(4,id);
                ps.executeUpdate();
                ps.close();

            }else {
                System.out.println("Pessoa não encontrada");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Integer id) throws Exception {
        String sql="Delete from pessoa where id =?;";
        PreparedStatement ps=Conexao.Conectar().prepareStatement(sql);
        try {
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
























