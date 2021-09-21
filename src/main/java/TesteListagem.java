import java.sql.*;

public class TesteListagem {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conn = connectionFactory.recuperaConexao();
        conn.setAutoCommit(false);
        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTOS";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.execute();
        ResultSet rst = stm.getResultSet();

        while (rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NOME");
            System.out.println(nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }
        conn.close();
    }
}
