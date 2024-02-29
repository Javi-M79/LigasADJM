package controller;

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAOEquipo {

    private final SessionFactory sessionFactory;

    public DAOEquipo() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //METODO DE INSERCION DE UN EQUIPO SIN LIGA.

    public void insertarEquipo(Equipo equipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Comprobamos si el equipo existe.
        Query query = session.createQuery("FROM Equipo WHERE nombre = :nombre", Equipo.class);
        query.setParameter("nombre", equipo.getNombre());
        List<Equipo> equiposCreados = query.getResultList();
        //Si no existe lo creo.
        if (equiposCreados.isEmpty()) {
            session.persist(equipo);
            session.getTransaction().commit();
            System.out.println("Equipo creado con exito.");
        } else {
            System.out.println("El equipo ya existe en la base de datos.");
        }
        session.close();
    }

    //OBTENER EQUiPOS DE LA BASE DE DATOS.
    public void listaEquipos() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("Select e from Equipo e", Equipo.class);
        List<Equipo> equipos = query.getResultList();

        for (Equipo e : equipos) {
            System.out.println("- ID Equipo: " + e.getId());
            System.out.println("    - Nombre: " + e.getNombre());
            System.out.println("    - Ciudad: " + e.getCiudad());
            System.out.println("    - Liga: " + e.getLiga().getNombre());
        }
        session.getTransaction().commit();
        session.close();

    }

    //BUSQUEDA UN SOLO EQUIPO POR NOMBRE.
    public void getEquipo(String nombre) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("Select e from Equipo e WHERE nombre= :nombre", Equipo.class)
                .setParameter("nombre", nombre);

        Equipo equipo = (Equipo) query.getSingleResult();

        if (equipo != null) {
            System.out.println("- ID Equipo: " + equipo.getId());
            System.out.println("    - Nombre: " + equipo.getNombre());
            System.out.println("    - Ciudad: " + equipo.getCiudad());
            System.out.println("    - Liga: " + equipo.getLiga().getNombre());

        }

        List<Equipo> equipos = query.getResultList();

        for (Equipo e : equipos
        ) {
            System.out.println("- ID Equipo: " + e.getId());
            System.out.println("    - Nombre: " + e.getNombre());
            System.out.println("    - Ciudad: " + e.getCiudad());
            System.out.println("    - Liga: " + e.getLiga().getNombre());
        }

        session.getTransaction().commit();
        session.close();


    }//BUSQUEDA UN SOLO EQUIPO POR ID.

    public void getEquipoId(int id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("Select e from Equipo e WHERE id= :id", Equipo.class)
                .setParameter("id", id);
        List<Equipo> equiposId = query.getResultList();
        for (Equipo e : equiposId
        ) {

            System.out.println("- Nombre: " + e.getNombre());
            System.out.println("- Ciudad: " + e.getCiudad());
            System.out.println("- Liga: " + e.getLiga().getNombre());
        }

        session.getTransaction().commit();
        session.close();


    }


    //AÑADIR EQUIPOS A LIGA
    public void equipoALiga(Equipo equipo, Liga liga) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//Comprobamos si la liga existe
        Query queryLiga = session.createQuery("FROM Liga WHERE nombre = :nombre");
        queryLiga.setParameter("nombre", liga.getNombre());
        List<Liga> ligasCreadas = queryLiga.getResultList();

        if (ligasCreadas.isEmpty()) {
            session.persist(liga);
            System.out.println("Liga " + liga.getNombre() + " creada con exito.");
        }
        //Comprobamos que el equipo exista

        Query query = session.createQuery("FROM Equipo WHERE nombre = :nombre", Equipo.class);
        query.setParameter("nombre", equipo.getNombre());
        List<Equipo> equiposCreados = query.getResultList();
        //Si no existe lo creo y le añado la liga
        if (equiposCreados.isEmpty()) {
            equipo.setLiga(liga);
            session.persist(equipo);

            System.out.println("Equipo creado con exito y asignado a la liga: " + liga.getNombre());
        } else {
            if (equipo.getLiga() == null) {
                equipo.setLiga(liga);
                session.persist(equipo.getLiga());
                System.out.println("El equipo se ha actualizado y se ha asigando a la liga.");
            }
        }
        session.getTransaction().commit();
        session.close();
    }


    public void borrarEquipo(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Equipo e WHERE e.id = :id")
                .setParameter("id", id);

        //Executeupdate(); Nos devuelve un numero que hace referencia al numero de filas que ha borrado.
        int equipoBorrado = query.executeUpdate();
        if (equipoBorrado == 0) {
            System.out.println("El equipo con ID: " + id + " no existe.");
        }else{
            System.out.println("Equipo con ID: " + id + " ha sido borrado con exito.");

        }

        session.getTransaction().commit();
        session.close();


    }
}








