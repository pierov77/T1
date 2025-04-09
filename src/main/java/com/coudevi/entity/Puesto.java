package com.coudevi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "puesto")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_puesto")
    private Long id;

    @Column(name = "nombre_puesto", nullable = false, length = 100)
    private String nombrePuesto;

    @Column(name = "salario_base")
    private double salarioBase;

    public Puesto() {}

    public Puesto(String nombrePuesto, double salarioBase) {
        this.nombrePuesto = nombrePuesto;
        this.salarioBase = salarioBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

}
