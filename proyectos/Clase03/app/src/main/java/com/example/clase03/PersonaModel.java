package com.example.clase03;

import androidx.annotation.NonNull;

public class PersonaModel {

    private String nombre;
    private String apellido;
    private String sexo;
    private Integer dni;

    public PersonaModel() {

    }

    public PersonaModel(String nombre, String apellido, Integer dni, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " " + this.dni + " " + this.sexo ;
    }
}
