import br.com.alura.model.Categoria;
import br.com.alura.model.Product;
import dao.CategoriaDao;
import dao.ProdutoDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategoria {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().recuperaConexao()){
            CategoriaDao categoriaDao = new CategoriaDao(connection);
            List<Categoria> listaCategorias = categoriaDao.listar();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
