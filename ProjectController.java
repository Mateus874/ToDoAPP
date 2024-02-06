package Controller;

import Model.Project; // Importa a classe Model.Project, que parece ser o modelo para a classe Project
import java.sql.Connection; // Importa a classe Connection do pacote java.sql para conectar ao banco de dados SQL
import java.sql.Date; // Importa a classe Date do pacote java.sql para trabalhar com datas SQL
import java.sql.PreparedStatement; // Importa a classe PreparedStatement do pacote java.sql para preparar consultas SQL
import java.sql.ResultSet; // Importa a classe ResultSet do pacote java.sql para extrair dados de consultas SQL
import java.sql.SQLException; // Importa a classe SQLException do pacote java.sql para tratar erros relacionados ao SQL
import java.util.ArrayList; // Importa a classe ArrayList do pacote java.util para criar uma lista din�mica ajust�vel
import java.util.List; // Importa a interface List do pacote java.util para usar listas
import util.ConnectionFactory; // Importa a classe ConnectionFactory do pacote util para gerenciar conex�es com o banco de dados


/**
 *
 * @author Sales
 */
public class ProjectController {  //classe do controller
    
    
    //---------------------------------------------------------------------------------------------------------------------------
    
    //createProject
     public void createProject(Project project) { // metodo de criar um projeto, utilizando os atributos da classe Project
         /*comando em sql para criar um novo projeto
         nesse caso foi criado uma vari�vel sql do tipo string para armazenar o comando em sql, e apenas trocar os valor com as interroga��es
         sql comando: insert into (inserir uma nova informa��o na tabela project, dessas colunas abaixo:*/
        String sql = "INSERT INTO projects (NAME, DESCRIPTION, CREATEdAt, UPGRADdAt) VALUES (?, ?, ?, ?)"; 
 
 
     /*come�ar a conex�o com null
       foi criado como null para receber depois as informa��es 
        */
       Connection connection = null;  //criou uma vari�vel nula e criou ela como type connection
       PreparedStatement statement = null; //criou o statement com o tipo de preparar a consulta em sql
     
    //criar a conex�o e  //usar o bloco try (Para fazer o tratamento de errros
            try {
                //puxou a abertura da conection com o m�todo getConnection e jogou para a v�riavel conneciton que estava null
       connection = ConnectionFactory.getConnection();
               //jogou o c�digo em sql dentro do prepareStatement e inicou a conex��o com uma variavel statement
       statement = connection.prepareStatement(sql);
          
       
               /*ultilizando a vari�vel statement para setar uma string, objserva��o ela tem um m�todo para setar cada tipo
               setString(m�todo)pegou o paramentro basedo na interroga��o, e puxou a informa��o da classe project e utilizou o m�todo getName
               para puxar a informa��o*/
       statement.setString(1, project.getName());
       
       statement.setString(2, project.getDescription());
       
       statement.setDate(3, new Date(project.getCreatedAt().getTime()));
       
       statement.setDate(4,new Date(project.getUpdatedAt().getTime()));
       // inicia a execu��o da consulta em sql de acordo com os paramentros que forma setado, no caso foi usado o m�todo execute para executar.
       statement.execute();
        //fechamento do bloco try com o catch para avisar se sobre o poss�vel erro
       } catch (SQLException ex) { //determinei que o catch vai ser usado em um sql, ent�o ele j� entende os poss�veis erros.
            // Trate a exce��o (registre, imprima, etc.)
            throw new RuntimeException("Erro ao executar o SQL para inser��o de projeto", ex); 
         //comando final do try, que no caso puxa a classe connectionFatory para fazer o fechamento do connection e statement.       
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }}
 //---------------------------------------------------------------------------------------------------------------------------       
    //atualizar
    public void update(Project project){ //atualizar os dados do projeto, typo project com o paramentro objeto

            //uso do comando update e o nome do projeto para setar as atualiza��es 
            String sql = "UPDATE projects SET " 
            + "NAME = ?, "
            + "DESCRIPTION = ?, "
            + "CREATEdAt = ?, "
            + "UPGRADdAt = ? "
            + "WHERE id = ?";

        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            
            /*nesse caso aqui foi usado um import para trabalhar com datas em sql
            A estrutura do c�digo:
            vari�vel de inicializa��o> setDate(Do import sql)> seta a posi��o da interroga��o> cria uma nova data com as
            informa��es do createdAt, j� que n�o poderi usar ele, pois ele � do pacote java util, ent�o uso o do sql
            
            */
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date (project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
            
       } catch (SQLException ex) {
            // Trate a exce��o (registre, imprima, etc.)
            throw new RuntimeException("Erro ao executar o SQL para inser��o de projeto", ex);

        } finally {
            ConnectionFactory.closeConnection(connection, statement);
    }}
 //---------------------------------------------------------------------------------------------------------------------------  
    /*Buscar todos os projetos
    esse m�todo usa um list para buscar os projetos
    */
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects"; //comando para buscar todos os projetos
        List<Project> projects = new ArrayList<>(); // arraylist para popular

            Connection Cconnection = null;
            PreparedStatement Sstatement= null;
            ResultSet RresultSet = null;  //resultSet para armazenar a lista

                try {
                    Cconnection = ConnectionFactory.getConnection();
                    Sstatement = Cconnection.prepareStatement(sql);
                    RresultSet = Sstatement.executeQuery(); //startar a forma de guardar o dados

                            while(RresultSet.next()){ //uso da repeti��o while para ir populando cada lacuna da lista at� que n�o aja ,mais coisas para se coloca rdentro dela

                            Project project = new Project(); //crio o objeto da classe Project para usar seu set
                                   //set em project a informa��o do o id > a informa��o que foi armazenada no result set atrav�s do m�todo getInt
                            project.setId(RresultSet.getInt("id")); 
                            System.out.println(" ");
                            project.setName(RresultSet.getString("NAME"));
                            System.out.println(" ");
                            project.setDescription(RresultSet.getString("DESCRIPTION"));
                            System.out.println(" ");
                            project.setCreatedAt(RresultSet.getDate("UPGRADdAt"));
                            System.out.println(" ");
                            project.setUpdatedAt(RresultSet.getDate("UPGRADdAt"));
                            System.out.println(" ");
                            
                            //adiciono no array list as informa��es que foram setadas no objeto project
                            projects.add(project); 

                    }


       } catch (SQLException ex) {
            // Trate a exce��o (registre, imprima, etc.)
            throw new RuntimeException("Erro ao executar o SQL para inser��o de projeto", ex);
                } finally{ //nesse caso tamb�m foi usado o fechamento do result set
                    ConnectionFactory.closeConnection(Cconnection, Sstatement,RresultSet);
    }     return projects;
     
}//---------------------------------------------------------------------------------------------------------------------------
    
            public void removerProject(int idProject){
            String sql = "DELETE FROM projects WHERE id = ?";
            
        Connection connection = null;
        PreparedStatement statement = null;
        
         try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();
                        
                } catch (SQLException ex) {
                    throw new RuntimeException("erro ao deletar o projeto", ex);
                } finally {
             ConnectionFactory.closeConnection(connection, statement);
                }
                

                
            }
}
