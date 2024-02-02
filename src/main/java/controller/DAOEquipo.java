package controller;

import database.HibernateUtil;
import model.Equipo;
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
        Session session = sessionFactory.getCurrentSession();
        //Persisitimos

        session.beginTransaction();
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();


    }

}
