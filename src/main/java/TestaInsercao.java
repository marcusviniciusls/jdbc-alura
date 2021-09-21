import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        String sql = "INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES ('MOUSE','MOUSE SEM FIO')";
        Statement stm =connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stm.getGeneratedKeys();

        while(rs.next()){
            Integer id = rs.getInt(1);
            System.out.println("Id gerado: " + id);
        }
    }
}
