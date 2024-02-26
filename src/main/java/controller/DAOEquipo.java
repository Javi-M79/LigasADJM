package controller;

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAOEquipo {

    private SessionFactory sessionFactory;

    public DAOEquipo() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //METODO DE INSERCION DE UN EQUIPO

    public void insertarEquipo(Equipo equipo) {

        //Creamos una sesion
        Session session = sessionFactory.openSession();

        //Comprobamos que el equipo no este creado.

        //Si no esta creado lo creo.
        session.beginTransaction();
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();


    }


    public void eliminarEquipo(Equipo equipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(equipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    //AÑADIR EQUIPOS A LIGA
    public void equipoALiga(Equipo equipo, Liga liga) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (equipo.getLiga() != null) {
            System.out.println("El equipo ya pertenece una liga.");
            session.getTransaction().rollback();
            session.close();
        }
        equipo.setLiga(liga);
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();
    }

    public boolean comprobarEquipo (Equipo equipo){
        boolean encontrado = true;

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select e from equipos e ");
        List <Equipo> equipos = query.getResultList();


        return encontrado;
    }

}
