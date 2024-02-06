package Controller; //Nome da classe

import Model.Task; //
import java.sql.PreparedStatement; //import para startar 
import java.util.List; // import de lista
import java.sql.Connection; // importa para conectar ao sql
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException; // import para tratar os erros, no caso esse é para identificar erro sno sql e depois avisar
import java.util.ArrayList;
import util.ConnectionFactory; //importe da clsse connection factory
/**
 *
 * @author Sales
 */
public class taskController { // nome da classe

    public void save(Task task) throws SQLException{ //metodo salvar ultilizando a task ultilizando todas os tipos dentro dela
        String sql = "INSERT INTO tasks (IDproject, NAME, DESCRIPTION, NOTESE, COMPLETED, DEADLINE, CREATEdAt, UPGRADdAt) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
       Connection connection = null;  //criou uma variável nula e criou ela como type connection
       PreparedStatement statement = null; //criou o Statemnet como nula tbm
        
        
        try {
            connection = ConnectionFactory.getConnection(); //puxou a abertura da conexão
            statement = connection.prepareStatement(sql); //iniciou o start com o SQL dentro
            statement.setInt(1,task.getIdProject()); //inseriu o project
            statement.setString(2, task.getName()); // inseriu o nome 
            statement.setString(3, task.getDescription()); // inseriu a descrição
            statement.setString(4, task.getNotes()); // inseriu a nota
            statement.setInt(5, task.getIscompleted() ? 1 : 0);
            statement.setDate(6,new Date(task.getDeadline().getTime()));//data de criação  
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));//data  
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));//data 
            statement.execute();
            
            
        } catch (SQLException ex) {
            throw new SQLException("erro ao salvar" + ex.getMessage(), ex);
        } 
        finally{
           ConnectionFactory.closeConnection(connection, statement);// usei dois paramentros de fechar para  evitar fazer if
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------
    
    
public void update(Task task){ //metodo atualizar ultilizando a task ultilizando todas os tipos dentro dela
            String sql = "UPDATE tasks SET " /// criou um variável string para armazenar o cód em sql.
                                                    + "IDproject = ?, " 
                                                    + "NAME = ?, "
                                                    + "DESCRIPTION = ?, "
                                                    + "NOTESE = ?, "
                                                    + "COMPLETED = ?, "
                                                    + "DEADLINE	= ?, "
                                                    + "CREATEdAt = ?, "
                                                    + "UPGRADdAt = ? "
                                                    + "WHERE id = ? ";
        
       Connection connection = null;  //criou uma variável nula e criou ela como type connection
       PreparedStatement statement = null; //criou o Statemnet como nula tbm
        
        
        try {
            connection = ConnectionFactory.getConnection(); //puxou a abertura da conexão
            statement = connection.prepareStatement(sql); //iniciou o start com o SQL dentro
            statement.setInt(1,task.getIdProject()); //inseriu o project
            statement.setString(2, task.getName()); // inseriu o nome 
            statement.setString(3, task.getDescription()); // inseriu a descrição
            statement.setString(4, task.getNotes()); // inseriu a nota
            statement.setBoolean(5, task.getIscompleted()); // o stts
            statement.setDate(6,new Date(task.getDeadline().getTime()));//data de criação  
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));//data  
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));//data 
            statement.setInt(9,task.getId());//data 
            statement.execute();
            
            
        } catch (Exception ex) {
            throw new RuntimeException("erro ao salvar" + ex.getMessage(), ex);
        } 
        finally{
           ConnectionFactory.closeConnection(connection, statement);// usei dois paramentros de fechar para  evitar fazer if
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------

public void removeById(int taskId) { //metodo remover
    
    String sql = "DELETE FROM tasks  WHERE id = ?"; //Criação de uma String SQL com a variável remover id
    Connection connection = null; // crio a variavel conn para ser usada depois, note que ela tem o valor null, ou nulo
    PreparedStatement statement = null; //crio outra variavel, dessa vez uma statemente e nulo tbm
    
    try{                           //Bloco try catch para tratar erro
        connection = ConnectionFactory.getConnection();// chamou o método para abrir a conexão
        statement = connection.prepareStatement(sql); // pego a variavel de uma conexão e starto ela, no caso o sql
        statement.setInt(1, taskId); // digo que que o starte vai pegar o paremetro ?, e trocar pela task id
        statement.execute(); // starto a execução
        
    } catch (SQLException ex){  // restante do try. Obs: É com o tipo SQL, justamente para tratar o erro do sql.
    throw new RuntimeException("erro ao deletar uma tarefa", ex);
    } 
    finally{
        ConnectionFactory.closeConnection((Connection) connection, statement); //finalização da conexão e do statement. Obs: O objetivo é diminuir o uso de dados do computador
    }
    
}

//--------------------------------------------------------------------------------------------------------------------------

public List<Task> getAll (int idProject){ //PUXAR AS INFORMAÇÕES DO SQL
    String sql = "SELECT * FROM tasks WHERE IDproject = ?"; // comando para selecionar todas as linha de id project de "?"
    
    Connection connection = null; // variavel de conexão
    PreparedStatement statement = null; // variavel null para armazenar o sql
    ResultSet resultSet = null; // é um objeto que armazena resposta 
    
    //devolver uma lista de tarefas
    
    List<Task> tasks = new ArrayList<>(); // criação de uma lista task
    try {
        connection = ConnectionFactory.getConnection();
        statement = connection.prepareStatement(sql); // prepara o star da conexão com o sql
        statement.setInt(1,idProject); // starta de acordo com as informações
        resultSet = statement.executeQuery(); // usa o executeQuery para puxar a resposta do banco de dados, e armazena no objeto resultSet.
        
        while(resultSet.next()){ // While(Enquanto), quanto tiver outro result, o código continuarar executando.
        
        Task task = new Task(); //foi criado um objeto para jogar as informações
        task.setId(resultSet.getInt("id"));
        task.setIdProject(resultSet.getInt("IDproject"));
        task.setName(resultSet.getString("NAME"));
        task.setDescription(resultSet.getString("DESCRIPTION"));
        task.setNotes(resultSet.getString("NOTESE"));
        task.setIscompleted(resultSet.getBoolean("COMPLETED"));
        task.setDeadline(resultSet.getDate("DEADLINE"));
        task.setCreatedAt(resultSet.getDate("CREATEdAt"));
        task.setUpdatedAt(resultSet.getDate("UPGRADdAt"));
        
        tasks.add(task);
        
        
        }   
        } catch (SQLException ex){  // restante do try. Obs: É com o tipo SQL, justamente para tratar o erro do sql.
    throw new RuntimeException("erro ao mostar a lista", ex);
    } 
    
    finally{
        ConnectionFactory.closeConnection((Connection) connection, statement, resultSet); //finalização da conexão e do statement. Obs: O objetivo é diminuir o uso de dados do computador
    }
    
        return tasks;
    
}
}
