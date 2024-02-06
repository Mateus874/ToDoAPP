package util; // nome do pacote, esse nome util se refere a um pacote de utilizades, a estrutura é a mvc

import java.sql.Connection; //importe para abertura da conexão
import java.sql.DriverManager; //importe que tem os drives para se conectar ao banco de dados, nesse caso é o jdbc
import java.sql.PreparedStatement; //importe da classe de preparar a consulta no sql
import java.sql.ResultSet; //esse resultset é uma forma de guardar as informações que foram extraidas do banco de dados (direto do banco de dados)
import java.sql.SQLException; // importe referente ao tratamento de erros, no caso em expecifico do SQL

 /*criação da classe connectionFatory que vai ser usada para estabelecer a conexão com o banco de dados
    usando a abertura da conexão e fechamento da mesma. Obs: precisa ser fechada sempre,
    para que seja preservada a segurança e a liberação de recursos*/
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver"; // Driver que vai ser usado para conectar ao mysql
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp2"; // caminho do local
    public static final String USER = "root"; // User
    public static final String PASS = ""; // senha
  
/*----------------------
/*
 * Código para abrir uma conexão usando o tipo 'Connection' dentro de um bloco try-catch
 */
public static Connection getConnection() { // Método para obter uma conexão
    try {
        // Carrega o driver do banco de dados MySQL
        Class.forName(DRIVER);

        // Retorna uma conexão usando as informações fornecidas
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException ex) {
        // Tratamento de erro em caso de falha na conexão
        throw new RuntimeException("Erro na conexão com o banco de dados", ex);
    }
}

 /*----------------------
    Trecho de método para fazer o fechamento da abertura do connection

*/   
            public static void closeConnection(Connection connection) { //closeConnection fazendo o fechamento, com o paramentro dentro
        try { //uso do bloco try catch para tratar erros nos futuro
            if (connection != null) { // Se a conexão estiver aberta? // 
                connection.close(); // eu fecho ela.
            }

        } catch (SQLException ex) { //tratamento caso algo de errado usando o sqlException ex
            throw new RuntimeException("Erro ao fechar a conexão", ex);
        }
    }

/*--------------------------------
            Segunda forma de fazer o fechamento, a primeira é apenas para teste caso for necessaria
            o close Connection 2 tem o preparedStatement (A consulta em sql)
    */
        public static void closeConnection(Connection connection, PreparedStatement statement)  {
        try {
            if (connection != null) { // Se a conexão estiver aberta?
                connection.close(); // eu fecho ela.
            }
            if (statement != null){ //verificação se tem conexão dentro
                statement.close(); //se tiver, fechar
            }
            

        } catch (SQLException ex) { //sql exception do tratamento, o ex é a causa depois da message de erro
            throw new RuntimeException("Erro ao fechar a conexão", ex);
        }
    }

//-----------------------------------
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) { // Se a conexão estiver aberta?
                connection.close(); // eu fecho ela.
            }
            if (statement != null){
                statement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão", ex);

}}

    


    
}

    
