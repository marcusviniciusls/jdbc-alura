import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        String sql = "DELETE FROM PRODUTOS WHERE ID = ?";
        PreparedStatement stm =connection.prepareStatement(sql);

        stm.setInt(1,1);

        boolean registroExcluido = stm.execute();

        System.out.println((registroExcluido == true) ? "Registro Excluido" : "Registro Não Encontrado" );
    }
}
