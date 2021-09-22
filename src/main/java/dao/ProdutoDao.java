package dao;

import br.com.alura.model.Categoria;
import br.com.alura.model.Product;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDao {

    private Connection connection;
    public ProdutoDao(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Product produto){
        String sql = "INSERT INTO PRODUTOS (NOME,DESCRICAO) VALUES (?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,produto.getNome());
            ps.setString(2,produto.getDescricao());

            ps.execute();

            try(ResultSet rs = ps.getGeneratedKeys()){
                while(rs.next()){
                    produto.setId(rs.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> listarTodos(){
        String sql = "SELECT * FROM PRODUTOS";
        List<Product> listaProdutos = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.execute();

            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3));
                    listaProdutos.add(p);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaProdutos;
    }

    public List<Product> buscar(Categoria lista) {
        String sql = "SELECT * FROM PRODUTOS WHERE CATEGORIA_ID = ?";
        List<Product> listaProdutos = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,lista.getId());
            ps.execute();

            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3));
                    listaProdutos.add(p);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaProdutos;
    }
}
