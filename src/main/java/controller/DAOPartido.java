package controller;


//ESTAS CLASES GESTIONAL LAS OPERACIONES QUE PODEMOS HACER CON CADA UNA DE LAS CLASES PRINCIPALES

import database.HibernateUtil;
import model.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOPartido {

    //Cada una tendra un objeto de SessionFactory para poder acceder a la DB.
    private SessionFactory sessionFactory;


    //La iniciamos dentrod el constructor.
    public DAOPartido() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //En insertar partido necesitamos que haya dos equipos (y una liga?)
    public void insertarPartido(Partido partido) {


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(partido);
        session.getTransaction().commit();
        session.close();


    }


}
