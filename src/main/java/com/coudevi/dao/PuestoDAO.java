package com.coudevi.dao;

import com.coudevi.entity.Puesto;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class PuestoDAO {

        private final EntityManager em;
        public PuestoDAO(EntityManager em) {
            this.em = em;
        }

        public void registrar(Puesto puesto) {
            em.persist(puesto);
        }

    public Optional<Puesto> buscarPorNombre(String nombrePuesto) {
        return em.createQuery("SELECT p FROM Puesto p WHERE p.nombrePuesto = :nombrePuesto", Puesto.class)
                .setParameter("nombrePuesto", nombrePuesto)
                .getResultStream()
                .findFirst();
    }
}
