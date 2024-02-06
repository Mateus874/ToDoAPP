/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Model.Task;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sales
 */
public class deadLimeColon extends DefaultTableCellRenderer{
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){
            
          JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          
          label.setHorizontalAlignment(CENTER);
          
          TaskTableModel taskModel = (TaskTableModel) table.getModel(); // pegar a tarefa usando o table.get
          Task task = taskModel.getTasks().get(row); //pegando uma linha especifica da parte do model task que tá armazenado e 
          //jogando para dentro do model tasks

          
          //criação do if para escolher a cor
          if(task.getDeadline().after(new Date())){//criação do teste para saber se dead line passou da data de hoje
              // after é o depois de agora ou depois de hoje
              label.setBackground(Color.GREEN); //escolher a cor com o set background da tabela label
          }else{
              label.setBackground(Color.RED); //escolher a cor com o set background da tabela label
              
          }
          
        return null;
        }
    
    
    
    
    
    
    
    
    
}
