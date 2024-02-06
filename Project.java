/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * Cria��o do model que tem os atribtutos e os getters e setters para acessar para um deles,
 */
public class Project{ //classe project
    
    private int id;  //atributo id private que vai ser usado para armazenar o n�mero do projecto
    private String name; // atributo private name, que vai ser usado para armazenar o nome principal do projeto
    private String description; // atributo private descri��o
    private Date createdAt; // atributo da data de cria��o 
    private Date updatedAt; // atributo da ultima data de atulaliza��o

    

// Construtor que vai dar as regras, nesse caso esse construtor mostra os retornos quando algu�m criar um objeto da class project
    //por�m esse construtor s� vai servir para armazenar no local correto, n�o iria criar um objeto, apenas ultilizar os gettes e settes
    public Project(int id, String name, String description) {
    this.id = id; //puxa o valor do paramentro e liga para o atributo id
    this.name = name;
    this.description = description;
}

      
// Construtor sem par�metros (construtor padr�o)
    public Project() { 
    this.createdAt = new Date(); //esse contrutor criar seu parametro por meio de um m�todo
    this.updatedAt = new Date(); //esse contrutor criar seu parametro por meio de um m�todo
    
}

    

    
    
    
    
    
    
    
    //gets e sets
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
    
}
