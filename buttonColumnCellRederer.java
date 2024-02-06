/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Model.Task;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sales
 */
public class buttonColumnCellRederer extends DefaultTableCellRenderer { //cria��o de botao
   //nesse caso v�o ser dois atributos, e por isso tem que criar um atributo (escolher a op��o do bot�o de editar ou excluir 
    private String buttonType;  // atributo
    
    // m�todo da customiza��o:
    

 public Component getTableCellComponent (JTable table, Object value, Boolean isSelected, boolean hasFocus, int row, int col){
     
     JLabel label;
     label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        
     //preciso centralizar
     
     // criar um variavel para puxar os dados para dentro dela
     label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+buttonType + ".png")));
     
     

     //Fazer o teste l�gico para 
     
     
     return label;
     
 }    
    
    
    
    
    
    
    
    
    
    //getts e setts

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    
}
