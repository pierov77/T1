package com.coudevi.service;

import com.coudevi.dao.EmpleadoDAO;
import com.coudevi.dao.PuestoDAO;
import com.coudevi.entity.Empleados;
import com.coudevi.entity.Puesto;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class TalentoProService {

    private final EmpleadoDAO empleadoDAO;
    private final PuestoDAO puestoDAO;
    private final EntityManager manager;

    public TalentoProService(EntityManager manager) {
        this.manager = manager;
        this.empleadoDAO = new EmpleadoDAO(manager);
        this.puestoDAO = new PuestoDAO(manager);
    }

    public void registrarEmpleado(String nombre, LocalDate fechaIngreso, String nombrePuesto, double salarioBase) {
        manager.getTransaction().begin();

        Puesto puesto = puestoDAO.buscarPorNombre(nombrePuesto)
                .orElseGet(() -> {
                    var nuevoPuesto = new Puesto(nombrePuesto, salarioBase);
                    puestoDAO.registrar(nuevoPuesto);
                    manager.flush();
                    return nuevoPuesto;
                });

        Empleados empleado = new Empleados(nombre, fechaIngreso, puesto);
        empleadoDAO.registrar(empleado);
        manager.getTransaction().commit();
        System.out.println("Empleado registrado correctamente.");
    }

    public void listarEmpleadosPorFecha(LocalDate fechaIngreso) {
        var empleados = empleadoDAO.listarPorFechaIngreso(fechaIngreso);
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados que hayan ingresado en la fecha: " + fechaIngreso);
        } else {
            empleados.forEach(empleado -> {
                System.out.println("Empleado: " + empleado.getNombre());
                System.out.println("Fecha de Ingreso: " + empleado.getFechaIngreso());
                System.out.println("Puesto: " + empleado.getPuesto().getNombrePuesto());
                System.out.println("Salario Base: " + empleado.getPuesto().getSalarioBase());
            });
        }
    }
}
