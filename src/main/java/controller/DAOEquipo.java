package controller;

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import controller.DAOLiga;

import java.util.List;

public class DAOEquipo extends DAOLiga {

    private final SessionFactory sessionFactory;

    public DAOEquipo() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //METODO DE INSERCION DE UN EQUIPO

    public void insertarEquipo(Equipo equipo) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        //Comprobamos si el equipo existe.

        Query query = session.createQuery("FROM Equipo WHERE nombre = :nombre");
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

    //OBTENER EQUIPO

    public void getEquipos() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select e from Equipo e");
        List<Equipo> equipo = (List<Equipo>) ((org.hibernate.query.Query<?>) query).list();

        for (Equipo e : equipo
        ) {
            System.out.println(e.getId());
            System.out.println(e.getNombre());
            System.out.println(e.getCiudad());
            System.out.println(e.getLiga());
        }

        session.getTransaction().commit();
        session.close();


    }


    //AÑADIR EQUIPOS A LIGA
    public void equipoALiga(Equipo equipo, Liga liga) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Comprobamos que el equipo exista si no exiate lo crea.


        insertarEquipo(equipo);
        insertarLiga(liga);


        if (equipo.getLiga() != null) {
            System.out.println("El equipo ya pertenece una liga.");
            session.getTransaction().rollback();
            session.close();
        } else {
            equipo.setLiga(liga);
            session.persist(equipo);
            session.getTransaction().commit();
            session.close();
        }
    }

    //COMPROBAR SI EL EQUIPO EXISTE
    public void comprobarEquipo(Equipo equipo) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM e equipos e ");
        List<Equipo> equipos = query.getResultList(); //No me funciona el metodo List.

        if (equipos.isEmpty()) {

            session.persist(equipo);
            session.getTransaction().commit();
            session.close();
            System.out.println("Equipo creado con exito.");
        } else {
            System.out.println("El equipo ya existe en la Base de Datos.");

        }


    }

}
