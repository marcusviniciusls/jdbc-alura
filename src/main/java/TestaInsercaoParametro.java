import java.sql.*;

public class TestaInsercaoParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        try (PreparedStatement stm =connection.prepareStatement("INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS)){

            adicionarProduto("Smart TV", "45 POelgadas", stm);
            adicionarProduto("Bola de FUtebol", "Esportivo", stm);

            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ROOLBACK EXECUTADO");
            connection.rollback();
        }

    }

    private static void adicionarProduto(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        try (ResultSet rs = stm.getGeneratedKeys()) {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.println("Id gerado: " + id);
            }
        }
    }
}
