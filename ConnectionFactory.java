package util; // nome do pacote, esse nome util se refere a um pacote de utilizades, a estrutura � a mvc

import java.sql.Connection; //importe para abertura da conex�o
import java.sql.DriverManager; //importe que tem os drives para se conectar ao banco de dados, nesse caso � o jdbc
import java.sql.PreparedStatement; //importe da classe de preparar a consulta no sql
import java.sql.ResultSet; //esse resultset � uma forma de guardar as informa��es que foram extraidas do banco de dados (direto do banco de dados)
import java.sql.SQLException; // importe referente ao tratamento de erros, no caso em expecifico do SQL

 /*cria��o da classe connectionFatory que vai ser usada para estabelecer a conex�o com o banco de dados
    usando a abertura da conex�o e fechamento da mesma. Obs: precisa ser fechada sempre,
    para que seja preservada a seguran�a e a libera��o de recursos*/
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver"; // Driver que vai ser usado para conectar ao mysql
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp2"; // caminho do local
    public static final String USER = "root"; // User
    public static final String PASS = ""; // senha
  
/*----------------------
/*
 * C�digo para abrir uma conex�o usando o tipo 'Connection' dentro de um bloco try-catch
 */
public static Connection getConnection() { // M�todo para obter uma conex�o
    try {
        // Carrega o driver do banco de dados MySQL
        Class.forName(DRIVER);

        // Retorna uma conex�o usando as informa��es fornecidas
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException ex) {
        // Tratamento de erro em caso de falha na conex�o
        throw new RuntimeException("Erro na conex�o com o banco de dados", ex);
    }
}

 /*----------------------
    Trecho de m�todo para fazer o fechamento da abertura do connection

*/   
            public static void closeConnection(Connection connection) { //closeConnection fazendo o fechamento, com o paramentro dentro
        try { //uso do bloco try catch para tratar erros nos futuro
            if (connection != null) { // Se a conex�o estiver aberta? // 
                connection.close(); // eu fecho ela.
            }

        } catch (SQLException ex) { //tratamento caso algo de errado usando o sqlException ex
            throw new RuntimeException("Erro ao fechar a conex�o", ex);
        }
    }

/*--------------------------------
            Segunda forma de fazer o fechamento, a primeira � apenas para teste caso for necessaria
            o close Connection 2 tem o preparedStatement (A consulta em sql)
    */
        public static void closeConnection(Connection connection, PreparedStatement statement)  {
        try {
            if (connection != null) { // Se a conex�o estiver aberta?
                connection.close(); // eu fecho ela.
            }
            if (statement != null){ //verifica��o se tem conex�o dentro
                statement.close(); //se tiver, fechar
            }
            

        } catch (SQLException ex) { //sql exception do tratamento, o ex � a causa depois da message de erro
            throw new RuntimeException("Erro ao fechar a conex�o", ex);
        }
    }

//-----------------------------------
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) { // Se a conex�o estiver aberta?
                connection.close(); // eu fecho ela.
            }
            if (statement != null){
                statement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conex�o", ex);

}}

    


    
}

    
