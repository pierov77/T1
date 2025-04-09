package com.coudevi.dao;

import com.coudevi.entity.Empleados;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class EmpleadoDAO {

    private final EntityManager em;

    public EmpleadoDAO(EntityManager em) {
        this.em = em;
    }

    public void registrar(Empleados empleado) {
            em.persist(empleado);
    }

    public List<Empleados> listarPorFechaIngreso(LocalDate fecha) {
            return em.createQuery("SELECT e FROM Empleados e WHERE e.fechaIngreso = :fecha", Empleados.class)
                    .setParameter("fecha", fecha)
                    .getResultList();
    }
}
