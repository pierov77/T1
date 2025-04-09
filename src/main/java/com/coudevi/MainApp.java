package com.coudevi;
import com.coudevi.service.TalentoProService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
public class MainApp {
        public static void main(String[] args) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TalentoPro");

            EntityManager manager = emf.createEntityManager();

            TalentoProService empleadoService = new TalentoProService(manager);

            // empleadoService.registrarEmpleado("Alexander", LocalDate.of(2025, 4, 10), "Docente", 7000);

            empleadoService.listarEmpleadosPorFecha(LocalDate.of(2025, 4, 10));

        }


}

