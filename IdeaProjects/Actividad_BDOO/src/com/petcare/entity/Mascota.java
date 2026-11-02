package com.petcare.entity;

public class Mascota {
    private int id;
    private String chip;
    private String nombre;
    private String especie;
    private int edad;

    public Mascota(String chip, String nombre, String especie, int edad) {
        this.chip = chip;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Chip: " + chip + " - Nombre: " + nombre +
                " - Espcecie: " + especie + " - Edad: " + edad;
    }
}
