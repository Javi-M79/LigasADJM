package controller;

import database.HibernateUtil;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOEquipo {

    private SessionFactory sessionFactory;

    public DAOEquipo() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //METODO DE INSERCION DE UN EQUIPO

    public void insertarEquipo(Equipo equipo) {

        //Creamos una sesion
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();


    }

    //AÑADIR EQUIPOS A LIGA
    public void equipoALiga(Equipo equipo, Liga liga) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        equipo.setIdLiga(liga);
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();


    }

}
