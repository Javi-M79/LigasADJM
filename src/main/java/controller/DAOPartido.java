package controller;


//ESTAS CLASES GESTIONAN LAS OPERACIONES QUE PODEMOS HACER CON CADA UNA DE LAS CLASES PRINCIPALES

import database.HibernateUtil;
import model.Partido;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOPartido {

    //Cada una tendra un objeto de SessionFactory para poder acceder a la DB.
    private SessionFactory sessionFactory;


    //La iniciamos dentro del constructor.
    public DAOPartido() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //En insertar partido necesitamos que haya dos equipos (y una liga?)
    public void insertarPartido(Partido partido) {

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.persist(partido);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Problema insertando el partido");
            throw new RuntimeException(e);

        }


    }


}
