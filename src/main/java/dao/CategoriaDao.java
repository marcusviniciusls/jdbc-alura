package dao;

import br.com.alura.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CategoriaDao {

    private Connection connection;
    public CategoriaDao(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException {
        String sql = "SELECT * FROM CATEGORIA";
        List<Categoria> listaCategorias = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.execute();

            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
                    listaCategorias.add(categoria);
                }
            }
        }
        return listaCategorias;
    }

    public List<Categoria> listarCategoriaPorProdutos() throws SQLException {
        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME FROM CATEGORIA C INNER JOIN PRODUTOS P ON C.ID = P.CATEGORIA_ID";
        List<Categoria> listaCategorias = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.execute();

            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
                    listaCategorias.add(categoria);
                }
            }
        }
        return listaCategorias;
    }
}
