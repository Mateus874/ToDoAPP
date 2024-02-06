/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Sales
 */
public class Task {
    // Atributos da classe
    private int id;             // ID único da tarefa
    private int idProject;      // ID do projeto ao qual a tarefa está associada
    private String name;        // Nome da tarefa
    private String description; // Descrição da tarefa
    private String notes;       // Notas adicionais sobre a tarefa
    private boolean iscompleted;// Indica se a tarefa está concluída
    private Date deadline;      // Data limite para a conclusão da tarefa
    private Date createdAt;     // Data de criação da tarefa
    private Date updatedAt;     // Data da última atualização da tarefa
    
    // Construtor que aceita parâmetros para inicializar os atributos
    public Task(int id, int idProject, String name, String description, String notes, boolean iscompleted) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.iscompleted = iscompleted;
    }

    // Construtor sem parâmetros (construtor padrão) que inicializa as datas
    public Task() {
        this.createdAt = new Date();
        this.deadline = new Date();
        this.updatedAt = new Date();
    }

    

      // Métodos getters e setters para acessar e modificar os atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", iscompleted=" + iscompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            }
