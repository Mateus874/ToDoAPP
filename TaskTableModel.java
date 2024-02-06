/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Model.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel; // import de uma classe
 
/**
 *
 * @author Sales
 */
public class TaskTableModel extends AbstractTableModel { // utilizando a herean�a da classe que tem os modelos para de trabalhar com tabelas

    //cria��o de um vetor para as colunas, a escolha do vetor, � por conta que as colunas n�o mudan de tamanho
    String[] columns = {"Nome", "Descri��o", "Prazo", "Tarefa Conclu�da", "Editar", "Excluir"};
    //lista vazia para guardar as tarefas
    List<Task> tasks = new ArrayList();

//S�o metodos fixos que precisam ser usado obrigatoriamente
//quantas tarefas eu j� tenho ou linhas
    @Override
    public int getRowCount() {
        return tasks.size();
    }
    @Override //Sobre escrita
    
    public String getColumnName(int columnIndex){ //esse metodo mostra o nome da coluna
        return columns[columnIndex];
        
    }
     @Override
  public boolean isCellEditable(int rowIndex , int columnIndex){ //editar a tabela
      return columnIndex == 4; //defini o mini test l�gico
  }  
  
    /**
     *
     * @param aValue
     * @param rowIndex
     * @param columnIndex
     */
    @Override
    // setar um valor, no caso esse m�todo vai fazer com que eu sete um valor de um determidado tipo
     public void setValueAt(Object aValue, int rowIndex, int columnIndex){
         //eu puxo o get a informa��o das linhas, seto em iscompleted, e trasformo o que tem dentro de a Value em boolean;
         tasks.get(rowIndex).setIscompleted((boolean) aValue);
         
     }

    @Override
    public Class<?> getColumnClass(int columnIndex) { // volta a claase que t� na coluna.,
        if(tasks.isEmpty()){ // teste l�gico para saber se t� v�zio, se estiver n�o deve fazer nada
            return Object.class; //Esse Object.class � para retornar do tipo objeto
        }
        return this.getValueAt(0 ,columnIndex).getClass(); //caso tenha algo, pegue a coluna 0 de todas as colunas e me retorne o valor da classe 
    }
    
    
//quantas colunas eu tenho

    @Override
    public int getColumnCount() {
        return columns.length;
    }
// qual o valor que deve ser exibido em determinada linha e coluna

    @Override

            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0 -> {
                        // corre��o: �ndice 0 para a primeira coluna
                        return tasks.get(rowIndex).getName();
            }
                    case 1 -> {
                        // corre��o: �ndice 1 para a segunda coluna
                        return tasks.get(rowIndex).getDescription();
            }
                    case 2 -> {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        return dateFormat.format(tasks.get(rowIndex).getDeadline());
            }
                    case 3 -> {
                        return tasks.get(rowIndex).getIscompleted();
            }
                    case 4 -> {
                        return "";
            }
                    case 5 -> {
                        return "";
            }
                    default -> throw new AssertionError();
                }
            }

       

            public String[] getColumns() {
                return columns;
            }

            public List<Task> getTasks() {
                return tasks;
            }

            public void setTasks(List<Task> tasks) {//vai ser usado para pegar as infroma��es de task controlle e jogar dentro da lista criada no topo
                this.tasks = tasks;
            }

    
}

    
