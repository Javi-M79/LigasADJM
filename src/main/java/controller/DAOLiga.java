package controller;

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DAOLiga {

    private SessionFactory sessionFactory;


    public DAOLiga() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    //CREAR UNA LIGA
    public void insertarLiga(Liga liga) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Liga WHERE nombre = :nombre");
        query.setParameter("nombre", liga.getNombre());
        List<Liga> ligasCreadas = query.getResultList();

        if (ligasCreadas.isEmpty()) {
            session.persist(liga);
            session.getTransaction().commit();
            System.out.println("Liga creada con exito.");
        } else {
            System.out.println("La liga ya existe.");
        }

        session.close();
    }


    //OBTENER LISTA DE TODAS LAS LIGAS.
    public void listaLigas() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("Select l from Liga l", Liga.class);
        List<Liga> listaLigas = query.getResultList();

        for (Liga l : listaLigas) {
            System.out.println("- ID: " + l.getId());
            System.out.println("    - Nombre: " + l.getNombre());
            System.out.println("    - Fecha inicio: " + l.getFechaInicio());
            System.out.println("    - Fecha fin: " + l.getFechaFin());
        }
        session.getTransaction().commit();
        session.close();

    }

    // OBTENER LIGA POR NOMBRE
    public void getLiga(String nombre) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("Select l from Liga l WHERE nombre= :nombre", Liga.class)
                .setParameter("nombre", nombre);

        Liga l = (Liga) query.getSingleResult();
        if (l != null) {
            System.out.println("- ID: " + l.getId());
            System.out.println("    - Nombre: " + l.getNombre());
            System.out.println("    - Fecha inicio: " + l.getFechaInicio());
            System.out.println("    - Fecha fin: " + l.getFechaFin());
        } else {
            System.out.println("La liga no existe");
        }

        session.getTransaction().commit();
        session.close();

    }

    public void getLigaID(int id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("Select l from Liga l WHERE id= :id", Liga.class)
                .setParameter("id", id);

        Liga l = (Liga) query.getSingleResult();
        if (l != null) {
            System.out.println("    - Nombre: " + l.getNombre());
            System.out.println("    - Fecha inicio: " + l.getFechaInicio());
            System.out.println("    - Fecha fin: " + l.getFechaFin());
        } else {
            System.out.println("La liga no existe");
        }

        session.getTransaction().commit();
        session.close();

    }


    public void listarEquiposPorLiga(int idLiga) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Query query = session.createQuery("SELECT e FROM Equipo e WHERE e.liga.id = :idLiga", Equipo.class);
        query.setParameter("idLiga", idLiga);
        List<Equipo> equipos = query.getResultList();

        if (!equipos.isEmpty()) {
            System.out.println("Equipos de la liga con ID " + idLiga + ":");

            for (Equipo equipo : equipos) {
                System.out.println("- ID: " + equipo.getId());
                System.out.println("  - Nombre: " + equipo.getNombre());
                System.out.println("  - Ciudad: " + equipo.getCiudad());
            }
        } else {
            System.out.println("No se encontraron equipos para la liga con ID: " + idLiga + ". Es posible que la liga no exista.");
        }

        session.getTransaction().commit();
        session.close();

    }

    public void listarEquiposNombre(String nombre) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("Select e from Equipo e WHERE e.liga.nombre= :nombre", Equipo.class)
                .setParameter("nombre", nombre);
        List<Equipo> equipos = query.getResultList();

        if (!equipos.isEmpty()) {
            System.out.println("Equipos de la liga " + nombre + ":");

            for (Equipo equipo : equipos) {
                System.out.println("- ID: " + equipo.getId());
                System.out.println("  - Nombre: " + equipo.getNombre());
                System.out.println("  - Ciudad: " + equipo.getCiudad());
            }
        } else {
            System.out.println("No se encontraron equipos para la liga " + nombre + ". Es posible que la liga no exista.");
        }

        session.getTransaction().commit();
        session.close();

    }

    public void borrarLiga(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from Liga l WHERE l.id = :id")
                .setParameter("id", id);

        //Nos devuelve un numero que hace referencia al numero de filas que ha borrado.
        int ligaBorrada = query.executeUpdate();
        if (ligaBorrada == 0) {
            System.out.println("La liga con ID: " + id + " no existe.");
        }else{
            System.out.println("La liga con ID: " + id + " ha sido borrada con exito.");

        }

        session.getTransaction().commit();
        session.close();


    }
}


