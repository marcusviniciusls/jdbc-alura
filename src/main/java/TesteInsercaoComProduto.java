import br.com.alura.model.Product;
import dao.ProdutoDao;

import java.sql.*;
import java.util.List;

public class TesteInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Product comoda = new Product("Comoda XP","Muitom boa");

        try(Connection connectionFactory =  new ConnectionFactory().recuperaConexao()){
            ProdutoDao pp = new ProdutoDao(connectionFactory);
            pp.salvar(comoda);

            List<Product> listaProdutos = pp.listarTodos();
            listaProdutos.forEach(lp -> System.out.println(lp));
        }
        System.out.println(comoda);
    }
}
