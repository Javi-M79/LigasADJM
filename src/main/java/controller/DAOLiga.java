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
        Session session = sessionFactory.openSession();
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


}
