package com.petcare.entity;

public class Veterinario {

    // Atributos
    private int id;
    private String numColegiado;
    private String nombre;
    private String especialidad;

    // Constructores
    public Veterinario(String numColegiado, String nombre, String especialidad) {
        this.numColegiado = numColegiado;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Veterinario() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método que devuelve los datos en formato texto
    @Override
    public String toString() {
        return "ID: " + id +
                " - Número colegiado: " + numColegiado +
                " - Nombre: " + nombre +
                " - Especialidad: " + especialidad;
    }
}
